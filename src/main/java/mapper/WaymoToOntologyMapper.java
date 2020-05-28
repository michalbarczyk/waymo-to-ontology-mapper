package mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mapper.model.CameraLabel;
import mapper.model.Label;
import ontology.Scenario;

import java.io.File;
import java.util.List;

public class WaymoToOntologyMapper {

    public Scenario mapToScenario(String jsonFilePath, String owlFilePath, String tmpFilePath) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<CameraLabel> cameraLabels = mapper.readValue(new File(jsonFilePath), new TypeReference<List<CameraLabel>>(){});

        ScenarioBuilder builder = new ScenarioBuilder(owlFilePath, tmpFilePath);

        for (CameraLabel cameraLabel : cameraLabels) {

            if (cameraLabel.name.equals(CameraDirection.FRONT.toString())) {
                mapSide(VehicleSide.IN_FRONT_OF, builder, cameraLabel.labels);
            }

            if (cameraLabel.name.equals(CameraDirection.FRONT_RIGHT.toString())) {
                mapSide(VehicleSide.ON_THE_RIGHT, builder, cameraLabel.labels);
            }

            if (cameraLabel.name.equals(CameraDirection.FRONT_LEFT.toString())) {
                mapSide(VehicleSide.ON_THE_LEFT, builder, cameraLabel.labels);
            }
        }

        return builder.buildAndSave();
    }

    private void mapSide(VehicleSide side, ScenarioBuilder scenarioBuilder, List<Label> labels) {

        for (Label label : labels) {
            if (label.type.equals(Type.TYPE_PEDESTRIAN.toString())) {
                scenarioBuilder.addPedestrian(side);
            }
            if (label.type.equals(Type.TYPE_VEHICLE.toString())) {
                scenarioBuilder.addVehicle(side);
            }
        }
    }
}
