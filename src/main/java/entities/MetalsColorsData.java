package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.testng.util.Strings;

import java.util.Arrays;
import java.util.List;

import static enums.ColorsAndMaterials.RED;
import static enums.ColorsAndMaterials.SELEN;
import static enums.NatureElements.FIRE;
import static enums.NatureElements.WATER;
import static enums.Vegetables.CUCUMBER;
import static enums.Vegetables.TOMATO;

@Data
@AllArgsConstructor
public class MetalsColorsData {

    public static MetalsColorsData DATA = new MetalsColorsData(
            Arrays.asList(3, 8),
            Arrays.asList(WATER.title, FIRE.title),
            RED.title,
            SELEN.title,
            Arrays.asList(CUCUMBER.title, TOMATO.title));

    public static String RESULT = DATA.generateLog();

    public List<Integer> summary;

    public List<String> elements;

    public String color;

    public String metals;

    public List<String> vegetables;

    public String generateLog() {
        // TODO Okay, let it be, but in general is is not make sense to use StringBuffer here
        // TODO Take a look on Strings::join or stream Collectors::join
        Integer summarys = summary.get(0) + summary.get(1);
        StringBuilder resultBuild = new StringBuilder();
        resultBuild.append("Summary: ")
                .append(summarys.toString())
                .append("\n" + "Elements: ");
        for (String item : elements) {
            resultBuild.append(item).append(", ");
        }
        resultBuild.delete(resultBuild.length() - 2, resultBuild.length())
                .append("\n" + "Color: " + color + "\n" + "Metal: "
                        + metals + "\n" + "Vegetables: ");
        for (String item : vegetables) {
            resultBuild.append(item).append(", ");
        }
        resultBuild.delete(resultBuild.length() - 2, resultBuild.length());
        String result = resultBuild.toString();
        return result;
    }
}
