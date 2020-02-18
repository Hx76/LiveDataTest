package com.example.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    public MutableLiveData<Integer> LikedNumber;
    public MutableLiveData<Integer> getLikedNumber() {
        if (LikedNumber == null){
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void setLikedNumber(MutableLiveData<Integer> likedNumber) {
        LikedNumber = likedNumber;
    }

    public void addLikedNumber(int n){
        LikedNumber.setValue(LikedNumber.getValue()+n);
    }




}
