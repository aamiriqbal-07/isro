package com.example.isro.specification;

import com.example.isro.model.CustomerSatellite;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSatelliteSpecification {

  public static Specification<CustomerSatellite> hasId(String id) {
    return (root, query, cb) -> id == null ? null : cb.equal(root.get("id"), id);
  }

  public static Specification<CustomerSatellite> hasCountry(String country) {
    return (root, query, cb) -> country == null ? null : cb.equal(root.get("country"), country);
  }

  public static Specification<CustomerSatellite> hasLaunchDate(Date launchDate) {
    return (root, query, cb) -> launchDate == null ? null
        : cb.equal(root.get("launchDate"), launchDate);
  }

  public static Specification<CustomerSatellite> hasLauncher(String launcher) {
    return (root, query, cb) -> launcher == null ? null : cb.equal(root.get("launcher"), launcher);
  }

  public static Specification<CustomerSatellite> hasMass(BigDecimal mass) {
    return (root, query, cb) -> mass == null ? null : cb.equal(root.get("mass"), mass);
  }
}
