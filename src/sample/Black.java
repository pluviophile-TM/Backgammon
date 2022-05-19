package sample;

import javafx.scene.image.ImageView;

public class Black extends Piece {

    public Black(String id,NewStack stack){
        super.id=id;
        super.stack=stack;
        super.image = new ImageView("sample\\images\\black.png");
        super.image.setFitHeight(51);
        super.image.setFitWidth(92);
        super.side="Black";

    }

}
