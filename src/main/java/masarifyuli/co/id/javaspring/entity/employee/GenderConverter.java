package masarifyuli.co.id.javaspring.entity.employee;

import masarifyuli.co.id.javaspring.util.ConverterEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
class GenderConverter extends ConverterEnum<Employee.Gender> implements AttributeConverter<Employee.Gender, String> {
    public GenderConverter() {
        super(Employee.Gender.class);
    }
}