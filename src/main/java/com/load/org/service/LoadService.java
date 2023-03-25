package com.load.org.service;


import com.load.org.dto.LoadDTO;
import com.load.org.dto.LoadUpdateDTO;
import com.load.org.model.LoadModel;
import com.load.org.repo.LoadRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadService {
    private final LoadRepo loadRepo;

    private LoadModel toLoadModel(LoadDTO loadDTO) {
        LoadModel model = new LoadModel();
        model.setDate(loadDTO.getDate());
        model.setLoadingPoint(loadDTO.getLoadingPoint());
        model.setUnloadingPoint(loadDTO.getUnloadingPoint());
        model.setComment(loadDTO.getComment());
        model.setWeight(loadDTO.getWeight());
        model.setNoOfTrucks(loadDTO.getNoOfTrucks());
        model.setTuckType(loadDTO.getTruckType());
        model.setShipperId(loadDTO.getShipperId());
        model.setProductType(loadDTO.getProductType());
        return model;
    }

    private LoadDTO toLoadDTO(LoadModel loadModel) {
        LoadDTO dto = new LoadDTO();
        dto.setDate(loadModel.getDate());
        dto.setLoadingPoint(loadModel.getLoadingPoint());
        dto.setUnloadingPoint(loadModel.getUnloadingPoint());
        dto.setComment(loadModel.getComment());
        dto.setWeight(loadModel.getWeight());
        dto.setNoOfTrucks(loadModel.getNoOfTrucks());
        dto.setTruckType(loadModel.getTuckType());
        dto.setShipperId(loadModel.getShipperId());
        dto.setProductType(loadModel.getProductType());
        return dto;
    }

    public String save(LoadDTO loadDTO) {
        var model = toLoadModel(loadDTO);
        loadRepo.save(model);
        return "Load Details Added successfully " + model.getId();
    }

    public LoadDTO getLoad(Long id) {
        var model = loadRepo.findById(id).orElse(null);
        if (model == null) return null;
        return toLoadDTO(model);
    }

    public void deleteLoad(Long id) {
        loadRepo.deleteById(id);
    }

    public boolean updateLoad(LoadUpdateDTO loadUpdateDTO, Long id) {
        var model = loadRepo.findById(id);
        if (model.isEmpty()) return false;
        model.get().setProductType(loadUpdateDTO.getProductType());
        model.get().setComment(loadUpdateDTO.getComment());
        model.get().setDate(loadUpdateDTO.getDate());
        model.get().setLoadingPoint(loadUpdateDTO.getLoadingPoint());
        model.get().setUnloadingPoint(loadUpdateDTO.getUnloadingPoint());
        model.get().setWeight(loadUpdateDTO.getWeight());
        model.get().setNoOfTrucks(model.get().getNoOfTrucks());
        loadRepo.save(model.get());
        return true;
    }

    public List<LoadDTO> getAllLoads() {
        return loadRepo.findAll().stream().map(this::toLoadDTO).toList();
    }
}
