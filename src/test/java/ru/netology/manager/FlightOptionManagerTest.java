package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOption;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.FlightOptionRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightOptionManagerTest {
    FlightOptionManager manager = new FlightOptionManager(new FlightOptionRepository());
    private FlightOption option1 = new FlightOption(1, 150_000, "SVO", "AKL", 1590);
    private FlightOption option2 = new FlightOption(2, 110_000, "SVO", "AKL", 1500);
    private FlightOption option3 = new FlightOption(3, 40_000, "SVO", "FAE", 1750);
    private FlightOption option4 = new FlightOption(4, 130_000, "DME", "AKL", 1560);
    private FlightOption option5 = new FlightOption(5, 25_000, "FAE", "FNC", 1150);
    private FlightOption option6 = new FlightOption(6, 15_000, "WAW", "TRN", 210);

    @BeforeEach
    public void setUp() {
        manager.add(option1);
        manager.add(option2);
        manager.add(option3);
        manager.add(option4);
        manager.add(option5);
        manager.add(option6);
    }

    @Test
    void shouldSearchFindAndSort() {
        FlightOption[] actual = manager.searchBy("SVO", "AKL");
        FlightOption[] expected = new FlightOption[]{option2, option1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAndNotFind() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.searchBy("FAE", "AKL");
        });
    }
}