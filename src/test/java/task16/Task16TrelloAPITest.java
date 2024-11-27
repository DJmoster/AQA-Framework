package task16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sviat.dev.task13.MyExecutionListener;
import sviat.dev.task13.MyTestListener;

import static io.restassured.RestAssured.given;

/**
 * V6.
 Create a new checklist on a card. Check that the API call returns a success status code and that the checklist is created with the name provided in the API call.
 Add an item to the checklist. Check that the API call returns a success status code and that the item is added to the checklist.
 Update the name of the checklist. Check that the API call returns a success status code and that the name of the checklist is updated as expected.
 Delete the checklist. Check that the API call returns a success status code and that the checklist is deleted from the card.
 */
@Listeners({MyExecutionListener.class})
public class Task16TrelloAPITest {
    private final String API_KEY = "";
    private final String API_TOKEN = "";
    private final String BOARD_ID = "67351d2d0d203cd5ec60c943";

    private String listId;
    private String cardId;
    private String checkListId;

    @Test
    void getBoardLists() {
        Response response = given()
                .header("Accept", "application/json")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .get("https://api.trello.com/1/boards/" + BOARD_ID + "/lists")
                .then()
                .statusCode(200)
                .extract().response();

        listId = response.jsonPath().getString("[0].id");
    }

    @Test(dependsOnMethods = {"getBoardLists"})
    void createCard() {
        Response response = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("idList", listId)
                .queryParam("name", "TestCardName")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .post("https://api.trello.com/1/cards")
                .then()
                .statusCode(200)
                .extract().response();

        cardId = response.jsonPath().getString("id");

        Assert.assertEquals(response.jsonPath().getString("name"), "TestCardName", "Card name is not valid!");
    }

    @Test(dependsOnMethods = {"createCard"})
    void createCheckList() {
        Response response = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("idCard", cardId)
                .queryParam("name", "TestCheckListName")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .post("https://api.trello.com/1/checklists")
                .then()
                .statusCode(200)
                .extract().response();

        checkListId = response.jsonPath().getString("id");

        Assert.assertEquals(response.jsonPath().getString("name"), "TestCheckListName", "Check list name is not valid!");
        Assert.assertEquals(response.jsonPath().getString("idCard"), cardId, "Card id is not valid!");
    }

    @Test(dependsOnMethods = {"createCheckList"})
    void createCheckListItem() {
        Response response = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("name", "TestCheckListItemName")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .post("https://api.trello.com/1/checklists/" + checkListId + "/checkItems")
                .then()
                .statusCode(200)
                .extract().response();


        Assert.assertEquals(response.jsonPath().getString("name"), "TestCheckListItemName", "Check list item name is not valid!");
        Assert.assertEquals(response.jsonPath().getString("idChecklist"), checkListId, "Check list id is not valid!");
    }

    @Test(dependsOnMethods = {"createCheckList"})
    void updateCheckListName() {
        Response response = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("name", "TestCheckListNameUpdated")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .put("https://api.trello.com/1/checklists/" + checkListId)
                .then()
                .statusCode(200)
                .extract().response();


        Assert.assertEquals(response.jsonPath().getString("name"), "TestCheckListNameUpdated", "Check list name is not valid!");
        Assert.assertEquals(response.jsonPath().getString("idCard"), cardId, "Card id is not valid!");
    }

    @Test(dependsOnMethods = {"createCheckList", "createCheckListItem", "updateCheckListName"})
    void deleteCheckList() {
        given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .delete("https://api.trello.com/1/checklists/" + checkListId)
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(dependsOnMethods = {"createCard", "createCheckList", "createCheckListItem", "updateCheckListName", "deleteCheckList"})
    void deleteCard() {
        given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .delete("https://api.trello.com/1/cards/" + cardId)
                .then()
                .statusCode(200)
                .extract().response();
    }

}
