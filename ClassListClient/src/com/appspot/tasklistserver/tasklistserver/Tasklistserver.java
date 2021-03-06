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
 * (build: 2013-11-22 19:59:01 UTC)
 * on 2013-12-05 at 09:49:35 UTC 
 * Modify at your own risk.
 */

package com.appspot.tasklistserver.tasklistserver;

/**
 * Service definition for Tasklistserver (v1).
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
 * This service uses {@link TasklistserverRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Tasklistserver extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the tasklistserver library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://tasklistserver.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "tasklistserver/v1/";

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
  public Tasklistserver(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Tasklistserver(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "addtask".
   *
   * This request holds the parameters needed by the the tasklistserver server.  After setting any
   * optional parameters, call the {@link Addtask#execute()} method to invoke the remote operation.
   *
   * @param name
   * @param time
   * @param lat
   * @param lon
   * @return the request
   */
  public Addtask addtask(java.lang.String name, java.lang.String time, java.lang.Integer lat, java.lang.Integer lon) throws java.io.IOException {
    Addtask result = new Addtask(name, time, lat, lon);
    initialize(result);
    return result;
  }

  public class Addtask extends TasklistserverRequest<com.appspot.tasklistserver.tasklistserver.model.Task> {

    private static final String REST_PATH = "addTask/{name}/{time}/{lat}/{lon}";

    /**
     * Create a request for the method "addtask".
     *
     * This request holds the parameters needed by the the tasklistserver server.  After setting any
     * optional parameters, call the {@link Addtask#execute()} method to invoke the remote operation.
     * <p> {@link
     * Addtask#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param name
     * @param time
     * @param lat
     * @param lon
     * @since 1.13
     */
    protected Addtask(java.lang.String name, java.lang.String time, java.lang.Integer lat, java.lang.Integer lon) {
      super(Tasklistserver.this, "POST", REST_PATH, null, com.appspot.tasklistserver.tasklistserver.model.Task.class);
      this.name = com.google.api.client.util.Preconditions.checkNotNull(name, "Required parameter name must be specified.");
      this.time = com.google.api.client.util.Preconditions.checkNotNull(time, "Required parameter time must be specified.");
      this.lat = com.google.api.client.util.Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
      this.lon = com.google.api.client.util.Preconditions.checkNotNull(lon, "Required parameter lon must be specified.");
    }

    @Override
    public Addtask setAlt(java.lang.String alt) {
      return (Addtask) super.setAlt(alt);
    }

    @Override
    public Addtask setFields(java.lang.String fields) {
      return (Addtask) super.setFields(fields);
    }

    @Override
    public Addtask setKey(java.lang.String key) {
      return (Addtask) super.setKey(key);
    }

    @Override
    public Addtask setOauthToken(java.lang.String oauthToken) {
      return (Addtask) super.setOauthToken(oauthToken);
    }

    @Override
    public Addtask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Addtask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Addtask setQuotaUser(java.lang.String quotaUser) {
      return (Addtask) super.setQuotaUser(quotaUser);
    }

    @Override
    public Addtask setUserIp(java.lang.String userIp) {
      return (Addtask) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String name;

    /**

     */
    public java.lang.String getName() {
      return name;
    }

    public Addtask setName(java.lang.String name) {
      this.name = name;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String time;

    /**

     */
    public java.lang.String getTime() {
      return time;
    }

    public Addtask setTime(java.lang.String time) {
      this.time = time;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer lat;

    /**

     */
    public java.lang.Integer getLat() {
      return lat;
    }

    public Addtask setLat(java.lang.Integer lat) {
      this.lat = lat;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer lon;

    /**

     */
    public java.lang.Integer getLon() {
      return lon;
    }

    public Addtask setLon(java.lang.Integer lon) {
      this.lon = lon;
      return this;
    }

    @Override
    public Addtask set(String parameterName, Object value) {
      return (Addtask) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "assigntask".
   *
   * This request holds the parameters needed by the the tasklistserver server.  After setting any
   * optional parameters, call the {@link Assigntask#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public Assigntask assigntask(java.lang.Integer id) throws java.io.IOException {
    Assigntask result = new Assigntask(id);
    initialize(result);
    return result;
  }

  public class Assigntask extends TasklistserverRequest<com.appspot.tasklistserver.tasklistserver.model.Task> {

    private static final String REST_PATH = "assignTask/{user}/{id}";

    /**
     * Create a request for the method "assigntask".
     *
     * This request holds the parameters needed by the the tasklistserver server.  After setting any
     * optional parameters, call the {@link Assigntask#execute()} method to invoke the remote
     * operation. <p> {@link
     * Assigntask#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected Assigntask(java.lang.Integer id) {
      super(Tasklistserver.this, "POST", REST_PATH, null, com.appspot.tasklistserver.tasklistserver.model.Task.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public Assigntask setAlt(java.lang.String alt) {
      return (Assigntask) super.setAlt(alt);
    }

    @Override
    public Assigntask setFields(java.lang.String fields) {
      return (Assigntask) super.setFields(fields);
    }

    @Override
    public Assigntask setKey(java.lang.String key) {
      return (Assigntask) super.setKey(key);
    }

    @Override
    public Assigntask setOauthToken(java.lang.String oauthToken) {
      return (Assigntask) super.setOauthToken(oauthToken);
    }

    @Override
    public Assigntask setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Assigntask) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Assigntask setQuotaUser(java.lang.String quotaUser) {
      return (Assigntask) super.setQuotaUser(quotaUser);
    }

    @Override
    public Assigntask setUserIp(java.lang.String userIp) {
      return (Assigntask) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer id;

    /**

     */
    public java.lang.Integer getId() {
      return id;
    }

    public Assigntask setId(java.lang.Integer id) {
      this.id = id;
      return this;
    }

    @Override
    public Assigntask set(String parameterName, Object value) {
      return (Assigntask) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "gettasks".
   *
   * This request holds the parameters needed by the the tasklistserver server.  After setting any
   * optional parameters, call the {@link Gettasks#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public Gettasks gettasks() throws java.io.IOException {
    Gettasks result = new Gettasks();
    initialize(result);
    return result;
  }

  public class Gettasks extends TasklistserverRequest<com.appspot.tasklistserver.tasklistserver.model.JsonMap> {

    private static final String REST_PATH = "map_integer_task";

    /**
     * Create a request for the method "gettasks".
     *
     * This request holds the parameters needed by the the tasklistserver server.  After setting any
     * optional parameters, call the {@link Gettasks#execute()} method to invoke the remote operation.
     * <p> {@link
     * Gettasks#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected Gettasks() {
      super(Tasklistserver.this, "GET", REST_PATH, null, com.appspot.tasklistserver.tasklistserver.model.JsonMap.class);
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
    public Gettasks setAlt(java.lang.String alt) {
      return (Gettasks) super.setAlt(alt);
    }

    @Override
    public Gettasks setFields(java.lang.String fields) {
      return (Gettasks) super.setFields(fields);
    }

    @Override
    public Gettasks setKey(java.lang.String key) {
      return (Gettasks) super.setKey(key);
    }

    @Override
    public Gettasks setOauthToken(java.lang.String oauthToken) {
      return (Gettasks) super.setOauthToken(oauthToken);
    }

    @Override
    public Gettasks setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Gettasks) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Gettasks setQuotaUser(java.lang.String quotaUser) {
      return (Gettasks) super.setQuotaUser(quotaUser);
    }

    @Override
    public Gettasks setUserIp(java.lang.String userIp) {
      return (Gettasks) super.setUserIp(userIp);
    }

    @Override
    public Gettasks set(String parameterName, Object value) {
      return (Gettasks) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Tasklistserver}.
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

    /** Builds a new instance of {@link Tasklistserver}. */
    @Override
    public Tasklistserver build() {
      return new Tasklistserver(this);
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
     * Set the {@link TasklistserverRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTasklistserverRequestInitializer(
        TasklistserverRequestInitializer tasklistserverRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(tasklistserverRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
