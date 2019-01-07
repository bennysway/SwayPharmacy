package swaypharmacy.clip.seven.com.swaypharmacy;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        AutoCompleteTextView searchBar = findViewById(R.id.searchDrugEditTextView);
        searchBar.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        ListView listView = findViewById(R.id.mainList);
        ImageView back = findViewById(R.id.back);

        try {
            JSONArray drugs =  new JSONArray(getJson());
            final ArrayList<String> list = new ArrayList<>();

            for(int i=0; i<drugs.length(); i++){
                list.add(drugs.getJSONObject(i).getString("term"));
            }
            listView.setAdapter(new ArrayAdapter(this, R.layout.drug_list_layout_item, R.id.drugName,list));
            searchBar.setAdapter(new ArrayAdapter(this, R.layout.drug_list_layout_item, R.id.drugName,list));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    QToast("Buying " + list.get(position));
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void QToast(String t){
        Toast.makeText(getApplicationContext(), t,
                Toast.LENGTH_LONG).show();
    }

    public String getJson() throws IOException {
        InputStream is = getApplicationContext().getAssets().open("drugs.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }
}
