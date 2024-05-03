package com.capgemini.wsb.dto;

import java.time.LocalDateTime;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;

    public VisitTO(Long id, String description, LocalDateTime time)
    {
        this.id = id;
        this.description = description;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
