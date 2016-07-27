package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_topic_content")
public class TopicContent implements Serializable {
    private static final long serialVersionUID = -2067401473353899423L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
