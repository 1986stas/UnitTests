package com.osikov.stas.unittests;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.osikov.stas.unittests.models.Contact;

import java.util.ArrayList;

public class ActivityRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_acivity_layout);
        recyclerView = findViewById(R.id.rvContacts);
        contacts = Contact.createContactsList(50);
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
