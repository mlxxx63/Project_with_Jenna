public class PlayList 
{
    private ArrayList<Song> playList;
    private String name;
    private String genre;

    public PlayList() 
    {
        playList = new ArrayList<>();
    }

    public void setName() 
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is the Name of the PlayList? ");
        name = myObj.nextLine();
    }

    public void setGenre() 
    {
        Scanner myObj2 = new Scanner(System.in);
        System.out.println("What is the Genre of the PlayList? ");
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

    public void addSong(int numSongs) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Song name: ");
        String songName = scan.nextLine();

        System.out.println("Enter artist name: ");
        String artistName = scan.nextLine();

        System.out.println("Enter song link: ");
        String songLink = scan.nextLine();

        Song newSong = new Song();
        newSong.setName(songName);
        newSong.setArtist(artistName);
        newSong.setLink(songLink);

        playList.add(newSong);

    }
