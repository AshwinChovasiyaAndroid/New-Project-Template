package com.example.myapplication.data.local.daosource

import com.example.myapplication.data.local.entities.NoteEntity

interface NoteDaoSource {
    fun insert(note: NoteEntity)
}