package erserver.modules.dependencies;

import java.util.ArrayList;
import java.util.List;

public class BedProviderDouble implements BedProvider {

    private ArrayList<Bed> bedToReturn;

    public BedProviderDouble() {
        bedToReturn = new ArrayList<>();
    }

    public void addBed(Bed bed) {
        bedToReturn.add(bed);
    }

    @Override
    public List<Bed> getAllBeds() {

        return bedToReturn;
    }
}
