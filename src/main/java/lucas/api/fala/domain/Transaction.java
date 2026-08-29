package lucas.api.fala.domain;



public class Transaction {
    private TransactionId id;
    private String description;
    private long amount;
    private Category category;


    public Transaction(Category category, long amount, String description) {
        this.id = new TransactionId();
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public TransactionId getId() {
        return id;
    }

    public void setId(TransactionId id) {
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
