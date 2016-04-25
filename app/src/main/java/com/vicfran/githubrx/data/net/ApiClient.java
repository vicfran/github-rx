package com.vicfran.githubrx.data.net;

import android.content.Context;

import com.vicfran.githubrx.GithubRxApplication;
import com.vicfran.githubrx.data.entity.RepoEntity;
import com.vicfran.githubrx.data.entity.mapper.RepoEntityJsonMapper;

import java.net.MalformedURLException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class ApiClient implements Api {
    
    private final Context mContext;

    public ApiClient() {
        mContext = GithubRxApplication.getContext();
    }

    @Override
    public Observable<List<RepoEntity>> repos() {
        return Observable.create(new Observable.OnSubscribe<List<RepoEntity>>() {
            @Override
            public void call(Subscriber<? super List<RepoEntity>> subscriber) {
                try {
                    String response = getReposFromApi();
                    if (response != null) {
                        subscriber.onNext(RepoEntityJsonMapper.transformRepos(response));
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e.getCause());
                }
            }
        });
    }

    private String getReposFromApi() throws MalformedURLException {
        return ApiConnection.createGET(Api.REPOS_URL).requestSyncCall();
    }

}
