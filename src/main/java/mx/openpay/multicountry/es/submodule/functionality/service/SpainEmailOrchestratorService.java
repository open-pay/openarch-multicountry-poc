package mx.openpay.multicountry.es.submodule.functionality.service;

import lombok.extern.slf4j.Slf4j;
import mx.openpay.multicountry.CountryImplementation;
import mx.openpay.multicountry.core.submodule.functionality.repository.EmailRepository;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailMessageService;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailOrchestratorService;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailSenderService;
import mx.openpay.multicountry.core.submodule.functionality.service.HtmlGeneratorService;
import mx.openpay.multicountry.core.submodule.functionality.service.TemplateService;

@Slf4j
@CountryImplementation("es")
public class SpainEmailOrchestratorService extends EmailOrchestratorService {

   public SpainEmailOrchestratorService(final TemplateService templateService, final HtmlGeneratorService htmlGeneratorService, final EmailMessageService emailMessageService,
         final EmailSenderService emailSenderService,
         final EmailRepository emailRepository) {
      super(templateService, htmlGeneratorService, emailMessageService, emailSenderService, emailRepository);
   }

   @Override
   protected void optionalStep(final String emailMessage, final String status) {
      // Para españa no se requiere guardar la bitácora
      log.info("No se guarda email en bitácora ...");
   }

}
