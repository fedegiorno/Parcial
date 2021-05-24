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
    private lateinit var tieEmail: EditText
    private lateinit var tieClave: TextInputEditText

    private var Apellido: String = ""
    private var Nombres: String = ""
    private var Usuario: String = ""
    private var NumeroDNI: String = ""
    private var Email: String = ""
    private var Clave: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d("PRUEBA", "onCreateView [RegisterFragment]")
        v = inflater.inflate(R.layout.fragment_register, container, false)

        tieApellido = v.findViewById(R.id.tieApellido)
        tieNombres = v.findViewById(R.id.tieNombres)
        tieUsuario = v.findViewById(R.id.tieUsuario)
        tieNumeroDNI = v.findViewById(R.id.tieNumeroDNI)
        tieClave = v.findViewById(R.id.tieClave)
        tieEmail = v.findViewById(R.id.tieEmail)

        btnRegistro = v.findViewById(R.id.btnRegistro)
        btnEliminar = v.findViewById(R.id.btnEliminar)

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

        tieUsuario.setText(nombreUsuario)
        tieClave.setText(clave)
        Log.d("PRUEBA vista", tieUsuario.text.toString())
        Log.d("PRUEBA vista", tieClave.text.toString())

        if (boton == 1) {   //En caso de haber elegido Modificar
            btnRegistro.text = "Modificar"

            Log.d("PRUEBA DB", docenteDao?.loadDocenteByUsuario(nombreUsuario)?.usuario.toString())
            Log.d("PRUEBA DB", docenteDao?.loadDocenteById("16009450")?.apellido.toString())
        }

        Apellido = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.apellido.toString()
        Nombres = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.nombres.toString()
        Usuario = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.usuario.toString()
        NumeroDNI = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.dni.toString()
        Email = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.email.toString()
        Clave = docenteDao?.loadDocenteByUsuario(nombreUsuario)?.password.toString()

        tieApellido.setText(Apellido)
        tieNombres.setText(Nombres)
        //tieUsuario.setText(Usuario)
        tieNumeroDNI.setText(NumeroDNI)
        tieEmail.setText(Email)
        //tieClave.setText(Clave)

        btnRegistro.setOnClickListener {    //ALTA y UPDATE DOCENTE
            Toast.makeText(
                requireContext(),
                "Ingresar al nuevo docente a la base de datos",
                Toast.LENGTH_SHORT
            ).show()

            if (tieNumeroDNI.text.isNullOrEmpty() or
                tieApellido.text.isNullOrEmpty() or
                tieNombres.text.isNullOrEmpty() or
                tieUsuario.text.isNullOrEmpty() or
                tieEmail.text.isNullOrEmpty() or
                tieClave.text.isNullOrEmpty()
            ) {
                when (boton) {
                    0 -> { // Nuevo Docente
                        docenteDao?.insertDocente(
                            Docente(
                                tieNumeroDNI.text.toString(),
                                tieApellido.text.toString(),
                                tieNombres.text.toString(),
                                tieUsuario.text.toString(),
                                tieEmail.text.toString(),
                                tieClave.text.toString()
                            )
                        )
                    }
                    1 -> { // Modificar Docente
                        docenteDao?.updateDocente(
                            Docente(
                                tieNumeroDNI.text.toString(),
                                tieApellido.text.toString(),
                                tieNombres.text.toString(),
                                tieUsuario.text.toString(),
                                tieEmail.text.toString(),
                                tieClave.text.toString()
                            )
                        )
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
