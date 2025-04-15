package com.example.randomiser_app.ui.infobutton;

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
    private static final  String CURPAGE = "currentPage";
    private String page;

    public InfoButtonFragment(){

    }

    public static InfoButtonFragment newInstance (String currentPage){
        InfoButtonFragment fragment = new InfoButtonFragment();
        Bundle args = new Bundle();
        args.putString(CURPAGE,currentPage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            page = getArguments().getString(CURPAGE);
        }
    }

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

    private void setupText(String page,Dialog dialog){
       Log.i("INFO BUTTON", page);
        switch(page){
            case"HOME":
                ((TextView)dialog.findViewById(R.id.infoTitle)).setText(R.string.info_button_main_title);
                ((TextView)dialog.findViewById(R.id.infoContent)).setText(String.format("%s%s%s%s", getString(R.string.info_button_main_content_p1), getString(R.string.info_button_main_content_p2), getString(R.string.info_button_main_content_p3), getString(R.string.info_button_main_content_p4)));
                break;
            case"COIN":
                ((TextView)dialog.findViewById(R.id.infoTitle)).setText(R.string.info_button_coin_flipper_title);
                dialog.findViewById(R.id.infoContent).setPadding(10,0,10,0);
                ((TextView)dialog.findViewById(R.id.infoContent)).setText(String.format("%s%s%s%s%s%s%s%s%s",
                        getString(R.string.info_button_coin_flipper_content_p1),
                        getString(R.string._1_info_button_coin_flipper_content_p2),
                        getString(R.string.info_button_coin_flipper_content_p3),
                        getString(R.string.info_button_coin_flipper_content_p4),
                        getString(R.string.info_button_coin_flipper_content_p5),
                        getString(R.string.info_button_line_break),
                        getString(R.string.info_button_coin_flipper_content_p6),
                        getString(R.string.info_button_coin_flipper_content_p7),
                        getString(R.string.info_button_line_break)));
                break;
            case "DICE":
                // TODO: 11/04/2025 add text for 'dice roll' info page
                break;
            case "STRAWS":
                // TODO: 11/04/2025 add text for 'draw straws' info page
                break;
            default:
                Log.i("InfoButton","Info unable to set up text");
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("InfoButtonFragment", "DialogFragment destroyed");
    }
}