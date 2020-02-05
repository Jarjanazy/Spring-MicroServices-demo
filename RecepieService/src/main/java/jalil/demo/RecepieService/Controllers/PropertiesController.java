package jalil.demo.RecepieService.Controllers;

import jalil.demo.RecepieService.Services.DBConnectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    DBConnectionInfoService dbConnectionInfoService;

    @Autowired
    PropertiesController(DBConnectionInfoService dbConnectionInfoService){
        this.dbConnectionInfoService = dbConnectionInfoService;
    }


    @GetMapping("/dbinfo")
    public String getDBConnectionInfo(){
        return dbConnectionInfoService.getDBConnectionInfo();
    }

}
