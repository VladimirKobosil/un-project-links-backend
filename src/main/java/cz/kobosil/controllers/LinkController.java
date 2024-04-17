package cz.kobosil.controllers;

import cz.kobosil.dto.LinkDTO;
import cz.kobosil.entity.LinkEntity;
import cz.kobosil.service.LinkService;
import io.swagger.v3.oas.annotations.links.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    private LinkService linkService;


    @PostMapping("/links")
    public ResponseEntity<?> createLink(@ModelAttribute LinkDTO linkDTO, @RequestPart("file") MultipartFile imageFile) throws IOException {
        LinkDTO createdLink = linkService.createLink(linkDTO, imageFile);
        return ResponseEntity.status(HttpStatus.OK).body(createdLink);
    }

    @PutMapping("/links/{linkId}")
    public ResponseEntity<LinkDTO> updateLink(@PathVariable long linkId, @ModelAttribute LinkDTO linkDTO, @RequestParam("file") MultipartFile imageFile) throws IOException {
        LinkDTO updatedLink = linkService.editLink(linkId, linkDTO, imageFile);
        return ResponseEntity.ok(updatedLink);
    }

    @GetMapping("/links")
    public List<LinkEntity> getLinks() {
        return linkService.getAllLinks();
    }

    @GetMapping("/links/{linkId}")
    public LinkDTO getLinkById(@PathVariable long linkId) {
        return linkService.getLinkById(linkId);
    }

    @DeleteMapping("/links/{linkId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeLink(@PathVariable long linkId) {
        linkService.removeLink(linkId);
    }

}