package com.hewei.roomtest.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by fengyinpeng on 2018/5/15.
 */
@Dao
public interface NewDAO {
    // --------------- News ---------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(NewsEntity news);

    @Update
    void updateUsers(NewsEntity news);

    @Delete
    void deleteUsers(NewsEntity news);

    @Query("SELECT * FROM news where id = :docId")
    NewsEntity loadNews(String docId);

    // --------------- File --------------------
    @Insert
    long insertFile(FileEntity file);

    @Query("select * from files where id = :fileId")
    FileEntity queryFile(int fileId);

    @Delete
    void deleteFile(FileEntity file);

    @Update
    void updateFile(FileEntity file);
}
