package cz.kobosil.service;

import cz.kobosil.dto.LinkDTO;
import cz.kobosil.entity.LinkEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LinkService {
    List<LinkEntity> getAllLinks();

    LinkDTO createLink(LinkDTO linkDTO, MultipartFile imageFile) throws IOException;

    LinkDTO editLink(long id, LinkDTO linkDTO, MultipartFile imageFile) throws IOException;

    LinkDTO removeLink(long id);

    LinkDTO getLinkById(long id);
}
