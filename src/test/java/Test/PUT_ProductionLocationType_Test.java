package Test;

import Base.Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PUT_ProductionLocationType_Test extends Base {

        public static HashMap map = new HashMap<>();
        @BeforeTest()
        public void BeforeMethod(){

            map.put("id",2);
            map.put("name",generateRandomDataforName());
            map.put("regionId",1);
            map.put("isDelete", true);
            map.put("isActive",true );

            System.out.println(map);
        }

        @Test(priority = 1,description = "200 Success")
        public void PUT_Update_Success() throws InterruptedException, IOException {

            given().headers("Authorization","Bearer "/*+ token*/).
                    contentType("application/json").
                    body(map).
                    when().
                    put(PRODUCTIONLOCATIONTYPE_PAGE_URL + "/Update?id="+2).
                    then().
                    statusCode(204).log().all();
        }

        @Test (priority = 2)
        public void PUT_Update_Assert_Test() throws InterruptedException, IOException {

            Response response = doGetRequest(PRODUCTIONLOCATIONTYPE_PAGE_URL);
            List<Integer> jsonResponse_listid = doGetResponseListID(response);
            List<String> jsonResponse_name = doGetResponseName(response);

            for (int i = 0; i < jsonResponse_listid.size(); i++) {
                Integer postNameID = jsonResponse_listid.get(i);
                System.out.println(postNameID);
                if(postNameID == 2 ) {
                    String postNameData = jsonResponse_name.get(i);
                    System.out.println(postNameData);
                    System.out.println("Client Name " + postNameData);

                    Assert.assertEquals(postNameData, map.get("name"));
                    System.out.println(postNameData);
                    System.out.println(map.get("name"));
                }
            }

        }
    }

