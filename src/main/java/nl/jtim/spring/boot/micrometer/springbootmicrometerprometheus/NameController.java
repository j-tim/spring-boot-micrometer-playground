package nl.jtim.spring.boot.micrometer.springbootmicrometerprometheus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NameController {

    private final RandomNameGenerator randomNameGenerator;

    public NameController(RandomNameGenerator randomNameGenerator) {
        this.randomNameGenerator = randomNameGenerator;
    }

    @GetMapping
    public String random() {
        return randomNameGenerator.pickRandomName();
    }

}
