package tests;

import org.testng.annotations.Test;

public class ApiTest extends BaseTest{

    @Test
    public void createProjectTest() {
      projectAdapter.createProject(200);
    }

    @Test
    public void getAllProjectTest() {
        projectAdapter.getAllProject(200);
    }

    @Test
    public void getProjectByCodeTest() {
        projectAdapter.getProjectByCode("DEMO", 200);
    }

    @Test
    public void deleteProjectByCodeTest() {
        projectAdapter.deleteProjectByCode("PUG", 200);
    }

}
