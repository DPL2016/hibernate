package com.kaishengit.pojo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by D on 2016/7/26.
 */
@Entity
@Table(name = "t_card")
public class Card {
    @Id
    @GenericGenerator(name = "fk",strategy = "foreign",
            parameters =@Parameter(name = "property",value = "person"))
    @GeneratedValue(generator = "fk")
    private Integer id;
    private String cardname;
    @OneToOne(mappedBy = "card")
    @PrimaryKeyJoinColumn
    private Person person;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardname='" + cardname + '\'' +
                ", person=" + person +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
