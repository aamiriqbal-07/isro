package com.example.isro.service;

import com.example.isro.client.LauncherClient;
import com.example.isro.model.Launcher;
import com.example.isro.repository.LauncherRepository;
import java.util.Arrays;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LauncherService {

  @Autowired
  private LauncherRepository launcherRepository;

  @Autowired
  private LauncherClient launcherClient;

  public void fetchAndSaveLaunchers() {
    try {
      Launcher[] launchers = launcherClient.fetchLaunchers();
      Arrays.stream(launchers).forEach(launcher -> {
        launcher.setRegisteredOn(new Date());
        launcher.setType("NEW");
        launcherRepository.save(launcher);
      });
    } catch (Exception e) {
      log.error("Error fetching and saving launchers: " + e.getMessage());
    }
  }
}
