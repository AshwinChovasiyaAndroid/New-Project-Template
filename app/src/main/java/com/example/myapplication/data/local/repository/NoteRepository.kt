package com.example.myapplication.data.local.repository

import com.example.myapplication.data.local.dao.NoteDao
import com.example.myapplication.data.local.daosource.NoteDaoSource
import com.example.myapplication.data.local.entities.NoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) : NoteDaoSource {
    override fun insert(note: NoteEntity) {
        noteDao.insert(note)
    }
}