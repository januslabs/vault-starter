package org.januslabs.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("vault")
public class VaultProperties {

  private String url = "http://localhost:8200";
  private String prefix = "vault";
  private String mount = "secret";
  private String tokenKey = "VAULT_TOKEN";
  @Value("#{systemEnvironment['VAULT_TOKEN']}")
  private String token;
}
