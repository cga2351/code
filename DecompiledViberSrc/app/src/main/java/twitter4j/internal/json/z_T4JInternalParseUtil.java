package twitter4j.internal.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import twitter4j.TwitterException;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public final class z_T4JInternalParseUtil
{
  private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue = new HashMap();

  private z_T4JInternalParseUtil()
  {
    throw new AssertionError();
  }

  public static boolean getBoolean(String paramString, JSONObject paramJSONObject)
  {
    String str = getRawString(paramString, paramJSONObject);
    if ((str == null) || ("null".equals(str)))
      return false;
    return Boolean.valueOf(str).booleanValue();
  }

  // ERROR //
  public static Date getDate(String paramString1, String paramString2)
    throws TwitterException
  {
    // Byte code:
    //   0: getstatic 16	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
    //   3: aload_1
    //   4: invokeinterface 58 2 0
    //   9: checkcast 60	java/util/concurrent/LinkedBlockingQueue
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +150 -> 164
    //   17: new 60	java/util/concurrent/LinkedBlockingQueue
    //   20: dup
    //   21: invokespecial 61	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   24: astore_3
    //   25: getstatic 16	twitter4j/internal/json/z_T4JInternalParseUtil:formatMapQueue	Ljava/util/Map;
    //   28: aload_1
    //   29: aload_3
    //   30: invokeinterface 65 3 0
    //   35: pop
    //   36: aload_3
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 69	java/util/concurrent/LinkedBlockingQueue:poll	()Ljava/lang/Object;
    //   44: checkcast 71	java/text/SimpleDateFormat
    //   47: astore 6
    //   49: aload 6
    //   51: ifnonnull +106 -> 157
    //   54: new 71	java/text/SimpleDateFormat
    //   57: dup
    //   58: aload_1
    //   59: getstatic 77	java/util/Locale:US	Ljava/util/Locale;
    //   62: invokespecial 80	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   65: astore 7
    //   67: aload 7
    //   69: ldc 82
    //   71: invokestatic 88	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   74: invokevirtual 92	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   77: aload 7
    //   79: astore 8
    //   81: aload 8
    //   83: aload_0
    //   84: invokevirtual 96	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   87: astore 12
    //   89: aload 5
    //   91: aload 8
    //   93: invokevirtual 99	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   96: aload 12
    //   98: areturn
    //   99: astore 11
    //   101: new 48	twitter4j/TwitterException
    //   104: dup
    //   105: new 101	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   112: ldc 104
    //   114: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_0
    //   118: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 110
    //   123: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload 11
    //   131: invokespecial 117	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: athrow
    //   135: astore 9
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 99	java/util/concurrent/LinkedBlockingQueue:put	(Ljava/lang/Object;)V
    //   144: aload 9
    //   146: athrow
    //   147: astore 13
    //   149: aload 12
    //   151: areturn
    //   152: astore 10
    //   154: goto -10 -> 144
    //   157: aload 6
    //   159: astore 8
    //   161: goto -80 -> 81
    //   164: aload_2
    //   165: astore 5
    //   167: goto -128 -> 39
    //
    // Exception table:
    //   from	to	target	type
    //   81	89	99	java/text/ParseException
    //   81	89	135	finally
    //   101	135	135	finally
    //   89	96	147	java/lang/InterruptedException
    //   137	144	152	java/lang/InterruptedException
  }

  public static Date getDate(String paramString, JSONObject paramJSONObject)
    throws TwitterException
  {
    return getDate(paramString, paramJSONObject, "EEE MMM d HH:mm:ss z yyyy");
  }

  public static Date getDate(String paramString1, JSONObject paramJSONObject, String paramString2)
    throws TwitterException
  {
    String str = getUnescapedString(paramString1, paramJSONObject);
    if (("null".equals(str)) || (str == null))
      return null;
    return getDate(str, paramString2);
  }

  public static double getDouble(String paramString, JSONObject paramJSONObject)
  {
    String str = getRawString(paramString, paramJSONObject);
    if ((str == null) || ("".equals(str)) || ("null".equals(str)))
      return -1.0D;
    return Double.valueOf(str).doubleValue();
  }

  public static int getInt(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString)))
      return -1;
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1;
  }

  public static int getInt(String paramString, JSONObject paramJSONObject)
  {
    return getInt(getRawString(paramString, paramJSONObject));
  }

  public static long getLong(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString)))
      return -1L;
    if (paramString.endsWith("+"))
      return 1L + Long.valueOf(paramString.substring(0, -1 + paramString.length())).longValue();
    return Long.valueOf(paramString).longValue();
  }

  public static long getLong(String paramString, JSONObject paramJSONObject)
  {
    return getLong(getRawString(paramString, paramJSONObject));
  }

  public static String getRawString(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.isNull(paramString))
        return null;
      String str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  static String getURLDecodedString(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = getRawString(paramString, paramJSONObject);
    if (localObject != null);
    try
    {
      String str = URLDecoder.decode((String)localObject, "UTF-8");
      localObject = str;
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return localObject;
  }

  static String getUnescapedString(String paramString, JSONObject paramJSONObject)
  {
    return HTMLEntity.unescape(getRawString(paramString, paramJSONObject));
  }

  public static Date parseTrendsDate(String paramString)
    throws TwitterException
  {
    switch (paramString.length())
    {
    default:
      return getDate(paramString, "EEE, d MMM yyyy HH:mm:ss z");
    case 10:
      return new Date(1000L * Long.parseLong(paramString));
    case 20:
    }
    return getDate(paramString, "yyyy-MM-dd'T'HH:mm:ss'Z'");
  }

  public static int toAccessLevel(HttpResponse paramHttpResponse)
  {
    int i;
    if (paramHttpResponse == null)
      i = -1;
    String str;
    do
    {
      return i;
      str = paramHttpResponse.getResponseHeader("X-Access-Level");
      i = 0;
    }
    while (str == null);
    switch (str.length())
    {
    default:
      return 0;
    case 4:
      return 1;
    case 10:
      return 2;
    case 25:
      return 3;
    case 26:
    }
    return 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.z_T4JInternalParseUtil
 * JD-Core Version:    0.6.2
 */