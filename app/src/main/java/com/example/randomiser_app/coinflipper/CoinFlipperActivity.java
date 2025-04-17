package com.example.randomiser_app.coinflipper;

import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.randomiser_app.R;
import com.example.randomiser_app.databinding.ActivityCoinFlipperBinding;
import com.example.randomiser_app.ui.infobutton.InfoButtonFragment;

public class CoinFlipperActivity extends AppCompatActivity {
    ActivityCoinFlipperBinding binding;
    private int currentSide = R.drawable.coinlogo;
    private int coinSide;
    private ImageView coinImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Need to set bindings manually and get the view from that in order to databind
        ActivityCoinFlipperBinding binding = ActivityCoinFlipperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setClickHandler(new CoinFlipperClickHandler(this));

        setUpToolbar();
        setInfoButton();
        binding.coinimage.setImageResource(R.drawable.coinlogo);
        binding.fliphistorylist.setText("");
        binding.fliphistorylist.setMovementMethod(new ScrollingMovementMethod());
        binding.fliphistorylist.setHorizontallyScrolling(true);
    }

    private void setUpToolbar(){
        Toolbar toolbar =  findViewById(R.id.customtoolbar);
        Log.i("CoinFlipperActivity", "toolbar: " + toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setToolbarText();

    }

    private void setToolbarText(){
        TextView toolbarTitle = findViewById(R.id.maintoolbartitle);
        toolbarTitle.setText(R.string.coin_flippers_toolbar_title);
        toolbarTitle.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle back button arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to previous activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    private void setInfoButton(){
        ImageButton imageButton = findViewById(R.id.toolbar_imagebutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoButtonFragment fragment = InfoButtonFragment.newInstance("COIN");
                fragment.show(getSupportFragmentManager(), "COINFLIPFRAG");
            }
        });

    }

}