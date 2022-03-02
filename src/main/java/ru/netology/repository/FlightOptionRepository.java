package ru.netology.repository;

import ru.netology.domain.FlightOption;

public class FlightOptionRepository {
    private FlightOption[] options = new FlightOption[0];

    public void save(FlightOption item) {
        int length = options.length + 1;
        FlightOption[] tmp = new FlightOption[length];
        System.arraycopy(options, 0, tmp, 0, options.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        options = tmp;
    }

    public FlightOption[] findAll() {
        return options;
    }

    public void removeById(int id) {
        int length = options.length - 1;
        FlightOption[] tmp = new FlightOption[length];
        int index = 0;
        for (FlightOption item : options) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        options = tmp;
    }
}
