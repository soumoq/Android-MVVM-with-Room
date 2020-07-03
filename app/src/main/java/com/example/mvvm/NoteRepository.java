package com.example.mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.xml.transform.Result;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNote;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNote = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new InsertNodeAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNodeAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNodeAsyncTask(noteDao).execute(note);
    }

    public void deleteAllNote(){
        new DeleteAllNodeAsyncTask(noteDao).execute();
    }

    private LiveData<List<Note>> getAllNote(){
        return allNote;
    }

    private static class InsertNodeAsyncTask extends AsyncTask<Note,Void,Void>{

        private NoteDao noteDao;
        private InsertNodeAsyncTask(NoteDao noteDao) {
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNodeAsyncTask extends AsyncTask<Note,Void,Void>{

        private NoteDao noteDao;
        private UpdateNodeAsyncTask(NoteDao noteDao) {
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }


    private static class DeleteNodeAsyncTask extends AsyncTask<Note,Void,Void>{

        private NoteDao noteDao;
        private DeleteNodeAsyncTask(NoteDao noteDao) {
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }


    private static class DeleteAllNodeAsyncTask extends AsyncTask<Void,Void,Void>{

        private NoteDao noteDao;
        private DeleteAllNodeAsyncTask(NoteDao noteDao) {
            this.noteDao =noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNode();
            return null;
        }
    }
}
