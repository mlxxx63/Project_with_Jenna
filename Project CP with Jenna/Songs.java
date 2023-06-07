public class Song 
{
    // Class Variables
    private String link;
    private String artist;
    private String name;

    public Song() 
    {
    }
    
    //setter methods
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setArtist(String artist) 
    {
        this.artist = artist;
    }

    public void setLink(String link) 
    {
        this.link = link;
    }

    //getter methods
    public String getLink() 
    {
        return link;
    }

    public String getArtist() 
    {
        return artist;
    }

    public String getName() 
    {
        return name;
    }
    
    //toString method
    public String toString()
    {
    return "Song: " + name + ", Artist: " + artist + ", Link: " + link;
    }
}
