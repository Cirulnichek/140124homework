package com.example.a140124homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.a140124homework.databinding.ActivityMainBinding;
import com.example.a140124homework.fragment.MyFragment;
import com.example.a140124homework.fragment.My_secondFragment;
import com.example.a140124homework.fragment.My_thirdFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private MyFragment firstFragment;
    private My_secondFragment secondFragment;

    private My_thirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        firstFragment = new MyFragment();
        secondFragment = new My_secondFragment();
        thirdFragment = new My_thirdFragment();

        binding.btnFr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fr_main, firstFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.btnFr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragmentManager.getFragments().get(0));
                fragmentTransaction.add(R.id.fr_main, secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.btnFr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fr_main, thirdFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}