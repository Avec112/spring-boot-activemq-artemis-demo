package no.avec.artemisdemo.consumer.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by avec on 2019-04-15.
 */
@Component
public class Consumer {

    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(Message message){
        if(message.getPayload() instanceof String){
            System.out.println("Recieved Message: " + message.getPayload().toString());
        } else {
            System.err.println("Message Type Unkown !");
        }
    }
}
