/*
package com.stackroute.muzixtrack.seedData;

import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationListener {
  private TrackRepository trackRepository;
  @Autowired
  public ApplicationRunnerImpl(TrackRepository trackRepository) {
    this.trackRepository = trackRepository;
  }
  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    Track track1=new Track(1,"keer","good");
    trackRepository.save(track1);
    Track track2=new Track(2,"sru","great");
    trackRepository.save(track2);
    Track track3=new Track(3,"afree","best");
    trackRepository.save(track3);
  }
}
*/
