package ru.dakon.Project3.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dakon.Project3.models.Measurement;
import ru.dakon.Project3.repositories.MeasurementRepository;

import java.util.List;

@Service
@Transactional
public class MeasurementService {
//    private final MeasurementRepository measurementRepository;
//    private final SensorService sensorService;
//
//    @Autowired
//    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
//        this.measurementRepository = measurementRepository;
//        this.sensorService = sensorService;
//    }
//
//    public List<Measurement> findAll() {
//        return measurementRepository.findAll();
//    }
//
//    @Transactional
//    public void save(Measurement measurement) {
//        enrichMeasurement(measurement);
//        measurementRepository.save(measurement);
//    }
//
//    public void enrichMeasurement(Measurement measurement) {
//        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
//    }

    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    public MeasurementService(MeasurementRepository measurementRepository,
                              SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        // мы должны сами найти сенсор из БД по имени и вставить объект из Hibernate persistence context'а
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());

    }

}
