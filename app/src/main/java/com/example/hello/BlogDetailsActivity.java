package com.example.hello;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class BlogDetailsActivity extends AppCompatActivity {
    public ImageView imageMain;
    public ImageView imageAvatar;
    public TextView textTitle;
    public TextView textDate;
    public TextView textAuthor;
    public TextView textRating;
    public TextView textViews;
    public TextView textDescription;
    public RatingBar ratingBar;
    public ImageView imageBack;

     public static final String Image_Url="https://images.dog.ceo/breeds/kuvasz/n02104029_4492.jpg";
    public static final String Avatar_Url="https://images.dog.ceo/breeds/dalmatian/cooper2.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);

    imageMain=findViewById(R.id.imageMain);
    Glide.with(this).load(Image_Url).transition(DrawableTransitionOptions.withCrossFade()).into(imageMain);
//        imageMain.setImageResource(R.drawable.scenery);

        imageAvatar=findViewById(R.id.imageAvatar);
        Glide.with(this).load(Avatar_Url).transform(new CircleCrop()).transition(DrawableTransitionOptions.withCrossFade()).into(imageAvatar);
//        imageAvatar.setImageResource(R.drawable.vro);

        imageBack=findViewById(R.id.imageView);
        imageBack.setOnClickListener(v->finish());

        textTitle=findViewById(R.id.textTitle);
        textTitle.setText("G'day from sydney");

        textDate=findViewById(R.id.textDate);
        textDate.setText("September 20, 2021");

        textAuthor=findViewById(R.id.textAuthor);
        textAuthor.setText("Grayson Wells");

        textRating=findViewById(R.id.textRating);
        textRating.setText("4.4");

        textViews = findViewById(R.id.textRating);
        textViews.setText("(2687 views)");

        textDescription=findViewById(R.id.textDescription);
        textDescription.setText("Australia is one of the most popular travel destinations in th world");

        ratingBar=findViewById(R.id.ratingBar);
        ratingBar.setRating(4.4f);

    }


}
