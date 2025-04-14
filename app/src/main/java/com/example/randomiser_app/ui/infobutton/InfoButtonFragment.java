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
                ((TextView)dialog.findViewById(R.id.infoTitle)).setText("RNJESUS");
                ((TextView)dialog.findViewById(R.id.infoContent)).setText("Welcome to RNJESUS – Let divine randomness decide! 🎲\n\nWhether you're flipping a coin, rolling dice, drawing straws, or picking a card, trust in the higher power of chance.\n\n• Coin Flip – Heads or tails? Leave it to fate.\n\n•  Roll Dice – From D6 to D20, let your roll be guided by a higher power.\n\n• Draw Straws – Who’s going first? Settle it fair and square with righteous intervention.\n\n• Pick a Card– Need a card? Shuffle the deck and RNJESUS decide.\n\nNo need to argue, overthink, or fight your friends—let RNJESUS take the wheel (and maybe the dice too).\n\n");
                break;
            case"COIN":
                // TODO: 11/04/2025 add text for 'dice roll' info page
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