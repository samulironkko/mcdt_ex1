package com.example.mcdt_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> carList = new ArrayList<String>();

    private static void getCars(){
        carList.add("Alfa Romeo");
        carList.add("BMW");
        carList.add("Corvette");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCar = findViewById(R.id.add_button);
        Button editCar = findViewById(R.id.edit_button);
        Button removeCar = findViewById(R.id.remove_button);
        final EditText editText = findViewById(R.id.edit_text);

        getCars();
        final ListView myListView = (ListView)findViewById(R.id.list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carList);
        myListView.setAdapter(aa);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = editText.getText().toString();
                carList.add(brand);
                myListView.setAdapter(aa);
            }
        });

        editCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedCar = carList.get(position);
                        editText.setText(selectedCar);

                    }
                });
            }
        });

        removeCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        carList.remove(position);
                        myListView.setAdapter(aa);
                    }
                });
            }
        });

    }

}
