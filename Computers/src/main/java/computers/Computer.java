package computers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
//    private String name;

    private String manufacturer;
    private String model;
    private double price;

    private List<Part> parts;

//    public Computer(String name) {
//        this.setName(name);
//        this.parts= new ArrayList<>();
//    }

    public Computer(String manufacturer, String model, double price) {

        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        this.parts= new ArrayList<>();
    }

//    public String getName() {
//        return name;
//    }
//
//    private void setName(String name) {



    //todo test returns unmodifiable List
    public List<Part> getParts() {
        return Collections.unmodifiableList(this.parts);
    }

    //todo test returns total price for parts;
    public double getTotalPrice(){
        return this.parts.stream().mapToDouble(Part::getPrice).sum();
    }

    //todo test adds correct parts
    //todo test throws when null
    public void addPart(Part part){
        if (part==null){
            throw new IllegalArgumentException("Cannot be null!");
        }
        this.parts.add(part);
    }

    //todo test removeCorrect part
    public boolean removePart(Part part){
        return this.parts.remove(part);
    }

    //todo returns correct part
    //todo throws null if not present
    public Part getPart(String partName){
        return this.parts.stream().filter(p->p.getName().equals(partName)).findFirst().orElse(null);
    }

    //returns correct manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    //sers correct manufacturers
    //throws if null
    private void setManufacturer(String manufacturer) {

        if (manufacturer==null||manufacturer.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {

        if (model==null||model.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.model = model;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
