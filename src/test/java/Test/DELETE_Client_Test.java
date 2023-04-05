package Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class DELETE_Client_Test extends Base {

    String token = doPostRequestAuthorizeValidateToken(LOGIN_PAGE_URL);
    public static HashMap map = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){

    }

    @Test(description = "200 Success")
    public void Delete_Update_Success() throws InterruptedException, IOException {

        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                delete(CLIENT_PAGE_URL + "/Delete?id=3").
                then().
                statusCode(204).log().all();
    }
    @Test (priority = 2)
    public void Delete_Update_Assert_Test() throws InterruptedException, IOException {
        SoftAssert softassert = new SoftAssert();
        Response response =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON,"Authorization","Bearer "+ token).
                when().
                get(CLIENT_PAGE_URL + "/3").
                then().
                contentType(ContentType.JSON).extract().response();
        Boolean delete = response.jsonPath().get("isDelete");
        System.out.println(delete);
        softassert.assertEquals(delete, 1);
        System.out.println(delete);

    }
}
