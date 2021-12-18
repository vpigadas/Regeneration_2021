package com.codehub.regen_2021.network;

import java.util.List;

public class JsonChannelResponse {

    private List<JsonShowResponse> shows;
    private String channelName;

    public List<JsonShowResponse> getShows() {
        return shows;
    }

    public void setShows(List<JsonShowResponse> shows) {
        this.shows = shows;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return "JsonChannelResponse{" +
                "shows=" + shows +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
