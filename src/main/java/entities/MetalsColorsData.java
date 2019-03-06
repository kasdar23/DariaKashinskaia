package entities;

import java.util.List;

// TODO Maybe Lombok ?
public class MetalsColorsData {

    // TODO Basically, this field should not be a String.
    public String oddNumber;

    public String evenNumber;

    public List<String> elements;

    public String color;

    public String metal;

    public List<String> vegetables;

    // TODO Java code convention, line length
    public MetalsColorsData(String oddNumber, String evenNumber, List<String> elements, String color, String metal, List<String> vegetables) {
        this.oddNumber = oddNumber;
        this.evenNumber = evenNumber;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public void setOddNumber(String oddNumber) {
        this.oddNumber = oddNumber;
    }

    public void setEvenNumber(String evenNumber) {
        this.evenNumber = evenNumber;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metal) {
        this.metal = metal;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
