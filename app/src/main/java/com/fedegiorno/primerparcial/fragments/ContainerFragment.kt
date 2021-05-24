/*
Desarrollo de Aplicaciones para Dispositivos Moviles
PRIMER PARCIAL
Temas: BottomNavigationBars, NavigationDrawer, Tabs, Preferences y Splash

ContainerFragment.kt
Ubicacion: com.fedegiorno.parcial1.fragments

Este es el fragmento que trabajara como contenedor de los fragmentos dedicados a mostrar los
detalles de la lista que estaran en tres pestañas
 */

package com.fedegiorno.primerparcial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.viewpager2.widget.ViewPager2
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

var _nombre: String = ""        //identificador
var _descripcion: String = ""
var _capacitador: String = ""
var _puntaje: String = ""
var _inicio: String = ""
var _fin: String = ""
var _horario: String = ""
var _requisitos: String = ""

class ContainerFragment : Fragment() {

    private lateinit var v: View
    private lateinit var vpgContainer: ViewPager2
    private lateinit var tabContainer: TabLayout

    lateinit var name: String
    lateinit var descripcion: String
    lateinit var capacitador: String
    lateinit var puntaje: String
    lateinit var inicio: String
    lateinit var fin: String
    lateinit var horario: String
    lateinit var requisitos: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_container, container, false)

        tabContainer = v.findViewById(R.id.tabContainer)

        vpgContainer = v.findViewById(R.id.vpgContainer)

        name = ContainerFragmentArgs.fromBundle(requireArguments()).name        //id_cd var id_cd = Contenedor_detallesArgs.fromBundle(requireArguments()).id
        descripcion = ContainerFragmentArgs.fromBundle(requireArguments()).descripcion
        capacitador = ContainerFragmentArgs.fromBundle(requireArguments()).capacitador
        puntaje = ContainerFragmentArgs.fromBundle(requireArguments()).puntaje
        inicio = ContainerFragmentArgs.fromBundle(requireArguments()).inicio
        fin = ContainerFragmentArgs.fromBundle(requireArguments()).fin
        horario = ContainerFragmentArgs.fromBundle(requireArguments()).horario
        requisitos = ContainerFragmentArgs.fromBundle(requireArguments()).requisitos

        _nombre = name      //identificador = id_cd
        _descripcion = descripcion
        _capacitador = capacitador
        _puntaje = puntaje
        _inicio = inicio
        _fin = fin
        _horario = horario
        _requisitos = requisitos

        return v
    }

    override fun onStart() {
        super.onStart()

        vpgContainer.adapter = ViewPagerAdapter(requireActivity())

        TabLayoutMediator(tabContainer, vpgContainer, TabLayoutMediator.TabConfigurationStrategy
        { tab, position ->
            when (position) {
                0 -> tab.text = "Presentacion"
                1 -> tab.text = "Temario"
                2 -> tab.text = "Requisitos"
                else -> tab.text = "undefined"
            }
        }).attach()

        //Toast.makeText(v.context, "Container: $_capacitador", Toast.LENGTH_LONG).show()
        //Snackbar.make(v,"Nombre de curso: $name", Snackbar.LENGTH_SHORT).show()

    }
}