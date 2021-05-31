package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.databases.cursoDao
import com.fedegiorno.primerparcial.databases.appDatabase

class DbCursosFragmentModificar : Fragment() {

    private lateinit var v: View
    private lateinit var btnCancelarModificar: Button
    private lateinit var btnAceptarModificar: Button

    private var db: appDatabase? = null
    private var cursoDao: cursoDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_db_cursos_modificar, container, false)

        btnCancelarModificar = v.findViewById(R.id.btnCancelarModificar)
        btnAceptarModificar = v.findViewById(R.id.btnAceptarModificar)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnAceptarModificar.setOnClickListener {

        }

        btnCancelarModificar.setOnClickListener {

        }
    }
}