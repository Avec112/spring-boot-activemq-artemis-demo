package no.avec.artemisdemo;

import no.avec.artemisdemo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;

/**
 * This application will produce 10 messages and put them on the queue.
 *
 * Using CommandLineRunner to access Producer and send messages.
 */

@SpringBootApplication
@EnableJms
public class ProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    // -------------------------------------------------------------------
    //              Simple way to produce some messages below
    // -------------------------------------------------------------------

    @Autowired
    ApplicationContext ctx; // needed to access the Producer bean

    @Override
    public void run(String... args) throws Exception {
        Producer producer = ctx.getBean(Producer.class);

        int messageCount = 1000;

        for(int i=1; i<=messageCount;i++) {
            producer.send("This is message #" + i);
            if((i%100)==0) {
                System.out.println("Produced " + i + " messages.");
            }
        }
        System.out.println("Finished creating messages.");
    }

}
