# subscriptions-client-java

This API lets you manage the subscriptions to API Hub asynchronous events. It enables you to receive notifications (asynchronous events) from Círculo de Crédito next-generation products (Open Banking &amp; Data Aggregation).

## Requirements

1. Java >= 1.7
2. Maven >= 3.3
## Installation

To install the dependencies, the following command must be executed:
```shell
mvn install -Dmaven.test.skip=true
```
## Getting started

### Step 1. Generate key and certificate

Before launching the test, you must have a keystore for the private key and the certificate associated with it.
To generate the keystore, execute the instructions found in ***src/main/security/createKeystore.sh*** or with the following commands:

**Optional**: If you want to encrypt your container, put a password in an environment variable.

```shell
export KEY_PASSWORD=your_super_secure_password
```

**Optional**: If you want to encrypt your keystore, put a password in an environment variable.

```shell
export KEYSTORE_PASSWORD=your_super_secure_keystore_password
```

- Definition of file names and aliases.

```shell
export PRIVATE_KEY_FILE=pri_key.pem
export CERTIFICATE_FILE=certificate.pem
export SUBJECT=/C=MX/ST=MX/L=MX/O=CDC/CN=CDC
export PKCS12_FILE=keypair.p12
export KEYSTORE_FILE=keystore.jks
export ALIAS=cdc
```
- Generate key and certificate.

```shell
# Genera la llave privada.
openssl ecparam -name secp384r1 -genkey -out ${PRIVATE_KEY_FILE}

# Genera el certificado público
openssl req -new -x509 -days 365 \
  -key ${PRIVATE_KEY_FILE} \
  -out ${CERTIFICATE_FILE} \
  -subj "${SUBJECT}"

```

- Generate PKCS12 container from private key and certificate

```shell
# Generate PKCS12 container from private key and certificate
# You will need to package your private key and certificate.

openssl pkcs12 -name ${ALIAS} \
  -export -out ${PKCS12_FILE} \
  -inkey ${PRIVATE_KEY_FILE} \
  -in ${CERTIFICATE_FILE} \
  -password pass:${KEY_PASSWORD}

```

- Generate a dummy keystore and delete its content.

```sh
#Generate a Keystore with a pair of dummy keys.
keytool -genkey -alias dummy -keyalg RSA \
    -keysize 2048 -keystore ${KEYSTORE_FILE} \
    -dname "CN=dummy, OU=, O=, L=, S=, C=" \
    -storepass ${KEYSTORE_PASSWORD} -keypass ${KEY_PASSWORD}
#Remove the dummy key pair.
keytool -delete -alias dummy \
    -keystore ${KEYSTORE_FILE} \
    -storepass ${KEYSTORE_PASSWORD}
```

- Import the PKCS12 container to the keystore

```sh
#We import the PKCS12 container
keytool -importkeystore -srckeystore ${PKCS12_FILE} \
  -srcstoretype PKCS12 \
  -srcstorepass ${KEY_PASSWORD} \
  -destkeystore ${KEYSTORE_FILE} \
  -deststoretype JKS -storepass ${KEYSTORE_PASSWORD} \
  -alias ${ALIAS}
#List the contents of the Kesystore to verify that
keytool -list -keystore ${KEYSTORE_FILE} \
  -storepass ${KEYSTORE_PASSWORD}
```

### Step 2. Uploading the certificate within the developer portal

 1. Login
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, select the previously created certificate and click the button "**Cargar**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/upload_cert.png">
    </p>

### Step 3. Download the Círculo de Crédito certificate within the developer portal

 1. Login.
 2. Click on the section "**Mis aplicaciones**".
 3. Select the application.
 4. Go to the tab "**Certificados para @tuApp**".
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/applications.png">
    </p>
 5. When the window opens, click the button "**Descargar**":
    <p align="center">
        <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/download_cert.png">
    </p>

### Step 4. Modify configuration file

To make use of the certificate that was downloaded and the keystore that was created, the routes found in ***src/main/resources/config.properties***
```properties
keystore_file=your_path_for_your_keystore/keystore.jks
cdc_cert_file=your_path_for_certificate_of_cdc/cdc_cert.pem
keystore_password=your_super_secure_keystore_password
key_alias=cdc
key_password=your_super_secure_password
```
### Step 5. Modify URL and request data

In the WebHookSubscriptionsApiTest.java file, found at ***src/test/java/io/Subscriptions/client/api/***. The request and URL data for API consumption must be modified in setBasePath ("the_url"), as shown in the following code snippet with the corresponding data:

> ** NOTE: ** The data in the following request is only representative.

```java
public class WebHookSubscriptionsApiTest {
    
    private Logger logger = LoggerFactory.getLogger(WebHookSubscriptionsApiTest.class.getName());
    private final WebHookSubscriptionsApi api = new WebHookSubscriptionsApi();
    private ApiClient apiClient = null;
    private String xApiKey = "your_api_key";
    private UUID subscriptionId = null;
    private String username ="username_account";
    private String password = "password_account";
    
    
    @Before
    public void setUp() {
    	this.apiClient = api.getApiClient();
    	this.apiClient.setBasePath("the_url");
    	OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new SignerInterceptor())
                .build();
    	apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void deleteSubscriptionTest() throws ApiException {
        String xApiKey = this.xApiKey;
        String username = this.username;
        String password = this.password;
       
        String subscriptionId = "uuid existing";
        SubscriptionAcknowledge response = api.deleteSubscription(xApiKey, username, password,  subscriptionId);
        Assert.assertNotNull(response);
        logger.info(response.toString());
    }
    
    
    @Test
    public void getSubscriptionTest() throws ApiException {
        String xApiKey = this.xApiKey;
        String username = this.username;
        String password = this.password;

        String subscriptionId = "uuid existing";

        Subscription response = api.getSubscription(xApiKey, username, password, subscriptionId);

        Assert.assertNotNull(response);
        logger.info(response.toString());
    }
    
    
    @Test
    public void getSubscriptionsTest() throws ApiException {
        String xApiKey = this.xApiKey;
        String username = this.username;
        String password = this.password;
        
        String page = "1";
        String perPage = "2";
        SubscriptionsMetadata response = api.getSubscriptions(xApiKey, username, password, page, perPage);

        Assert.assertNotNull(response);
        logger.info(response.toString());
    }
    
    
     @Test
    public void postSubscriptionTest() throws ApiException {
        String xApiKey = this.xApiKey;
        String username = this.username;
        String password = this.password;

        
        Subscription enrollment = new Subscription();
        enrollment.setEventType("mx.com.circulolaboral.employmentverification");
        enrollment.setWebHookUrl("https://yourdomain.com/v1/notifications");
        enrollment.setEnrollmentId(UUID.randomUUID());
        
        
        EncriptHelper encript = new EncriptHelper("username_webhook","password_webhook");
        String xWebhookJwtAuth = encript.getCredentialJWT();

        SubscriptionAcknowledge subsAck = api.postSubscription(xApiKey, username, password,  enrollment, xWebhookJwtAuth);
        Assert.assertNotNull(subsAck);
        logger.info(subsAck.toString());
        
    }
    
}


```
### Step 6. 
Run the unit test


Having the previous steps, all that remains is to run the unit test, with the following command:
```shell
mvn test -Dmaven.install.skip=true
```
