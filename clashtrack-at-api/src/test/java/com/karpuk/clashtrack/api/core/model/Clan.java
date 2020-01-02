package com.karpuk.clashtrack.api.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clan {

    private String tag;
    private String name;
    private String type;
    private int locationId;
    private int clanLevel;
    private int members;

    public Clan() {
    }

    public Clan(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getClanLevel() {
        return clanLevel;
    }

    public void setClanLevel(int clanLevel) {
        this.clanLevel = clanLevel;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clan clan = (Clan) o;

        if (locationId != clan.locationId) return false;
        if (clanLevel != clan.clanLevel) return false;
        if (members != clan.members) return false;
        if (tag != null ? !tag.equals(clan.tag) : clan.tag != null) return false;
        if (name != null ? !name.equals(clan.name) : clan.name != null) return false;
        return type != null ? type.equals(clan.type) : clan.type == null;
    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + locationId;
        result = 31 * result + clanLevel;
        result = 31 * result + members;
        return result;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", locationId=" + locationId +
                ", clanLevel=" + clanLevel +
                ", members=" + members +
                '}';
    }

}
