package lucas.api.fala.application.input;

import lucas.api.fala.domain.Category;

public record PersistTransactionInput(String description, long amount, Category category) {
}
