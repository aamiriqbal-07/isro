package com.example.isro.wrapper;

import com.example.isro.model.Launcher;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LauncherResponse {

  @JsonProperty("launchers")
  private List<Launcher> launchers;

  public List<Launcher> getLaunchers() {
    return launchers;
  }

  public void setLaunchers(List<Launcher> launchers) {
    this.launchers = launchers;
  }
}