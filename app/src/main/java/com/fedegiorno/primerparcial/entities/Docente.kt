package com.fedegiorno.primerparcial.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Docente")
class Docente (dni: String, apellido: String, nombres: String, usuario: String, email: String, password: String) {

    @PrimaryKey
    @ColumnInfo(name="dni")
    var dni: String = dni

    @ColumnInfo(name="apellido")
    var apellido: String

    @ColumnInfo(name="nombres")
    var nombres: String

    @ColumnInfo(name="usuario")
    var usuario: String

    @ColumnInfo(name="email")
    var email: String

    @ColumnInfo(name="password")
    var password: String


    init {
        this.dni = dni
        this.apellido = apellido
        this.nombres = nombres
        this.usuario = usuario
        this.email = email
        this.password = password
    }
}