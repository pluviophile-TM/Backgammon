package sample;

import javafx.scene.image.ImageView;

public class Dice {


    int num;
    ImageView imageView;

    public Dice(int num,ImageView imageView) {
        this.num = num;
        this.imageView=imageView;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
