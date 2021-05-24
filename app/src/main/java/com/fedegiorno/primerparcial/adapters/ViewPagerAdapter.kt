package com.fedegiorno.primerparcial.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fedegiorno.primerparcial.fragments.*


class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

        val fragment_a = DetailFragment1()
        fragment_a.arguments = Bundle().apply {
            putString("name", _nombre)              //putInt("id_cd", identificador)
            putString("descripcion", _descripcion)  //putInt("id_cd", identificador)
            putString("capacitador", _capacitador)  //putInt("id_cd", identificador)
            putString("puntaje", _puntaje)          //putInt("id_cd", identificador)
            putString("inicio", _inicio)            //putInt("id_cd", identificador)
            putString("fin", _fin)                  //putInt("id_cd", identificador)
            putString("horario", _horario)          //putInt("id_cd", identificador)
            putString("requisitos", _requisitos)    //putInt("id_cd", identificador)
        }

        val fragment_b = DetailFragment2()
        fragment_b.arguments = Bundle().apply {
            putString("name", _nombre)              //putInt("id_cd", identificador)
            putString("descripcion", _descripcion)  //putInt("id_cd", identificador)
        }

        val fragment_c = DetailFragment3()
        fragment_c.arguments = Bundle().apply {
            putString("name", _nombre)              //putInt("id_cd", identificador)
            putString("requisitos", _requisitos)    //putInt("id_cd", identificador)
        }

        return when (position) {
            0 -> fragment_a
            1 -> fragment_b
            2 -> fragment_c

            else -> fragment_a
        }
    }

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    companion object {
        private const val TAB_COUNT = 3
    }
}