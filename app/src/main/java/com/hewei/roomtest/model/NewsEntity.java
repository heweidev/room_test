package com.hewei.roomtest.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by fengyinpeng on 2018/5/15.
 */

@Entity(tableName = "news", indices = @Index(value = "title", unique = true))
public class NewsEntity {
    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo
    public String title;

    public String contents;
    public String origin;
}
