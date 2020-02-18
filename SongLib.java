import java.io.*;

public class SongLib {

  private static SongList songList;

  public static void main(String args[]) {

    readExistingSongLibrary();

    //Song song4 = new Song("Song 6", "Artist 4");
    //songList.addSong(song4);

    /*Song song1 = new Song("Song 1", "Artist 1");
    songList.addSong(song1);

    Song song5 = new Song("Song 1", "Artist 3");
    songList.addSong(song5);

    Song song3 = new Song("Song 3", "Artist 3");
    songList.addSong(song3);

    Song song2 = new Song("Song 2", "Artist 2");
    songList.addSong(song2);

    Song song6 = new Song("Song 1", "Artist 2");
    songList.addSong(song6);*/

    //addSongListToLibrary();

    System.out.println(songList);
  }

  private static void addSongListToLibrary() {

    try{
      FileWriter writer = new FileWriter("./songLibrary.csv");
      Song song = songList.getHead();
      while(song != null){
        writer.append(song.getName() + ", " + song.getArtist() + ", " + song.getAlbum() + ", " + song.getYear() + "\n");
        song = song.nextSong;
      }
      writer.flush();
      writer.close();
    } catch(IOException e){
      System.out.println(e);
    }
  }

  private static void readExistingSongLibrary() {
    try{

      String fileName = "./songLibrary.csv";
      File file = new File(fileName);

      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      songList = new SongList();

      while((line = reader.readLine()) != null){
        String[] row = line.split(",");
        Song song = new Song(row[0], row[1], Integer.parseInt(row[3].trim()), row[2]);
        songList.addSong(song);
      }

      reader.close();
    } catch(IOException e){
      System.out.println(e);
    }
  }
}
