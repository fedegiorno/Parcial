package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.fedegiorno.primerparcial.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private lateinit var v: View
    private lateinit var btnAcceder: Button
    private lateinit var btnNuevoDocente: Button
    private lateinit var btnModificar: Button
    private lateinit var tieUsuario: TextInputEditText
    private lateinit var tieClave: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        v=inflater.inflate(R.layout.fragment_login, container, false)
        // Inflate the layout for this fragment
        btnAcceder = v.findViewById(R.id.btnAcceder)
        btnNuevoDocente = v.findViewById(R.id.btnNuevoDocente)
        btnModificar = v.findViewById(R.id.btnModificar)
        tieUsuario = v.findViewById(R.id.tieUsuario)
        tieClave = v.findViewById(R.id.tieClave)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnAcceder.setOnClickListener{
            val actionIngresar = LoginFragmentDirections.actionLoginFragmentToMainActivity2()
            v.findNavController().navigate(actionIngresar)
        }

        btnNuevoDocente.setOnClickListener{
//            Toast.makeText(v.context, "Usuario: ${etxNombreUsuario.text.toString()}", Toast.LENGTH_SHORT).show()
//            Toast.makeText(v.context, "Clave: ${etxClave.text.toString()}", Toast.LENGTH_SHORT).show()
//            Toast.makeText(v.context, "Usuario: ", Toast.LENGTH_SHORT).show()
//            Toast.makeText(v.context, "Clave: ", Toast.LENGTH_SHORT).show()
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
