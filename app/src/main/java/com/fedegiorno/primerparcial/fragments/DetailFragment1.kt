/*
Desarrollo de Aplicaciones para Dispositivos Moviles
PRIMER PARCIAL
Temas: BottomNavigationBars, NavigationDrawer, Tabs, Preferences y Splash

DetailFragment1.kt
Ubicacion: com.fedegiorno.parcial1.fragments

Este es el fragmento contendra el primer grupo de detalles de la lista
 */

package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentContainer
import com.fedegiorno.primerparcial.R


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment1 : Fragment() {

    private lateinit var v : View
    lateinit var txtNombre: TextView
    lateinit var txtCapacitador: TextView
    lateinit var txtPuntaje: TextView
    lateinit var txtInicio: TextView
    lateinit var txtFin: TextView
    lateinit var txtHorario: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_detail1, container, false)
        txtNombre = v.findViewById(R.id.txtNombre)
        txtCapacitador = v.findViewById(R.id.txtCapacitador)
        txtPuntaje = v.findViewById(R.id.txtPuntaje)
        txtInicio = v.findViewById(R.id.txtInicio)
        txtFin = v.findViewById(R.id.txtFin)
        txtHorario = v.findViewById(R.id.txtHorario)
        return v
    }

}
