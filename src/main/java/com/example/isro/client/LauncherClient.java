package com.example.isro.client;

import com.example.isro.model.Launcher;
import com.example.isro.wrapper.LauncherResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class LauncherClient {

  @Value("${isro.launcher.api}")
  private String LAUNCHERS_API;

  @Autowired
  private RestTemplate restTemplate;

  public Launcher[] fetchLaunchers() {
    try {
      ResponseEntity<LauncherResponse> response = restTemplate.exchange(
          LAUNCHERS_API,
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<LauncherResponse>() {
          }
      );

      LauncherResponse launcherResponse = response.getBody();
      if (launcherResponse != null && launcherResponse.getLaunchers() != null) {
        List<Launcher> launchersList = launcherResponse.getLaunchers();
        return launchersList.toArray(new Launcher[0]);
      } else {
        return new Launcher[0];
      }
    } catch (Exception e) {
      log.error("Error fetching launchers: " + e.getMessage());
      return null;
    }
  }
}
