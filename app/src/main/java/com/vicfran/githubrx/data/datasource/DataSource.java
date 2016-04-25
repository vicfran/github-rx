package com.vicfran.githubrx.data.datasource;

import com.vicfran.githubrx.data.entity.RepoEntity;

import java.util.List;

import rx.Observable;

public interface DataSource {

    Observable<List<RepoEntity>> repos();

}
