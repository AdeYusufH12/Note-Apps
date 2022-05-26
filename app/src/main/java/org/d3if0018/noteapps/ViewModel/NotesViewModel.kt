package org.d3if0018.noteapps.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.d3if0018.noteapps.Database.NotesDatabase
import org.d3if0018.noteapps.Model.Notes
import org.d3if0018.noteapps.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository:NotesRepository

    init {

        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }



}