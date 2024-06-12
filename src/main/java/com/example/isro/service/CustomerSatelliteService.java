package com.example.isro.service;

import com.example.isro.client.CustomerSatelliteClient;
import com.example.isro.model.CustomerSatellite;
import com.example.isro.repository.CustomerSatelliteRepository;
import com.example.isro.specification.CustomerSatelliteSpecification;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerSatelliteService {

  @Autowired
  private CustomerSatelliteClient customerSatelliteClient;

  @Autowired
  private CustomerSatelliteRepository customerSatelliteRepository;

  public void fetchAndSaveCustomerSatellites() {
    try {
      CustomerSatellite[] satellites = customerSatelliteClient.fetchCustomerSatellites();
      if (satellites == null) {
        return;
      }

      for (CustomerSatellite satellite : satellites) {
        CustomerSatellite cs = customerSatelliteRepository.save(satellite);
      }
    } catch (Exception e) {
      log.error("Error fetching and saving customer satellites: " + e.getMessage());
    }
  }

  public List<CustomerSatellite> searchSatellites(String id, Date launchDate, String country,
      String launcher, BigDecimal mass) {
    Specification<CustomerSatellite> spec = Specification.where(
            CustomerSatelliteSpecification.hasId(id))
        .and(CustomerSatelliteSpecification.hasCountry(country))
        .and(CustomerSatelliteSpecification.hasLaunchDate(launchDate))
        .and(CustomerSatelliteSpecification.hasLauncher(launcher))
        .and(CustomerSatelliteSpecification.hasMass(mass));
    return customerSatelliteRepository.findAll((Sort) spec);
  }
}
