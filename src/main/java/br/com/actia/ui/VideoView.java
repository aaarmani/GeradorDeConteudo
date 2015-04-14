package br.com.actia.ui;

import br.com.actia.model.Video;
import br.com.actia.model.VideoType;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

/**
 *
 * @author Armani <anderson.armani@actia.com.br>
 */
public class VideoView  extends VBox {
    private final int MAX_HEIGHT = 600;
    private final int VIEWER_SIZE = 300;
    
    private TextField tfId;
    private TextField tfName;
    private TextField tfVideoPath;
    private Button btnChooseVideo;
    private Button btnCancelVideo;
    private Button btnSaveVideo;
    private Button btnPlayVideo;
    private ComboBox<VideoType> cbVideoType;
    private MediaView mediaView;
    private ResourceBundle rb;
        
    public VideoView(ResourceBundle rb) {
        this.rb = rb;
        this.setMaxHeight(MAX_HEIGHT);
        this.getStyleClass().add("whitePanel");
        initializeComponents();
    }

    private void initializeComponents() {
        VBox head = buildHead();
        GridPane chooser = buildChooser();
        HBox buttons = buildButtons();
        VBox viewer = buildViewer();
        
        this.getChildren().addAll(head, chooser, buttons, viewer);
    }
    
    private VBox buildHead() {
        Label lblTitle = new Label(rb.getString("VDNewVideo"));
        lblTitle.getStyleClass().add("titleLabel");
        Separator separator = new Separator();
        return new VBox(lblTitle, separator);
    }

    private GridPane buildChooser() {
        tfId = new TextField();
        
        Label lblName = new Label(rb.getString("Name"));
        tfName = new TextField();
        
        Label lblType = new Label(rb.getString("Type"));
        cbVideoType = new ComboBox<>();
        
        Label lblImage = new Label(rb.getString("VDChooseVideo"));
        tfVideoPath = new TextField();
        btnChooseVideo = new Button(rb.getString("Search"));
        btnChooseVideo.setId("btnChooseVideo");
        btnChooseVideo.getStyleClass().add("flatButton");
       
        GridFormBuilder grid = new GridFormBuilder();
        grid.addRowGenerics(lblName, tfName, lblType, cbVideoType);
        grid.addRowGenerics(lblImage, tfVideoPath, btnChooseVideo, null);
        
        return grid.build();
    }
    
    private HBox buildButtons() {
        btnCancelVideo = new Button(rb.getString("Cancel"));
        btnCancelVideo.setId("btnCancelVideo");
        btnCancelVideo.setCancelButton(true);
        btnCancelVideo.getStyleClass().add("flatButton");
        
        btnSaveVideo = new Button(rb.getString("Save"));
        btnSaveVideo.setId("btnSalveVideo");
        btnSaveVideo.setDefaultButton(true);
        btnSaveVideo.getStyleClass().add("flatButton");
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnCancelVideo, btnSaveVideo);
        hbox.getStyleClass().add("buttonBar");
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        return hbox;
    }
    
    private VBox buildViewer() {
        Separator separator = new Separator();
        mediaView = new MediaView();
        mediaView.setFitWidth(VIEWER_SIZE);
        mediaView.setFitHeight(VIEWER_SIZE);
        mediaView.setPreserveRatio(true);
        mediaView.setSmooth(true);
        mediaView.setCache(true);
        mediaView.getStyleClass().add("Img");
        
        btnPlayVideo = new Button(rb.getString("Play"));
        btnPlayVideo.setId("btnPlayBanner");
        btnPlayVideo.getStyleClass().add("flatButton");
        setBtToPlay();
        
        VBox vbox = new VBox(separator, mediaView, btnPlayVideo);
        vbox.getStyleClass().add("viewPane");
        
        return vbox;
    }

    public void setBtToPlay() {
        this.btnPlayVideo.setText(rb.getString("Play"));
    }
    
    public void setBtToStop() {
        this.btnPlayVideo.setText(rb.getString("Stop"));
    }
    
    public Video loadVideoFromPanel() {
        Integer id = null;
        if(!tfId.getText().trim().isEmpty()) {
            id = Integer.valueOf(tfId.getText());
        }
        
        String name = null;
        if(!tfName.getText().trim().isEmpty()) {
            name = tfName.getText();
        }
        
        String videoPath = null;
        if(!tfVideoPath.getText().trim().isEmpty()) {
            videoPath = tfVideoPath.getText();
        }
        
        VideoType videoType = null;
        if(!cbVideoType.getSelectionModel().isEmpty()) {
            videoType = cbVideoType.getSelectionModel().getSelectedItem();
        }

        return new Video(id, videoType, name, videoPath);
    }

    public void resetForm() {
        tfId.setText("");
        tfName.setText("");
        tfVideoPath.setText("");
    }
    
    public TextField getTfId() {
        return tfId;
    }

    public void setTfId(TextField tfId) {
        this.tfId = tfId;
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public TextField getTfVideoPath() {
        return tfVideoPath;
    }

    public void setTfVideoPath(TextField tfVideoPath) {
        this.tfVideoPath = tfVideoPath;
    }

    public Button getBtnChooseVideo() {
        return btnChooseVideo;
    }

    public void setBtnChooseVideo(Button btnChooseVideo) {
        this.btnChooseVideo = btnChooseVideo;
    }

    public Button getBtnCancelVideo() {
        return btnCancelVideo;
    }

    public void setBtnCancelVideo(Button btnCancelVideo) {
        this.btnCancelVideo = btnCancelVideo;
    }

    public Button getBtnSaveVideo() {
        return btnSaveVideo;
    }

    public void setBtnSaveVideo(Button btnSaveVideo) {
        this.btnSaveVideo = btnSaveVideo;
    }

    public Button getBtnPlayVideo() {
        return btnPlayVideo;
    }

    public void setBtnPlayVideo(Button btnPlayVideo) {
        this.btnPlayVideo = btnPlayVideo;
    }

    public ComboBox<VideoType> getCbVideoType() {
        return cbVideoType;
    }

    public void setCbVideoType(ComboBox<VideoType> cbVideoType) {
        this.cbVideoType = cbVideoType;
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setMediaView(MediaView mediaView) {
        this.mediaView = mediaView;
    }
}