import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Date;

public class Logger {

    public static void logMessage(String title, String from, MqttMessage mqttMessage) {
        String date = new Date().toString();
        String message = new String(mqttMessage.getPayload());
        System.out.println("[" + date + "] " + title + " de '" + from + "'" + ": " + message);
    }

    public static void logMessage(String title) {
        String date = new Date().toString();
        System.out.println("[" + date + "] " + title);
    }
}
