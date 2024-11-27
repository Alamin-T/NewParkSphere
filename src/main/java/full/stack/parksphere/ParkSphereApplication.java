package full.stack.parksphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "full.stack.parksphere")
public class ParkSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkSphereApplication.class, args);
    }

}
