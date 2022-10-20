package adapters;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import models.Project;

public class ProjectAdapter extends BaseAdapters {

    public void createProject(int statusCode) {
        Project project = new Project();
        Faker faker = new Faker();
        project.setCode(faker.animal().name());
        project.setTitle(faker.animal().name());
        String body = new Gson().toJson(project);
        post(body,"v1/project",statusCode);
    }

    public void getAllProject(int statusCode) {
        get("v1/project", statusCode);
    }

    public void getProjectByCode(String code, int statusCode ) {
        get("v1/project/" + code  ,statusCode);
    }

    public void deleteProjectByCode(String code, int statusCode) {
        get("v1/project/" + code  ,statusCode);
    }
}
