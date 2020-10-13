package io.Subscriptions.client.api;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.Subscriptions.client.ApiCallback;
import io.Subscriptions.client.ApiClient;
import io.Subscriptions.client.ApiException;
import io.Subscriptions.client.ApiResponse;
import io.Subscriptions.client.Configuration;
import io.Subscriptions.client.Pair;
import io.Subscriptions.client.ProgressRequestBody;
import io.Subscriptions.client.ProgressResponseBody;
import io.Subscriptions.client.model.Subscription;
import io.Subscriptions.client.model.SubscriptionAcknowledge;
import io.Subscriptions.client.model.SubscriptionsMetadata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebHookSubscriptionsApi {
    private ApiClient apiClient;
    public WebHookSubscriptionsApi() {
        this(Configuration.getDefaultApiClient());
    }
    public WebHookSubscriptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call deleteSubscriptionCall(String xApiKey, String username, String password,  String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/v1/subscriptions/{subscriptionId}"
            .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteSubscriptionValidateBeforeCall(String xApiKey, String username, String password,  String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling deleteSubscription(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling deleteSubscription(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling deleteSubscription(Async)");
        }
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling deleteSubscription(Async)");
        }
        
        okhttp3.Call call = deleteSubscriptionCall(xApiKey, username, password,  subscriptionId, progressListener, progressRequestListener);
        return call;
    }
    
    public SubscriptionAcknowledge deleteSubscription(String xApiKey, String username, String password, String subscriptionId) throws ApiException {
        ApiResponse<SubscriptionAcknowledge> resp = deleteSubscriptionWithHttpInfo(xApiKey, username, password,  subscriptionId);
        return resp.getData();
    }
    
    public ApiResponse<SubscriptionAcknowledge> deleteSubscriptionWithHttpInfo(String xApiKey, String username, String password,  String subscriptionId) throws ApiException {
        okhttp3.Call call = deleteSubscriptionValidateBeforeCall(xApiKey, username, password,  subscriptionId, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call deleteSubscriptionAsync(String xApiKey, String username, String password, String xSignature, String subscriptionId, final ApiCallback<SubscriptionAcknowledge> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = deleteSubscriptionValidateBeforeCall(xApiKey, username, password, subscriptionId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
    
    public okhttp3.Call getSubscriptionCall(String xApiKey, String username, String password,  String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/v1/subscriptions/{subscriptionId}"
            .replaceAll("\\{" + "subscriptionId" + "\\}", apiClient.escapeString(subscriptionId.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSubscriptionValidateBeforeCall(String xApiKey, String username, String password, String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getSubscription(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling getSubscription(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling getSubscription(Async)");
        }
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling getSubscription(Async)");
        }
        
        okhttp3.Call call = getSubscriptionCall(xApiKey, username, password,  subscriptionId, progressListener, progressRequestListener);
        return call;
    }
    
    public Subscription getSubscription(String xApiKey, String username, String password, String subscriptionId) throws ApiException {
        ApiResponse<Subscription> resp = getSubscriptionWithHttpInfo(xApiKey, username, password, subscriptionId);
        return resp.getData();
    }
    
    public ApiResponse<Subscription> getSubscriptionWithHttpInfo(String xApiKey, String username, String password, String subscriptionId) throws ApiException {
        okhttp3.Call call = getSubscriptionValidateBeforeCall(xApiKey, username, password,  subscriptionId, null, null);
        Type localVarReturnType = new TypeToken<Subscription>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getSubscriptionAsync(String xApiKey, String username, String password, String xSignature, String subscriptionId, final ApiCallback<Subscription> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = getSubscriptionValidateBeforeCall(xApiKey, username, password, subscriptionId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Subscription>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
    
    public okhttp3.Call getSubscriptionsCall(String xApiKey, String username, String password,  String page, String perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/v1/subscriptions";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (perPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSubscriptionsValidateBeforeCall(String xApiKey, String username, String password,  String page, String perPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getSubscriptions(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling getSubscriptions(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling getSubscriptions(Async)");
        }
        
        okhttp3.Call call = getSubscriptionsCall(xApiKey, username, password, page, perPage, progressListener, progressRequestListener);
        return call;
    }
    
    public SubscriptionsMetadata getSubscriptions(String xApiKey, String username, String password,  String page, String perPage) throws ApiException {
        ApiResponse<SubscriptionsMetadata> resp = getSubscriptionsWithHttpInfo(xApiKey, username, password, page, perPage);
        return resp.getData();
    }
    
    public ApiResponse<SubscriptionsMetadata> getSubscriptionsWithHttpInfo(String xApiKey, String username, String password,  String page, String perPage) throws ApiException {
        okhttp3.Call call = getSubscriptionsValidateBeforeCall(xApiKey, username, password, page, perPage, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionsMetadata>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getSubscriptionsAsync(String xApiKey, String username, String password, String xSignature, String page, String perPage, final ApiCallback<SubscriptionsMetadata> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = getSubscriptionsValidateBeforeCall(xApiKey, username, password,  page, perPage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionsMetadata>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
    
    public okhttp3.Call postSubscriptionCall(String xApiKey, String username, String password,  Subscription enrollment, String xWebhookJwtAuth, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = enrollment;
        String localVarPath = "/v1/subscriptions";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));

        
        if (xWebhookJwtAuth != null)
        localVarHeaderParams.put("x-webhook-jwt-auth", apiClient.parameterToString(xWebhookJwtAuth));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call postSubscriptionValidateBeforeCall(String xApiKey, String username, String password,  Subscription enrollment, String xWebhookJwtAuth, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling postSubscription(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling postSubscription(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling postSubscription(Async)");
        }
        if (enrollment == null) {
            throw new ApiException("Missing the required parameter 'enrollment' when calling postSubscription(Async)");
        }
        if (xWebhookJwtAuth == null) {
            throw new ApiException("Missing the required parameter 'xWebhookJwtAuth' when calling postSubscription(Async)");
        }
        
        okhttp3.Call call = postSubscriptionCall(xApiKey, username, password,  enrollment, xWebhookJwtAuth, progressListener, progressRequestListener);
        return call;
    }
    
    public SubscriptionAcknowledge postSubscription(String xApiKey, String username, String password,  Subscription enrollment, String xWebhookJwtAuth) throws ApiException {
        ApiResponse<SubscriptionAcknowledge> resp = postSubscriptionWithHttpInfo(xApiKey, username, password, enrollment, xWebhookJwtAuth);
        return resp.getData();
    }
    
    public ApiResponse<SubscriptionAcknowledge> postSubscriptionWithHttpInfo(String xApiKey, String username, String password,  Subscription enrollment, String xWebhookJwtAuth) throws ApiException {
        okhttp3.Call call = postSubscriptionValidateBeforeCall(xApiKey, username, password,  enrollment, xWebhookJwtAuth, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call postSubscriptionAsync(String xApiKey, String username, String password,  Subscription enrollment, String xWebhookJwtAuth, final ApiCallback<SubscriptionAcknowledge> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = postSubscriptionValidateBeforeCall(xApiKey, username, password, enrollment, xWebhookJwtAuth, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionAcknowledge>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
