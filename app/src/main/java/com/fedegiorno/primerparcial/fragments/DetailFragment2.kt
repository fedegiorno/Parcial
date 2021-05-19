/*
Desarrollo de Aplicaciones para Dispositivos Moviles
PRIMER PARCIAL
Temas: BottomNavigationBars, NavigationDrawer, Tabs, Preferences y Splash

DetailFragment2.kt
Ubicacion: com.fedegiorno.parcial1.fragments

Este es el fragmento contendra el segundo grupo de detalles de la lista
 */

package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fedegiorno.primerparcial.R


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment2 : Fragment() {

    private lateinit var v : View
    lateinit var txtNombre2: TextView
    lateinit var txtDescripcion: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail2, container, false)
        txtNombre2 = v.findViewById(R.id.txtNombre2)
        txtDescripcion = v.findViewById(R.id.txtDescripcion)
        return v
    }

}