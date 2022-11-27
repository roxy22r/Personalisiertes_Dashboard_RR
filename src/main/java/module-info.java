module ch.rr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports ch.rr.calender;
    opens ch.rr.calender to javafx.fxml;
    exports ch.rr.joke;
    opens ch.rr.joke to javafx.fxml;
    exports ch.rr.stock;

    opens ch.rr.stock to javafx.fxml;
    exports ch.rr.calender.model;
    opens ch.rr.calender.model to javafx.fxml;
}