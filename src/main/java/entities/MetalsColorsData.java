package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static enums.ColorsAndMaterials.RED;
import static enums.ColorsAndMaterials.SELEN;
import static enums.NatureElements.FIRE;
import static enums.NatureElements.WATER;
import static enums.Vegetables.CUCUMBER;
import static enums.Vegetables.TOMATO;

// TODO Maybe Lombok ?
@Data
@AllArgsConstructor
public class MetalsColorsData {

    // TODO Basically, this field should not be a String.

    public static MetalsColorsData DATA = new MetalsColorsData(
            Arrays.asList(3, 8),
            Arrays.asList(WATER.title, FIRE.title),
            RED.title,
            SELEN.title,
            Arrays.asList(CUCUMBER.title, TOMATO.title));

    public static String RESULT = DATA.generateLog();

    public List<Integer> numbers;

    public List<String> elements;

    public String color;

    public String metal;

    public List<String> vegetables;

    // TODO Java code convention, line length

    public String generateLog() {
        Integer summary = numbers.get(0)+numbers.get(1);
        StringBuilder resultBuild = new StringBuilder();
        resultBuild.append("Summary: ")
                .append(summary.toString())
                .append("\n" + "Elements: ");
        for (String item : elements) {
            resultBuild.append(item).append(", ");
        }
        resultBuild.delete(resultBuild.length() - 2, resultBuild.length())
                .append("\n" + "Color: " + color + "\n" + "Metal: "
                        + metal + "\n" + "Vegetables: ");
        for (String item : vegetables) {
            resultBuild.append(item).append(", ");
        }
        resultBuild.delete(resultBuild.length() - 2, resultBuild.length());
        String result = resultBuild.toString();
        return result;
    }
}
