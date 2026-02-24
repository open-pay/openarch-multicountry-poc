package mx.openpay.multicountry.core.submodule.functionality.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailMessageService {

   public String createEmailMessage(final String email, final String htmlContent) {
      log.info("Creando mensaje de email para: {}", email);

      final StringBuilder message = new StringBuilder();
      message.append("To: ").append(email).append("\n");
      message.append("Subject: ").append("Creación de Cuenta").append("\n");
      message.append("Content-Type: text/html").append("\n");
      message.append(htmlContent);

      return message.toString();
   }

}
