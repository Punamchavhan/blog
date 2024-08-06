package com.example.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.LocalDateTime;


@Entity

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titles;
    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    private User author;

    //getters and setters

    public Long getId(){
        return id;

    }
   public void setId(Long id){
    this.id= id;

   }
   public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public User getAuthor() {
    return author;
}

public void setAuthor(User author) {
    this.author = author;
}


}
