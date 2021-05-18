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
import androidx.viewpager2.widget.ViewPager2
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ContainerFragment : Fragment() {

    private lateinit var v: View
    private lateinit var vpgContainer: ViewPager2
    private lateinit var tabContainer: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_container, container, false)

        tabContainer = v.findViewById(R.id.tabContainer)

        vpgContainer = v.findViewById(R.id.vpgContainer)


        var name: String = ContainerFragmentArgs.fromBundle(requireArguments()).name
        var descripcion: String = ContainerFragmentArgs.fromBundle(requireArguments()).descripcion
        var capacitador: String = ContainerFragmentArgs.fromBundle(requireArguments()).capacitador
        var puntaje: String = ContainerFragmentArgs.fromBundle(requireArguments()).puntaje
        var inicio: String = ContainerFragmentArgs.fromBundle(requireArguments()).inicio
        var fin: String = ContainerFragmentArgs.fromBundle(requireArguments()).fin
        var horario: String = ContainerFragmentArgs.fromBundle(requireArguments()).horario
        var requisitos: String = ContainerFragmentArgs.fromBundle(requireArguments()).requisitos

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
    }
}