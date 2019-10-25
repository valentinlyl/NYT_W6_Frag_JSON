package com.example.nyt;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private ArrayList<Article.article> articlesToAdapt;

    public ArticleAdapter() {

    }

    public void setArticlesToAdapt(ArrayList<Article.article> articlesToAdapt) {
        this.articlesToAdapt = articlesToAdapt;
    }

    public ArticleAdapter(ArrayList<Article.article> arrayList){
        this.articlesToAdapt = arrayList;
    }

    public void setData(ArrayList articlesToAdapt){
        this.articlesToAdapt = articlesToAdapt;
    }

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


    private boolean btnState = false;
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        ArticleAdapter.ViewHolder myViewHolder = new ArticleAdapter.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ArticleAdapter.ViewHolder holder, int position) {
        final Article.article article = this.articlesToAdapt.get(position);
        holder.headline.setText(article.getTitle());
        holder.summary.setText(article.get_abstract());

        //holder.photo.setImageResource(article.getImageDrawableId());


        /*
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
        });*/

    }

    @Override
    public int getItemCount() {
        return articlesToAdapt.size();
    }
}




