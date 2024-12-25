package artworksselector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArtworkManager {
    private List<Artwork> artworks;

    public ArtworkManager(int n) {
        artworks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            artworks.add(new Artwork(i));
        }
    }

    public void likeArtwork(int id) {
        if (id >= 0 && id < artworks.size()) {
            artworks.get(id).like();
        } else {
            throw new IllegalArgumentException("Invalid artwork ID");
        }
    }

    public void dislikeArtwork(int id) {
        if (id >= 0 && id < artworks.size()) {
            artworks.get(id).dislike();
        } else {
            throw new IllegalArgumentException("Invalid artwork ID");
        }
    }

    public List<Artwork> getTopKArtworks(int k) {
        return artworks.stream()
                .sorted(Comparator.comparingInt(Artwork::getScore).reversed())
                .limit(k)
                .toList();
    }
}
