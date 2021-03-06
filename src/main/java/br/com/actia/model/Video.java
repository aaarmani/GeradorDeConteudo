package br.com.actia.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Armani <anderson.armani@actia.com.br>
 */
@Entity
@Table (name="video")
public class Video implements AbstractEntity, Serializable {
    /**
     * Chave primária da entidade <code>Video</code>. O valor gerado pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Size(max=16)
    @Column(unique=true, nullable=false)  
    @Expose
    private String name;
    @ManyToOne
    @JoinColumn(name="video_type_id", referencedColumnName="id")
    @Expose
    private VideoType type;
    @NotNull
    @Expose
    private String videoName;
    @Transient
    private String videoPath;

    public Video() {}

    public Video(Integer id, VideoType type, String name, String videoName, String videoPath) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.videoName = videoName;
        this.videoPath = videoPath;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VideoType getType() {
        return type;
    }

    public void setType(VideoType type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
