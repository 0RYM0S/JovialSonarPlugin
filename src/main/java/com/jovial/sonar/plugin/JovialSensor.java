package com.jovial.sonar.plugin;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

public class JovialSensor implements Sensor {
    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name("Jovial Sensor").onlyOnLanguage(JovialLanguage.KEY);
    }

    @Override
    public void execute(SensorContext context) {
        // Connect to jovialserver to perform analysis. jovialserver is a
        // Python language server implemented using pygls. It must be running
        // locally for this connection to succeed.
        try (java.net.Socket socket = new java.net.Socket("localhost", 2087)) {
            // Here we would send files or analysis requests to jovialserver
            // and process the responses it returns.
            socket.getOutputStream().write(0); // placeholder communication
        } catch (java.io.IOException e) {
            // This message is printed when jovialserver is not available.
            System.err.println("Unable to connect to jovialserver: " + e.getMessage());
        }
    }
}
