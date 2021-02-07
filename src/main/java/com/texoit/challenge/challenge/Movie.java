package com.texoit.challenge.challenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int year;
    private String title;
    private String studios;
    private String producer;
    private Boolean winner;

    public Movie(){

    }

    public Movie(int year, String title, String studios, String producer, Boolean winner){
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producer = producer;
        this.winner = winner;
    }
    

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    public String getProducer() {
        return producer;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getStudios() {
        return studios;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Boolean getWinner() {
        return winner;
    }

}
