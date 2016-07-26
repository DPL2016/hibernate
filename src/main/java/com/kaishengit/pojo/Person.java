package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by D on 2016/7/26.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = -1126022037726514305L;
    private Integer id;
    private String name;
    private Card card;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
