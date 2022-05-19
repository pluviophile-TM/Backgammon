package sample;


import javafx.scene.shape.SVGPath;

public class SvgCus {

    String id;  //1 2 3 ... 24 ..25..26
    SVGPath svgPath;
    public int WhiteNum;
    public int BlackNum;
    NewStack stack;

    public SvgCus(String id, SVGPath svgPath, int whiteNum,NewStack stack) {
        this.id = id;
        this.svgPath = svgPath;
        this.WhiteNum = whiteNum;
        this.BlackNum = 25-whiteNum;
        this.stack=stack;
    }

    @Override
    public String toString() {
        return "SvgCus{" +
                "ID='" + id + '\'' +
                '}';
    }

}
