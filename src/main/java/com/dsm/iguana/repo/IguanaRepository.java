package com.dsm.iguana.repo;

import com.dsm.iguana.model.Iguana;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "iguana", path = "iguana")
public interface IguanaRepository extends MongoRepository<Iguana, String> {

    public Iguana findByName(@Param("name") String name);


}
