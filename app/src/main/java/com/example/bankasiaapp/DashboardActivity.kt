package com.example.bankasiaapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navControler: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        navControler = Navigation.findNavController(this, R.id.nav_host_fragment)

        nav_view.setupWithNavController(navControler)

        NavigationUI.setupActionBarWithNavController(this, navControler)
        toggle = ActionBarDrawerToggle(this, container, R.string.open, R.string.close)
        container.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView1.setNavigationItemSelectedListener {
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

    override fun onSupportNavigateUp(): Boolean {
        val navigateControler = findNavController(R.id.nav_host_fragment)
        return navigateControler.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.right_side_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
