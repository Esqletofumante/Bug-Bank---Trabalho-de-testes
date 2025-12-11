package Framework.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class FileOperations {

    private static final String DIR_PATH_PROPERTIES =
            System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "main" + File.separator + "resources" +
                    File.separator + "Properties" + File.separator;

    public static Properties getProperties(String fileName) {

        Properties prop = new Properties();
        try (InputStream inputStream =
                     new FileInputStream(DIR_PATH_PROPERTIES + fileName + ".properties")) {

            prop.load(inputStream);

        } catch (Exception e) {
            System.out.println("Não foi possível carregar o arquivo de propriedade: " + fileName);
        }
        return prop;
    }

    public static void setProperty(String fileName, String key, String value) {

        Properties prop = getProperties(fileName);

        try (OutputStream outputStream =
                     new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties")) {

            prop.setProperty(key, value);
            prop.store(outputStream, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para gravar várias propriedades de uma vez
    public static void setProperties(String fileName, Map<String, String> data) {

        Properties prop = getProperties(fileName);

        data.forEach(prop::setProperty);

        try (OutputStream outputStream =
                     new FileOutputStream(DIR_PATH_PROPERTIES + fileName + ".properties")) {

            prop.store(outputStream, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
