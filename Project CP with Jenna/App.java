import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class App 
{
    public static ArrayList<PlayList> albumn = new ArrayList<>();

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        while(true)
        {
            showMenu();

            System.out.println("Enter what you want to do: ");
            int input = scan.nextInt();
            scan.nextLine(); // Mr. Bragg says: consume the newline character left by nextInt
            
            if (input == 1)
            {
                createPlaylists(scan);
            }

            if (input == 2)
            {
                showPlaylists();
            }

            if (input == 3)
            {
                addSongsToPlaylist(scan);
            }

            if (input == 4)
            {
                removeSongsFromPlaylist(scan);
            }

            if(input == 5)
            {
                editPlaylistDetails(scan);
            }

            if(input == 6)
            {
                savePlaylistsToFile();
            }

            if(input == 7)
            {
                clearPlaylist(scan);
            }
            
            if(input == 8)
            {
                break; // Mr. Bragg says: add a break to exit the infinite loop
            }
        
        }
            // Mr. Bragg says: We've moved the scanner close method here. 
            // It should only be closed once, and that should be at the end of the main method.
            scan.close();
    }

    public static void showMenu() 
    {
        System.out.println("");
        System.out.println("Main Menu: ");
        System.out.println("-------------------------------------------------");
        System.out.println("|   Option 1: Create album and playlists         |");
        System.out.println("|   Option 2: Show playlists                     |");
        System.out.println("|   Option 3: Add new songs to a playlist        |");
        System.out.println("|   Option 4: Remove songs from a playlist       |");
        System.out.println("|   Option 5: Edit playlist details              |");
        System.out.println("|   Option 6: Save playlists to a file           |");
        System.out.println("|   Option 7: clear all songs from a playlist    |");
        System.out.println("|   Option 8: Exit                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void createPlaylists(Scanner scan) {
        System.out.println(" ");
        
            System.out.println("How many playlists do you want to create: ");
            int numberPlaylists = scan.nextInt();
            scan.nextLine();  // TB says: This will consume the leftover newline character.
            System.out.println(" ");

            for (int i = 0; i < numberPlaylists; i++) {
                System.out.println("Enter the info for Playlist " + (i + 1));
                albumn.add(new PlayList());
                albumn.get(i).setName(scan);
                albumn.get(i).setGenre(scan);
                System.out.println(" ");
            }
        
        System.out.println("Playlists created:");
        for(int i = 0; i < albumn.size(); i++) 
        {
            System.out.println("Playlist " + (i + 1) + ": " + albumn.get(i).getName());
        }
        
    }

    public static void showPlaylists() 
    {
        for (int i = 0; i < albumn.size(); i++) {
            PlayList playlist = albumn.get(i);  // initialize a varible playlist type PlayList = to albumn.get(i)
            ArrayList<Song> songs = playlist.getSongList();  // initialize a varible songs = to play playlist.getSongList()

            System.out.println("This is playlist " + (i + 1));
            System.out.println("Name: " + playlist.getName());
            System.out.println("Genre: " + playlist.getGenre());
        
            if (songs.isEmpty()) 
            {
                System.out.println("No songs added to this playlist yet!");
            } 
            else 
            {
                System.out.println("Songs:");
                for (Song j : songs) 
                {   // for int j
                    System.out.println("Song: " + j.getName() + ", Artist: " + j.getArtist() + ", Link: " + j.getLink());
                }
            }
            System.out.println();
        }
    }

    public static void addSongsToPlaylist(Scanner scan) 
    {
        System.out.println("Which playlist do you want to add new song(s) to?");
        int choice = scan.nextInt();
        
        System.out.println("How many songs do you want to add?");
        int numSongs = scan.nextInt();
        scan.nextLine();
        
        System.out.println(" ");
        for (int i = 0; i < numSongs; i++) 
        {
            System.out.println("Enter the details for song " + (i + 1));
            albumn.get(choice - 1).addSong(numSongs, scan);
            System.out.println(" ");
        }
        
        
    }

    public static void savePlaylistsToFile() {
        try {
            FileWriter fileWriter = new FileWriter("savefile.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (PlayList playlist : albumn) 
            {
                printWriter.println("Name: " + playlist.getName() + ", Genre: " + playlist.getGenre());
                ArrayList<Song> songs = playlist.getSongList();
                for (Song j : songs) 
                {
                    printWriter.println("Song: " + j.getName() + ", Artist: " + j.getArtist() + ", Link: " + j.getLink());
                }
                printWriter.println();
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("Playlists saved to file successfully!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void editPlaylistDetails(Scanner scan) {
        System.out.println("Enter the playlist index you want to edit: ");
        int playlistIndex = scan.nextInt();
        scan.nextLine();

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) 
        {
            PlayList playlist = albumn.get(playlistIndex - 1);
            System.out.println("Current details for Playlist " + playlistIndex);
            System.out.println("Name: " + playlist.getName());
            System.out.println("Genre: " + playlist.getGenre());

            System.out.println("Enter the updated name (press Enter to skip): ");
            playlist.setName(scan);

            System.out.println("Enter the updated genre (press Enter to skip): ");
            playlist.setGenre(scan);

            System.out.println("Playlist details updated successfully!");
        } 
        else 
        {
            System.out.println("Invalid playlist index!");
        }
    }

    public static void removeSongsFromPlaylist(Scanner scan) {

        System.out.println("Enter the playlist index to remove songs from: ");
        int playlistIndex = scan.nextInt();
        

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) 
        {
            PlayList playlist = albumn.get(playlistIndex - 1);
            ArrayList<Song> songs = playlist.getSongList();

            if (songs.isEmpty()) 
            {
                System.out.println("No songs in the playlist to remove!");
            } 
            else 
            {
                System.out.println("Current songs in Playlist " + playlistIndex + ":");
                for (int i = 0; i < songs.size(); i++) 
                {
                    System.out.println((i + 1) + ". Song: " + songs.get(i).getName() + ", Artist: " + songs.get(i).getArtist());
                }

                System.out.println("Enter the index of the song to remove: ");
                int songIndex = scan.nextInt();
               

                if (songIndex >= 1 && songIndex <= songs.size()) 
                {
                    playlist.removeSong(songIndex - 1);
                    System.out.println("Song removed successfully!");
                } 
                else 
                {
                    System.out.println("Invalid song index!");
                }
            }
        } else 
        {
            System.out.println("Invalid playlist index!");
        }
    }
    

    public static void clearPlaylist(Scanner scan) 
    {
        System.out.println("Enter the playlist index to clear: ");
        int playlistIndex = scan.nextInt();
        scan.nextLine();
    
        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) 
        {
            PlayList playlist = albumn.get(playlistIndex - 1);
            ArrayList<Song> songs = playlist.getSongList();
    
            if (songs.isEmpty()) 
            {
                System.out.println("The playlist is already empty!");
            } 

            else 
            {
                System.out.println("Are you sure you want to clear the playlist? (yes/no)");
                String confirmation = scan.nextLine();

    
                if (confirmation.equalsIgnoreCase("yes")) 
                {
                    playlist.clear();
                    System.out.println("Playlist cleared successfully!");
                } 
                else 
                {
                    System.out.println("Clear operation canceled.");
                }
            }
        }
        else 
        {
            System.out.println("Invalid playlist index!");
        }
    }
}
    

