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
Spinner spinner_type,spinner_cuisine;
EditText name;
String type,cuisine,fname;
Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner_type=findViewById(R.id.spinner_type);
        spinner_cuisine=findViewById(R.id.spinner_cuisine);
        name=findViewById(R.id.name);
        search=findViewById(R.id.search);
        setupSpinner();

        }
    private void setupSpinner() {

        ArrayAdapter typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_type_options, android.R.layout.simple_spinner_item);

        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner_type.setAdapter(typeSpinnerAdapter);

        ArrayAdapter cuisineSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_cuisine_options, android.R.layout.simple_spinner_item);


        cuisineSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner_cuisine.setAdapter(cuisineSpinnerAdapter);

        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals("none")) {
                        type="";
                    } else if (selection.equals("main course")) {
                        type="main course";
                    } else if (selection.equals("side dish")) {
                        type="side dish";
                    } else if (selection.equals("dessert")) {
                        type="dessert";
                    }else if (selection.equals("salad")) {
                        type="salad";
                    }else if (selection.equals("breakfast")) {
                        type="breakfast";
                    }else if (selection.equals("soup")) {
                        type="soup";
                    }else if (selection.equals("beverage")) {
                        type="beverage";
                    }else if (selection.equals("drink")) {
                        type="drink";
                    }else {
                        type="";
                    }
                }
                Log.e(SearchActivity.class.getSimpleName(),"type:"+type);

            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                type="";
            }
        });
        spinner_cuisine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals("none")) {
                        cuisine="";
                    } else if (selection.equals("chinese")) {
                        cuisine="chinese";
                    } else if (selection.equals("japanese")) {
                        cuisine="japanese";
                    } else if (selection.equals("korean")) {
                        cuisine="korean";
                    }else if (selection.equals("vietnamese")) {
                        cuisine="vietnamese";
                    }else if (selection.equals("thai")) {
                        cuisine="thai";
                    }else if (selection.equals("indian")) {
                        cuisine="indian";
                    }else if (selection.equals("british")) {
                        cuisine="british";
                    }else if (selection.equals("italian")) {
                        cuisine="italian";
                    }else if (selection.equals("mexican")) {
                        cuisine="mexican";
                    }else if (selection.equals("caribbean")) {
                        cuisine="caribbean";
                    }else {
                        cuisine="";
                    }
                }
                Log.e(SearchActivity.class.getSimpleName(),"cuisine:"+cuisine);
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cuisine="";
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ResultVideoActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name", name.getText().toString());
                extras.putString("type", type);
                extras.putString("cuisine",cuisine );
                intent.putExtras(extras);
                startActivity(intent);

            }
        });
    }
}