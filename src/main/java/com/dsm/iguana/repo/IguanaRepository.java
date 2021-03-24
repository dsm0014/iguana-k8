package com.dsm.iguana.repo;

import com.dsm.iguana.model.Iguana;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IguanaRepository extends MongoRepository<Iguana, String> {

}
