package com.infra_app.config;

import com.infra_app.model.District;
import com.infra_app.model.Mandal;
import com.infra_app.model.Zone;
import com.infra_app.repository.DistrictRepository;
import com.infra_app.repository.MandalRepository;
import com.infra_app.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final DistrictRepository districtRepository;
    private final MandalRepository mandalRepository;

    @Bean
    public CommandLineRunner loadData(ZoneRepository zoneRepository) {
        return args -> {
            Zone northZone = new Zone();
            northZone.setName("North Zone");
            zoneRepository.save(northZone);

            Zone southZone = new Zone();
            southZone.setName("South Zone");
            zoneRepository.save(southZone);

            Zone eastZone = new Zone();
            eastZone.setName("East Zone");
            zoneRepository.save(eastZone);

            Zone westZone = new Zone();
            westZone.setName("West Zone");
            zoneRepository.save(westZone);

            District districtA = new District();
            districtA.setName("District A");
            districtA.setZone(northZone);
            districtRepository.save(districtA);

            District districtB = new District();
            districtB.setName("District B");
            districtB.setZone(northZone);
            districtRepository.save(districtB);

            District districtC = new District();
            districtC.setName("District C");
            districtC.setZone(southZone);
            districtRepository.save(districtC);

            District districtD = new District();
            districtD.setName("District D");
            districtD.setZone(southZone);
            districtRepository.save(districtD);

            mandalRepository.save(new Mandal(null, districtA, "Mandal A1"));
            mandalRepository.save(new Mandal(null, districtA, "Mandal A2"));
            mandalRepository.save(new Mandal(null, districtB, "Mandal B1"));
            mandalRepository.save(new Mandal(null, districtC, "Mandal C1"));
            mandalRepository.save(new Mandal(null, districtD, "Mandal D1"));
        };
    }
}
