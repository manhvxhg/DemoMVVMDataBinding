package com.example.manhnd16.demomvvmdatabinding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manhnd16.demomvvmdatabinding.R;
import com.example.manhnd16.demomvvmdatabinding.databinding.MyListBinding;
import com.example.manhnd16.demomvvmdatabinding.viewmodel.MyListViewModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<MyListViewModel> mMyListArrayList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(ArrayList<MyListViewModel> arrayList, Context context) {
        this.mMyListArrayList = arrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        MyListBinding myListBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.mylist, parent, false);
        return new MyViewHolder(myListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyListViewModel myListViewModel = mMyListArrayList.get(position);
        holder.bind(myListViewModel, position);
    }

    @Override
    public int getItemCount() {
        return mMyListArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyListBinding myListBinding;
        private int position;

        public MyViewHolder(@NonNull MyListBinding myListBinding) {
            super(myListBinding.getRoot());
            myListBinding.getRoot().setOnClickListener(this);
            this.myListBinding = myListBinding;
        }

        public void bind(MyListViewModel myli, int position) {
            this.myListBinding.setMylistmodel(myli);
            this.position = position;
            myListBinding.executePendingBindings();
        }

        public MyListBinding getMyListBinding() {
            return myListBinding;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "Test " + position, Toast.LENGTH_LONG).show();
        }
    }
}
