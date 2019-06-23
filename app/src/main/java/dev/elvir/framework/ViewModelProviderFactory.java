package dev.elvir.framework;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;



public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {



    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

