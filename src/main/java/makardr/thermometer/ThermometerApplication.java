package makardr.thermometer;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;

@SpringBootApplication
public class ThermometerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThermometerApplication.class, args);
    }

}
