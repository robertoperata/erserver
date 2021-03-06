package erserver.modules.dependencies;

import erserver.modules.dependencies.vendorpagersystem.PagerTransport;
import erserver.modules.testtypes.Patient;
import erserver.modules.dependencies.vendorpagersystem.PagerSystem;

import java.util.ArrayList;
import java.util.List;

public class AlertScanner {

   private static final String ADMIN_ON_CALL_DEVICE = "111-111-1111";

//   private StaffAssignmentManager staffAssignmentManager;
   private InboundPatientSource inboundPatientSource;
   private ArrayList<Integer> criticalPatientNotificationsSent;

   public AlertScanner(/*StaffAssignmentManager staffAssignmentManager, */InboundPatientSource inboundPatientSource) {
//      this.staffAssignmentManager = staffAssignmentManager;
      this.inboundPatientSource = inboundPatientSource;
      criticalPatientNotificationsSent = new ArrayList<>();
   }

   public void scan() {
      System.out.println("Scanning for situations requiring alerting...");
      List<Patient> inbound = inboundPatientSource.currentInboundPatients();
      for (Patient patient : inbound) {
         if (Priority.RED.equals(patient.getPriority())) {
            if (!criticalPatientNotificationsSent.contains(patient.getTransportId())) {
               alertForNewCriticalPatient(patient);
            }
         }
         if (Priority.YELLOW.equals(patient.getPriority()) && "heart arrhytmia".equalsIgnoreCase(patient.getCondition())) {
            if (!criticalPatientNotificationsSent.contains(patient.getTransportId())) {
               alertForNewCriticalPatient(patient);
            }
         }
      }
   }

   protected void alertForNewCriticalPatient(Patient patient) {
      try {
         PagerTransport transport = PagerSystem.getTransport();
         transport.initialize();
         transport.transmitRequiringAcknowledgement(ADMIN_ON_CALL_DEVICE, "New inbound critical patient: " +
            patient.getTransportId());
         criticalPatientNotificationsSent.add(patient.getTransportId());
      } catch (Throwable t) {
         System.out.println("Failed attempt to use pager system to device " + ADMIN_ON_CALL_DEVICE);
      }
   }

}
