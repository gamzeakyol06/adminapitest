package Test;

import Base.Base;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;

public class POST_MatchUser_Test extends Base {

    //de6e9154-476d-4064-9a5b-88ad57e045d5 old   userid in test environment
    // 7048d8df-3572-4188-bfd2-82ee83f0702e burayı updatele notificationdaki gibi
    @Test(description = "200 Success")
    public void POST_MatchUser_Success() throws InterruptedException, IOException {
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
            System.out.println(postuseridData);
                String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
                System.out.println(token);
                given().headers("Authorization", "Bearer " + token).
                        contentType("application/json").
                        body(postData).
                        when().
                        post(MAIN_PAGE_URL + "MatchUser").
                        then().
                        statusCode(200).log().all();
            }
    }
}
