package com.github.wubuku.sui.tests;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Arrays;

/**
 * From Move Definition:
 * <p>
 * <pre>
 *     struct DaySummaryCreated has copy, drop {
 *         id: object::ID,
 *         day: Day,
 *         description: String,
 *         meta_data: vector<u8>,
 *     }
 * </pre>
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class DaySummaryCreated {
    private String id;
    private Day day;
    private String description;
    private int[] metaData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getMetaData() {
        return metaData;
    }

    public void setMetaData(int[] metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "DaySummaryCreated{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", description='" + description + '\'' +
                ", metaData=" + Arrays.toString(metaData) +
                '}';
    }
}
