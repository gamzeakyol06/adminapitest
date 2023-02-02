package Test;
import Base.Base;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

    public class POST_RegisterAnonymous2_Test  extends Base {
        public static HashMap map = new HashMap();
        @BeforeTest()
        public void BeforeMethod(){
            map.put("fullName",generateData());
            map.put("email",generateData());
            map.put("department",generateData());
            map.put("phone",generateData());
            map.put("experience",generateData());
            map.put("jobTitle",generateData());
            map.put("country",generateData());
            map.put("city",generateData());
            map.put("interestedlocation",generateData());
        }

        @Test
        public void POST_RegisterAnonymous2_Success() {
/*            String postData = "{\n" +
                    "  \"fullName\": \"string3\",\n" +
                    "  \"email\": \"string3\",\n" +
                    "  \"department\": \"string3\",\n" +
                    "  \"phone\": \"string3\",\n" +
                    "  \"experience\": \"string3\",\n" +
                    "  \"jobTitle\": \"string3\",\n" +
                    "  \"country\": \"string3\",\n" +
                    "  \"city\": \"string3\",\n" +
                    "  \"interestedlocation\": \"string3\"\n" +
                    "}";

            System.out.println(postData);*/
            System.out.println(map);

            given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                    //body(postData).
                    body(map).
                    when().
                    post(MAIN_PAGE_URL + "RegisterAnonymous2").
                    then().
                    statusCode(200).log().all();
        }
    }