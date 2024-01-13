package com.example.myapplication.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteEntity(val title: String,
                val description: String,
                val priority: Int,
                @PrimaryKey(autoGenerate = false) val id: Int? = null)
