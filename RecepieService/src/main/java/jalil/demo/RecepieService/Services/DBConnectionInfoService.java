package jalil.demo.RecepieService.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DBConnectionInfoService {

    @Value("${server.port}")
    private String port;

    @Value("${spring.h2.console.path}")
    private String path;


    public String getDBConnectionInfo(){
        return "Port: " + port + " - Path:" + path;
    }

}
