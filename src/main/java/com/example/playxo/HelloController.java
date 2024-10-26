package com.example.playxo;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    private char nowSymbol = '✖';
    private char[][] gameFild = new char[3][3];
    boolean isGame = true;

    @FXML
    private Label mainLableWinner;

    @FXML
    void ButtonClick(ActionEvent event) {
        Button butt = (Button) event.getSource(); //нажатая кнопка

        if (!isGame || butt.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(butt) == null ? 0 : GridPane.getRowIndex(butt);
        int colmIndex = GridPane.getColumnIndex(butt) == null ? 0 : GridPane.getColumnIndex(butt);

        gameFild[rowIndex][colmIndex] = nowSymbol;
        butt.setText(String.valueOf(nowSymbol));

        checkHorizontalMethod();
        checkVerticalMethod();
        checkDiagonalMethod();

        nowSymbol = nowSymbol == '✖' ? '◯' : '✖';
    }

    @FXML
    void textWinnerMassage() {
        String[] texts = new String[10];

        texts[0] = "Перемога завжди з тими,\n хто вірить у себе!";
        texts[1] = "Я — стратег і\n переможець!";
        texts[2] = "Ще один крок\n до величі!";
        texts[3] = "Моя тактика —\n моє майбутнє!";
        texts[4] = "Кожна перемога —\n це плід розуму і терпіння.";
        texts[5] = "Там, де є віра,\n завжди є успіх!";
        texts[6] = "Я вписав своє ім’я\n в історію гри!";
        texts[7] = "Виграв тут, \nвиграю й\n у житті!";
        texts[8] = "Сьогодні — перемога,\n завтра — нові\n вершини!";
        texts[9] = "Три в ряд, і\n це мій\n тріумф!";

        Random random = new Random();
        int randomNumber = random.nextInt(9);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,texts[randomNumber], ButtonType.FINISH);
        alert.setHeaderText("Player - " + nowSymbol + " You are winner!!!");
        alert.showAndWait();
        mainLableWinner.setText("YEEEEY");
    }

    private void checkHorizontalMethod(){
        if (gameFild[0][0] == gameFild[0][1] && gameFild[0][0] == gameFild[0][2] && (gameFild[0][0] == '✖' || gameFild[0][0] == '◯')) { //якщо не пуста ячейка
            textWinnerMassage();
            isGame = false;
        } else if (gameFild[1][0] == gameFild[1][1] && gameFild[1][0] == gameFild[1][2] && (gameFild[1][0] == '✖' || gameFild[1][0] == '◯')) {
            textWinnerMassage();
            isGame = false;
        } else if (gameFild[2][0] == gameFild[2][1] && gameFild[2][0] == gameFild[2][2] && (gameFild[2][0] == '✖' || gameFild[2][0] == '◯')) {
            textWinnerMassage();
            isGame = false;
        }
    }

    private void checkVerticalMethod(){
        if (gameFild[0][0] == gameFild[1][0] && gameFild[0][0] == gameFild[2][0] && (gameFild[0][0] == '✖' || gameFild[0][0] == '◯')) {
            textWinnerMassage();
            isGame = false;
        } else if (gameFild[0][1] == gameFild[1][1] && gameFild[0][1] == gameFild[2][1] && (gameFild[0][1] == '✖' || gameFild[0][1] == '◯')) {
            textWinnerMassage();
            isGame = false;
        } else if (gameFild[0][2] == gameFild[1][2] && gameFild[0][2] == gameFild[2][2] && (gameFild[0][2] == '✖' || gameFild[0][2] == '◯')) {
            textWinnerMassage();
            isGame = false;
        }
    }

    private void checkDiagonalMethod(){
        if (gameFild[0][0] == gameFild[1][1] && gameFild[0][0] == gameFild[2][2] && (gameFild[0][0] == '✖' || gameFild[0][0] == '◯')) {
            textWinnerMassage();
            isGame = false;
        }else if (gameFild[0][2] == gameFild[1][1] && gameFild[0][2] == gameFild[2][0] && (gameFild[0][2] == '✖' || gameFild[0][2] == '◯')) {
            textWinnerMassage();
            isGame = false;
        }
    }

    @FXML
    void initialize() {

    }
}
