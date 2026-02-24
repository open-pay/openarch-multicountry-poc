package mx.openpay.multicountry;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

class CustomProfileCondition implements Condition {

   @Override
   public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
      final MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(CountryImplementation.class.getName());
      if (attrs != null) {
         for (final Object value : attrs.get("value")) {
            if (context.getEnvironment().matchesProfiles((String[]) value)) {
               return true;
            }
         }
         return false;
      }
      return true;
   }

}
