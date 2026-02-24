package mx.openpay.multicountry.core.submodule.functionality.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDTO {

   @Email
   private String email;

   @NotBlank
   private String name;

}
