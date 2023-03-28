package Test;

import Base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_Region_Test extends Base {
    public static HashMap map = new HashMap<>();

    @BeforeTest()
    public void BeforeMethod(){

        map.put("name","Test Region Created by Test Automation");
        map.put("isDelete", null);
        map.put("isActive",true );
        map.put("createdBy", null);
        map.put("createdDate",null);
        map.put("modifiedBy", null);
        System.out.println(map);
    }

    @Test(priority = 1, description = "200 Success")
    public void POST_Create_Success() throws InterruptedException, IOException {

        given().headers("Authorization","Bearer "/*+ token*/).
                contentType("application/json").
                body(map).
                when().
                post(REGION_PAGE_URL + "/Create").
                then().
                statusCode(200).log().all();
    }
    @Test (priority = 2,description = "400 Not Success (Empty Region Name)")
    public void POST_Create_Not_Success() throws InterruptedException {
        map.put("name",null);

        System.out.println(map);

        given().headers("Authorization","Bearer ").
                contentType("application/json").
                body(map).
                when().
                post(REGION_PAGE_URL + "/Create").
                then().
                statusCode(400).log().all();
    }
}
