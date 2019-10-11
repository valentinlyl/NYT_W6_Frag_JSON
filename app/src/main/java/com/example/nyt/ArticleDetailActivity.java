package com.example.nyt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Intent receivedIntent = getIntent();
        int numReceived = receivedIntent.getIntExtra("ID", 0);

        TextView headlineTextView = findViewById(R.id.detailHeadline);
        TextView authorTextView = findViewById(R.id.detailAuthor);
        TextView contentTextView = findViewById(R.id.detailContent);
        ImageView imageView = findViewById(R.id.detailImage);

        headlineTextView.setText(FakeDatabase.getArticleById(numReceived).getHeadline());
        authorTextView.setText(FakeDatabase.getArticleById(numReceived).getAuthor());
        contentTextView.setText(FakeDatabase.getArticleById(numReceived).getContent());
        imageView.setImageResource(FakeDatabase.getArticleById(numReceived).getImageDrawableId());

    }
}
