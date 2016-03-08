package org.januslabs.vault;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(VaultAutoConfiguration.class)
@ActiveProfiles("test")
public class VaultClientTest {

  /*
   * Root Token from the dev server
   */
  public static String VAULT_TOKEN = "38377754-c116-11d1-49a4-2ed6d139c9ee";

  @Rule
  public  final EnvironmentVariables environmentVariables = new EnvironmentVariables();

  
  public  void setEnvironmentVariables() {
    environmentVariables.set("VAULT_TOKEN", VAULT_TOKEN);
    environmentVariables.set("VAULT_ADDR", "http://127.0.0.1:8200");
    Assert.hasText(System.getenv("VAULT_TOKEN"), VAULT_TOKEN);
  }

  private @Autowired VaultClient vaultclient;

  @Test
  public void testVaultClient() {
    setEnvironmentVariables();
    Assert.notNull(vaultclient);
  }

  @Test
  /*
   * Please run vault write secret/hello value=world before the test
   */
  public void testGetValue() {
    setEnvironmentVariables();
    Assert.hasText(vaultclient.getValue("hello"), "world");
  }
}
