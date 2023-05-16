import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        PlayList[] playList = null;

        while(true)
        {
            showMenu();

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter what you want to do: ");
            int input = myObj.nextInt();

            if (input == 1)
            {
                Scanner myObj2 = new Scanner(System.in);  
                System.out.println("How many playlist you want to make: ");
                int numberPlayList = myObj2.nextInt();
                playList = new PlayList[numberPlayList];
                int a = 0;

                for (int i = 0; i < numberPlayList; i ++)
                {
                    a = i+1;
                    System.out.println("Enter the infos for PlayList " + a);
                    playList[i] = new PlayList();
                    playList[i].askName();
                    playList[i].askGenre();
                }
            }
            
            if (input == 2)
            {
                getSong();
            }
            
            if (input == 3)
            {
                int a = 0;
                for (int i = 0; i < playList.length; i++)
                {
                    a = i+1;
                    System.out.println("This is playlist " + a);
                    System.out.println("Name: " + playList[i].getName() + " " + "Genre: " + playList[i].getGenre());
                    System.out.println(" ");
                }
            }
        }
    }
    
    public static void getSong()
    {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("\'Print stop when done\'");
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Song name: ");
            String answer = scan.nextLine();
            Songs.setName(answer);
            
            if(answer.equalsIgnoreCase("stop"))
            {
                break;
            }
            
            //Scanner input_genre = new Scanner(System.in);
            System.out.println("Enter artist name: ");
            String genre = scan.nextLine();
            //if
            Songs.setGenre(genre);
            list.add(answer); //needs to be song with song info
        }
    }
    
    public static void showMenu()
    { 
        System.out.println("");
        System.out.println("Main Mene: ");
        System.out.println("---------------------------------------");
        System.out.println("|   Option 1: Create playlist         |");
        System.out.println("|   Option 2: Add songs to playlist   |");
        System.out.println("|   Option 3: Show playlist           |");
        System.out.println("|   Option 7: Exit                    |");
    }

    
}

public class PlayList
{
    private String name;
    private String genre;

    public void askName()
    {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("What is the Name of the PlayList ? ");
        name = myObj.nextLine();
    }

    public void askGenre()
    {
        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("What is the Genre of the PlayList ? ");
        genre = myObj2.nextLine();
    }    

    public String getName()
    {
        return name;
    }

    public String getGenre()
    {
        return genre;
    }
}
