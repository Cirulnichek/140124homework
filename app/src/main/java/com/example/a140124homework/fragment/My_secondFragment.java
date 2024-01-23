package com.example.a140124homework.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.example.a140124homework.R;
import com.example.a140124homework.view.DrawView;

public class My_secondFragment extends Fragment {
    private DrawView drawView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.drawView = new DrawView(getActivity());
        return this.drawView;
    }

    public void destroyThread() {
        if (drawView != null) {
            this.drawView.destroyThread();
        }
    }
}