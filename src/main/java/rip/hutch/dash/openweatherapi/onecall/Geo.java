package rip.hutch.dash.openweatherapi.onecall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rip.hutch.dash.repo.geocode.Geocode;
import rip.hutch.dash.repo.geocode.Geocode.Result;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Geo {
  private String name;
  private double lat;
  private double lon;
  private String country;
  private String state;
  private Map<String, String> localNames;

  public static Geocode getGeocode(String input, Geo[] geos) {
    Geocode geocode = new Geocode();
    geocode.setInput(input);

    List<Result> results = new ArrayList<>();

    for (Geo geo : geos) {
      Result result = new Result();

      result.setName(geo.name);
      result.setLat(geo.lat);
      result.setLon(geo.lon);
      result.setCountry(geo.country);
      result.setState(geo.state);

      results.add(result);
    }
    geocode.setResults(results);

    return geocode;
  }
}
