package mx.openpay.multicountry.core.submodule.functionality.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import mx.openpay.multicountry.core.submodule.functionality.entity.Email;
import mx.openpay.multicountry.core.submodule.functionality.model.EmailRequestDTO;
import mx.openpay.multicountry.core.submodule.functionality.model.EmailResponseDTO;
import mx.openpay.multicountry.core.submodule.functionality.repository.EmailRepository;
import mx.openpay.oa.sb.starter.data.jpa.repository.config.OpJpaConstants;

@Slf4j
public class EmailOrchestratorService {

   private final TemplateService templateService;

   private final HtmlGeneratorService htmlGeneratorService;

   private final EmailMessageService emailMessageService;

   private final EmailSenderService emailSenderService;

   private final EmailRepository emailRepository;

   public EmailOrchestratorService(final TemplateService templateService, final HtmlGeneratorService htmlGeneratorService, final EmailMessageService emailMessageService,
         final EmailSenderService emailSenderService, final EmailRepository emailRepository) {
      this.templateService = templateService;
      this.htmlGeneratorService = htmlGeneratorService;
      this.emailMessageService = emailMessageService;
      this.emailSenderService = emailSenderService;
      this.emailRepository = emailRepository;
   }

   // TODO: Nota: no se puede hacer uso de final en metodos, ya que esto rompe en uso de proxies por
   // parte de spring. La idea de usar final es para prevenir que las clases hijas sobre escriban el
   // comportamiento global/core. Si quisieramos forzar este comportamiento habria que definir alguna
   // estrategia.
   @Transactional(transactionManager = OpJpaConstants.TRANSACTION_MANAGER_JPA_ONE)
   public EmailResponseDTO processAndSendEmail(final EmailRequestDTO request) {
      // Paso 1: Obtener template
      final String template = this.templateService.getTemplate();

      // Paso 2: Generar HTML final
      final String htmlContent = this.htmlGeneratorService.generateHtml(template, request.getName());

      // Paso 3: Crear mensaje de email
      final String emailMessage = this.emailMessageService.createEmailMessage(request.getEmail(), htmlContent);

      // Paso 4: Enviar email
      final String status = this.emailSenderService.sendEmail(emailMessage);

      // Paso 5: Guardar bitácora (opcional)
      this.optionalStep(emailMessage, status);

      return EmailResponseDTO.builder().status(status).build();
   }

   protected void optionalStep(final String emailMessage, final String status) {
      log.info("Guardando email en bitácora ...");
      this.emailRepository.save(Email.builder().message(emailMessage).status(status).build());
   }

}
