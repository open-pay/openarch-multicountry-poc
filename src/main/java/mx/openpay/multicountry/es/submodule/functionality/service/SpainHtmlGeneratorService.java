package mx.openpay.multicountry.es.submodule.functionality.service;

import lombok.extern.slf4j.Slf4j;
import mx.openpay.multicountry.CountryImplementation;
import mx.openpay.multicountry.core.submodule.functionality.service.HtmlGeneratorService;

@Slf4j
@CountryImplementation("es")
public class SpainHtmlGeneratorService implements HtmlGeneratorService {

   @Override
   public String generateHtml(final String template, final String templateData) {
      log.info("Generando HTML final con mjml ...");

      return template.replace("{{name}}", templateData);
   }

}
