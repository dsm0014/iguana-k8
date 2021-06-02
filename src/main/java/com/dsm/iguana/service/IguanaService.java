package com.dsm.iguana.service;

import com.dsm.iguana.model.Iguana;
import com.dsm.iguana.repo.IguanaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import org.yaml.snakeyaml.tokens.ValueToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IguanaService {


    private static IguanaRepository repo;

    private static List<Iguana> data = new ArrayList<>();

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

    public List<Iguana> findAll() {
        if(data.size() < 1) {
            data = repo.findAll();
        }
        return data;
    }

    public List<Iguana> search(String iguanaInput) {
        if (StringUtils.isEmptyOrWhitespace(iguanaInput)) {
            return this.findAll();
        }
        String iguana = iguanaInput.toLowerCase().trim();
        return data.stream().parallel()
                .filter(ig -> ig.getName().toLowerCase().contains(iguana)
                           || ig.getBinomialName().toLowerCase().contains(iguana)
                           || Arrays.stream(ig.getAlternateNames()).parallel()
                                .anyMatch(altName -> altName.toLowerCase().contains(iguana)))
                .collect(Collectors.toList());
    }
}
