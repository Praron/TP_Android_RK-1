package com.example.sleepless.rk1_news_app;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

public class MainActivity extends AppCompatActivity implements ArticleFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticleListFragment articleList = new ArticleListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, articleList).commit();

        articleList.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                Bundle b = new Bundle();
                b.putString("title", article.getTitle());
                b.putString("content", article.getContent());
                b.putString("date", article.getDate().toString());

                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArguments(b);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, articleFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
