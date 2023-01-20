package by.samuseu.ProjectThreeREST.util;

import by.samuseu.ProjectThreeREST.dto.SensorDTO;
import by.samuseu.ProjectThreeREST.models.Sensor;
import by.samuseu.ProjectThreeREST.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;

        if (sensorsService.findByName(sensorDTO.getName()).isPresent()) {
            errors.rejectValue("name", "", "A sensor with this name is already in the database");
        }
    }
}