package masarifyuli.co.id.javaspring.util;

import java.io.File;
import java.util.Properties;

import masarifyuli.co.id.javaspring.AppContext;
import masarifyuli.co.id.javaspring.entity.employee.EmployeeRepository;
import org.ini4j.Wini;
import org.springframework.lang.Nullable;

public class Util {

    public @Nullable
    Properties properties() {
        try {
            Wini ini = new Wini(new File("conf/general.ini"));
            Properties prop = new Properties();
            String dbHost = ini.get("database", "host");
            String dbPort = ini.get("database", "port");
            String dbName = ini.get("database", "name");
            prop.put("spring.datasource.url", "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "" +
                    "?createDatabaseIfNotExist=true&serverTimezone=Asia/Jakarta");
            prop.put("spring.datasource.username", ini.get("database", "username"));
            prop.put("spring.datasource.password", ini.get("database", "password"));
            return prop;
        } catch (Exception e) {
            return null;
        }
    }

    public String encodePassword(String password) {
        return new AppContext().getBean(EmployeeRepository.class).encodePassword(password);
    }

}

