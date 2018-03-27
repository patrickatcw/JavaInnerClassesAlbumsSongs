package com.me;

/*
from linked list exercise
- modify the playlist challenge so that the album clss uses an inner class
instead of using an arraylist to hold its tracks, it will use an inner class called songlist
- the inner songlist class will use an arraylist and will provide a method to add a song
- it will also provide findsong() methods which will be used by the containing album class
to add songs to the playlist.
- neither the song class or the main class should be changed
 */

import java.util.*;

public class Main {

    //step 16 instance creating arraylist
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        //step 14 instance, creating a new object
        Album album = new Album("Stormbringer", "Deep Purple");

        //step 15 calling method to add songs
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);

        //step 17 calling method to add album
        albums.add(album);

        //step 18 adding another album, creating a new object
        album = new Album("For Those About to Rock", "AC/DC");

        //step 19 add songs calling method
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Let's go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);

        //step 20 calling method to add album
        albums.add(album);

        //step 21 creating a linkedlist of playlist
        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); //no track 24, should produce message

        //step 22 calling playlist method
        play(playList);

    }

    //step 23 make play method
    private static void play(LinkedList<Song> playList) {
        //step 25
        Scanner scanner = new Scanner(System.in);   //add scanner above
        boolean quit = false;
        boolean forward = true;  //end of step 25

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size()==0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());

            //step 27 calling printmenu method, step 28 make it below
            printMenu();


            //step 24 run

        }

        //step 26
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list.");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();  //in step 27 call this method in play method
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }

        }

    }

    //step 28 create printMenu method
    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist.");

    }

    //step 29 printList method
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------");

        //step 30 run

    }

}

