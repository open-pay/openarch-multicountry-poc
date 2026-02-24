package mx.openpay.multicountry.core.submodule.functionality.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "EMAILS")
public class Email {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   @Column(name = "ID_EMAIL")
   private Long id;

   @Column(name = "MESSAGE")
   private String message;

   @Column(name = "STATUS")
   private String status;

}
