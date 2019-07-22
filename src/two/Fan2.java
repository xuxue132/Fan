package two;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Fan2 extends Application {
    private double radius=100;
    private int speed=1;
    public void start (Stage primaryStage){
        GridPane pane=new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(20);
        pane.setPadding(new Insets(50));
        Circle circle=new Circle(radius,radius,radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Pane pane1=new Pane();
        pane1.getChildren().addAll(circle);
        Arc []arc=new Arc[4];
        for(int i=0;i<4;i++){
            arc[i]=new Arc(radius,radius,radius*0.9,
                    radius*0.9,(45+i*90),30);
            arc[i].setType(ArcType.ROUND);
            arc[i].setFill(Color.RED);
            arc[i].setStroke(Color.BLACK);
            pane1.getChildren().add(arc[i]);
        }
        pane.add(pane1, 0,1);

        Button button1=new Button("start");
        Button button2=new Button("Steep");
        Button button3=new Button("Reverse");
        HBox hBox=new HBox(50);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button1,button2,button3);
        pane.add(hBox,0,0);

        EventHandler<ActionEvent>eventEventHandler=e->{
          for(int i=0;i<4;i++) {
              arc[i].setStartAngle(arc[i].getStartAngle()-speed);
          }
        };

        Timeline timeline=new Timeline(new KeyFrame(Duration.millis(5),eventEventHandler ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        button1.setOnAction(e->{
            timeline.play();
        });

        button2.setOnAction(e->{
            timeline.stop();
        });

        button3.setOnAction(e->{
            speed*=-1;
        });

        ScrollBar scrollBar=new ScrollBar();
        scrollBar.valueProperty().addListener(ov->{
            scrollBar.setMax(10);
            scrollBar.setMin(1);
            if(speed<0)
            speed=(int)scrollBar.getValue()*(-1);
            else
                speed=(int)scrollBar.getValue();

        });
        pane.add(scrollBar,0,2);
        Scene scene=new Scene(pane,500,500);
        primaryStage.setTitle("Fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}