package com.vicfran.githubrx.data.entity;

import com.google.gson.annotations.SerializedName;

public class RepoEntity {

    @SerializedName("id")
    private int mId;
    @SerializedName("watchers_count")
    private int mWatchers;
    @SerializedName("forks_count")
    private int mForks;
    @SerializedName("size")
    private int mSize;

    @SerializedName("name")
    private String mName;
    @SerializedName("html_url")
    private String mUrl;
    @SerializedName("default_branch")
    private String mDefaultBranch;

    public RepoEntity() {}

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

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public String getDefaultBranch() {
        return mDefaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        mDefaultBranch = defaultBranch;
    }

}
