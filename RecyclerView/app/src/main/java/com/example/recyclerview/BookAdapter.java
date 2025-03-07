package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bViewHolder> {

    ArrayList <BookModel> list;

    public BookAdapter(ArrayList<BookModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public bViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_book, parent, false);
        BookAdapter.bViewHolder viewHolder = new BookAdapter.bViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull bViewHolder holder, int position) {
        BookModel model=list.get(position);

        holder.Bauthor.setText(model.getPauthor());
        holder.Bname.setText(model.getBname());
        holder.Bprice.setText(model.getBprice());

        Glide.with(holder.book.getContext()).load(model.getBook()).into(holder.book);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class bViewHolder extends RecyclerView.ViewHolder{

        ImageView book;
        TextView Bname,Bprice,Bauthor;

        public bViewHolder(@NonNull View itemView) {
            super(itemView);

            Bname = itemView.findViewById(R.id.txtBname);
            Bprice = itemView.findViewById(R.id.txtBprice);
            Bauthor = itemView.findViewById(R.id.txtBauthor);
            book = itemView.findViewById(R.id.book);

        }
    }

}
