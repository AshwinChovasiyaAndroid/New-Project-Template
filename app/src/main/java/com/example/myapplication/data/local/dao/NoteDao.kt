package com.example.myapplication.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.data.local.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert
    fun insert(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

    @Query("delete from note_table")
    fun deleteAllNotes()

    @Query("select * from note_table order by priority desc")
    fun getAllNotes(): LiveData<List<NoteEntity>>
}