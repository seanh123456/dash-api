package rip.hutch.dash;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rip.hutch.dash.openweatherapi.onecall.Geo;
import rip.hutch.dash.openweatherapi.onecall.OneCall;
import rip.hutch.dash.repo.geocode.Geocode;
import rip.hutch.dash.repo.geocode.GeocodeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ApiController {

  @Autowired GeocodeRepository geocodeRepository;

  @GetMapping("/hey")
  public Map<String, String> onecall() {
    RestTemplate rt = new RestTemplate();
    OneCall oc =
        rt.getForObject(
            "https://api.openweathermap.org/data/2.5/onecall?lat=39.40419189300774&lon=-76.95065414699363&appid=5cdd79dbe5103d57991be66e3f21a2a9",
            OneCall.class);
    System.out.println(oc.toString());
    Map<String, String> message = new HashMap<>();
    message.put("message", "Hello!");
    return message;
  }

  @GetMapping("/ho")
  public Geocode geo(@RequestParam String input) {
    Geocode geocode;
    if (!geocodeRepository.existsGeocodeByInput(input)) {
      RestTemplate rt = new RestTemplate();
      String api =
          String.format(
              "https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=6&appid=5cdd79dbe5103d57991be66e3f21a2a9",
              input);
      ResponseEntity<Geo[]> geos = rt.getForEntity(api, Geo[].class);
      System.out.println("Geos: " + geos.toString());
      geocode = Geo.getGeocode(input, geos.getBody());
      System.out.println("Geocodes: " + geocode.toString());
      geocodeRepository.save(geocode);
    } else {
      System.out.println("Already Exists");
      geocode = geocodeRepository.findByInput(input);
    }

    return geocode;
  }

  @GetMapping("/coord")
  public OneCall geoOnecall(@RequestParam double lat, @RequestParam double lon) {
    RestTemplate rt = new RestTemplate();
    OneCall oc =
        rt.getForObject(
            "https://api.openweathermap.org/data/2.5/onecall?lat="
                + lat
                + "&lon="
                + lon
                + "&appid=5cdd79dbe5103d57991be66e3f21a2a9",
            OneCall.class);
    return oc;
  }
}
