package br.upe.alexapatterns.playback.observer;

import br.upe.alexapatterns.playback.event.PlaybackEvent;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Requisito #3 - Observer: gerencia inscrições e publica eventos.
 */
public class PlaybackEventPublisher implements PlaybackPublisher {

  private final Set<PlaybackObserver> observers = new LinkedHashSet<>();

  @Override
  public void subscribe(PlaybackObserver observer) {
    observers.add(observer);

  }

  @Override
  public void unsubscribe(PlaybackObserver observer) {
    observers.remove(observer);

  }

  @Override
  public void publish(PlaybackEvent event) {
    Set<PlaybackObserver> snapshot = new LinkedHashSet<>(observers);

    for (PlaybackObserver observer : snapshot) {
      observer.update(event);
    }
  }
}
