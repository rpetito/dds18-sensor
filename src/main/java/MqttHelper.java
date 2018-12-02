import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttHelper {

    public static void sendMessage(String message, String channel) throws MqttException {

        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.connect();
        MqttMessage msqttMessage = new MqttMessage();
        msqttMessage.setPayload(message.getBytes());

        //Defino el nombre del publicador, debe ser el mismo en el que escucha el Suscrbier.java
        client.publish(channel, msqttMessage);
    }

    public static void escuchar(String channel, MqttCallback callback) throws MqttException {
        MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
        client.setCallback(callback);
        client.connect();
        client.subscribe(channel);
    }

}
