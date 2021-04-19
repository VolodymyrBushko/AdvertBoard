package com.volodymyr.bush.advertboard.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Advert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String text;
    private String contacts;
    private Integer duration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Transient
    private Long userId;

    public Advert() {
    }

    public Advert(String category, String text, String contacts, Date startDate, Integer duration, Long userId) {
        this.category = category;
        this.text = text;
        this.contacts = contacts;
        this.startDate = startDate;
        this.duration = duration;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return Objects.equals(id, advert.id) && Objects.equals(category, advert.category) && Objects.equals(text, advert.text) && Objects.equals(contacts, advert.contacts) && Objects.equals(startDate, advert.startDate) && Objects.equals(duration, advert.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, text, contacts, startDate, duration);
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", text='" + text + '\'' +
                ", contacts='" + contacts + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }
}
