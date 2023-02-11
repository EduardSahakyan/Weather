package org.example.data.mappers;

import java.util.List;

public interface Mapper<RESPONSE, RESULT> {

    RESULT toEntity(RESPONSE dto);

    List<RESULT> toList(List<RESPONSE> listDto);

}
