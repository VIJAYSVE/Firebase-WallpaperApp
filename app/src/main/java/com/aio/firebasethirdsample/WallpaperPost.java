package com.aio.firebasethirdsample;

public class WallpaperPost {
    String link;

    public WallpaperPost() {
    }

    @Override
    public String toString() {
        return "WallpaperPost{" +
                "link='" + link + '\'' +
                '}';
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
