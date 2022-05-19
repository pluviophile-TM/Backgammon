package sample;

import java.util.Stack;

public class NewStack {


    public Stack<Piece> stack = new Stack<>();
    public int whiteNum;
    public int BlackNum;

    public NewStack( int whiteNum) {
        this.whiteNum = whiteNum;
        BlackNum = 25-whiteNum;
    }



    @Override
    public String toString() {
        return "newStack{" +
                "position whNum='" + whiteNum + '\'' +
                '}';
    }

}
