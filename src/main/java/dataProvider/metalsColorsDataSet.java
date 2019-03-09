package dataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.MetalsColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class metalsColorsDataSet {
    private static final String JSON_PATH = "src//main//resources//JDI_ex8_metalsColorsDataSet.json";

    @DataProvider
    public Object[][] expectedData() throws FileNotFoundException {
        Type type = new TypeToken<Map<String, MetalsColorsData>>(){}.getType();
        Map<String, MetalsColorsData> dataSet = new Gson().fromJson(
                new FileReader(JSON_PATH), type);
        Object[][] objectDataSet = new Object[dataSet.size()][1];
        int i = 0;
        for (MetalsColorsData data : dataSet.values()) {
            objectDataSet[i][0] = data;
            ++i;
        }
        return objectDataSet;
        }
}
