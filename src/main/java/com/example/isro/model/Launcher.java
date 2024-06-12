package com.example.isro.model;

import com.example.isro.helper.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "launchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Launcher {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "type")
  private String type;

  @Column(name = "registered_on")
  @JsonDeserialize(using = CustomDateDeserializer.class)  // Only if needed
  private Date registeredOn;
}

