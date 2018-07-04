package com.bta.astro.asteria.service;

import com.bta.astro.asteria.audit.Action;
import com.bta.astro.asteria.audit.Audit;
import com.bta.astro.asteria.entity.AstronomicalObject;
import com.bta.astro.asteria.performance.PerformanceLog;
import com.bta.astro.asteria.repository.AstronomicalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

@Service
public class AstronomicalObjectsService {

    @Autowired
    private AstronomicalObjectRepository astronomicalObjectRepository;

    @PerformanceLog
    @Audit(action = Action.GET)
    public Iterable<AstronomicalObject> getAstronomicalObjects() {
        return astronomicalObjectRepository.findAll(PageRequest.of(0, 25));
    }
}
