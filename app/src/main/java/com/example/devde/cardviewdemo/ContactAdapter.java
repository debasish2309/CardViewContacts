package com.example.devde.cardviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    ArrayList<contact> contacts = new ArrayList<contact>();
    Context context;                      //context for click listener

    public ContactAdapter(ArrayList<contact> contacts,Context context) {   //context for click listener
        this.contacts = contacts;
        this.context = context;        //context for click listener
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view,context,contacts); //context and contacts for click listener
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        contact contact = contacts.get(position);
        holder.person_image.setImageResource(contact.getImage_id());
        holder.person_name.setText(contact.getName());
        holder.person_email.setText(contact.getEmail());
        holder.person_phone.setText(contact.getPhone());

        final int currentPosition = position;
        final contact infodata = contacts.get(position);

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(infodata);

            }
        });

    }
    private void removeItem(contact infodata){
        int Currposition = contacts.indexOf(infodata);
        contacts.remove(Currposition);
        notifyItemRemoved(Currposition);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView person_image;
        TextView person_name,person_email,person_phone;
        Button delete;
        //For click Listener
        ArrayList<contact> contacts = new ArrayList<contact>();
        Context context;

        //content and ArrayList for clicklistener

        public ContactViewHolder(final View view, Context context, final ArrayList<contact> contacts) {
            super(view);
            this.contacts = contacts;     //for click listener
            this.context = context;       //for clicklistener
            view.setOnClickListener(this);//for click listener
            person_image = view.findViewById(R.id.contact_image);
            person_name = view.findViewById(R.id.person_name);
            person_email = view.findViewById(R.id.person_email);
            person_phone = view.findViewById(R.id.person_phone);
            delete = view.findViewById(R.id.btn_delete);

            /*delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        contacts.remove(position);

                    }

                }
            });*/
        }


        //Whole method for clicklistener

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            contact contact = this.contacts.get(position);
            Intent intent = new Intent(this.context,ContactDetails.class);
            intent.putExtra("img_id",contact.getImage_id());
            intent.putExtra("name",contact.getName());
            intent.putExtra("email",contact.getEmail());
            intent.putExtra("phone",contact.getPhone());
            this.context.startActivity(intent);

        }
    }

}
