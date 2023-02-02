package Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class Base {

    public final static String MAIN_PAGE_URL1 = "https://sf.eldor.com.tr/PublicAPI/api/App/";
    public final static String MAIN_PAGE_URL = "https://myeldor.eldor.com.tr/PublicAPI/api/App/";
    public final static String NOTIFICATION_PAGE_URL = "https://sf.eldor.com.tr/NotificationAPI/api/Notification/";

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;
        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }
    public static String doPostRequestAuthorize(String endpoint) {
        HashMap map = new HashMap<>();

        map.put("osType", generateData());
        map.put("appVersion", generateData());
        map.put("osVersion", generateData());
        map.put("deviceName", generateData());
        map.put("deviceGUID", generateData());

        System.out.println(map);

        Response responsetoken =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(map).
                when().
                post(endpoint).
                then().
                contentType(ContentType.JSON).extract().response();
         String token = responsetoken.jsonPath().get("token");
         return token;
    }
    public static List<String> doGetResponseListUserID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("userId");
    }
    public static List<String> doGetResponseListtoken(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("token");
    }
    public static List<Integer> doGetResponseListID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("id");
    }
    public static List<Integer> doGetResponseListAppID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("applicationId");
    }
    public static List<String> doGetResponseList(@NotNull Response response) throws IOException {
        return response.jsonPath().get();
    }
    public static String generateData(){
        String generateAlpha = RandomStringUtils.randomAlphanumeric(6);
        return generateAlpha;
    }
    public static Integer generateDataNumber(){
        Random rand = new Random();
        Integer generateAlphaNum = rand.nextInt(28);
        return generateAlphaNum;
    }
}
