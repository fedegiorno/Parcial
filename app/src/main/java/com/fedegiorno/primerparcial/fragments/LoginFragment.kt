package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.fedegiorno.primerparcial.R

class LoginFragment : Fragment() {

    private lateinit var v: View
    private lateinit var btnAcceder: Button
    private lateinit var btnNuevoDocente: Button
    private lateinit var etxNombreUsuario: EditText
    private lateinit var etxClave: EditText

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
        etxNombreUsuario = v.findViewById(R.id.etxNombreUsuario)
        etxClave = v.findViewById(R.id.etxClave)

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
                etxNombreUsuario.text.toString(),
                etxClave.text.toString())
            v.findNavController().navigate(actionRegister)
        }

    }
}
