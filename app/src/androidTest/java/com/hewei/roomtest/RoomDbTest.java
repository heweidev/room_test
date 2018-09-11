package com.hewei.roomtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.hewei.roomtest.model.FileEntity;
import com.hewei.roomtest.model.NewDAO;
import com.hewei.roomtest.model.NewsDataBase;
import com.hewei.roomtest.model.NewsEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by fengyinpeng on 2018/5/17.
 */

@RunWith(AndroidJUnit4.class)
public class RoomDbTest {
    private NewDAO mUserDao;
    private NewsDataBase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, NewsDataBase.class).build();
        mUserDao = mDb.newsDAO();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeNewsAndReadInList() throws Exception {
        NewsEntity news = new NewsEntity();
        news.id = "abcd";
        news.contents = "<a href=\"http://www.baidu.com\"></a>";
        news.origin = "fyp";
        news.title = "Hello World";

        mUserDao.insertNews(news);

        news.origin = "fyp-1";
        mUserDao.updateUsers(news);

        NewsEntity news1 = mUserDao.loadNews("abcd");
        assertThat(news1.contents, equalTo(news.contents));
        assertThat(news1.origin, equalTo(news.origin));

        FileEntity file = new FileEntity();
        file.localUri = "/sdcard/a.mp3";
        file.docId = "abcd";
        long id1 = mUserDao.insertFile(file);
        long id2 = mUserDao.insertFile(file);

        System.out.println("id1: " + id1 + ", id2 = " + id2);

        NewsEntity del = new NewsEntity();
        del.id = "abcd";
        mUserDao.deleteUsers(del);
        assertThat(mUserDao.loadNews("abcd"), equalTo(null));
        assertThat(mUserDao.queryFile(file.id), equalTo(null));
    }
}
