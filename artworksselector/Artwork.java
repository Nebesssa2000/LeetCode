package artworksselector;

public class Artwork {
    private int id;
    private int likes;
    private int dislikes;

    public Artwork(int id) {
        this.id = id;
        this.likes = 0;
        this.dislikes = 0;
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public void like() {
        this.likes++;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void dislike() {
        this.dislikes++;
    }

    public int getScore() {
        return likes - dislikes;
    }
}
