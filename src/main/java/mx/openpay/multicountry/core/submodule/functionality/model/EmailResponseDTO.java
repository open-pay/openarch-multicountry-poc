package mx.openpay.multicountry.core.submodule.functionality.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailResponseDTO implements Serializable {

   private static final long serialVersionUID = 1538511148221296045L;

   private String status;

}
