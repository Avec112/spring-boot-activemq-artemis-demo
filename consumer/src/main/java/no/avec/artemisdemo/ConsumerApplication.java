package no.avec.artemisdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This Application will consume messages added to the queue
 */
@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Listening for messages. CTRL + C to quit.");
    }
}
