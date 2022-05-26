package org.d3if0018.noteapps.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.d3if0018.noteapps.Model.Notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes ")
    fun getNotes():LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)

}