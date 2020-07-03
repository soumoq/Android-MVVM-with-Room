package com.example.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNode();

    @Query("select * from note_table order by priority desc")
    LiveData<List<Note>> getAllNotes();

}
