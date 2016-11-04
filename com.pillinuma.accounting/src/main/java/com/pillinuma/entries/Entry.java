package com.pillinuma.entries;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fernando on 9/29/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="Entry.findAll",
                query="SELECT o FROM Entry o"),
        @NamedQuery(name="Entry.findByDate",
                query="SELECT o FROM Entry o WHERE o.date = :date"),
        @NamedQuery(name="Entry.findByAmount",
                query="SELECT o FROM Entry o WHERE o.amount = :amount")

})
public class Entry extends BaseBO {

    private String description;
    private BigDecimal amount;
    private LocalDate date;

    @Transient
    private Map<String, Tag> tags;

    public Entry() {
        tags = new HashMap<>();
    }

    public Entry(String description, BigDecimal amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    public String getId() {
        return super.getId();
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

    @Transient
    public Map<String, Tag> getTags() {
        return tags;
    }
}
