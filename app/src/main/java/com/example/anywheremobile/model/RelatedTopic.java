package com.example.anywheremobile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic {

    @SerializedName("FirstURL")
    @Expose
    private String firstURL;
    @SerializedName("Icon")
    @Expose
    private Icon icon;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Text")
    @Expose
    private String text;

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RelatedTopic{" +
                "firstURL='" + firstURL + '\'' +
                ", icon=" + icon +
                ", result='" + result + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
