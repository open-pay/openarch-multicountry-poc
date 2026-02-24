package mx.openpay.multicountry.core.submodule.functionality.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mx.openpay.multicountry.core.submodule.functionality.model.EmailRequestDTO;
import mx.openpay.multicountry.core.submodule.functionality.model.EmailResponseDTO;
import mx.openpay.multicountry.core.submodule.functionality.service.EmailOrchestratorService;
import mx.openpay.oa.sb.starter.web.controller.OpAbstractController;
import mx.openpay.oa.sb.starter.web.response.OpResponseDTO;

@RestController
public class EmailController extends OpAbstractController {

   private final EmailOrchestratorService emailOrchestratorService;

   public EmailController(final EmailOrchestratorService emailOrchestratorService) {
      this.emailOrchestratorService = emailOrchestratorService;
   }

   @PostMapping(path = "/email", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public OpResponseDTO<EmailResponseDTO> processAndSendEmail(@RequestBody final EmailRequestDTO request) {
      final EmailResponseDTO response = this.emailOrchestratorService.processAndSendEmail(request);

      return super.createSuccessResponse(response);
   }

}
