package com.example.thick124lop124ltdd03nhomhehe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.thick124lop124ltdd03nhomhehe.Models.SinhVien;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SinhVien> sinhvien_listProperties = new ArrayList<>();
    DatabaseReference mDatabase;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnThem = findViewById(R.id.button7);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, AddMember.class);
                startActivity(intent1);
            }
        });

    }
}