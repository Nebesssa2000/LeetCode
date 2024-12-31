package artworkselectorasync;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ArtworkManager {
    private final List<Artwork> artworks;
    private final ExecutorService executor;

    public ArtworkManager(int n) {
        artworks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            artworks.add(new Artwork(i));
        }
        executor = Executors.newFixedThreadPool(4); // Пул потоков
    }

    public Future<Void> likeArtwork(int id) {
        return executor.submit(new Callable<Void>() {
            @Override
            public Void call() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is processing like for artwork " + id);
                if (id >= 0 && id < artworks.size()) {
                    artworks.get(id).like();
                } else {
                    throw new IllegalArgumentException("Invalid artwork ID");
                }
                return null;
            }
        });
    }

    public Future<Void> dislikeArtwork(int id) {
        return executor.submit(new Callable<Void>() {
            @Override
            public Void call() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is processing dislike for artwork " + id);
                if (id >= 0 && id < artworks.size()) {
                    artworks.get(id).dislike();
                } else {
                    throw new IllegalArgumentException("Invalid artwork ID");
                }
                return null;
            }
        });
    }

    public Future<List<Artwork>> getTopKArtworks(int k) {
        return executor.submit(new Callable<List<Artwork>>() {
            @Override
            public List<Artwork> call() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is processing getTopKArtworks for top " + k);
                return artworks.stream()
                        .sorted(Comparator.comparingInt(Artwork::getScore).reversed())
                        .limit(k)
                        .toList();
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}