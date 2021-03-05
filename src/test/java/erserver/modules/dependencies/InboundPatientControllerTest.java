package erserver.modules.dependencies;

import erserver.modules.testtypes.Patient;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InboundPatientControllerTest {

    @Test
    public void testInboundXmlConversion() {
        InboundPatientController controller = new InboundPatientController(null);
        String xml = "<Inbound>" +
                     "<Patient>" +
                     "<TransportId>1</TransportId>" +
                     "<Name>John Doe</Name>" +
                     "<Condition>heart arrhythmia</Condition>" +
                     "<Priority>YELLOW</Priority>" +
                     "<Birthdate></Birthdate>" +
                     "</Patient>" +
                     "</Inbound>";
        List<Patient> patients = controller.buildPatiemtsFromXml(xml);
        assertEquals(1, patients.size());
        Patient patient = patients.get(0);
        assertEquals(1, patient.getTransportId());
        assertEquals("John Doe", patient.getName());
        assertEquals("heart arrhythmia", patient.getCondition());
        assertEquals(Priority.YELLOW, patient.getPriority());

    }
}
