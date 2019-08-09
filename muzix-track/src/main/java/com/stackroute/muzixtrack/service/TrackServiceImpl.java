package com.stackroute.muzixtrack.service;

import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixtrack.exceptions.TrackNotFoundException;
import com.stackroute.muzixtrack.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Profile("prod")
@Primary
@Qualifier
class TrackServiceImpl implements TrackService {
  private TrackRepository trackRepository;

  @Autowired
  public TrackServiceImpl(TrackRepository trackRepository) {

    this.trackRepository = trackRepository;
  }

  @Override
  public Track save(Track track) throws TrackAlreadyExistsException {
    if (trackRepository.existsById(track.getId())) {
      throw new TrackAlreadyExistsException(("user already exists"));
    }
    Track savedTrack = trackRepository.save(track);
    if (savedTrack == null) {
      throw new TrackAlreadyExistsException("user already exists");
    }
    return savedTrack;
  }

  @Override
  public Track getById(int id) throws TrackNotFoundException {
    if (!trackRepository.existsById(id)) {
      throw new TrackNotFoundException("not found");
    }
    Track retriveTrack = trackRepository.findById(id);
    return retriveTrack;
  }

  @Override
  public List<Track> getAllTracks() throws Exception {
    if (trackRepository.findAll().isEmpty()) {
      throw new Exception("Internal server error");
    } else {
      List<Track> allTracks = trackRepository.findAll();
      return allTracks;
    }
  }

  @Override
  //delete a particular  part of a track by its id
  public Track deleteById(int id) throws TrackNotFoundException {
    //  delete the track
    if (trackRepository.existsById(id)) {
      Track retrivedTrack = trackRepository.findById(id);
      trackRepository.deleteById(id);
      return retrivedTrack;
    } else {
      throw new TrackNotFoundException("Track not found");
    }
  }

  @Override
  //update a particular  part of a track by its id
  public Track updateTrackById(int id,Track track) throws TrackNotFoundException {
//  update the track
    if (trackRepository.existsById(id)) {
      Track updateTrackById = trackRepository.findById(id);
      return updateTrackById;
    } else {
      throw new TrackNotFoundException("track not found");
    }
  }


  @Override
  public List<Track> findByName(String name) throws Exception {
    if (trackRepository.findByName(name).isEmpty()) {
      throw new Exception("no track with this name");
    } else {
      List<Track> allTracksByName = trackRepository.findByName(name);
      return allTracksByName;
    }
  }
}

