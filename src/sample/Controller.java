package sample;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {


    @FXML SVGPath infernoBlack;
    @FXML SVGPath infernoWhite;

    @FXML SVGPath ul1;
    @FXML SVGPath ul2;
    @FXML SVGPath ul3;
    @FXML SVGPath ul4;
    @FXML SVGPath ul5;
    @FXML SVGPath ul6;

    @FXML SVGPath ur1;
    @FXML SVGPath ur2;
    @FXML SVGPath ur3;
    @FXML SVGPath ur4;
    @FXML SVGPath ur5;
    @FXML SVGPath ur6;

    @FXML SVGPath dl1;
    @FXML SVGPath dl2;
    @FXML SVGPath dl3;
    @FXML SVGPath dl4;
    @FXML SVGPath dl5;
    @FXML SVGPath dl6;

    @FXML SVGPath dr1;
    @FXML SVGPath dr2;
    @FXML SVGPath dr3;
    @FXML SVGPath dr4;
    @FXML SVGPath dr5;
    @FXML SVGPath dr6;

    @FXML AnchorPane MainGraph;
    @FXML TextField turn;
    @FXML Button diceButton;

    List<ImageView> list = new ArrayList<ImageView>();
    ObservableList<ImageView> observableList = FXCollections.observableList(list);


    ArrayList<NewStack>stackList=new ArrayList<>();
    ArrayList <Dice> diceRoll  = new ArrayList<>();
    ArrayList <SvgCus> selectors = new ArrayList<>();
    ArrayList <Integer> BanndedDice = new ArrayList<>();

    NewStack whiteInferSt=new NewStack(-1);
    NewStack blackInferSt=new NewStack(26);

    NewStack whiteBar =new NewStack(0);
    NewStack blackBar =new NewStack(25);

    boolean thisTurn=false;
    Piece lastSelect=null;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        System.out.println("Initialize:[INVOKED]");

        //**Stacks**//
        stackList.add(whiteBar); //index 0 white bar
        for(int i=1;i<=24;i++){
            NewStack stack=new NewStack(i);
            stackList.add(stack);
        }
        stackList.add(blackBar); //index 25 black bar


        infernoWhite.setVisible(false);
        SvgCus sinfernoWhite = new SvgCus("-1",infernoWhite,-1,whiteInferSt);
        selectors.add(sinfernoWhite);
        infernoWhite.setOnMouseClicked(event ->svgClicked(sinfernoWhite));

        infernoBlack.setVisible(false);
        SvgCus sinfernoBlack = new SvgCus("26",infernoBlack,26,blackInferSt);
        selectors.add(sinfernoBlack);
        infernoBlack.setOnMouseClicked(event ->svgClicked(sinfernoBlack));

        ul1.setVisible(false);
        SvgCus sul1 = new SvgCus("7",ul1,7,stackList.get(7));
        selectors.add(sul1);
        ul1.setOnMouseClicked(event ->svgClicked(sul1));

        ul2.setVisible(false);
        SvgCus sul2 = new SvgCus("8",ul2,8,stackList.get(8));
        selectors.add(sul2);
        ul2.setOnMouseClicked(event ->svgClicked(sul2));

        ul3.setVisible(false);
        SvgCus sul3 = new SvgCus("9",ul3,9,stackList.get(9));
        selectors.add(sul3);
        ul3.setOnMouseClicked(event ->svgClicked(sul3));

        ul4.setVisible(false);
        SvgCus sul4 = new SvgCus("10",ul4,10,stackList.get(10));
        selectors.add(sul4);
        ul4.setOnMouseClicked(event ->svgClicked(sul4));

        ul5.setVisible(false);
        SvgCus sul5 = new SvgCus("11",ul5,11,stackList.get(11));
        selectors.add(sul5);
        ul5.setOnMouseClicked(event ->svgClicked(sul5));

        ul6.setVisible(false);
        SvgCus sul6 = new SvgCus("12",ul6,12,stackList.get(12));
        selectors.add(sul6);
        ul6.setOnMouseClicked(event ->svgClicked(sul6));

        ur1.setVisible(false);
        SvgCus sur1 = new SvgCus("6",ur1,6,stackList.get(6));
        selectors.add(sur1);
        ur1.setOnMouseClicked(event ->svgClicked(sur1));

        ur2.setVisible(false);
        SvgCus sur2 = new SvgCus("5",ur2,5,stackList.get(5));
        selectors.add(sur2);
        ur2.setOnMouseClicked(event ->svgClicked(sur2));

        ur3.setVisible(false);
        SvgCus sur3 = new SvgCus("4",ur3,4,stackList.get(4));
        selectors.add(sur3);
        ur3.setOnMouseClicked(event ->svgClicked(sur3));

        ur4.setVisible(false);
        SvgCus sur4 = new SvgCus("3",ur4,3,stackList.get(3));
        selectors.add(sur4);
        ur4.setOnMouseClicked(event ->svgClicked(sur4));

        ur5.setVisible(false);
        SvgCus sur5 = new SvgCus("2",ur5,2,stackList.get(2));
        selectors.add(sur5);
        ur5.setOnMouseClicked(event ->svgClicked(sur5));

        ur6.setVisible(false);
        SvgCus sur6 = new SvgCus("1",ur6,1,stackList.get(1));
        selectors.add(sur6);
        ur6.setOnMouseClicked(event ->svgClicked(sur6));

        dl1.setVisible(false);
        SvgCus sdl1 = new SvgCus("18",dl1,18,stackList.get(18));
        selectors.add(sdl1);
        dl1.setOnMouseClicked(event ->svgClicked(sdl1));

        dl2.setVisible(false);
        SvgCus sdl2 = new SvgCus("17",dl2,17,stackList.get(17));
        selectors.add(sdl2);
        dl2.setOnMouseClicked(event ->svgClicked(sdl2));

        dl3.setVisible(false);
        SvgCus sdl3 = new SvgCus("16",dl3,16,stackList.get(16));
        selectors.add(sdl3);
        dl3.setOnMouseClicked(event ->svgClicked(sdl3));

        dl4.setVisible(false);
        SvgCus sdl4 = new SvgCus("15",dl4,15,stackList.get(15));
        selectors.add(sdl4);
        dl4.setOnMouseClicked(event ->svgClicked(sdl4));

        dl5.setVisible(false);
        SvgCus sdl5 = new SvgCus("14",dl5,14,stackList.get(14));
        selectors.add(sdl5);
        dl5.setOnMouseClicked(event ->svgClicked(sdl5));

        dl6.setVisible(false);
        SvgCus sdl6 = new SvgCus("13",dl6,13,stackList.get(13));
        selectors.add(sdl6);
        dl6.setOnMouseClicked(event ->svgClicked(sdl6));

        dr1.setVisible(false);
        SvgCus sdr1 = new SvgCus("19",dr1,19,stackList.get(11));
        selectors.add(sdr1);
        dr1.setOnMouseClicked(event ->svgClicked(sdr1));

        dr2.setVisible(false);
        SvgCus sdr2 = new SvgCus("20",dr2,20,stackList.get(20));
        selectors.add(sdr2);
        dr2.setOnMouseClicked(event ->svgClicked(sdr2));

        dr3.setVisible(false);
        SvgCus sdr3 = new SvgCus("21",dr3,21,stackList.get(21));
        selectors.add(sdr3);
        dr3.setOnMouseClicked(event ->svgClicked(sdr3));

        dr4.setVisible(false);
        SvgCus sdr4 = new SvgCus("22",dr4,22,stackList.get(22));
        selectors.add(sdr4);
        dr4.setOnMouseClicked(event ->svgClicked(sdr4));

        dr5.setVisible(false);
        SvgCus sdr5 = new SvgCus("23",dr5,23,stackList.get(23));
        selectors.add(sdr5);
        dr5.setOnMouseClicked(event ->svgClicked(sdr5));

        dr6.setVisible(false);
        SvgCus sdr6 = new SvgCus("24",dr6,24,stackList.get(24));
        selectors.add(sdr6);
        dr6.setOnMouseClicked(event ->svgClicked(sdr6));

        for (int i=1;i<3;i++){
            White u = new White(i+"",stackList.get(1));
            stackList.get(1).stack.add(u);
            u.getImage().setFitHeight(51);
            u.getImage().setFitWidth(92);
            u.getImage().setLayoutX(820);
            u.getImage().setLayoutY(i*40);
            u.getImage().setOnMouseClicked(event->pieceClicked(u));
            MainGraph.getChildren().add(u.getImage());
        }

        for (int i=1;i<6;i++){
            White u = new White((i+2)+"",stackList.get(12));
            stackList.get(12).stack.add(u);
            u.getImage().setFitHeight(51);
            u.getImage().setFitWidth(92);
            u.getImage().setLayoutX(260);
            u.getImage().setLayoutY(i*40);
            u.getImage().setOnMouseClicked(event->pieceClicked(u));
            MainGraph.getChildren().add(u.getImage());
        }

        for (int i=1;i<4;i++){
            White u = new White((i+7)+"",stackList.get(17));
            stackList.get(17).stack.add(u);
            u.getImage().setFitHeight(51);
            u.getImage().setFitWidth(92);
            u.getImage().setLayoutX(450);
            u.getImage().setLayoutY(490-((i-1)*40));
            u.getImage().setOnMouseClicked(event->pieceClicked(u));
            MainGraph.getChildren().add(u.getImage());
        }

        for (int i=1;i<6;i++){
            White u = new White((i+10)+"",stackList.get(19));
            stackList.get(19).stack.add(u);
            u.getImage().setFitHeight(51);
            u.getImage().setFitWidth(92);
            u.getImage().setLayoutX(580);
            u.getImage().setLayoutY(490-((i-1)*40));
            u.getImage().setOnMouseClicked(event->pieceClicked(u));
            MainGraph.getChildren().add(u.getImage());
        }

        for (int i=1;i<3;i++){
            Black b = new Black(i+"",stackList.get(24));
            stackList.get(24).stack.add(b);
            b.getImage().setFitHeight(51);
            b.getImage().setFitWidth(92);
            b.getImage().setLayoutX(820);
            b.getImage().setLayoutY(490-((i-1)*40));
            b.getImage().setOnMouseClicked(event->pieceClicked(b));
            MainGraph.getChildren().add(b.getImage());
        }

        for (int i=1;i<6;i++){
            Black b = new Black((i+2)+"",stackList.get(13));
            stackList.get(13).stack.add(b);
            b.getImage().setFitHeight(51);
            b.getImage().setFitWidth(92);
            b.getImage().setLayoutX(260);
            b.getImage().setLayoutY(490-((i-1)*40));
            b.getImage().setOnMouseClicked(event->pieceClicked(b));
            MainGraph.getChildren().add(b.getImage());
        }

        for (int i=1;i<4;i++){
            Black b = new Black((i+7)+"",stackList.get(8));
            stackList.get(8).stack.add(b);
            b.getImage().setFitHeight(51);
            b.getImage().setFitWidth(92);
            b.getImage().setLayoutX(450);
            b.getImage().setLayoutY(i*40);
            b.getImage().setOnMouseClicked(event->pieceClicked(b));
            MainGraph.getChildren().add(b.getImage());
        }

        for (int i=1;i<6;i++){
            Black b = new Black((i+10)+"",stackList.get(6));
            stackList.get(6).stack.add(b);
            b.getImage().setFitHeight(51);
            b.getImage().setFitWidth(92);
            b.getImage().setLayoutX(580);
            b.getImage().setLayoutY(i*40);
            b.getImage().setOnMouseClicked(event->pieceClicked(b));
            MainGraph.getChildren().add(b.getImage());
        }



    }

    public void RollDice(){
        downLight();
        if(observableList.size()!=0){
            MainGraph.getChildren().removeAll(observableList);
            observableList.clear();
        }
        diceRoll.clear();

        Random rnd = new Random();
        int first = rnd.nextInt(6)+1;
        int second = rnd.nextInt(6)+1;
        System.out.println("-----------------------");
        System.out.println("dice1 "+first);
        System.out.println("dice2 "+second);
        System.out.println("-----------------------");

        if (first==second){
            for (int i=0;i<4;i++){
                ImageView roll = new ImageView("sample\\images\\dice-decoy\\dice" + (first) + ".png");
                Dice dice=new Dice(first,roll);
                roll.setLayoutX(270+(i*40));
                roll.setLayoutY(150);
                roll.setFitWidth(300);
                roll.setFitHeight(300);
                diceRoll.add(dice);
                observableList.add(dice.imageView);
            }
        }
        else{
            ImageView roll = new ImageView("sample\\images\\dice-decoy\\dice" + (first) + ".png");
            roll.setLayoutX(270);
            roll.setLayoutY(150);
            roll.setFitWidth(300);
            roll.setFitHeight(300);
            Dice dice1=new Dice(first,roll);
            diceRoll.add(dice1);
            observableList.add(dice1.imageView);

            ImageView roll2 = new ImageView("sample\\images\\dice-decoy\\dice" + (second) + ".png");
            roll2.setLayoutX(310);
            roll2.setLayoutY(150);
            roll2.setFitWidth(300);
            roll2.setFitHeight(300);
            Dice dice2=new Dice(second,roll2);
            diceRoll.add(dice2);
            observableList.add(dice2.imageView);
        }


        MainGraph.getChildren().addAll(observableList);

        turnMaker();

    }

    private void turnMaker() {
        thisTurn=!thisTurn;
        if (thisTurn){
            turn.setText("player one");
        }else {
            turn.setText("player two");
        }
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Turn ");
//        if(thisTurn)
//            alert.setHeaderText("player one");
//        else
//            alert.setContentText("player two");
//        alert.showAndWait();

        findPiece();
    }

    private void findPiece(){
        if(thisTurn){ // true white
            if(whiteBar.stack.size()>0){
                lastSelect=whiteBar.stack.peek();
                checkBar();
            }
            else if(AllMoveOut(thisTurn)){ // change from tahmine
                highLightOuter();
               // infernoWhite.setVisible(true);
            }
            else {
                for(NewStack stack:stackList){
                    if(stack.stack.isEmpty())
                        continue;
                    if(stack.stack.peek().side.equals("Black"))
                        continue;
                    for(Dice dice:diceRoll){
                        int d=dice.getNum()+stack.whiteNum;
                        if(d>24){
                                continue;
                        }
                        else if(canMoveTO(stackList.get(d))){
                            System.out.println("highlight white");
                            highLight(stack.stack.peek());
                        }
                    }
                }
            }
        }
        else{
            if(blackBar.stack.size()>0){
                lastSelect=blackBar.stack.peek();
                checkBar();
            }
            else if(AllMoveOut(false)){ // change from tahmine // check for black turn
                highLightOuter();
                //infernoBlack.setVisible(true);
            }
            //else {
                for(NewStack stack:stackList){
                    if(stack.stack.isEmpty())
                        continue;
                    if(stack.stack.peek().side.equals("White"))
                        continue;
                    for(Dice dice:diceRoll){
                        int d=dice.getNum()+stack.BlackNum;
                        if(d>24){
                            continue;
                        }
                        else if(canMoveTO(stackList.get(25-d))){
                            System.out.println("highlight Black");
                            highLight(stack.stack.peek());
                        }
                    }
                }
            //}
        }
    }

    private void highLightOuter() {
        boolean x=false;
        boolean y=false;
        if(thisTurn){
            for(Dice dice:diceRoll){
                int d=25-dice.getNum();
                if(stackList.get(d).stack.size()>0){
                    if(stackList.get(d).stack.peek().side.equals("White")){
                        highLight(stackList.get(d).stack.peek());
                        x=true;
                    }
                }
                for(int i=19;i<24;i++){
                    int des=i+dice.getNum();
                    if(des<25&&stackList.get(i).stack.size()>0&&stackList.get(i).stack.peek().side.equals("White")){
                        y=true;
                        highLight(stackList.get(i).stack.peek());
                    }
                }
            }

            if(!x&&!y){
                System.out.println("---just get out--------");
               for(Dice dice:diceRoll){
                   for(int i=19;i<25;i++){
                       if(stackList.get(i).stack.size()>0){
                           if(stackList.get(i).stack.peek().side.equals("White")){
                               if(i+dice.getNum()>24){
                                   highLight(stackList.get(i).stack.peek());
                               }
                               else if(canMoveTO(stackList.get(i+dice.getNum()))){
                                   highLight(stackList.get(i).stack.peek());
                               }
                           }
                       }
                   }
               }
            }
        }
        else {
            for(Dice dice:diceRoll){
                int d=dice.getNum();
                if(stackList.get(d).stack.size()>0){
                    if(stackList.get(d).stack.peek().side.equals("Black")){
                        highLight(stackList.get(d).stack.peek());
                        x=true;
                    }
                }
                for(int i=6;i<1;i--){
                    int des=i-dice.getNum();
                    if(des>0&&stackList.get(i).stack.size()>0&&stackList.get(i).stack.peek().side.equals("Black")){
                        y=true;
                        highLight(stackList.get(i).stack.peek());
                    }
                }
            }
            if(!x&&!y){
                for(Dice dice:diceRoll){
                    for(int i=1;i<6;i++){
                        if(stackList.get(i).stack.size()>0){
                            if(stackList.get(i).stack.peek().side.equals("Black")){
                                if(dice.getNum()>i){
                                    highLight(stackList.get(i).stack.peek());
                                }
                                else if(canMoveTO(stackList.get(i-dice.getNum()))){
                                    highLight(stackList.get(i).stack.peek());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkBar() {
        if(thisTurn){

            for(Dice dice:diceRoll){
                int d=dice.getNum();
                if(canMoveTO(stackList.get(d))){
                    for(SvgCus svgCus:selectors){
                        if(svgCus.stack.whiteNum==d){
                            svgCus.svgPath.setVisible(true);
                            highLight(whiteBar.stack.peek());
                        }
                    }
                }
            }
        }else {
            for(Dice dice:diceRoll){
                int d=25-dice.getNum();
                if(canMoveTO(stackList.get(d))){
                    for(SvgCus svgCus:selectors){
                        if(svgCus.stack.whiteNum==d){ //yes i know it should be whitenum
                            svgCus.svgPath.setVisible(true);
                            highLight(blackBar.stack.peek());
                        }
                    }
                }
            }
        }

    }

    public boolean canMoveTO(NewStack newStack){
        if(newStack.stack.isEmpty())
            return true;
        if(thisTurn){
            if(newStack.stack.peek().side.equals("White"))
                return true;
            if(newStack.stack.size()==1)
                return true;
        }
        else {
            if(newStack.stack.peek().side.equals("Black"))
                return true;
            if(newStack.stack.size()==1)
                return true;
        }
        return false;
    }

    private void svgClicked(SvgCus svgCus) {
        if (lastSelect==null){
            System.out.println("----------------------------------> last select null");
            return;
        }


        if(svgCus.svgPath==infernoWhite){
            if (lastSelect.getImage().getBlendMode()!=BlendMode.BLUE){
                lastSelect=null;
                return;
            }
            System.out.println(Color.ANSI_PURPLE+"Move initiated from svg clicked direct line cond1:");
            System.out.println(Color.ANSI_RESET+".");
            animate(885,459-(whiteInferSt.stack.size()*40),lastSelect);
            DiceExpired(svgCus.WhiteNum,lastSelect.stack.whiteNum);
            whiteInferSt.stack.push(lastSelect.getStack().stack.pop());
            lastSelect.stack=whiteInferSt;
            lastSelect.getImage().setBlendMode(BlendMode.SRC_OVER);

            lastSelect=null;
            findPiece();

        }
        else if(svgCus.svgPath==infernoBlack){
            if(lastSelect.getImage().getBlendMode()!=BlendMode.COLOR_BURN){
                lastSelect=null;
                return;
            }
            System.out.println(Color.ANSI_PURPLE+"Move initiated from svg clicked direct line cond2:");
            System.out.println(Color.ANSI_RESET+".");
            animate(200,50+(blackInferSt.stack.size()*40),lastSelect);
            DiceExpired(26,lastSelect.stack.whiteNum);
            blackInferSt.stack.push(lastSelect.getStack().stack.pop());
            lastSelect.stack=blackInferSt;
            lastSelect.getImage().setBlendMode(BlendMode.SRC_OVER);
            lastSelect=null;
            findPiece();
        }
        else {
            for(NewStack stack:stackList){
                if(stack.whiteNum==svgCus.WhiteNum&&stack.stack.size()==1){
                    if(stack.stack.peek().side!=lastSelect.side){
                        if(thisTurn){
                            move(25,stack.stack.peek());
                        }
                        else {
                            move(0,stack.stack.peek());
                        }
                        break;
                    }
                }
            }


            DiceExpired(svgCus.WhiteNum,lastSelect.stack.whiteNum);
            move(svgCus.WhiteNum,lastSelect);
            return;

        }

    }

    public void DiceExpired(int svgDest,int pieceOrigin ) { // white num svg click  orgin piece  // svg  and value origin if can move ==true
        System.out.println("************************************************************");
        System.out.println(Color.ANSI_BLACK+"DiceExpired:[INVOKED][svg:"+svgDest+"||||orgin piece"+pieceOrigin+"]"+Color.ANSI_RESET);
        System.out.println("************************************************************");
        if ((svgDest==-1||svgDest==26)&&canMoveOut()) { // MoveOut
            if (svgDest==-1) {
                if (beforeEmpty(pieceOrigin)) {
                    for (int i = 0; i < diceRoll.size(); i++) {
                        Dice temp = diceRoll.get(i);
                        if (temp.num > (26-1-pieceOrigin)) { // in
                            System.out.println("-------------------------------------[DICEROLL WHITE]-------------------------------]");
                            System.out.println(Color.ANSI_GREEN + "before:[true]  removing " + temp.num);
                            System.out.println(Color.ANSI_RESET + ".");
                            System.out.println("-------------------------------------[DICEROLL]-------------------------------]");
                            diceRoll.remove(temp);
                            for (Dice x :diceRoll){
                                System.out.println("Dice:["+x.num+"]");
                            }
                            return;
                        }
                    }
                    System.out.println(Color.ANSI_BLACK+"----------------------DiceExpired:[if white]+"+Color.ANSI_RESET);
                } else {
                    System.out.println(Color.ANSI_BLACK+"----------------------DiceExpired:[else white]+"+Color.ANSI_RESET);
                    for (int i = 0; i < diceRoll.size(); i++) {
                        Dice temp = diceRoll.get(i);
                        System.out.println("exp."+(26 + svgDest - pieceOrigin)+"|||orgin"+pieceOrigin+"|||svg Dest"+svgDest);
                        if (temp.num ==(26 -1- pieceOrigin)) { // va on
                            System.out.println("-------------------------------------[DICEROLL WHITE]-------------------------------]");
                            System.out.println(Color.ANSI_GREEN + "before:[false]  removing " + temp.num);
                            System.out.println(Color.ANSI_RESET + ".");
                            System.out.println("-------------------------------------[DICEROLL]-------------------------------]");
                            diceRoll.remove(temp);
                            for (Dice x :diceRoll){
                                System.out.println("Dice:["+x.num+"]");
                            }
                            return;
                        }
                    }
                }
            }
        }
        if (svgDest==26){ //black
            System.out.println(Color.ANSI_BLACK+"----------------------DiceExpired:[if Black]"+Color.ANSI_RESET);
            if (beforeEmpty(pieceOrigin)) {
                for (int i = 0; i < diceRoll.size(); i++) {
                    Dice temp = diceRoll.get(i);
                    System.out.println("exp."+(26-1-pieceOrigin)+"||||svg"+svgDest+"|||origin"+pieceOrigin);
                    if (temp.num > (pieceOrigin)) { // in
                        System.out.println("-------------------------------------[DICEROLL Black]-------------------------------]");
                        System.out.println(Color.ANSI_GREEN + "before:[true]  removing " + temp.num);
                        System.out.println(Color.ANSI_RESET + ".");
                        System.out.println("-------------------------------------[DICEROLL]-------------------------------]");
                        diceRoll.remove(temp);
                        for (Dice x :diceRoll){
                            System.out.println("Dice:["+x.num+"]");
                        }
                        return;
                    }
                }
            } else {
                System.out.println(Color.ANSI_BLACK+"----------------------DiceExpired:[else Black+]"+Color.ANSI_RESET);
                for (int i = 0; i < diceRoll.size(); i++) {
                    Dice temp = diceRoll.get(i);
                    System.out.println("***exp."+(pieceOrigin)+"|||origin"+pieceOrigin);
                    if (temp.num == (pieceOrigin)) { // va on
                        System.out.println("-------------------------------------[DICEROLL Black]-------------------------------]");
                        System.out.println(Color.ANSI_GREEN + "before:[false]  removing " + temp.num);
                        System.out.println(Color.ANSI_RESET + ".");
                        System.out.println("-------------------------------------[DICEROLL]-------------------------------]");
                        diceRoll.remove(temp);
                        for (Dice x :diceRoll){
                            System.out.println("Dice:["+x.num+"]");
                        }
                        return;
                    }
                }
            }
        }
        else {
            System.out.println(Color.ANSI_BLACK+"DiceExpired:[INVOKED]+"+Color.ANSI_RESET);
            int diceValue = svgDest-pieceOrigin;
            diceValue=Math.abs(diceValue);

            System.out.println(Color.ANSI_RED + "DiceValue:" + diceValue);
            System.out.println(Color.ANSI_RED + "DiceSize::Before" + diceRoll.size());
            //System.out.println(Color.ANSI_RESET + ".");
            Dice test = new Dice(8888,null);
            for (int i=0;i<diceRoll.size();i++){
                 test = diceRoll.get(i);
                if (test.num==diceValue){
                    System.out.println(test+": : found");
                    break;
                }
            }
            if (test.num!=8888){
                diceRoll.remove(test);
                observableList.remove(test);
            }
            System.out.println(Color.ANSI_RED + "DiceSize::After" + diceRoll.size());
            System.out.println(Color.ANSI_RESET + ".");
        }
        System.out.println("----------------------------[DICE ROLL-VALUES]--------------------------------");
        for (Dice x :diceRoll){
            System.out.println("Dice:["+x.num+"]");
        }
    }

    public boolean beforeEmpty(int pieceNumber){
        if (thisTurn){ // white
            System.out.println(Color.ANSI_BLACK+"---------------[Before-Empty white]-------------------"+Color.ANSI_RESET);
            System.out.println(Color.ANSI_RED+"check for "+pieceNumber);
            System.out.println(Color.ANSI_BLACK+"---------------[Before-Empty white]-------------------"+Color.ANSI_RESET);

            for (int i=19;i<=pieceNumber;i++){
                System.out.println("i:"+i);
                if (stackList.get(i).stack.size()!=0){
                    System.out.println("---------------------------------[BEFORE EMPTY]-------------------------------------");
                    System.out.println(Color.ANSI_PURPLE+"black check before empty"+stackList.get((25-i))+"not empty returning false");
                    System.out.println(Color.ANSI_RESET+".");
                    return false;
                }
            }
            System.out.println(" before empty :: return true");
        return true;
        }else { // black
            System.out.println(Color.ANSI_BLACK+"---------------[Before-Empty black]-------------------"+Color.ANSI_RESET);
            System.out.println(Color.ANSI_RED+"check for"+pieceNumber);
            System.out.println(Color.ANSI_BLACK+"---------------[Before-Empty black]-------------------"+Color.ANSI_RESET);

            for (int i=6;i>=pieceNumber;i--){
                System.out.println("Black i:"+i+"--->6-i:"+(6-i));
                if (stackList.get((i)).stack.size()!=0){
                    System.out.println("---------------------------------[BEFORE EMPTY]-------------------------------------");
                    System.out.println(Color.ANSI_PURPLE+"black check before empty"+stackList.get((25-i))+"not empty returnin false");
                    System.out.println(Color.ANSI_RESET+".");
                    return false;
                }
            }
            System.out.println("befor empty : BLACK : return true");
            return true;
        }
    }

    public void highLight(Piece piece){
        if(piece.side.equals("Black")){
            piece.getImage().setBlendMode(BlendMode.COLOR_BURN);
        }
        else
            piece.getImage().setBlendMode(BlendMode.BLUE);
    }

    public void pieceClicked(Piece piece){
        System.out.println("----------------------------[DICE ROLL-VALUES]--------------------------------");
        for (Dice x :diceRoll){
            System.out.println("Dice:["+x.num+"]");
        }

        boolean isTop=false;
        NewStack pieceStack=null;
        hideSVGs();
        for(NewStack stack:stackList){
            if(stack.stack.isEmpty())
                continue;
            if(stack.stack.peek()==piece){
                pieceStack=stack;
                isTop=true;
                break;
            }
        }
        if(!isTop){
            System.out.println("you can't move it");
            return ;
        }

        if(thisTurn){
            if(piece.side.equals("Black")){
                System.out.println("This is not ur turn dude -white move-");
                return;
            }
            if(!whiteBar.stack.isEmpty()){
                if(piece!=whiteBar.stack.peek()){
                    System.out.println("white bar isn't empty");
                    return;
                }
                for(Dice dice:diceRoll){
                    if(canMoveTO(stackList.get(dice.getNum()))){
                        showSVG(dice.getNum());
                    }
                }
                return;
            }
            if(piece.getImage().getBlendMode()!=BlendMode.BLUE){
                System.out.println("No move for it!");
                return;
            }
            if(lastSelect!=piece){

                for(Dice dice:diceRoll){
                    int d=dice.getNum()+pieceStack.whiteNum;
                    if(d==25){
                        infernoWhite.setVisible(true);
                        lastSelect=piece;
                    }
                    if(d>25){
                        if(canMoveOut() ){
                            boolean checkb4=true;
                            for(int i=19;i<piece.stack.whiteNum;i++){
                                int ldes=i+dice.getNum();
                                if(ldes<=25&&!stackList.get(i).stack.isEmpty()){

                                    if(stackList.get(i).stack.peek().side.equals("White")&&canMoveTO(stackList.get(ldes))){
                                        checkb4=false;
                                    }

                                }
                            }
                            if(checkb4){
                                infernoWhite.setVisible(true);
                                lastSelect=piece;
                            }

                        }
                    }
                    else if(canMoveTO(stackList.get(d))){

                        System.out.println(Color.ANSI_PURPLE+"else 721 inovked");
                        System.out.println(Color.ANSI_RESET+".");
                        showSVG(d);
                        lastSelect=piece;
                    }
                }
            }
            else {
                System.out.println(Color.ANSI_PURPLE+" check after 721 id55");
                System.out.println(Color.ANSI_RESET+".");
                lastSelect=null;
                hideSVGs();
                findPiece();
            }

        }
        else{ //working -----
            if(piece.side.equals("White")){
                System.out.println("This is not ur turn dude -black move-");
                return;
            }
            if(!blackBar.stack.isEmpty()){
                if(piece!=blackBar.stack.peek()){
                    System.out.println("black bar isn't empty");
                    return;
                }
                for(Dice dice:diceRoll){
                    if(canMoveTO(stackList.get(25-dice.getNum()))){
                        showSVG(25-dice.getNum());
                    }
                }
                return;
            }
            if(piece.getImage().getBlendMode()!=BlendMode.COLOR_BURN){
                System.out.println("No move for it!");
                return;
            }
            if(lastSelect!=piece){

                for(Dice dice:diceRoll){
                    int d=dice.getNum()+pieceStack.BlackNum;
                    if(d==25){
                        infernoBlack.setVisible(true);
                        lastSelect=piece;
                    }
                    if(d>25 ){
                        if(canMoveOut() ){
                            boolean checkb4=true;
                            for(int i=19;i<piece.stack.BlackNum;i++){
                                int ldes=i+dice.getNum();
                                if(ldes<=25&&!stackList.get(25-i).stack.isEmpty()){

                                    if(stackList.get(25-i).stack.peek().side.equals("Black")&&canMoveTO(stackList.get(25-ldes))){
                                        checkb4=false;
                                    }

                                }
                            }
                            if(checkb4){
                                infernoBlack.setVisible(true);
                                lastSelect=piece;
                            }

                        }
                    }
                     else if(canMoveTO(stackList.get(25-d))){
                        showSVG(25-d);
                        lastSelect=piece;
                    }
                }
            }
            else {
                lastSelect=null;
                hideSVGs();
            }
        }

    }

    private boolean canMoveOut() {
        if(thisTurn){
            if(!whiteBar.stack.isEmpty())
                return false;
            for(NewStack newStack:stackList){
                if(newStack.stack.isEmpty())
                    continue;
                if(newStack.stack.peek().side.equals("White")&&newStack.BlackNum>6) {
                    System.out.println(Color.ANSI_CYAN + " Cout checkd  STACK whiteNUM:" + newStack.whiteNum +
                            "Stack BlackNum:" + newStack.BlackNum + "||  size" + newStack.stack.size());
                    System.out.println(Color.ANSI_RESET+".");
                    return false;
                }
            }
        }
        else {
            if(!blackBar.stack.isEmpty())
                return false;
            for(NewStack newStack:stackList){
                if(newStack.stack.isEmpty())
                    continue;
                if(newStack.stack.peek().side.equals("Black")&&newStack.whiteNum>6)
                    return false;
            }
        }
        return true;
    }

    public boolean AllMoveOut(boolean turn){
        // white turn
        if (turn){
            System.out.println(Color.ANSI_RED+"All-Move-Out white:[INVOKED]");
            System.out.println(Color.ANSI_RESET+".");
            for (NewStack temp :stackList){
                if (temp.whiteNum<19 && temp.stack.size()!=0){
                    if (temp.stack.peek().side=="White"){
                        System.out.println("-----------------------[WHITE]----------------------------");
                        System.out.println(Color.ANSI_RED+"White stack lower than 19 isn`t empty of white WHnum:"+temp.whiteNum);
                        System.out.println("Returning FALSE VALUE....");
                        System.out.println(Color.ANSI_RESET+".");
                        System.out.println("-----------------------[WHITE]----------------------------");
                        infernoWhite.setVisible(false);
                        return false;
                    }
                }
            }
            System.out.println("-----------------------[WHITE]----------------------------");
            System.out.println(Color.ANSI_RED+" No white lower 19 found returning [TRUE] ");
            System.out.println(Color.ANSI_RESET+".");
            System.out.println("-----------------------[WHITE]----------------------------");
            return true;
        }
        // Black turn
        if (!turn){
            System.out.println(Color.ANSI_RED+"All-Move-Out Black:[INVOKED]");
            System.out.println(Color.ANSI_RESET+".");
            for (NewStack temp:stackList){
                if (temp.BlackNum<19 && temp.stack.size()!=0){
                    if (temp.stack.peek().side=="Black"){
                        System.out.println("----------------------[BLACK]-----------------------------");
                        System.out.println(Color.ANSI_RED+"Black stack lower than 19 isn`t empty of white BLnum:"+temp.BlackNum);
                        System.out.println("Returning FALSE VALUE....");
                        System.out.println(Color.ANSI_RESET+".");
                        System.out.println("----------------------[BLACK]-----------------------------");
                        infernoBlack.setVisible(false);
                        return false;
                    }
                }
            }

            System.out.println("-----------------------[Black]----------------------------");
            System.out.println(Color.ANSI_RED+" No Black lower 19 found returning [TRUE] ");
            System.out.println(Color.ANSI_RESET+".");
            System.out.println("-----------------------[Black]----------------------------");
            return true;
        }
        infernoBlack.setVisible(false);
        return false;
    }

    private void downLight() {
        hideSVGs();
        for (NewStack temp: stackList ){
            if (temp.stack.size()!=0){
                temp.stack.peek().getImage().setBlendMode(BlendMode.SRC_OVER);
                //temp.stack.peek().getImage().setOnMouseClicked(event -> System.out.println("Noop"));
            }
        }
    }

    private void hideSVGs() {
        for(SvgCus svgCus:selectors){
            //System.out.println(svgCus);
            svgCus.svgPath.setVisible(false);
        }
    }

    private void showSVG(int num) {
        for(SvgCus svgCus:selectors){
            if(svgCus.WhiteNum==num){
                svgCus.svgPath.setVisible(true);
            }
        }
    }

    public void move(int des,Piece piece){

        System.out.println(Color.ANSI_GREEN+"Moce first input+piece animat x:"+piece.getImage().getLayoutX()+"|||||"+piece.getImage().getLayoutY()+"::side"+
                piece.side+" stack id "+piece.stack.whiteNum+" stack size:"+piece.stack.stack.size());
        System.out.println(Color.ANSI_RESET+".");

        downLight();
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("move");
//        alert.setHeaderText("destination "+des+" "+stackList.get(des));
//        alert.setContentText("piece "+piece);

//        alert.showAndWait();
        switch (des){
            case 0: //white bar
                System.out.println(Color.ANSI_RED+"CASE O CALLED");
                animate(542,40+(40*whiteBar.stack.size()),piece);
                break; // what if break isnt here; error hack
            case 1:
                animate(820,40+(stackList.get(1).stack.size()*40),piece);
                break;
            case 2:
                animate(770,40+(stackList.get(2).stack.size()*40),piece);
                break;
            case 3:
                animate(725,40+(stackList.get(3).stack.size()*40),piece);
                break;
            case 4:
                animate(680,40+(stackList.get(4).stack.size()*40),piece);
                break;
            case 5:
                animate(630,40+(stackList.get(5).stack.size()*40),piece);
                break;
            case 6:
                animate(580,40+(stackList.get(6).stack.size()*40),piece);
                break;
            case 7:
                animate(500,40+(stackList.get(7).stack.size()*40),piece);
                break;
            case 8:
                animate(450,40+(stackList.get(8).stack.size()*40),piece);
                break;
            case 9:
                animate(405,40+(stackList.get(9).stack.size()*40),piece);
                break;
            case 10:
                animate(355,40+(stackList.get(10).stack.size()*40),piece);
                break;
            case 11:
                animate(310,40+(stackList.get(11).stack.size()*40),piece);
                break;
            case 12:
                animate(260,40+(stackList.get(12).stack.size()*40),piece);
                break;
            case 13:
                animate(260,490-(stackList.get(13).stack.size()*40),piece);
                break;
            case 14:
                animate(310,490-(stackList.get(14).stack.size()*40),piece);
                break;
            case 15:
                animate(355,490-(stackList.get(15).stack.size()*40),piece);
                break;
            case 16:
                animate(405,490-(stackList.get(16).stack.size()*40),piece);
                break;
            case 17:
                animate(450,490-(stackList.get(17).stack.size()*40),piece);
                break;
            case 18:
                animate(500,490-(stackList.get(18).stack.size()*40),piece);
                break;
            case 19:
                animate(580,490-(stackList.get(19).stack.size()*40),piece);
                break;
            case 20:
                animate(630,490-(stackList.get(20).stack.size()*40),piece);
                break;
            case 21:
                animate(680,490-(stackList.get(21).stack.size()*40),piece);
                break;
            case 22:
                animate(725,490-(stackList.get(22).stack.size()*40),piece);
                break;
            case 23:
                animate(770,490-(stackList.get(23).stack.size()*40),piece);
                break;
            case 24:
                animate(820,490-(stackList.get(24).stack.size()*40),piece);
                break;
            case 25:
                animate(542,480-(40*blackBar.stack.size()),piece);
                break;
        }

        //dice remove



        piece.stack.stack.pop();
        piece.stack=stackList.get(des);
        stackList.get(des).stack.push(piece);

        //winner check

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("move");
//        alert.setHeaderText("destination "+des+" "+stackList.get(des));
//        alert.setContentText("piece "+piece);
//
//        alert.showAndWait();

        System.out.println(Color.ANSI_GREEN+"Moce first Output to find piece +piece animat x:"+piece.getImage().getLayoutX()+"|||||"+piece.getImage().getLayoutY()+"::side"+
                piece.side+" stack id "+piece.stack.whiteNum+" stack size:"+piece.stack.stack.size());
        System.out.println(Color.ANSI_RESET+".");

        if(!status())
            findPiece();


    }

    public void animate(int x,int y,Piece piece){
        System.out.println("animate:[INVOKED]");
        System.out.println(Color.ANSI_BLUE+"piece animat INPUT: x:"+piece.getImage().getLayoutX()+"||||| Y"+piece.getImage().getLayoutY()+"::side"+
                piece.side+" stack id "+piece.stack.whiteNum+" stack size:"+piece.stack.stack.size());
        System.out.println(Color.ANSI_RESET+".");
        if (x>piece.getImage().getLayoutX()){
            // x dest > x origin => x plus
            if (y>piece.getImage().getLayoutY()){
                // y dest > y origin => y plus x plus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()+10);
                        if (piece.getImage().getLayoutY()>y){
                            piece.getImage().setLayoutY(y);
                            stop();
                            AnimationTimer timer1 = new AnimationTimer() {
                                @Override
                                public void handle(long now) {
                                    piece.getImage().setLayoutX(piece.getImage().getLayoutX()+10);
                                    if (piece.getImage().getLayoutX()>x){
                                        piece.getImage().setLayoutX(x);
                                        stop();
                                    }
                                }
                            };
                            timer1.start();
                        }
                    }
                };
                timer.start();

            }
            // System.out.println("check y::::"+y+" y piece::::"+piece.getImage().getLayoutY());
            if (y<piece.getImage().getLayoutY()){
                //y dest < y origin => y minus x plus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()-10);
                        if (y>piece.getImage().getLayoutY()){
                            stop();
                            piece.getImage().setLayoutY(y);
                            AnimationTimer timer1 = new AnimationTimer() {
                                @Override
                                public void handle(long now) {
                                    piece.getImage().setLayoutX(piece.getImage().getLayoutX()+10);
                                    if (x<piece.getImage().getLayoutX()){
                                        stop();
                                        piece.getImage().setLayoutX(x);
                                    }
                                }
                            };
                            timer1.start();
                        }
                    }
                };
                timer.start();
            }
            if (y==piece.getImage().getLayoutY()){
                // y dest == y position => x plus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutX(piece.getImage().getLayoutX()+10);
                        if (x<piece.getImage().getLayoutX()){
                            stop();
                            piece.getImage().setLayoutX(x);
                        }
                    }
                };
                timer.start();
            }


        }else if (x<piece.getImage().getLayoutX()){
            // x dest < x origin => x minus
            // System.out.println("x< x.p");
            // System.out.println("y::"+y+"   y.p"+piece.getImage().getLayoutY());
            if (y>piece.getImage().getLayoutY()){
                // y dest > y origin => y plus x minus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()+10);
                        if (y<piece.getImage().getLayoutY()){
                            stop();
                            piece.getImage().setLayoutY(y);
                            AnimationTimer timer1 = new AnimationTimer() {
                                @Override
                                public void handle(long now) {
                                    piece.getImage().setLayoutX(piece.getImage().getLayoutX()-10);
                                    if (x>piece.getImage().getLayoutX()){
                                        stop();
                                        piece.getImage().setLayoutX(x);
                                    }
                                }
                            };
                            timer1.start();
                        }
                    }
                };
                timer.start();
            }
            if (y<piece.getImage().getLayoutY()){
                //y dest < y origin => y minus x minus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()-10);
                        if (y>piece.getImage().getLayoutY()){
                            stop();
                            piece.getImage().setLayoutY(y);
                            AnimationTimer timer1 = new AnimationTimer() {
                                @Override
                                public void handle(long now) {
                                    piece.getImage().setLayoutX(piece.getImage().getLayoutX()-10);
                                    if (x>piece.getImage().getLayoutX()){
                                        stop();
                                        piece.getImage().setLayoutX(x);
                                    }
                                }
                            };
                            timer1.start();
                        }
                    }
                };
                timer.start();
            }
            if (y==piece.getImage().getLayoutY()){
                // y dest == y origin => x minus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutX(piece.getImage().getLayoutX()-10);
                        if (x>piece.getImage().getLayoutX()){
                            stop();
                            piece.getImage().setLayoutX(x);
                        }
                    }
                };
                timer.start();
            }
        }
        if (x==piece.getImage().getLayoutX()){
            // x origin = x dest
            if (y>piece.getImage().getLayoutY()){
                // y dest > y origin => y plus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()+10);
                        if (y<piece.getImage().getLayoutY()){
                            stop();
                            piece.getImage().setLayoutY(y);
                        }
                    }
                };
                timer.start();
            }
            if (y<piece.getImage().getLayoutY()){
                // y dest < y origin => y minus
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        piece.getImage().setLayoutY(piece.getImage().getLayoutY()-10);
                        if (y>piece.getImage().getLayoutY()){
                            stop();
                            piece.getImage().setLayoutY(y);
                        }
                    }
                };
                timer.start();
            }
        }


        System.out.println(Color.ANSI_BLUE+"piece animat x:"+piece.getImage().getLayoutX()+"||||| Y:"+piece.getImage().getLayoutY()+"::side"+
                piece.side+" stack id "+piece.stack.whiteNum+" stack size:"+piece.stack.stack.size());
        System.out.println(Color.ANSI_RESET+".");
        hideSVGs();
    }

    public boolean status(){
        if(whiteInferSt.stack.size()==15){
            turn.setText("Player one wins!");
            diceButton.setDisable(true);
            return true;
        }
        if(blackInferSt.stack.size()==15){
            turn.setText("Player two wins!");
            diceButton.setDisable(true);
            return true;
        }
        return false;
    }

    @FXML
    public void reStart() throws IOException {
        diceButton.setDisable(false);
        for(NewStack stack:stackList){
            stack.stack.clear();
        }
        blackInferSt.stack.clear();
        whiteInferSt.stack.clear();
        diceButton.getScene().getWindow().hide();
        selectors.clear();
//        System.exit(1);
        Main h1 = new Main();
        try {
            h1.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //kha reload??

    }

    @FXML
    public void test(){
        move(3,stackList.get(24).stack.peek());
        move(3,stackList.get(24).stack.peek());

        move(4,stackList.get(13).stack.peek());
        move(4,stackList.get(13).stack.peek());
        move(4,stackList.get(13).stack.peek());
        move(4,stackList.get(13).stack.peek());
        move(4,stackList.get(13).stack.peek());

        move(5,stackList.get(8).stack.peek());
        move(5,stackList.get(8).stack.peek());
        move(2,stackList.get(8).stack.peek());


        move(22,stackList.get(1).stack.peek());
        move(22,stackList.get(1).stack.peek());

        move(20,stackList.get(12).stack.peek());
        move(20,stackList.get(12).stack.peek());
        move(20,stackList.get(12).stack.peek());
        move(20,stackList.get(12).stack.peek());
        move(20,stackList.get(12).stack.peek());

        move(20,stackList.get(17).stack.peek());
        move(20,stackList.get(17).stack.peek());
        move(22,stackList.get(17).stack.peek());

    }

}
