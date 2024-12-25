package artworksselector;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Количество работ
        ArtworkManager manager = new ArtworkManager(n);

        // Лайки и дизлайки
        manager.likeArtwork(0);
        manager.likeArtwork(0);
        manager.dislikeArtwork(1);
        manager.likeArtwork(2);
        manager.likeArtwork(2);
        manager.likeArtwork(2);
        manager.dislikeArtwork(2);
        manager.likeArtwork(3);
        manager.dislikeArtwork(3);
        manager.dislikeArtwork(3);

        // Получение лучших K работ
        int k = 3;
        List<Artwork> topKArtworks = manager.getTopKArtworks(k);

        // Вывод лучших K работ
        System.out.println("Top " + k + " artworks:");
        for (Artwork artwork : topKArtworks) {
            System.out.println("ID: " + artwork.getId() + ", Score: " + artwork.getScore());
        }
    }
}
