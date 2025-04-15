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
                ((TextView)dialog.findViewById(R.id.infoContent)).setText("\uD83E\uDE99 How to Use the Coin Flipper:\n \n" +
                        "1) Just give the “Flip” button a tap to send it flying.\n" +
                        "\n" +
                        "2) Watch it Spin - The buttons will be disabled until the coin is done.\n \n" +
                        "3) See the Result – The coin will land on either Heads or Tails. That’s your answer!\n \n" +
                        "You can flip as many times as you like — just don’t blame us if the coin chooses something you didn’t want \uD83D\uDE09\n \n" +
                        "─────────────────\n" +
                        "No coin in your pocket? No problem. This digital flipper is perfect for:\n" +
                        "\n" +
                        "\uD83D\uDD04 Deciding who goes first in board games like Monopoly, Risk, or Catan\n" +
                        "\n" +
                        "\uD83C\uDFC8 Kicking off a friendly football or soccer match\n" +
                        "\n" +
                        "\uD83C\uDFA4 Choosing the first speaker in a group presentation or debate\n" +
                        "\n" +
                        "\uD83C\uDF54 Picking where to eat when no one wants to choose\n" +
                        "\n" +
                        "\uD83C\uDFAE Breaking ties or choosing teams in party or video games\n" +
                        "\n" +
                        "☕ Settling everyday standoffs (like who’s making the coffee run)\n" +
                        "\n");

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