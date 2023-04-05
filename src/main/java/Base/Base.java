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

    public final static String CLIENT_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/Client";
    public final static String COMPANY_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/Company";
    public final static String COUNTRY_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/Country";
    public final static String REGION_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/Region";
    public final static String SITE_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/Site";
    public final static String WORKCENTER_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/WorkCenter";
    public final static String PRODUCTIONLOCATIONTYPE_PAGE_URL = "https://apitest.niso.dev/pamis/admin/organisation/ProductionLocationType";
    public final static String LOGIN_PAGE_URL = "https://apitest.niso.dev/pamis/identity/v1/Login";

    public static Response doGetRequest(String endpoint) {
        String token = doPostRequestAuthorizeValidateToken(LOGIN_PAGE_URL);
        RestAssured.defaultParser = Parser.JSON;
        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON,"Authorization","Bearer " + token).
                when().get(endpoint).
                then().contentType(ContentType.JSON).extract().response();
    }
    public static String doPostRequestAuthorizeValidateToken(String endpoint) {

        HashMap map = new HashMap<>();

        map.put("username","akyolg");
        map.put("password","Niso.2022!");
        map.put("applicationId",0);
        System.out.println(map);
        RestAssured.defaultParser = Parser.JSON;
        Response responsetoken =  given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(map).
                when().
                post(endpoint).
                then().
                contentType(ContentType.JSON).extract().response();
        System.out.println(responsetoken);

        String token = responsetoken.jsonPath().getString("accessToken.code");
        System.out.println(token);
        return token;
    }
    public static String doPostRequestAuthorize(String endpoint) {

        HashMap map = new HashMap<>();
        map.put("osType", generateData());
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
    public static List<String> doGetResponseName(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("name");
    }
    public static List<Integer> doGetResponseListproductionLocationTypeID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("productionLocationTypeID");
    }
    public static List<Integer> doGetResponseListID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("id");
    }
    public static List<Integer> doGetResponseexternalID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("externalID");
    }
    public static List<Integer> doGetResponseListParentID(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("parentID");
    }
    public static List<Integer> doGetResponseListclientId(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("clientId");
    }
    public static List<String> doGetResponseListtoken(@NotNull Response response) throws IOException {
        return response.jsonPath().getList("token");
    }
    public static List<String> doGetResponseList(@NotNull Response response) throws IOException {
        return response.jsonPath().get();
    }
    public static List<Boolean> doGetResponseisDelete(@NotNull Response response) throws IOException {
        return response.jsonPath().get();
    }
    public static String generateData(){
        String generateAlpha = RandomStringUtils.randomAlphanumeric(6);
        return generateAlpha;
    }
    public static String generateRandomDataforName(){
        String generateAlpha = RandomStringUtils.randomAlphanumeric(10);
        return generateAlpha;
    }
    public static Integer generateRandomDataforId(){
        Random rand = new Random();
        Integer generateAlphaNum = rand.nextInt(250);
        return generateAlphaNum;
    }
}
