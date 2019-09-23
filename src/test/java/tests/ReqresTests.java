package tests;

import adapters.UsersAdapter;
import models.JobUser;
import models.SingleUser;
import models.UsersList;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.testng.Assert.assertEquals;

public class ReqresTests extends BaseTest {

    @Test
    public void testList() throws FileNotFoundException {
        UsersList expectedList;
        expectedList = gson.fromJson(new FileReader("src/test/java/resources/expectedList.json"), UsersList.class);

        UsersList list = new UsersAdapter().getUserList(1);
        assertEquals(list, expectedList);
    }

    @Test
    public void createUser() {
        JobUser user = new UsersAdapter().post(new JobUser("name", "job", "", ""));
        System.out.println(user);
    }

    @Test
    public void getSingleUser() throws FileNotFoundException {
        SingleUser singleUser = new UsersAdapter().getUser(4);
        System.out.println(singleUser);

        SingleUser expectedSingleUser;
        expectedSingleUser = gson.fromJson(new FileReader("src/test/java/resources/singleUser.json"), SingleUser.class);

        assertEquals(expectedSingleUser, singleUser);
    }

    @Test
    public void getSingleUserNotFound() throws FileNotFoundException {
        SingleUser singleUser = new UsersAdapter().getUser(23);
        System.out.println(singleUser);

        SingleUser expectedSingleUser;
        expectedSingleUser = gson.fromJson(new FileReader("src/test/java/resources/singleUserNotFound.json"), SingleUser.class);

        assertEquals(expectedSingleUser, singleUser);
    }
}
