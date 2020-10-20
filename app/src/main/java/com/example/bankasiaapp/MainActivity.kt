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
import kotlinx.android.synthetic.main.activity_main.*

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
            startActivity(Intent(this, DashboardActivity::class.java))

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
}


