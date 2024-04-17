package cz.kobosil.service;

import cz.kobosil.dto.LinkDTO;
import cz.kobosil.dto.mapper.LinkMapper;
import cz.kobosil.entity.LinkEntity;
import cz.kobosil.entity.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private LinkRepository linkRepository;


    @Override
    public List<LinkEntity> getAllLinks() {

        return linkRepository.findAll();
    }


    @Override
    public LinkDTO createLink(LinkDTO linkDTO, MultipartFile imageFile) throws IOException {
        LinkEntity link = linkMapper.toEntity(linkDTO);
        link.setImageData(imageFile.getBytes());

        LinkEntity saved = linkRepository.save(link);

        return linkMapper.toDTO(saved);
    }

    @Override
    public LinkDTO editLink(long id, LinkDTO linkDTO, MultipartFile imageFile) throws IOException {
        LinkEntity entity = fetchLinkById(id);
        linkDTO.setId(id);

        linkMapper.updateEntity(linkDTO, entity);

        entity.setImageData(imageFile.getBytes());

        LinkEntity saved = linkRepository.save(entity);
        return linkMapper.toDTO(saved);
    }

    @Override
    public LinkDTO removeLink(long id) {
        LinkEntity link = fetchLinkById(id);
        LinkDTO model = linkMapper.toDTO(link);
        linkRepository.delete(link);
        return model;
    }

    @Override
    public LinkDTO getLinkById(long id) {
        LinkEntity link = fetchLinkById(id);

        LinkDTO linkDto = linkMapper.toDTO(link);

        linkDto.setImageData(Base64.getEncoder().encodeToString(link.getImageData()).getBytes());

        return linkDto;
    }

    private LinkEntity fetchLinkById(long id) {
        return linkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Link with id " + id + " wasn't found in the database."));
    }

    private byte[] uploadImage(MultipartFile file) throws IOException {

        return file.getBytes();
    }
}