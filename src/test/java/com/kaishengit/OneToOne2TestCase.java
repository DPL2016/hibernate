package com.kaishengit;

import com.kaishengit.pojo.Topic;
import com.kaishengit.pojo.TopicContent;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOne2TestCase {

    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Topic topic = new Topic();
        topic.setTitle("Hello");
        TopicContent topicContent = new TopicContent();
        topicContent.setContent("Hello,124r54t4");
        topic.setTopicContent(topicContent);
        session.save(topic);
        session.save(topicContent);

        session.getTransaction().commit();
    }


    @Test
    public void testFind(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Topic topic = (Topic) session.get(Topic.class,3);
        System.out.println(topic.getTitle());
        session.getTransaction().commit();

    }
}
