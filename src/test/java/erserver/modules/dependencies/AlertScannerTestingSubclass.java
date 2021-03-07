package erserver.modules.dependencies;

import erserver.modules.testtypes.Patient;

import java.util.ArrayList;

public class AlertScannerTestingSubclass extends AlertScanner{
    public ArrayList<Patient> patientsAlertedFor;

    public AlertScannerTestingSubclass(InboundPatientSource inboundPatientSource) {

        super(inboundPatientSource);
        patientsAlertedFor = new ArrayList<>();
    }

    @Override
    protected void alertForNewCriticalPatient(Patient patient) {
        if(!patientsAlertedFor.contains(patient)) {

            patientsAlertedFor.add(patient);
        }
    }
}
