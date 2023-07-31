package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import Base.Base;
import static io.restassured.RestAssured.given;

    public class PUT_Country_Test extends Base {

        String token = doPostRequestAuthorizeValidateToken(LOGIN_PAGE_URL);
        public static HashMap map = new HashMap<>();
        @BeforeTest()
        public void BeforeMethod(){

            map.put("id",2);
            map.put("externalID",generateRandomDataforId());
            map.put("regionId",1);
            map.put("isDelete", false);
            map.put("isActive",true );

            System.out.println(map);
        }

        @Test(priority = 1,description = "200 Success")
        public void PUT_Update_Success() throws InterruptedException, IOException {

            given().headers("Authorization","Bearer "+ token).
                    contentType("application/json").
                    body(map).
                    when().
                    put(COUNTRY_PAGE_URL + "/Update?id="+2).
                    then().
                    statusCode(204).log().all();
        }

        @Test (priority = 2)
        public void PUT_Update_Assert_Test() throws InterruptedException, IOException {

            Response response =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON,"Authorization","Bearer "+ token).
                    when().
                    get(COUNTRY_PAGE_URL + "/2").
                    then().
                    contentType(ContentType.JSON).extract().response();
            Integer externalID = response.jsonPath().get("externalID");
            Assert.assertEquals(externalID, map.get("externalID") );
            System.out.println(externalID);
            System.out.println(map.get("externalID"));

        }
    }

