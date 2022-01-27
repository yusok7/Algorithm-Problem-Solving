package programmers.levelthree;

import java.util.*;
import java.io.*;

public class BestAlbum {

    static class Song implements Comparable<Song> {
        String genre;
        int play;
        int id;

        public Song(String genre, int play, int id) {
            this.genre = genre;
            this.play = play;
            this.id = id;
        }

        @Override
        public int compareTo(Song o) {
            if (this.genre.equals(o.genre)) {
                return -(Integer.compare(this.play, o.play));
            } else {
                return this.genre.compareTo(o.genre);
            }
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Song>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        List<Song> list = new ArrayList<>();
        for (String genre : genres) {
            map.put(genre, new ArrayList<>());
        }

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int id = i;

            Song song = new Song(genre, play, id);
            ArrayList<Song> songs = map.get(genre);
            songs.add(song);
            Collections.sort(songs);
            map.put(genre, songs);

            count.put(genre, count.getOrDefault(genre, 0) + play);
        }

        for (String key : count.keySet()) {
            Song song = new Song(key, count.get(key), 0);
            list.add(song);
        }
        Collections.sort(list, (Song song1, Song song2) -> {
            return -(song1.play - song2.play);
        });

        List<Integer> list2 = new ArrayList<>();
        for (Song song : list) {
            String genre = song.genre;
            ArrayList<Song> songs = map.get(genre);
            int index = 0;

            for (int i = 0; i < songs.size(); i++) {
                if (index == 2)
                    break;
                int id = songs.get(i).id;
                list2.add(id);
                index++;
            }
        }

        int[] answer = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            answer[i] = list2.get(i);
        }

        return answer;
    }
}
