package Test;
import Base.Base;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GET_StatusCode_Test extends Base {

    String token = doPostRequestAuthorizeValidateToken(LOGIN_PAGE_URL);
    // Client
    @Test
    public void Test_Client() {
        given().headers("Authorization","Bearer " + token).
                contentType("application/json").
                when().
                get(CLIENT_PAGE_URL + "").
                then().
                statusCode(200).log().all();

    }

    // Company
    @Test
    public void Test_Company() {
        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                get(COMPANY_PAGE_URL + "").
                then().
                statusCode(200).log().all();
    }

    // Country
    @Test
    public void Test_Country() {
        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                get(COUNTRY_PAGE_URL + "").
                then().
                statusCode(200).log().all();
    }

    //Region
    @Test
    public void Test_Region() {

        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                get(REGION_PAGE_URL + "").
                then().
                statusCode(200).log().all();
    }

    //Site
    @Test
    public void Test_Site() {
        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(SITE_PAGE_URL + "").
                then().
                statusCode(200).log().all();
    }

    //WorkCenter
    @Test
    public void Test_WorkCenter() {

        given().headers("Authorization","Bearer "+ token).
                contentType("application/json").
                when().
                get( WORKCENTER_PAGE_URL+ "").
                then().
                statusCode(200).log().all();
    }

    //ProductionTarget
    @Test
    public void Test_ProductionTarget() {

        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(PRODUCTIONTARGET_PAGE_URL+ "").
                then().
                statusCode(200).log().all();
    }
    //ProductionTarget
    @Test
    public void Test_ProductionLocationType() {

        given().headers("Authorization","Bearer "+token).
                contentType("application/json").
                when().
                get(PRODUCTIONLOCATIONTYPE_PAGE_URL+ "").
                then().
                statusCode(200).log().all();
    }
}
