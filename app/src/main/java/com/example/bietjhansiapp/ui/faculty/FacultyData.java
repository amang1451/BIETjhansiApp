package com.example.bietjhansiapp.ui.faculty;

public class FacultyData {
    String email,image,key,name,post;

    public FacultyData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public FacultyData(String email, String image, String key, String name, String post) {
        this.email = email;
        this.image = image;
        this.key = key;
        this.name = name;
        this.post = post;
    }
}
