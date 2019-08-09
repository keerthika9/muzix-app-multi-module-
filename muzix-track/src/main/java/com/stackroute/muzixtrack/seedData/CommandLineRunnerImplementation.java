/*
package com.stackroute.muzixtrack.seedData;

import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImplementation implements CommandLineRunner {
  private TrackRepository trackRepository;
  @Autowired
  public CommandLineRunnerImplementation(TrackRepository trackRepository) {
    this.trackRepository = trackRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Track track1=new Track(1,"akhi","nice");
    trackRepository.save(track1);
    Track track2=new Track(2,"keer","nice");
    trackRepository.save(track2);
  }
}
*/
