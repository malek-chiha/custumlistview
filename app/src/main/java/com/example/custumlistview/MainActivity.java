package com.example.custumlistview;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected ListView myListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListViewPerso = findViewById(R.id.listviewperso) ;

        ArrayList<HashMap<String, String>> listitem = new ArrayList<>();
        HashMap<String , String> map ;
        map = new HashMap<>();
        map.put("titre" ,"word") ;
        map.put("description " ,"Editeur de text") ;
        map.put("img" ,String.valueOf(R.mipmap.word));
        listitem.add(map) ;

        map = new HashMap<>();
        map.put("titre" ,"excel") ;
        map.put("description " ,"Editeur de text") ;
        map.put("img" ,String.valueOf(R.mipmap.excel));
        listitem.add(map) ;

        map = new HashMap<>();
        map.put("titre" ,"outlook") ;
        map.put("description " ,"Editeur de text") ;
        map.put("img" ,String.valueOf(R.mipmap.outlook));
        listitem.add(map) ;

        map = new HashMap<>();
        map.put("titre" ,"powerpoint") ;
        map.put("description " ,"Editeur de text") ;
        map.put("img" ,String.valueOf(R.mipmap.power));
        listitem.add(map) ;

        SimpleAdapter adapter= new SimpleAdapter(this.getBaseContext(),
                listitem,
                R.layout.activity_list_item ,
                new String [] {"img" ,"titre" ,"description" } ,
                new int [] {R.id.img , R.id.titre ,R.id.description }) ;


        myListViewPerso.setAdapter(adapter);
        myListViewPerso.setOnItemClickListener((parent, view, position, id) -> {
            HashMap map1 =(HashMap) myListViewPerso.getItemAtPosition(position);
            String titre =(String) map1.get("titre");
            Toast.makeText(MainActivity.this,titre,Toast.LENGTH_SHORT).show();
        });
        myListViewPerso.setOnItemClickListener((parent, view, position, id) -> {
            HashMap map2 =(HashMap) myListViewPerso.getItemAtPosition(position);
            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
            adb.setTitle("Selection Item");
            adb.setMessage("Votre choix :" +map2.get("titre"));
            adb.setPositiveButton("ok" ,null);
            adb.show();
        });


    }
}