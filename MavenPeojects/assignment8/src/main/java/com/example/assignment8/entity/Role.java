package com.example.assignment8.entity;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class Role {

    @Id
    String name;

    String remark;

    @Convert(converter = StringListConverter.class)
    List<String> authorities=new ArrayList<>();

}

class StringListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> list) {
        return list == null ? "" : String.join(",", list);
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        return Strings.isEmpty(joined) ? new ArrayList<>()
                : Arrays.asList(joined.split(","));
    }
}
