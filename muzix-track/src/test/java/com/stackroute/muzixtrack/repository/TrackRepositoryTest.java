/*
package com.stackroute.muzixtrack.repository;

import com.stackroute.muzixtrack.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//When a class is annotated with @RunWith or extends a class annotated with @RunWith, JUnit will invoke the class it references to runthe tests in that class instead of the runner built into JUnit
@RunWith(SpringRunner.class)//The SpringRunner provides support for loading a Spring ApplicationContext and having beans
//@DataJpaTest
@SpringBootTest
public class TrackRepositoryTest {
  @Autowired//@Autowired annotation is used for automatic dependency injection
    TrackRepository trackRepository;
  Track track;

  @Before
  public void setup() {
    track = new Track();
    track.setId(1);
    track.setName("keer");
    track.setComments("super");
  }

  @After
  public void teardown() {
    trackRepository.deleteAll();
  }

@Test
  public void givenDetailsAsInputShouldReturnCorrectId() {
    trackRepository.save(track);
    Track trackDetails = trackRepository.findById(track.getId());
    assertEquals(1, trackDetails.getId());
  }
  @Test
  public void givenNameShouldReturnTrackDetails() {
    Track track = new Track(2, "akhi", "great");
    trackRepository.save(track);
    List<Track> list = trackRepository.findAll();
    Assert.assertEquals("akhi", list.get(0).getName());
  }
@Test
  public void givenIdShouldReturnTrackFailure(){
  trackRepository.save(track);
  Track trackDetails = trackRepository.findById(track.getId());
  Assert.assertNotSame(3,trackDetails.getId());
  }
  @Test
  public void givenDetailsShouldGetSaved() {
    Track trackInput = new Track(3, "lakalaka", "horror");
    trackRepository.save(trackInput);
    List<Track> trackDetails = trackRepository.findAll();
    List<Track> expectedDtails = new ArrayList<>();
    expectedDtails.add(trackInput);
    assertEquals(expectedDtails, trackDetails);
  }

}
*/
