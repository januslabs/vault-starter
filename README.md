<a href='https://bintray.com/nandhusriram/vault-starter/vault-starter/_latestVersion'><img src='https://api.bintray.com/packages/nandhusriram/vault-starter/vault-starter/images/download.svg'></a>
# vault-starter
==================
The Vault ,from HashiCorp  is a tool for securely accessing secrets. A secret is anything that you want to tightly control access to, such as API keys, passwords, certificates, and more. Vault provides a unified interface to any secret, while providing tight access control and recording a detailed audit log. This project provides a bootstrap around the  HTTP interfaces to Vault using Spring Boot in a non cloud environment.

Getting Started
================
The easiest way to get started with this starter project is to fork, clone or download this repository.

	git clone https://github.com/januslabs/vault-starter.git 
	
You will also need to install [Vault](https://www.vaultproject.io/docs/install/index.html).

Once installed, you can start a development server using the following command.

	vault server -dev
    export VAULT_ADDR='http://127.0.0.1:8200'
    export VAULT_TOKEN=xxxxxxxxxxxxxxxx
	vault write secret/hello value=world
	
For more information refer to the vault website [Vault]( https://www.vaultproject.io/intro/).

Bintray:

Grab the latest binary (0.0.1) [here] (https://bintray.com/artifact/download/nandhusriram/vault-starter/org/januslabs/vault-starter/0.0.1/vault-starter-0.0.1.jar).

Building
==========
Java Version: 1.8

Basic Compile and Test
======================
$ mvn clean install

###Maven:

```xml

<dependencies>
    <dependency>
     	<groupId>org.januslabs</groupId>
		<artifactId>vault-starter</artifactId>
		<version>0.0.1</version>
    </dependency>
   
</dependencies>

<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://jcenter.bintray.com</url>
    </repository>
</repositories>
```

Basic Usage
============
```java
VaultClient vaultclient=new VaultClient();
vaultclient.getValue("mydbpassword");
```