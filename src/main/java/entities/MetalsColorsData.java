package entities;

import java.util.List;

public class MetalsColorsData {

    public MetalsColorsData(String oddNumber, String evenNumber, List<String> elements, String color, String metal, List<String> vegetables) {
        this.oddNumber = oddNumber;
        this.evenNumber = evenNumber;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public String oddNumber;

    public String evenNumber;

    public List<String> elements;

    public String color;

    public String metal;

    public List<String> vegetables;

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
