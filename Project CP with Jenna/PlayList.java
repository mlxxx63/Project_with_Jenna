import java.util.ArrayList;
import java.util.Scanner;

public class PlayList 
{
    private ArrayList<Song> playList;
    private String name;
    private String genre;

    public PlayList() 
    {
        playList = new ArrayList<>();
    }
    
    // Mr. Bragg says: There's no change in the setters, they remain the same.
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

    // Mr. Bragg says: There's no change in the getters, they remain the same.
    public String getName() 
    {
        return name;
    }

    public String getGenre() 
    {
        return genre;
    }

    // Mr. Bragg says: We've removed the line where we were closing the scanner. Closing should only be done once, ideally in the main method.
    public void addSong(int numSongs, Scanner scan) 
    {
        System.out.println("Enter artist name: ");
        String artistName = scan.nextLine();
        

        System.out.println("Enter Song name: ");
        String songName = scan.nextLine();

        System.out.println("Enter song link: ");
        String songLink = scan.nextLine();

        Song newSong = new Song();
        newSong.setName(songName);
        newSong.setArtist(artistName);
        newSong.setLink(songLink);

        playList.add(newSong);
    }

    // Mr. Bragg says: There's no change in the following methods, they remain the same.
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

    public Song getSongByIndex(int index) 
    {
        return playList.get(index);
    }

    public ArrayList<Song> getSongList() 
    {
        return playList;
    }

    public void clear() 
    {
        playList.removeAll(playList);
    }
}
