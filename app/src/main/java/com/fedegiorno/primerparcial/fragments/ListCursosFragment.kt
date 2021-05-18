package com.fedegiorno.primerparcial.fragments

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fedegiorno.primerparcial.R
import com.fedegiorno.primerparcial.adapters.CursoListAdapter
import com.fedegiorno.primerparcial.entities.Curso
import com.google.android.material.snackbar.Snackbar

class ListCursosFragment : Fragment() {

    private lateinit var v: View
    private lateinit var recMain2: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    private var cursos: MutableList<Curso> = ArrayList()
    private lateinit var cursosListAdapter: CursoListAdapter

    companion object{
        fun newInstance() = ListCursosFragment
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cursos.add(Curso(name = "Curso Uno",
            descripcion = "Etapa Uno - Nivel Inicial",
            profesor = "profesor Uno",
            puntaje = "2",
            inicio = "01/01/2021",
            fin = "31/03/2021",
            horario = "de 8 a 18 hs.",
            carga = "30 Hs.",
            nivel = "Inicial",
            requisitos = "Docente de Nivel Inicial"))
        cursos.add(Curso(name = "Curso Dos",
            descripcion = "Etapa Dos - Nivel Inicial",
            profesor = "profesor Dos",
            puntaje = "2",
            inicio = "01/01/2021",
            fin = "31/03/2021",
            horario = "de 8 a 18 hs.",
            carga = "40 Hs.",
            nivel = "Inicial",
            requisitos = "Docente de Nivel Inicial"))
        cursos.add(Curso(name = "Curso Tres",
            descripcion = "Etapa Tres - Nivel Primario",
            profesor = "profesor Tres",
            puntaje = "3",
            inicio = "01/04/2021",
            fin = "30/06/2021",
            horario = "de 14 a 18 hs.",
            carga = "45 Hs.",
            nivel = "Primario",
            requisitos = "Docente de Nivel Primario"))
        cursos.add(Curso(name = "Curso Cuatro",
            descripcion = "Etapa Cuatro - Nivel Primario",
            profesor = "profesor Cuatro",
            puntaje = "4",
            inicio = "01/01/2021",
            fin = "31/03/2021",
            horario = "de 8 a 18 hs.",
            carga = "30 Hs.",
            nivel = "Primario",
            requisitos = "Docente de Nivel Primario"))
        cursos.add(Curso(name = "Curso Cinco",
            descripcion = "Etapa Cinco - Nivel Secundario",
            profesor = "profesor Cinco",
            puntaje = "3",
            inicio = "01/04/2021",
            fin = "30/06/2021",
            horario = "de 8 a 18 hs.",
            carga = "48 Hs.",
            nivel = "Secundario",
            requisitos = "Docente de Nivel Secundario"))
        cursos.add(Curso(name = "Curso Seis",
            descripcion = "Etapa Seis - Nivel Secundario",
            profesor = "profesor Seis",
            puntaje = "5",
            inicio = "01/01/2021",
            fin = "31/03/2021",
            horario = "de 8 a 18 hs.",
            carga = "30 Hs.",
            nivel = "Secundario",
            requisitos = "Docente de Nivel Secundario"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
            // Inflate the layout for this fragment
            v = inflater.inflate(R.layout.fragment_list_cursos, container, false)
            recMain2 = v.findViewById(R.id.reclistcursos)
        return v
    }

    override fun onStart() {
        super.onStart()

        var color: String?
        val Prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())

        color = Prefs.getString("backListColor", "")

        Toast.makeText(requireContext(),color, Toast.LENGTH_SHORT).show()

        // Configuracion del recyclerview
        recMain2.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(context)
        recMain2.layoutManager = linearLayoutManager

        cursosListAdapter = CursoListAdapter(cursos, requireContext()) { pos ->
            onItemClick(pos)
        }

        recMain2.adapter = cursosListAdapter
        //Se pasa el adaptador al recycler, se muestra en pantalla la lista
    }

    private fun onItemClick(position: Int): Boolean {
        Toast.makeText(v.context, "Posicion: $position", Toast.LENGTH_LONG).show()
//        Snackbar.make(v,position.toString(), Snackbar.LENGTH_SHORT).show()

        Toast.makeText(v.context, "Nombre del curso: ${cursos[position].name}", Toast.LENGTH_LONG).show()

        var name: String = cursos[position].name.toString()
        var descripcion: String = cursos[position].descripcion.toString()
        var profesor: String = cursos[position].profesor.toString()
        var puntaje: String = cursos[position].puntaje.toString()
        var inicio: String = cursos[position].inicio.toString()
        var fin: String = cursos[position].fin.toString()
        var horario: String = cursos[position].horario.toString()
        var carga: String = cursos[position].carga.toString()
        var nivel: String = cursos[position].nivel.toString()
        var requisitos: String = cursos[position].requisitos.toString()

        val actionlist = ListCursosFragmentDirections.actionListCursosFragmentToContainerFragment(name, descripcion, profesor, puntaje, inicio, fin, horario, carga, nivel, requisitos)
        v.findNavController().navigate(actionlist)

        return true
    }

}