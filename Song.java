class Song {

  private String name;
  private String artist;
  private String album;
  private int year;
  public Song nextSong;

  public Song(String name, String artist) {
    this.name = name;
    this.artist = artist;
  }

  public Song(String name, String artist, int year, String album) {
    this.name = name;
    this.artist = artist;
    this.year = year;
    this.album = album;
  }

  public Song(String name, String artist, int year) {
    this.name = name;
    this.artist = artist;
    this.year = year;
  }

  public Song(String name, String artist, String album) {
    this.name = name;
    this.artist = artist;
    this.album = album;
  }

  public String getName() {
    return this.name;
  }

  public String getArtist() {
    return this.artist;
  }

  public String getAlbum() {
    return this.album;
  }

  public int getYear() {
    return this.year;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public void setYear() {
    this.year = year;
  }
}
