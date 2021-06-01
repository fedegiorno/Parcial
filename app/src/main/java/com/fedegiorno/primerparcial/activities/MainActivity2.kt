package com.fedegiorno.primerparcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.fedegiorno.primerparcial.R
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.properties.Delegates


class MainActivity2 : AppCompatActivity() {

    lateinit var v: View

    /* BOTTOM NAVIGATION BAR */
    private lateinit var bottomNavViewMain2 : BottomNavigationView
    private lateinit var navHostFragment2 : NavHostFragment
    /* BOTTOM NAVIGATION BAR */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /* BOTTOM NAVIGATION BAR */
        navHostFragment2 = supportFragmentManager.findFragmentById(R.id.nav_host_main2) as NavHostFragment
        bottomNavViewMain2 = findViewById(R.id.bottom_bar_2)
        NavigationUI.setupWithNavController(bottomNavViewMain2, navHostFragment2.navController)
        /* BOTTOM NAVIGATION BAR */

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.Item1 -> {
                val InfoCiieActivity = Intent(this, InfoCIIEActivity::class.java)
                startActivity(InfoCiieActivity)
                true
            }
            R.id.Item2 -> {
                Toast.makeText(this,"Preferencias", Toast.LENGTH_SHORT).show()
                val preferencias: Intent = Intent(this, SettingsActivity::class.java)
                startActivity(preferencias)
                true
            }
            R.id.Item3 -> {
                Toast.makeText(this,"Salir", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }

    companion object

}