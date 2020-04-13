package com.dengage.sdk.models;

import com.google.gson.annotations.SerializedName;

public class TransactionalOpen extends ModelBase {
    @SerializedName("messageId")
    private int messageId;

    @SerializedName("messageDetails")
    private String messageDetails;

    @SerializedName("transactionId")
    private String transactionId;

    @SerializedName("userAgent")
    private transient String userAgent = "";

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }
}
