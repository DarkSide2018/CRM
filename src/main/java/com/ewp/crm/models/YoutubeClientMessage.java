package com.ewp.crm.models;

import javax.persistence.*;

@Entity
public class YoutubeClientMessage {

    @Id
    @GeneratedValue
    @Column(name = "youtube_client_message_id")
    private Long id;

    @Column(nullable = false)
    @Lob
    private String messages;

    @ManyToOne
    @JoinTable(name = "youtube_client_youtube_client_message",
            inverseJoinColumns = {@JoinColumn(name = "youtube_client_id", foreignKey = @ForeignKey(name = "FK_YOUTUBE_CLIENT_YOUTUBE_CLIENT_MESSAGES"))},
            joinColumns = {@JoinColumn(name = "youtube_client_messages_id", foreignKey = @ForeignKey(name = "FK_YOUTUBE_CLIENT_MESSAGES"))})
    private YoutubeClient youtubeClient;

    public YoutubeClientMessage() {
    }

    public YoutubeClientMessage(String messages, YoutubeClient youtubeClient) {
        this.messages = messages;
        this.youtubeClient = youtubeClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public YoutubeClient getYoutubeClient() {
        return youtubeClient;
    }

    public void setYoutubeClient(YoutubeClient youtubeClient) {
        this.youtubeClient = youtubeClient;
    }

    @Override
    public String toString() {
        return "YoutubeClientMessage{" +
                "id=" + id +
                ", messages='" + messages + '\'' +
                ", youtubeClient=" + youtubeClient +
                '}';
    }
}
