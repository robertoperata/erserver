package erserver.modules.dependencies;

import java.util.ArrayList;
import java.util.List;

public class StafProviderDouble implements StaffProvider {

    private ArrayList<Staff> staffToReturn;

    public StafProviderDouble() {

        this.staffToReturn = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        staffToReturn.add(staff);
    }

    @Override
    public List<Staff> getShiftStaff() {

        return staffToReturn;
    }
}
