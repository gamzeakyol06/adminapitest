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

public class PUT_Client_Test extends Base{

    public static HashMap map = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){

        map.put("id",1);
        map.put("name",generateRandomDataforName());
        map.put("clientID",null);
        map.put("isDelete", false);
        map.put("isActive",true );
        map.put("createdBy",null);
        map.put("createdDate",1);
        map.put("modifiedBy",null);
        map.put("modifiedDate",null);

        System.out.println(map);
    }

    @Test(priority = 1,description = "200 Success")
    public void PUT_Update_Success() throws InterruptedException, IOException {

        given().headers("Authorization","Bearer "/*+ token*/).
                contentType("application/json").
                body(map).
                when().
                put(CLIENT_PAGE_URL + "/Update?id="+1).
                then().
                statusCode(204).log().all();
    }

    @Test (priority = 2)
    public void PUT_Update_Assert_Test() throws InterruptedException, IOException {

            Response response =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).

                    when().
                    get(CLIENT_PAGE_URL + "/1").
                    then().
                    contentType(ContentType.JSON).extract().response();
            String name = response.jsonPath().get("name");
            Assert.assertEquals(name, map.get("name") );
            System.out.println(name);
            System.out.println(map.get("name"));

    }
}
