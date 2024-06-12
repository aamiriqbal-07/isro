package com.example.isro.wrapper;

import com.example.isro.model.CustomerSatellite;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CustomerSatelliteResponse {

  @JsonProperty("customer_satellites")
  private List<CustomerSatellite> customerSatellites;

  public List<CustomerSatellite> getCustomerSatellites() {
    return customerSatellites;
  }

  public void setCustomerSatellites(List<CustomerSatellite> customerSatellites) {
    this.customerSatellites = customerSatellites;
  }
}
