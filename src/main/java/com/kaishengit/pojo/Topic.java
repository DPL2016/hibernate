package com.kaishengit.pojo;


import java.io.Serializable;

public class Topic implements Serializable{
    private static final long serialVersionUID = -3446732322759664054L;
    private Integer id;
    private String title;
    private TopicContent topicContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TopicContent getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(TopicContent topicContent) {
        this.topicContent = topicContent;
    }
}
