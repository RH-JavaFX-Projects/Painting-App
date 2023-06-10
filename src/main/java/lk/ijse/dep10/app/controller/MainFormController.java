package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;


public class MainFormController {
    public Text txtType;
    private double movePressedX=0;
    private double movePressedY=0;
    private double x1=0;
    private double y1=0;
    private double x2=0;
    private double y2=0;
    private boolean rectangle =false;
    private boolean circle =false;
    private boolean oval =false;
    private boolean pen =false;
    private boolean eraser =false;
    private boolean text =false;
    private boolean fill =false;
    private boolean stroke =false;
    public AnchorPane root;



    @FXML
    private Button btnSave;
    @FXML
    private Canvas cnvMain;
    @FXML
    private ColorPicker clrPickerFill;
    @FXML
    private ColorPicker clrPickerStroke;
    @FXML
    private Label lblText;
    @FXML
    private Label lblCircle;
    @FXML
    private Label lblEraser;
    @FXML
    private Label lblOval;
    @FXML
    private Label lblPen;
    @FXML
    private Label lblRectangle;
    @FXML
    private VBox vBox;
    private final javafx.scene.image.Image imageEraser = new javafx.scene.image.Image("/image/eraser.png");
    private final javafx.scene.image.Image imagePen = new javafx.scene.image.Image("/image/pen1.png");


    @FXML
    void cnvMainOnMouseDragged(MouseEvent event) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setStroke(clrPickerStroke.getValue());
        x2= event.getX();
        y2= event.getY();
        if (pen) {
            gc.lineTo(x2, y2);
            gc.stroke();

        }
        if (eraser) {
            gc.clearRect(event.getX() , event.getY()+5 , 20, 20);
        }

    }
    @FXML
    void cnvMainOnMousePressed(MouseEvent event) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setStroke(clrPickerStroke.getValue());
        x1=event.getX();
        y1=event.getY();
        if (pen) {
            gc.beginPath();
            gc.lineTo(x1, y1);

        }
        if (eraser) {
            gc.clearRect(event.getX() , event.getY()+5 , 20, 20);
        }
        if (text) {
            System.out.println("mouseClicked");
            txtType.setVisible(true);
            txtType.setX(event.getSceneX());
            txtType.setY(event.getSceneY());
            txtType.setText("Kumar");
        }
    }
    @FXML
    void cnvMainOnMouseReleased(MouseEvent event) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setStroke(clrPickerStroke.getValue());
        gc.setFill(clrPickerFill.getValue());
        if (rectangle) {
            if (x2>x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeRect(x1,y1,x2-x1,y2-y1);
                }
                if (fill) {
                    gc.fillRect(x1,y1,x2-x1,y2-y1);
                }
            }
            if (x2<x1&&y2<y1)  {
                if (stroke) {
                    gc.strokeRect(x2,y2,x1-x2,y1-y2);
                }
                if (fill) {
                    gc.fillRect(x2,y2,x1-x2,y1-y2);
                }
            }
            if (x2<x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeRect(x2,y1,x1-x2,y2-y1);
                }
                if (fill) {
                    gc.fillRect(x2,y1,x1-x2,y2-y1);
                }
            }
            if (x2>x1&&y2<y1)  {
                if (stroke) {
                    gc.strokeRect(x1,y2,x2-x1,y1-y2);
                }
                if (fill) {
                    gc.fillRect(x1,y2,x2-x1,y1-y2);
                }
            }
        }
        if (circle) {
            if (x2>x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeOval(x1,y1,x2-x1,x2-x1);
                }
                if (fill) {
                    gc.fillOval(x1,y1,x2-x1,x2-x1);
                }
            }
            if (x2<x1&&y2<y1)  {
                if (stroke) {
                    gc.strokeOval(x2,y2,x1-x2,x1-x2);
                }
                if (fill) {
                    gc.fillOval(x2,y2,x1-x2,x1-x2);
                }
            }
            if (x2<x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeOval(x2,y1,x1-x2,x1-x2);
                }
                if (fill) {
                    gc.fillOval(x2,y1,x1-x2,x1-x2);
                }
            }
            if (x2>x1&&y2<y1)  {
                if (stroke) {
                    gc.strokeOval(x1,y2,x2-x1,x2-x1);
                }
                if (fill) {
                    gc.fillOval(x1,y2,x2-x1,x2-x1);
                }
            }
        }
        if (oval) {
            if (x2>x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeOval(x1,y1,x2-x1,y2-y1);
                }
                if (fill) {
                    gc.fillOval(x1,y1,x2-x1,y2-y1);
                }
            }
            if (stroke) {
                if (x2<x1&&y2<y1)  {
                    gc.strokeOval(x2,y2,x1-x2,y1-y2);
                    if (fill) {
                        gc.fillOval(x2,y2,x1-x2,y1-y2);
                    }
                }
            }
            if (x2<x1&&y2>y1)  {
                if (stroke) {
                    gc.strokeOval(x2,y1,x1-x2,y2-y1);
                }
                if (fill) {
                    gc.fillOval(x2,y1,x1-x2,y2-y1);
                }
            }
            if (x2>x1&&y2<y1)  {
                if (stroke) {
                    gc.strokeOval(x1,y2,x2-x1,y1-y2);
                }
                if (fill) {
                    gc.fillOval(x1,y2,x2-x1,y1-y2);
                }
            }
        }

    }





    @FXML
    void lblRectangleOnMouseEntered(MouseEvent event) {
        lblRectangle.setScaleX(1.5);
        lblRectangle.setScaleY(1.5);
    }
    @FXML
    void lblCircleOnMouseEntered(MouseEvent event) {
        lblCircle.setScaleX(1.5);
        lblCircle.setScaleY(1.5);

    }
    @FXML
    void lblOvalOnMouseEntered(MouseEvent event) {
        lblOval.setScaleX(1.5);
        lblOval.setScaleY(1.5);


    }
    @FXML
    void lblPenOnMouseEntered(MouseEvent event) {
        lblPen.setScaleX(1.5);
        lblPen.setScaleY(1.5);

    }
    @FXML
    void lblEraserOnMouseEntered(MouseEvent event) {
        lblEraser.setScaleX(1.5);
        lblEraser.setScaleY(1.5);


    }
    @FXML
    void lblTextOnMouseEntered(MouseEvent event) {
        lblText.setScaleX(1.5);
        lblText.setScaleY(1.5);

    }
    @FXML
    void lblRectangleOnMouseExited(MouseEvent event) {
        lblRectangle.setScaleX(1);
        lblRectangle.setScaleY(1);


    }
    @FXML
    void lblCircleOnMouseExited(MouseEvent event) {
        lblCircle.setScaleX(1);
        lblCircle.setScaleY(1);


    }
    @FXML
    void lblOvalOnMouseExited(MouseEvent event) {
        lblOval.setScaleX(1);
        lblOval.setScaleY(1);

    }
    @FXML
    void lblPenOnMouseExited(MouseEvent event) {
        lblPen.setScaleX(1);
        lblPen.setScaleY(1);


    }
    @FXML
    void lblEraserOnMouseExited(MouseEvent event) {
        lblEraser.setScaleX(1);
        lblEraser.setScaleY(1);

    }
    @FXML
    void lblTextOnMouseExited(MouseEvent event) {
        lblText.setScaleX(1);
        lblText.setScaleY(1);


    }




    @FXML
    void lblRectangleOnMouseClicked(MouseEvent event) {
        cnvMain.setCursor(Cursor.DEFAULT);
        rectangle=true;
        circle=false;
        oval=false;
        pen=false;
        eraser=false;
        text=false;
        lblRectangle.setEffect(new InnerShadow(20, Color.RED));
        lblCircle.setEffect(null);
        lblOval.setEffect(null);
        lblPen.setEffect(null);
        lblEraser.setEffect(null);
        lblText.setEffect(null);

    }
    @FXML
    void lblCircleOnMouseClicked(MouseEvent event) {
        cnvMain.setCursor(Cursor.DEFAULT);
        rectangle=false;
        circle=true;
        oval=false;
        pen=false;
        eraser=false;
        text=false;
        lblRectangle.setEffect(null);
        lblCircle.setEffect(new InnerShadow(20, Color.RED));
        lblOval.setEffect(null);
        lblPen.setEffect(null);
        lblEraser.setEffect(null);
        lblText.setEffect(null);

    }
    @FXML
    void lblOvalOnMouseClicked(MouseEvent event) {
        cnvMain.setCursor(Cursor.DEFAULT);
        rectangle=false;
        circle=false;
        oval=true;
        pen=false;
        eraser=false;
        text=false;
        lblRectangle.setEffect(null);
        lblCircle.setEffect(null);
        lblOval.setEffect(new InnerShadow(20, Color.RED));
        lblPen.setEffect(null);
        lblEraser.setEffect(null);
        lblText.setEffect(null);

    }
    @FXML
    void lblPenOnMouseClicked(MouseEvent event) {
        cnvMain.setCursor(new ImageCursor(imagePen));
        rectangle=false;
        circle=false;
        oval=false;
        pen=true;
        eraser=false;
        text=false;
        lblRectangle.setEffect(null);
        lblCircle.setEffect(null);
        lblOval.setEffect(null);
        lblPen.setEffect(new InnerShadow(20, Color.RED));
        lblEraser.setEffect(null);
        lblText.setEffect(null);

    }
    @FXML
    void lblEraserOnMouseClicked(MouseEvent event) {
        cnvMain.setCursor(new ImageCursor(imageEraser));
        rectangle=false;
        circle=false;
        oval=false;
        pen=false;
        eraser=true;
        text=false;
        lblRectangle.setEffect(null);
        lblCircle.setEffect(null);
        lblOval.setEffect(null);
        lblPen.setEffect(null);
        lblEraser.setEffect(new InnerShadow(20, Color.RED));
        lblText.setEffect(null);

    }
    @FXML
    void lblTextOnMouseClicked(MouseEvent event) {
        cnvMain.requestFocus();
        cnvMain.setCursor(Cursor.DEFAULT);
        rectangle=false;
        circle=false;
        oval=false;
        pen=false;
        eraser=false;
        text=true;
        lblRectangle.setEffect(null);
        lblCircle.setEffect(null);
        lblOval.setEffect(null);
        lblPen.setEffect(null);
        lblEraser.setEffect(null);
        lblText.setEffect(new InnerShadow(20, Color.RED));

    }



    @FXML
    void lblMoveOnMouseDragged(MouseEvent event) {
        if (event.getSceneX() < 0) {
            vBox.setLayoutX(0);
            vBox.setLayoutY(event.getSceneY() - movePressedY);
        }
        if (event.getSceneY() < 0) {
            vBox.setLayoutX(event.getSceneX() - movePressedX);
            vBox.setLayoutY(0);
        }
        if (event.getSceneX() > cnvMain.getWidth()) {
            vBox.setLayoutX(cnvMain.getWidth());
            vBox.setLayoutY(event.getSceneY() - movePressedY);
        }
        if (event.getSceneY() > cnvMain.getHeight()) {
            vBox.setLayoutX(event.getSceneX() - movePressedX);
            vBox.setLayoutY(cnvMain.getHeight());

        } else {
            vBox.setLayoutX(event.getSceneX() - movePressedX);
            vBox.setLayoutY(event.getSceneY() - movePressedY);
        }
    }

    @FXML
    void lblMoveOnMousePressed(MouseEvent event) {
        movePressedX = event.getX();
        movePressedY = event.getY();
    }


    public void btnSaveOnAction(javafx.event.ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save the File");
        File file = fileChooser.showSaveDialog(btnSave.getScene().getWindow());
    }

    public void btnClearOnAction(javafx.event.ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.clearRect(0 , 0 , cnvMain.getWidth(),cnvMain.getHeight());
    }

    public void initialize() {
        txtType.setVisible(false);
        cnvMain.widthProperty().bind(root.widthProperty());
        cnvMain.heightProperty().bind(root.heightProperty());
    }

    public void clrPickerFillOnAction(javafx.event.ActionEvent actionEvent) {
        clrPickerStroke.setValue(Color.WHITE);
        fill=true;
        stroke=false;
    }

    public void clrPickerStrokeOnAction(ActionEvent actionEvent) {
        clrPickerFill.setValue(Color.WHITE);
        stroke=true;
        fill=false;
    }

    public void cnvMainOnKeyTyped(KeyEvent keyEvent) {
//        if (text) {
//            System.out.println("ras");
//            String type = "";
//
//            while (keyEvent.getText()!=null){
//               txtType.setText(keyEvent.getText());
//            }
//        }


    }
}
