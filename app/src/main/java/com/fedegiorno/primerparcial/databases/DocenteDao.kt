package com.fedegiorno.primerparcial.databases

import androidx.room.*
import com.fedegiorno.primerparcial.entities.Docente

@Dao
interface docenteDao {

    @Query("SELECT * FROM Docente ORDER BY dni")
    fun loadAllDocentes(): MutableList<Docente?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocente(Docente: Docente?)

    @Update
    fun updateDocente(Docente: Docente?)

    @Delete
    fun delete(Docente: Docente?)

    @Query("SELECT * FROM Docente WHERE dni = :dni")
    fun loadDocenteById(dni: String): Docente?

}