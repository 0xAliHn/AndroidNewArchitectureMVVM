package com.android.androidcomponents.injection;

import javax.inject.Singleton;

import dagger.Component;
import com.android.androidcomponents.ui.event.add.AddEventViewModel;
import com.android.androidcomponents.ui.event.list.EventListViewModel;


@Singleton
@Component(modules = {CountdownModule.class})
public interface CountdownComponent {

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }
}
