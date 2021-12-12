package rip.hutch.dash.openweatherapi.onecall;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OneCall {
  private double lat;
  private double lon;
  private String timezone;
  private int timezoneOffset;
  private Current current;
  private List<Minutely> minutely;
  private List<Hourly> hourly;
  private List<Daily> daily;
  private List<Alert> alerts;

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Current {
    private long dt;
    private long sunrise;
    private long sunset;
    private float temp;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private float dewPoint;
    private int uvi;
    private int clouds;
    private int visibility;
    private float windSpeed;
    private int windDeg;
    private List<Weather> weather;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Minutely {
    private long dt;
    private int precipitation;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Hourly {
    private long dt;
    private int precipitation;
    private float temp;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private float dewPoint;
    private int uvi;
    private int clouds;
    private int visibility;
    private float windSpeed;
    private int windDeg;
    private float windGust;
    private List<Weather> weather;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Daily {
    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private float moonPhase;
    private Temp temp;
    private FeelsLike feelsLike;
    private int pressure;
    private int humidity;
    private float dewPoint;
    private float windSpeed;
    private int windDeg;
    private float windGust;
    private List<Weather> weather;
    private int clouds;
    private float pop;
    private float rain;
    private float uvi;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Temp {
	    private float day;
	    private float min;
	    private float max;
	    private float night;
	    private float eve;
	    private float morn;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class FeelsLike {
	    private float day;
	    private float night;
	    private float eve;
	    private float morn;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @EqualsAndHashCode
  @ToString
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Alert {
	    private String senderName;
	    private String event;
	    private long start;
	    private long end;
	    private String description;
	    private List<String> tags;
  }
}
