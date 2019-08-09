package com.stackroute.muzixtrack.exceptions;

public class TrackNotFoundException extends Exception {
  private String message;
  public TrackNotFoundException(String message){
    super(message);
    this.message=message;
  }
}
