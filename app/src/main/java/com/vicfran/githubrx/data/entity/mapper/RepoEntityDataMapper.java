package com.vicfran.githubrx.data.entity.mapper;

import com.vicfran.githubrx.data.entity.RepoEntity;
import com.vicfran.githubrx.domain.model.Repo;

import java.util.ArrayList;
import java.util.List;

public class RepoEntityDataMapper {
    
    private RepoEntityDataMapper() {}

    public static Repo transform(RepoEntity entity) {
        Repo repo = new Repo();

        if (entity == null) return repo;

        repo.setId(entity.getId());
        repo.setWatchers(entity.getWatchers());
        repo.setForks(entity.getForks());
        repo.setName(entity.getName());
        repo.setUrl(entity.getUrl());

        return repo;
    }

    public static List<Repo> transform(List<RepoEntity> entities) {
        List<Repo> repos = new ArrayList<>();

        if (entities == null) return repos;

        for (RepoEntity entity : entities) {
            repos.add(transform(entity));
        }

        return repos;
    }
}
