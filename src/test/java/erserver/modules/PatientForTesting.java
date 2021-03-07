package erserver.modules;

import erserver.modules.testtypes.Patient;

import java.time.LocalDate;

public class PatientForTesting extends Patient {
    private LocalDate currentDate;

    public PatientForTesting() {

        this.currentDate = LocalDate.now();
    }

    public void setCurrentDate(LocalDate currentDate) {

        this.currentDate = currentDate;
    }


    @Override
    public LocalDate getSystemCurrentDate() {

        return currentDate;
    }
}
