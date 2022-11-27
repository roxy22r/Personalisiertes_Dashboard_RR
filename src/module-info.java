module com.example.personalisiertes_dashboard_rr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.personalisiertes_dashboard_rr to javafx.fxml;
    exports ch.rr.calender;
    opens ch.rr.calender to javafx.fxml;
    exports ch.rr.Joke;
    opens ch.rr.Joke to javafx.fxml;
    exports ch.rr.StockMarket;
    opens ch.rr.StockMarket to javafx.fxml;
}