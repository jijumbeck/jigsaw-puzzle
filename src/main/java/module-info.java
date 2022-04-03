module edu.jijumbeck.jigsawpuzzle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens edu.jijumbeck.jigsawpuzzle to javafx.fxml;
    exports edu.jijumbeck.jigsawpuzzle;
}