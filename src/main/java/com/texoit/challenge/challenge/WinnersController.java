package com.texoit.challenge.challenge;


import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WinnersController {

    @Autowired
    private ObjectMapper mapper; 
    
    @Autowired
    private MovieRepository repository;
    
    @GetMapping(value = "/awardIntervals")
    public ObjectNode helloWorld(HttpServletResponse response){
      
        ObjectNode responseBody = mapper.createObjectNode();
        ArrayNode minArray = responseBody.putArray("min");
        ArrayNode maxArray = responseBody.putArray("max");

        for(Object movie: this.repository.findMinInterval()){
           minArray.addPOJO(movie) ;
        }

        for(Object movie: this.repository.findMaxInterval()){
            maxArray.addPOJO(movie);
        }
        
        return responseBody;
    }
}
