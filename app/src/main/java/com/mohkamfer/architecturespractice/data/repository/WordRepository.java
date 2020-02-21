package com.mohkamfer.architecturespractice.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mohkamfer.architecturespractice.data.entity.Word;
import com.mohkamfer.architecturespractice.data.dao.WordDao;
import com.mohkamfer.architecturespractice.data.WordRoomDatabase;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getInstance(application);
        wordDao = db.wordDao();
        allWords = wordDao.findAll();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        new InsertAsyncTask(wordDao).execute(word);
    }

    private class InsertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words[0]);
            return null;
        }
    }
}
