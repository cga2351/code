package twitter4j.internal.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONObject;

public abstract class HttpResponse
{
  private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
  protected final HttpClientConfiguration CONF;
  protected InputStream is;
  private JSONObject json = null;
  private JSONArray jsonArray = null;
  protected String responseAsString = null;
  protected int statusCode;
  private boolean streamConsumed = false;

  HttpResponse()
  {
    this.CONF = ConfigurationContext.getInstance();
  }

  public HttpResponse(HttpClientConfiguration paramHttpClientConfiguration)
  {
    this.CONF = paramHttpClientConfiguration;
  }

  private void disconnectForcibly()
  {
    try
    {
      disconnect();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public JSONArray asJSONArray()
    throws twitter4j.TwitterException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   4: ifnonnull +80 -> 84
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_1
    //   17: aload 5
    //   19: ifnonnull +70 -> 89
    //   22: aload_0
    //   23: invokevirtual 70	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
    //   26: astore_1
    //   27: aload_0
    //   28: new 72	twitter4j/internal/org/json/JSONArray
    //   31: dup
    //   32: new 74	twitter4j/internal/org/json/JSONTokener
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 77	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
    //   40: invokespecial 80	twitter4j/internal/org/json/JSONArray:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
    //   43: putfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   46: aload_0
    //   47: getfield 51	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   50: invokeinterface 86 1 0
    //   55: ifeq +120 -> 175
    //   58: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   61: aload_0
    //   62: getfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   65: iconst_1
    //   66: invokevirtual 90	twitter4j/internal/org/json/JSONArray:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 94	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 99	java/io/Reader:close	()V
    //   80: aload_0
    //   81: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   84: aload_0
    //   85: getfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   88: areturn
    //   89: aload_0
    //   90: new 72	twitter4j/internal/org/json/JSONArray
    //   93: dup
    //   94: aload_0
    //   95: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   98: invokespecial 103	twitter4j/internal/org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   101: putfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   104: aconst_null
    //   105: astore_1
    //   106: goto -60 -> 46
    //   109: astore 4
    //   111: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   114: invokevirtual 106	twitter4j/internal/logging/Logger:isDebugEnabled	()Z
    //   117: ifeq +102 -> 219
    //   120: new 62	twitter4j/TwitterException
    //   123: dup
    //   124: new 108	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   131: aload 4
    //   133: invokevirtual 113	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 119
    //   141: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   148: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload 4
    //   156: invokespecial 124	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: athrow
    //   160: astore_2
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 99	java/io/Reader:close	()V
    //   169: aload_0
    //   170: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   173: aload_2
    //   174: athrow
    //   175: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   178: astore 6
    //   180: aload_0
    //   181: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   184: ifnull +19 -> 203
    //   187: aload_0
    //   188: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   191: astore 8
    //   193: aload 6
    //   195: aload 8
    //   197: invokevirtual 94	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   200: goto -128 -> 72
    //   203: aload_0
    //   204: getfield 43	twitter4j/internal/http/HttpResponse:jsonArray	Ltwitter4j/internal/org/json/JSONArray;
    //   207: invokevirtual 125	twitter4j/internal/org/json/JSONArray:toString	()Ljava/lang/String;
    //   210: astore 7
    //   212: aload 7
    //   214: astore 8
    //   216: goto -23 -> 193
    //   219: new 62	twitter4j/TwitterException
    //   222: dup
    //   223: aload 4
    //   225: invokevirtual 113	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
    //   228: aload 4
    //   230: invokespecial 124	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: athrow
    //   234: astore 9
    //   236: goto -156 -> 80
    //   239: astore_3
    //   240: goto -71 -> 169
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	109	twitter4j/internal/org/json/JSONException
    //   22	46	109	twitter4j/internal/org/json/JSONException
    //   46	72	109	twitter4j/internal/org/json/JSONException
    //   89	104	109	twitter4j/internal/org/json/JSONException
    //   175	193	109	twitter4j/internal/org/json/JSONException
    //   193	200	109	twitter4j/internal/org/json/JSONException
    //   203	212	109	twitter4j/internal/org/json/JSONException
    //   9	15	160	finally
    //   22	46	160	finally
    //   46	72	160	finally
    //   89	104	160	finally
    //   111	160	160	finally
    //   175	193	160	finally
    //   193	200	160	finally
    //   203	212	160	finally
    //   219	234	160	finally
    //   76	80	234	java/io/IOException
    //   165	169	239	java/io/IOException
  }

  // ERROR //
  public JSONObject asJSONObject()
    throws twitter4j.TwitterException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   4: ifnonnull +80 -> 84
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_1
    //   17: aload 5
    //   19: ifnonnull +70 -> 89
    //   22: aload_0
    //   23: invokevirtual 70	twitter4j/internal/http/HttpResponse:asReader	()Ljava/io/Reader;
    //   26: astore_1
    //   27: aload_0
    //   28: new 129	twitter4j/internal/org/json/JSONObject
    //   31: dup
    //   32: new 74	twitter4j/internal/org/json/JSONTokener
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 77	twitter4j/internal/org/json/JSONTokener:<init>	(Ljava/io/Reader;)V
    //   40: invokespecial 130	twitter4j/internal/org/json/JSONObject:<init>	(Ltwitter4j/internal/org/json/JSONTokener;)V
    //   43: putfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   46: aload_0
    //   47: getfield 51	twitter4j/internal/http/HttpResponse:CONF	Ltwitter4j/internal/http/HttpClientConfiguration;
    //   50: invokeinterface 86 1 0
    //   55: ifeq +93 -> 148
    //   58: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   61: aload_0
    //   62: getfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   65: iconst_1
    //   66: invokevirtual 131	twitter4j/internal/org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 94	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 99	java/io/Reader:close	()V
    //   80: aload_0
    //   81: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   84: aload_0
    //   85: getfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   88: areturn
    //   89: aload_0
    //   90: new 129	twitter4j/internal/org/json/JSONObject
    //   93: dup
    //   94: aload_0
    //   95: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   98: invokespecial 132	twitter4j/internal/org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   101: putfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   104: aconst_null
    //   105: astore_1
    //   106: goto -60 -> 46
    //   109: astore 4
    //   111: aload_0
    //   112: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   115: ifnonnull +77 -> 192
    //   118: new 62	twitter4j/TwitterException
    //   121: dup
    //   122: aload 4
    //   124: invokevirtual 113	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
    //   127: aload 4
    //   129: invokespecial 124	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: athrow
    //   133: astore_2
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 99	java/io/Reader:close	()V
    //   142: aload_0
    //   143: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   146: aload_2
    //   147: athrow
    //   148: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   151: astore 6
    //   153: aload_0
    //   154: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   157: ifnull +19 -> 176
    //   160: aload_0
    //   161: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   164: astore 8
    //   166: aload 6
    //   168: aload 8
    //   170: invokevirtual 94	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   173: goto -101 -> 72
    //   176: aload_0
    //   177: getfield 41	twitter4j/internal/http/HttpResponse:json	Ltwitter4j/internal/org/json/JSONObject;
    //   180: invokevirtual 133	twitter4j/internal/org/json/JSONObject:toString	()Ljava/lang/String;
    //   183: astore 7
    //   185: aload 7
    //   187: astore 8
    //   189: goto -23 -> 166
    //   192: new 62	twitter4j/TwitterException
    //   195: dup
    //   196: new 108	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   203: aload 4
    //   205: invokevirtual 113	twitter4j/internal/org/json/JSONException:getMessage	()Ljava/lang/String;
    //   208: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 119
    //   213: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   220: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aload 4
    //   228: invokespecial 124	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: athrow
    //   232: astore 9
    //   234: goto -154 -> 80
    //   237: astore_3
    //   238: goto -96 -> 142
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	109	twitter4j/internal/org/json/JSONException
    //   22	46	109	twitter4j/internal/org/json/JSONException
    //   46	72	109	twitter4j/internal/org/json/JSONException
    //   89	104	109	twitter4j/internal/org/json/JSONException
    //   148	166	109	twitter4j/internal/org/json/JSONException
    //   166	173	109	twitter4j/internal/org/json/JSONException
    //   176	185	109	twitter4j/internal/org/json/JSONException
    //   9	15	133	finally
    //   22	46	133	finally
    //   46	72	133	finally
    //   89	104	133	finally
    //   111	133	133	finally
    //   148	166	133	finally
    //   166	173	133	finally
    //   176	185	133	finally
    //   192	232	133	finally
    //   76	80	232	java/io/IOException
    //   138	142	237	java/io/IOException
  }

  public Reader asReader()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.is, "UTF-8"));
      return localBufferedReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new InputStreamReader(this.is);
  }

  public InputStream asStream()
  {
    if (this.streamConsumed)
      throw new IllegalStateException("Stream has already been consumed.");
    return this.is;
  }

  // ERROR //
  public String asString()
    throws twitter4j.TwitterException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   4: ifnonnull +217 -> 221
    //   7: aload_0
    //   8: invokevirtual 160	twitter4j/internal/http/HttpResponse:asStream	()Ljava/io/InputStream;
    //   11: astore 12
    //   13: aload 12
    //   15: astore 8
    //   17: aload 8
    //   19: ifnonnull +27 -> 46
    //   22: aload 8
    //   24: ifnull +8 -> 32
    //   27: aload 8
    //   29: invokevirtual 163	java/io/InputStream:close	()V
    //   32: iconst_0
    //   33: ifeq +7 -> 40
    //   36: aconst_null
    //   37: invokevirtual 164	java/io/BufferedReader:close	()V
    //   40: aload_0
    //   41: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 137	java/io/BufferedReader
    //   49: dup
    //   50: new 139	java/io/InputStreamReader
    //   53: dup
    //   54: aload 8
    //   56: ldc 143
    //   58: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   61: invokespecial 147	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   64: astore 7
    //   66: new 108	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   73: astore 13
    //   75: aload 7
    //   77: invokevirtual 167	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore 15
    //   82: aload 15
    //   84: ifnull +84 -> 168
    //   87: aload 13
    //   89: aload 15
    //   91: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 169
    //   96: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: goto -25 -> 75
    //   103: astore_2
    //   104: aload 8
    //   106: astore 14
    //   108: aload 7
    //   110: astore 4
    //   112: aload 14
    //   114: astore_3
    //   115: new 62	twitter4j/TwitterException
    //   118: dup
    //   119: aload_2
    //   120: invokevirtual 170	java/io/IOException:getMessage	()Ljava/lang/String;
    //   123: aload_2
    //   124: invokespecial 124	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: athrow
    //   128: astore 5
    //   130: aload_3
    //   131: astore 6
    //   133: aload 4
    //   135: astore 7
    //   137: aload 6
    //   139: astore 8
    //   141: aload 8
    //   143: ifnull +8 -> 151
    //   146: aload 8
    //   148: invokevirtual 163	java/io/InputStream:close	()V
    //   151: aload 7
    //   153: ifnull +8 -> 161
    //   156: aload 7
    //   158: invokevirtual 164	java/io/BufferedReader:close	()V
    //   161: aload_0
    //   162: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   165: aload 5
    //   167: athrow
    //   168: aload_0
    //   169: aload 13
    //   171: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: putfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   177: getstatic 32	twitter4j/internal/http/HttpResponse:logger	Ltwitter4j/internal/logging/Logger;
    //   180: aload_0
    //   181: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   184: invokevirtual 94	twitter4j/internal/logging/Logger:debug	(Ljava/lang/String;)V
    //   187: aload 8
    //   189: invokevirtual 163	java/io/InputStream:close	()V
    //   192: aload_0
    //   193: iconst_1
    //   194: putfield 39	twitter4j/internal/http/HttpResponse:streamConsumed	Z
    //   197: aload 8
    //   199: ifnull +8 -> 207
    //   202: aload 8
    //   204: invokevirtual 163	java/io/InputStream:close	()V
    //   207: aload 7
    //   209: ifnull +8 -> 217
    //   212: aload 7
    //   214: invokevirtual 164	java/io/BufferedReader:close	()V
    //   217: aload_0
    //   218: invokespecial 101	twitter4j/internal/http/HttpResponse:disconnectForcibly	()V
    //   221: aload_0
    //   222: getfield 37	twitter4j/internal/http/HttpResponse:responseAsString	Ljava/lang/String;
    //   225: areturn
    //   226: astore 22
    //   228: goto -196 -> 32
    //   231: astore 21
    //   233: goto -193 -> 40
    //   236: astore 18
    //   238: goto -31 -> 207
    //   241: astore 17
    //   243: goto -26 -> 217
    //   246: astore 10
    //   248: goto -97 -> 151
    //   251: astore 9
    //   253: goto -92 -> 161
    //   256: astore 11
    //   258: aload 11
    //   260: astore 5
    //   262: aconst_null
    //   263: astore 7
    //   265: aconst_null
    //   266: astore 8
    //   268: goto -127 -> 141
    //   271: astore 20
    //   273: aload 20
    //   275: astore 5
    //   277: aconst_null
    //   278: astore 7
    //   280: goto -139 -> 141
    //   283: astore 5
    //   285: goto -144 -> 141
    //   288: astore_1
    //   289: aload_1
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_3
    //   293: aconst_null
    //   294: astore 4
    //   296: goto -181 -> 115
    //   299: astore 19
    //   301: aload 8
    //   303: astore_3
    //   304: aload 19
    //   306: astore_2
    //   307: aconst_null
    //   308: astore 4
    //   310: goto -195 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   66	75	103	java/io/IOException
    //   75	82	103	java/io/IOException
    //   87	100	103	java/io/IOException
    //   168	197	103	java/io/IOException
    //   115	128	128	finally
    //   27	32	226	java/io/IOException
    //   36	40	231	java/io/IOException
    //   202	207	236	java/io/IOException
    //   212	217	241	java/io/IOException
    //   146	151	246	java/io/IOException
    //   156	161	251	java/io/IOException
    //   7	13	256	finally
    //   46	66	271	finally
    //   66	75	283	finally
    //   75	82	283	finally
    //   87	100	283	finally
    //   168	197	283	finally
    //   7	13	288	java/io/IOException
    //   46	66	299	java/io/IOException
  }

  public abstract void disconnect()
    throws IOException;

  public abstract String getResponseHeader(String paramString);

  public abstract Map<String, List<String>> getResponseHeaderFields();

  public int getStatusCode()
  {
    return this.statusCode;
  }

  public String toString()
  {
    return "HttpResponse{statusCode=" + this.statusCode + ", responseAsString='" + this.responseAsString + '\'' + ", is=" + this.is + ", streamConsumed=" + this.streamConsumed + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpResponse
 * JD-Core Version:    0.6.2
 */