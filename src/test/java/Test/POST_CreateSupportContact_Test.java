package Test;
import Base.Base;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_CreateSupportContact_Test extends Base{
    public static HashMap map = new HashMap();
    @BeforeMethod
    public void BeforeMethod(){
        map.put("fullName",generateData());
        map.put("email",generateData());
        map.put("phone",generateData());
        map.put("message",generateData());
        map.put("supportType",generateData());
    }
    @Test
    public void POST_CreateSupportContact_Success() {
       /* String postData = "{\n" +
                "  \"fullName\": \"string3\",\n" +
                "  \"email\": \"string3\",\n" +
                "  \"phone\": \"string3\",\n" +
                "  \"message\": \"string3\",\n" +
                "  \"supportType\": \"string3\"\n" +
                "}";

        System.out.println(postData);*/
        System.out.println(map);
        given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                //body(postData).
                body(map).
                when().
                post(MAIN_PAGE_URL + "CreateSupportContact").
                then().
                statusCode(200).log().all();
    }
}