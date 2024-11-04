package org.example.hsf301.navigate;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.controllers.MyProfileController;
import org.example.hsf301.controllers.TourController;
import org.example.hsf301.controllers.TourManagementController;
import org.example.hsf301.pojo.Account;
import org.example.hsf301.service.AccountService;
import org.example.hsf301.service.TourService;
import org.example.hsf301.utils.NavigateUtil;

public interface Navigable {

    // Default method to navigate to the Home page
    default void navigateHome(StackPane contentArea) throws IOException {
        setContent("home", contentArea);
    }

    // Default method to navigate to the Tours page
    default void navigateTour(StackPane contentArea) throws IOException {
        setContent("tour", contentArea);
    }

    // Default method to navigate to the Bookings page
    default void navigateBooking(StackPane contentArea) throws IOException {
        setContent("booking", contentArea);
    }

    // Default method to navigate to the Settings page
    default void navigateSetting(StackPane contentArea) throws IOException {
        setContent("setting", contentArea);
    }

    default void navigateKoi(StackPane contentArea) throws IOException {
        setContent("koi", contentArea);
    }

    default void navigateStaff(StackPane contentArea) throws IOException {
        setContent("staff", contentArea);
    }

    //navigateMyProfile
    default void navigateMyProfile(StackPane contentArea) throws IOException {
        setContent("my_profile", contentArea);
    }

    //navigateFarm
    default void navigateFarm(StackPane contentArea) throws IOException {
        setContent("farm", contentArea);
    }

    default void navigateLogout(StackPane contentArea) throws IOException {
        NavigateUtil.navigateTo(ResourcePaths.LOGIN_VIEW, contentArea, 830, 650, "Hello!");
    }

    default void navigateTourHomePage(StackPane contentArea) throws IOException {
        setContent("tours_home_page", contentArea);
    }

    //Management
    default void navigateTourManagement(StackPane contentArea) throws IOException {
        setContent("tours_management", contentArea);
    }

    // Method to load and set the content in the provided contentArea
    default void setContent(String page, StackPane contentArea) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            Objects.requireNonNull(
                getClass().getResource("/org/example/hsf301/fxml/" + page + ".fxml")));

        // preload on startup with initialize method
        //preload data when customer login
        if (page.equals("tours_home_page")) {
            TourService tourService = new TourService(ResourcePaths.HIBERNATE_CONFIG);
            TourController tourController = new TourController(tourService);
            loader.setController(tourController);
        }

        //tours_management
        if (page.equals("tours_management")) {
            TourService tourService = new TourService(ResourcePaths.HIBERNATE_CONFIG);
            TourManagementController tourManagementController = new TourManagementController(
                tourService);
            loader.setController(tourManagementController);
        }

        //my_profile
        if (page.equals("my_profile")) {
            AccountService accountService = new AccountService(ResourcePaths.HIBERNATE_CONFIG);
            MyProfileController myProfileController = new MyProfileController(accountService);
            loader.setController(myProfileController);
        }

        //preload data when admin login

        //preload data when staff login

        Node pageContent = loader.load();
        contentArea.getChildren().clear();
        contentArea.getChildren().add(pageContent);
    }
}