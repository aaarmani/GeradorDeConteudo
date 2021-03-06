package br.com.actia.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Armani <anderson.armani@actia.com.br>
 */
@Entity
@Table (name = "banner")
public class Banner implements AbstractEntity, Serializable {
    /**
     * Chave primária da entidade <code>Banner</code>. O valor gerado pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Size(max=16)
    @Column(unique=true, nullable=false)
    private String name;
    @NotNull
    @Expose
    private String image;
    @Transient
    private String imagePath;
    
    public Banner() {}
    
    public Banner(Integer id, String name, String imageName, String imagePath) {
        this.id = id;
        this.name = name;
        this.image = imageName;
        this.imagePath = imagePath;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImageOrigPath(String imageOrigPath) {
        this.imagePath = imageOrigPath;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
