package com.ojaoba.calender.controller;

import com.ojaoba.calender.model.Content;
import com.ojaoba.calender.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
@CrossOrigin
public class ContentController {

     private final ContentCollectionRepository contentCollectionRepository;

    @GetMapping("")
     public List<Content> findAll(){

         return contentCollectionRepository.findALl();


     }

     @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){

      return  contentCollectionRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found "));
     }

     @PostMapping("")
     @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid  @RequestBody Content content){
        contentCollectionRepository.save(content);


     }
     @PutMapping("/{id}")
     public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!contentCollectionRepository.existsById(id)){

            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }

        contentCollectionRepository.save(content);


     }

     @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        contentCollectionRepository.delete(id);
     }




}
