/*
package Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DELETE_ProductionLocationType_Test extends Base {

        public static HashMap map = new HashMap<>();
        @BeforeTest()
        public void BeforeMethod(){

        }

        @Test(description = "200 Success")
        public void Delete_Update_Success() throws InterruptedException, IOException {

            given().headers("Authorization","Bearer "*/
/*+ token*//*
).
                    contentType("application/json").
                    when().
                    delete(PRODUCTIONLOCATIONTYPE_PAGE_URL + "/Delete?id=3").
                    then().
                    statusCode(204).log().all();
        }
       */
/* @Test (priority = 2)
        public void Delete_Update_Assert_Test() throws InterruptedException, IOException {
            SoftAssert softassert = new SoftAssert();

            Response response = doGetRequest(PRODUCTIONLOCATIONTYPE_PAGE_URL);
            List<Integer> jsonResponse_listid = doGetResponseListID(response);
            List<Boolean> jsonResponse_delete = doGetResponseisDelete(response);

            for (int i = 0; i < jsonResponse_listid.size(); i++) {
                Integer postNameID = jsonResponse_listid.get(i);
                System.out.println(postNameID);
                if (postNameID == 3) {
                    String postNameDelete = String.valueOf(jsonResponse_delete.get(3));
                    System.out.println(postNameDelete);
                    System.out.println("Delete " + postNameDelete);
                    Boolean delete = response.jsonPath().get("isDelete");
                    System.out.println(delete);
                    softassert.assertEquals(delete, 1);
                    System.out.println(delete);
                }
            }
        }*//*

    }
*/
