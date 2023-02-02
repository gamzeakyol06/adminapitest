package Test;

import Base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_UpdateUserFCM_Test extends Base {
    //de6e9154-476d-4064-9a5b-88ad57e045d5  userid in test environment
    public static HashMap map = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){
        map.put("fireBaseToken", generateData());
        System.out.println(map);
    }
    @Test(description = "200 Success")
    public void POST_UpdateUserFCM_Success() throws InterruptedException {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        System.out.println(token);
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                body(map).
                when().
                post(MAIN_PAGE_URL + "UpdateUserFCM").
                then().
                statusCode(200).log().all();
    }
}
