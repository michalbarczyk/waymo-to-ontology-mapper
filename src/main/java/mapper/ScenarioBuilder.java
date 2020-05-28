package mapper;

import ontology.*;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;

public class ScenarioBuilder {

    private final OWLFactory factory;

    private final Scenario scenario;

    private final Vehicle mainVehicle;

    private int nextVehicleId;

    private int nextPedestrianId;

    public ScenarioBuilder(String owlFilePath, String tmpFilePath) throws Exception {

        this.nextPedestrianId = 0;

        this.nextVehicleId = 0;

        File original = new File(owlFilePath);
        File copied = new File(tmpFilePath);

        com.google.common.io.Files.copy(original, copied);

        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(copied);

        this.factory = new OWLFactory(ontology);
        this.scenario = extractWaymoScenarioTemplate();
        this.mainVehicle = extractMainWaymoVehicleTemplate();

        this.scenario.addHas_vehicle(this.mainVehicle);
    }

    private Scenario extractWaymoScenarioTemplate() {
        return this.factory.getAllScenarioInstances().stream()
                .filter(s -> ((Scenario) s).getOwlIndividual().toStringID().contains("waymo_scenario_main"))
                .findFirst()
                .orElse(null);
    }

    private int getNextPedestrianId() {return nextPedestrianId++;}

    private Pedestrian extractNextWaymoPedestrianTemplate() {

        String id = "waymo_pedestrian_" + getNextPedestrianId();

        return this.factory.getAllPedestrianInstances().stream()
                .filter(p -> ((Pedestrian) p).getOwlIndividual().toStringID().contains(id))
                .findAny()
                .orElse(null);
    }

    private int getNextVehicleId() {return nextVehicleId++;}

    private Vehicle extractNextWaymoVehicleTemplate() {

        String id = "waymo_vehicle_" + getNextVehicleId();

        return this.factory.getAllVehicleInstances().stream()
                .filter(v -> ((Vehicle) v).getOwlIndividual().toStringID().contains(id))
                .findFirst()
                .orElse(null);
    }

    private Vehicle extractMainWaymoVehicleTemplate() {
         return this.factory.getAllVehicleInstances().stream()
                .filter(v -> ((Vehicle) v).getOwlIndividual().toStringID().contains("waymo_vehicle_main"))
                .findFirst()
                .orElse(null);
    }

    public ScenarioBuilder addPedestrian(VehicleSide vehicleSide) {

        Pedestrian pedestrian = extractNextWaymoPedestrianTemplate();

        switch (vehicleSide) {
            case IN_FRONT_OF:
                this.mainVehicle.addHas_in_the_front(pedestrian);
                break;
            case ON_THE_LEFT:
                this.mainVehicle.addHas_on_the_left(pedestrian);
                break;
            case ON_THE_RIGHT:
                this.mainVehicle.addHas_on_the_right(pedestrian);
                break;
        }

        //this.scenario.addHas_pedestrian(pedestrian);

        return this;
    }

    public ScenarioBuilder addVehicle(VehicleSide vehicleSide) {

        Vehicle vehicle = extractNextWaymoVehicleTemplate();

        switch (vehicleSide) {
            case IN_FRONT_OF:
                this.mainVehicle.addHas_in_the_front(vehicle);
                break;
            case ON_THE_LEFT:
                this.mainVehicle.addHas_on_the_left(vehicle);
                break;
            case ON_THE_RIGHT:
                this.mainVehicle.addHas_on_the_right(vehicle);
                break;
        }

        //this.scenario.addHas_vehicle(vehicle);

        return this;
    }

    public Scenario buildAndSave() throws OWLOntologyStorageException {
        this.factory.saveOwlOntology();
        return this.scenario;
    }

//    public static void main(String[] args) throws Exception {
//
//        String owlFilePath = "C:\\owl-projects\\Ontology\\changed_ontology.owl";
//        String tmpFilePath = "C:\\owl-projects\\Tmp\\waymo_ontology.owl";
//
//        //ScenarioBuilder builder = new ScenarioBuilder(owlFilePath, tmpFilePath);
//
//        File copied = new File(tmpFilePath);
//        File original = new File(owlFilePath);
//        com.google.common.io.Files.copy(original, copied);
//
//        OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
//        OWLOntology ontology = ontologyManager.loadOntologyFromOntologyDocument(copied);
//
//        OWLFactory factory = new OWLFactory(ontology);
//
//        Vehicle a = factory.getAllVehicleInstances().stream()
//                .filter(v -> ((Vehicle) v).getOwlIndividual().toStringID().contains("waymo_vehicle_" + (0)))
//                .findFirst()
//                .orElse(null);
//
//        Pedestrian y = factory.getAllPedestrianInstances().stream()
//                .filter(p -> ((Pedestrian) p).getOwlIndividual().toStringID().contains("waymo_pedestrian_" + (0)))
//                .findAny()
//                .orElse(null);
//
//        System.out.println(y);
//
//
////        Pedestrian pedestrian  = factory.getAllPedestrianInstances().stream().findAny().get();
////        Vehicle vehicle = factory.getAllVehicleInstances().stream()
////                .filter(v -> ((Vehicle) v)
////                .getOwlIndividual()
////                .toStringID()
////                .endsWith("main"))
////                .findAny().get();
////
////        Vehicle vehicle1 = factory.getAllVehicleInstances().stream()
////                .filter(v -> ((Vehicle) v)
////                        .getOwlIndividual()
////                        .toStringID()
////                        .endsWith("waymo_vehicle_1"))
////                .findAny().get();
////
////        Passenger passenger = factory.getAllPassengerInstances().stream().findAny().get();
////        Driver driver = factory.getAllDriverInstances().stream().findAny().get();
////        Tree tree = factory.getAllTreeInstances().stream().findAny().get();
////        Street_lamp lamp = factory.getAllStreet_lampInstances().stream().findAny().get();
////
////
////        Scenario scenario = factory.getAllScenarioInstances().stream()
////                .filter(c -> ((Scenario) c)
////                        .getOwlIndividual()
////                        .toStringID()
////                        .endsWith("waymo_scenario_main"))
////                .findAny().get();
////
////        // create new scenario
////
////        vehicle.addHas_on_the_right(vehicle1);
////        vehicle.addHas_on_the_right(tree);
////        vehicle.addVehicle_has_driver(driver);
////        vehicle.addVehicle_has_passenger(passenger);
////        vehicle.addHas_on_the_left(lamp);
////
////        scenario.addHas_vehicle(vehicle);
////        // crosswalking.addHas_pedestrain(pedestrian);
////
////        System.out.println(scenario);
////
////        factory.saveOwlOntology();
//    }
}
