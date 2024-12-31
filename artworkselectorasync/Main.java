package artworkselectorasync;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Количество работ
        ArtworkManager manager = new ArtworkManager(n);

        try {
            // Лайки и дизлайки
            Future<Void> future1 = manager.likeArtwork(0);
            Future<Void> future2 = manager.likeArtwork(0);
            Future<Void> future3 = manager.dislikeArtwork(1);
            Future<Void> future4 = manager.likeArtwork(2);
            Future<Void> future5 = manager.likeArtwork(2);
            Future<Void> future6 = manager.likeArtwork(2);
            Future<Void> future7 = manager.dislikeArtwork(2);
            Future<Void> future8 = manager.likeArtwork(3);
            Future<Void> future9 = manager.dislikeArtwork(3);
            Future<Void> future10 = manager.dislikeArtwork(3);

            // Ожидание завершения всех задач
            future1.get();
            future2.get();
            future3.get();
            future4.get();
            future5.get();
            future6.get();
            future7.get();
            future8.get();
            future9.get();
            future10.get();

            // Получение лучших K работ
            int k = 3;
            Future<List<Artwork>> topKArtworksFuture = manager.getTopKArtworks(k);
            List<Artwork> topKArtworks = topKArtworksFuture.get();

            // Вывод лучших K работ
            System.out.println("Top " + k + " artworks:");
            for (Artwork artwork : topKArtworks) {
                System.out.println("ID: " + artwork.getId() + ", Score: " + artwork.getScore());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            manager.shutdown();
        }
    }
}