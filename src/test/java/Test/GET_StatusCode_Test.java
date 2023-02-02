package Test;
import Base.Base;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GET_StatusCode_Test extends Base {

    @Test
    public void Test_Public_GetLocations() {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        given().headers("Authorization","Bearer "+token).
            contentType("application/json").
            when().
            get(MAIN_PAGE_URL + "GetLocations").
            then().
            statusCode(200).log().all();
    }
    @Test
    public void Test_Public_GetPolicy() {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(MAIN_PAGE_URL + "GetPolicy").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void Test_Public_GDPR() {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(MAIN_PAGE_URL + "GetGDPR").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void Test_Public_GetProductsByCategory() {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(MAIN_PAGE_URL + "GetProductsByCategory").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void Test_Public_GetReasons() {
        String token = doPostRequestAuthorize(MAIN_PAGE_URL + "CreateDevice");
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(MAIN_PAGE_URL + "GetReasons").
                then().
                statusCode(200).log().all();
    }
}
