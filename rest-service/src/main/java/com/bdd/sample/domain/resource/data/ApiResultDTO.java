package com.bdd.sample.domain.resource.data;

import io.cucumber.datatable.DataTable;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class ApiResultDTO {

    private String httpStatusCode;
    private String message;

    @Builder
    public static ApiResultDTO newApiResultDTO(String httpStatusCode,String message)  {
        ApiResultDTO apiResultDTO = new ApiResultDTO();
        apiResultDTO.httpStatusCode = httpStatusCode;
        apiResultDTO.message = message;
        return apiResultDTO;
    }

    public static List<ApiResultDTO> getListFromCucumberTable(DataTable table)   {
        List<ApiResultDTO> apiResultList = new ArrayList<>();
        table.cells()
                .stream()
                .skip(1)        // Skip header row
                .map(rowColumns -> new ApiResultDTOBuilder()
                        .httpStatusCode(rowColumns.get(0))
                        .message(rowColumns.get(1))
                        .build())
                .forEach(apiResultList::add);
        return apiResultList;
    }

}

