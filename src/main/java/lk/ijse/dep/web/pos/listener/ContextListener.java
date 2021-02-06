package lk.ijse.dep.web.pos.listener;

import lk.ijse.dep.web.pos.AppInitializer;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebListener
public class ContextListener implements ServletContextListener {

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Class.forName("lk.ijse.dep.web.pos.AppInitializer");
        } catch (ClassNotFoundException e) {
            logger.info("Failed to create the IOC container", e);
        }

        Properties prop = new Properties();
        try {

//            Properties properties = System.getProperties();
//            for (Object o : properties.keySet()) {
//                System.out.println(o);
//            }

//            System.out.println(System.getProperty("catalina.home"));

            String logFilePath;
            if (prop.getProperty("app.log_dir") != null) {
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            } else {
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        AppInitializer.getContext().close();
    }
}
