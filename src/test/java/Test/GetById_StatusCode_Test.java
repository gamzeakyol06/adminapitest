package Test;
import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.given;

public class GetById_StatusCode_Test extends Base{

    @Test
    public void Test_ClientById() throws IOException {
        Response response = doGetRequest(CLIENT_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Client Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(CLIENT_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
   /* @Test
    public void Test_ClientById_notSuccess() throws IOException {

        Integer ClientId = generateRandomDataforId();
        System.out.println("ClientId " + ClientId);
        given().
                contentType(ContentType.JSON).
                when().
                get(CLIENT_PAGE_URL+"/"+ClientId).
                then().
                statusCode(200).log().all();
    }
*/

    @Test
    public void Test_CompanyById() throws IOException {
        Response response = doGetRequest(CLIENT_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Client Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(CLIENT_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
   /* @Test
    public void Test_CompanyById_notSuccess() throws IOException {

        Integer ClientId = generateRandomDataforId();
        System.out.println("ClientId " + ClientId);
        given().
                contentType(ContentType.JSON).
                when().
                get(CLIENT_PAGE_URL+"/"+ClientId).
                then().
                statusCode(200).log().all();
    }*/

    @Test
    public void Test_CompanyWithClientById() throws IOException {

        Response response = doGetRequest(COMPANY_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListclientId(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Client Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(COMPANY_PAGE_URL+"/CompanyWithClient/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
   /* @Test
    public void Test_CompanyWithClientById_notSuccess() throws IOException {

        Integer ClientId = generateRandomDataforId();
        System.out.println("ClientId " + ClientId);
        given().
                contentType(ContentType.JSON).
                when().
                get(CLIENT_PAGE_URL+"/"+ClientId).
                then().
                statusCode(200).log().all();
    }*/

    @Test
    public void Test_CountryById() throws IOException {
        Response response = doGetRequest(COUNTRY_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Country Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(COUNTRY_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
    /*@Test
    public void Test_CountryById_notSuccess() throws IOException {

        Integer CountryId = generateRandomDataforId();
        System.out.println("Country Id " + CountryId);
        given().
                contentType(ContentType.JSON).
                when().
                get(COUNTRY_PAGE_URL+"/"+CountryId).
                then().
                statusCode(200).log().all();
    }*/

    @Test
    public void Test_RegionById() throws IOException {

        Response response = doGetRequest(REGION_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Region Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(REGION_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
    /*@Test
    public void Test_RegionById_notSuccess() throws IOException {

        Integer RegionId = generateRandomDataforId();
        System.out.println("RegionId " + RegionId);
        given().
                contentType(ContentType.JSON).
                when().
                get(REGION_PAGE_URL+"/"+RegionId).
                then().
                statusCode(200).log().all();
    }
*/

    @Test
    public void Test_SiteById() throws IOException {

        Response response = doGetRequest(SITE_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Site Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(SITE_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
    /*@Test
    public void Test_SiteById_notSuccess() throws IOException {

        Integer SiteId = generateRandomDataforId();
        System.out.println("SiteId " + SiteId);
        given().
                contentType(ContentType.JSON).
                when().
                get(SITE_PAGE_URL+"/"+SiteId).
                then().
                statusCode(200).log().all();
    }
*/

    @Test
    public void Test_WorkCenterById() throws IOException {

        Response response = doGetRequest(WORKCENTER_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("WorkCenter Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(WORKCENTER_PAGE_URL+"/"+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }
    /*@Test
    public void Test_WorkCenterById_notSuccess() throws IOException {

        Integer WorkCenterId = generateRandomDataforId();
        System.out.println("WorkCenterId " + WorkCenterId);
        given().
                contentType(ContentType.JSON).
                when().
                get(WORKCENTER_PAGE_URL+"/"+WorkCenterId).
                then().
                statusCode(200).log().all();
    }
*/

    @Test
    public void Test_WorkCentersByParentId() throws IOException {

        Response response = doGetRequest(WORKCENTER_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListParentID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("Parent Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(WORKCENTER_PAGE_URL+"/WorkCentersByParentId?Id="+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }

    @Test
    public void Test_WorkCenterByLocationType() throws IOException {

        Response response = doGetRequest(WORKCENTER_PAGE_URL);
        List<Integer> jsonResponse_listid = doGetResponseListproductionLocationTypeID(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postidData = Integer.toString(jsonResponse_listid.get(i));
            System.out.println("ProductionLocationTypeID Id " + postidData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(WORKCENTER_PAGE_URL+"/WorkCentersByLocationType?ProductionLocationTypeName="+postidData).
                    then().
                    statusCode(200).log().all();
        }
    }

}
