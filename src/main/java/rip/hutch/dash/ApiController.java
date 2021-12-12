package rip.hutch.dash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import rip.hutch.dash.openweatherapi.onecall.Geo;
import rip.hutch.dash.openweatherapi.onecall.OneCall;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ApiController {

  @GetMapping("/hey/")
  public Map<String, String> onecall() {
    RestTemplate rt = new RestTemplate();
    OneCall oc =
        rt.getForObject(
            "https://api.openweathermap.org/data/2.5/onecall?lat=39.40419189300774&lon=-76.95065414699363&appid=b2156c9743bc7225deb7b64fcb90d13f",
            OneCall.class);
    System.out.println(oc.toString());
    Map<String, String> message = new HashMap<>();
    message.put("message", "Hello!");
    return message;
  }

  @GetMapping("/ho/")
  public Map<String, String> geo() {
    RestTemplate rt = new RestTemplate();
    @SuppressWarnings("unchecked")
    List<Geo> geo =
        rt.getForObject(
            "https://api.openweathermap.org/geo/1.0/direct?q=westminster&limit=6&appid=b2156c9743bc7225deb7b64fcb90d13f",
            List.class);
    System.out.println(geo.toString());
    Map<String, String> message = new HashMap<>();
    message.put("message", "Hello!");
    return message;
  }
}
