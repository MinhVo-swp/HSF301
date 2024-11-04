package org.example.hsf301.layouts;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import org.example.hsf301.controllers.LoginController;
import org.example.hsf301.navigate.Navigable;

public class MainController implements Initializable, Navigable {

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Set tours_home_page as the default content when the app starts
            setContent("tours_home_page", contentArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler for navigating to the Home page
    @FXML
    private void navigateHome() throws IOException {
        navigateHome(contentArea);
    }

    @FXML
    private void navigateMyProfile() throws IOException {
        navigateMyProfile(contentArea);
    }

    // Handler for navigating to the Tours page
    @FXML
    private void navigateTour() throws IOException {
        navigateTourHomePage(contentArea);
    }

    // Handler for navigating to the Bookings page
    @FXML
    private void navigateBooking() throws IOException {
        navigateBooking(contentArea);
    }

    @FXML
    private void navigateLogout() throws IOException {
        navigateLogout(contentArea);
    }
}