package lucas.api.fala.application.output;

import lucas.api.fala.application.input.PersistTransactionInput;
import lucas.api.fala.domain.Transaction;
import lucas.api.fala.domain.TransactionRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record TransactionOutput(String id, String description, String category, double value) {
   public static TransactionOutput from(Transaction transaction){
       return new TransactionOutput(transaction.getId().uuid().toString(),
            transaction.getDescription(),
               transaction.getCategory().name(),
               BigDecimal.valueOf(transaction.getAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue());
   }
}
