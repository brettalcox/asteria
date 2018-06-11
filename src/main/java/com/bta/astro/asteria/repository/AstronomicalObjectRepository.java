package com.bta.astro.asteria.repository;

import com.bta.astro.asteria.entity.AstronomicalObject;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "astronomical-objects", path = "astronomical-objects")
public interface AstronomicalObjectRepository extends PagingAndSortingRepository<AstronomicalObject, String> {
}
