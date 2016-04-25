package com.vicfran.githubrx.domain.usecases;

import com.vicfran.githubrx.data.RepositoryImpl;
import com.vicfran.githubrx.domain.RepositoryInterface;

import rx.Observable;

public class GetReposUseCase extends UseCase {

    private final RepositoryInterface mRepository;

    public GetReposUseCase() {
        super();
        mRepository = new RepositoryImpl();
    }

    @Override public Observable buildUseCaseObservable() {
        return mRepository.getRepos();
    }
}
