package com.robbyp.finances.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Persistent tokens are used by Spring Security to automatically log in users.
 *
 * @see com.robbyp.jhips.security.PersistentTokenRememberMeServices
 */

@EqualsAndHashCode(of = "series")
@ToString
@Getter
@Document(collection = "fin_persistent_token")
public class PersistentToken implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final int MAX_USER_AGENT_LEN = 255;

  @Id
  @Setter
  private String series;

  @JsonIgnore
  @NotNull
  @Setter
  private String tokenValue;

  @Setter
  private LocalDate tokenDate;

  //an IPV6 address max length is 39 characters
  @Size(max = 39)
  @Setter
  private String ipAddress;

  @JsonIgnore
  @DBRef
  @Setter
  private User user;

  private String userAgent;

  public void setUserAgent(String userAgent) {
    if (userAgent.length() >= MAX_USER_AGENT_LEN) {
      this.userAgent = userAgent.substring(0, MAX_USER_AGENT_LEN - 1);
    } else {
      this.userAgent = userAgent;
    }
  }

}
