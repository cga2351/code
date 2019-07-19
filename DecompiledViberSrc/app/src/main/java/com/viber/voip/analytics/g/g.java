package com.viber.voip.analytics.g;

import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bn;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.onepf.oms.util.CollectionUtils;

public class g
{
  private static final Logger a = ViberEnv.getLogger();

  private String a()
  {
    return d.bn.d.d();
  }

  private String b()
  {
    return String.format(a() + "/api/v1/assignments/applications/%s/restore", new Object[] { "Viber" });
  }

  private String c()
  {
    return a() + "/api/v1/assignments/applications/%s/experiments/%s/users/%s";
  }

  private String d()
  {
    return a() + "/api/v1/events/applications/%s/experiments/%s/users/%s";
  }

  public c a(String paramString)
  {
    try
    {
      c localc = c.a(paramString);
      return localc;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  // ERROR //
  public String a(a.a parama, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 77	com/viber/voip/util/da:b	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_3
    //   10: invokestatic 77	com/viber/voip/util/da:b	(Ljava/lang/CharSequence;)Z
    //   13: ifne -6 -> 7
    //   16: ldc 79
    //   18: astore 4
    //   20: aload_3
    //   21: ldc 81
    //   23: invokestatic 87	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 17
    //   28: aload 17
    //   30: astore 4
    //   32: aload_0
    //   33: invokespecial 89	com/viber/voip/analytics/g/g:c	()Ljava/lang/String;
    //   36: astore 6
    //   38: iconst_3
    //   39: anewarray 4	java/lang/Object
    //   42: astore 7
    //   44: aload 7
    //   46: iconst_0
    //   47: ldc 47
    //   49: aastore
    //   50: aload 7
    //   52: iconst_1
    //   53: aload_1
    //   54: invokevirtual 92	com/viber/voip/analytics/g/a$a:a	()Ljava/lang/String;
    //   57: aastore
    //   58: aload 7
    //   60: iconst_2
    //   61: aload 4
    //   63: aastore
    //   64: aload 6
    //   66: aload 7
    //   68: invokestatic 53	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: astore 8
    //   73: invokestatic 96	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   76: invokeinterface 102 1 0
    //   81: astore 9
    //   83: new 104	okhttp3/Request$Builder
    //   86: dup
    //   87: invokespecial 105	okhttp3/Request$Builder:<init>	()V
    //   90: aload 8
    //   92: invokevirtual 109	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   95: astore 10
    //   97: new 111	org/json/JSONObject
    //   100: dup
    //   101: invokespecial 112	org/json/JSONObject:<init>	()V
    //   104: astore 11
    //   106: aload 11
    //   108: ldc 114
    //   110: aload_2
    //   111: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   114: pop
    //   115: aload 11
    //   117: ldc 120
    //   119: iconst_1
    //   120: invokevirtual 123	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload 10
    //   126: ldc 125
    //   128: invokestatic 131	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   131: aload 11
    //   133: invokevirtual 132	org/json/JSONObject:toString	()Ljava/lang/String;
    //   136: invokestatic 138	okhttp3/RequestBody:create	(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;
    //   139: invokevirtual 141	okhttp3/Request$Builder:put	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   142: pop
    //   143: aload 9
    //   145: invokevirtual 147	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   148: aload 10
    //   150: invokevirtual 150	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   153: invokevirtual 156	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   156: invokeinterface 162 1 0
    //   161: astore 14
    //   163: aload 14
    //   165: invokevirtual 168	okhttp3/Response:isSuccessful	()Z
    //   168: ifne +44 -> 212
    //   171: new 170	java/io/IOException
    //   174: dup
    //   175: new 33	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   182: ldc 172
    //   184: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 14
    //   189: invokevirtual 176	okhttp3/Response:code	()I
    //   192: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokespecial 182	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: astore 5
    //   204: aload 5
    //   206: invokevirtual 185	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   209: goto -177 -> 32
    //   212: aload 14
    //   214: invokevirtual 189	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   217: invokevirtual 194	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   220: areturn
    //   221: astore 12
    //   223: goto -99 -> 124
    //
    // Exception table:
    //   from	to	target	type
    //   20	28	202	java/io/UnsupportedEncodingException
    //   106	124	221	org/json/JSONException
  }

  public String a(String paramString, Map<String, Object> paramMap)
    throws Exception
  {
    if (da.a(paramString))
      return null;
    String str = b();
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
    Request.Builder localBuilder1 = new Request.Builder().url(str);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if (!CollectionUtils.isEmpty(paramMap))
      {
        localJSONObject2 = new JSONObject();
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Response localResponse;
      while (true)
      {
        JSONObject localJSONObject2;
        localBuilder1.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), localJSONObject1.toString()));
        localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
        if (localResponse.isSuccessful())
          break;
        throw new IOException("Unexpected response code: " + localResponse.code());
        localJSONObject1.put("profile", localJSONObject2);
        JSONObject localJSONObject3 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("name", "ff");
        localJSONArray1.put(localJSONObject4);
        localJSONObject3.put("pages", localJSONArray1);
        localJSONObject1.put("test", localJSONObject3);
        JSONObject localJSONObject5 = new JSONObject();
        localJSONObject5.put("defaultUserId", paramString);
        JSONArray localJSONArray2 = new JSONArray();
        JSONObject localJSONObject6 = new JSONObject();
        localJSONObject6.put("name", "ab");
        localJSONArray2.put(localJSONObject6);
        localJSONObject5.put("pages", localJSONArray2);
        localJSONObject1.put("assign", localJSONObject5);
      }
      return localResponse.body().string();
    }
  }

  // ERROR //
  public boolean a(a.a parama, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 197	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: ldc 79
    //   11: astore 5
    //   13: aload_2
    //   14: ldc 81
    //   16: invokestatic 87	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 27
    //   21: aload 27
    //   23: astore 5
    //   25: aload_0
    //   26: invokespecial 261	com/viber/voip/analytics/g/g:d	()Ljava/lang/String;
    //   29: astore 7
    //   31: iconst_3
    //   32: anewarray 4	java/lang/Object
    //   35: astore 8
    //   37: aload 8
    //   39: iconst_0
    //   40: ldc 47
    //   42: aastore
    //   43: aload 8
    //   45: iconst_1
    //   46: aload_1
    //   47: invokevirtual 92	com/viber/voip/analytics/g/a$a:a	()Ljava/lang/String;
    //   50: aastore
    //   51: aload 8
    //   53: iconst_2
    //   54: aload 5
    //   56: aastore
    //   57: aload 7
    //   59: aload 8
    //   61: invokestatic 53	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: astore 9
    //   66: invokestatic 96	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   69: invokeinterface 102 1 0
    //   74: astore 10
    //   76: new 104	okhttp3/Request$Builder
    //   79: dup
    //   80: invokespecial 105	okhttp3/Request$Builder:<init>	()V
    //   83: aload 9
    //   85: invokevirtual 109	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   88: astore 11
    //   90: new 111	org/json/JSONObject
    //   93: dup
    //   94: invokespecial 112	org/json/JSONObject:<init>	()V
    //   97: astore 12
    //   99: aload 12
    //   101: ldc 244
    //   103: aload_3
    //   104: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: new 111	org/json/JSONObject
    //   111: dup
    //   112: invokespecial 112	org/json/JSONObject:<init>	()V
    //   115: astore 22
    //   117: aload 4
    //   119: invokestatic 205	org/onepf/oms/util/CollectionUtils:isEmpty	(Ljava/util/Map;)Z
    //   122: ifne +70 -> 192
    //   125: aload 4
    //   127: invokeinterface 211 1 0
    //   132: invokeinterface 217 1 0
    //   137: astore 23
    //   139: aload 23
    //   141: invokeinterface 222 1 0
    //   146: ifeq +164 -> 310
    //   149: aload 23
    //   151: invokeinterface 226 1 0
    //   156: checkcast 228	java/util/Map$Entry
    //   159: astore 25
    //   161: aload 22
    //   163: aload 25
    //   165: invokeinterface 231 1 0
    //   170: checkcast 49	java/lang/String
    //   173: aload 25
    //   175: invokeinterface 234 1 0
    //   180: checkcast 49	java/lang/String
    //   183: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: goto -48 -> 139
    //   190: astore 13
    //   192: new 241	org/json/JSONArray
    //   195: dup
    //   196: invokespecial 242	org/json/JSONArray:<init>	()V
    //   199: astore 14
    //   201: aload 14
    //   203: aload 12
    //   205: invokevirtual 249	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   208: pop
    //   209: new 111	org/json/JSONObject
    //   212: dup
    //   213: invokespecial 112	org/json/JSONObject:<init>	()V
    //   216: astore 16
    //   218: aload 16
    //   220: ldc_w 263
    //   223: aload 14
    //   225: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload 11
    //   231: ldc 125
    //   233: invokestatic 131	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   236: aload 16
    //   238: invokevirtual 132	org/json/JSONObject:toString	()Ljava/lang/String;
    //   241: invokestatic 138	okhttp3/RequestBody:create	(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;
    //   244: invokevirtual 237	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   247: pop
    //   248: aload 10
    //   250: invokevirtual 147	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   253: aload 11
    //   255: invokevirtual 150	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   258: invokevirtual 156	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   261: invokeinterface 162 1 0
    //   266: invokevirtual 168	okhttp3/Response:isSuccessful	()Z
    //   269: ifne +58 -> 327
    //   272: new 68	java/lang/Exception
    //   275: dup
    //   276: ldc_w 265
    //   279: invokespecial 266	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   282: athrow
    //   283: astore 19
    //   285: getstatic 16	com/viber/voip/analytics/g/g:a	Lcom/viber/dexshared/Logger;
    //   288: aload 19
    //   290: ldc_w 268
    //   293: invokeinterface 273 3 0
    //   298: iconst_0
    //   299: ireturn
    //   300: astore 6
    //   302: aload 6
    //   304: invokevirtual 185	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   307: goto -282 -> 25
    //   310: aload 12
    //   312: ldc_w 275
    //   315: aload 22
    //   317: invokevirtual 132	org/json/JSONObject:toString	()Ljava/lang/String;
    //   320: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   323: pop
    //   324: goto -132 -> 192
    //   327: iconst_1
    //   328: ireturn
    //   329: astore 17
    //   331: goto -102 -> 229
    //
    // Exception table:
    //   from	to	target	type
    //   99	139	190	org/json/JSONException
    //   139	187	190	org/json/JSONException
    //   310	324	190	org/json/JSONException
    //   248	283	283	java/lang/Throwable
    //   13	21	300	java/io/UnsupportedEncodingException
    //   218	229	329	org/json/JSONException
  }

  public boolean a(a.a parama, String paramString, Map<String, String> paramMap)
  {
    return a(parama, paramString, "IMPRESSION", paramMap);
  }

  public static class a extends g.b
  {
    public final a a;

    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      super(paramString3, paramString4);
      this.a = a.a(paramString2);
    }

    public boolean a()
    {
      return (a.b == this.a) || (a.c == this.a);
    }

    public String toString()
    {
      return "Assignment{label='" + this.b + '\'' + ", bucket='" + this.c + '\'' + ", payload='" + this.d + '\'' + ", status=" + this.a + "}";
    }

    static enum a
    {
      static
      {
        a[] arrayOfa = new a[7];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
        arrayOfa[5] = f;
        arrayOfa[6] = g;
      }

      public static a a(String paramString)
      {
        int i = -1;
        switch (paramString.hashCode())
        {
        default:
        case 1535750299:
        case 1396124396:
        case 1898925569:
        case 2102053140:
        case -1206889277:
        case 198804849:
        }
        while (true)
          switch (i)
          {
          default:
            return g;
            if (paramString.equals("EXPERIMENT_IN_DRAFT_STATE"))
            {
              i = 0;
              continue;
              if (paramString.equals("NEW_ASSIGNMENT"))
              {
                i = 1;
                continue;
                if (paramString.equals("EXISTING_ASSIGNMENT"))
                {
                  i = 2;
                  continue;
                  if (paramString.equals("EXPERIMENT_NOT_FOUND"))
                  {
                    i = 3;
                    continue;
                    if (paramString.equals("EXPERIMENT_EXPIRED"))
                    {
                      i = 4;
                      continue;
                      if (paramString.equals("NO_PROFILE_MATCH"))
                        i = 5;
                    }
                  }
                }
              }
            }
            break;
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
        return a;
        return b;
        return c;
        return d;
        return e;
        return f;
      }
    }
  }

  public static abstract class b
  {
    public final String b;
    public final String c;
    public final String d;

    public b(String paramString1, String paramString2, String paramString3)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
    }

    public abstract boolean a();
  }

  public static class c
  {
    public final List<g.d> a;
    public final List<g.a> b;

    public c(List<g.d> paramList, List<g.a> paramList1)
    {
      this.a = paramList;
      this.b = paramList1;
    }

    public static c a(String paramString)
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return new c(a(localJSONObject.getJSONObject("test")), b(localJSONObject.getJSONObject("assignments")));
    }

    private static List<g.d> a(JSONObject paramJSONObject)
      throws JSONException
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray1 = paramJSONObject.getJSONArray("pages");
      for (int i = 0; i < localJSONArray1.length(); i++)
      {
        JSONArray localJSONArray2 = localJSONArray1.getJSONObject(i).getJSONArray("experiments");
        int j = 0;
        if (j < localJSONArray2.length())
        {
          JSONObject localJSONObject1 = localJSONArray2.getJSONObject(j);
          String str1 = localJSONObject1.getString("label");
          boolean bool = localJSONObject1.getBoolean("result");
          JSONObject localJSONObject2 = a(localJSONObject1, "bucket");
          String str2;
          if (localJSONObject2 == null)
          {
            str2 = null;
            label94: if (localJSONObject2 != null)
              break label140;
          }
          label140: for (String str3 = null; ; str3 = b(localJSONObject2, "payload"))
          {
            localArrayList.add(new g.d(str1, bool, str2, str3));
            j++;
            break;
            str2 = localJSONObject2.getString("name");
            break label94;
          }
        }
      }
      return localArrayList;
    }

    private static JSONObject a(JSONObject paramJSONObject, String paramString)
      throws JSONException
    {
      if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString)))
        return paramJSONObject.getJSONObject(paramString);
      return null;
    }

    private static String b(JSONObject paramJSONObject, String paramString)
      throws JSONException
    {
      if ((paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString)))
        return paramJSONObject.getString(paramString);
      return null;
    }

    private static List<g.a> b(JSONObject paramJSONObject)
      throws JSONException
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray1 = paramJSONObject.getJSONArray("pages");
      for (int i = 0; i < localJSONArray1.length(); i++)
      {
        JSONArray localJSONArray2 = localJSONArray1.getJSONObject(i).getJSONArray("experiments");
        int j = 0;
        if (j < localJSONArray2.length())
        {
          JSONObject localJSONObject1 = localJSONArray2.getJSONObject(j);
          String str1 = localJSONObject1.getString("label");
          String str2 = localJSONObject1.getString("status");
          JSONObject localJSONObject2 = a(localJSONObject1, "bucket");
          String str3;
          if (localJSONObject2 == null)
          {
            str3 = null;
            label94: if (localJSONObject2 != null)
              break label140;
          }
          label140: for (String str4 = null; ; str4 = b(localJSONObject2, "payload"))
          {
            localArrayList.add(new g.a(str1, str2, str3, str4));
            j++;
            break;
            str3 = localJSONObject2.getString("name");
            break label94;
          }
        }
      }
      return localArrayList;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Tests:[");
      localStringBuilder.append(TextUtils.join(",\n", this.a));
      localStringBuilder.append("],\nAssignments:[");
      localStringBuilder.append(TextUtils.join(",\n", this.b));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static class d extends g.b
  {
    public final boolean a;

    public d(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    {
      super(paramString2, paramString3);
      this.a = paramBoolean;
    }

    public boolean a()
    {
      return this.a;
    }

    public String toString()
    {
      return "Test{label='" + this.b + '\'' + ", bucket='" + this.c + '\'' + ", payload='" + this.d + '\'' + ", result=" + this.a + "}";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g.g
 * JD-Core Version:    0.6.2
 */