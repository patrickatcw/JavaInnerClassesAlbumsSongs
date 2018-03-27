package com.me;

import java.util.ArrayList;
import java.util.LinkedList;

//step 6 create an album class
public class Album {

    //step 7 fields
    private String name;
    private String artist;
    //private ArrayList<Song> songs;
    //step 38 get rid of above and...
    private SongList songs;



    //step 8 constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        //step 9 initialize arrayist
        //this.songs = new ArrayList<Song>();
        //step 39 get rid of above and change to...
        this.songs = new SongList();


    }

    //step 10 method to add song
    public boolean addSong(String title, double duration){
        //step 40 add below this and comment out below that
        return this.songs.add(new Song(title, duration));
        /*if(findSong(title) == null){   //checking if a song already exists
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;*/
    }

    //step 36 cut from here and put below
    //step 11 method to find song
   /* private Song findSong(String title){
        for(Song checkedSong: this.songs) {  //making sure no duplicates
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;

    }*/

    //step 12 method addtoplaylist
    //passing track number and playlist
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        //step 41 remove code below, then add...
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;

        }

        /*int index = trackNumber -1; //b/c array list starts at 0
        if((index >= 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }*/
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //step 13 method addtoplaylist ooverloading
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        //step 42, change below
        Song checkedSong = /*findSong(title);*/songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;

            //step 43 back to main to run

        }

        System.out.println("The song " + title + " is not in the album");
        return false;

        //go to main to test, step 14
    }

    //step 31 for innerclass challenge beginning - method
    private class SongList {

        //step 32 field
        private ArrayList<Song> songs;

        //step 33 constructor
        public SongList() {

            //step 34 initialize arraylist in constructor
            this.songs = new ArrayList<Song>();

        }

        //step 35 method for adding a song
        public boolean add(Song song){

            if(songs.contains(song)){
                return false;
            }

            this.songs.add(song);
            return true;

        }

        //step 36 find song method (from album class to song list class
        private Song findSong(String title){
            for(Song checkedSong: this.songs) {  //making sure no duplicates
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;

        }

        //step 37 method to find song by track number
        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if((index > 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;

        }


    }

}
