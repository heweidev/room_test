package com.hewei.roomtest.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by fengyinpeng on 2018/5/15.
 */

@Database(entities = {
        FileEntity.class,
        NewsEntity.class,
        NewTable.class
    }, version = 6)
public abstract class NewsDataBase extends RoomDatabase {
    private static final String DB_NAME = "news_edit";

    private static NewsDataBase sInst;

    public abstract NewDAO newsDAO();


    public static NewsDataBase dataBase(Context context) {
        if (sInst == null) {
            sInst = Room.databaseBuilder(context, NewsDataBase.class, DB_NAME)
                    .addMigrations(new Migration_1_3(1, 6))
                    .build();
        }

        return sInst;
    }

    private static class Migration_1_3 extends Migration {
        /**
         * Creates a new migration between {@code startVersion} and {@code endVersion}.
         *
         * @param startVersion The start version of the database.
         * @param endVersion   The end version of the database after this migration is applied.
         */
        public Migration_1_3(int startVersion, int endVersion) {
            super(startVersion, endVersion);
        }

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `new_tab` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        }
    }
}
