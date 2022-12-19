package com.example.viewmodelandlivedata12102022;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by pphat on 12/19/2022.
 */
public class MyLiveData {
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    public LiveData<String> getString() {
        return stringMutableLiveData;
    }

    public void setData(String data) {
        stringMutableLiveData.setValue(data);
    }
}
