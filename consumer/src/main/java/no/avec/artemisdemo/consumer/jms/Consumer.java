package no.avec.artemisdemo.consumer.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by avec on 2019-04-15.
 */
@Component
public class Consumer {

    private int messageCounter = 0;

    @JmsListener(destination = "${jms.queue.destination}")
    public void receive(Message message){
        if(message.getPayload() instanceof String){
//            System.out.println("Recieved Message: " + message.getPayload().toString());
            messageCounter+=1;
            if((messageCounter % 100)==0) { // print every 100
                System.out.println(messageCounter + " messages processed.");
            }
        } else {
            System.err.println("Message Type Unknown !");
        }
    }
}
