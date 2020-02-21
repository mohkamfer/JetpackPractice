package com.mohkamfer.architecturespractice.data.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mohkamfer.architecturespractice.data.entity.Word;
import com.mohkamfer.architecturespractice.data.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> wordList;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        wordList = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getWordList() {
        return wordList;
    }

    public void insert(Word word) {
        wordRepository.insert(word);
    }
}
