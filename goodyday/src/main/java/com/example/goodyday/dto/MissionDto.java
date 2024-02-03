package com.example.goodyday.dto;

public class MissionDto {
    private String deviceId;
    private String title;
    private String guideText;
    private String content;
    private String photo_url;
    private Integer level;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return photo_url;
    }

    public void setImageUrl(String photo_url) {
        this.photo_url = photo_url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    // Constructors, getters, and setters
}
