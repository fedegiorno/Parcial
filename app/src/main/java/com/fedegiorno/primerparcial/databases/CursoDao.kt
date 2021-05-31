package com.fedegiorno.primerparcial.databases

import androidx.room.*
import com.fedegiorno.primerparcial.entities.Curso

/* Listado de funciones a usar con la Base de Datos, es el nexo entre Android y SQL
* Debemos usar un interface por cada tabla */
@Dao
interface cursoDao {

    // Devuelve todos los cursos ordenados por name
    @Query("SELECT * FROM t_curso ORDER BY name")
    fun loadAllCursos(): MutableList<Curso?>?

    // inserta un curso a la DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)        //Si la primarykey existe en la DB, reemplaza el contenido
    fun insertCurso(Curso: Curso?)

    // Actualiza el Curso en la DB
    @Update
    fun updateCurso(Curso: Curso?)

    // Elimina el Curso de la DB
    @Delete
    fun deleteCurso(Docente: Curso?)

}