package lucas.api.fala.application;

import lucas.api.fala.application.input.PersistTransactionInput;
import lucas.api.fala.application.output.TransactionOutput;
import lucas.api.fala.domain.Category;
import lucas.api.fala.domain.Transaction;
import lucas.api.fala.domain.TransactionRepository;

public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionOutput execute(PersistTransactionInput input){
        var transaction = transactionRepository.save(
                new Transaction(input.category(), input.amount(), input.description()));
        return TransactionOutput.from(transaction);
    }
}
