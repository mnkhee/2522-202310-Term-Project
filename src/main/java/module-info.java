module ca.bcit.comp2522.termproject.comp2522202310termproject360 {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
            requires com.almasb.fxgl.all;
    
    opens ca.bcit.comp2522.termproject.comp2522202310termproject360 to javafx.fxml;
    exports ca.bcit.comp2522.termproject.comp2522202310termproject360;
}