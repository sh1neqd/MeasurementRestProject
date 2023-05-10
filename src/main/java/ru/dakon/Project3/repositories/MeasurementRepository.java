package ru.dakon.Project3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dakon.Project3.models.Measurement;
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
