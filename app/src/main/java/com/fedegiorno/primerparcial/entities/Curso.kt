package com.fedegiorno.primerparcial.entities

class Curso( name: String?,
             descripcion: String?,
             profesor: String?,
             puntaje: String?,
             inicio: String?,
             fin: String?,
             horario: String?,
             carga: String?,
             nivel: String?,
             requisitos: String?)  {

    var name: String = ""
    var descripcion: String = ""
    var profesor: String = ""
    var puntaje: String = ""
    var inicio: String = ""
    var fin: String = ""
    var horario: String = ""
    var carga: String = ""
    var nivel: String = ""
    var requisitos: String = ""

    init{
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