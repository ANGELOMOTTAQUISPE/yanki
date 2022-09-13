package yanki.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
/*
* Esta es el modelo de las cuentas ()
* @autor Angelo Motta
* */
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
    * Se crea una entidad Account con los parametros:
    * @param idAccount idcuenta
    * @param accountNumber
    * @param accountType
    * @param minimammount
    * @param fee
    * @param client
    * @param headline
    * @param authorizedSignatures
    * */
    @Id
    private String idAccount;
    private String accountNumber;
    private String debitCardNumber;
    private Client client;
    private String associatedCard;
}
