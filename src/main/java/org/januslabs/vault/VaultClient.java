package org.januslabs.vault;

import org.springframework.beans.factory.annotation.Autowired;

import se.jhaals.Vault;

public class VaultClient {

  @Autowired
  private Vault vaultConfigurer;

  @Autowired
  private VaultProperties vaultProperties;

  public VaultClient(Vault vaultConfigurer) {
    this.vaultConfigurer = vaultConfigurer;
  }

  public String getValue(String path) {
    path = vaultProperties.getMount() + "/" + path;
    return vaultConfigurer.read(path).getData().get("value");
  }
}
