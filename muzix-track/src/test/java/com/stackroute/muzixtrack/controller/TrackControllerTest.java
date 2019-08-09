package com.stackroute.muzixtrack.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixtrack.domain.Track;
import com.stackroute.muzixtrack.exceptions.GlobalExceptions;
import com.stackroute.muzixtrack.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixtrack.exceptions.TrackNotFoundException;
import com.stackroute.muzixtrack.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {
  @Autowired
  private MockMvc mockMvc;
  private Track track;
  @MockBean
  private TrackService trackService;
  @InjectMocks
  private TrackController trackController;
  private List<Track> list =null;
  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(new GlobalExceptions()).build();
    track = new Track();
    track.setName("keer");
    track.setId(9);
    track.setComments("good");
    list = new ArrayList();
    list.add(track);
  }
  @Test
  public void saveUser() throws Exception {
    when(trackService.save(any())).thenReturn(track);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }
  @Test
  public void givenUrlAsInputShouldReturnSaveUserFailure() throws Exception {
    when(trackService.save(any())).thenThrow(TrackAlreadyExistsException.class);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isConflict())
      .andDo(MockMvcResultHandlers.print());
  }
  @Test
  public void givenUrlAsInputShouldReturnAllTracks() throws Exception {
    when(trackService.getAllTracks()).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  @Test
  public void givenIdAsInputShouldDeleteTrack() throws Exception {
    when(trackService.deleteById(anyInt())).thenReturn(track);
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/track/9")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isNoContent())
      .andDo(MockMvcResultHandlers.print());
  }
  @Test
  public void givenIdAsInputShouldReturnTrack() throws Exception {
    when(trackService.getById(anyInt())).thenReturn(track);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/9")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }
  @Test
  public void givenNameAsInputShouldReturnTrack() throws Exception {
    when(trackService.findByName(anyString())).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/keer")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }
  /*@Test
  public void givenIdAsInputShouldUpdateTrack() throws Exception {
    when(trackService.updateTrackById(anyInt(),track)).thenReturn(track);
    mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track/9")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
      .andExpect(MockMvcResultMatchers.status().isFound())
      .andDo(MockMvcResultHandlers.print());
  }*/
  private static String asJsonString(final Object obj)
  {
    try{
      return new ObjectMapper().writeValueAsString(obj);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}


