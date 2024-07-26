package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverSettings {
    private String browser;
    private int windowWidth;
    private int windowHeight;

    public WebDriverSettings()
    {
       Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Üzgünüz, config.properties bulunamadı");
                return;
            }
            properties.load(input);

            browser = properties.getProperty("browser");
            windowWidth = Integer.parseInt(properties.getProperty("window_width"));
            windowHeight = Integer.parseInt(properties.getProperty("window_height"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getBrowser() {
        return browser;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }
    }

