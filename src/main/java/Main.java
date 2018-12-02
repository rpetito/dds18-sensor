import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws MqttException {

        String inputText = "Hola !";

        Logger.logMessage("Sensor listo para enviar mediciones");
        MqttHelper.sendMessage(inputText, "mediciones");

        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese mensaje a enviar...");

            inputText = scanner.nextLine();

            if(inputText.equalsIgnoreCase("exit")) {
                MqttHelper.sendMessage("Adios !", "mediciones");
            } else {
                MqttHelper.sendMessage(inputText, "mediciones");
            }

        } while (!inputText.equalsIgnoreCase("exit"));



    }


}
