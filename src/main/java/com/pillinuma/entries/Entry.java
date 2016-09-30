package com.pillinuma.entries;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fernando on 9/29/16.
 */
public class Entry {

    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Map<String, Tag> tags;

    public Entry() {
        tags = new HashMap<>();
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addTag(Tag tag) {
        tags.put(tag.getName(), tag);
    }

    public Tag getTag(String tagName) {
        return tags.get(tagName);
    }

    public void setTags(Map<String, Tag> tags) {
        this.tags = tags;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }
}
