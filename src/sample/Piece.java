package sample;

import javafx.scene.image.ImageView;

public class Piece {
    String id;
    String side;
    NewStack stack;
    ImageView image;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public NewStack getStack() {
        return stack;
    }

    public void setStack(NewStack stack) {
        this.stack = stack;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
