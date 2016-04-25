package com.vicfran.githubrx.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vicfran.githubrx.R;
import com.vicfran.githubrx.domain.model.Repo;
import com.vicfran.githubrx.domain.usecases.GetReposUseCase;
import com.vicfran.githubrx.view.presenter.RepoListPresenter;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private TextView mReposTextView;
    private ProgressBar mProgressBar;

    private RepoListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mReposTextView = (TextView) findViewById(R.id.lbl_repos);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        mPresenter = new RepoListPresenter();
        mPresenter.setView(this);

        loadReposData();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }

    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void renderRepos(Collection<Repo> repos) {
        if (repos == null) return;

        String text = "";
        for (Repo repo : repos) {
            text += renderRepo(repo) + "\n";
        }

        mReposTextView.setText(text);
    }

    private String renderRepo(Repo repo) {
        if (repo == null) return "";

        String repoString = "";

        repoString += repo.getName() + "\n";
        repoString += repo.getUrl() + "\n";
        repoString += repo.getUrl() + "\n";

        return repoString;
    }

    private void loadReposData() {
        mPresenter.loadRepos();
    }
}
