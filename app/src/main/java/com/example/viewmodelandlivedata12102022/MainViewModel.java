package com.example.viewmodelandlivedata12102022;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by pphat on 12/21/2022.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    public LiveData<String> getString() {
        return stringMutableLiveData;
    }

    public void setString(String text) {
        stringMutableLiveData.setValue(text);
    }
}
