package ru.dakon.Project3.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dakon.Project3.models.Sensor;
import ru.dakon.Project3.repositories.SensorRepository;

import java.util.Optional;

@Service
@Transactional
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
