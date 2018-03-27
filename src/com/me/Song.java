package com.me;

//step 1 create this class
public class Song {

    //create fields
    private String title;
    private double duration;

    //step 3 constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;

    }

    //step 4 add getter for title
    public String getTitle() {
        return title;

    }

    //step 5 add an override
    @Override
    public String toString() {
        return this.title + ": " + this.duration;
        //next step 6 create an album class
    }

}
