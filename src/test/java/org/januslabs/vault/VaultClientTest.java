package org.januslabs.vault;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(VaultAutoConfiguration.class)
public class VaultClientTest {

  /*
   * Root Token from the dev server
   */
  public static String VAULT_TOKEN="e549db34-8733-6a15-8847-9d079ec76b0f";
  private @Autowired VaultClient vaultclient;

 /* @Before
  public void before() throws Exception {
    
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    context.registerShutdownHook();
    Environment environment = context.getBean(Environment.class);
    String token = environment.getProperty("vault.token").toString();
    System.out.println(token);
   
  }
 
  
  @PropertySource("classpath:application.properties")
  static
  class AppConfig {

      @Bean
      public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
          return new PropertySourcesPlaceholderConfigurer();
      }
  }*/
  
 @Test
  public void testVaultClient()
  {
 
    Assert.notNull(vaultclient);
  }
  @Test
  /*
   * Please run vault write secret/hello value=world before the test
   */
  public void testGetValue()
  {
    Assert.hasText(vaultclient.getValue("hello"), "world");
  }
}
