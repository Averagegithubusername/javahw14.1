package ru.netology.manager;

import ru.netology.domain.FlightOption;
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

    public FlightOption[] searchBy(String text) {
        FlightOption[] result = new FlightOption[0];
        for (FlightOption option: repository.findAll()) {
            if (matches(option, text)) {
                //todo искать последовательно сначала по from потом по to
                FlightOption[] tmp = new FlightOption[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = option;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

//    public boolean matches(FlightOption option, String search) {
//        if (product instanceof Book) {
//            Book book = (Book) product;
//            if (book.getName().contains(search)) {
//                return true;
//            }
//            if (book.getAuthor().contains(search)) {
//                return true;
//            }
//        }
//        if (product instanceof Smartphone) {
//            Smartphone smartphone = (Smartphone) product;
//            if (smartphone.getName().contains(search)) {
//                return true;
//            }
//            if (smartphone.getManufacturer().contains(search)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
