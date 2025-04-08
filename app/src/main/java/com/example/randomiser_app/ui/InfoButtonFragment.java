package com.example.randomiser_app.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.randomiser_app.R;


public class InfoButtonFragment extends DialogFragment {
    private final String TAG = "MAINMENUFRAG";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_info_button,null);
        builder.setView(view);

        setupText(view);
        return builder.create();

    }

    private void setupText(View view){

        TextView textView =  view.findViewById(R.id.infoTitle);
        textView.setText("The Main Menu is for the man RNGJESUS Himself");




    }
}