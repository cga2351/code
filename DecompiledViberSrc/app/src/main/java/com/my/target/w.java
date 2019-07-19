package com.my.target;

import android.content.Context;
import android.os.Build.VERSION;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class w extends v<String>
{
  private int f;

  public static w a()
  {
    return new w();
  }

  private String a(HttpURLConnection paramHttpURLConnection)
  {
    String str1;
    if (this.f <= 10)
      str1 = paramHttpURLConnection.getHeaderField("Location");
    String str2;
    try
    {
      URI localURI = new URI(str1);
      str2 = paramHttpURLConnection.getURL().toURI().resolve(localURI).toString();
      int i = 1;
      if ((Build.VERSION.SDK_INT >= 28) && (!bk.d(str2)))
        i = 0;
      if ((bk.b(str2)) || (i == 0))
      {
        this.d = str2;
        return null;
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      return null;
    }
    return str2;
  }

  // ERROR //
  private void d(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 67	com/my/target/w:d	Ljava/lang/Object;
    //   5: new 72	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   12: ldc 75
    //   14: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 84	com/my/target/dp:a	(Ljava/lang/String;)V
    //   27: aload_2
    //   28: invokestatic 89	com/my/target/aa:a	(Landroid/content/Context;)Lcom/my/target/aa;
    //   31: astore 13
    //   33: aload 13
    //   35: astore 4
    //   37: new 38	java/net/URL
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   48: checkcast 23	java/net/HttpURLConnection
    //   51: astore 7
    //   53: aload 7
    //   55: sipush 10000
    //   58: invokevirtual 98	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   61: aload 7
    //   63: sipush 10000
    //   66: invokevirtual 101	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   69: aload 7
    //   71: ldc 103
    //   73: invokevirtual 106	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload 7
    //   78: ldc 108
    //   80: ldc 110
    //   82: invokestatic 115	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokevirtual 119	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 7
    //   90: iconst_0
    //   91: invokevirtual 123	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   94: aload 7
    //   96: ldc 125
    //   98: ldc 127
    //   100: invokevirtual 130	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 4
    //   105: ifnull +10 -> 115
    //   108: aload 4
    //   110: aload 7
    //   112: invokevirtual 133	com/my/target/aa:b	(Ljava/net/URLConnection;)V
    //   115: aload_0
    //   116: aload 7
    //   118: invokevirtual 137	java/net/HttpURLConnection:getResponseCode	()I
    //   121: putfield 140	com/my/target/w:c	I
    //   124: aload 7
    //   126: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   129: astore 10
    //   131: aload 10
    //   133: ifnull +8 -> 141
    //   136: aload 10
    //   138: invokevirtual 148	java/io/InputStream:close	()V
    //   141: aload_0
    //   142: getfield 140	com/my/target/w:c	I
    //   145: sipush 200
    //   148: if_icmpeq +33 -> 181
    //   151: aload_0
    //   152: getfield 140	com/my/target/w:c	I
    //   155: sipush 204
    //   158: if_icmpeq +23 -> 181
    //   161: aload_0
    //   162: getfield 140	com/my/target/w:c	I
    //   165: sipush 404
    //   168: if_icmpeq +13 -> 181
    //   171: aload_0
    //   172: getfield 140	com/my/target/w:c	I
    //   175: sipush 403
    //   178: if_icmpne +80 -> 258
    //   181: aconst_null
    //   182: astore 8
    //   184: aload 4
    //   186: ifnull +10 -> 196
    //   189: aload 4
    //   191: aload 7
    //   193: invokevirtual 150	com/my/target/aa:a	(Ljava/net/URLConnection;)V
    //   196: aload 7
    //   198: ifnull +8 -> 206
    //   201: aload 7
    //   203: invokevirtual 153	java/net/HttpURLConnection:disconnect	()V
    //   206: aload 8
    //   208: ifnull +33 -> 241
    //   211: new 72	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   218: ldc 155
    //   220: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 8
    //   225: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 84	com/my/target/dp:a	(Ljava/lang/String;)V
    //   234: aload_0
    //   235: aload 8
    //   237: aload_2
    //   238: invokespecial 157	com/my/target/w:d	(Ljava/lang/String;Landroid/content/Context;)V
    //   241: return
    //   242: astore_3
    //   243: ldc 159
    //   245: invokestatic 84	com/my/target/dp:a	(Ljava/lang/String;)V
    //   248: aload_3
    //   249: invokevirtual 162	java/lang/Throwable:printStackTrace	()V
    //   252: aconst_null
    //   253: astore 4
    //   255: goto -218 -> 37
    //   258: aload_0
    //   259: getfield 140	com/my/target/w:c	I
    //   262: sipush 302
    //   265: if_icmpeq +30 -> 295
    //   268: aload_0
    //   269: getfield 140	com/my/target/w:c	I
    //   272: sipush 301
    //   275: if_icmpeq +20 -> 295
    //   278: aload_0
    //   279: getfield 140	com/my/target/w:c	I
    //   282: istore 12
    //   284: aconst_null
    //   285: astore 8
    //   287: iload 12
    //   289: sipush 303
    //   292: if_icmpne -96 -> 196
    //   295: aload_0
    //   296: iconst_1
    //   297: aload_0
    //   298: getfield 19	com/my/target/w:f	I
    //   301: iadd
    //   302: putfield 19	com/my/target/w:f	I
    //   305: aload_0
    //   306: aload 7
    //   308: invokespecial 164	com/my/target/w:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   311: astore 11
    //   313: aload 11
    //   315: astore 8
    //   317: goto -121 -> 196
    //   320: astore 5
    //   322: aconst_null
    //   323: astore 6
    //   325: aload_0
    //   326: iconst_0
    //   327: putfield 167	com/my/target/w:a	Z
    //   330: aload_0
    //   331: aload 5
    //   333: invokevirtual 170	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   336: putfield 174	com/my/target/w:e	Ljava/lang/String;
    //   339: new 72	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   346: ldc 176
    //   348: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 174	com/my/target/w:e	Ljava/lang/String;
    //   355: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 84	com/my/target/dp:a	(Ljava/lang/String;)V
    //   364: aload 6
    //   366: astore 7
    //   368: aconst_null
    //   369: astore 8
    //   371: goto -175 -> 196
    //   374: astore 9
    //   376: aload 7
    //   378: astore 6
    //   380: aload 9
    //   382: astore 5
    //   384: goto -59 -> 325
    //
    // Exception table:
    //   from	to	target	type
    //   27	33	242	java/lang/Throwable
    //   37	53	320	java/lang/Throwable
    //   53	103	374	java/lang/Throwable
    //   108	115	374	java/lang/Throwable
    //   115	131	374	java/lang/Throwable
    //   136	141	374	java/lang/Throwable
    //   141	181	374	java/lang/Throwable
    //   189	196	374	java/lang/Throwable
    //   258	284	374	java/lang/Throwable
    //   295	313	374	java/lang/Throwable
  }

  protected String a(String paramString, Context paramContext)
  {
    this.f = 0;
    d(paramString, paramContext);
    return (String)this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.w
 * JD-Core Version:    0.6.2
 */