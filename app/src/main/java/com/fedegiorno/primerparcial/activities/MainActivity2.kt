package com.fedegiorno.primerparcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.fragments.ListCursosFragmentDirections

class MainActivity2 : AppCompatActivity() {

    lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.Item1 -> {
//                Toast.makeText(this,"Informacion CIIEs", Toast.LENGTH_SHORT).show()
                val InfoCiieActivity = Intent(this, InfoCIIEActivity::class.java)
                startActivity(InfoCiieActivity)
//                val action2 = ListCursosFragmentDirections.actionListCursosFragmentToInfoCIIEActivity()
//                findNavController(R.id.activity_main2).navigate(action2)
                true
            }
            R.id.Item2 -> {
                Toast.makeText(this,"Preferencias", Toast.LENGTH_SHORT).show()
                val preferencias: Intent = Intent(this, SettingsActivity::class.java)
                startActivity(preferencias)
//                val actionPref = ListCursosFragmentDirections.actionListCursosFragmentToSettingsFragment()
//                v.findNavController().navigate(actionPref)
                true
            }
            R.id.Item3 -> {
                Toast.makeText(this,"Salir", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
        //super.onOptionsItemSelected(item)
    }
}