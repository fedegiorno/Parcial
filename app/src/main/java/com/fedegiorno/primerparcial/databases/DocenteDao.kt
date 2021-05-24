package com.fedegiorno.primerparcial.databases

import androidx.room.*
import com.fedegiorno.primerparcial.entities.Docente

/* Listado de funciones a usar con la Base de Datos, es el nexo entre Android y SQL
* Debemos usar un interface por cada tabla */
@Dao
public interface docenteDao {

    // Devuelve todos los docentes ordenados por dni
    @Query("SELECT * FROM Docente ORDER BY dni")
    fun loadAllDocentes(): MutableList<Docente?>?

    // inserta un docente a la DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocente(Docente: Docente?)

    // Actualiza el Docente en la DB
    @Update
    fun updateDocente(Docente: Docente?)

    // Elimina el Docente de la DB
    @Delete
    fun deleteDocente(Docente: Docente?)

    // Devuelve el Docente según su dni
    @Query("SELECT * FROM Docente WHERE dni = :dni")
    fun loadDocenteById(dni: String): Docente?

    // Devuelve el Docente según su nombre de usuario
    @Query("SELECT * FROM Docente WHERE usuario = :usuario")
    fun loadDocenteByUsuario(usuario: String): Docente?
}