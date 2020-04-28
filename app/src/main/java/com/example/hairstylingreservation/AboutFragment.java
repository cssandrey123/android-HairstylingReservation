package com.example.hairstylingreservation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);

        if (savedInstanceState != null) {
            int day = savedInstanceState.getInt("day", -1);
            Toast.makeText(view.getContext(), "am ajuns la about" + day, Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(view.getContext(), "null error", Toast.LENGTH_SHORT).show();

        return view;
    }
}
