package com.vicfran.githubrx.data.net;

import com.vicfran.githubrx.data.entity.RepoEntity;

import java.util.List;

import rx.Observable;

public interface Api {

    String BASE_URL = "https://api.github.com/users/vicfran/";

    String REPOS_URL = BASE_URL + "repos";

    Observable<List<RepoEntity>> repos();
}
