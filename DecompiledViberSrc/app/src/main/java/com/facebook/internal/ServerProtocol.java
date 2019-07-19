package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol
{
  private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
  public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
  public static final String DIALOG_PARAM_APP_ID = "app_id";
  public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
  public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
  public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
  public static final String DIALOG_PARAM_DISPLAY = "display";
  public static final String DIALOG_PARAM_E2E = "e2e";
  public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
  public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
  public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
  public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
  public static final String DIALOG_PARAM_SCOPE = "scope";
  public static final String DIALOG_PATH = "dialog/";
  public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
  public static final String DIALOG_RESPONSE_TYPE_TOKEN = "token";
  public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
  public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
  public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
  public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
  public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
  public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
  public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
  public static final String GRAPH_API_VERSION = "v2.1";
  private static final String GRAPH_URL_FORMAT = "https://graph.%s";
  private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
  private static final String LEGACY_API_VERSION = "v1.0";
  private static final String TAG = ServerProtocol.class.getName();
  public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[] { "service_disabled", "AndroidAuthKillSwitchException" });
  public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection(new String[] { "access_denied", "OAuthAccessDeniedException" });

  public static final String getAPIVersion()
  {
    if (Settings.getPlatformCompatibilityEnabled())
      return "v1.0";
    return "v2.1";
  }

  public static final String getDialogAuthority()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("m.%s", arrayOfObject);
  }

  public static final String getGraphUrlBase()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("https://graph.%s", arrayOfObject);
  }

  public static final String getGraphVideoUrlBase()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Settings.getFacebookDomain();
    return String.format("https://graph-video.%s", arrayOfObject);
  }

  public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(Context paramContext, String paramString1, int paramInt, String paramString2, Bundle paramBundle)
  {
    String str = Settings.getApplicationSignature(paramContext);
    if (Utility.isNullOrEmpty(str));
    while (true)
    {
      return null;
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("android_key_hash", str);
      localBundle1.putString("app_id", Settings.getApplicationId());
      localBundle1.putInt("version", paramInt);
      localBundle1.putString("display", "touch");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("action_id", paramString1);
      localBundle2.putString("app_name", paramString2);
      if (paramBundle == null)
        paramBundle = new Bundle();
      try
      {
        JSONObject localJSONObject1 = BundleJSONConverter.convertToJSON(localBundle2);
        JSONObject localJSONObject2 = BundleJSONConverter.convertToJSON(paramBundle);
        if ((localJSONObject1 == null) || (localJSONObject2 == null))
          continue;
        localBundle1.putString("bridge_args", localJSONObject1.toString());
        localBundle1.putString("method_args", localJSONObject2.toString());
        return localBundle1;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + localJSONException);
          localBundle1 = null;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.internal.ServerProtocol
 * JD-Core Version:    0.6.2
 */