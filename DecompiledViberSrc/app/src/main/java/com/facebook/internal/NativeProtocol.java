package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.SessionDefaultAudience;
import com.facebook.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

public final class NativeProtocol
{
  public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
  public static final String ACTION_FEED_DIALOG_REPLY = "com.facebook.platform.action.reply.FEED_DIALOG";
  public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
  public static final String ACTION_LIKE_DIALOG_REPLY = "com.facebook.platform.action.reply.LIKE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG_REPLY = "com.facebook.platform.action.reply.MESSAGE_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG_REPLY = "com.facebook.platform.action.reply.OGMESSAGEPUBLISH_DIALOG";
  public static final String AUDIENCE_EVERYONE = "everyone";
  public static final String AUDIENCE_FRIENDS = "friends";
  public static final String AUDIENCE_ME = "only_me";
  public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
  public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
  public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
  private static final String CONTENT_SCHEME = "content://";
  public static final int DIALOG_REQUEST_CODE = 64207;
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  public static final String ERROR_USER_CANCELED = "UserCanceled";
  public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
  public static final String EXTRA_ACTION = "com.facebook.platform.extra.ACTION";
  public static final String EXTRA_ACTION_TYPE = "com.facebook.platform.extra.ACTION_TYPE";
  public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
  public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
  public static final String EXTRA_DATA_FAILURES_FATAL = "com.facebook.platform.extra.DATA_FAILURES_FATAL";
  public static final String EXTRA_DESCRIPTION = "com.facebook.platform.extra.DESCRIPTION";
  public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
  public static final String EXTRA_FRIEND_TAGS = "com.facebook.platform.extra.FRIENDS";
  public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
  public static final String EXTRA_IMAGE = "com.facebook.platform.extra.IMAGE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE";
  public static final String EXTRA_LIKE_COUNT_STRING_WITH_LIKE = "com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE";
  public static final String EXTRA_LINK = "com.facebook.platform.extra.LINK";
  public static final String EXTRA_OBJECT_ID = "com.facebook.platform.extra.OBJECT_ID";
  public static final String EXTRA_OBJECT_IS_LIKED = "com.facebook.platform.extra.OBJECT_IS_LIKED";
  public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
  public static final String EXTRA_PHOTOS = "com.facebook.platform.extra.PHOTOS";
  public static final String EXTRA_PLACE_TAG = "com.facebook.platform.extra.PLACE";
  public static final String EXTRA_PREVIEW_PROPERTY_NAME = "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME";
  public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
  public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
  public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
  public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
  public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
  static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
  public static final String EXTRA_REF = "com.facebook.platform.extra.REF";
  public static final String EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE";
  public static final String EXTRA_SOCIAL_SENTENCE_WITH_LIKE = "com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE";
  public static final String EXTRA_SUBTITLE = "com.facebook.platform.extra.SUBTITLE";
  public static final String EXTRA_TITLE = "com.facebook.platform.extra.TITLE";
  public static final String EXTRA_UNLIKE_TOKEN = "com.facebook.platform.extra.UNLIKE_TOKEN";
  private static final NativeAppInfo FACEBOOK_APP_INFO = new KatanaAppInfo(null);
  private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
  public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
  public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
  public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
  private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
  public static final String IMAGE_URL_KEY = "url";
  public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
  static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
  static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
  private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(arrayOfInteger);
  public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
  public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
  public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
  public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
  public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
  public static final String METHOD_ARGS_ACTION = "ACTION";
  public static final String METHOD_ARGS_ACTION_TYPE = "ACTION_TYPE";
  public static final String METHOD_ARGS_DATA_FAILURES_FATAL = "DATA_FAILURES_FATAL";
  public static final String METHOD_ARGS_DESCRIPTION = "DESCRIPTION";
  public static final String METHOD_ARGS_FRIEND_TAGS = "FRIENDS";
  public static final String METHOD_ARGS_IMAGE = "IMAGE";
  public static final String METHOD_ARGS_LINK = "LINK";
  public static final String METHOD_ARGS_OBJECT_ID = "object_id";
  public static final String METHOD_ARGS_PHOTOS = "PHOTOS";
  public static final String METHOD_ARGS_PLACE_TAG = "PLACE";
  public static final String METHOD_ARGS_PREVIEW_PROPERTY_NAME = "PREVIEW_PROPERTY_NAME";
  public static final String METHOD_ARGS_REF = "REF";
  public static final String METHOD_ARGS_SUBTITLE = "SUBTITLE";
  public static final String METHOD_ARGS_TITLE = "TITLE";
  public static final int NO_PROTOCOL_AVAILABLE = -1;
  public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
  private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
  private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
  public static final int PROTOCOL_VERSION_20121101 = 20121101;
  public static final int PROTOCOL_VERSION_20130502 = 20130502;
  public static final int PROTOCOL_VERSION_20130618 = 20130618;
  public static final int PROTOCOL_VERSION_20131107 = 20131107;
  public static final int PROTOCOL_VERSION_20140204 = 20140204;
  public static final int PROTOCOL_VERSION_20140324 = 20140324;
  public static final int PROTOCOL_VERSION_20140701 = 20140701;
  public static final int PROTOCOL_VERSION_20141001 = 20141001;
  public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
  public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
  public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
  public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
  public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
  private static Map<String, List<NativeAppInfo>> actionToAppInfoMap;
  private static List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();

  static
  {
    actionToAppInfoMap = buildActionToAppInfoMap();
    Integer[] arrayOfInteger = new Integer[8];
    arrayOfInteger[0] = Integer.valueOf(20141001);
    arrayOfInteger[1] = Integer.valueOf(20140701);
    arrayOfInteger[2] = Integer.valueOf(20140324);
    arrayOfInteger[3] = Integer.valueOf(20140204);
    arrayOfInteger[4] = Integer.valueOf(20131107);
    arrayOfInteger[5] = Integer.valueOf(20130618);
    arrayOfInteger[6] = Integer.valueOf(20130502);
    arrayOfInteger[7] = Integer.valueOf(20121101);
  }

  private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap()
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MessengerAppInfo(null));
    localHashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", localArrayList);
    return localHashMap;
  }

  private static List<NativeAppInfo> buildFacebookAppList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FACEBOOK_APP_INFO);
    localArrayList.add(new WakizashiAppInfo(null));
    return localArrayList;
  }

  private static Uri buildPlatformProviderVersionURI(NativeAppInfo paramNativeAppInfo)
  {
    return Uri.parse("content://" + paramNativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
  }

  public static Intent createPlatformActivityIntent(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    Intent localIntent = findActivityIntent(paramContext, "com.facebook.platform.PLATFORM_ACTIVITY", paramString2);
    if (localIntent == null)
      return null;
    String str = Utility.getMetadataApplicationId(paramContext);
    localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", paramInt).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString2).putExtra("com.facebook.platform.extra.APPLICATION_ID", str);
    if (isVersionCompatibleWithBucketedIntent(paramInt))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("action_id", paramString1);
      localBundle.putString("app_name", paramString3);
      localIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", localBundle);
      if (paramBundle == null)
        paramBundle = new Bundle();
      localIntent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", paramBundle);
      return localIntent;
    }
    localIntent.putExtra("com.facebook.platform.protocol.CALL_ID", paramString1);
    localIntent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", paramString3);
    localIntent.putExtras(paramBundle);
    return localIntent;
  }

  public static Intent createPlatformServiceIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      NativeAppInfo localNativeAppInfo = (NativeAppInfo)localIterator.next();
      Intent localIntent = validateServiceIntent(paramContext, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(localNativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), localNativeAppInfo);
      if (localIntent != null)
        return localIntent;
    }
    return null;
  }

  public static Intent createProxyAuthIntent(Context paramContext, String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, SessionDefaultAudience paramSessionDefaultAudience)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      NativeAppInfo localNativeAppInfo = (NativeAppInfo)localIterator.next();
      Intent localIntent1 = new Intent().setClassName(localNativeAppInfo.getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", paramString1);
      if (!Utility.isNullOrEmpty(paramList))
        localIntent1.putExtra("scope", TextUtils.join(",", paramList));
      if (!Utility.isNullOrEmpty(paramString2))
        localIntent1.putExtra("e2e", paramString2);
      localIntent1.putExtra("response_type", "token");
      localIntent1.putExtra("return_scopes", "true");
      localIntent1.putExtra("default_audience", paramSessionDefaultAudience.getNativeProtocolAudience());
      if (!Settings.getPlatformCompatibilityEnabled())
      {
        localIntent1.putExtra("legacy_override", "v2.1");
        if (paramBoolean)
          localIntent1.putExtra("auth_type", "rerequest");
      }
      Intent localIntent2 = validateActivityIntent(paramContext, localIntent1, localNativeAppInfo);
      if (localIntent2 != null)
        return localIntent2;
    }
    return null;
  }

  public static Intent createTokenRefreshIntent(Context paramContext)
  {
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      NativeAppInfo localNativeAppInfo = (NativeAppInfo)localIterator.next();
      Intent localIntent = validateServiceIntent(paramContext, new Intent().setClassName(localNativeAppInfo.getPackage(), "com.facebook.katana.platform.TokenRefreshService"), localNativeAppInfo);
      if (localIntent != null)
        return localIntent;
    }
    return null;
  }

  private static Intent findActivityIntent(Context paramContext, String paramString1, String paramString2)
  {
    List localList = (List)actionToAppInfoMap.get(paramString2);
    Intent localIntent;
    if (localList == null)
      localIntent = null;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return localIntent;
        localIterator = localList.iterator();
        localIntent = null;
      }
      NativeAppInfo localNativeAppInfo = (NativeAppInfo)localIterator.next();
      localIntent = validateActivityIntent(paramContext, new Intent().setAction(paramString1).setPackage(localNativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), localNativeAppInfo);
    }
    while (localIntent == null);
    return localIntent;
  }

  public static Bundle getBridgeArgumentsFromIntent(Intent paramIntent)
  {
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
      return null;
    return paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
  }

  public static UUID getCallIdFromIntent(Intent paramIntent)
  {
    if (paramIntent == null);
    while (true)
    {
      return null;
      Bundle localBundle;
      if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
      {
        localBundle = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        if (localBundle == null)
          break label61;
      }
      label61: for (String str = localBundle.getString("action_id"); str != null; str = null)
        try
        {
          UUID localUUID = UUID.fromString(str);
          return localUUID;
          str = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          return null;
        }
    }
  }

  public static Bundle getErrorDataFromResultIntent(Intent paramIntent)
  {
    if (!isErrorResult(paramIntent))
      return null;
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null)
      return localBundle.getBundle("error");
    return paramIntent.getExtras();
  }

  public static Exception getExceptionFromErrorData(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    String str1 = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
    String str2 = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
    if ((str1 != null) && (str1.equalsIgnoreCase("UserCanceled")))
      return new FacebookOperationCanceledException(str2);
    return new FacebookException(str2);
  }

  public static int getLatestAvailableProtocolVersionForAction(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, (List)actionToAppInfoMap.get(paramString), paramArrayOfInt);
  }

  private static int getLatestAvailableProtocolVersionForAppInfo(Context paramContext, NativeAppInfo paramNativeAppInfo, int[] paramArrayOfInt)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String[] arrayOfString = { "version" };
    Uri localUri = buildPlatformProviderVersionURI(paramNativeAppInfo);
    try
    {
      Cursor localCursor2 = localContentResolver.query(localUri, arrayOfString, null, null, null);
      localCursor1 = localCursor2;
      if (localCursor1 == null)
        if (localCursor1 != null)
          localCursor1.close();
      label271: 
      do
      {
        return -1;
        TreeSet localTreeSet;
        try
        {
          localTreeSet = new TreeSet();
          while (localCursor1.moveToNext())
            localTreeSet.add(Integer.valueOf(localCursor1.getInt(localCursor1.getColumnIndex("version"))));
        }
        finally
        {
        }
        if (localCursor1 != null)
          localCursor1.close();
        throw localObject1;
        int i = -1 + paramArrayOfInt.length;
        Iterator localIterator = localTreeSet.descendingIterator();
        int j = getLatestKnownVersion();
        while (true)
        {
          if (!localIterator.hasNext())
            break label271;
          int k = ((Integer)localIterator.next()).intValue();
          for (int m = i; m >= 0; m--)
          {
            int n = paramArrayOfInt[m];
            if (n <= k)
              break;
          }
          if (m < 0)
          {
            if (localCursor1 == null)
              break;
            localCursor1.close();
            return -1;
          }
          if (paramArrayOfInt[m] == k)
          {
            int i1;
            if (m % 2 == 0)
              i1 = Math.min(k, j);
            for (int i2 = i1; ; i2 = -1)
            {
              if (localCursor1 != null)
                localCursor1.close();
              return i2;
            }
          }
          i = m;
        }
      }
      while (localCursor1 == null);
      localCursor1.close();
      return -1;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  private static int getLatestAvailableProtocolVersionForAppInfoList(Context paramContext, List<NativeAppInfo> paramList, int[] paramArrayOfInt)
  {
    if (paramList == null)
      return -1;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int i = getLatestAvailableProtocolVersionForAppInfo(paramContext, (NativeAppInfo)localIterator.next(), paramArrayOfInt);
      if (i != -1)
        return i;
    }
    return -1;
  }

  public static int getLatestAvailableProtocolVersionForService(Context paramContext, int paramInt)
  {
    return getLatestAvailableProtocolVersionForAppInfoList(paramContext, facebookAppInfoList, new int[] { paramInt });
  }

  public static final int getLatestKnownVersion()
  {
    return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
  }

  public static int getProtocolVersionFromIntent(Intent paramIntent)
  {
    return paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
  }

  public static Bundle getSuccessResultsFromIntent(Intent paramIntent)
  {
    int i = getProtocolVersionFromIntent(paramIntent);
    Bundle localBundle = paramIntent.getExtras();
    if ((!isVersionCompatibleWithBucketedIntent(i)) || (localBundle == null))
      return localBundle;
    return localBundle.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
  }

  public static boolean isErrorResult(Intent paramIntent)
  {
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null)
      return localBundle.containsKey("error");
    return paramIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
  }

  public static boolean isVersionCompatibleWithBucketedIntent(int paramInt)
  {
    return (KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(paramInt))) && (paramInt >= 20140701);
  }

  static Intent validateActivityIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null)
      paramIntent = null;
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
      if (localResolveInfo == null)
        return null;
    }
    while (paramNativeAppInfo.validateSignature(paramContext, localResolveInfo.activityInfo.packageName));
    return null;
  }

  static Intent validateServiceIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    if (paramIntent == null)
      paramIntent = null;
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if (localResolveInfo == null)
        return null;
    }
    while (paramNativeAppInfo.validateSignature(paramContext, localResolveInfo.serviceInfo.packageName));
    return null;
  }

  private static class KatanaAppInfo extends NativeProtocol.NativeAppInfo
  {
    static final String KATANA_PACKAGE = "com.facebook.katana";

    private KatanaAppInfo()
    {
      super();
    }

    protected String getPackage()
    {
      return "com.facebook.katana";
    }
  }

  private static class MessengerAppInfo extends NativeProtocol.NativeAppInfo
  {
    static final String MESSENGER_PACKAGE = "com.facebook.orca";

    private MessengerAppInfo()
    {
      super();
    }

    protected String getPackage()
    {
      return "com.facebook.orca";
    }
  }

  private static abstract class NativeAppInfo
  {
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final HashSet<String> validAppSignatureHashes = buildAppSignatureHashes();

    private static HashSet<String> buildAppSignatureHashes()
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
      localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
      localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
      return localHashSet;
    }

    protected abstract String getPackage();

    public boolean validateSignature(Context paramContext, String paramString)
    {
      String str1 = Build.BRAND;
      int i = paramContext.getApplicationInfo().flags;
      if ((str1.startsWith("generic")) && ((i & 0x2) != 0));
      while (true)
      {
        return true;
        try
        {
          PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
          Signature[] arrayOfSignature = localPackageInfo.signatures;
          int j = arrayOfSignature.length;
          for (int k = 0; ; k++)
          {
            if (k >= j)
              break label99;
            String str2 = Utility.sha1hash(arrayOfSignature[k].toByteArray());
            if (validAppSignatureHashes.contains(str2))
              break;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          return false;
        }
      }
      label99: return false;
    }
  }

  private static class WakizashiAppInfo extends NativeProtocol.NativeAppInfo
  {
    static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";

    private WakizashiAppInfo()
    {
      super();
    }

    protected String getPackage()
    {
      return "com.facebook.wakizashi";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol
 * JD-Core Version:    0.6.2
 */