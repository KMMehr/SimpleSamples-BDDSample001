package com.bdd.sample.domain.resource.data;
import io.cucumber.datatable.DataTable;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
//@Builder
public class Sample001DC {

    String text;

    int age;

    @Builder
    public static Sample001DC newSample001DC(String text , int age){
        Sample001DC sample001DC = new Sample001DC();
        sample001DC.text = text;
        sample001DC.age = age;
        return sample001DC;
    }

    public static List<Sample001DC> getListFromCucumberTable(DataTable table)
    {
        List<Sample001DC> sample001DCList = new ArrayList<>();
        table.cells()
                .stream()
                .skip(1)        // Skip header row
                .map(rowColumns -> new Sample001DCBuilder().text(rowColumns.get(0)).age(Integer.parseInt(rowColumns.get(1)))
                            .build())
                .forEach(sample001DCList::add);
        return sample001DCList;
    }

}



