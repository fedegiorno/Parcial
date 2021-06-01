package com.fedegiorno.primerparcial.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "t_curso")
class Curso( id: Int,
             name: String?,
             descripcion: String?,
             profesor: String?,
             puntaje: String?,
             inicio: String?,
             fin: String?,
             horario: String?,
             carga: String?,
             nivel: String?,
             requisitos: String?)  {


    @PrimaryKey
    var id: Int = 0

    @ColumnInfo(name="name")
    var name: String = ""

    @ColumnInfo(name="descripcion")
    var descripcion: String = ""

    @ColumnInfo(name="profesor")
    var profesor: String = ""

    @ColumnInfo(name="puntaje")
    var puntaje: String = ""

    @ColumnInfo(name="inicio")
    var inicio: String = ""

    @ColumnInfo(name="fin")
    var fin: String = ""

    @ColumnInfo(name="horario")
    var horario: String = ""

    @ColumnInfo(name="carga")
    var carga: String = ""

    @ColumnInfo(name="nivel")
    var nivel: String = ""

    @ColumnInfo(name="requisitos")
    var requisitos: String = ""

    init{
        this.id = id
        this.name = name!!
        this.descripcion = descripcion!!
        this.profesor = profesor!!
        this.puntaje = puntaje!!
        this.inicio = inicio!!
        this.fin = fin!!
        this.horario = horario!!
        this.carga = carga!!
        this.nivel = nivel!!
        this.requisitos = requisitos!!
    }

}