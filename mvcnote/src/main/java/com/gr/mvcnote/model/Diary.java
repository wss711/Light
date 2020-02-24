package com.gr.mvcnote.model;

import androidx.annotation.NonNull;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-24
 **/
public class Diary {

    private String id;
    private String title;
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Diary(@NonNull String title, @NonNull String description) {
        this.title = title;
        this.description = description;
    }

    public Diary(@NonNull String id, @NonNull String title, @NonNull String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
