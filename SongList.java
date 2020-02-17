class SongList {

  private Song head;

  public void addSong(Song newSong) {
    if(isExistingSong(newSong)){
      // throw error
      return;
    } else if(head == null){
      head = newSong;
    } else{
      Song ptr = head;
      Song prev = null;
      while(ptr != null){
        if(newSong.getName().compareTo(ptr.getName()) == 0){
          insertDuplicateNameSong(prev, ptr, newSong);
          return;
        } else if(newSong.getName().compareTo(ptr.getName()) < 0){
          // new song comes before current song
          insertSong(newSong, prev, ptr);
          return;
        } else if(ptr.nextSong == null){
          // new song goes at end
          insertSong(newSong, ptr, null);
          return;
        }
        prev = ptr;
        ptr = ptr.nextSong;
      }
    }
  }

  private void insertDuplicateNameSong(Song prev, Song ptr, Song newSong) {
    while(ptr.getName().equals(newSong.getName())){
      if(newSong.getArtist().compareTo(ptr.getArtist()) < 0){
        // insert song before current song
        insertSong(newSong, prev, ptr);
        return;
      } else if(ptr.nextSong == null){
        // insert song at end
        insertSong(newSong, ptr, null);
        return;
      }
      prev = ptr;
      ptr = ptr.nextSong;
    }
    insertSong(newSong, prev, ptr);
  }

  private boolean isExistingSong(Song newSong) {
    Song ptr = head;
    while(ptr != null){
      if(ptr.getName().equals(newSong.getName()) && ptr.getArtist().equals(newSong.getArtist())){
        return true;
      }
      ptr = ptr.nextSong;
    }
    return false;
  }

  private void insertSong(Song newSong, Song previousSong, Song nextSong) {
    if(previousSong == null){
      // insert in beginning
      head = newSong;
      newSong.nextSong = nextSong;
    } else{
      previousSong.nextSong = newSong;
      newSong.nextSong = nextSong;
    }
  }

  public void deleteSong(Song newSong) {
    Song ptr = head;
    Song prev = null;
    while(ptr != null){
      if(ptr.getName().equals(newSong.getName()) && ptr.getArtist().equals(newSong.getArtist())){
        if(prev == null){
          // delete head
          head = ptr.nextSong;
        } else{
          prev.nextSong = newSong.nextSong;
          newSong.nextSong = null;
        }
      }
      prev = ptr;
      ptr = ptr.nextSong;
    }
    // throw error, song not found
  }

  public void editSong(Song existingSong, Song editedSong) {
    if(isExistingSong(editedSong)){
      // throw error
      return;
    } else{
      Song ptr = head;
      Song prev = null;
      while(ptr != null){
        if(ptr.getName().equals(existingSong.getName()) && ptr.getArtist().equals(existingSong.getArtist())){
          editedSong.nextSong = ptr.nextSong;
          prev.nextSong = editedSong;
          ptr = editedSong;
          return;
        }
        prev = ptr;
        ptr = ptr.nextSong;
      }
      // throw error, song not found
    }
  }

  public String toString() {
    Song ptr = head;
    String songListString = "";
    songListString += "____________________________\n";
    while(ptr != null){
      songListString += "Song Name: " + ptr.getName() + "\n";
      songListString += "Song Artist: " + ptr.getArtist() + "\n";
      songListString += "Song Album: " + ptr.getAlbum() + "\n";
      songListString += "Song Year: " + ptr.getYear() + "\n";
      songListString += "____________________________" + "\n";
      ptr = ptr.nextSong;
    }
    return songListString;
  }
}
