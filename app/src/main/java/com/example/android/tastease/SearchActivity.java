package com.example.android.tastease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {
    EditText name, exclude, include;
Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        include = findViewById(R.id.include);
        exclude = findViewById(R.id.exclude);
        name=findViewById(R.id.name);
        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ResultVideoActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name", name.getText().toString());
                extras.putString("include", include.getText().toString());
                extras.putString("exclude", exclude.getText().toString());
                intent.putExtras(extras);
                startActivity(intent);

            }
        });

    }


}
