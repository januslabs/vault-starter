package org.januslabs.vault;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import se.jhaals.Vault;

@Configuration
@EnableConfigurationProperties
@Slf4j
public class VaultAutoConfiguration {

  private @Autowired Environment environment;
  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnProperty(value = "vault.enabled", matchIfMissing = true)
  public VaultProperties vaultProperties() {
    log.info("getting VaultProperties");
    return new VaultProperties();
  }

  @Bean
  @ConditionalOnProperty(value = "vault.enabled", matchIfMissing = true)
  public Vault vaultConfigurer(VaultProperties vaultProperties) {
    log.info("environment  " + environment);
    if (vaultProperties.getToken()==null || vaultProperties.getToken().isEmpty()) {
      vaultProperties.setToken(System.getenv(vaultProperties.getTokenKey()));
    }
    return new Vault(vaultProperties.getUrl(), vaultProperties.getToken());
  }

  @Bean
  @ConditionalOnProperty(value = "vault.enabled", matchIfMissing = true)
  @DependsOn()
  public VaultClient vaultClient(Vault vaultConfigurer) {
    return new VaultClient(vaultConfigurer);
  }

}
