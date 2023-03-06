package Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetByName_StatusCode_Test extends Base {

    @Test
    public void Test_ClientByName_Success() throws IOException {
        Response response = doGetRequest(CLIENT_PAGE_URL);
        List<String> jsonResponse_listid = doGetResponseName(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postNameData = jsonResponse_listid.get(i);
            System.out.println("Client Name " + postNameData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(CLIENT_PAGE_URL+"/ClientsByName?name="+postNameData).
                    then().
                    statusCode(200).log().all();
        }

    }
    /*@Test
    public void Test_ClientByName_notSuccess() throws IOException {

        String ClientName = generateRandomDataforName();
        System.out.println("ClientName " + ClientName);
        given().
                contentType(ContentType.JSON).
                when().
                get(CLIENT_PAGE_URL+"/ClientsByName?name="+ClientName).
                then().
                statusCode(204).log().all();
    }*/
/**/
    @Test
    public void Test_CompanyByName_Success() throws IOException {
        Response response = doGetRequest(COMPANY_PAGE_URL);
        List<String> jsonResponse_listid = doGetResponseName(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postNameData = jsonResponse_listid.get(i);
            System.out.println("Company Name " + postNameData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(COMPANY_PAGE_URL +"/CompaniesByName?name="+postNameData).
                    then().
                    statusCode(200).log().all();
        }

    }
    /*@Test
    public void Test_CompanyByName_notSuccess() throws IOException {

        String CompanyName = generateRandomDataforName();
        System.out.println("CompanyName " + CompanyName);
        given().
                contentType(ContentType.JSON).
                when().
                get(COMPANY_PAGE_URL+"/CompaniesByName?name="+ CompanyName).
                then().
                statusCode(204).log().all();
    }
*/
    @Test
    public void Test_CountryByName_Success() throws IOException {


        Response response = doGetRequest(COUNTRY_PAGE_URL);
        List<String> jsonResponse_listid = doGetResponseName(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postNameData = jsonResponse_listid.get(i);
            System.out.println("Country Name " + postNameData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(COUNTRY_PAGE_URL +"/CountriesByName?name="+postNameData).
                    then().
                    statusCode(200).log().all();
        }

    }
    /*@Test
    public void Test_CountryByName_notSuccess() throws IOException {
        String CountryName = generateRandomDataforName();
        System.out.println("CountryName " + CountryName);
        given().
                contentType(ContentType.JSON).
                when().
                get(COUNTRY_PAGE_URL+"/CountriesByName?name="+ CountryName).
                then().
                statusCode(204).log().all();
    }
*/
    @Test
    public void Test_RegionsByName_Success() throws IOException {

        Response response = doGetRequest(REGION_PAGE_URL);
        List<String> jsonResponse_listid = doGetResponseName(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postNameData = jsonResponse_listid.get(i);
            System.out.println("Region Name " + postNameData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(REGION_PAGE_URL +"/RegionsByName?name="+postNameData).
                    then().
                    statusCode(200).log().all();
        }

    }
    /*@Test
    public void Test_RegionByName_notSuccess() throws IOException {
        String RegionName = generateRandomDataforName();
        System.out.println("RegionName " + RegionName);
        given().
                contentType(ContentType.JSON).
                when().
                get(REGION_PAGE_URL+"/RegionsByName?name="+RegionName).
                then().
                statusCode(204).log().all();
    }
*/
    @Test
    public void Test_SitesByName_Success() throws IOException {

        Response response = doGetRequest(SITE_PAGE_URL);
        List<String> jsonResponse_listid = doGetResponseName(response);

        for (int i = 0; i < jsonResponse_listid.size(); i++) {
            String postNameData = jsonResponse_listid.get(i);
            System.out.println("Site Name " + postNameData);

            given().
                    contentType(ContentType.JSON).
                    when().
                    get(SITE_PAGE_URL +"/SitesByName?name="+postNameData).
                    then().
                    statusCode(200).log().all();
        }

    }
    /*@Test
    public void Test_SiteByName_notSuccess() throws IOException {
        String SiteName = generateRandomDataforName();
        System.out.println("SiteName " + SiteName);
        given().
                contentType(ContentType.JSON).
                when().
                get(SITE_PAGE_URL+"/SitesByName?name="+ SiteName).
                then().
                statusCode(204).log().all();
    }
*/
}
