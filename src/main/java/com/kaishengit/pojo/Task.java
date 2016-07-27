package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by D on 2016/7/27.
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 1853048827580587983L;
    private String id;
    private String title;

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
}
