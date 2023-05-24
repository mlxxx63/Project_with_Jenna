public class Song 
{
    private String link;
    private String artist;
    private String name;

    public Song() 
    {
    }

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
}
