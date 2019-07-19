package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.model.GraphUser;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.Builder;
import com.facebook.widget.WebDialog.OnCompleteListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationClient
  implements Parcelable
{
  public static final Parcelable.Creator<AuthorizationClient> CREATOR = new Parcelable.Creator()
  {
    public AuthorizationClient createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AuthorizationClient(paramAnonymousParcel);
    }

    public AuthorizationClient[] newArray(int paramAnonymousInt)
    {
      return new AuthorizationClient[paramAnonymousInt];
    }
  };
  static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
  static final String EVENT_EXTRAS_IS_LEGACY = "is_legacy";
  static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
  static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
  static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
  static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
  static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
  static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
  static final String EVENT_EXTRAS_TRY_LEGACY = "try_legacy";
  static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
  static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
  private static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
  private static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
  static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
  static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
  static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
  static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
  static final String EVENT_PARAM_EXTRAS = "6_extras";
  static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
  static final String EVENT_PARAM_METHOD = "3_method";
  private static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
  static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
  private static final String TAG = "Facebook-AuthorizationClient";
  private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
  private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
  private transient AppEventsLogger appEventsLogger;
  transient BackgroundProcessingListener backgroundProcessingListener;
  transient boolean checkedInternetPermission;
  transient Context context;
  AuthHandler currentHandler;
  List<AuthHandler> handlersToTry;
  Map<String, String> loggingExtras;
  transient OnCompletedListener onCompletedListener;
  AuthorizationRequest pendingRequest;
  transient StartActivityDelegate startActivityDelegate;

  public AuthorizationClient()
  {
  }

  AuthorizationClient(Parcel paramParcel)
  {
    ClassLoader localClassLoader = AuthorizationClient.class.getClassLoader();
    int i = paramParcel.readInt();
    if (i != -1)
    {
      this.handlersToTry = new ArrayList();
      for (int j = 0; j < i; j++)
      {
        AuthHandler localAuthHandler = (AuthHandler)paramParcel.readParcelable(localClassLoader);
        localAuthHandler.setAuthorizationClient(this);
        this.handlersToTry.add(localAuthHandler);
      }
    }
    this.currentHandler = ((AuthHandler)paramParcel.readParcelable(localClassLoader));
    if (this.currentHandler != null)
      this.currentHandler.setAuthorizationClient(this);
    this.pendingRequest = ((AuthorizationRequest)paramParcel.readParcelable(localClassLoader));
    if (paramParcel.readInt() != -1)
    {
      this.loggingExtras = new HashMap();
      paramParcel.readMap(this.loggingExtras, localClassLoader);
    }
  }

  private void addLoggingExtra(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.loggingExtras == null)
      this.loggingExtras = new HashMap();
    if ((this.loggingExtras.containsKey(paramString1)) && (paramBoolean))
      paramString2 = (String)this.loggingExtras.get(paramString1) + "," + paramString2;
    this.loggingExtras.put(paramString1, paramString2);
  }

  private void completeWithFailure()
  {
    complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
  }

  private AppEventsLogger getAppEventsLogger()
  {
    if ((this.appEventsLogger == null) || (!this.appEventsLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())))
      this.appEventsLogger = AppEventsLogger.newLogger(this.context, this.pendingRequest.getApplicationId());
    return this.appEventsLogger;
  }

  private static String getE2E()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("init", System.currentTimeMillis());
      label18: return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label18;
    }
  }

  private List<AuthHandler> getHandlerTypes(AuthorizationRequest paramAuthorizationRequest)
  {
    ArrayList localArrayList = new ArrayList();
    SessionLoginBehavior localSessionLoginBehavior = paramAuthorizationRequest.getLoginBehavior();
    if (localSessionLoginBehavior.allowsKatanaAuth())
    {
      if (!paramAuthorizationRequest.isLegacy())
        localArrayList.add(new GetTokenAuthHandler(this));
      localArrayList.add(new KatanaProxyAuthHandler(this));
    }
    if (localSessionLoginBehavior.allowsWebViewAuth())
      localArrayList.add(new WebViewAuthHandler(this));
    return localArrayList;
  }

  private void logAuthorizationMethodComplete(String paramString, Result paramResult, Map<String, String> paramMap)
  {
    logAuthorizationMethodComplete(paramString, paramResult.code.getLoggingValue(), paramResult.errorMessage, paramResult.errorCode, paramMap);
  }

  private void logAuthorizationMethodComplete(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    Bundle localBundle;
    if (this.pendingRequest == null)
    {
      localBundle = newAuthorizationLoggingBundle("");
      localBundle.putString("2_result", AuthorizationClient.Result.Code.ERROR.getLoggingValue());
      localBundle.putString("5_error_message", "Unexpected call to logAuthorizationMethodComplete with null pendingRequest.");
    }
    while (true)
    {
      localBundle.putString("3_method", paramString1);
      localBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
      getAppEventsLogger().logSdkEvent("fb_mobile_login_method_complete", null, localBundle);
      return;
      localBundle = newAuthorizationLoggingBundle(this.pendingRequest.getAuthId());
      if (paramString2 != null)
        localBundle.putString("2_result", paramString2);
      if (paramString3 != null)
        localBundle.putString("5_error_message", paramString3);
      if (paramString4 != null)
        localBundle.putString("4_error_code", paramString4);
      if ((paramMap != null) && (!paramMap.isEmpty()))
        localBundle.putString("6_extras", new JSONObject(paramMap).toString());
    }
  }

  private void logAuthorizationMethodStart(String paramString)
  {
    Bundle localBundle = newAuthorizationLoggingBundle(this.pendingRequest.getAuthId());
    localBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
    localBundle.putString("3_method", paramString);
    getAppEventsLogger().logSdkEvent("fb_mobile_login_method_start", null, localBundle);
  }

  private void logWebLoginCompleted(String paramString1, String paramString2)
  {
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(this.context, paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_web_login_e2e", paramString2);
    localBundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
    localBundle.putString("app_id", paramString1);
    localAppEventsLogger.logSdkEvent("fb_dialogs_web_login_dialog_complete", null, localBundle);
  }

  static Bundle newAuthorizationLoggingBundle(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("1_timestamp_ms", System.currentTimeMillis());
    localBundle.putString("0_auth_logger_id", paramString);
    localBundle.putString("3_method", "");
    localBundle.putString("2_result", "");
    localBundle.putString("5_error_message", "");
    localBundle.putString("4_error_code", "");
    localBundle.putString("6_extras", "");
    return localBundle;
  }

  private void notifyBackgroundProcessingStart()
  {
    if (this.backgroundProcessingListener != null)
      this.backgroundProcessingListener.onBackgroundProcessingStarted();
  }

  private void notifyBackgroundProcessingStop()
  {
    if (this.backgroundProcessingListener != null)
      this.backgroundProcessingListener.onBackgroundProcessingStopped();
  }

  private void notifyOnCompleteListener(Result paramResult)
  {
    if (this.onCompletedListener != null)
      this.onCompletedListener.onCompleted(paramResult);
  }

  void authorize(AuthorizationRequest paramAuthorizationRequest)
  {
    if (paramAuthorizationRequest == null);
    do
    {
      return;
      if (this.pendingRequest != null)
        throw new FacebookException("Attempted to authorize while a request is pending.");
    }
    while ((paramAuthorizationRequest.needsNewTokenValidation()) && (!checkInternetPermission()));
    this.pendingRequest = paramAuthorizationRequest;
    this.handlersToTry = getHandlerTypes(paramAuthorizationRequest);
    tryNextHandler();
  }

  public void cancelCurrentHandler()
  {
    if (this.currentHandler != null)
      this.currentHandler.cancel();
  }

  boolean checkInternetPermission()
  {
    if (this.checkedInternetPermission)
      return true;
    this.checkedInternetPermission = true;
    return true;
  }

  int checkPermission(String paramString)
  {
    return this.context.checkCallingOrSelfPermission(paramString);
  }

  void complete(Result paramResult)
  {
    if (this.currentHandler != null)
      logAuthorizationMethodComplete(this.currentHandler.getNameForLogging(), paramResult, this.currentHandler.methodLoggingExtras);
    if (this.loggingExtras != null)
      paramResult.loggingExtras = this.loggingExtras;
    this.handlersToTry = null;
    this.currentHandler = null;
    this.pendingRequest = null;
    this.loggingExtras = null;
    notifyOnCompleteListener(paramResult);
  }

  void completeAndValidate(Result paramResult)
  {
    if ((paramResult.token != null) && (this.pendingRequest.needsNewTokenValidation()))
    {
      validateSameFbidAndFinish(paramResult);
      return;
    }
    complete(paramResult);
  }

  void continueAuth()
  {
    if ((this.pendingRequest == null) || (this.currentHandler == null))
      throw new FacebookException("Attempted to continue authorization without a pending request.");
    if (this.currentHandler.needsRestart())
    {
      this.currentHandler.cancel();
      tryCurrentHandler();
    }
  }

  Request createGetPermissionsRequest(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", paramString);
    return new Request(null, "me/permissions", localBundle, HttpMethod.GET, null);
  }

  Request createGetProfileIdRequest(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", "id");
    localBundle.putString("access_token", paramString);
    return new Request(null, "me", localBundle, HttpMethod.GET, null);
  }

  RequestBatch createReauthValidationBatch(final Result paramResult)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    final ArrayList localArrayList3 = new ArrayList();
    String str1 = paramResult.token.getToken();
    Request.Callback local4 = new Request.Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        try
        {
          GraphUser localGraphUser = (GraphUser)paramAnonymousResponse.getGraphObjectAs(GraphUser.class);
          if (localGraphUser != null)
            localArrayList1.add(localGraphUser.getId());
          return;
        }
        catch (Exception localException)
        {
        }
      }
    };
    String str2 = this.pendingRequest.getPreviousAccessToken();
    Request localRequest1 = createGetProfileIdRequest(str2);
    localRequest1.setCallback(local4);
    Request localRequest2 = createGetProfileIdRequest(str1);
    localRequest2.setCallback(local4);
    Request localRequest3 = createGetPermissionsRequest(str2);
    localRequest3.setCallback(new Request.Callback()
    {
      public void onCompleted(Response paramAnonymousResponse)
      {
        try
        {
          Session.PermissionsPair localPermissionsPair = Session.handlePermissionResponse(paramAnonymousResponse);
          if (localPermissionsPair != null)
          {
            localArrayList2.addAll(localPermissionsPair.getGrantedPermissions());
            localArrayList3.addAll(localPermissionsPair.getDeclinedPermissions());
          }
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
    RequestBatch localRequestBatch = new RequestBatch(new Request[] { localRequest1, localRequest2, localRequest3 });
    localRequestBatch.setBatchApplicationId(this.pendingRequest.getApplicationId());
    localRequestBatch.addCallback(new RequestBatch.Callback()
    {
      public void onBatchCompleted(RequestBatch paramAnonymousRequestBatch)
      {
        try
        {
          AccessToken localAccessToken;
          if ((localArrayList1.size() == 2) && (localArrayList1.get(0) != null) && (localArrayList1.get(1) != null) && (((String)localArrayList1.get(0)).equals(localArrayList1.get(1))))
            localAccessToken = AccessToken.createFromTokenWithRefreshedPermissions(paramResult.token, localArrayList2, localArrayList3);
          AuthorizationClient.Result localResult;
          for (Object localObject2 = AuthorizationClient.Result.createTokenResult(AuthorizationClient.this.pendingRequest, localAccessToken); ; localObject2 = localResult)
          {
            AuthorizationClient.this.complete((AuthorizationClient.Result)localObject2);
            return;
            localResult = AuthorizationClient.Result.createErrorResult(AuthorizationClient.this.pendingRequest, "User logged in as different Facebook user.", null);
          }
        }
        catch (Exception localException)
        {
          AuthorizationClient.this.complete(AuthorizationClient.Result.createErrorResult(AuthorizationClient.this.pendingRequest, "Caught exception", localException.getMessage()));
          return;
        }
        finally
        {
          AuthorizationClient.this.notifyBackgroundProcessingStop();
        }
      }
    });
    return localRequestBatch;
  }

  public int describeContents()
  {
    return 0;
  }

  BackgroundProcessingListener getBackgroundProcessingListener()
  {
    return this.backgroundProcessingListener;
  }

  boolean getInProgress()
  {
    return (this.pendingRequest != null) && (this.currentHandler != null);
  }

  OnCompletedListener getOnCompletedListener()
  {
    return this.onCompletedListener;
  }

  StartActivityDelegate getStartActivityDelegate()
  {
    if (this.startActivityDelegate != null)
      return this.startActivityDelegate;
    if (this.pendingRequest != null)
      return new StartActivityDelegate()
      {
        public Activity getActivityContext()
        {
          return AuthorizationClient.this.pendingRequest.getStartActivityDelegate().getActivityContext();
        }

        public void startActivityForResult(Intent paramAnonymousIntent, int paramAnonymousInt)
        {
          AuthorizationClient.this.pendingRequest.getStartActivityDelegate().startActivityForResult(paramAnonymousIntent, paramAnonymousInt);
        }
      };
    return null;
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == this.pendingRequest.getRequestCode())
      return this.currentHandler.onActivityResult(paramInt1, paramInt2, paramBundle);
    return false;
  }

  public void setBackgroundProcessingListener(BackgroundProcessingListener paramBackgroundProcessingListener)
  {
    this.backgroundProcessingListener = paramBackgroundProcessingListener;
  }

  public void setContext(final Activity paramActivity)
  {
    this.context = paramActivity;
    this.startActivityDelegate = new StartActivityDelegate()
    {
      public Activity getActivityContext()
      {
        return paramActivity;
      }

      public void startActivityForResult(Intent paramAnonymousIntent, int paramAnonymousInt)
      {
        paramActivity.startActivityForResult(paramAnonymousIntent, paramAnonymousInt);
      }
    };
  }

  public void setContext(Context paramContext)
  {
    this.context = paramContext;
    this.startActivityDelegate = null;
  }

  public void setOnCompletedListener(OnCompletedListener paramOnCompletedListener)
  {
    this.onCompletedListener = paramOnCompletedListener;
  }

  public void startOrContinueAuth(AuthorizationRequest paramAuthorizationRequest)
  {
    if (getInProgress())
    {
      continueAuth();
      return;
    }
    authorize(paramAuthorizationRequest);
  }

  boolean tryCurrentHandler()
  {
    if ((this.currentHandler.needsInternetPermission()) && (!checkInternetPermission()))
    {
      addLoggingExtra("no_internet_permission", "1", false);
      return false;
    }
    boolean bool = this.currentHandler.tryAuthorize(this.pendingRequest);
    if (bool)
    {
      logAuthorizationMethodStart(this.currentHandler.getNameForLogging());
      return bool;
    }
    addLoggingExtra("not_tried", this.currentHandler.getNameForLogging(), true);
    return bool;
  }

  void tryNextHandler()
  {
    if (this.currentHandler != null)
      logAuthorizationMethodComplete(this.currentHandler.getNameForLogging(), "skipped", null, null, this.currentHandler.methodLoggingExtras);
    do
    {
      if ((this.handlersToTry == null) || (this.handlersToTry.isEmpty()))
        break;
      this.currentHandler = ((AuthHandler)this.handlersToTry.remove(0));
    }
    while (!tryCurrentHandler());
    while (this.pendingRequest == null)
      return;
    completeWithFailure();
  }

  void validateSameFbidAndFinish(Result paramResult)
  {
    if (paramResult.token == null)
      throw new FacebookException("Can't validate without a token");
    RequestBatch localRequestBatch = createReauthValidationBatch(paramResult);
    notifyBackgroundProcessingStart();
    localRequestBatch.executeAsync();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.handlersToTry != null)
    {
      paramParcel.writeInt(this.handlersToTry.size());
      Iterator localIterator = this.handlersToTry.iterator();
      while (localIterator.hasNext())
        paramParcel.writeParcelable((AuthHandler)localIterator.next(), paramInt);
    }
    paramParcel.writeInt(-1);
    paramParcel.writeParcelable(this.currentHandler, paramInt);
    paramParcel.writeParcelable(this.pendingRequest, paramInt);
    if (this.loggingExtras != null);
    for (int i = 0; ; i = -1)
    {
      paramParcel.writeInt(i);
      if (this.loggingExtras != null)
        paramParcel.writeMap(this.loggingExtras);
      return;
    }
  }

  static class AuthDialogBuilder extends WebDialog.Builder
  {
    private static final String OAUTH_DIALOG = "oauth";
    static final String REDIRECT_URI = "fbconnect://success";
    private String e2e;
    private boolean isRerequest;

    public AuthDialogBuilder(Context paramContext, String paramString, Bundle paramBundle)
    {
      super(paramString, "oauth", paramBundle);
    }

    public WebDialog build()
    {
      Bundle localBundle = getParameters();
      localBundle.putString("redirect_uri", "fbconnect://success");
      localBundle.putString("client_id", getApplicationId());
      localBundle.putString("e2e", this.e2e);
      localBundle.putString("response_type", "token");
      localBundle.putString("return_scopes", "true");
      if ((this.isRerequest) && (!Settings.getPlatformCompatibilityEnabled()))
        localBundle.putString("auth_type", "rerequest");
      return new WebDialog(getContext(), "oauth", localBundle, getTheme(), getListener());
    }

    public AuthDialogBuilder setE2E(String paramString)
    {
      this.e2e = paramString;
      return this;
    }

    public AuthDialogBuilder setIsRerequest(boolean paramBoolean)
    {
      this.isRerequest = paramBoolean;
      return this;
    }
  }

  static abstract class AuthHandler
    implements Parcelable
  {
    AuthorizationClient client;
    Map<String, String> methodLoggingExtras;

    AuthHandler(Parcel paramParcel)
    {
      ClassLoader localClassLoader = AuthHandler.class.getClassLoader();
      if (paramParcel.readInt() != -1)
      {
        this.methodLoggingExtras = new HashMap();
        paramParcel.readMap(this.methodLoggingExtras, localClassLoader);
      }
    }

    AuthHandler(AuthorizationClient paramAuthorizationClient)
    {
      this.client = paramAuthorizationClient;
    }

    protected void addLoggingExtra(String paramString, Object paramObject)
    {
      if (this.methodLoggingExtras == null)
        this.methodLoggingExtras = new HashMap();
      Map localMap = this.methodLoggingExtras;
      if (paramObject == null);
      for (Object localObject = null; ; localObject = paramObject.toString())
      {
        localMap.put(paramString, localObject);
        return;
      }
    }

    void cancel()
    {
    }

    public int describeContents()
    {
      return 0;
    }

    abstract String getNameForLogging();

    boolean needsInternetPermission()
    {
      return false;
    }

    boolean needsRestart()
    {
      return false;
    }

    boolean onActivityResult(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return false;
    }

    void setAuthorizationClient(AuthorizationClient paramAuthorizationClient)
    {
      this.client = paramAuthorizationClient;
    }

    abstract boolean tryAuthorize(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest);

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.methodLoggingExtras != null);
      for (int i = this.methodLoggingExtras.size(); ; i = -1)
      {
        paramParcel.writeInt(i);
        if (this.methodLoggingExtras != null)
          paramParcel.writeMap(this.methodLoggingExtras);
        return;
      }
    }
  }

  public static class AuthorizationRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new Parcelable.Creator()
    {
      public AuthorizationClient.AuthorizationRequest createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AuthorizationClient.AuthorizationRequest(paramAnonymousParcel);
      }

      public AuthorizationClient.AuthorizationRequest[] newArray(int paramAnonymousInt)
      {
        return new AuthorizationClient.AuthorizationRequest[paramAnonymousInt];
      }
    };
    private final String applicationId;
    private final String authId;
    private final SessionDefaultAudience defaultAudience;
    private boolean isLegacy = false;
    private boolean isRerequest = false;
    private final SessionLoginBehavior loginBehavior;
    private List<String> permissions;
    private final String previousAccessToken;
    private final int requestCode;
    private final transient AuthorizationClient.StartActivityDelegate startActivityDelegate;

    AuthorizationRequest(Parcel paramParcel)
    {
      this.loginBehavior = SessionLoginBehavior.values()[paramParcel.readInt()];
      this.requestCode = paramParcel.readInt();
      boolean bool2;
      if (paramParcel.readInt() > 0)
      {
        bool2 = bool1;
        this.isLegacy = bool2;
        this.permissions = paramParcel.createStringArrayList();
        this.defaultAudience = SessionDefaultAudience.values()[paramParcel.readInt()];
        this.applicationId = paramParcel.readString();
        this.previousAccessToken = paramParcel.readString();
        this.authId = paramParcel.readString();
        if (paramParcel.readInt() <= 0)
          break label117;
      }
      while (true)
      {
        this.isRerequest = bool1;
        this.startActivityDelegate = null;
        return;
        bool2 = false;
        break;
        label117: bool1 = false;
      }
    }

    AuthorizationRequest(SessionLoginBehavior paramSessionLoginBehavior, int paramInt, boolean paramBoolean, List<String> paramList, SessionDefaultAudience paramSessionDefaultAudience, String paramString1, String paramString2, AuthorizationClient.StartActivityDelegate paramStartActivityDelegate, String paramString3)
    {
      this.loginBehavior = paramSessionLoginBehavior;
      this.requestCode = paramInt;
      this.isLegacy = paramBoolean;
      this.permissions = paramList;
      this.defaultAudience = paramSessionDefaultAudience;
      this.applicationId = paramString1;
      this.previousAccessToken = paramString2;
      this.startActivityDelegate = paramStartActivityDelegate;
      this.authId = paramString3;
    }

    public int describeContents()
    {
      return 0;
    }

    String getApplicationId()
    {
      return this.applicationId;
    }

    String getAuthId()
    {
      return this.authId;
    }

    SessionDefaultAudience getDefaultAudience()
    {
      return this.defaultAudience;
    }

    SessionLoginBehavior getLoginBehavior()
    {
      return this.loginBehavior;
    }

    List<String> getPermissions()
    {
      return this.permissions;
    }

    String getPreviousAccessToken()
    {
      return this.previousAccessToken;
    }

    int getRequestCode()
    {
      return this.requestCode;
    }

    AuthorizationClient.StartActivityDelegate getStartActivityDelegate()
    {
      return this.startActivityDelegate;
    }

    boolean isLegacy()
    {
      return this.isLegacy;
    }

    boolean isRerequest()
    {
      return this.isRerequest;
    }

    boolean needsNewTokenValidation()
    {
      return (this.previousAccessToken != null) && (!this.isLegacy);
    }

    void setIsLegacy(boolean paramBoolean)
    {
      this.isLegacy = paramBoolean;
    }

    void setPermissions(List<String> paramList)
    {
      this.permissions = paramList;
    }

    void setRerequest(boolean paramBoolean)
    {
      this.isRerequest = paramBoolean;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      int j = -1;
      int k;
      int m;
      if (this.loginBehavior != null)
      {
        k = this.loginBehavior.ordinal();
        paramParcel.writeInt(k);
        paramParcel.writeInt(this.requestCode);
        if (!this.isLegacy)
          break label125;
        m = i;
        label45: paramParcel.writeInt(m);
        paramParcel.writeStringList(this.permissions);
        if (this.defaultAudience != null)
          j = this.defaultAudience.ordinal();
        paramParcel.writeInt(j);
        paramParcel.writeString(this.applicationId);
        paramParcel.writeString(this.previousAccessToken);
        paramParcel.writeString(this.authId);
        if (!this.isRerequest)
          break label131;
      }
      while (true)
      {
        paramParcel.writeInt(i);
        return;
        k = j;
        break;
        label125: m = 0;
        break label45;
        label131: i = 0;
      }
    }
  }

  public static abstract interface BackgroundProcessingListener
  {
    public abstract void onBackgroundProcessingStarted();

    public abstract void onBackgroundProcessingStopped();
  }

  static class GetTokenAuthHandler extends AuthorizationClient.AuthHandler
  {
    public static final Parcelable.Creator<GetTokenAuthHandler> CREATOR = new Parcelable.Creator()
    {
      public AuthorizationClient.GetTokenAuthHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AuthorizationClient.GetTokenAuthHandler(paramAnonymousParcel);
      }

      public AuthorizationClient.GetTokenAuthHandler[] newArray(int paramAnonymousInt)
      {
        return new AuthorizationClient.GetTokenAuthHandler[paramAnonymousInt];
      }
    };
    private transient GetTokenClient getTokenClient;

    GetTokenAuthHandler(Parcel paramParcel)
    {
      super();
    }

    GetTokenAuthHandler(AuthorizationClient paramAuthorizationClient)
    {
      super();
    }

    void cancel()
    {
      if (this.getTokenClient != null)
      {
        this.getTokenClient.cancel();
        this.getTokenClient = null;
      }
    }

    String getNameForLogging()
    {
      return "get_token";
    }

    void getTokenCompleted(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, Bundle paramBundle)
    {
      this.getTokenClient = null;
      this.client.notifyBackgroundProcessingStop();
      if (paramBundle != null)
      {
        ArrayList localArrayList1 = paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        List localList = paramAuthorizationRequest.getPermissions();
        if ((localArrayList1 != null) && ((localList == null) || (localArrayList1.containsAll(localList))))
        {
          AccessToken localAccessToken = AccessToken.createFromNativeLogin(paramBundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE);
          AuthorizationClient.Result localResult = AuthorizationClient.Result.createTokenResult(this.client.pendingRequest, localAccessToken);
          this.client.completeAndValidate(localResult);
          return;
        }
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!localArrayList1.contains(str))
            localArrayList2.add(str);
        }
        if (!localArrayList2.isEmpty())
          addLoggingExtra("new_permissions", TextUtils.join(",", localArrayList2));
        paramAuthorizationRequest.setPermissions(localArrayList2);
      }
      this.client.tryNextHandler();
    }

    boolean needsRestart()
    {
      return this.getTokenClient == null;
    }

    boolean tryAuthorize(final AuthorizationClient.AuthorizationRequest paramAuthorizationRequest)
    {
      this.getTokenClient = new GetTokenClient(this.client.context, paramAuthorizationRequest.getApplicationId());
      if (!this.getTokenClient.start())
        return false;
      this.client.notifyBackgroundProcessingStart();
      PlatformServiceClient.CompletedListener local2 = new PlatformServiceClient.CompletedListener()
      {
        public void completed(Bundle paramAnonymousBundle)
        {
          AuthorizationClient.GetTokenAuthHandler.this.getTokenCompleted(paramAuthorizationRequest, paramAnonymousBundle);
        }
      };
      this.getTokenClient.setCompletedListener(local2);
      return true;
    }
  }

  static abstract class KatanaAuthHandler extends AuthorizationClient.AuthHandler
  {
    KatanaAuthHandler(Parcel paramParcel)
    {
      super();
    }

    KatanaAuthHandler(AuthorizationClient paramAuthorizationClient)
    {
      super();
    }

    protected boolean tryIntent(Intent paramIntent, int paramInt)
    {
      if (paramIntent == null)
        return false;
      try
      {
        this.client.getStartActivityDelegate().startActivityForResult(paramIntent, paramInt);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
      }
      return false;
    }
  }

  static class KatanaProxyAuthHandler extends AuthorizationClient.KatanaAuthHandler
  {
    public static final Parcelable.Creator<KatanaProxyAuthHandler> CREATOR = new Parcelable.Creator()
    {
      public AuthorizationClient.KatanaProxyAuthHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AuthorizationClient.KatanaProxyAuthHandler(paramAnonymousParcel);
      }

      public AuthorizationClient.KatanaProxyAuthHandler[] newArray(int paramAnonymousInt)
      {
        return new AuthorizationClient.KatanaProxyAuthHandler[paramAnonymousInt];
      }
    };
    private String applicationId;

    KatanaProxyAuthHandler(Parcel paramParcel)
    {
      super();
      this.applicationId = paramParcel.readString();
    }

    KatanaProxyAuthHandler(AuthorizationClient paramAuthorizationClient)
    {
      super();
    }

    private AuthorizationClient.Result handleResultOk(Bundle paramBundle)
    {
      String str1 = paramBundle.getString("error");
      if (str1 == null)
        str1 = paramBundle.getString("error_type");
      String str2 = paramBundle.getString("error_code");
      String str3 = paramBundle.getString("error_message");
      if (str3 == null)
        str3 = paramBundle.getString("error_description");
      String str4 = paramBundle.getString("e2e");
      if (!Utility.isNullOrEmpty(str4))
        this.client.logWebLoginCompleted(this.applicationId, str4);
      if ((str1 == null) && (str2 == null) && (str3 == null))
      {
        AccessToken localAccessToken = AccessToken.createFromWebBundle(this.client.pendingRequest.getPermissions(), paramBundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB);
        return AuthorizationClient.Result.createTokenResult(this.client.pendingRequest, localAccessToken);
      }
      if (ServerProtocol.errorsProxyAuthDisabled.contains(str1))
        return null;
      if (ServerProtocol.errorsUserCanceled.contains(str1))
        return AuthorizationClient.Result.createCancelResult(this.client.pendingRequest, null);
      return AuthorizationClient.Result.createErrorResult(this.client.pendingRequest, str1, str3, str2);
    }

    String getNameForLogging()
    {
      return "katana_proxy_auth";
    }

    boolean onActivityResult(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AuthorizationClient.Result localResult;
      if (paramBundle == null)
      {
        localResult = AuthorizationClient.Result.createCancelResult(this.client.pendingRequest, "Operation canceled");
        if (localResult == null)
          break label92;
        this.client.completeAndValidate(localResult);
      }
      while (true)
      {
        return true;
        if (paramInt2 == 0)
        {
          localResult = AuthorizationClient.Result.createCancelResult(this.client.pendingRequest, paramBundle.getString("error"));
          break;
        }
        if (paramInt2 != -1)
        {
          localResult = AuthorizationClient.Result.createErrorResult(this.client.pendingRequest, "Unexpected resultCode from authorization.", null);
          break;
        }
        localResult = handleResultOk(paramBundle);
        break;
        label92: this.client.tryNextHandler();
      }
    }

    boolean tryAuthorize(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest)
    {
      this.applicationId = paramAuthorizationRequest.getApplicationId();
      String str = AuthorizationClient.access$100();
      Intent localIntent = NativeProtocol.createProxyAuthIntent(this.client.context, paramAuthorizationRequest.getApplicationId(), paramAuthorizationRequest.getPermissions(), str, paramAuthorizationRequest.isRerequest(), paramAuthorizationRequest.getDefaultAudience());
      addLoggingExtra("e2e", str);
      return tryIntent(localIntent, paramAuthorizationRequest.getRequestCode());
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.applicationId);
    }
  }

  public static abstract interface OnCompletedListener
  {
    public abstract void onCompleted(AuthorizationClient.Result paramResult);
  }

  public static class Result
    implements Parcelable
  {
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator()
    {
      public AuthorizationClient.Result createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AuthorizationClient.Result(paramAnonymousParcel, null);
      }

      public AuthorizationClient.Result[] newArray(int paramAnonymousInt)
      {
        return new AuthorizationClient.Result[paramAnonymousInt];
      }
    };
    public final Code code;
    public final String errorCode;
    public final String errorMessage;
    Map<String, String> loggingExtras;
    public final AuthorizationClient.AuthorizationRequest request;
    public final AccessToken token;

    private Result(Parcel paramParcel)
    {
      ClassLoader localClassLoader = Result.class.getClassLoader();
      this.code = Code.values()[paramParcel.readInt()];
      this.token = ((AccessToken)paramParcel.readParcelable(localClassLoader));
      this.errorMessage = paramParcel.readString();
      this.errorCode = paramParcel.readString();
      this.request = ((AuthorizationClient.AuthorizationRequest)paramParcel.readParcelable(localClassLoader));
      if (paramParcel.readInt() != -1)
      {
        this.loggingExtras = new HashMap();
        paramParcel.readMap(this.loggingExtras, localClassLoader);
      }
    }

    private Result(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, Code paramCode, AccessToken paramAccessToken, String paramString1, String paramString2)
    {
      this.request = paramAuthorizationRequest;
      this.token = paramAccessToken;
      this.errorMessage = paramString1;
      this.code = paramCode;
      this.errorCode = paramString2;
    }

    static Result createCancelResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString)
    {
      return new Result(paramAuthorizationRequest, Code.CANCEL, null, paramString, null);
    }

    static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2)
    {
      return createErrorResult(paramAuthorizationRequest, paramString1, paramString2, null);
    }

    static Result createErrorResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, String paramString1, String paramString2, String paramString3)
    {
      String str = TextUtils.join(": ", Utility.asListNoNulls(new String[] { paramString1, paramString2 }));
      return new Result(paramAuthorizationRequest, Code.ERROR, null, str, paramString3);
    }

    static Result createTokenResult(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, AccessToken paramAccessToken)
    {
      return new Result(paramAuthorizationRequest, Code.SUCCESS, paramAccessToken, null, null);
    }

    public int describeContents()
    {
      return 0;
    }

    public Map<String, String> getLoggingExtras()
    {
      return this.loggingExtras;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.code.ordinal());
      paramParcel.writeParcelable(this.token, paramInt);
      paramParcel.writeString(this.errorMessage);
      paramParcel.writeString(this.errorCode);
      paramParcel.writeParcelable(this.request, paramInt);
      if (this.loggingExtras != null);
      for (int i = this.loggingExtras.size(); ; i = -1)
      {
        paramParcel.writeInt(i);
        if (this.loggingExtras != null)
          paramParcel.writeMap(this.loggingExtras);
        return;
      }
    }

    public static enum Code
    {
      private final String loggingValue;

      static
      {
        CANCEL = new Code("CANCEL", 1, "cancel");
        ERROR = new Code("ERROR", 2, "error");
        Code[] arrayOfCode = new Code[3];
        arrayOfCode[0] = SUCCESS;
        arrayOfCode[1] = CANCEL;
        arrayOfCode[2] = ERROR;
      }

      private Code(String paramString)
      {
        this.loggingValue = paramString;
      }

      String getLoggingValue()
      {
        return this.loggingValue;
      }
    }
  }

  public static abstract interface StartActivityDelegate
  {
    public abstract Activity getActivityContext();

    public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  }

  static class WebViewAuthHandler extends AuthorizationClient.AuthHandler
  {
    public static final Parcelable.Creator<WebViewAuthHandler> CREATOR = new Parcelable.Creator()
    {
      public AuthorizationClient.WebViewAuthHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AuthorizationClient.WebViewAuthHandler(paramAnonymousParcel);
      }

      public AuthorizationClient.WebViewAuthHandler[] newArray(int paramAnonymousInt)
      {
        return new AuthorizationClient.WebViewAuthHandler[paramAnonymousInt];
      }
    };
    private String applicationId;
    private String e2e;
    private transient WebDialog loginDialog;

    WebViewAuthHandler(Parcel paramParcel)
    {
      super();
      this.applicationId = paramParcel.readString();
      this.e2e = paramParcel.readString();
    }

    WebViewAuthHandler(AuthorizationClient paramAuthorizationClient)
    {
      super();
    }

    private String loadCookieToken()
    {
      return this.client.getStartActivityDelegate().getActivityContext().getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void saveCookieToken(String paramString)
    {
      SharedPreferences.Editor localEditor = this.client.getStartActivityDelegate().getActivityContext().getSharedPreferences("com.facebook.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit();
      localEditor.putString("TOKEN", paramString);
      if (!localEditor.commit())
        Utility.logd("Facebook-AuthorizationClient", "Could not update saved web view auth handler token.");
    }

    void cancel()
    {
      if (this.loginDialog != null)
      {
        this.loginDialog.setOnCompleteListener(null);
        this.loginDialog.dismiss();
        this.loginDialog = null;
      }
    }

    String getNameForLogging()
    {
      return "web_view";
    }

    boolean needsInternetPermission()
    {
      return true;
    }

    boolean needsRestart()
    {
      return true;
    }

    void onWebDialogComplete(AuthorizationClient.AuthorizationRequest paramAuthorizationRequest, Bundle paramBundle, FacebookException paramFacebookException)
    {
      AuthorizationClient.Result localResult;
      if (paramBundle != null)
      {
        if (paramBundle.containsKey("e2e"))
          this.e2e = paramBundle.getString("e2e");
        AccessToken localAccessToken = AccessToken.createFromWebBundle(paramAuthorizationRequest.getPermissions(), paramBundle, AccessTokenSource.WEB_VIEW);
        localResult = AuthorizationClient.Result.createTokenResult(this.client.pendingRequest, localAccessToken);
        CookieSyncManager.createInstance(this.client.context).sync();
        saveCookieToken(localAccessToken.getToken());
      }
      while (true)
      {
        if (!Utility.isNullOrEmpty(this.e2e))
          this.client.logWebLoginCompleted(this.applicationId, this.e2e);
        this.client.completeAndValidate(localResult);
        return;
        if (!(paramFacebookException instanceof FacebookOperationCanceledException))
          break;
        localResult = AuthorizationClient.Result.createCancelResult(this.client.pendingRequest, "User canceled log in.");
      }
      this.e2e = null;
      String str1 = paramFacebookException.getMessage();
      String str2;
      if ((paramFacebookException instanceof FacebookServiceException))
      {
        FacebookRequestError localFacebookRequestError = ((FacebookServiceException)paramFacebookException).getRequestError();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(localFacebookRequestError.getErrorCode());
        str2 = String.format("%d", arrayOfObject);
        str1 = localFacebookRequestError.toString();
      }
      while (true)
      {
        localResult = AuthorizationClient.Result.createErrorResult(this.client.pendingRequest, null, str1, str2);
        break;
        str2 = null;
      }
    }

    boolean tryAuthorize(final AuthorizationClient.AuthorizationRequest paramAuthorizationRequest)
    {
      this.applicationId = paramAuthorizationRequest.getApplicationId();
      Bundle localBundle = new Bundle();
      if (!Utility.isNullOrEmpty(paramAuthorizationRequest.getPermissions()))
      {
        String str2 = TextUtils.join(",", paramAuthorizationRequest.getPermissions());
        localBundle.putString("scope", str2);
        addLoggingExtra("scope", str2);
      }
      localBundle.putString("default_audience", paramAuthorizationRequest.getDefaultAudience().getNativeProtocolAudience());
      String str1 = paramAuthorizationRequest.getPreviousAccessToken();
      if ((!Utility.isNullOrEmpty(str1)) && (str1.equals(loadCookieToken())))
      {
        localBundle.putString("access_token", str1);
        addLoggingExtra("access_token", "1");
      }
      while (true)
      {
        WebDialog.OnCompleteListener local2 = new WebDialog.OnCompleteListener()
        {
          public void onComplete(Bundle paramAnonymousBundle, FacebookException paramAnonymousFacebookException)
          {
            AuthorizationClient.WebViewAuthHandler.this.onWebDialogComplete(paramAuthorizationRequest, paramAnonymousBundle, paramAnonymousFacebookException);
          }
        };
        this.e2e = AuthorizationClient.access$100();
        addLoggingExtra("e2e", this.e2e);
        this.loginDialog = ((WebDialog.Builder)new AuthorizationClient.AuthDialogBuilder(this.client.getStartActivityDelegate().getActivityContext(), this.applicationId, localBundle).setE2E(this.e2e).setIsRerequest(paramAuthorizationRequest.isRerequest()).setOnCompleteListener(local2)).build();
        this.loginDialog.show();
        return true;
        Utility.clearFacebookCookies(this.client.context);
        addLoggingExtra("access_token", "0");
      }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.applicationId);
      paramParcel.writeString(this.e2e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.AuthorizationClient
 * JD-Core Version:    0.6.2
 */