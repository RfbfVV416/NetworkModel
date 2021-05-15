package NetworkModel;

import java.util.ArrayList;
import java.util.List;

public class CableTypes {
    private List<Cable> CableTypesList = new ArrayList<>();

    public List<Cable> getCableTypesList() {
        return CableTypesList;
    }

    public void setCableTypesList(List<Cable> cableTypesList) {
        CableTypesList = cableTypesList;
    }
}
