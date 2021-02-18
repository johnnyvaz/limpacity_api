package br.com.limpacity.api.controller.base.error;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = -5300005787375927621L;
    private String developerMessage;
    private String userMessage;
    private String moreInfo;
    private long errorCode = 10000l;

    public ErrorDTO() {

    }

    public ErrorDTO(String developerMessage, String userMessage) {
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    public ErrorDTO(String developerMessage, String userMessage, long errorCode) {
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
        this.errorCode = errorCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

}
