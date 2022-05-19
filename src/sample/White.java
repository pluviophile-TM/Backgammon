package sample;

import javafx.scene.image.ImageView;

public class White extends Piece {

    public White(String id,NewStack stack) {
        super.id = id;
        super.image = new ImageView("sample\\images\\white.png");
        super.side="White";
        super.image.setFitHeight(51);
        super.image.setFitWidth(92);
        super.stack=stack;
    }

}
