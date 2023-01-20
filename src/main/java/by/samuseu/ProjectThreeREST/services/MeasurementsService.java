package by.samuseu.ProjectThreeREST.services;

import by.samuseu.ProjectThreeREST.models.Measurement;
import by.samuseu.ProjectThreeREST.repositories.MeasurementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementsRepository measurementsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    public List<Measurement> findByRaining(boolean raining) {
        return measurementsRepository.findByRaining(raining);
    }

    @Transactional
    public void save(Measurement measurement) {
        measurementsRepository.save(measurement);
    }
}