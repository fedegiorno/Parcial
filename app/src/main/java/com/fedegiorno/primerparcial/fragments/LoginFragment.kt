
package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.databases.appDatabase
import com.fedegiorno.primerparcial.databases.docenteDao
import com.fedegiorno.primerparcial.entities.Curso
import com.fedegiorno.primerparcial.entities.Docente
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {

    private lateinit var v: View
    private lateinit var btnAcceder: Button
    private lateinit var btnNuevoDocente: Button
    private lateinit var btnModificar: Button
    private lateinit var tieUsuario: TextInputEditText
    private lateinit var tieClave: TextInputEditText
    private lateinit var usuarioActual: String
    private lateinit var claveActual: String

    private var db: appDatabase? = null
    private var docenteDao: docenteDao? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        v = inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment

        btnAcceder = v.findViewById(R.id.btnAcceder)
        btnNuevoDocente = v.findViewById(R.id.btnNuevoDocente)
        btnModificar = v.findViewById(R.id.btnAceptarModificar)
        tieUsuario = v.findViewById(R.id.tieUsuario)
        tieClave = v.findViewById(R.id.tieClave)

        //Instancio el objeto DB
        db = appDatabase.getAppDataBase(v.context)

        //Instancio la interface a la DB
        docenteDao = db?.docenteDao()

        Log.i("TAGDBDOCENTES",docenteDao?.cuenta().toString() )

        if (docenteDao?.cuenta() == 0) { //Valores iniciales de mi Base de Datos
            docenteDao?.insertDocente(Docente(dni = "16009450", apellido ="GIORNO", nombres = "FEDERICO", usuario = "fedegiorno", email = "fedegiorno@gmail.com", password ="12345"))
            docenteDao?.insertDocente(Docente(dni = "17566766", apellido ="BATTISTA", nombres = "GRACIELA FERNANDA", usuario = "grabattista", email = "grabattista@gmail.com", password ="12345"))
            docenteDao?.insertDocente(Docente(dni = "15888777", apellido ="ROITBERG", nombres = "HUMBERTO FRANCISCO", usuario = "hfroitberg", email = "hfroitberg@gmail.com", password ="12345"))
            docenteDao?.insertDocente(Docente(dni = "24555666", apellido ="NEGREIRA", nombres = "ALEJANDRA MARINA", usuario = "amnegreira", email = "amnegreira@gmail.com", password ="12345"))
            docenteDao?.insertDocente(Docente(dni = "28777444", apellido ="ZELAYA", nombres = "CLAUDIA BEATRIZ", usuario = "clabzelaya", email = "clabzelaya@gmail.com", password ="12345"))
        }

        return v
    }

    override fun onStart() {
        super.onStart()

        //Instancio el objeto DB
        db = appDatabase.getAppDataBase(v.context)

        //Instancio la interface a la DB
        docenteDao = db?.docenteDao()

        btnAcceder.setOnClickListener{
            if (!(tieUsuario.text.isNullOrEmpty() or tieClave.text.isNullOrEmpty())) {
                usuarioActual = tieUsuario.text.toString()
                claveActual = tieClave.text.toString()
                if (claveActual == docenteDao?.loadDocenteByUsuario(usuarioActual)?.password.toString()) {
                    val actionIngresar = LoginFragmentDirections.actionLoginFragmentToMainActivity2()
                    v.findNavController().navigate(actionIngresar)
                } else {
                    Snackbar.make(v, "Usuario o contraseña incorrecta", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        btnNuevoDocente.setOnClickListener{
            val actionRegister = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(
                tieUsuario.text.toString(),
                tieClave.text.toString(),
                0)
            v.findNavController().navigate(actionRegister)
        }

        btnModificar.setOnClickListener{
            val actionModificar = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(
                tieUsuario.text.toString(),
                tieClave.text.toString(),
                1)
            v.findNavController().navigate(actionModificar)
        }


    }
}
