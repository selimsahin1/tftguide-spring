package com.example.tftguide.Dao.Model;

import java.util.List;

public class Profile {

    ProfileSummaryA profileSummaryA;
    List<ProfileA> profileAList;

    public ProfileSummaryA getProfileSummaryA() {
        return profileSummaryA;
    }

    public void setProfileSummaryA(ProfileSummaryA profileSummaryA) {
        this.profileSummaryA = profileSummaryA;
    }

    public List<ProfileA> getProfileAList() {
        return profileAList;
    }

    public void setProfileAList(List<ProfileA> profileAList) {
        this.profileAList = profileAList;
    }
}
