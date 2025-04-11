package com.example.randomiser_app.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.randomiser_app.R;

import java.util.Objects;


public class InfoButtonFragment extends DialogFragment {
    private final String TAG = "MAINMENUFRAG";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = new Dialog(this.requireContext());
        dialog.setContentView(R.layout.fragment_info_button);
        setupText(page,dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(R.drawable.info_button_box_style);
        dialog.show();
        return dialog;
    }

    private void setupText(View view){

        TextView textView =  view.findViewById(R.id.infoTitle);
        textView.setText("The Main Menu is for the man RNGJESUS Himself");




    }
}