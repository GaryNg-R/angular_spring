package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findByCountryCode(@Param("code") String code);
    //To retrieve states for a given country code
    //localhost:8080/api/states/search/findByCountryCode?code=IN
}
