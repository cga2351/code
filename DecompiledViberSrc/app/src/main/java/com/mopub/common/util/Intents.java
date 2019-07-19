package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intents
{
  private static final Map<String, String> a = Collections.unmodifiableMap(localHashMap);

  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("market", "https://play.google.com/store/apps/details?%s");
    localHashMap.put("amzn", "http://www.amazon.com/gp/mas/dl/android?%s");
  }

  private static Uri a(Uri paramUri)
    throws UrlParseException
  {
    Preconditions.checkNotNull(paramUri);
    if (!"navigate".equals(paramUri.getHost()))
      throw new UrlParseException("URL missing 'navigate' host parameter.");
    String str;
    try
    {
      str = paramUri.getQueryParameter("url");
      if (str == null)
        throw new UrlParseException("URL missing 'url' query parameter.");
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Could not handle url: " + paramUri);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
    }
    return Uri.parse(str);
  }

  @Deprecated
  public static boolean canHandleApplicationUrl(Context paramContext, Uri paramUri)
  {
    return false;
  }

  @Deprecated
  public static boolean canHandleApplicationUrl(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    return false;
  }

  public static boolean deviceCanHandleIntent(Context paramContext, Intent paramIntent)
  {
    try
    {
      boolean bool1 = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return bool2;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public static Uri getPlayStoreUri(Intent paramIntent)
  {
    Preconditions.checkNotNull(paramIntent);
    return Uri.parse("market://details?id=" + paramIntent.getPackage());
  }

  public static Intent getStartActivityIntent(Context paramContext, Class paramClass, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, paramClass);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    return localIntent;
  }

  public static Intent intentForNativeBrowserScheme(Uri paramUri)
    throws UrlParseException
  {
    Preconditions.checkNotNull(paramUri);
    if (!UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(paramUri))
    {
      String str = "mopubnativebrowser://";
      if (MoPub.getBrowserAgent() == MoPub.BrowserAgent.NATIVE)
        str = str + ", http://, or https://";
      throw new UrlParseException("URI does not have " + str + " scheme.");
    }
    if ("mopubnativebrowser".equalsIgnoreCase(paramUri.getScheme()))
      return new Intent("android.intent.action.VIEW", a(paramUri));
    if (MoPub.getBrowserAgent() == MoPub.BrowserAgent.NATIVE)
      return new Intent("android.intent.action.VIEW", paramUri);
    throw new UrlParseException("Invalid URI: " + paramUri.toString());
  }

  public static Intent intentForShareTweet(Uri paramUri)
    throws UrlParseException
  {
    if (!UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(paramUri))
      throw new UrlParseException("URL does not have mopubshare://tweet? format.");
    String str1;
    String str2;
    try
    {
      str1 = paramUri.getQueryParameter("screen_name");
      str2 = paramUri.getQueryParameter("tweet_id");
      if (TextUtils.isEmpty(str1))
        throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Could not handle url: " + paramUri);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
    }
    if (TextUtils.isEmpty(str2))
      throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
    String str3 = String.format("Check out @%s's Tweet: %s", new Object[] { str1, String.format("https://twitter.com/%s/status/%s", new Object[] { str1, str2 }) });
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", str3);
    localIntent.putExtra("android.intent.extra.TEXT", str3);
    return localIntent;
  }

  public static void launchActionViewIntent(Context paramContext, Uri paramUri, String paramString)
    throws IntentNotResolvableException
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramUri);
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    launchIntentForUserClick(paramContext, localIntent, paramString);
  }

  public static void launchApplicationIntent(Context paramContext, Intent paramIntent)
    throws IntentNotResolvableException
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramIntent);
    if (deviceCanHandleIntent(paramContext, paramIntent))
    {
      String str3 = "Unable to open intent: " + paramIntent;
      if (!(paramContext instanceof Activity))
        paramIntent.addFlags(268435456);
      launchIntentForUserClick(paramContext, paramIntent, str3);
      return;
    }
    String str1 = paramIntent.getStringExtra("browser_fallback_url");
    if (TextUtils.isEmpty(str1))
    {
      if (!a.containsKey(paramIntent.getScheme()))
      {
        launchApplicationUrl(paramContext, getPlayStoreUri(paramIntent));
        return;
      }
      throw new IntentNotResolvableException("Device could not handle neither intent nor market url.\nIntent: " + paramIntent.toString());
    }
    Uri localUri = Uri.parse(str1);
    String str2 = localUri.getScheme();
    if (("http".equalsIgnoreCase(str2)) || ("https".equalsIgnoreCase(str2)))
    {
      showMoPubBrowserForUrl(paramContext, localUri, null);
      return;
    }
    launchApplicationUrl(paramContext, localUri);
  }

  public static void launchApplicationUrl(Context paramContext, Uri paramUri)
    throws IntentNotResolvableException
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", paramUri);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramUri);
    if (deviceCanHandleIntent(paramContext, localIntent))
    {
      launchApplicationIntent(paramContext, localIntent);
      return;
    }
    if ((a.containsKey(localIntent.getScheme())) && (localIntent.getData() != null) && (!TextUtils.isEmpty(localIntent.getData().getQuery())))
    {
      String str = (String)a.get(localIntent.getScheme());
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIntent.getData().getQuery();
      launchApplicationIntent(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(String.format(str, arrayOfObject))));
      return;
    }
    throw new IntentNotResolvableException("Could not handle application specific action: " + paramUri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
  }

  public static void launchIntentForUserClick(Context paramContext, Intent paramIntent, String paramString)
    throws IntentNotResolvableException
  {
    Preconditions.NoThrow.checkNotNull(paramContext);
    Preconditions.NoThrow.checkNotNull(paramIntent);
    try
    {
      startActivity(paramContext, paramIntent);
      return;
    }
    catch (IntentNotResolvableException localIntentNotResolvableException)
    {
      throw new IntentNotResolvableException(paramString + "\n" + localIntentNotResolvableException.getMessage());
    }
  }

  public static void showMoPubBrowserForUrl(Context paramContext, Uri paramUri, String paramString)
    throws IntentNotResolvableException
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramUri);
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Final URI to show in browser: " + paramUri);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    Bundle localBundle = new Bundle();
    localBundle.putString("URL", paramUri.toString());
    if (!TextUtils.isEmpty(paramString))
      localBundle.putString("mopub-dsp-creative-id", paramString);
    launchIntentForUserClick(paramContext, getStartActivityIntent(paramContext, MoPubBrowser.class, localBundle), "Could not show MoPubBrowser for url: " + paramUri + "\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.");
  }

  public static void startActivity(Context paramContext, Intent paramIntent)
    throws IntentNotResolvableException
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramIntent);
    if (!(paramContext instanceof Activity))
      paramIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      throw new IntentNotResolvableException(localActivityNotFoundException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Intents
 * JD-Core Version:    0.6.2
 */