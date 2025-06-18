package com.infra_app.config;

import com.infra_app.model.*;
import com.infra_app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final DistrictRepository districtRepository;
    private final MandalRepository mandalRepository;
    private final GpRepository gpRepository;
    private final LocationRepository locationRepository;

    @Bean
    public CommandLineRunner loadData(ZoneRepository zoneRepository) {
        return args -> {

            Zone zoneNorth = zoneRepository.save(new Zone(null, "North Zone"));
            Zone zoneSouth = zoneRepository.save(new Zone(null, "South Zone"));
            Zone zoneEast = zoneRepository.save(new Zone(null, "East Zone"));
            Zone zoneWest = zoneRepository.save(new Zone(null, "West Zone"));
            Zone zoneCentral = zoneRepository.save(new Zone(null, "Central Zone"));

            District district1 = districtRepository.save(new District(null, zoneNorth, "Lucknow"));
            District district2 = districtRepository.save(new District(null, zoneNorth, "Kanpur"));
            District district3 = districtRepository.save(new District(null, zoneSouth, "Hyderabad"));
            District district4 = districtRepository.save(new District(null, zoneSouth, "Chennai"));
            District district5 = districtRepository.save(new District(null, zoneEast, "Kolkata"));
            District district6 = districtRepository.save(new District(null, zoneNorth, "Delhi"));
            District district7 = districtRepository.save(new District(null, zoneWest, "Mumbai"));


            Mandal mandal1 = new Mandal(null, district1, "Mohanlalganj");
            Mandal mandal2 = new Mandal(null, district1, "Badlapur");
            Mandal mandal3 = new Mandal(null, district3, "Serilingampally");
            Mandal mandal4 = new Mandal(null, district4, "Tambaram");
            Mandal mandal5 = new Mandal(null, district7, "Andheri");

            mandalRepository.saveAll(List.of(mandal1, mandal2, mandal3, mandal4, mandal5));

            Gp gp1 = Gp.builder().mandal(mandal1).name("GP LKO 1").code("LKO001").build();
            Gp gp2 = Gp.builder().mandal(mandal1).name("GP LKO 2").code("LKO002").build();
            Gp gp3 = Gp.builder().mandal(mandal2).name("GP LKO A1").code("LKO003").build();
            Gp gp4 = Gp.builder().mandal(mandal3).name("GP HYD 1").code("HYD001").build();
            Gp gp5 = Gp.builder().mandal(mandal4).name("GP CHN 1").code("CHN001").build();
            Gp gp6 = Gp.builder().mandal(mandal5).name("GP MUM 1").code("MUM001").build();

            gpRepository.saveAll(List.of(gp1, gp2, gp3, gp4, gp5, gp6));

            Location loc1 = Location.builder().name("Location A").build();
            Location loc2 = Location.builder().name("Location B").build();
            Location loc3 = Location.builder().name("Location C").build();

            locationRepository.saveAll(List.of(loc1, loc2, loc3));
        };
    }
}
