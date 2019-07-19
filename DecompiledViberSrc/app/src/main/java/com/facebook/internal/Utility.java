package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Settings;
import com.facebook.model.GraphObject;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility
{
  private static final String APPLICATION_FIELDS = "fields";
  private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
  private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
  private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
  private static final String[] APP_SETTING_FIELDS = { "supports_attribution", "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs" };
  private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
  private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
  private static final String APP_SETTING_SUPPORTS_ATTRIBUTION = "supports_attribution";
  private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
  public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
  private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
  private static final String DIALOG_CONFIG_NAME_KEY = "name";
  private static final String DIALOG_CONFIG_URL_KEY = "url";
  private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
  private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a1";
  private static final String HASH_ALGORITHM_MD5 = "MD5";
  private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
  private static final Logger L = ViberEnv.getLogger("FacebookSDK");
  static final String LOG_TAG = "FacebookSDK";
  private static final String URL_SCHEME = "https";
  private static final String UTF8 = "UTF-8";
  private static Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
  private static AsyncTask<Void, Void, GraphObject> initialAppSettingsLoadTask;

  public static <T> boolean areObjectsEqual(T paramT1, T paramT2)
  {
    if (paramT1 == null)
      return paramT2 == null;
    return paramT1.equals(paramT2);
  }

  public static <T> ArrayList<T> arrayList(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfT.length);
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(paramArrayOfT[j]);
    return localArrayList;
  }

  public static <T> List<T> asListNoNulls(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      T ? = paramArrayOfT[j];
      if (? != null)
        localArrayList.add(?);
    }
    return localArrayList;
  }

  public static Uri buildUri(String paramString1, String paramString2, Bundle paramBundle)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String))
        localBuilder.appendQueryParameter(str, (String)localObject);
    }
    return localBuilder.build();
  }

  public static void clearCaches(Context paramContext)
  {
  }

  private static void clearCookiesForDomain(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext).sync();
    CookieManager localCookieManager = CookieManager.getInstance();
    String str = localCookieManager.getCookie(paramString);
    if (str == null)
      return;
    String[] arrayOfString1 = str.split(";");
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length > 0)
        localCookieManager.setCookie(paramString, arrayOfString2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
    }
    localCookieManager.removeExpiredCookie();
  }

  public static void clearFacebookCookies(Context paramContext)
  {
    clearCookiesForDomain(paramContext, "facebook.com");
    clearCookiesForDomain(paramContext, ".facebook.com");
    clearCookiesForDomain(paramContext, "https://facebook.com");
    clearCookiesForDomain(paramContext, "https://.facebook.com");
  }

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static String coerceValueIfNullOrEmpty(String paramString1, String paramString2)
  {
    if (isNullOrEmpty(paramString1))
      return paramString2;
    return paramString1;
  }

  static Map<String, Object> convertJSONObjectToHashMap(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray = paramJSONObject.names();
    int i = 0;
    while (true)
    {
      if (i < localJSONArray.length());
      try
      {
        String str = localJSONArray.getString(i);
        Object localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject))
          localObject = convertJSONObjectToHashMap((JSONObject)localObject);
        localHashMap.put(str, localObject);
        label65: i++;
        continue;
        return localHashMap;
      }
      catch (JSONException localJSONException)
      {
        break label65;
      }
    }
  }

  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists())
      return;
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        deleteDirectory(arrayOfFile[j]);
    }
    paramFile.delete();
  }

  public static void disconnectQuietly(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof HttpURLConnection))
      ((HttpURLConnection)paramURLConnection).disconnect();
  }

  public static String getActivityName(Context paramContext)
  {
    if (paramContext == null)
      return "null";
    if (paramContext == paramContext.getApplicationContext())
      return "unknown";
    return paramContext.getClass().getSimpleName();
  }

  private static GraphObject getAppSettingsQueryResponse(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fields", TextUtils.join(",", APP_SETTING_FIELDS));
    Request localRequest = Request.newGraphPathRequest(null, paramString, null);
    localRequest.setSkipClientToken(true);
    localRequest.setParameters(localBundle);
    return localRequest.executeAndWait().getGraphObject();
  }

  public static DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3)
  {
    if ((isNullOrEmpty(paramString2)) || (isNullOrEmpty(paramString3)))
      return null;
    FetchedAppSettings localFetchedAppSettings = (FetchedAppSettings)fetchedAppSettings.get(paramString1);
    if (localFetchedAppSettings != null)
    {
      Map localMap = (Map)localFetchedAppSettings.getDialogConfigurations().get(paramString2);
      if (localMap != null)
        return (DialogFeatureConfig)localMap.get(paramString3);
    }
    return null;
  }

  public static String getHashedDeviceAndAppID(Context paramContext, String paramString)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (str == null)
      return null;
    return sha1hash(str + paramString);
  }

  public static String getMetadataApplicationId(Context paramContext)
  {
    Validate.notNull(paramContext, "context");
    Settings.loadDefaultsFromMetadata(paramContext);
    return Settings.getApplicationId();
  }

  public static Method getMethodQuietly(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public static Method getMethodQuietly(String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = getMethodQuietly(Class.forName(paramString1), paramString2, paramArrayOfClass);
      return localMethod;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws JSONException
  {
    Object localObject1 = paramJSONObject.opt(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof String)));
    for (Object localObject2 = new JSONTokener((String)localObject1).nextValue(); ; localObject2 = localObject1)
    {
      if ((localObject2 != null) && (!(localObject2 instanceof JSONObject)) && (!(localObject2 instanceof JSONArray)))
      {
        if (paramString2 != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.putOpt(paramString2, localObject2);
          return localJSONObject;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
      }
      return localObject2;
    }
  }

  private static String hashBytes(MessageDigest paramMessageDigest, byte[] paramArrayOfByte)
  {
    paramMessageDigest.update(paramArrayOfByte);
    byte[] arrayOfByte = paramMessageDigest.digest();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = arrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfByte[j];
      localStringBuilder.append(Integer.toHexString(0xF & k >> 4));
      localStringBuilder.append(Integer.toHexString(0xF & k >> 0));
    }
    return localStringBuilder.toString();
  }

  private static String hashWithAlgorithm(String paramString1, String paramString2)
  {
    return hashWithAlgorithm(paramString1, paramString2.getBytes());
  }

  private static String hashWithAlgorithm(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
      return hashBytes(localMessageDigest, paramArrayOfByte);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }

  public static int[] intersectRanges(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    if (paramArrayOfInt1 == null)
      return paramArrayOfInt2;
    if (paramArrayOfInt2 == null)
      return paramArrayOfInt1;
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    int j = 0;
    int k = 0;
    int m;
    int n;
    if ((j < paramArrayOfInt1.length) && (i < paramArrayOfInt2.length))
    {
      m = paramArrayOfInt1[j];
      n = paramArrayOfInt2[i];
      if (j >= -1 + paramArrayOfInt1.length)
        break label250;
    }
    label229: label231: label250: for (int i1 = paramArrayOfInt1[(j + 1)]; ; i1 = 2147483647)
    {
      if (i < -1 + paramArrayOfInt2.length);
      for (int i2 = paramArrayOfInt2[(i + 1)]; ; i2 = 2147483647)
      {
        if (m < n)
          if (i1 > n)
            if (i1 > i2)
              i += 2;
        int i3;
        while (true)
        {
          if (n == -2147483648)
            break label229;
          i3 = k + 1;
          arrayOfInt[k] = n;
          if (i2 == 2147483647)
            break label231;
          k = i3 + 1;
          arrayOfInt[i3] = i2;
          break;
          j += 2;
          i2 = i1;
          continue;
          j += 2;
          i2 = 2147483647;
          n = -2147483648;
          continue;
          if (i2 > m)
          {
            if (i2 > i1)
            {
              j += 2;
              i2 = i1;
              n = m;
            }
            else
            {
              i += 2;
              n = m;
            }
          }
          else
          {
            i += 2;
            i2 = 2147483647;
            n = -2147483648;
          }
        }
        break;
        k = i3;
        return Arrays.copyOf(arrayOfInt, k);
      }
    }
  }

  public static Object invokeMethodQuietly(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    return null;
  }

  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public static <T> boolean isNullOrEmpty(Collection<T> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }

  public static <T> boolean isSubset(Collection<T> paramCollection1, Collection<T> paramCollection2)
  {
    if ((paramCollection2 == null) || (paramCollection2.size() == 0))
    {
      boolean bool;
      if (paramCollection1 != null)
      {
        int i = paramCollection1.size();
        bool = false;
        if (i != 0);
      }
      else
      {
        bool = true;
      }
      return bool;
    }
    HashSet localHashSet = new HashSet(paramCollection2);
    Iterator localIterator = paramCollection1.iterator();
    while (localIterator.hasNext())
      if (!localHashSet.contains(localIterator.next()))
        return false;
    return true;
  }

  public static void loadAppSettingsAsync(final Context paramContext, String paramString)
  {
    if ((isNullOrEmpty(paramString)) || (fetchedAppSettings.containsKey(paramString)) || (initialAppSettingsLoadTask != null));
    while (true)
    {
      return;
      final String str1 = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[] { paramString });
      initialAppSettingsLoadTask = new AsyncTask()
      {
        protected GraphObject doInBackground(Void[] paramAnonymousArrayOfVoid)
        {
          return Utility.getAppSettingsQueryResponse(this.val$applicationId);
        }

        protected void onPostExecute(GraphObject paramAnonymousGraphObject)
        {
          if (paramAnonymousGraphObject != null)
          {
            JSONObject localJSONObject = paramAnonymousGraphObject.getInnerJSONObject();
            Utility.parseAppSettingsFromJSON(this.val$applicationId, localJSONObject);
            paramContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).edit().putString(str1, localJSONObject.toString()).apply();
          }
          Utility.access$202(null);
        }
      };
      initialAppSettingsLoadTask.execute((Void[])null);
      String str2 = paramContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0).getString(str1, null);
      if (isNullOrEmpty(str2))
        continue;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(str2);
        localJSONObject2 = localJSONObject1;
        if (localJSONObject2 == null)
          continue;
        parseAppSettingsFromJSON(paramString, localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          logd("FacebookSDK", localJSONException);
          JSONObject localJSONObject2 = null;
        }
      }
    }
  }

  public static void logd(String paramString, Exception paramException)
  {
    if ((Settings.isDebugEnabled()) && (paramString != null) && (paramException != null))
      L.b(paramException, null, new Object[0]);
  }

  public static void logd(String paramString1, String paramString2)
  {
    if ((Settings.isDebugEnabled()) && (paramString1 != null) && (paramString2 != null))
      L.b("?", new Object[] { paramString2 });
  }

  public static void logd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((Settings.isDebugEnabled()) && (!isNullOrEmpty(paramString1)))
      L.b(paramThrowable, "?", new Object[] { paramString2 });
  }

  static String md5hash(String paramString)
  {
    return hashWithAlgorithm("MD5", paramString);
  }

  private static FetchedAppSettings parseAppSettingsFromJSON(String paramString, JSONObject paramJSONObject)
  {
    FetchedAppSettings localFetchedAppSettings = new FetchedAppSettings(paramJSONObject.optBoolean("supports_attribution", false), paramJSONObject.optBoolean("supports_implicit_sdk_logging", false), paramJSONObject.optString("gdpv4_nux_content", ""), paramJSONObject.optBoolean("gdpv4_nux_enabled", false), parseDialogConfigurations(paramJSONObject.optJSONObject("android_dialog_configs")), null);
    fetchedAppSettings.put(paramString, localFetchedAppSettings);
    return localFetchedAppSettings;
  }

  private static Map<String, Map<String, DialogFeatureConfig>> parseDialogConfigurations(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("data");
      if (localJSONArray != null)
      {
        int i = 0;
        if (i < localJSONArray.length())
        {
          DialogFeatureConfig localDialogFeatureConfig = DialogFeatureConfig.parseDialogConfig(localJSONArray.optJSONObject(i));
          if (localDialogFeatureConfig == null);
          while (true)
          {
            i++;
            break;
            String str = localDialogFeatureConfig.getDialogName();
            Object localObject = (Map)localHashMap.get(str);
            if (localObject == null)
            {
              localObject = new HashMap();
              localHashMap.put(str, localObject);
            }
            ((Map)localObject).put(localDialogFeatureConfig.getFeatureName(), localDialogFeatureConfig);
          }
        }
      }
    }
    return localHashMap;
  }

  public static Bundle parseUrlQueryString(String paramString)
  {
    Bundle localBundle = new Bundle();
    String[] arrayOfString1;
    int i;
    if (!isNullOrEmpty(paramString))
    {
      arrayOfString1 = paramString.split("&");
      i = arrayOfString1.length;
    }
    for (int j = 0; ; j++)
      if (j < i)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        try
        {
          if (arrayOfString2.length == 2)
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
          else if (arrayOfString2.length == 1)
            localBundle.putString(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          logd("FacebookSDK", localUnsupportedEncodingException);
        }
      }
      else
      {
        return localBundle;
      }
  }

  public static void putObjectInBundle(Bundle paramBundle, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      return;
    }
    throw new FacebookException("attempted to add unsupported type to Bundle");
  }

  public static FetchedAppSettings queryAppSettings(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (fetchedAppSettings.containsKey(paramString)))
      return (FetchedAppSettings)fetchedAppSettings.get(paramString);
    GraphObject localGraphObject = getAppSettingsQueryResponse(paramString);
    if (localGraphObject == null)
      return null;
    return parseAppSettingsFromJSON(paramString, localGraphObject.getInnerJSONObject());
  }

  // ERROR //
  public static String readStreamToString(java.io.InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 659	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 662	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_1
    //   9: new 664	java/io/InputStreamReader
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 665	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 209	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   25: astore_3
    //   26: sipush 2048
    //   29: newarray char
    //   31: astore 6
    //   33: aload_2
    //   34: aload 6
    //   36: invokevirtual 669	java/io/InputStreamReader:read	([C)I
    //   39: istore 7
    //   41: iload 7
    //   43: iconst_m1
    //   44: if_icmpeq +33 -> 77
    //   47: aload_3
    //   48: aload 6
    //   50: iconst_0
    //   51: iload 7
    //   53: invokevirtual 672	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -24 -> 33
    //   60: astore 4
    //   62: aload_1
    //   63: astore 5
    //   65: aload 5
    //   67: invokestatic 674	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: invokestatic 674	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   74: aload 4
    //   76: athrow
    //   77: aload_3
    //   78: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 9
    //   83: aload_1
    //   84: invokestatic 674	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   87: aload_2
    //   88: invokestatic 674	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   91: aload 9
    //   93: areturn
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_2
    //   98: aconst_null
    //   99: astore 5
    //   101: goto -36 -> 65
    //   104: astore 4
    //   106: aload_1
    //   107: astore 5
    //   109: aconst_null
    //   110: astore_2
    //   111: goto -46 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   18	33	60	finally
    //   33	41	60	finally
    //   47	57	60	finally
    //   77	83	60	finally
    //   0	9	94	finally
    //   9	18	104	finally
  }

  public static boolean safeGetBooleanFromResponse(GraphObject paramGraphObject, String paramString)
  {
    Object localObject = Boolean.valueOf(false);
    if (paramGraphObject != null)
      localObject = paramGraphObject.getProperty(paramString);
    if (!(localObject instanceof Boolean))
      localObject = Boolean.valueOf(false);
    return ((Boolean)localObject).booleanValue();
  }

  public static String safeGetStringFromResponse(GraphObject paramGraphObject, String paramString)
  {
    Object localObject = "";
    if (paramGraphObject != null)
      localObject = paramGraphObject.getProperty(paramString);
    if (!(localObject instanceof String))
      localObject = "";
    return (String)localObject;
  }

  public static void setAppEventAttributionParameters(GraphObject paramGraphObject, AttributionIdentifiers paramAttributionIdentifiers, String paramString, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAttributionId() != null))
      paramGraphObject.setProperty("attribution", paramAttributionIdentifiers.getAttributionId());
    boolean bool2;
    if ((paramAttributionIdentifiers != null) && (paramAttributionIdentifiers.getAndroidAdvertiserId() != null))
    {
      paramGraphObject.setProperty("advertiser_id", paramAttributionIdentifiers.getAndroidAdvertiserId());
      if (!paramAttributionIdentifiers.isTrackingLimited())
      {
        bool2 = bool1;
        paramGraphObject.setProperty("advertiser_tracking_enabled", Boolean.valueOf(bool2));
        label76: if (paramBoolean)
          break label118;
      }
    }
    while (true)
    {
      paramGraphObject.setProperty("application_tracking_enabled", Boolean.valueOf(bool1));
      return;
      bool2 = false;
      break;
      if (paramString == null)
        break label76;
      paramGraphObject.setProperty("advertiser_id", paramString);
      break label76;
      label118: bool1 = false;
    }
  }

  public static void setAppEventExtendedDeviceInfoParameters(GraphObject paramGraphObject, Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("a1");
    String str1 = paramContext.getPackageName();
    int i = -1;
    String str2 = "";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str1, 0);
      i = localPackageInfo.versionCode;
      str2 = localPackageInfo.versionName;
      label55: localJSONArray.put(str1);
      localJSONArray.put(i);
      localJSONArray.put(str2);
      paramGraphObject.setProperty("extinfo", localJSONArray.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label55;
    }
  }

  static String sha1hash(String paramString)
  {
    return hashWithAlgorithm("SHA-1", paramString);
  }

  static String sha1hash(byte[] paramArrayOfByte)
  {
    return hashWithAlgorithm("SHA-1", paramArrayOfByte);
  }

  public static boolean stringsEqualOrEmpty(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((bool1) && (bool2))
      return true;
    if ((!bool1) && (!bool2))
      return paramString1.equals(paramString2);
    return false;
  }

  public static JSONArray tryGetJSONArrayFromResponse(GraphObject paramGraphObject, String paramString)
  {
    if (paramGraphObject == null)
      return null;
    Object localObject = paramGraphObject.getProperty(paramString);
    if (!(localObject instanceof JSONArray))
      return null;
    return (JSONArray)localObject;
  }

  public static JSONObject tryGetJSONObjectFromResponse(GraphObject paramGraphObject, String paramString)
  {
    if (paramGraphObject == null)
      return null;
    Object localObject = paramGraphObject.getProperty(paramString);
    if (!(localObject instanceof JSONObject))
      return null;
    return (JSONObject)localObject;
  }

  public static <T> Collection<T> unmodifiableCollection(T[] paramArrayOfT)
  {
    return Collections.unmodifiableCollection(Arrays.asList(paramArrayOfT));
  }

  public static class DialogFeatureConfig
  {
    private String dialogName;
    private Uri fallbackUrl;
    private String featureName;
    private int[] featureVersionSpec;

    private DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
    {
      this.dialogName = paramString1;
      this.featureName = paramString2;
      this.fallbackUrl = paramUri;
      this.featureVersionSpec = paramArrayOfInt;
    }

    private static DialogFeatureConfig parseDialogConfig(JSONObject paramJSONObject)
    {
      String str1 = paramJSONObject.optString("name");
      if (Utility.isNullOrEmpty(str1));
      String str2;
      String str3;
      do
      {
        String[] arrayOfString;
        do
        {
          return null;
          arrayOfString = str1.split("\\|");
        }
        while (arrayOfString.length != 2);
        str2 = arrayOfString[0];
        str3 = arrayOfString[1];
      }
      while ((Utility.isNullOrEmpty(str2)) || (Utility.isNullOrEmpty(str3)));
      String str4 = paramJSONObject.optString("url");
      boolean bool = Utility.isNullOrEmpty(str4);
      Uri localUri = null;
      if (!bool)
        localUri = Uri.parse(str4);
      return new DialogFeatureConfig(str2, str3, localUri, parseVersionSpec(paramJSONObject.optJSONArray("versions")));
    }

    private static int[] parseVersionSpec(JSONArray paramJSONArray)
    {
      Object localObject = null;
      if (paramJSONArray != null)
      {
        int i = paramJSONArray.length();
        int[] arrayOfInt = new int[i];
        int j = 0;
        while (true)
          if (j < i)
          {
            int k = paramJSONArray.optInt(j, -1);
            String str;
            if (k == -1)
            {
              str = paramJSONArray.optString(j);
              if (Utility.isNullOrEmpty(str));
            }
            try
            {
              int m = Integer.parseInt(str);
              k = m;
              arrayOfInt[j] = k;
              j++;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              while (true)
              {
                Utility.logd("FacebookSDK", localNumberFormatException);
                k = -1;
              }
            }
          }
        localObject = arrayOfInt;
      }
      return localObject;
    }

    public String getDialogName()
    {
      return this.dialogName;
    }

    public Uri getFallbackUrl()
    {
      return this.fallbackUrl;
    }

    public String getFeatureName()
    {
      return this.featureName;
    }

    public int[] getVersionSpec()
    {
      return this.featureVersionSpec;
    }
  }

  public static class FetchedAppSettings
  {
    private Map<String, Map<String, Utility.DialogFeatureConfig>> dialogConfigMap;
    private String nuxContent;
    private boolean nuxEnabled;
    private boolean supportsAttribution;
    private boolean supportsImplicitLogging;

    private FetchedAppSettings(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, Map<String, Map<String, Utility.DialogFeatureConfig>> paramMap)
    {
      this.supportsAttribution = paramBoolean1;
      this.supportsImplicitLogging = paramBoolean2;
      this.nuxContent = paramString;
      this.nuxEnabled = paramBoolean3;
      this.dialogConfigMap = paramMap;
    }

    public Map<String, Map<String, Utility.DialogFeatureConfig>> getDialogConfigurations()
    {
      return this.dialogConfigMap;
    }

    public String getNuxContent()
    {
      return this.nuxContent;
    }

    public boolean getNuxEnabled()
    {
      return this.nuxEnabled;
    }

    public boolean supportsAttribution()
    {
      return this.supportsAttribution;
    }

    public boolean supportsImplicitLogging()
    {
      return this.supportsImplicitLogging;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.internal.Utility
 * JD-Core Version:    0.6.2
 */