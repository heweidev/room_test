package com.hewei.roomtest.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by fengyinpeng on 2018/9/11.
 */

@Entity(tableName = "new_tab")
public class NewTable {
    @PrimaryKey(autoGenerate = true)
    public long id;
}
