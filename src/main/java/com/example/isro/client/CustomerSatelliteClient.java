package com.example.isro.client;

import com.example.isro.model.CustomerSatellite;
import com.example.isro.wrapper.CustomerSatelliteResponse;
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
public class CustomerSatelliteClient {

  @Value("${customer.satellites.api}")
  private String CUSTOMER_SATELLITES_API;

  @Autowired
  private RestTemplate restTemplate;

  public CustomerSatellite[] fetchCustomerSatellites() {
    try {
      ResponseEntity<CustomerSatelliteResponse> response = restTemplate.exchange(
          CUSTOMER_SATELLITES_API,
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<CustomerSatelliteResponse>() {
          }
      );

      CustomerSatelliteResponse customerSatelliteResponse = response.getBody();
      if (customerSatelliteResponse != null
          && customerSatelliteResponse.getCustomerSatellites() != null) {
        List<CustomerSatellite> customerSatellitesList = customerSatelliteResponse.getCustomerSatellites();
        return customerSatellitesList.toArray(new CustomerSatellite[0]);
      } else {
        return new CustomerSatellite[0];
      }
    } catch (Exception e) {
      log.error("Error fetching customer satellites: " + e.getMessage());
      return null;
    }
  }
}
