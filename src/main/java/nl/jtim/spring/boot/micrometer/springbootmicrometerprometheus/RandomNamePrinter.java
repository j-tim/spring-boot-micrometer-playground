package nl.jtim.spring.boot.micrometer.springbootmicrometerprometheus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RandomNamePrinter {

    private final RandomNameGenerator randomValueGenerator;

    public RandomNamePrinter(RandomNameGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Scheduled(fixedRate = 1000) // runs every second
    public void printRandomName() {
        String randomName = randomValueGenerator.pickRandomName();

        log.info("Print random name: {}", randomName);
    }
}
