package com.fedegiorno.primerparcial.databases

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fedegiorno.primerparcial.entities.Docente


@Database(
    entities = [Docente::class],
    //Aca se agregan todas las tablas
    version = 1,
    exportSchema = false)

abstract class appDatabase: RoomDatabase() {

    //Aca se agregan todas las interfaces que uso
    abstract fun docenteDao(): docenteDao

    companion object {
        private var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "DocentesDB"
                    ).allowMainThreadQueries().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}