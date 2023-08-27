package com.ojaoba.calender.repository;

import com.ojaoba.calender.model.Content;
import com.ojaoba.calender.model.Status;
import com.ojaoba.calender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findALl(){

        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c->c.id().equals(id)).findFirst();


    }

    public void save(Content content){
        contentList.removeIf(c->c.id().equals((content.id())));
        contentList.add(content);

    }

    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "My first blog post",
                "My blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

       Content b = new Content(2,
               "My second blog post",
               "My second blog post",
               Status.IDEA,
               Type.ARTICLE,
               LocalDateTime.now(),
               null,
               "");



        contentList.add(c);
        contentList.add(b);

    }


    public boolean existsById(Integer id) {
        Boolean answer =  contentList.stream().filter(c-> c.id().equals(id)).count() == 1;
        System.out.println(answer);
        return answer;
    }

    public void delete(Integer id) {
        contentList.removeIf(c->c.id().equals(id));
    }
}
