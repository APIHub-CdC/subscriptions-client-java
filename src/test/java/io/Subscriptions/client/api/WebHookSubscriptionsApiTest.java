package io.Subscriptions.client.api;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.Subscriptions.client.ApiClient;
import io.Subscriptions.client.ApiException;
import io.Subscriptions.client.model.Subscription;
import io.Subscriptions.client.model.SubscriptionAcknowledge;
import io.Subscriptions.client.model.SubscriptionsMetadata;
import io.Subscriptions.helper.EncriptHelper;
import io.Subscriptions.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;


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
