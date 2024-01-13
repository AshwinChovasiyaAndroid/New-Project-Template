package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.local.dao.NoteDao
import com.example.myapplication.data.local.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class Modules {

    /*@Provides
    @Singleton
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): AnalyticsService {
        return Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
            .create(AnalyticsService::class.java)
    }*/

    /* @Binds
     abstract fun bindAnalyticsService(
         analyticsServiceImpl: AnalyticsServiceImpl
     ): AnalyticsService*/


    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context) :NoteDatabase{
        return Room.databaseBuilder(
            context, NoteDatabase::class.java,
            "note_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.noteDao()
    }


}