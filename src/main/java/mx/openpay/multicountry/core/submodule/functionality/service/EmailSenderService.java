package mx.openpay.multicountry.core.submodule.functionality.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailSenderService {

   public String sendEmail(final String emailMessage) {
      log.info("Enviando mensaje:\n" + emailMessage);
      log.info("Email enviado exitosamente");

      return "Sent";
   }

}
