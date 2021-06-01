package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.databases.appDatabase
import com.fedegiorno.primerparcial.databases.docenteDao
import com.fedegiorno.primerparcial.entities.Docente
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class RegisterFragment : Fragment() {

    private lateinit var v: View

    private var db: appDatabase? = null
    private var docenteDao: docenteDao? = null

    private lateinit var btnRegistro: Button
    private lateinit var btnEliminar: Button

    private lateinit var tieApellido: TextInputEditText
    private lateinit var tieNombres: TextInputEditText
    private lateinit var tieUsuario: TextInputEditText
    private lateinit var tieNumeroDNI: TextInputEditText
    private lateinit var tieEmail: TextInputEditText
    private lateinit var tieClave: TextInputEditText

    lateinit var docenteActual: Docente

    lateinit var mensajeAcceso: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_register, container, false)

        tieApellido = v.findViewById(R.id.tieApellido)
        tieNombres = v.findViewById(R.id.tieNombres)
        tieUsuario = v.findViewById(R.id.tieUsuario)
        tieNumeroDNI = v.findViewById(R.id.tieNumeroDNI)
        tieClave = v.findViewById(R.id.tieClave)
        tieEmail = v.findViewById(R.id.tieEmail)

        btnRegistro = v.findViewById(R.id.btnRegistro)
        btnEliminar = v.findViewById(R.id.btnAceptarEliminar)

        return v
    }

    override fun onStart() {
        super.onStart()

        //Instancio el objeto DB
        db = appDatabase.getAppDataBase(v.context)

        //Instancio la interface a la DB
        docenteDao = db?.docenteDao()

        var nombreUsuario: String = RegisterFragmentArgs.fromBundle(requireArguments()).usuario
        var clave: String = RegisterFragmentArgs.fromBundle(requireArguments()).clave
        var boton: Int = RegisterFragmentArgs.fromBundle(requireArguments()).boton

        Toast.makeText(
            requireContext(),
            "onStart()",
            Toast.LENGTH_SHORT
        ).show()
        
        when (boton){
            0 -> {//En caso de haber tecleado Nuevo Docente
                btnRegistro.text = getString(R.string.Agregar)
                mensajeAcceso = "Ingresa nuevo docente a la base de datos"
                tieApellido.setText("")
                tieNombres.setText("")
                tieUsuario.setText(nombreUsuario)
                tieNumeroDNI.setText("")
                tieEmail.setText("")
                tieClave.setText(clave)
            }
            1 -> {//En caso de haber elegido Modificar o Eliminar
                btnRegistro.text = getString(R.string.Actualizar)
                mensajeAcceso = "Docente actualizado en la base de datos"
                tieApellido.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.apellido.toString())
                tieNombres.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.nombres.toString())
                tieUsuario.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.usuario.toString())
                tieNumeroDNI.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.dni.toString())
                tieEmail.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.email.toString())
                tieClave.setText(docenteDao?.loadDocenteByUsuario(nombreUsuario)?.password.toString())

                Toast.makeText(
                    requireContext(),
                    tieApellido.text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnRegistro.setOnClickListener {    //ALTA y UPDATE DOCENTE
            Toast.makeText(
                requireContext(),
                mensajeAcceso,
                Toast.LENGTH_SHORT
            ).show()

            if (!(tieNumeroDNI.text.isNullOrEmpty() or
                tieApellido.text.isNullOrEmpty() or
                tieNombres.text.isNullOrEmpty() or
                tieUsuario.text.isNullOrEmpty() or
                tieEmail.text.isNullOrEmpty() or
                tieClave.text.isNullOrEmpty())
            ) {
                docenteActual = Docente(
                    tieNumeroDNI.text.toString(),
                    tieApellido.text.toString(),
                    tieNombres.text.toString(),
                    tieUsuario.text.toString(),
                    tieEmail.text.toString(),
                    tieClave.text.toString()
                )

                when (boton) {
                    0 -> { // Nuevo Docente
                        docenteDao?.insertDocente(docenteActual)
                    }
                    1 -> { // Modificar Docente
                        docenteDao?.updateDocente(docenteActual)
                    }
                }
            }else {
                Snackbar.make(v, "Complete todos los campos", Snackbar.LENGTH_LONG).show()
            }
        }// btnRegistro.setOnClickListener

        btnEliminar.setOnClickListener{ // BAJA DOCENTE
            docenteDao?.deleteDocente(
                Docente(
                    tieNumeroDNI.text.toString(),
                    tieApellido.text.toString(),
                    tieNombres.text.toString(),
                    tieUsuario.text.toString(),
                    tieEmail.text.toString(),
                    tieClave.text.toString()
                )
            )
        } // btnEliminar.setOnClickListener
    }

}
