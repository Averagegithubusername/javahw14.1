package ru.netology.manager;

import ru.netology.domain.FlightOption;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.FlightOptionRepository;

import java.util.Arrays;

public class FlightOptionManager {

    private FlightOptionRepository repository;

    public FlightOptionManager(FlightOptionRepository repository) {
        this.repository = repository;
    }

    public void add(FlightOption option) {
        repository.save(option);
    }

    public FlightOption[] searchBy(String from, String to) {
        FlightOption[] result = new FlightOption[0];
        for (FlightOption option : repository.findAll()) {
            if (option.getFrom().contains(from) && option.getTo().contains(to)) {
                FlightOption[] tmp = new FlightOption[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = option;
                result = tmp;
            }
            if (result.length == 0) throw new NotFoundException("Рейсы не найдены");
        }
        Arrays.sort(result);
        return result;
    }
}
