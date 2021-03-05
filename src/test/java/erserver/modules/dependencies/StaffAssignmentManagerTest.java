package erserver.modules.dependencies;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StaffAssignmentManagerTest {

    @Test
    public void physiciansAndResidentsReturnForPhysiciansOnDutyCall(){
        StafProviderDouble stafProviderDouble = new StafProviderDouble();
        stafProviderDouble.addStaff(new Staff(1, "rob", StaffRole.DOCTOR));
        stafProviderDouble.addStaff(new Staff(2, "ale", StaffRole.RESIDENT));
        StaffAssignmentManager manager = new StaffAssignmentManager(stafProviderDouble, new BedProviderDouble());
        List<Staff> physiciansOnDuty = manager.getPhysiciansOnDuty();
        assertEquals(2, physiciansOnDuty.size());
        assertEquals(1, physiciansOnDuty.get(0).getStaffId());
        assertEquals(2, physiciansOnDuty.get(1).getStaffId());
    }

    @Test
    public void withMockito(){
        List<Staff> docsAndResidents = new ArrayList<>();
        docsAndResidents.add(new Staff(1, "rob", StaffRole.DOCTOR));
        docsAndResidents.add(new Staff(2, "ale", StaffRole.RESIDENT));
        StaffProvider staffProviderMock = Mockito.mock(StaffProvider.class);
        BedProvider bedProviderMock = Mockito.mock(BedProvider.class);
        Mockito.when(staffProviderMock.getShiftStaff()).thenReturn(docsAndResidents);
        StaffAssignmentManager manager = new StaffAssignmentManager(staffProviderMock, bedProviderMock);
        List<Staff> physiciansOnDuty = manager.getPhysiciansOnDuty();
        assertEquals(2, physiciansOnDuty.size());
        assertEquals(1, physiciansOnDuty.get(0).getStaffId());
        assertEquals(2, physiciansOnDuty.get(1).getStaffId());
    }

}
