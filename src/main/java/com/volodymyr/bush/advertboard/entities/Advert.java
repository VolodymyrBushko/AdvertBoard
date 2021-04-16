package com.volodymyr.bush.advertboard.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String text;
    private String contacts;
    private Date startDate;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    public Advert() {
    }

    public Advert(String category, String text, String contacts, Date startDate, Integer duration) {
        this.category = category;
        this.text = text;
        this.contacts = contacts;
        this.startDate = startDate;
        this.duration = duration;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
