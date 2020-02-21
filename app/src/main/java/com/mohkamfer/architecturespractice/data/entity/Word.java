package com.mohkamfer.architecturespractice.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class Word {
    @PrimaryKey
    @ColumnInfo(name = "content")
    public String content;
}
