/*
Desarrollo de Aplicaciones para Dispositivos Moviles
PRIMER PARCIAL
Temas: BottomNavigationBars, NavigationDrawer, Tabs, Preferences y Splash

DbCursosFragmentAlta.kt
Ubicacion: com.fedegiorno.primerparcial.fragments

Este fragmento mostrara lo correspondiente a la primera division del Nav Bar
 */

@file:Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")

package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.databases.cursoDao
import com.fedegiorno.primerparcial.databases.appDatabase
import com.google.android.material.textfield.TextInputEditText

class DbCursosFragmentAlta : Fragment() {

    private lateinit var v: View
    
    private lateinit var btnCancelarAlta: Button
    private lateinit var btnAceptarAlta: Button

    lateinit var name: String
    lateinit var descripcion: String
    lateinit var capacitador: String
    lateinit var puntaje: String
    lateinit var inicio: String
    lateinit var fin: String
    lateinit var horario: String
    lateinit var carga: String
    lateinit var nivel: String
    lateinit var requisitos: String

    lateinit var tieName: TextInputEditText
    lateinit var tieDescripcion: TextInputEditText
    lateinit var tieCapacitador: TextInputEditText
    lateinit var tiePuntaje: TextInputEditText
    lateinit var tieInicio: TextInputEditText
    lateinit var tieFin: TextInputEditText
    lateinit var tieHorario: TextInputEditText
    lateinit var tieCarga: TextInputEditText
    lateinit var tieNivel: TextInputEditText
    lateinit var tieRequisitos: TextInputEditText

    private var db: appDatabase? = null
    private var cursoDao: cursoDao? = null

    //lateinit var cursoDao: cursoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_db_cursos_alta, container, false)

        btnCancelarAlta = v.findViewById(R.id.btnCancelarAlta)
        btnAceptarAlta = v.findViewById(R.id.btnAceptarAlta)
        
        tieName = v.findViewById(R.id.tieName)
        tieDescripcion = v.findViewById(R.id.tieDescripcion)
        tieCapacitador = v.findViewById(R.id.tieCapacitador)
        tiePuntaje = v.findViewById(R.id.tiePuntaje)
        tieInicio = v.findViewById(R.id.tieInicio)
        tieFin = v.findViewById(R.id.tieFin)
        tieHorario = v.findViewById(R.id.tieHorario)
        tieCarga = v.findViewById(R.id.tieCarga)
        tieNivel = v.findViewById(R.id.tieNivel)
        tieRequisitos = v.findViewById(R.id.tieRequisitos)

        return v
    }

    override fun onStart() {
        super.onStart()

        //Instancio el objeto DB
        db = appDatabase.getAppDataBase(v.context)

        //Instancio la interface a la DB
        cursoDao = db?.cursoDao()

        //var cursoactual: String = RegisterFragmentArgs.fromBundle(requireArguments()).id


        btnAceptarAlta.setOnClickListener {
            var name: String = tieName.text.toString()
            Log.d("************* ", name)

        }

        btnCancelarAlta.setOnClickListener {

        }
    }
}