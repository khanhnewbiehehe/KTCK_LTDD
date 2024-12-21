package com.example.thick124lop124ltdd03nhomhehe;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thick124lop124ltdd03nhomhehe.Models.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVien_listArrayAdapter extends ArrayAdapter<SinhVien> {

    private Context context;
    private List<SinhVien> sinhvien_listProperties;

    public SinhVien_listArrayAdapter(Context context, int resource, ArrayList<SinhVien> objects) {
        super(context, resource, objects);

        this.context = context;
        this.sinhvien_listProperties = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SinhVien property = sinhvien_listProperties.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sinhvien_list_item, null);

        TextView room_name = view.findViewById(R.id.sinhvien_msv);
        TextView room_date = view.findViewById(R.id.sinhvien_ten);
        TextView room_trangthai = view.findViewById(R.id.sinhvien_lop);

        room_name.setText(property.getMaSV());
        room_date.setText(property.getTen());
        room_trangthai.setText(property.getLop());


        return view;
    }
}
