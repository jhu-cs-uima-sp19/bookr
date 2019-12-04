package com.example.myapplication;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoomViewModel extends ViewModel {
    /**
     * Live Data Instance
     */
    private MutableLiveData<ArrayList<String>> mSelection = new MutableLiveData<>();

    public void setName(ArrayList<String> selections) {
        mSelection.setValue(selections);
    }

    public LiveData<ArrayList<String>> getName() {
        return mSelection;
    }
}
