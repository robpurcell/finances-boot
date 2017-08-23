package com.robbyp.finances.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.robbyp.finances.config.Constants;


/**
 * A user.
 */
@ToString
@EqualsAndHashCode(callSuper=false)
@Setter
@Getter
@Document(collection = "fin_user")
public class User extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @NotNull
  @Pattern(regexp = Constants.LOGIN_REGEX)
  @Size(min = 1, max = 50)
  @Indexed
  private String login;

  @JsonIgnore
  @NotNull
  @Size(min = 60, max = 60)
  private String password;

  @Size(max = 50)
  @Field("first_name")
  private String firstName;

  @Size(max = 50)
  @Field("last_name")
  private String lastName;

  @Email
  @Size(min = 5, max = 100)
  @Indexed
  private String email;

  private boolean activated = false;

  @Size(min = 2, max = 5)
  @Field("lang_key")
  private String langKey;

  @Size(max = 256)
  @Field("image_url")
  private String imageUrl;

  @Size(max = 20)
  @Field("activation_key")
  @JsonIgnore
  private String activationKey;

  @Size(max = 20)
  @Field("reset_key")
  @JsonIgnore
  private String resetKey;

  @Field("reset_date")
  private Instant resetDate = null;

  @JsonIgnore
  private Set<Authority> authorities = new HashSet<>();

}
