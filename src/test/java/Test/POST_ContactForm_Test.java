package Test;

import Base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class POST_ContactForm_Test extends Base {

    //de6e9154-476d-4064-9a5b-88ad57e045d5  userid in test environment
    public static HashMap map = new HashMap<>();
    @BeforeTest()
    public void BeforeMethod(){
        map.put("userId", generateData());
    }

    @Test(description = "200 Success")
    public void POST_ContactForm_Success() throws InterruptedException {
        String postData = "{\n" +
                "  \"locationID\": "+ 1 + ",\n" +
                "  \"reasonID\": "+ 1 + ",\n" +
                "  \"subject\": \"string3\",\n" +
                "  \"detail\": \"string3\",\n" +
                "  \"fullName\": \"string3\",\n" +
                "  \"email\": \"strin@sdgs.com\",\n" +
                "  \"phone\": \"string3\",\n" +
                "  \"photos\": " + "[]" + "\n" +
                "}";
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        System.out.println(postData);
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                body(postData).
                when().
                post(MAIN_PAGE_URL + "ContactForm").
                then().
                statusCode(200).log().all();
    }
    @Test(description = "200 Success")

    public void POST_ContactForm_Not_Success() throws InterruptedException {
        String postData = "{\n" +
                "  \"locationID\": "+ 1 + ",\n" +
                "  \"reasonID\": "+ 1 + ",\n" +
                "  \"subject\": \"string35\",\n" +
                "  \"detail\": \"string3\",\n" +
                "  \"fullName\": \"string3\",\n" +
                "  \"email\": \"string3@dfgd.com\",\n" +
                "  \"phone\": \"string3\",\n" +
                "  \"photos\": " + "[]" + "\n" +
                "}";
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        System.out.println(postData);
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                body(postData).
                when().
                post(MAIN_PAGE_URL + "ContactForm").
                then().
                statusCode(200).log().all();
    }
}
