package edu.comillas.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acronym",
    "name",
    "otherAcronyms",
    "otherNames"
})
public class RegionalBloc {

    @JsonProperty("acronym")
    private String acronym;
    @JsonProperty("name")
    private String name;
    @JsonProperty("otherAcronyms")
    private List<String> otherAcronyms = null;
    @JsonProperty("otherNames")
    private List<String> otherNames = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("acronym")
    public String getAcronym() {
        return acronym;
    }

    @JsonProperty("acronym")
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("otherAcronyms")
    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    @JsonProperty("otherAcronyms")
    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    @JsonProperty("otherNames")
    public List<String> getOtherNames() {
        return otherNames;
    }

    @JsonProperty("otherNames")
    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
