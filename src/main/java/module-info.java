module zero.saiyi.cssdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    opens zero.saiyi.cssdemo to javafx.fxml;
    exports zero.saiyi.cssdemo;
}