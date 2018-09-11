package com.hewei.roomtest.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by fengyinpeng on 2018/5/15.
 */

@Entity(foreignKeys = @ForeignKey(entity = NewsEntity.class, parentColumns = "id",
            childColumns = "doc_id", onDelete = ForeignKey.CASCADE),
    tableName = "files",
    indices = @Index("doc_id"))
public class FileEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "local_uri")
    public String localUri;

    @ColumnInfo(name = "remote_uri")
    public String remoteUri;

    @ColumnInfo(name = "doc_id")
    public String docId;
}
