package com.android.androidcomponents.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.android.androidcomponents.CountdownApplication;
import com.android.androidcomponents.db.EventDatabase;
import com.android.androidcomponents.repository.EventRepository;
import com.android.androidcomponents.repository.EventRepositoryImpl;


@Module
public class CountdownModule {

    private CountdownApplication countdownApplication;

    public CountdownModule(CountdownApplication countdownApplication) {
        this.countdownApplication = countdownApplication;
    }

    @Provides
    Context applicationContext() {
        return countdownApplication;
    }

    @Provides
    @Singleton
    EventRepository providesEventRepository(EventDatabase eventDatabase) {
        return new EventRepositoryImpl(eventDatabase);
    }

    @Provides
    @Singleton
    EventDatabase providesEventDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class, "event_db").build();
    }
}
