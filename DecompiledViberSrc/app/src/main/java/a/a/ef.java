package a.a;

import android.net.TrafficStats;
import com.appboy.f.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public final class ef
  implements fg
{
  private static final String a = c.a(ef.class);
  private static final int b = (int)TimeUnit.SECONDS.toMillis(30L);
  private final int c;

  public ef(int paramInt)
  {
    this.c = paramInt;
  }

  private InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.connect();
    int i = paramHttpURLConnection.getResponseCode();
    if (i / 100 == 2)
    {
      if ("gzip".equalsIgnoreCase(paramHttpURLConnection.getContentEncoding()))
        return new GZIPInputStream(paramHttpURLConnection.getInputStream());
      return new BufferedInputStream(paramHttpURLConnection.getInputStream());
    }
    throw new w("Bad Http response code from Appboy: [" + i + "]");
  }

  private String a(BufferedReader paramBufferedReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      String str = paramBufferedReader.readLine();
      if (str == null)
        break;
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  private JSONObject a(URI paramURI, JSONObject paramJSONObject, Map<String, String> paramMap, gu paramgu)
  {
    URL localURL = dp.a(paramURI);
    Object localObject = null;
    if (localURL != null);
    try
    {
      JSONObject localJSONObject = a(localURL, paramJSONObject, paramMap, paramgu);
      localObject = localJSONObject;
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new w("Experienced IOException during request to [" + localURL.toString() + "], failing: [" + localIOException.getMessage() + "]", localIOException);
    }
  }

  // ERROR //
  private JSONObject a(URL paramURL, JSONObject paramJSONObject, Map<String, String> paramMap, gu paramgu)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +334 -> 335
    //   4: aload_0
    //   5: aload_1
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokespecial 133	a/a/ef:b	(Ljava/net/URL;Lorg/json/JSONObject;Ljava/util/Map;La/a/gu;)Ljava/net/HttpURLConnection;
    //   13: astore 24
    //   15: aload 24
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +308 -> 329
    //   24: aload_0
    //   25: aload 5
    //   27: invokespecial 135	a/a/ef:a	(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   30: astore 15
    //   32: aload 15
    //   34: astore 6
    //   36: new 99	java/io/BufferedReader
    //   39: dup
    //   40: new 137	java/io/InputStreamReader
    //   43: dup
    //   44: aload 6
    //   46: ldc 139
    //   48: invokespecial 142	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: invokespecial 145	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore 16
    //   56: new 147	org/json/JSONObject
    //   59: dup
    //   60: aload_0
    //   61: aload 16
    //   63: invokespecial 149	a/a/ef:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   66: invokespecial 150	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 17
    //   71: aload 5
    //   73: ifnull +8 -> 81
    //   76: aload 5
    //   78: invokevirtual 153	java/net/HttpURLConnection:disconnect	()V
    //   81: aload 6
    //   83: ifnull +8 -> 91
    //   86: aload 6
    //   88: invokevirtual 158	java/io/InputStream:close	()V
    //   91: aload 17
    //   93: areturn
    //   94: astore 18
    //   96: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   99: ldc 160
    //   101: aload 18
    //   103: invokestatic 164	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: aload 17
    //   109: areturn
    //   110: astore 22
    //   112: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   115: new 78	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   122: ldc 166
    //   124: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 22
    //   129: invokevirtual 123	java/io/IOException:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 90
    //   137: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aload 22
    //   145: invokestatic 164	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: aload 5
    //   151: ifnull +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 153	java/net/HttpURLConnection:disconnect	()V
    //   159: aload 6
    //   161: ifnull +8 -> 169
    //   164: aload 6
    //   166: invokevirtual 158	java/io/InputStream:close	()V
    //   169: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   172: new 78	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   179: ldc 168
    //   181: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: ldc 173
    //   190: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 176	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: aconst_null
    //   201: areturn
    //   202: astore 20
    //   204: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   207: new 78	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   214: ldc 178
    //   216: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 20
    //   221: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: ldc 90
    //   226: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aload 20
    //   234: invokestatic 164	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: goto -89 -> 149
    //   241: astore 10
    //   243: aload 6
    //   245: astore 12
    //   247: aload 5
    //   249: astore 11
    //   251: aload 11
    //   253: ifnull +8 -> 261
    //   256: aload 11
    //   258: invokevirtual 153	java/net/HttpURLConnection:disconnect	()V
    //   261: aload 12
    //   263: ifnull +8 -> 271
    //   266: aload 12
    //   268: invokevirtual 158	java/io/InputStream:close	()V
    //   271: aload 10
    //   273: athrow
    //   274: astore 8
    //   276: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   279: ldc 160
    //   281: aload 8
    //   283: invokestatic 164	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   286: pop
    //   287: goto -118 -> 169
    //   290: astore 13
    //   292: getstatic 20	a/a/ef:a	Ljava/lang/String;
    //   295: ldc 160
    //   297: aload 13
    //   299: invokestatic 164	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   302: pop
    //   303: goto -32 -> 271
    //   306: astore 10
    //   308: aconst_null
    //   309: astore 12
    //   311: aconst_null
    //   312: astore 11
    //   314: goto -63 -> 251
    //   317: astore 10
    //   319: aload 5
    //   321: astore 11
    //   323: aconst_null
    //   324: astore 12
    //   326: goto -75 -> 251
    //   329: aconst_null
    //   330: astore 6
    //   332: goto -183 -> 149
    //   335: aconst_null
    //   336: astore 5
    //   338: goto -319 -> 19
    //
    // Exception table:
    //   from	to	target	type
    //   86	91	94	java/lang/Exception
    //   56	71	110	java/io/IOException
    //   56	71	202	org/json/JSONException
    //   36	56	241	finally
    //   56	71	241	finally
    //   112	149	241	finally
    //   204	238	241	finally
    //   164	169	274	java/lang/Exception
    //   266	271	290	java/lang/Exception
    //   4	15	306	finally
    //   24	32	317	finally
  }

  private void a(HttpURLConnection paramHttpURLConnection, JSONObject paramJSONObject)
  {
    TrafficStats.setThreadStatsTag(1337);
    paramHttpURLConnection.setDoOutput(true);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
    localBufferedOutputStream.write(paramJSONObject.toString().getBytes("UTF-8"));
    localBufferedOutputStream.flush();
    localBufferedOutputStream.close();
  }

  private HttpURLConnection b(URL paramURL, JSONObject paramJSONObject, Map<String, String> paramMap, gu paramgu)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)gh.a(paramURL);
      localHttpURLConnection.setConnectTimeout(b);
      localHttpURLConnection.setReadTimeout(this.c);
      localHttpURLConnection.setInstanceFollowRedirects(false);
      localHttpURLConnection.setRequestMethod(paramgu.toString());
      a(localHttpURLConnection, paramMap);
      if (paramgu == gu.b)
        a(localHttpURLConnection, paramJSONObject);
      return localHttpURLConnection;
    }
    catch (IOException localIOException)
    {
      throw new w("Could not set up connection [" + paramURL.toString() + "] [" + localIOException.getMessage() + "].  Appboy will try to reconnect periodically.", localIOException);
    }
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap)
  {
    return a(paramURI, null, paramMap, gu.a);
  }

  public JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    return a(paramURI, paramJSONObject, paramMap, gu.b);
  }

  void a(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ef
 * JD-Core Version:    0.6.2
 */