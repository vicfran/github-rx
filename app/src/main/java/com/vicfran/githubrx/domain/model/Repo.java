package com.vicfran.githubrx.domain.model;

public class Repo {

    private int mId;
    private int mWatchers;
    private int mForks;

    private String mName;
    private String mUrl;

    public Repo() {}

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public int getWatchers() {
        return mWatchers;
    }

    public void setWatchers(int watchers) {
        mWatchers = watchers;
    }

    public int getForks() {
        return mForks;
    }

    public void setForks(int forks) {
        mForks = forks;
    }

}
