/*
Desarrollo de Aplicaciones para Dispositivos Moviles
PRIMER PARCIAL
Temas: BottomNavigationBars, NavigationDrawer, Tabs, Preferences y Splash

DetailFragment3.kt
Ubicacion: com.fedegiorno.parcial1.fragments

Este es el fragmento contendra el tercer grupo de detalles de la lista
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
class DetailFragment3 : Fragment() {

    private lateinit var v : View
    lateinit var txtNombre: TextView
    lateinit var txtRequisitos: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail3, container, false)
        txtNombre = v.findViewById(R.id.txtNombre)
        txtRequisitos = v.findViewById(R.id.txtRequisitos)
        return v
    }

    override fun onStart() {
        super.onStart()

//        txtNombre.setText(name)
//        txtRequisitos.setText(requisitos)

    }
}