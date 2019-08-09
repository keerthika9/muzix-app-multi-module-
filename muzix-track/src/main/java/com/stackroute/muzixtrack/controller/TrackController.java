package com.stackroute.muzixtrack.controller;

import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixtrack.exceptions.TrackNotFoundException;
import com.stackroute.muzixtrack.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackController {
  private TrackService trackService;

  public TrackController() {
  }

  @Autowired
  public TrackController(TrackService trackService) {

    this.trackService = trackService;
  }

  @PostMapping("/track")
  public ResponseEntity<?> save(@RequestBody Track track) throws TrackAlreadyExistsException {
    ResponseEntity responseEntity;
    Track savedTrack = trackService.save(track);
    return new ResponseEntity(savedTrack, HttpStatus.CREATED);


  }



  @GetMapping("track/{id}")
  public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
    ResponseEntity responseEntity;
      Track retrivedTrack = trackService.getById(id);
      return new ResponseEntity<>(retrivedTrack, HttpStatus.CREATED);

  }

  @GetMapping("tracks")
  //to get the List of track
  public ResponseEntity<?> getAllTracks() throws Exception {
    ResponseEntity responseEntity;
      responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    return responseEntity;
  }

  @DeleteMapping("track/{id}")
  public ResponseEntity<?> deleteById(@PathVariable int id) throws TrackNotFoundException {
    ResponseEntity responseEntity;
      Track retrivedTrack = trackService.getById(id);
      return new ResponseEntity<>(retrivedTrack, HttpStatus.NO_CONTENT);
  }

  @PutMapping("track/{id}")
  //to update the track
  public ResponseEntity<?> updateTrackById(@PathVariable int id,@RequestBody Track track) throws TrackNotFoundException {
    ResponseEntity responseEntity;
      Track trackUpdated = trackService.getById(id);
      responseEntity = new ResponseEntity<>(trackUpdated, HttpStatus.FOUND);
    return responseEntity;
  }

  @GetMapping("tracks/{name}")
  //to get the track by name
  public ResponseEntity<?> getFindByName(@PathVariable String name) throws Exception {
    ResponseEntity responseEntity;
     List<Track> retrivedTrack = trackService.findByName(name);
      return new ResponseEntity<>(retrivedTrack, HttpStatus.CREATED);

  }


}


