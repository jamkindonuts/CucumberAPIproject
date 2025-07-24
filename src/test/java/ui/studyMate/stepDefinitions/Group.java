package ui.studyMate.stepDefinitions;

import ui.studyMate.pages.GroupsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class Group {

        GroupsPage groupsPage=new GroupsPage();
        String groupName;


        @When("I go to groups page")
        public void i_go_to_groups_page() {
            groupsPage.goToGroups();
        }
        @When("I create group with name {string}, description {string}, date {string}, and upload file {string}")
        public void i_create_group_with_name_description_date_and_upload_file(String name, String description, String date, String image) {
            Random random = new Random();
            int randomDigits = random.nextInt(100);
            groupName = name + randomDigits;
            groupsPage.createGroup(groupName, description, date, image);
        }
        @When("I edit the group name to {string}")
        public void i_edit_the_group_name_to(String newName) {
            groupsPage.editGroup(newName, groupName);
            groupName = newName;
        }
        @When("I delete group")
        public void i_delete_group() {
            groupsPage.deleteGroup(groupName);
        }
        @Then("The group should be deleted")
        public void the_group_should_be_deleted() {
            groupsPage.verifyGroupDeleted(groupName);

        }

    }

