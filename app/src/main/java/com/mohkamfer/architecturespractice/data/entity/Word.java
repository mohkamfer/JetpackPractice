package com.mohkamfer.architecturespractice.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class Word {
    @PrimaryKey
    @ColumnInfo(name = "content")
    @NonNull
    public String content;

    public Word () {}

    public Word (String word) {
        this.content = word;
    }
}
