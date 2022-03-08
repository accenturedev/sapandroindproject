package com.sap.northwindapplication.mdui.pages;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sap.northwindapplication.R;

import java.util.ArrayList;

public class PageList extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Bundle extras = getIntent().getExtras();

        String extrasS= extras.getString("Immessi");
        Log.i("valueimport", extrasS);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(extrasS);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        ArrayList<String> arrayList= new ArrayList<String>();

        arrayList.add("Conferma Bolle");
        arrayList.add("Resi Unificati");
        arrayList.add("Ricevimento OODD");

        ListView listView = findViewById(R.id.pages_list);
        // custom Adapter
        ItemAdapter adapter2 = new ItemAdapter(this, arrayList);

        /* Standard adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        */


        listView.setAdapter(adapter2);

    }
    public class ItemAdapter extends ArrayAdapter<String>{

        public ItemAdapter(@NonNull Context context, ArrayList<String> arrayList) {
            super(context, 0, arrayList);

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            String item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_pages_list, parent, false);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.single_element);

            textView.setText(item);

            return convertView;
        }
    }
}


