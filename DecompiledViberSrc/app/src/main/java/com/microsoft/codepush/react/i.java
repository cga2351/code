package com.microsoft.codepush.react;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Base64;
import com.e.b.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  public static final String a = System.getProperty("line.separator");

  public static String a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      String str2 = j.a(paramContext.getAssets().open("CodePushHash"));
      return str2;
    }
    catch (IOException localIOException1)
    {
      try
      {
        String str1 = j.a(paramContext.getAssets().open("CodePushHash.json"));
        return str1;
      }
      catch (IOException localIOException2)
      {
        if (!paramBoolean)
          j.b("Unable to get the hash of the binary's bundled resources - \"codepush.gradle\" may have not been added to the build definition.");
      }
    }
    return null;
  }

  // ERROR //
  private static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 52
    //   4: invokestatic 58	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore 6
    //   9: new 60	java/security/DigestInputStream
    //   12: dup
    //   13: aload_0
    //   14: aload 6
    //   16: invokespecial 64	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   19: astore 5
    //   21: sipush 8192
    //   24: newarray byte
    //   26: astore 7
    //   28: aload 5
    //   30: aload 7
    //   32: invokevirtual 68	java/security/DigestInputStream:read	([B)I
    //   35: istore 8
    //   37: iload 8
    //   39: iconst_m1
    //   40: if_icmpne -12 -> 28
    //   43: aload 5
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: invokevirtual 71	java/security/DigestInputStream:close	()V
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 74	java/io/InputStream:close	()V
    //   61: aload 6
    //   63: invokevirtual 78	java/security/MessageDigest:digest	()[B
    //   66: astore 10
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: astore 11
    //   74: aload 11
    //   76: iconst_0
    //   77: new 80	java/math/BigInteger
    //   80: dup
    //   81: iconst_1
    //   82: aload 10
    //   84: invokespecial 83	java/math/BigInteger:<init>	(I[B)V
    //   87: aastore
    //   88: ldc 85
    //   90: aload 11
    //   92: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: areturn
    //   96: astore 9
    //   98: aload 9
    //   100: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   103: goto -42 -> 61
    //   106: astore_2
    //   107: aconst_null
    //   108: astore 5
    //   110: aload 5
    //   112: astore_1
    //   113: new 96	com/microsoft/codepush/react/f
    //   116: dup
    //   117: ldc 98
    //   119: aload_2
    //   120: invokespecial 101	com/microsoft/codepush/react/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: athrow
    //   124: astore_3
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 71	java/security/DigestInputStream:close	()V
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 74	java/io/InputStream:close	()V
    //   141: aload_3
    //   142: athrow
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   150: goto -9 -> 141
    //   153: astore_3
    //   154: aload 5
    //   156: astore_1
    //   157: goto -32 -> 125
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -50 -> 113
    //   166: astore_2
    //   167: aload 5
    //   169: astore_1
    //   170: goto -57 -> 113
    //   173: astore_2
    //   174: goto -64 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   48	53	96	java/io/IOException
    //   57	61	96	java/io/IOException
    //   2	21	106	java/io/IOException
    //   2	21	124	finally
    //   113	124	124	finally
    //   129	133	143	java/io/IOException
    //   137	141	143	java/io/IOException
    //   21	28	153	finally
    //   28	37	153	finally
    //   2	21	160	java/security/NoSuchAlgorithmException
    //   21	28	166	java/security/NoSuchAlgorithmException
    //   28	37	166	java/security/NoSuchAlgorithmException
    //   21	28	173	java/io/IOException
    //   28	37	173	java/io/IOException
  }

  public static String a(String paramString1, String paramString2)
  {
    for (File localFile : new File(paramString1).listFiles())
    {
      String str1 = j.a(paramString1, localFile.getName());
      String str2;
      if (localFile.isDirectory())
      {
        String str3 = a(str1, paramString2);
        if (str3 != null)
          str2 = j.a(localFile.getName(), str3);
      }
      else
      {
        do
        {
          return str2;
          str2 = localFile.getName();
        }
        while (str2.equals(paramString2));
      }
    }
    return null;
  }

  public static Map<String, Object> a(String paramString, PublicKey paramPublicKey)
  {
    try
    {
      com.e.b.c localc = com.e.b.c.b(paramString);
      if (localc.a(new com.e.a.a.f((RSAPublicKey)paramPublicKey)))
      {
        Map localMap = localc.g().b();
        j.b("JWT verification succeeded, payload content: " + localMap.toString());
        return localMap;
      }
      return null;
    }
    catch (Exception localException)
    {
      j.b(localException.getMessage());
      j.b(localException.getStackTrace().toString());
    }
    return null;
  }

  public static void a(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    m.a(paramString2, paramString3);
    JSONObject localJSONObject = j.a(paramString1);
    try
    {
      JSONArray localJSONArray = localJSONObject.getJSONArray("deletedFiles");
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        File localFile = new File(paramString3, localJSONArray.getString(i));
        if (localFile.exists())
          localFile.delete();
      }
    }
    catch (JSONException localJSONException)
    {
      throw new f("Unable to copy files from current package during diff update", localJSONException);
    }
  }

  private static void a(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    File[] arrayOfFile = new File(paramString1).listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile = arrayOfFile[j];
      String str1 = localFile.getName();
      String str2 = localFile.getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      String str3;
      label66: String str4;
      if (paramString2.isEmpty())
      {
        str3 = "";
        str4 = str3 + str1;
        if (!a(str4))
          break label121;
      }
      while (true)
      {
        j++;
        break;
        str3 = paramString2 + "/";
        break label66;
        label121: if (localFile.isDirectory())
          a(str2, str4, paramArrayList);
        else
          try
          {
            paramArrayList.add(str4 + ":" + a(new FileInputStream(localFile)));
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            throw new f("Unable to compute hash of update contents.", localFileNotFoundException);
          }
      }
    }
  }

  public static boolean a(String paramString)
  {
    return (paramString.startsWith("__MACOSX/")) || (paramString.equals(".DS_Store")) || (paramString.endsWith("/.DS_Store")) || (paramString.equals(".codepushrelease")) || (paramString.endsWith("/.codepushrelease"));
  }

  public static PublicKey b(String paramString)
  {
    try
    {
      X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace(a, "").getBytes(), 0));
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(localX509EncodedKeySpec);
      return localPublicKey;
    }
    catch (Exception localException)
    {
      j.b(localException.getMessage());
      j.b(localException.getStackTrace().toString());
    }
    return null;
  }

  public static void b(String paramString1, String paramString2)
  {
    j.b("Verifying hash for folder path: " + paramString1);
    ArrayList localArrayList = new ArrayList();
    a(paramString1, "", localArrayList);
    Collections.sort(localArrayList);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put((String)localIterator.next());
    String str1 = localJSONArray.toString().replace("\\/", "/");
    j.b("Manifest string: " + str1);
    String str2 = a(new ByteArrayInputStream(str1.getBytes()));
    j.b("Expected hash: " + paramString2 + ", actual hash: " + str2);
    if (!paramString2.equals(str2))
      throw new c("The update contents failed the data integrity check.");
    j.b("The update contents succeeded the data integrity check.");
  }

  public static void b(String paramString1, String paramString2, String paramString3)
    throws c
  {
    j.b("Verifying signature for folder path: " + paramString1);
    PublicKey localPublicKey = b(paramString3);
    if (localPublicKey == null)
      throw new c("The update could not be verified because no public key was found.");
    String str1 = d(paramString1);
    if (str1 == null)
      throw new c("The update could not be verified because no signature was found.");
    Map localMap = a(str1, localPublicKey);
    if (localMap == null)
      throw new c("The update could not be verified because it was not signed by a trusted party.");
    String str2 = (String)localMap.get("contentHash");
    if (str2 == null)
      throw new c("The update could not be verified because the signature did not specify a content hash.");
    if (!str2.equals(paramString2))
      throw new c("The update contents failed the code signing check.");
    j.b("The update contents succeeded the code signing check.");
  }

  public static String c(String paramString)
  {
    return j.a(j.a(paramString, "CodePush"), ".codepushrelease");
  }

  public static String d(String paramString)
  {
    String str1 = c(paramString);
    try
    {
      String str2 = m.d(str1);
      return str2;
    }
    catch (IOException localIOException)
    {
      j.b(localIOException.getMessage());
      j.b(localIOException.getStackTrace().toString());
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.i
 * JD-Core Version:    0.6.2
 */