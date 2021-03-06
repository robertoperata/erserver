package erserver.modules.dependencies;

import erserver.modules.testtypes.Patient;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlertScannerTest {

    @Test
    public void scanAlertForPriorityPatients() {
        InboundPatientTestDouble inboundPatientTestDouble = new InboundPatientTestDouble();
        inboundPatientTestDouble.simulateNewInboundPatient(createTestRedPatient(11, Priority.RED, "stroke"));
        inboundPatientTestDouble.simulateNewInboundPatient(createTestRedPatient(12, Priority.YELLOW, "broken leg"));
        AlertScannerTestingSubclass alertScanner = new AlertScannerTestingSubclass(inboundPatientTestDouble);
        alertScanner.scan();
        Assert.assertEquals(1, alertScanner.patientsAlertedFor.size());
        Assert.assertEquals(11, alertScanner.patientsAlertedFor.get(0).getTransportId());

    }
    @Test
    public void scanAlertForYellowHearArrythmiaPriorityPatients() {
        InboundPatientTestDouble inboundPatientTestDouble = new InboundPatientTestDouble();
        inboundPatientTestDouble.simulateNewInboundPatient(createTestRedPatient(11, Priority.GREEN, "breath"));
        inboundPatientTestDouble.simulateNewInboundPatient(createTestRedPatient(12, Priority.YELLOW, "heart arrhytmia"));
        AlertScannerTestingSubclass alertScanner = new AlertScannerTestingSubclass(inboundPatientTestDouble);
        alertScanner.scan();
        Assert.assertEquals(1, alertScanner.patientsAlertedFor.size());
        Assert.assertEquals(12, alertScanner.patientsAlertedFor.get(0).getTransportId());

    }

    private Patient createTestRedPatient(int transportId, Priority priority, String conditions) {
        Patient patient = new Patient();
        patient.setTransportId(transportId);
        patient.setPriority(priority);
        patient.setCondition(conditions);
        return patient;
    }

}
