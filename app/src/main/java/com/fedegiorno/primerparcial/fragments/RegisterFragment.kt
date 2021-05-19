package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import androidx.navigation.findNavController
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.databases.appDatabase
import com.fedegiorno.primerparcial.databases.docenteDao
import com.fedegiorno.primerparcial.entities.Docente
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast

class RegisterFragment : Fragment() {

    private lateinit var v: View

    private var db: appDatabase? = null
    private var docenteDao: docenteDao? = null

    private lateinit var btnRegistro: Button
    private lateinit var etxApellido: EditText
    private lateinit var etxNombres: EditText
    private lateinit var etxUsuario: EditText
    private lateinit var etxNumeroDNI: EditText
    private lateinit var etxEmail: EditText
    private lateinit var etxClave: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Log.d("PRUEBA", "onCreate [RegisterFragment]")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d("PRUEBA", "onCreateView [RegisterFragment]")
        v = inflater.inflate(R.layout.fragment_register, container, false)
        btnRegistro = v.findViewById(R.id.btnRegistro)

        etxApellido = v.findViewById(R.id.etxApellido)
        etxNombres = v.findViewById(R.id.etxNombres)
        etxUsuario = v.findViewById(R.id.etxUsuario)
        etxNumeroDNI = v.findViewById(R.id.etxNumeroDNI)
        etxClave = v.findViewById(R.id.etxClave)
        etxEmail = v.findViewById(R.id.etxEmail)

        return v
    }

    override fun onStart() {
        super.onStart()

        Log.d("PRUEBA", "onStart [RegisterFragment]")
        db = appDatabase.getAppDataBase(v.context)
        Log.d("PRUEBA", "onStart [RegisterFragment] Definicion db superada")
        docenteDao = db?.docenteDao()

        var nombreUsuario: String = RegisterFragmentArgs.fromBundle(requireArguments()).usuario
        var clave: String = RegisterFragmentArgs.fromBundle(requireArguments()).clave

        etxNombres.setText(nombreUsuario)
        etxClave.setText(clave)

//        Snackbar.make(v,"Nombre de usuario: $NombreUsuario", Snackbar.LENGTH_LONG ).show()
//        Toast.makeText(requireContext(),"Nombre de usuario: $NombreUsuario", Toast.LENGTH_LONG ).show()

        btnRegistro.setOnClickListener{
            Toast.makeText(requireContext(),"Ingresar al nuevo docente a la base de datos", Toast.LENGTH_SHORT).show()

            if (etxNumeroDNI.text.isNotEmpty() and
                etxApellido.text.isNotEmpty() and
                etxNombres.text.isNotEmpty() and
                etxUsuario.text.isNotEmpty() and
                etxEmail.text.isNotEmpty() and
                etxClave.text.isNotEmpty()) {

                docenteDao?.insertDocente(Docente(
                    etxNumeroDNI.text.toString(),
                    etxApellido.text.toString(),
                    etxNombres.text.toString(),
                    etxUsuario.text.toString(),
                    etxEmail.text.toString(),
                    etxClave.text.toString()))
            } else {
                Snackbar.make(v,"Complete todos los campos", Snackbar.LENGTH_LONG ).show()
            }
        }
    }


}
