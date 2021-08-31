package nl.jtim.spring.boot.micrometer.springbootmicrometerprometheus;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomNameGenerator {

    private final Random random;
    private final static String RANDOM_NAMES_CREATED_METRIC_NAME = "random.names.created";

    // Custom counters
    private final Counter randomNamesCreatedCounter;

    private final List<String> names;

    public RandomNameGenerator(MeterRegistry meterRegistry) {
        // Fluent Builder, more declarative
        randomNamesCreatedCounter = Counter.builder(RANDOM_NAMES_CREATED_METRIC_NAME)
                .description("The total number random names created.")
                .register(meterRegistry);

        random = new Random();

        names = Arrays.asList("John", "Tim", "Mark", "David", "Oliver", "Adam", "Josh");
    }

    private int randomInt(int minimum, int maximum) {
        return random.nextInt((maximum - minimum) + 1);
    }

    public String pickRandomName() {
        String randomName = names.get(randomInt(0, names.size() - 1));
        randomNamesCreatedCounter.increment();

        return randomName;
    }
}
