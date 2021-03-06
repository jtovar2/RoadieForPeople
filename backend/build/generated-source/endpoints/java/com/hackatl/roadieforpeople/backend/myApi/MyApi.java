/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-10-17 at 21:32:42 UTC 
 * Modify at your own risk.
 */

package com.hackatl.roadieforpeople.backend.myApi;

/**
 * Service definition for MyApi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MyApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class MyApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.20.0 of the myApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "myApi/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public MyApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  MyApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the MyEndpoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code MyApi myApi = new MyApi(...);}
   *   {@code MyApi.MyEndpoint.List request = myApi.myEndpoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public MyEndpoint myEndpoint() {
    return new MyEndpoint();
  }

  /**
   * The "myEndpoint" collection of methods.
   */
  public class MyEndpoint {

    /**
     * Create a request for the method "myEndpoint.deleteRoute".
     *
     * This request holds the parameters needed by the myApi server.  After setting any optional
     * parameters, call the {@link DeleteRoute#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     */
    public DeleteRoute deleteRoute(java.lang.Long id) throws java.io.IOException {
      DeleteRoute result = new DeleteRoute(id);
      initialize(result);
      return result;
    }

    public class DeleteRoute extends MyApiRequest<Void> {

      private static final String REST_PATH = "route/{id}";

      /**
       * Create a request for the method "myEndpoint.deleteRoute".
       *
       * This request holds the parameters needed by the the myApi server.  After setting any optional
       * parameters, call the {@link DeleteRoute#execute()} method to invoke the remote operation. <p>
       * {@link
       * DeleteRoute#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @since 1.13
       */
      protected DeleteRoute(java.lang.Long id) {
        super(MyApi.this, "DELETE", REST_PATH, null, Void.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      @Override
      public DeleteRoute setAlt(java.lang.String alt) {
        return (DeleteRoute) super.setAlt(alt);
      }

      @Override
      public DeleteRoute setFields(java.lang.String fields) {
        return (DeleteRoute) super.setFields(fields);
      }

      @Override
      public DeleteRoute setKey(java.lang.String key) {
        return (DeleteRoute) super.setKey(key);
      }

      @Override
      public DeleteRoute setOauthToken(java.lang.String oauthToken) {
        return (DeleteRoute) super.setOauthToken(oauthToken);
      }

      @Override
      public DeleteRoute setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (DeleteRoute) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public DeleteRoute setQuotaUser(java.lang.String quotaUser) {
        return (DeleteRoute) super.setQuotaUser(quotaUser);
      }

      @Override
      public DeleteRoute setUserIp(java.lang.String userIp) {
        return (DeleteRoute) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.Long id;

      /**

       */
      public java.lang.Long getId() {
        return id;
      }

      public DeleteRoute setId(java.lang.Long id) {
        this.id = id;
        return this;
      }

      @Override
      public DeleteRoute set(String parameterName, Object value) {
        return (DeleteRoute) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "myEndpoint.getRoute".
     *
     * This request holds the parameters needed by the myApi server.  After setting any optional
     * parameters, call the {@link GetRoute#execute()} method to invoke the remote operation.
     *
     * @param id
     * @return the request
     */
    public GetRoute getRoute(java.lang.Long id) throws java.io.IOException {
      GetRoute result = new GetRoute(id);
      initialize(result);
      return result;
    }

    public class GetRoute extends MyApiRequest<com.hackatl.roadieforpeople.backend.myApi.model.Route> {

      private static final String REST_PATH = "route/{id}";

      /**
       * Create a request for the method "myEndpoint.getRoute".
       *
       * This request holds the parameters needed by the the myApi server.  After setting any optional
       * parameters, call the {@link GetRoute#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetRoute#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param id
       * @since 1.13
       */
      protected GetRoute(java.lang.Long id) {
        super(MyApi.this, "GET", REST_PATH, null, com.hackatl.roadieforpeople.backend.myApi.model.Route.class);
        this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetRoute setAlt(java.lang.String alt) {
        return (GetRoute) super.setAlt(alt);
      }

      @Override
      public GetRoute setFields(java.lang.String fields) {
        return (GetRoute) super.setFields(fields);
      }

      @Override
      public GetRoute setKey(java.lang.String key) {
        return (GetRoute) super.setKey(key);
      }

      @Override
      public GetRoute setOauthToken(java.lang.String oauthToken) {
        return (GetRoute) super.setOauthToken(oauthToken);
      }

      @Override
      public GetRoute setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetRoute) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetRoute setQuotaUser(java.lang.String quotaUser) {
        return (GetRoute) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetRoute setUserIp(java.lang.String userIp) {
        return (GetRoute) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.Long id;

      /**

       */
      public java.lang.Long getId() {
        return id;
      }

      public GetRoute setId(java.lang.Long id) {
        this.id = id;
        return this;
      }

      @Override
      public GetRoute set(String parameterName, Object value) {
        return (GetRoute) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "myEndpoint.getRoutes".
     *
     * This request holds the parameters needed by the myApi server.  After setting any optional
     * parameters, call the {@link GetRoutes#execute()} method to invoke the remote operation.
     *
     * @param startLocation
     * @return the request
     */
    public GetRoutes getRoutes(java.lang.String startLocation) throws java.io.IOException {
      GetRoutes result = new GetRoutes(startLocation);
      initialize(result);
      return result;
    }

    public class GetRoutes extends MyApiRequest<com.hackatl.roadieforpeople.backend.myApi.model.RouteCollection> {

      private static final String REST_PATH = "routecollection/{startLocation}";

      /**
       * Create a request for the method "myEndpoint.getRoutes".
       *
       * This request holds the parameters needed by the the myApi server.  After setting any optional
       * parameters, call the {@link GetRoutes#execute()} method to invoke the remote operation. <p>
       * {@link
       * GetRoutes#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param startLocation
       * @since 1.13
       */
      protected GetRoutes(java.lang.String startLocation) {
        super(MyApi.this, "GET", REST_PATH, null, com.hackatl.roadieforpeople.backend.myApi.model.RouteCollection.class);
        this.startLocation = com.google.api.client.util.Preconditions.checkNotNull(startLocation, "Required parameter startLocation must be specified.");
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetRoutes setAlt(java.lang.String alt) {
        return (GetRoutes) super.setAlt(alt);
      }

      @Override
      public GetRoutes setFields(java.lang.String fields) {
        return (GetRoutes) super.setFields(fields);
      }

      @Override
      public GetRoutes setKey(java.lang.String key) {
        return (GetRoutes) super.setKey(key);
      }

      @Override
      public GetRoutes setOauthToken(java.lang.String oauthToken) {
        return (GetRoutes) super.setOauthToken(oauthToken);
      }

      @Override
      public GetRoutes setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetRoutes) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetRoutes setQuotaUser(java.lang.String quotaUser) {
        return (GetRoutes) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetRoutes setUserIp(java.lang.String userIp) {
        return (GetRoutes) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String startLocation;

      /**

       */
      public java.lang.String getStartLocation() {
        return startLocation;
      }

      public GetRoutes setStartLocation(java.lang.String startLocation) {
        this.startLocation = startLocation;
        return this;
      }

      @Override
      public GetRoutes set(String parameterName, Object value) {
        return (GetRoutes) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "myEndpoint.placeRoute".
     *
     * This request holds the parameters needed by the myApi server.  After setting any optional
     * parameters, call the {@link PlaceRoute#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.hackatl.roadieforpeople.backend.myApi.model.Route}
     * @return the request
     */
    public PlaceRoute placeRoute(com.hackatl.roadieforpeople.backend.myApi.model.Route content) throws java.io.IOException {
      PlaceRoute result = new PlaceRoute(content);
      initialize(result);
      return result;
    }

    public class PlaceRoute extends MyApiRequest<Void> {

      private static final String REST_PATH = "placeRoute";

      /**
       * Create a request for the method "myEndpoint.placeRoute".
       *
       * This request holds the parameters needed by the the myApi server.  After setting any optional
       * parameters, call the {@link PlaceRoute#execute()} method to invoke the remote operation. <p>
       * {@link
       * PlaceRoute#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.hackatl.roadieforpeople.backend.myApi.model.Route}
       * @since 1.13
       */
      protected PlaceRoute(com.hackatl.roadieforpeople.backend.myApi.model.Route content) {
        super(MyApi.this, "POST", REST_PATH, content, Void.class);
      }

      @Override
      public PlaceRoute setAlt(java.lang.String alt) {
        return (PlaceRoute) super.setAlt(alt);
      }

      @Override
      public PlaceRoute setFields(java.lang.String fields) {
        return (PlaceRoute) super.setFields(fields);
      }

      @Override
      public PlaceRoute setKey(java.lang.String key) {
        return (PlaceRoute) super.setKey(key);
      }

      @Override
      public PlaceRoute setOauthToken(java.lang.String oauthToken) {
        return (PlaceRoute) super.setOauthToken(oauthToken);
      }

      @Override
      public PlaceRoute setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (PlaceRoute) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public PlaceRoute setQuotaUser(java.lang.String quotaUser) {
        return (PlaceRoute) super.setQuotaUser(quotaUser);
      }

      @Override
      public PlaceRoute setUserIp(java.lang.String userIp) {
        return (PlaceRoute) super.setUserIp(userIp);
      }

      @Override
      public PlaceRoute set(String parameterName, Object value) {
        return (PlaceRoute) super.set(parameterName, value);
      }
    }

  }

  /**
   * Create a request for the method "sayHi".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link SayHi#execute()} method to invoke the remote operation.
   *
   * @param name
   * @return the request
   */
  public SayHi sayHi(java.lang.String name) throws java.io.IOException {
    SayHi result = new SayHi(name);
    initialize(result);
    return result;
  }

  public class SayHi extends MyApiRequest<com.hackatl.roadieforpeople.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "sayHi/{name}";

    /**
     * Create a request for the method "sayHi".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link SayHi#execute()} method to invoke the remote operation. <p> {@link
     * SayHi#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param name
     * @since 1.13
     */
    protected SayHi(java.lang.String name) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackatl.roadieforpeople.backend.myApi.model.MyBean.class);
      this.name = com.google.api.client.util.Preconditions.checkNotNull(name, "Required parameter name must be specified.");
    }

    @Override
    public SayHi setAlt(java.lang.String alt) {
      return (SayHi) super.setAlt(alt);
    }

    @Override
    public SayHi setFields(java.lang.String fields) {
      return (SayHi) super.setFields(fields);
    }

    @Override
    public SayHi setKey(java.lang.String key) {
      return (SayHi) super.setKey(key);
    }

    @Override
    public SayHi setOauthToken(java.lang.String oauthToken) {
      return (SayHi) super.setOauthToken(oauthToken);
    }

    @Override
    public SayHi setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SayHi) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SayHi setQuotaUser(java.lang.String quotaUser) {
      return (SayHi) super.setQuotaUser(quotaUser);
    }

    @Override
    public SayHi setUserIp(java.lang.String userIp) {
      return (SayHi) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String name;

    /**

     */
    public java.lang.String getName() {
      return name;
    }

    public SayHi setName(java.lang.String name) {
      this.name = name;
      return this;
    }

    @Override
    public SayHi set(String parameterName, Object value) {
      return (SayHi) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link MyApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link MyApi}. */
    @Override
    public MyApi build() {
      return new MyApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link MyApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMyApiRequestInitializer(
        MyApiRequestInitializer myapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(myapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
