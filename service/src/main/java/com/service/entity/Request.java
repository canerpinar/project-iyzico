//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.service.entity;

import javax.persistence.*;

@MappedSuperclass
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="locale")
    private String locale;
    @Column(name="conversationId")
    private String conversationId;

    public Request() {
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String toString() {
        return (new ToStringRequestBuilder(this)).append("locale", this.locale).append("conversationId", this.conversationId).toString();
    }
}
