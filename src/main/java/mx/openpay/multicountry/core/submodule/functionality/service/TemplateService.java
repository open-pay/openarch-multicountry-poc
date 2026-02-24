package mx.openpay.multicountry.core.submodule.functionality.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TemplateService {

   public String getTemplate() {
      log.info("Obteniendo template ...");

      return "<html><body><h1>Creación de Cuenta</h1><p>Bienvenido {{name}}</p></body></html>";
   }

}
