package rip.hutch.dash.repo.geocode;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
@Document(collection = "geocode")
public class Geocode {

  @Id private String id;
  private String input;
  private List<Result> results;

  @Getter
  @Setter
  @NoArgsConstructor
  @Data
  @ToString
  public static class Result {
    private String name;
    private double lat;
    private double lon;
    private String country;
    private String state;
  }
}
