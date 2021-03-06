package erserver.modules.dependencies;

import erserver.modules.testtypes.Patient;

import java.util.ArrayList;
import java.util.List;

public class InboundPatientTestDouble implements InboundPatientSource{

    private ArrayList<Patient> inboundPatients;

    public InboundPatientTestDouble() {

        this.inboundPatients = new ArrayList<>();
    }

    public void simulateNewInboundPatient(Patient patient) {
        inboundPatients.add(patient);
    }

    @Override
    public List<Patient> currentInboundPatients() {
        return inboundPatients;
    }

    @Override
    public void informOfPatientArrival(int transportId) {

    }

}
