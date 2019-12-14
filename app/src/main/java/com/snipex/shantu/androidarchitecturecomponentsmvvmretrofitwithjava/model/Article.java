package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model;

public class Article {

    private String title;
    private String imageHref;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return imageHref;
    }

    public void setUrlToImage(String urlToImage) {
        this.imageHref = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
