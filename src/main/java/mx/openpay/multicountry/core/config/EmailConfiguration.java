package mx.openpay.multicountry.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import mx.openpay.multicountry.core.submodule.functionality.repository.EmailRepository;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailMessageService;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailOrchestratorService;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailSenderService;
import mx.openpay.multicountry.core.submodule.functionality.service.HtmlGeneratorService;
import mx.openpay.multicountry.core.submodule.functionality.service.TemplateService;

@Configuration
public class EmailConfiguration {

   // TODO Nota: Con esta configuracion prevenimos la creacion de 2 beans, por consiguiente el tener
   // que usar @qualifier
   @Bean
   @ConditionalOnMissingBean
   public EmailOrchestratorService emailOrchestratorService(final TemplateService templateService, final HtmlGeneratorService htmlGeneratorService, final EmailMessageService emailMessageService,
         final EmailSenderService emailSenderService, final EmailRepository emailRepository) {
      return new EmailOrchestratorService(templateService, htmlGeneratorService, emailMessageService, emailSenderService, emailRepository);
   }

}
