package TestCases.RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

//import io.restassured.mapper.ObjectMapper;

public class BreakingBadInfo {

    public Response response;
    private static String jsonString;
    private static String token;

    @Test
    public void getWWInformation() {

        Response response1 = RestAssured.get("https://breakingbadapi.com/api/characters/");
        RestAssured.baseURI = "https://www.breakingbadapi.com/api/";
        RestAssured.basePath = "characters/";

        String birthdayWW = given().
                get("https://breakingbadapi.com/api/characters/1").
                then().extract().path("birthday").toString();

        System.out.println("Walter White Birthday is: "+birthdayWW);
    }

    @Test
    public void printCharactersInfo() throws JsonProcessingException {

        POJO pojo = new POJO();

       String characterNames = given()
                .when()
                .body(pojo)
                .get("https://breakingbadapi.com/api/characters/")
               .then()
               .extract()
               .path("name").toString();

        String characterPortrayed = given()
                .when()
                .body(pojo)
                .get("https://breakingbadapi.com/api/characters/")
                .then()
                .extract()
                .path("portrayed")
                .toString();

       List<Object> pojo1 = RestAssured
               .get("https://breakingbadapi.com/api/characters/")
               .then()
               .extract()
               .as(List.class);

        System.out.println();
        System.out.println("The number of entries are: "+pojo1.size());
        System.out.println();
        Map<String, Object> name = (Map<String, Object>) pojo1.get(0);
        for (int i = 0; i < pojo1.size(); i++) {
             name = (Map<String, Object>) pojo1.get(i);
            System.out.println();
            System.out.println("Character name: " +name.get("name"));
            System.out.println("Portrayed: "+name.get("portrayed"));
            System.out.println();
            System.out.println("==============================");

        }

    }
}
