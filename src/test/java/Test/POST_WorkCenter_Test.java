package Test;

import Base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_WorkCenter_Test extends Base {
    public static HashMap map = new HashMap<>();

    @BeforeTest()
    public void BeforeMethod(){

        map.put("name","Test WorkCenter Created by Test Automation");
        map.put("siteId",1);
        map.put("productionLocationTypeId",1);
        map.put("sequenceNo","1");
        map.put("parentId",1);
        map.put("isFinal",false);
        map.put("isDelete", null);
        map.put("isActive",null );
        map.put("createdBy", null);
        map.put("createdDate",null);
        map.put("modifiedBy",null);
        map.put("modifiedDate",null); 

        System.out.println(map);
    }
    @Test(priority = 1, description = "200 Success")
    public void POST_Create_Success() throws InterruptedException, IOException {

        given().headers("Authorization","Bearer "/*+ token*/).
                contentType("application/json").
                body(map).
                when().
                post(WORKCENTER_PAGE_URL + "/Create").
                then().
                statusCode(200).log().all();
    }
    @Test (priority = 2, description = "400 Not Success (Empty WorkCenter Name)")
    public void POST_Create_Not_Success() throws InterruptedException {

        map.put("name",null);
        map.put("siteId",0);
        map.put("productionLocationTypeId",0);
        map.put("sequenceNo",null);
        map.put("parentId",0);
        map.put("isFinal",true);

        System.out.println(map);

        given().headers("Authorization","Bearer ").
                contentType("application/json").
                body(map).
                when().
                post(WORKCENTER_PAGE_URL + "/Create").
                then().
                statusCode(400).log().all();
    }
}
