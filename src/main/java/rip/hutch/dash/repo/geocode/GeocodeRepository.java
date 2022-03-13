package rip.hutch.dash.repo.geocode;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeocodeRepository extends MongoRepository<Geocode, String> {

  public Geocode findByInput(String input);

  public boolean existsGeocodeByInput(String input);
}
