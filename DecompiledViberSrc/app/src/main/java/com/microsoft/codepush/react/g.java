package com.microsoft.codepush.react;

import java.io.IOException;
import org.json.JSONObject;

public class g
{
  private String a;

  private String i()
  {
    return j.a(k(), "unzipped");
  }

  private String j()
  {
    return this.a;
  }

  private String k()
  {
    String str = j.a(j(), "CodePush");
    if (a.m())
      str = j.a(str, "TestPackages");
    return str;
  }

  private String l()
  {
    return j.a(k(), "codepush.json");
  }

  public String a(String paramString)
  {
    String str1 = b();
    if (str1 == null);
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = e();
    }
    while (localJSONObject == null);
    String str2 = localJSONObject.optString("bundlePath", null);
    if (str2 == null)
      return j.a(str1, paramString);
    return j.a(str1, str2);
  }

  public JSONObject a()
  {
    String str = l();
    if (!m.c(str))
      return new JSONObject();
    try
    {
      JSONObject localJSONObject = j.a(str);
      return localJSONObject;
    }
    catch (IOException localIOException)
    {
      throw new f("Error getting current package info", localIOException);
    }
  }

  // ERROR //
  public void a(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 80	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 87	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 89	java/net/HttpURLConnection
    //   14: checkcast 89	java/net/HttpURLConnection
    //   17: astore 15
    //   19: new 91	java/io/BufferedInputStream
    //   22: dup
    //   23: aload 15
    //   25: invokevirtual 95	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   28: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 9
    //   33: new 100	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 102	com/microsoft/codepush/react/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 16
    //   47: aload 16
    //   49: invokevirtual 106	java/io/File:delete	()Z
    //   52: pop
    //   53: new 108	java/io/FileOutputStream
    //   56: dup
    //   57: aload 16
    //   59: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore 13
    //   64: new 113	java/io/BufferedOutputStream
    //   67: dup
    //   68: aload 13
    //   70: ldc 114
    //   72: invokespecial 117	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   75: astore 20
    //   77: ldc 114
    //   79: newarray byte
    //   81: astore 23
    //   83: aload 9
    //   85: aload 23
    //   87: iconst_0
    //   88: ldc 114
    //   90: invokevirtual 121	java/io/BufferedInputStream:read	([BII)I
    //   93: istore 24
    //   95: iload 24
    //   97: iflt +112 -> 209
    //   100: aload 20
    //   102: aload 23
    //   104: iconst_0
    //   105: iload 24
    //   107: invokevirtual 125	java/io/BufferedOutputStream:write	([BII)V
    //   110: goto -27 -> 83
    //   113: astore 22
    //   115: aload 13
    //   117: astore 6
    //   119: aload 15
    //   121: astore 7
    //   123: aload 22
    //   125: astore_3
    //   126: aload 20
    //   128: astore 4
    //   130: aload 9
    //   132: astore 5
    //   134: new 127	com/microsoft/codepush/react/d
    //   137: dup
    //   138: aload_1
    //   139: aload_3
    //   140: invokespecial 130	com/microsoft/codepush/react/d:<init>	(Ljava/lang/String;Ljava/net/MalformedURLException;)V
    //   143: athrow
    //   144: astore 8
    //   146: aload 5
    //   148: astore 9
    //   150: aload 6
    //   152: astore 10
    //   154: aload 4
    //   156: astore 11
    //   158: aload 7
    //   160: astore 12
    //   162: aload 10
    //   164: astore 13
    //   166: aload 11
    //   168: ifnull +8 -> 176
    //   171: aload 11
    //   173: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   176: aload 13
    //   178: ifnull +8 -> 186
    //   181: aload 13
    //   183: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   186: aload 9
    //   188: ifnull +8 -> 196
    //   191: aload 9
    //   193: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   196: aload 12
    //   198: ifnull +8 -> 206
    //   201: aload 12
    //   203: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   206: aload 8
    //   208: athrow
    //   209: aload 20
    //   211: ifnull +8 -> 219
    //   214: aload 20
    //   216: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   219: aload 13
    //   221: ifnull +8 -> 229
    //   224: aload 13
    //   226: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   229: aload 9
    //   231: ifnull +8 -> 239
    //   234: aload 9
    //   236: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   239: aload 15
    //   241: ifnull +8 -> 249
    //   244: aload 15
    //   246: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   249: return
    //   250: astore 25
    //   252: new 70	com/microsoft/codepush/react/f
    //   255: dup
    //   256: ldc 140
    //   258: aload 25
    //   260: invokespecial 75	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: athrow
    //   264: astore 14
    //   266: new 70	com/microsoft/codepush/react/f
    //   269: dup
    //   270: ldc 140
    //   272: aload 14
    //   274: invokespecial 75	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: athrow
    //   278: astore 8
    //   280: aconst_null
    //   281: astore 12
    //   283: aconst_null
    //   284: astore 11
    //   286: aconst_null
    //   287: astore 13
    //   289: aconst_null
    //   290: astore 9
    //   292: goto -126 -> 166
    //   295: astore 29
    //   297: aload 15
    //   299: astore 12
    //   301: aload 29
    //   303: astore 8
    //   305: aconst_null
    //   306: astore 11
    //   308: aconst_null
    //   309: astore 13
    //   311: aconst_null
    //   312: astore 9
    //   314: goto -148 -> 166
    //   317: astore 18
    //   319: aload 15
    //   321: astore 12
    //   323: aload 18
    //   325: astore 8
    //   327: aconst_null
    //   328: astore 11
    //   330: aconst_null
    //   331: astore 13
    //   333: goto -167 -> 166
    //   336: astore 27
    //   338: aload 15
    //   340: astore 12
    //   342: aload 27
    //   344: astore 8
    //   346: aconst_null
    //   347: astore 11
    //   349: goto -183 -> 166
    //   352: astore 21
    //   354: aload 20
    //   356: astore 11
    //   358: aload 15
    //   360: astore 12
    //   362: aload 21
    //   364: astore 8
    //   366: goto -200 -> 166
    //   369: astore_3
    //   370: aconst_null
    //   371: astore 4
    //   373: aconst_null
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 6
    //   379: aconst_null
    //   380: astore 7
    //   382: goto -248 -> 134
    //   385: astore 28
    //   387: aload 15
    //   389: astore 7
    //   391: aload 28
    //   393: astore_3
    //   394: aconst_null
    //   395: astore 4
    //   397: aconst_null
    //   398: astore 5
    //   400: aconst_null
    //   401: astore 6
    //   403: goto -269 -> 134
    //   406: astore 17
    //   408: aload 9
    //   410: astore 5
    //   412: aload 15
    //   414: astore 7
    //   416: aload 17
    //   418: astore_3
    //   419: aconst_null
    //   420: astore 4
    //   422: aconst_null
    //   423: astore 6
    //   425: goto -291 -> 134
    //   428: astore 26
    //   430: aload 9
    //   432: astore 5
    //   434: aload 13
    //   436: astore 6
    //   438: aload 15
    //   440: astore 7
    //   442: aload 26
    //   444: astore_3
    //   445: aconst_null
    //   446: astore 4
    //   448: goto -314 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   77	83	113	java/net/MalformedURLException
    //   83	95	113	java/net/MalformedURLException
    //   100	110	113	java/net/MalformedURLException
    //   134	144	144	finally
    //   214	219	250	java/io/IOException
    //   224	229	250	java/io/IOException
    //   234	239	250	java/io/IOException
    //   244	249	250	java/io/IOException
    //   171	176	264	java/io/IOException
    //   181	186	264	java/io/IOException
    //   191	196	264	java/io/IOException
    //   201	206	264	java/io/IOException
    //   0	19	278	finally
    //   19	33	295	finally
    //   33	64	317	finally
    //   64	77	336	finally
    //   77	83	352	finally
    //   83	95	352	finally
    //   100	110	352	finally
    //   0	19	369	java/net/MalformedURLException
    //   19	33	385	java/net/MalformedURLException
    //   33	64	406	java/net/MalformedURLException
    //   64	77	428	java/net/MalformedURLException
  }

  public void a(JSONObject paramJSONObject)
  {
    try
    {
      j.a(paramJSONObject, l());
      return;
    }
    catch (IOException localIOException)
    {
      throw new f("Error updating current package info", localIOException);
    }
  }

  // ERROR //
  public void a(JSONObject paramJSONObject, String paramString1, l paraml, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 149
    //   3: aconst_null
    //   4: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 5
    //   9: aload_0
    //   10: aload 5
    //   12: invokevirtual 151	com/microsoft/codepush/react/g:b	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 6
    //   17: aload 6
    //   19: ldc 153
    //   21: invokestatic 18	com/microsoft/codepush/react/j:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 7
    //   26: aload 6
    //   28: invokestatic 61	com/microsoft/codepush/react/m:c	(Ljava/lang/String;)Z
    //   31: ifeq +8 -> 39
    //   34: aload 6
    //   36: invokestatic 155	com/microsoft/codepush/react/m:a	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: ldc 157
    //   42: aconst_null
    //   43: invokevirtual 51	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 8
    //   48: new 80	java/net/URL
    //   51: dup
    //   52: aload 8
    //   54: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: invokevirtual 87	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   60: checkcast 89	java/net/HttpURLConnection
    //   63: checkcast 89	java/net/HttpURLConnection
    //   66: astore 21
    //   68: aload 21
    //   70: ldc 159
    //   72: ldc 161
    //   74: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: new 91	java/io/BufferedInputStream
    //   80: dup
    //   81: aload 21
    //   83: invokevirtual 95	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   86: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore 15
    //   91: aload 21
    //   93: invokevirtual 168	java/net/HttpURLConnection:getContentLength	()I
    //   96: i2l
    //   97: lstore 26
    //   99: lconst_0
    //   100: lstore 28
    //   102: new 100	java/io/File
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 11	com/microsoft/codepush/react/g:k	()Ljava/lang/String;
    //   110: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore 30
    //   115: aload 30
    //   117: invokevirtual 171	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: new 100	java/io/File
    //   124: dup
    //   125: aload 30
    //   127: ldc 173
    //   129: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore 32
    //   134: new 108	java/io/FileOutputStream
    //   137: dup
    //   138: aload 32
    //   140: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore 19
    //   145: new 113	java/io/BufferedOutputStream
    //   148: dup
    //   149: aload 19
    //   151: ldc 114
    //   153: invokespecial 117	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   156: astore 17
    //   158: ldc 114
    //   160: newarray byte
    //   162: astore 36
    //   164: iconst_4
    //   165: newarray byte
    //   167: astore 37
    //   169: aload 15
    //   171: aload 36
    //   173: iconst_0
    //   174: ldc 114
    //   176: invokevirtual 121	java/io/BufferedInputStream:read	([BII)I
    //   179: istore 38
    //   181: iload 38
    //   183: iflt +175 -> 358
    //   186: lload 28
    //   188: ldc2_w 177
    //   191: lcmp
    //   192: ifge +9 -> 201
    //   195: iconst_0
    //   196: istore 50
    //   198: goto +747 -> 945
    //   201: lload 28
    //   203: iload 38
    //   205: i2l
    //   206: ladd
    //   207: lstore 28
    //   209: aload 17
    //   211: aload 36
    //   213: iconst_0
    //   214: iload 38
    //   216: invokevirtual 125	java/io/BufferedOutputStream:write	([BII)V
    //   219: aload_3
    //   220: new 180	com/microsoft/codepush/react/k
    //   223: dup
    //   224: lload 26
    //   226: lload 28
    //   228: invokespecial 183	com/microsoft/codepush/react/k:<init>	(JJ)V
    //   231: invokeinterface 188 2 0
    //   236: goto -67 -> 169
    //   239: astore 34
    //   241: aload 15
    //   243: astore 12
    //   245: aload 17
    //   247: astore 35
    //   249: aload 19
    //   251: astore 11
    //   253: aload 21
    //   255: astore 13
    //   257: aload 34
    //   259: astore 9
    //   261: aload 35
    //   263: astore 10
    //   265: new 127	com/microsoft/codepush/react/d
    //   268: dup
    //   269: aload 8
    //   271: aload 9
    //   273: invokespecial 130	com/microsoft/codepush/react/d:<init>	(Ljava/lang/String;Ljava/net/MalformedURLException;)V
    //   276: athrow
    //   277: astore 14
    //   279: aload 12
    //   281: astore 15
    //   283: aload 11
    //   285: astore 16
    //   287: aload 10
    //   289: astore 17
    //   291: aload 13
    //   293: astore 18
    //   295: aload 16
    //   297: astore 19
    //   299: aload 17
    //   301: ifnull +8 -> 309
    //   304: aload 17
    //   306: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   309: aload 19
    //   311: ifnull +8 -> 319
    //   314: aload 19
    //   316: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   319: aload 15
    //   321: ifnull +8 -> 329
    //   324: aload 15
    //   326: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   329: aload 18
    //   331: ifnull +8 -> 339
    //   334: aload 18
    //   336: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   339: aload 14
    //   341: athrow
    //   342: aload 37
    //   344: iload 51
    //   346: aload 36
    //   348: iload 50
    //   350: baload
    //   351: bastore
    //   352: iinc 50 1
    //   355: goto +590 -> 945
    //   358: lload 26
    //   360: lload 28
    //   362: lcmp
    //   363: ifeq +41 -> 404
    //   366: new 70	com/microsoft/codepush/react/f
    //   369: dup
    //   370: new 190	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   377: ldc 193
    //   379: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: lload 28
    //   384: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   387: ldc 202
    //   389: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: lload 26
    //   394: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokespecial 206	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;)V
    //   403: athrow
    //   404: aload 37
    //   406: invokestatic 212	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   409: invokevirtual 215	java/nio/ByteBuffer:getInt	()I
    //   412: istore 39
    //   414: iload 39
    //   416: ldc 216
    //   418: if_icmpne +171 -> 589
    //   421: iconst_1
    //   422: istore 40
    //   424: aload 17
    //   426: ifnull +8 -> 434
    //   429: aload 17
    //   431: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   434: aload 19
    //   436: ifnull +8 -> 444
    //   439: aload 19
    //   441: invokevirtual 134	java/io/FileOutputStream:close	()V
    //   444: aload 15
    //   446: ifnull +8 -> 454
    //   449: aload 15
    //   451: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   454: aload 21
    //   456: ifnull +8 -> 464
    //   459: aload 21
    //   461: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   464: iload 40
    //   466: ifeq +308 -> 774
    //   469: aload_0
    //   470: invokespecial 218	com/microsoft/codepush/react/g:i	()Ljava/lang/String;
    //   473: astore 42
    //   475: aload 32
    //   477: aload 42
    //   479: invokestatic 220	com/microsoft/codepush/react/m:a	(Ljava/io/File;Ljava/lang/String;)V
    //   482: aload 32
    //   484: invokestatic 222	com/microsoft/codepush/react/m:a	(Ljava/io/File;)V
    //   487: aload 42
    //   489: ldc 224
    //   491: invokestatic 18	com/microsoft/codepush/react/j:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   494: astore 43
    //   496: aload 43
    //   498: invokestatic 61	com/microsoft/codepush/react/m:c	(Ljava/lang/String;)Z
    //   501: istore 44
    //   503: iload 44
    //   505: ifeq +27 -> 532
    //   508: aload 43
    //   510: aload_0
    //   511: invokevirtual 40	com/microsoft/codepush/react/g:b	()Ljava/lang/String;
    //   514: aload 6
    //   516: invokestatic 229	com/microsoft/codepush/react/i:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   519: new 100	java/io/File
    //   522: dup
    //   523: aload 43
    //   525: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   528: invokevirtual 106	java/io/File:delete	()Z
    //   531: pop
    //   532: aload 42
    //   534: aload 6
    //   536: invokestatic 231	com/microsoft/codepush/react/m:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload 42
    //   541: invokestatic 233	com/microsoft/codepush/react/m:b	(Ljava/lang/String;)V
    //   544: aload 6
    //   546: aload_2
    //   547: invokestatic 234	com/microsoft/codepush/react/i:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   550: astore 45
    //   552: aload 45
    //   554: ifnonnull +69 -> 623
    //   557: new 236	com/microsoft/codepush/react/c
    //   560: dup
    //   561: new 190	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   568: ldc 238
    //   570: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_2
    //   574: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc 240
    //   579: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokespecial 241	com/microsoft/codepush/react/c:<init>	(Ljava/lang/String;)V
    //   588: athrow
    //   589: iconst_0
    //   590: istore 40
    //   592: goto -168 -> 424
    //   595: astore 41
    //   597: new 70	com/microsoft/codepush/react/f
    //   600: dup
    //   601: ldc 140
    //   603: aload 41
    //   605: invokespecial 75	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   608: athrow
    //   609: astore 20
    //   611: new 70	com/microsoft/codepush/react/f
    //   614: dup
    //   615: ldc 140
    //   617: aload 20
    //   619: invokespecial 75	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   622: athrow
    //   623: aload 7
    //   625: invokestatic 61	com/microsoft/codepush/react/m:c	(Ljava/lang/String;)Z
    //   628: ifeq +16 -> 644
    //   631: new 100	java/io/File
    //   634: dup
    //   635: aload 7
    //   637: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   640: invokevirtual 106	java/io/File:delete	()Z
    //   643: pop
    //   644: iload 44
    //   646: ifeq +67 -> 713
    //   649: ldc 243
    //   651: invokestatic 244	com/microsoft/codepush/react/j:b	(Ljava/lang/String;)V
    //   654: aload 4
    //   656: ifnull +65 -> 721
    //   659: iconst_1
    //   660: istore 46
    //   662: aload 6
    //   664: invokestatic 246	com/microsoft/codepush/react/i:c	(Ljava/lang/String;)Ljava/lang/String;
    //   667: invokestatic 61	com/microsoft/codepush/react/m:c	(Ljava/lang/String;)Z
    //   670: istore 47
    //   672: iload 46
    //   674: ifeq +64 -> 738
    //   677: iload 47
    //   679: ifeq +48 -> 727
    //   682: aload 6
    //   684: aload 5
    //   686: invokestatic 248	com/microsoft/codepush/react/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: aload 6
    //   691: aload 5
    //   693: aload 4
    //   695: invokestatic 250	com/microsoft/codepush/react/i:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   698: aload_1
    //   699: ldc 46
    //   701: aload 45
    //   703: invokestatic 253	com/microsoft/codepush/react/j:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   706: aload_1
    //   707: aload 7
    //   709: invokestatic 144	com/microsoft/codepush/react/j:a	(Lorg/json/JSONObject;Ljava/lang/String;)V
    //   712: return
    //   713: ldc 255
    //   715: invokestatic 244	com/microsoft/codepush/react/j:b	(Ljava/lang/String;)V
    //   718: goto -64 -> 654
    //   721: iconst_0
    //   722: istore 46
    //   724: goto -62 -> 662
    //   727: new 236	com/microsoft/codepush/react/c
    //   730: dup
    //   731: ldc_w 257
    //   734: invokespecial 241	com/microsoft/codepush/react/c:<init>	(Ljava/lang/String;)V
    //   737: athrow
    //   738: iload 47
    //   740: ifeq +19 -> 759
    //   743: ldc_w 259
    //   746: invokestatic 244	com/microsoft/codepush/react/j:b	(Ljava/lang/String;)V
    //   749: aload 6
    //   751: aload 5
    //   753: invokestatic 248	com/microsoft/codepush/react/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: goto -58 -> 698
    //   759: iload 44
    //   761: ifeq -63 -> 698
    //   764: aload 6
    //   766: aload 5
    //   768: invokestatic 248	com/microsoft/codepush/react/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: goto -73 -> 698
    //   774: aload 32
    //   776: aload 6
    //   778: aload_2
    //   779: invokestatic 262	com/microsoft/codepush/react/m:a	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   782: goto -76 -> 706
    //   785: astore 14
    //   787: aconst_null
    //   788: astore 18
    //   790: aconst_null
    //   791: astore 17
    //   793: aconst_null
    //   794: astore 19
    //   796: aconst_null
    //   797: astore 15
    //   799: goto -500 -> 299
    //   802: astore 23
    //   804: aload 21
    //   806: astore 18
    //   808: aload 23
    //   810: astore 14
    //   812: aconst_null
    //   813: astore 17
    //   815: aconst_null
    //   816: astore 19
    //   818: aconst_null
    //   819: astore 15
    //   821: goto -522 -> 299
    //   824: astore 25
    //   826: aload 21
    //   828: astore 18
    //   830: aload 25
    //   832: astore 14
    //   834: aconst_null
    //   835: astore 17
    //   837: aconst_null
    //   838: astore 19
    //   840: goto -541 -> 299
    //   843: astore 53
    //   845: aload 21
    //   847: astore 18
    //   849: aload 53
    //   851: astore 14
    //   853: aconst_null
    //   854: astore 17
    //   856: goto -557 -> 299
    //   859: astore 9
    //   861: aconst_null
    //   862: astore 10
    //   864: aconst_null
    //   865: astore 11
    //   867: aconst_null
    //   868: astore 12
    //   870: aconst_null
    //   871: astore 13
    //   873: goto -608 -> 265
    //   876: astore 22
    //   878: aload 21
    //   880: astore 13
    //   882: aload 22
    //   884: astore 9
    //   886: aconst_null
    //   887: astore 10
    //   889: aconst_null
    //   890: astore 11
    //   892: aconst_null
    //   893: astore 12
    //   895: goto -630 -> 265
    //   898: astore 24
    //   900: aload 21
    //   902: astore 13
    //   904: aload 24
    //   906: astore 9
    //   908: aload 15
    //   910: astore 12
    //   912: aconst_null
    //   913: astore 10
    //   915: aconst_null
    //   916: astore 11
    //   918: goto -653 -> 265
    //   921: astore 52
    //   923: aload 19
    //   925: astore 11
    //   927: aload 21
    //   929: astore 13
    //   931: aload 52
    //   933: astore 9
    //   935: aload 15
    //   937: astore 12
    //   939: aconst_null
    //   940: astore 10
    //   942: goto -677 -> 265
    //   945: iload 50
    //   947: iload 38
    //   949: if_icmpge -748 -> 201
    //   952: iload 50
    //   954: lload 28
    //   956: l2i
    //   957: iadd
    //   958: istore 51
    //   960: iload 51
    //   962: iconst_4
    //   963: if_icmplt -621 -> 342
    //   966: goto -765 -> 201
    //   969: astore 33
    //   971: aload 21
    //   973: astore 18
    //   975: aload 33
    //   977: astore 14
    //   979: goto -680 -> 299
    //
    // Exception table:
    //   from	to	target	type
    //   158	169	239	java/net/MalformedURLException
    //   169	181	239	java/net/MalformedURLException
    //   209	236	239	java/net/MalformedURLException
    //   342	352	239	java/net/MalformedURLException
    //   366	404	239	java/net/MalformedURLException
    //   404	414	239	java/net/MalformedURLException
    //   265	277	277	finally
    //   429	434	595	java/io/IOException
    //   439	444	595	java/io/IOException
    //   449	454	595	java/io/IOException
    //   459	464	595	java/io/IOException
    //   304	309	609	java/io/IOException
    //   314	319	609	java/io/IOException
    //   324	329	609	java/io/IOException
    //   334	339	609	java/io/IOException
    //   48	68	785	finally
    //   68	91	802	finally
    //   91	99	824	finally
    //   102	145	824	finally
    //   145	158	843	finally
    //   48	68	859	java/net/MalformedURLException
    //   68	91	876	java/net/MalformedURLException
    //   91	99	898	java/net/MalformedURLException
    //   102	145	898	java/net/MalformedURLException
    //   145	158	921	java/net/MalformedURLException
    //   158	169	969	finally
    //   169	181	969	finally
    //   209	236	969	finally
    //   342	352	969	finally
    //   366	404	969	finally
    //   404	414	969	finally
  }

  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str1 = paramJSONObject.optString("packageHash", null);
    JSONObject localJSONObject = a();
    String str2 = localJSONObject.optString("currentPackage", null);
    if ((str1 != null) && (str1.equals(str2)))
      return;
    if (paramBoolean)
    {
      String str4 = b();
      if (str4 != null)
        m.a(str4);
    }
    while (true)
    {
      j.a(localJSONObject, "currentPackage", str1);
      a(localJSONObject);
      return;
      String str3 = d();
      if ((str3 != null) && (!str3.equals(str1)))
        m.a(b(str3));
      j.a(localJSONObject, "previousPackage", localJSONObject.optString("currentPackage", null));
    }
  }

  public String b()
  {
    String str = a().optString("currentPackage", null);
    if (str == null)
      return null;
    return b(str);
  }

  public String b(String paramString)
  {
    return j.a(k(), paramString);
  }

  public String c()
  {
    return a().optString("currentPackage", null);
  }

  public JSONObject c(String paramString)
  {
    String str = j.a(b(paramString), "app.json");
    try
    {
      JSONObject localJSONObject = j.a(str);
      return localJSONObject;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public String d()
  {
    return a().optString("previousPackage", null);
  }

  public JSONObject e()
  {
    String str = c();
    if (str == null)
      return null;
    return c(str);
  }

  public JSONObject f()
  {
    String str = d();
    if (str == null)
      return null;
    return c(str);
  }

  public void g()
  {
    JSONObject localJSONObject = a();
    m.a(b());
    j.a(localJSONObject, "currentPackage", localJSONObject.optString("previousPackage", null));
    j.a(localJSONObject, "previousPackage", null);
    a(localJSONObject);
  }

  public void h()
  {
    m.a(k());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.g
 * JD-Core Version:    0.6.2
 */