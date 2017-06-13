package com.android.androidcomponents.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.android.androidcomponents.dao.EventDao;
import com.android.androidcomponents.entity.Event;

@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}
