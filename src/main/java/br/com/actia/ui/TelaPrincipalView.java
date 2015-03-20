package br.com.actia.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Armani
 */
public class TelaPrincipalView {

    private Scene mainScene;
    BorderPane bpMenu;
    VBox vboxAction;
    ImageView imgvLogo;
    ImageView imgBR;
    ImageView imgES;
    ImageView imgEN;
    ImageView imgUser;

    public TelaPrincipalView(Stage stage) {
        inicializaComponentes();

        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("MainScreen");
        mainScene = new Scene(borderPane);
        mainScene.getStylesheets().add("style.css");

        bpMenu = getBorderPaneMenu();
        vboxAction = getVboxAction();

        borderPane.setLeft(bpMenu);
        borderPane.setRight(vboxAction);

        stage.setTitle("##MainFrameTitle");
        stage.setWidth(1000);
        stage.setHeight(620);
        stage.setScene(mainScene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    private void inicializaComponentes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BorderPane getBorderPaneMenu() {
        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(150);
        borderPane.setMaxWidth(150);
        borderPane.getStyleClass().add("MenuMain");

        borderPane.setTop(getLogo());
        borderPane.setCenter(getMenu());
        borderPane.setBottom(getFlags());

        return borderPane;
    }

    private VBox getVboxAction() {
        VBox vbox = new VBox();
        vbox.setMinWidth(50);
        vbox.setMaxWidth(50);
        vbox.getStyleClass().add("MenuMain");

        vbox.getChildren().add(getUserLogo());

        return vbox;
    }

    /**
     *
     * @return VBox with actia image logo
     */
    private VBox getLogo() {
        Image logoImg = new Image("actiaLogo.png");
        imgvLogo = new ImageView(logoImg);
        imgvLogo.maxHeight(40);
        imgvLogo.maxWidth(150);

        VBox logoVBox = new VBox();
        logoVBox.getStyleClass().add("LogoPanel");
        logoVBox.getChildren().add(imgvLogo);
        return logoVBox;
    }

    /**
     * 
     * @return VBox menu
     */
    private TreeView getMenu() {
        TreeItem<String> rootItem = new TreeItem<String> ("Inbox", null);
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        TreeView<String> tree = new TreeView<String> (rootItem);
        tree.getStyleClass().add("MenuMain");
        return tree;
        /*VBox vbMenu = new VBox();
        
        Button btn = new Button("Teste Armani");
        btn.setMinSize(150, 40);
        btn.getStyleClass().add("button");
        vbMenu.getChildren().add(btn);

        Button btn2 = new Button("Teste Armani 2");
        btn2.setMinSize(150, 40);
        btn2.getStyleClass().add("button");
        vbMenu.getChildren().add(btn2);
        
        return vbMenu;*/
    }
    
    /**
     *
     * @return HBox with logo images for i18n
     */
    private HBox getFlags() {
        imgBR = new ImageView("gn.png");
        imgBR.getStyleClass().add("flag");
        Button btnBR = new Button(null, imgBR);
        btnBR.getStyleClass().add("LangButton");

        imgES = new ImageView("es.png");
        imgES.getStyleClass().add("flag");
        
        imgEN = new ImageView("us.png");
        imgEN.getStyleClass().add("flag");

        HBox flagsPanel = new HBox();
        flagsPanel.getStyleClass().add("LangPanel");
        flagsPanel.getChildren().add(btnBR);
        flagsPanel.getChildren().add(imgEN);
        flagsPanel.getChildren().add(imgES);
        return flagsPanel;
    }
    
    private VBox getUserLogo() {
        Image logoImg = new Image("user_verde.png");
        imgUser = new ImageView(logoImg);
        imgUser.maxHeight(40);
        imgUser.maxWidth(40);
        
        VBox vbox = new VBox();
        vbox.getStyleClass().add("ImgUser");
        vbox.getChildren().add(imgUser);
        
        return vbox;
    }

    //#####################################################
    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public BorderPane getBpMenu() {
        return bpMenu;
    }

    public void setBpMenu(BorderPane bpMenu) {
        this.bpMenu = bpMenu;
    }

    public VBox getVbAction() {
        return vboxAction;
    }

    public void setVbAction(VBox vbAction) {
        this.vboxAction = vbAction;
    }

    public ImageView getImgvLogo() {
        return imgvLogo;
    }

    public void setImgvLogo(ImageView imgvLogo) {
        this.imgvLogo = imgvLogo;
    }

    public ImageView getImgBR() {
        return imgBR;
    }

    public void setImgBR(ImageView imgBR) {
        this.imgBR = imgBR;
    }

    public ImageView getImgES() {
        return imgES;
    }

    public void setImgES(ImageView imgES) {
        this.imgES = imgES;
    }

    public ImageView getImgEN() {
        return imgEN;
    }

    public void setImgEN(ImageView imgEN) {
        this.imgEN = imgEN;
    }

    public ImageView getImgUser() {
        return imgUser;
    }

    public void setImgUser(ImageView imgUser) {
        this.imgUser = imgUser;
    }

}
