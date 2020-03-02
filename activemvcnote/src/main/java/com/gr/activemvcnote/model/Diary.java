package com.gr.activemvcnote.model;

import androidx.annotation.NonNull;

import com.gr.activemvcnote.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-29
 **/
public class Diary {

    private String id;
    private String title;
    private String description;

    private List<Observer<Diary>> mObserverList;

    public String getId() {
        return id;
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

    public Diary(@NonNull String title,@NonNull String description){
        this(title,description, UUID.randomUUID().toString());
    }

    public Diary(@NonNull String title, @NonNull String description,@NonNull String id) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void registerObserver(Observer<Diary> observer){
        getObservers().add(observer);
    }

    public void notifyObservers(){
        for(Observer<Diary> observer : getObservers()){
            observer.update(this);
        }
    }

    private List<Observer<Diary>> getObservers(){
        if(mObserverList == null){
            mObserverList = new ArrayList<>();
        }
        return mObserverList;
    }
}
