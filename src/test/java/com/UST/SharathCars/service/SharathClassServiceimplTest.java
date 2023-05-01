package com.UST.SharathCars.service;

import com.UST.SharathCars.model.Cars;
import com.UST.SharathCars.repository.SharathClassRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SharathClassServiceimplTest {

    @Mock
    private SharathClassRepo mockRepo;

    @InjectMocks
    private SharathClassServiceimpl sharathClassServiceimplUnderTest;

    @Test
    void testAddCar() {
        // Setup
        final Cars car = new Cars(0, "carName", 0L, "brand", "colour", 0, "date");
        final Cars expectedResult = new Cars(0, "carName", 0L, "brand", "colour", 0, "date");

        // Configure SharathClassRepo.save(...).
        final Cars cars = new Cars(0, "carName", 0L, "brand", "colour", 0, "date");
        when(mockRepo.save(new Cars(0, "carName", 0L, "brand", "colour", 0, "date"))).thenReturn(cars);

        // Run the test
        final Cars result = sharathClassServiceimplUnderTest.addCar(car);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetallcars() {
        // Setup
        final List<Cars> expectedResult = List.of(new Cars(0, "carName", 0L, "brand", "colour", 0, "date"));

        // Configure SharathClassRepo.findAll(...).
        final List<Cars> cars = List.of(new Cars(0, "carName", 0L, "brand", "colour", 0, "date"));
        when(mockRepo.findAll()).thenReturn(cars);

        // Run the test
        final List<Cars> result = sharathClassServiceimplUnderTest.getallcars();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetallcars_SharathClassRepoReturnsNoItems() {
        // Setup
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Cars> result = sharathClassServiceimplUnderTest.getallcars();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetdate() {
        // Setup
        final List<Cars> expectedResult = List.of(new Cars(0, "carName", 0L, "brand", "colour", 0, "date"));

        // Configure SharathClassRepo.findByDate(...).
        final List<Cars> cars = List.of(new Cars(0, "carName", 0L, "brand", "colour", 0, "date"));
        when(mockRepo.findByDate("date")).thenReturn(cars);

        // Run the test
        final List<Cars> result = sharathClassServiceimplUnderTest.getdate("date");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetdate_SharathClassRepoReturnsNoItems() {
        // Setup
        when(mockRepo.findByDate("date")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Cars> result = sharathClassServiceimplUnderTest.getdate("date");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
