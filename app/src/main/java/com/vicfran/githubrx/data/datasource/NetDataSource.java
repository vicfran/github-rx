package com.vicfran.githubrx.data.datasource;

import com.vicfran.githubrx.data.entity.RepoEntity;
import com.vicfran.githubrx.data.net.Api;
import com.vicfran.githubrx.data.net.ApiClient;

import java.util.List;

import rx.Observable;

public class NetDataSource implements DataSource {

    private Api mApi;

    public NetDataSource() {
        mApi = new ApiClient();
    }

    @Override
    public Observable<List<RepoEntity>> repos() {
        return mApi.repos();
    }

}
