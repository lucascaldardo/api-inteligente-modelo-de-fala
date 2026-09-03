package lucas.api.fala.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lucas.api.fala.domain.Category;

import java.util.UUID;

@Entity
public class TransactionEntity {

    @Id
    private UUID id;

    private String description;
    private long amount;
    private Category category;

    public TransactionEntity() {
    }

    public TransactionEntity(UUID id, String description, long amount, Category category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
