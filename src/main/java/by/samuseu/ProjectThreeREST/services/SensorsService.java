package by.samuseu.ProjectThreeREST.services;

import by.samuseu.ProjectThreeREST.models.Sensor;
import by.samuseu.ProjectThreeREST.repositories.SensorsRepository;
import by.samuseu.ProjectThreeREST.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public List<Sensor> findAll() {
        return sensorsRepository.findAll();
    }

    public Sensor findOne(int id) {
        return sensorsRepository.findById(id).orElseThrow(SensorNotFoundException::new);
    }

    public Optional<Sensor> findByName(String name) {
        return Optional.ofNullable(sensorsRepository.findByName(name));
    }
    @Transactional
    public void save(Sensor sensor) {
        sensorsRepository.save(sensor);
    }
}