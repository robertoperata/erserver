package erserver.modules.dependencies;

import java.util.ArrayList;

public class AlertTransmitterTestDouble implements AlertTransmitter{

    private ArrayList<String> alertsReceived;
    private ArrayList<String> alertsReceivedRequireAck;

    public AlertTransmitterTestDouble() {
        this.alertsReceived = new ArrayList<>();
        this.alertsReceivedRequireAck = new ArrayList<>();
    }

    @Override
    public void transmit(String targetDevice, String pageText) {
        this.alertsReceived.add(targetDevice + ": " + pageText);
    }

    @Override
    public void transmitRequiringAcknowledgement(String targetDevice, String pageText) {
        this.alertsReceivedRequireAck.add(targetDevice + ": " + pageText);
    }

    public ArrayList<String> getAlertsReceived() {

        return alertsReceived;
    }

    public ArrayList<String> getAlertsReceivedRequireAck() {

        return alertsReceivedRequireAck;
    }
}
