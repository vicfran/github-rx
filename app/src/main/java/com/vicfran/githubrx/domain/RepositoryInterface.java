package com.vicfran.githubrx.domain;

import com.vicfran.githubrx.domain.model.Repo;

import java.util.List;

import rx.Observable;

public interface RepositoryInterface {

    Observable<List<Repo>> getRepos();

}
