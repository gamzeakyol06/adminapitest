package Test;

import Base.Base;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class POST_ConfirmGDPR_Test extends Base {

    //de6e9154-476d-4064-9a5b-88ad57e045d5  userid in test environment
    public static HashMap map = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){
        map.put("userId", generateData());
        System.out.println(map);
    }

    @Test (description = "200 Success")
    public void POST_ConfirmGDPR_Success() throws InterruptedException, IOException {
/*        String postData = "{\n" +
                "  \"userId\": \"de6e9154-476d-4064-9a5b-88ad57e045d5\"\n" +
                "}";*/

        Response response = doGetRequest(NOTIFICATION_PAGE_URL + "GetAllNotificationToken");
        System.out.println(response.getBody().asString());
        List<String> jsonResponse_listuserid = doGetResponseListUserID(response);
        System.out.println(jsonResponse_listuserid);

        String postuseridData = jsonResponse_listuserid.get(0);
        System.out.println(postuseridData);

        if (postuseridData != null) {
            String postData = "{\n" +
                    "  \"userId\": " + "\"" + postuseridData + "\"" + "\n" +
                    "}";
            String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
            System.out.println(token);
            System.out.println(postData);
            given().headers("Authorization", "Bearer " + token).
                    contentType("application/json").
                    body(postData).
                    when().
                    get(MAIN_PAGE_URL1+"GetGDPR").
                    then().
                    statusCode(200).log().all();
        }
        }
    @Test (description = "400 Not Success")
    public void POST_ConfirmGDPR_Not_Success() throws InterruptedException {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        System.out.println(token);
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                body(map).
                when().
                post(MAIN_PAGE_URL + "ConfirmGDPR").
                then().
                statusCode(500).log().all();
    }
}
