package com.shuku.helper;

import com.shuku.entity.Avatar;
import com.shuku.entity.Contribution;

import java.util.Date;

public class UserHelper {
    private long id;
    private String usercode;
    private String username;
    private String email;
    private Avatar avatar;
    private int contributionValue;
    private Contribution contribution;
    private Date creationdate;

    public UserHelper() {
    }

    public UserHelper(long id, String usercode, String username, String email, Avatar avatar, int contributionValue, Contribution contribution, Date creationdate) {
        this.id = id;
        this.usercode = usercode;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.contributionValue = contributionValue;
        this.contribution = contribution;
        this.creationdate = creationdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public int getContributionValue() {
        return contributionValue;
    }

    public void setContributionValue(int contributionValue) {
        this.contributionValue = contributionValue;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}
