package com.suchness.intellisense.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class RiverTrack implements Serializable {
    @ApiModelProperty(value = "轨迹id")
    private Integer id;

    @ApiModelProperty(value = "轨迹")
    private String trackpoints;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackpoints() {
        return trackpoints;
    }

    public void setTrackpoints(String trackpoints) {
        this.trackpoints = trackpoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trackpoints=").append(trackpoints);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}