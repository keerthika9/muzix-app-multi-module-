package com.stackroute.muzixtrack.service;

import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixtrack.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
  public Track save(Track track) throws TrackAlreadyExistsException;
  public Track getById(int id) throws TrackNotFoundException;
  public List<Track> getAllTracks() throws Exception;
  public Track deleteById(int id)throws TrackNotFoundException;
  public Track updateTrackById(int id,Track track) throws TrackNotFoundException;
  public List<Track>findByName(String name)throws Exception;
}
