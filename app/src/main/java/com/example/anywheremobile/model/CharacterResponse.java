package com.example.anywheremobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResponse {

    @SerializedName("RelatedTopics")
    @Expose
    private List<RelatedTopic> relatedTopics;

    public List<RelatedTopic> getRelatedTopics() {
        return relatedTopics;
    }

    public void setRelatedTopics(List<RelatedTopic> relatedTopics) {
        this.relatedTopics = relatedTopics;
    }

    @Override
    public String toString() {
        return "CharacterResponse{" +
                "relatedTopics=" + relatedTopics +
                '}';
    }
}
