package com.example.nyt;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView headline;
        public TextView summary;
        public ImageView bookmark;
        public ImageView share;
        public ImageView photo;


        public ViewHolder(View v){
            super(v);
            view = v;
            headline = v.findViewById(R.id.newsHeadline);
            summary = v.findViewById(R.id.newsDetails);
            bookmark = v.findViewById(R.id.newsSaveButton);
            share = v.findViewById(R.id.newsShareButton);
            photo = v.findViewById(R.id.newsPhoto);

        }
    }

    public ArrayList<Article> articleArrayList;
    public ArticleAdapter(ArrayList<Article> arrayList) {
        this.articleArrayList = arrayList;
    }
    private boolean btnState = false;
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        ArticleAdapter.ViewHolder myViewHolder = new ArticleAdapter.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ArticleAdapter.ViewHolder holder, int position) {
        final Article article = this.articleArrayList.get(position);
        holder.headline.setText(article.getHeadline());
        holder.summary.setText(article.getSummary());
        holder.photo.setImageResource(article.getImageDrawableId());



        holder.headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.view.getContext(), ArticleDetailActivity.class);
                intent.putExtra("ID", article.getArticleID());
                holder.view.getContext().startActivity(intent);
            }
        });
        holder.summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.view.getContext(), ArticleDetailActivity.class);
                intent.putExtra("ID", article.getArticleID());
                holder.view.getContext().startActivity(intent);
            }
        });
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.view.getContext(), ArticleDetailActivity.class);
                intent.putExtra("ID", article.getArticleID());
                holder.view.getContext().startActivity(intent);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                        article.getHeadline());
                holder.view.getContext().startActivity(intent);
            }
        });
        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.view.getContext(), "Article Bookmarked", Toast.LENGTH_SHORT).show();
                if (!btnState) {
                    holder.bookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
                } else {
                    holder.bookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                }

                btnState = !btnState;
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }
}




