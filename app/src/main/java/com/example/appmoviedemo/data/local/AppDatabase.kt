package com.example.appmoviedemo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appmoviedemo.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1) //Le estamos diciendo que tipo de informacion guardamos en la base de datos y la version la vamos cambiando nosotros
abstract class AppDatabase: RoomDatabase(){
    abstract  fun movieDao():MovieDao

    companion object{   //Para que se genere solo una base de datos y nose cree demas
        private var INSTANCE :AppDatabase?=null

        fun getDatabase(context: Context):AppDatabase{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "movie_table"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }


}