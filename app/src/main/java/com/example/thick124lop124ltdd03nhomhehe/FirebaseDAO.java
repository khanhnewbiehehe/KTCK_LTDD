package com.example.thick124lop124ltdd03nhomhehe;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDAO<T> {
    private final DatabaseReference databaseReference;

    // Constructor to initialize the Firebase Realtime Database
    public FirebaseDAO() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    // Create: Add new data
    public void add(String id, T data, FirebaseCallback callback) {
        if (id == null || id.isEmpty()) {
            callback.onFailure("Sai MSV");
            return;
        }
        if (data == null) {
            callback.onFailure("Data cannot be null");
            return;
        }

        databaseReference.child(id).setValue(data)
                .addOnSuccessListener(aVoid -> callback.onSuccess("Da them sinh vien"))
                .addOnFailureListener(e -> callback.onFailure(e.getMessage()));
    }

    // Read: Retrieve data
    public void read(String id, Class<T> clazz, FirebaseValueCallback<T> callback) {
        if (id == null || id.isEmpty()) {
            callback.onFailure("Sai MSV");
            return;
        }

        databaseReference.child(id).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        T data = dataSnapshot.getValue(clazz);
                        callback.onSuccess(data);
                    } else {
                        callback.onFailure("Khong co sinh vien");
                    }
                })
                .addOnFailureListener(e -> callback.onFailure(e.getMessage()));
    }

    // Update: Modify existing data
    public void update(String id, T newData, FirebaseCallback callback) {
        if (id == null || id.isEmpty()) {
            callback.onFailure("Invalid ID");
            return;
        }
        if (newData == null) {
            callback.onFailure("Data cannot be null");
            return;
        }

        databaseReference.child(id).setValue(newData)
                .addOnSuccessListener(aVoid -> callback.onSuccess("Data updated successfully"))
                .addOnFailureListener(e -> callback.onFailure(e.getMessage()));
    }

    // Delete: Remove data
    public void delete(String id, FirebaseCallback callback) {
        if (id == null || id.isEmpty()) {
            callback.onFailure("Invalid ID");
            return;
        }

        databaseReference.child(id).removeValue()
                .addOnSuccessListener(aVoid -> callback.onSuccess("Data deleted successfully"))
                .addOnFailureListener(e -> callback.onFailure(e.getMessage()));
    }

    // Callback interface for basic CRUD operations
    public interface FirebaseCallback {
        void onSuccess(String message);

        void onFailure(String errorMessage);
    }

    // Callback interface for reading data
    public interface FirebaseValueCallback<T> {
        void onSuccess(T data);

        void onFailure(String errorMessage);
    }
}
