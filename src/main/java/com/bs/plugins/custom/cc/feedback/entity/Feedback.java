package com.bs.plugins.custom.cc.feedback.entity;

import com.bs.plugins.custom.cc.feedback.base.BaseFeedback;

import javax.validation.constraints.Pattern;

public class Feedback extends BaseFeedback {

    private static final long serialVersionUID = 1L;
    /**
     * 邮箱-
     **/
    @Pattern(regexp = "^[^@]+@[^@]+\\.[^@]+$")
    private String email;
    /**
     * 电话-
     **/
    @Pattern(regexp = "^0?1[3|4|5|7|8][0-9]\\d{8}$")
    private String mobilePhone;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public Feedback() {
    }

}
