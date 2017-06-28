package theVacationer.model.landmarks;

import java.util.List;

/**
 * Created by Alexander Dmitryukov on 6/28/2017.
 */
public class Landmarks {
    List<Landmark> landmarksList;

    public Landmarks(List<Landmark> landmarksList) {
        this.landmarksList = landmarksList;
    }

    public List<Landmark> getLandmarksList() {
        return landmarksList;
    }

    public void setLandmarksList(List<Landmark> landmarksList) {
        this.landmarksList = landmarksList;
    }
}
