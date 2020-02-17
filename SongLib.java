import java.io.*;

public class SongLib {

  private static SongList songList;

  public static void main(String args[]) {

    songList = readExistingSongLibrary();

    Song song4 = new Song("Song 4", "Artist 4");
    songList.addSong(song4);

    Song song1 = new Song("Song 1", "Artist 1");
    songList.addSong(song1);

    Song song5 = new Song("Song 1", "Artist 3");
    songList.addSong(song5);

    Song song3 = new Song("Song 3", "Artist 3");
    songList.addSong(song3);

    Song song2 = new Song("Song 2", "Artist 2");
    songList.addSong(song2);

    Song song6 = new Song("Song 1", "Artist 2");
    songList.addSong(song6);

    Song editedSong2 = new Song("Edited Song 2", "Edited Artist 2");
    songList.editSong(song2, editedSong2);

    System.out.println(songList);
  }

  private static void addSongListToLibrary() {

  }

  private static SongList readExistingSongLibrary() {
    try{

      String fileName = "./songLibrary.json";
      File file = new File(fileName);

      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while((line = reader.readLine()) != null){
        System.out.println(line);
      }

      reader.close();
    } catch(IOException e){
      System.out.println(e);
    }
    return new SongList();
  }
}
