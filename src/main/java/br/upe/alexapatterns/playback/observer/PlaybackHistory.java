package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Requisito #3 Observer: registra os eventos recebidos em ordem.
 */
public class PlaybackHistory implements PlaybackObserver {

  private final List<PlaybackEvent> events = new ArrayList<>();

  @Override
  public void update(PlaybackEvent event) {
    events.add(event);

  }

  /**
   * Devolve uma cópia não modificável dos eventos recebidos.
   */
  public List<PlaybackEvent> getEvents() {
    return Collections.unmodifiableList(new ArrayList<>(events));

  }
}
