package org.example.backend.controller;

import org.example.backend.dto.IemDTO;
import org.example.backend.service.IemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/iem")
public class IemController {
    @Autowired
    private IemService iemService;

    @GetMapping
    public List<IemDTO> getAllIems(){
        return iemService.getAllIems();

    }
    @GetMapping("/{id}")
    public IemDTO getIemById(@PathVariable Long id){
        return iemService.getIem(id);
    }
    @DeleteMapping("/{id}")
    public void deleteIem(@PathVariable Long id){
        return iemService.deleteIem(id);
    }
    @PostMapping
    public IemDTO createIem(@RequestBody IemDTO iemDTO){
        return iemService.createIem(iemDto);
    }
}
