import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

// main fuction to run the code
public class App 
{
    // An ArrayList that hold the playList ArrayList
    public static ArrayList<PlayList> albumn = new ArrayList<>();

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        // Create a Scanner object
        
    // In this while loop, the user can make choices of what they want to do 
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
    
     // show the text base of what this program can do
    public static void showMenu() 
    {
        System.out.println("");
        System.out.println("Main Menu: ");
        System.out.println("-------------------------------------------------");
        System.out.println("|   Option 1: Create playlists                   |");
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
            
             // enter the information of the playlist 
            for (int i = 0; i < numberPlaylists; i++) {
                System.out.println("Enter the info for Playlist " + (i + 1));
                 // add the playList ArrrayList to the albumn ArrayList 
                albumn.add(new PlayList());
               /* call out the setName method for the user to enter infos,
               *and then it gets added to playList then albumn
               */
                albumn.get(i).setName(scan);
                 /* call out the setGenre method for the user to enter infos,
                 *and then it gets added to playList then albumn
                 */
                albumn.get(i).setGenre(scan);
                System.out.println(" ");
            }
        // Print out the infos that was just inputed 
        System.out.println("Playlists created:");
        for(int i = 0; i < albumn.size(); i++) 
        {
            System.out.println("Playlist " + (i + 1) + ": " + albumn.get(i).getName());
        }
        
    }
    // Print out the albumn (prints put the playlist information)
    public static void showPlaylists() 
    {
        for (int i = 0; i < albumn.size(); i++) {
             // initialize a varible playlist type PlayList = to albumn.get(i)
            PlayList playlist = albumn.get(i); 
            // initialize a varible songs = to playlist.getSongList()
            ArrayList<Song> songs = playlist.getSongList(); 

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
                    System.out.println(j.toString());
                }
            }
            System.out.println();
        }
    }
     // add songs to the playList Array
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
             /*its (choice -1) because of the index in ArrayList, 
             *numSongs is added to the method addSong
             *because we only want to make a certain amount of songs 
             */
            albumn.get(choice - 1).addSong(numSongs, scan);
            System.out.println(" ");
        }
        
        
    }
    //the purpose is to save the ArrayList albumn to a text file 
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
                    printWriter.println(j.toString());
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
    
    // allow the user to change the infos of the PlayList 
    public static void editPlaylistDetails(Scanner scan) {
        System.out.println("Enter the playlist index you want to edit: ");
        int playlistIndex = scan.nextInt();
        scan.nextLine();

        /* if and else logic serves the purpose of making sure
        *the user enter the right input*/
        
        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) 
        {
             // initialize a varible playlist type PlayList = 
             //to albumn.get(playlistIndex - 1)
            PlayList playlist = albumn.get(playlistIndex - 1);
            System.out.println("Current details for Playlist " + playlistIndex);
            System.out.println("Name: " + playlist.getName());
            System.out.println("Genre: " + playlist.getGenre());

            System.out.println("Enter the updated name (press Enter to skip): ");
            String name = scan.nextLine();
            if(name.isEmpty()==false)
            {
                playlist.setNewName(name);
            }
            
            System.out.println("Enter the updated genre (press Enter to skip): ");
            String genre = scan.nextLine();
            if(genre.isEmpty()==false){
                playlist.setNewGenre(genre);
            }

            System.out.println("Playlist details updated successfully!");
        } 
        else 
        {
            System.out.println("Invalid playlist index!");
        }
    }

    // remove song from a specific playlist
    public static void removeSongsFromPlaylist(Scanner scan) {

        System.out.println("Enter the playlist index to remove songs from: ");
        int playlistIndex = scan.nextInt();
        

        if (playlistIndex >= 1 && playlistIndex <= albumn.size()) 
        {
            PlayList playlist = albumn.get(playlistIndex - 1);
            ArrayList<Song> songs = playlist.getSongList();
             
             // if the Array is empty then nothing happen
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
               
                 // this codes resulted in deleting a chosen song 
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
                    // clear function resulted in every elements in the array getting cleared 
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
