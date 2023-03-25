package com.load.org.controller;


import com.load.org.dto.LoadDTO;
import com.load.org.dto.LoadUpdateDTO;
import com.load.org.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/load")
@RequiredArgsConstructor
public class LoadController {
    private final LoadService loadService;

    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody LoadDTO loadDTO) {
        if (loadDTO.getDate() == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        var val = loadService.save(loadDTO);
        return ResponseEntity.ok(val);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateLoad(@PathVariable("id") Long id, @RequestBody LoadUpdateDTO loadUpdateDTO) {
        if (loadUpdateDTO.getDate() == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if (!loadService.updateLoad(loadUpdateDTO, id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LoadDTO>> getAllLoads() {
        return ResponseEntity.ok(loadService.getAllLoads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadDTO> getLoad(@PathVariable("id") Long id) {
        return ResponseEntity.ok(loadService.getLoad(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable("id") Long id) {
        loadService.deleteLoad(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
