package com.example.demo;



import java.time.LocalDateTime;
import java.util.Date;


public class Post {
    public long id;
    public String title;
    public int price;
    public String author;
    public String message;
    public LocalDateTime createAt;
    public LocalDateTime updateAt;

    public Post() {
    }

    public Post(String title, int price, String author, String message) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.message = message;
        this.createAt = LocalDateTime.now();
    }


    public Post(String title, int price, String message) {
        this.price = price;
        this.title = title;
        this.message = message;
        this.updateAt = LocalDateTime.now();
    }

    public Post(String title) {
        this.title = title;
        this.createAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
