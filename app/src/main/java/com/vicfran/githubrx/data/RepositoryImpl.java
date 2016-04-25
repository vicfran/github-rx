package com.vicfran.githubrx.data;

import com.vicfran.githubrx.data.datasource.DataSource;
import com.vicfran.githubrx.data.datasource.NetDataSource;
import com.vicfran.githubrx.data.entity.RepoEntity;
import com.vicfran.githubrx.data.entity.mapper.RepoEntityDataMapper;
import com.vicfran.githubrx.domain.RepositoryInterface;
import com.vicfran.githubrx.domain.model.Repo;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class RepositoryImpl implements RepositoryInterface {

    private DataSource mDataSource;

    public RepositoryImpl() {
        mDataSource =  new NetDataSource();
    }

    @Override
    public Observable<List<Repo>> getRepos() {
        return mDataSource.repos().map(new Func1<List<RepoEntity>, List<Repo>>() {
            @Override
            public List<Repo> call(List<RepoEntity> repoEntities) {
                return RepoEntityDataMapper.transform(repoEntities);
            }
        });
    }

}
