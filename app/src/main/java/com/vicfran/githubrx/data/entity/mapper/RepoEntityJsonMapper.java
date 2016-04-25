package com.vicfran.githubrx.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.vicfran.githubrx.data.entity.RepoEntity;
import com.vicfran.githubrx.domain.model.Repo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RepoEntityJsonMapper {

    private static Gson mGson = new Gson();

    private RepoEntityJsonMapper() {}

    public static RepoEntity transformRepo(String response) {
        RepoEntity repo = new RepoEntity();

        if (response == null) return repo;
        try {
            Type repoEntityType = new TypeToken<RepoEntity>() {}.getType();
            RepoEntity repoEntity = mGson.fromJson(response, repoEntityType);

            return repoEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    public static List<RepoEntity> transformRepos(String responseJsonList) {
        List<RepoEntity> repos = new ArrayList<>();

        if (responseJsonList == null) return repos;

        try {
            Type repoEntityType = new TypeToken<List<RepoEntity>>() {}.getType();
            repos = mGson.fromJson(responseJsonList, repoEntityType);

            return repos;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
