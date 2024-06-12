package com.example.isro.controller;

import com.example.isro.model.CustomerSatellite;
import com.example.isro.service.CustomerSatelliteService;
import com.example.isro.service.LauncherService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LauncherController {

  @Autowired
  private LauncherService launcherService;

  @Autowired
  private CustomerSatelliteService customerSatelliteService;

  @GetMapping("/fetch-launchers")
  public String fetchLaunchers() {
    launcherService.fetchAndSaveLaunchers();
    return "Launchers fetched and saved successfully!";
  }

  @GetMapping("/fetch-customer-satellites")
  public String fetchCustomerSatellites() {
    customerSatelliteService.fetchAndSaveCustomerSatellites();
    return "Customer satellites fetched and saved successfully!";
  }

  @GetMapping("/search-customer-satellites")
  public List<CustomerSatellite> searchCustomerSatellites(
      @RequestParam(required = false) String id,
      @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date launchDate,
      @RequestParam(required = false) String country,
      @RequestParam(required = false) String launcher,
      @RequestParam(required = false) BigDecimal mass) {
    return customerSatelliteService.searchSatellites(id, launchDate, country, launcher, mass);
  }
}
