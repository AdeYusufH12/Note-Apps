package org.d3if0018.noteapps.Repository

import androidx.lifecycle.LiveData
import org.d3if0018.noteapps.Dao.NotesDao
import org.d3if0018.noteapps.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes():LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.inserNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }

}