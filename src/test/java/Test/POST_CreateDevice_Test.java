package Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class POST_CreateDevice_Test extends Base {

    public static HashMap map = new HashMap<>();
    public static HashMap map_data = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){
        map.put("userId", generateData());
        System.out.println(map);
        map_data.put("osType",generateData());
        map_data.put("appVersion",generateData());
        map_data.put("osVersion",generateData());
        map_data.put("deviceName",generateData());
        map_data.put("deviceGUID",generateData());
        System.out.println(map_data);
    }
    @Test
    public void POST_CreateDevice_Success(){
    /*String postData = "{\n" +
            "  \"osType\": \"string3\",\n" +
            "  \"appVersion\": \"string3\",\n" +
            "  \"osVersion\": \"string3\",\n" +
            "  \"deviceName\": \"string3\",\n" +
            "  \"deviceGUID\": \"string3\"\n" +
            "}";

        System.out.println(postData);*/

    Response responsetoken =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
            //body(postData).
            body(map_data).
            when().
            post(MAIN_PAGE_URL + "CreateDevice").
            then().
            contentType(ContentType.JSON).extract().response();
        System.out.println(responsetoken.asString());
    }
}