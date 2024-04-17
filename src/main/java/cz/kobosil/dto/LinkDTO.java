package cz.kobosil.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    @JsonProperty("id")
    private long id;
    private String name;
    private URL url;
    private byte[] imageData;
    private String description;
    private boolean inFirefox;
    private boolean inChrome;
    private boolean active;
    private boolean openInNewWindow;
}
