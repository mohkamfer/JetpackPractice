package com.mohkamfer.architecturespractice.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mohkamfer.architecturespractice.data.entity.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Query("DELETE FROM word")
    void deleteAll();

    @Query("SELECT * FROM word ORDER BY content ASC")
    LiveData<List<Word>> findAll();
}
