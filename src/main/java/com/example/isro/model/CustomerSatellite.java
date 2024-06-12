package com.example.isro.model;

import com.example.isro.helper.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_satellites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSatellite {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "country")
  private String country;

  @Column(name = "launch_date")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date launchDate;

  @Column(name = "mass")
  private BigDecimal mass;

  @Column(name = "launcher")
  private String launcher;
}
