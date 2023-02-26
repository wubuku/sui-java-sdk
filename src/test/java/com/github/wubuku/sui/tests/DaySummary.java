package com.github.wubuku.sui.tests;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.sui.bean.UID;

import java.util.Arrays;

@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class DaySummary {

    private UID id;

    private Day day;

    private Long version;

    private String description;

    private int[] metadata;

    private String[] arrayData;

    private int[] optionalData;

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getMetadata() {
        return metadata;
    }

    public void setMetadata(int[] metadata) {
        this.metadata = metadata;
    }

    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public int[] getOptionalData() {
        return optionalData;
    }

    public void setOptionalData(int[] optionalData) {
        this.optionalData = optionalData;
    }

    @Override
    public String toString() {
        return "DaySummary{" +
                "id=" + id +
                ", day=" + day +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", metadata=" + Arrays.toString(metadata) +
                ", arrayData=" + Arrays.toString(arrayData) +
                ", optionalData=" + Arrays.toString(optionalData) +
                '}';
    }
}
