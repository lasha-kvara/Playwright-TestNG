package Tests;

import ApiMethods.Api;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.utils.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportListener.class)
public class ApiTests extends Api {

    @Test
    public void VerifySuccessfulGet(){
       String resp = ListUsers_Get();
       System.out.println(resp);
    }
    @Test
    public void VerifyGetResponseIsNotEmptyOrNull(){
        String resp = ListUsers_Get();

        // Verify if the response is not empty
        Assert.assertFalse(resp.trim().isEmpty(), "Response body should not be empty");
        // Verify if the response is not null
        Assert.assertNotNull(resp, "Response should not be null");
    }

    @Test
    public void VerifyGetResponseData(){
        int userId = 2;
        String expectedEmail = "janet.weaver@reqres.in";
        String expectedFirstName = "Janet";
        String expectedLastName = "Weaver";

        String resp = SingleUser_Get(userId);
        JsonObject jsonObject = JsonParser.parseString(resp).getAsJsonObject();

        // Extract the "data" from JsonObject
        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        // Extract "id", "email", "first_name" and "last_name"
        int id = dataObject.get("id").getAsInt();
        String email = dataObject.get("email").getAsString();
        String firstName = dataObject.get("first_name").getAsString();
        String lastName = dataObject.get("last_name").getAsString();

        // Print the results
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);

        // Verify if actual result equals expected values
        Assert.assertEquals(id, userId);
        Assert.assertEquals(firstName, expectedFirstName);
        Assert.assertEquals(lastName, expectedLastName);
        Assert.assertEquals(email, expectedEmail);

    }

    @Test
    public void VerifySuccessfulPost(){
        String name = "Neo";
        String job = "Tester";
        String resp = CreateUser_Post(name, job);
        System.out.println(resp);
    }

    @Test
    public void VerifyInvalidInputPost(){
        String resp = CreateUserWithInvalidBody_Post();
        System.out.println(resp);
    }

    @Test
    public void VerifySuccessfulDelete(){
        DeleteUser_Delete();
    }
}
