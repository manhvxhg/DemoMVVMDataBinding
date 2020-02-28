package com.example.manhnd16.demomvvmdatabinding.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.manhnd16.demomvvmdatabinding.R;
import com.example.manhnd16.demomvvmdatabinding.adapter.MyAdapter;
import com.example.manhnd16.demomvvmdatabinding.databinding.ActivityMainBinding;
import com.example.manhnd16.demomvvmdatabinding.viewmodel.MyListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyListViewModel mMyListViewModel;
    public ObservableField<MyAdapter> myAdapterObservableField = new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainBinding(this);
        mMyListViewModel = ViewModelProviders.of(this).get(MyListViewModel.class);
        mMyListViewModel.getMutableLiveData().observe(this, new Observer<ArrayList<MyListViewModel>>() {
            @Override
            public void onChanged(ArrayList<MyListViewModel> myListViewModels) {
                myAdapterObservableField.set(new MyAdapter(myListViewModels, MainActivity.this));
            }
        });
    }
}
