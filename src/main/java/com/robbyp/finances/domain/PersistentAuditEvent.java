package com.robbyp.finances.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Persist AuditEvent managed by the Spring Boot actuator
 *
 * @see org.springframework.boot.actuate.audit.AuditEvent
 */
@Setter
@Getter
@Document(collection = "fin_persistent_audit_event")
public class PersistentAuditEvent implements Serializable {

  @Id
  @Field("event_id")
  private String id;

  @NotNull
  private String principal;

  private Instant auditEventDate;
  @Field("event_type")
  private String auditEventType;

  private Map<String, String> data = new HashMap<>();

}
