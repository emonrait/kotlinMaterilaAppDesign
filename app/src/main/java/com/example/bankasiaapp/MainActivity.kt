package com.example.bankasiaapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.bankasiaapp.model.ApiResponse
import com.example.bankasiaapp.model.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.drawerlayout
import kotlinx.android.synthetic.main.activity_main.input_password
import kotlinx.android.synthetic.main.activity_main.navView
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navControler: NavController
    val drawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(drawerToggle)

        //drawerToggle.syncState()
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("")


        btn_login.setOnClickListener {
            loginUser()
            startActivity(Intent(this, DashboardActivity::class.java))

        }
        link_register.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> Toast.makeText(this, "Home Menu", Toast.LENGTH_SHORT).show()
                R.id.login -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Login Page", Toast.LENGTH_SHORT).show()
                }
                R.id.registration -> Toast.makeText(this, "registration Menu", Toast.LENGTH_SHORT)
                    .show()
                R.id.notifications -> Toast.makeText(this, "notifications Menu", Toast.LENGTH_SHORT)
                    .show()
                R.id.aboutus -> Toast.makeText(this, "aboutus Menu", Toast.LENGTH_SHORT).show()
                R.id.atmLocations -> Toast.makeText(this, "atmLocations Menu", Toast.LENGTH_SHORT)
                    .show()
                R.id.terms -> Toast.makeText(this, "terms Menu", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(this, "logout Menu", Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    /*override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle.syncState()
    }*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.right_side_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item!!.itemId == R.id.menuBtn) {
            if (drawerlayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerlayout.closeDrawer(Gravity.RIGHT)
            } else {
                drawerlayout.openDrawer(Gravity.RIGHT)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun loginUser() {
        var apiinstance = ApiService()
        var userId = input_username.text.toString().trim()
        var password = input_password.text.toString().trim()

        var call: Call<ApiResponse> = apiinstance.login(userId, password)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                Toast.makeText(
                    applicationContext,
                    response.body()?.getoutMessage(),
                    Toast.LENGTH_LONG
                ).show()
            }

        })


    }
}


