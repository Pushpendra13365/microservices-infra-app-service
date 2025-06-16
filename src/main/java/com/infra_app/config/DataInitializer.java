package com.infra_app.config;

import com.infra_app.model.District;
import com.infra_app.model.Gp;
import com.infra_app.model.Mandal;
import com.infra_app.model.Zone;
import com.infra_app.repository.DistrictRepository;
import com.infra_app.repository.GpRepository;
import com.infra_app.repository.MandalRepository;
import com.infra_app.repository.ZoneRepository;
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

            Mandal mandalA = new Mandal(null, districtA, "Mandal A1");
            Mandal mandalA2 = new Mandal(null, districtA, "Mandal A2");
            Mandal mandalB = new Mandal(null, districtB, "Mandal B1");
            Mandal mandalC = new Mandal(null, districtC, "Mandal C1");
            Mandal mandalD = new Mandal(null, districtD, "Mandal D1");

            mandalRepository.saveAll(List.of(mandalA, mandalA2, mandalB, mandalC, mandalD));

            Gp gp1 = Gp.builder().mandal(mandalA).name("GP A1").code("GP001").build();
            Gp gp2 = Gp.builder().mandal(mandalA).name("GP A2").code("GP002").build();
            Gp gp3 = Gp.builder().mandal(mandalB).name("GP B1").code("GP003").build();
            Gp gp4 = Gp.builder().mandal(mandalC).name("GP C1").code("GP004").build();

            gpRepository.saveAll(List.of(gp1, gp2, gp3, gp4));
        };
    }
}
