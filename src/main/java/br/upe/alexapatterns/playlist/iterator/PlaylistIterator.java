package br.upe.alexapatterns.playlist.iterator;

import br.upe.alexapatterns.track.entity.Track;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Requisito #2 - Iterator: controla um percurso independente pelas faixas.
 */
public class PlaylistIterator implements Iterator<Track> {

  private List<Track> track;
  private int position;

  /**
   * Inicia o percurso sobre uma cópia da sequência recebida.
   */
  public PlaylistIterator(List<Track> track) {
    this.track = new ArrayList<>(track);
    this.position = 0;
  }

  @Override
  public boolean hasNext() {
    return position < track.size();
  }


  @Override
  public Track next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    return track.get(position++);
  }

}