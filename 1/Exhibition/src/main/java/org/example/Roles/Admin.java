package org.example.Roles;

import org.example.Exhibitions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Admin {

    int id = 0;
    Map<Integer, AuthorizedUser> autUserList = new HashMap<>();
    Map<Integer, Exhibitions> exhibitionList = new HashMap<>();

    @PostMapping(path = "/exhibition/new", consumes = "application/json", produces = "application/json")
    public Integer addExhibition(@RequestBody Exhibitions exhibition) {
        if (!exhibitionList.containsValue(exhibition)) {
            exhibitionList.put(++id, exhibition);
        }
        return id;
    }

    @GetMapping("/exhibition/{id}")
    public Exhibitions getExhibition(@PathVariable int id) {
        Exhibitions exhibition = exhibitionList.get(id);
        if (exhibition == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return exhibition;
    }

    @PutMapping("/exhibition/{id}")
    public Integer editExhibition(@RequestBody Exhibitions exhibition, @PathVariable int id) {
        if (!exhibitionList.containsValue(exhibition)) {
            exhibitionList.put(++id, exhibition);
        }
        return id;
    }

    @DeleteMapping("/exhibition/{id}")
    public void deleteExhibition(@RequestParam(value="id") Integer id){
        exhibitionList.remove(id);
    }

    @GetMapping("/autuser/{id}")
    public AuthorizedUser getAutUser(@PathVariable int id) {
        AuthorizedUser autUser = autUserList.get(id);
        if (autUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return autUser;
    }


    @DeleteMapping("/autuser/{id}")
    public void deleteAutUser(@RequestParam(value="id") Integer id){
        autUserList.remove(id);
    }
}