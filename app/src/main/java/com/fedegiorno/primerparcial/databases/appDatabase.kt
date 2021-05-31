package com.fedegiorno.primerparcial.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fedegiorno.primerparcial.entities.Docente
import com.fedegiorno.primerparcial.entities.Curso


@Database(
    entities = [Docente::class, Curso::class],
    //Aca se agregan todas las tablas
    version = 1,
    exportSchema = false)

abstract class appDatabase: RoomDatabase() {

    //Aca se agregan todas las interfaces que uso
    abstract fun docenteDao(): docenteDao
    abstract fun cursoDao(): cursoDao

    companion object {
        private var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "CIIE-DB"
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