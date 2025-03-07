package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    RecyclerView rcyl;
    ArrayList<BookModel> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcyl = findViewById(R.id.rcyl);

        bookList = new ArrayList<>();

        bookList.add(new BookModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtuphMb4mq-EcVWhMVT8FCkv5dqZGgvn_QiA&s","Book 1","200","Raju"));
        bookList.add(new BookModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtuphMb4mq-EcVWhMVT8FCkv5dqZGgvn_QiA&s","Book 2","200","Raju"));
        bookList.add(new BookModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtuphMb4mq-EcVWhMVT8FCkv5dqZGgvn_QiA&s","Book 3","200","Raju"));
        bookList.add(new BookModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtuphMb4mq-EcVWhMVT8FCkv5dqZGgvn_QiA&s","Book 4","200","Raju"));
        bookList.add(new BookModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtuphMb4mq-EcVWhMVT8FCkv5dqZGgvn_QiA&s","Book 5","200","Raju"));


        BookAdapter adapter = new BookAdapter(bookList);
        rcyl.setAdapter(adapter);
        //rcyl.setLayoutManager(new LinearLayoutManager(this));
        //rcyl.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rcyl.setLayoutManager(new GridLayoutManager(this,2));
        //rcyl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));

    }
}