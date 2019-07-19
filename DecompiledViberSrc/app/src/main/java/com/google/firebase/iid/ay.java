package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyPair;
import java.util.Properties;

final class ay
{
  // ERROR //
  private final d a(Context paramContext, String paramString, d paramd, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 18
    //   2: iconst_3
    //   3: invokestatic 24	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   6: ifeq +11 -> 17
    //   9: ldc 18
    //   11: ldc 26
    //   13: invokestatic 30	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: new 32	java/util/Properties
    //   20: dup
    //   21: invokespecial 33	java/util/Properties:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 35
    //   30: aload_3
    //   31: invokestatic 40	com/google/firebase/iid/d:a	(Lcom/google/firebase/iid/d;)Ljava/lang/String;
    //   34: invokevirtual 44	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   37: pop
    //   38: aload 5
    //   40: ldc 46
    //   42: aload_3
    //   43: invokestatic 49	com/google/firebase/iid/d:b	(Lcom/google/firebase/iid/d;)Ljava/lang/String;
    //   46: invokevirtual 44	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   49: pop
    //   50: aload 5
    //   52: ldc 51
    //   54: aload_3
    //   55: invokestatic 55	com/google/firebase/iid/d:c	(Lcom/google/firebase/iid/d;)J
    //   58: invokestatic 61	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   61: invokevirtual 44	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_1
    //   66: aload_2
    //   67: invokestatic 65	com/google/firebase/iid/ay:e	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   70: astore 9
    //   72: aload 9
    //   74: invokevirtual 71	java/io/File:createNewFile	()Z
    //   77: pop
    //   78: new 73	java/io/RandomAccessFile
    //   81: dup
    //   82: aload 9
    //   84: ldc 75
    //   86: invokespecial 78	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore 14
    //   91: aload 14
    //   93: invokevirtual 82	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   96: astore 19
    //   98: aload 19
    //   100: invokevirtual 88	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   103: pop
    //   104: iload 4
    //   106: ifeq +106 -> 212
    //   109: aload 19
    //   111: invokevirtual 92	java/nio/channels/FileChannel:size	()J
    //   114: lstore 25
    //   116: lload 25
    //   118: lconst_0
    //   119: lcmp
    //   120: ifle +92 -> 212
    //   123: aload 19
    //   125: lconst_0
    //   126: invokevirtual 96	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   129: pop
    //   130: aload 19
    //   132: invokestatic 99	com/google/firebase/iid/ay:a	(Ljava/nio/channels/FileChannel;)Lcom/google/firebase/iid/d;
    //   135: astore 32
    //   137: aload 19
    //   139: ifnull +9 -> 148
    //   142: aconst_null
    //   143: aload 19
    //   145: invokestatic 102	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/nio/channels/FileChannel;)V
    //   148: aconst_null
    //   149: aload 14
    //   151: invokestatic 105	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/io/RandomAccessFile;)V
    //   154: aload 32
    //   156: areturn
    //   157: astore 28
    //   159: ldc 18
    //   161: iconst_3
    //   162: invokestatic 24	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   165: ifeq +47 -> 212
    //   168: aload 28
    //   170: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   173: astore 29
    //   175: ldc 18
    //   177: new 110	java/lang/StringBuilder
    //   180: dup
    //   181: bipush 64
    //   183: aload 29
    //   185: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   188: invokevirtual 114	java/lang/String:length	()I
    //   191: iadd
    //   192: invokespecial 117	java/lang/StringBuilder:<init>	(I)V
    //   195: ldc 119
    //   197: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 29
    //   202: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 30	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload 19
    //   214: lconst_0
    //   215: invokevirtual 96	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   218: pop
    //   219: aload 5
    //   221: aload 19
    //   223: invokestatic 133	java/nio/channels/Channels:newOutputStream	(Ljava/nio/channels/WritableByteChannel;)Ljava/io/OutputStream;
    //   226: aconst_null
    //   227: invokevirtual 137	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   230: aload 19
    //   232: ifnull +9 -> 241
    //   235: aconst_null
    //   236: aload 19
    //   238: invokestatic 102	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/nio/channels/FileChannel;)V
    //   241: aconst_null
    //   242: aload 14
    //   244: invokestatic 105	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/io/RandomAccessFile;)V
    //   247: aload_3
    //   248: areturn
    //   249: astore 10
    //   251: aload 10
    //   253: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: astore 11
    //   258: ldc 18
    //   260: new 110	java/lang/StringBuilder
    //   263: dup
    //   264: bipush 21
    //   266: aload 11
    //   268: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   271: invokevirtual 114	java/lang/String:length	()I
    //   274: iadd
    //   275: invokespecial 117	java/lang/StringBuilder:<init>	(I)V
    //   278: ldc 139
    //   280: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 11
    //   285: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 142	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   294: pop
    //   295: aconst_null
    //   296: areturn
    //   297: astore 22
    //   299: aload 22
    //   301: athrow
    //   302: astore 23
    //   304: aload 22
    //   306: astore 21
    //   308: aload 23
    //   310: astore 20
    //   312: aload 19
    //   314: ifnull +10 -> 324
    //   317: aload 21
    //   319: aload 19
    //   321: invokestatic 102	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/nio/channels/FileChannel;)V
    //   324: aload 20
    //   326: athrow
    //   327: astore 17
    //   329: aload 17
    //   331: athrow
    //   332: astore 18
    //   334: aload 17
    //   336: astore 16
    //   338: aload 18
    //   340: astore 15
    //   342: aload 16
    //   344: aload 14
    //   346: invokestatic 105	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/io/RandomAccessFile;)V
    //   349: aload 15
    //   351: athrow
    //   352: astore 15
    //   354: aconst_null
    //   355: astore 16
    //   357: goto -15 -> 342
    //   360: astore 20
    //   362: aconst_null
    //   363: astore 21
    //   365: goto -53 -> 312
    //   368: astore 28
    //   370: goto -211 -> 159
    //
    // Exception table:
    //   from	to	target	type
    //   123	137	157	com/google/firebase/iid/ba
    //   72	91	249	java/io/IOException
    //   148	154	249	java/io/IOException
    //   241	247	249	java/io/IOException
    //   342	352	249	java/io/IOException
    //   98	104	297	java/lang/Throwable
    //   109	116	297	java/lang/Throwable
    //   123	137	297	java/lang/Throwable
    //   159	212	297	java/lang/Throwable
    //   212	230	297	java/lang/Throwable
    //   299	302	302	finally
    //   91	98	327	java/lang/Throwable
    //   142	148	327	java/lang/Throwable
    //   235	241	327	java/lang/Throwable
    //   317	324	327	java/lang/Throwable
    //   324	327	327	java/lang/Throwable
    //   329	332	332	finally
    //   91	98	352	finally
    //   142	148	352	finally
    //   235	241	352	finally
    //   317	324	352	finally
    //   324	327	352	finally
    //   98	104	360	finally
    //   109	116	360	finally
    //   123	137	360	finally
    //   159	212	360	finally
    //   212	230	360	finally
    //   123	137	368	java/io/IOException
  }

  private static d a(SharedPreferences paramSharedPreferences, String paramString)
    throws ba
  {
    String str1 = paramSharedPreferences.getString(aa.a(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(aa.a(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
      return null;
    return new d(a(str1, str2), b(paramSharedPreferences, paramString));
  }

  // ERROR //
  private final d a(File paramFile)
    throws ba, IOException
  {
    // Byte code:
    //   0: new 169	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 173	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore 7
    //   15: aload 7
    //   17: lconst_0
    //   18: ldc2_w 174
    //   21: iconst_1
    //   22: invokevirtual 178	java/nio/channels/FileChannel:lock	(JJZ)Ljava/nio/channels/FileLock;
    //   25: pop
    //   26: aload 7
    //   28: invokestatic 99	com/google/firebase/iid/ay:a	(Ljava/nio/channels/FileChannel;)Lcom/google/firebase/iid/d;
    //   31: astore 13
    //   33: aload 7
    //   35: ifnull +9 -> 44
    //   38: aconst_null
    //   39: aload 7
    //   41: invokestatic 102	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/nio/channels/FileChannel;)V
    //   44: aconst_null
    //   45: aload_2
    //   46: invokestatic 181	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   49: aload 13
    //   51: areturn
    //   52: astore 10
    //   54: aload 10
    //   56: athrow
    //   57: astore 11
    //   59: aload 10
    //   61: astore 9
    //   63: aload 11
    //   65: astore 8
    //   67: aload 7
    //   69: ifnull +10 -> 79
    //   72: aload 9
    //   74: aload 7
    //   76: invokestatic 102	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/nio/channels/FileChannel;)V
    //   79: aload 8
    //   81: athrow
    //   82: astore 5
    //   84: aload 5
    //   86: athrow
    //   87: astore 6
    //   89: aload 5
    //   91: astore 4
    //   93: aload 6
    //   95: astore_3
    //   96: aload 4
    //   98: aload_2
    //   99: invokestatic 181	com/google/firebase/iid/ay:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   102: aload_3
    //   103: athrow
    //   104: astore_3
    //   105: aconst_null
    //   106: astore 4
    //   108: goto -12 -> 96
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 9
    //   116: goto -49 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   15	33	52	java/lang/Throwable
    //   54	57	57	finally
    //   9	15	82	java/lang/Throwable
    //   38	44	82	java/lang/Throwable
    //   72	79	82	java/lang/Throwable
    //   79	82	82	java/lang/Throwable
    //   84	87	87	finally
    //   9	15	104	finally
    //   38	44	104	finally
    //   72	79	104	finally
    //   79	82	104	finally
    //   15	33	111	finally
  }

  private static d a(FileChannel paramFileChannel)
    throws ba, IOException
  {
    Properties localProperties = new Properties();
    localProperties.load(Channels.newInputStream(paramFileChannel));
    String str1 = localProperties.getProperty("pub");
    String str2 = localProperties.getProperty("pri");
    if ((str1 == null) || (str2 == null))
      throw new ba("Invalid properties file");
    KeyPair localKeyPair = a(str1, str2);
    try
    {
      long l = Long.parseLong(localProperties.getProperty("cre"));
      return new d(localKeyPair, l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ba(localNumberFormatException);
    }
  }

  // ERROR //
  private static KeyPair a(String paramString1, String paramString2)
    throws ba
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 8
    //   3: invokestatic 221	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   6: astore_3
    //   7: aload_1
    //   8: bipush 8
    //   10: invokestatic 221	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   13: astore 4
    //   15: ldc 223
    //   17: invokestatic 229	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   20: astore 8
    //   22: new 231	java/security/KeyPair
    //   25: dup
    //   26: aload 8
    //   28: new 233	java/security/spec/X509EncodedKeySpec
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 236	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   36: invokevirtual 240	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   39: aload 8
    //   41: new 242	java/security/spec/PKCS8EncodedKeySpec
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 243	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   50: invokevirtual 247	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   53: invokespecial 250	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   56: astore 9
    //   58: aload 9
    //   60: areturn
    //   61: astore_2
    //   62: new 16	com/google/firebase/iid/ba
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 209	com/google/firebase/iid/ba:<init>	(Ljava/lang/Exception;)V
    //   70: athrow
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: astore 6
    //   80: ldc 18
    //   82: new 110	java/lang/StringBuilder
    //   85: dup
    //   86: bipush 19
    //   88: aload 6
    //   90: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 114	java/lang/String:length	()I
    //   96: iadd
    //   97: invokespecial 117	java/lang/StringBuilder:<init>	(I)V
    //   100: ldc 252
    //   102: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 6
    //   107: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 142	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: new 16	com/google/firebase/iid/ba
    //   120: dup
    //   121: aload 5
    //   123: invokespecial 209	com/google/firebase/iid/ba:<init>	(Ljava/lang/Exception;)V
    //   126: athrow
    //   127: astore 5
    //   129: goto -56 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   0	15	61	java/lang/IllegalArgumentException
    //   15	58	71	java/security/NoSuchAlgorithmException
    //   15	58	127	java/security/spec/InvalidKeySpecException
  }

  static void a(Context paramContext)
  {
    for (File localFile : b(paramContext).listFiles())
      if (localFile.getName().startsWith("com.google.InstanceId"))
        localFile.delete();
  }

  private final void a(Context paramContext, String paramString, d paramd)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramd.equals(a(localSharedPreferences, paramString));
      if (bool)
        return;
    }
    catch (ba localba)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Writing key to shared preferences");
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString(aa.a(paramString, "|P|"), d.a(paramd));
      localEditor.putString(aa.a(paramString, "|K|"), d.b(paramd));
      localEditor.putString(aa.a(paramString, "cre"), String.valueOf(d.c(paramd)));
      localEditor.commit();
    }
  }

  private static long b(SharedPreferences paramSharedPreferences, String paramString)
  {
    String str = paramSharedPreferences.getString(aa.a(paramString, "cre"), null);
    if (str != null)
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return 0L;
  }

  private static File b(Context paramContext)
  {
    File localFile = ContextCompat.getNoBackupFilesDir(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
      return localFile;
    Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
    return paramContext.getFilesDir();
  }

  private final d c(Context paramContext, String paramString)
    throws ba
  {
    try
    {
      d locald2 = d(paramContext, paramString);
      if (locald2 != null)
      {
        a(paramContext, paramString, locald2);
        return locald2;
      }
      localObject1 = null;
      try
      {
        d locald1 = a(paramContext.getSharedPreferences("com.google.android.gms.appid", 0), paramString);
        if (locald1 == null)
          break label76;
        a(paramContext, paramString, locald1, false);
        return locald1;
      }
      catch (ba localba2)
      {
        if (localba2 == null)
          break label83;
      }
      throw localba2;
    }
    catch (ba localba1)
    {
      while (true)
      {
        Object localObject1 = localba1;
        continue;
        label76: Object localObject2 = localObject1;
      }
    }
    label83: return null;
  }

  private final d d(Context paramContext, String paramString)
    throws ba
  {
    File localFile = e(paramContext, paramString);
    if (!localFile.exists())
      return null;
    try
    {
      d locald2 = a(localFile);
      return locald2;
    }
    catch (ba localba)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str2 = String.valueOf(localba);
        Log.d("FirebaseInstanceId", 40 + String.valueOf(str2).length() + "Failed to read key from file, retrying: " + str2);
      }
      try
      {
        d locald1 = a(localFile);
        return locald1;
      }
      catch (IOException localIOException2)
      {
        String str1 = String.valueOf(localIOException2);
        Log.w("FirebaseInstanceId", 45 + String.valueOf(str1).length() + "IID file exists, but failed to read from it: " + str1);
        throw new ba(localIOException2);
      }
    }
    catch (IOException localIOException1)
    {
      label27: break label27;
    }
  }

  private static File e(Context paramContext, String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
      localObject = "com.google.InstanceId.properties";
    while (true)
    {
      return new File(b(paramContext), (String)localObject);
      try
      {
        String str1 = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        String str2 = 33 + String.valueOf(str1).length() + "com.google.InstanceId_" + str1 + ".properties";
        localObject = str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }

  final d a(Context paramContext, String paramString)
    throws ba
  {
    d locald = c(paramContext, paramString);
    if (locald != null)
      return locald;
    return b(paramContext, paramString);
  }

  final d b(Context paramContext, String paramString)
  {
    d locald1 = new d(c.a(), System.currentTimeMillis());
    d locald2 = a(paramContext, paramString, locald1, true);
    if ((locald2 != null) && (!locald2.equals(locald1)))
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
        Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
      return locald2;
    }
    if (Log.isLoggable("FirebaseInstanceId", 3))
      Log.d("FirebaseInstanceId", "Generated new key");
    a(paramContext, paramString, locald1);
    return locald1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ay
 * JD-Core Version:    0.6.2
 */