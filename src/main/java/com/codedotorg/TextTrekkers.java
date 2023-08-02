package com.codedotorg;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextTrekkers {

    /** The text box that displays the results */
    private TextArea gameplay;

    /** Whether or not the player has the key */
    private boolean hasKey;

    /** Whether or not the door is locked */
    private boolean doorLocked;

    /** The label to tell the user where to type */
    private Label inputLabel;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructor for the TextTrekkers class.
     * Initializes the gameplay area as a TextArea with wrap text enabled.
     * Sets the initial game state where the player does not have the key
     * and the door is not locked. Also initializes the input label and
     * input field for user commands.
     */
    public TextTrekkers() {
        gameplay = new TextArea();
        gameplay.setWrapText(true);

        hasKey = false;
        doorLocked = false;

        inputLabel = new Label("Enter your command:");
        inputField = new TextField();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage and shows the main scene.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("TextTrekkers");
        showMainScene(primaryStage);
    }

    /**
     * Displays the main scene of the game.
     * It sets the action for the input field, creates the layout for the scene,
     * and then sets and shows this scene on the primary stage.
     *
     * @param primaryStage The primary stage on which the scene is to be set and shown.
     */
    public void showMainScene(Stage primaryStage) {
        setInputFieldAction();

        HBox inputLayout = new HBox(inputLabel, inputField);
        VBox layout = new VBox(gameplay, inputLayout);
        Scene mainScene = new Scene(layout, 300, 200);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Processes the user's command in a text-based adventure game.
     * The command is converted to lowercase to ensure case-insensitive comparison.
     * 
     * The following commands are supported:
     * - "go north": The user attempts to go north, and the method returns a
     *               description of what they see.
     * - "pick up key": The user attempts to pick up a key. If successful, the method
     *                  updates the hasKey variable and returns a success message.
     * - "use key": The user attempts to use a key they have picked up. If the user has
     *              a key, the method unlocks the door and returns a success message. If
     *              the user doesn't have a key, the method returns a failure message.
     * - "open door": The user attempts to open a door. If the door is unlocked, the method
     *                returns a success message indicating the user has won. If the door is
     *                locked, the method returns a failure message.
     * 
     * If the command is not recognized, the method returns a message indicating the command
     * was not understood.
     * 
     * @param input The user's command.
     * @return A string describing the result of the user's command.
     */
    public String processCommand(String input) {
        
        return "";
    }

    /**
     * Sets an action on the input field. When an action is performed on the
     * input field (typically when the user presses Enter), it gets the text
     * from the input field and appends it to the gameplay text area prefixed
     * with "You: ". Then it processes the input text as a command and gets a
     * response, which is also appended to the gameplay text area but prefixed
     * with "Game: ". Finally, it clears the input field for the next input.
     */
    private void setInputFieldAction() {
        inputField.setOnAction(event -> {
            String input = inputField.getText();
            gameplay.appendText("You: " + input + "\n");
            String response = processCommand(input);
            gameplay.appendText("Game: " + response + "\n");
            inputField.clear();
        });
    }

}
