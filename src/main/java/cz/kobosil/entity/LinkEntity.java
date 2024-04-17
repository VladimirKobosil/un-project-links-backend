package cz.kobosil.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Entity(name = "link")
@Getter
@Setter
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;


    private URL url;

    @Lob
    @Column(name = "imageData", length = 1000000)
    private byte[] imageData;


    private String description;


    private boolean inFirefox;


    private boolean inChrome;


    private boolean active;


    private boolean openInNewWindow;

}