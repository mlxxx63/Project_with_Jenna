import java.util.ArrayList;
import java.util.Scanner;

public class PlayList 
{
    // create an ArrayList with Song type (class Song)
    private ArrayList<Song> playList;
    private String name;
    private String genre;

 // setting constructor (when ever we make an Object,
 //a new ArrayList is created)
    public PlayList() 
    {
        playList = new ArrayList<>();
    }
    
    // setter methods (asking for the user's input)
    public void setName(Scanner scan) 
    {
        System.out.println("What is the Name of the PlayList? ");
        name = scan.nextLine();
    }

    public void setGenre(Scanner scan) 
    {
        System.out.println("What is the Genre of the PlayList? ");
        genre = scan.nextLine();
    }
    
    //new setters
    public void setNewName(String str)
    {
        name = str;
    }

    public void setNewGenre(String str)
    {
        genre = str;
    }

    // getter methods 
    public String getName() 
    {
        return name;
    }

    public String getGenre() 
    {
        return genre;
    }

    // Mr. Bragg says: We've removed the line where we were closing the scanner.
    //Closing should only be done once, ideally in the main method.
    // method add songs to the ArrayList playList 
    public void addSong(int numSongs, Scanner scan) 
    {
         // asking for user's inputs for song name, artist, link 
        System.out.println("Enter artist name: ");
        String artistName = scan.nextLine();
        

        System.out.println("Enter Song name: ");
        String songName = scan.nextLine();

        System.out.println("Enter song link: ");
        String songLink = scan.nextLine();
        
        //doesn't create the song if any of requirments aren't fullfilled
         if (songName.isEmpty() || artistName.isEmpty() || songLink.isEmpty())
        {
            System.out.println("Invalid input. Song not created.");
            return;
        }
        
        else if(songLink.contains("youtu.be")|| songLink.contains("youtube"))
        {
            Song newSong = new Song();
            newSong.setName(songName);
            newSong.setArtist(artistName);
            newSong.setLink(songLink);
            
            // add the song object to the ArrayList playList 
            playList.add(newSong);
        }
        
        else{
            System.out.println("Invalid input. Song not created.");
            return;
        }
    }

     // remove song function
    public void removeSong(int index) 
    {
        if (index >= 0 && index < playList.size()) 
        {
            playList.remove(index);
            System.out.println("Song removed from the playlist.");
        } 
        else 
        {
            System.out.println("Invalid song index.");
        }
    }
    // return the song that is relavant to the index
    public Song getSongByIndex(int index) 
    {
        return playList.get(index);
    }
    
    // return the ArrayList playList 
    public ArrayList<Song> getSongList() 
    {
        return playList;
    }

    // removeAll is the function which removes 
    //all the elements in that Array List 
    public void clear() 
    {
        playList.removeAll(playList);
    }
}
