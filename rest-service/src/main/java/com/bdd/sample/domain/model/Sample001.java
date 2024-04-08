package com.bdd.sample.domain.model;

import com.bdd.sample.domain.resource.data.Sample001DC;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "sample001" , schema = "BDD_SAMPLE")
@AllArgsConstructor
@NoArgsConstructor
public class Sample001 {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String text;

    private int age;

    public void setText(String text) {
        this.text = text;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public int getAge() {
        return age;
    }


    public static Sample001 fromSample001Request(@NonNull Sample001DC sample001DC){
        Sample001 sample001 = new Sample001();
        sample001.text = sample001DC.getText();
        sample001.age = sample001DC.getAge();
        return sample001;
    }

    public boolean isEqualFieldByFieldCaseInsensetive(Sample001 otherSample001)  {
        return  this.getId().equalsIgnoreCase(otherSample001.getId())
                && this.getText().equalsIgnoreCase(otherSample001.getText())
                 && this.getAge()== otherSample001.getAge();
    }

    public boolean isEqualToSample001RequestFieldByFieldCaseInsensetive(Sample001DC sample001DC)  {
        if(this.getText() == null || sample001DC == null || sample001DC.getText() == null)
            return false;
        return  this.getText().equalsIgnoreCase(sample001DC.getText())
                && this.getAge()== sample001DC.getAge();
    }


    public boolean isEqualFieldByFieldCaseSensetive(Sample001 otherSample001)  {
        if(this.getText() == null || otherSample001== null || otherSample001.getText() == null)
            return false;
        return this.getId().equalsIgnoreCase(otherSample001.getId())
            && this.getText().equalsIgnoreCase(otherSample001.getText())
            && this.getAge()== otherSample001.getAge();
    }

}


