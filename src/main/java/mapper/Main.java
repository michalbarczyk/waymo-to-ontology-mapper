package mapper;

import ontology.Scenario;

public class Main {
    public static void main(String[] args) throws Exception {

        String owlFilePath = "C:\\owl-projects\\Ontology\\changed_ontology.owl";
        String tmpFilePath = "C:\\owl-projects\\Tmp\\waymo_ontology.owl";
        String cameraLabelsFilePath = "C:\\owl-projects\\waymo-camera-labels-simple.json";

        WaymoToOntologyMapper mapper = new WaymoToOntologyMapper();

        Scenario scenario = mapper.mapToScenario(cameraLabelsFilePath, owlFilePath, tmpFilePath);


//        Scenario scenario = new ScenarioBuilder(owlFilePath, tmpFilePath)
//                .addPedestrian(VehicleSide.IN_FRONT_OF)
//                .addPedestrian(VehicleSide.ON_THE_LEFT)
//                .addVehicle(VehicleSide.ON_THE_RIGHT)
//                .buildAndSave();
//
        System.out.println(scenario);
        System.out.println(scenario.getHas_vehicle());
        System.out.println(scenario.getHas_pedestrian());
    }
}
