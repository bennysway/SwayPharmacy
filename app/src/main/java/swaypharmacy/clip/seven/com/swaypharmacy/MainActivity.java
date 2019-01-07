package swaypharmacy.clip.seven.com.swaypharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        View include = findViewById(R.id.mainButtons);
        ImageView searchButton = include.findViewById(R.id.search_icon);
        ImageView diagnoseButton = include.findViewById(R.id.diagnose_icon);
        ImageView helpButton = include.findViewById(R.id.emergency_icon);
        ImageView itemsButton = include.findViewById(R.id.cart_icon);
        ImageView accountButton = include.findViewById(R.id.account_icon);
        ImageView writeButton = include.findViewById(R.id.rate_icon);






        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSearch = new Intent(getApplicationContext(), Search.class);
                startActivity(toSearch);
            }
        });


    }
}
