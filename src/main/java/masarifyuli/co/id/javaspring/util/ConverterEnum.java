package masarifyuli.co.id.javaspring.util;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public abstract class ConverterEnum<T extends Enum<T>> implements AttributeConverter<T, String> {
    private final Class<T> clazz;

    protected ConverterEnum(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return attribute != null ? String.valueOf(attribute.ordinal()) : null;
    }

    @Override
    public T convertToEntityAttribute(String string) {
        if (StringUtils.isBlank(string)) {
            return null;
        }
        T[] enums = clazz.getEnumConstants();
        for (T e : enums) {
            if (String.valueOf(e.ordinal()).equals(string)) {
                return e;
            }
        }
        return null;
    }
}


