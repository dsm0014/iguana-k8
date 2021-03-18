package com.dsm.iguana.api.service;

import com.dsm.iguana.api.model.Iguana;
import com.dsm.iguana.api.repo.IguanaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class IguanaService {


    private static IguanaRepository repo;

    @Autowired
    public IguanaService(IguanaRepository repo) {
        IguanaService.repo = repo;
    }

    public static boolean loadIguanaData() {
        ObjectMapper mapper = new ObjectMapper();
        File iguanaFile = new File("./data/iguanas.json");
        List<Iguana> iguanaData;
        try {
            iguanaData = mapper.readValue(iguanaFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (repo.findAll().size() != iguanaData.size()) {
            repo.deleteAll();
            repo.saveAll(iguanaData);
            return true;
        }
        return false;
    }
}
