package com.vicfran.githubrx.view.presenter;

import com.vicfran.githubrx.domain.model.Repo;
import com.vicfran.githubrx.domain.usecases.DefaultSubscriber;
import com.vicfran.githubrx.domain.usecases.GetReposUseCase;
import com.vicfran.githubrx.domain.usecases.UseCase;
import com.vicfran.githubrx.view.MainActivity;

import java.util.List;

public class RepoListPresenter implements Presenter {

    private UseCase mUseCase;

    private MainActivity mView;

    public RepoListPresenter() {
        mUseCase = new GetReposUseCase();
    }

    public void setView(MainActivity view) {
        mView = view;
    }

    public void loadRepos() {
        mView.showLoading();
        getRepos();
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {
        mUseCase.unsubscribe();
    }

    private void getRepos() {
        mUseCase.execute(new ReposSubscriber());
    }

    private final class ReposSubscriber extends DefaultSubscriber<List<Repo>> {

        @Override
        public void onCompleted() {
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
        }

        @Override
        public void onNext(List<Repo> repos) {
            mView.renderRepos(repos);
        }
    }
}
