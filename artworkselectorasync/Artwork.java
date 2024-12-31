package artworkselectorasync;

import java.util.concurrent.atomic.AtomicInteger;

public class Artwork {
    private final int id;
    private final AtomicInteger likes;
    private final AtomicInteger dislikes;

    public Artwork(int id) {
        this.id = id;
        this.likes = new AtomicInteger(0);
        this.dislikes = new AtomicInteger(0);
    }

    public int getId() {
        return id;
    }

    public int getLikes() {
        return likes.get();
    }

    public void like() {
        int newLikes = this.likes.incrementAndGet();
        System.out.println("Thread " + Thread.currentThread().getName() + " liked artwork " + id + ". Total likes: " + newLikes);
    }

    public int getDislikes() {
        return dislikes.get();
    }

    public void dislike() {
        int newDislikes = this.dislikes.incrementAndGet();
        System.out.println("Thread " + Thread.currentThread().getName() + " disliked artwork " + id + ". Total dislikes: " + newDislikes);
    }

    public int getScore() {
        return likes.get() - dislikes.get();
    }
}
