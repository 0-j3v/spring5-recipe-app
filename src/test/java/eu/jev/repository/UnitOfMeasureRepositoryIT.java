package eu.jev.repository;

import eu.jev.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUom() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon", optionalUnitOfMeasure.get().getUom());
    }

    @Test
    void findByUomCup() {
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByUom("Cup");
        assertEquals("Cup", optionalUnitOfMeasure.get().getUom());
    }
}