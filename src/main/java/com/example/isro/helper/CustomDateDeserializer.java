package com.example.isro.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

  @Override
  public Date deserialize(JsonParser jsonParser, DeserializationContext context)
      throws IOException, JsonProcessingException {
    String date = jsonParser.getText();
    try {
      return dateFormat.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
