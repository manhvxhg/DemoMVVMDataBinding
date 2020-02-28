package com.example.manhnd16.demomvvmdatabinding.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.manhnd16.demomvvmdatabinding.model.MyList;
import com.example.manhnd16.demomvvmdatabinding.networkservice.ApiService;
import com.example.manhnd16.demomvvmdatabinding.networkservice.MyClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyListViewModel extends ViewModel {
    public String id = "";
    public String artistname = "";
    public String artistimage = "";
    public String moviename = "";
    public MutableLiveData<ArrayList<MyListViewModel>> mutableLiveData = new MutableLiveData<>();
    private ArrayList<MyListViewModel> arrayList;
    private ArrayList<MyList> myList;

    public String getImageurl() {
        return artistimage;
    }

    public MyListViewModel() {

    }

    public MyListViewModel(MyList myList) {
        this.id = myList.id;
        this.artistname = myList.artistname;
        this.artistimage = myList.artistimage;
        this.moviename = myList.moviename;
    }

    public MutableLiveData<ArrayList<MyListViewModel>> getMutableLiveData() {

        arrayList = new ArrayList<>();

        ApiService apiService = MyClient.getInstance().getMyApi();
        Call<ArrayList<MyList>> call = apiService.getartistdata();
        call.enqueue(new Callback<ArrayList<MyList>>() {
            @Override
            public void onResponse(Call<ArrayList<MyList>> call, Response<ArrayList<MyList>> response) {
                myList = new ArrayList<>();
                myList = response.body();
                if (myList != null && myList.size() > 0) {
                    for (int i = 0; i < myList.size(); i++) {
                        MyList myk = myList.get(i);
                        MyListViewModel myListViewModel = new MyListViewModel(myk);
                        arrayList.add(myListViewModel);
                        mutableLiveData.setValue(arrayList);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MyList>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
