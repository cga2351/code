package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.util.Properties;

final class zzn
{
  private static zzo zzd(SharedPreferences paramSharedPreferences, String paramString)
    throws zzp
  {
    String str1 = paramSharedPreferences.getString(zzak.zzh(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(zzak.zzh(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
      return null;
    return new zzo(zzg(str1, str2), zze(paramSharedPreferences, paramString));
  }

  private static zzo zzd(File paramFile)
    throws zzp, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Properties localProperties = new Properties();
      localProperties.load(localFileInputStream);
      String str1 = localProperties.getProperty("pub");
      String str2 = localProperties.getProperty("pri");
      if ((str1 == null) || (str2 == null))
      {
        zzd(null, localFileInputStream);
        return null;
      }
      KeyPair localKeyPair = zzg(str1, str2);
      try
      {
        long l = Long.parseLong(localProperties.getProperty("cre"));
        zzo localzzo = new zzo(localKeyPair, l);
        zzd(null, localFileInputStream);
        return localzzo;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new zzp(localNumberFormatException);
      }
    }
    catch (Throwable localThrowable2)
    {
      Object localObject1;
      try
      {
        throw localThrowable2;
      }
      finally
      {
        localThrowable1 = localThrowable2;
      }
      zzd(localThrowable1, localFileInputStream);
      throw localObject1;
    }
    finally
    {
      while (true)
        Throwable localThrowable1 = null;
    }
  }

  private static void zzd(Context paramContext, String paramString, zzo paramzzo)
  {
    Object localObject1 = null;
    try
    {
      if (Log.isLoggable("InstanceID", 3))
        Log.d("InstanceID", "Writing key to properties file");
      File localFile = zzj(paramContext, paramString);
      localFile.createNewFile();
      Properties localProperties = new Properties();
      localProperties.setProperty("pub", zzo.zzd(paramzzo));
      localProperties.setProperty("pri", zzo.zze(paramzzo));
      localProperties.setProperty("cre", String.valueOf(zzo.zzf(paramzzo)));
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      try
      {
        localProperties.store(localFileOutputStream, null);
        zzd(null, localFileOutputStream);
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      finally
      {
        zzd(localThrowable, localFileOutputStream);
      }
    }
    catch (IOException localIOException)
    {
      String str = String.valueOf(localIOException);
      Log.w("InstanceID", 21 + String.valueOf(str).length() + "Failed to write key: " + str);
    }
  }

  private static long zze(SharedPreferences paramSharedPreferences, String paramString)
  {
    String str = paramSharedPreferences.getString(zzak.zzh(paramString, "cre"), null);
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

  private final void zze(Context paramContext, String paramString, zzo paramzzo)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramzzo.equals(zzd(localSharedPreferences, paramString));
      if (bool)
        return;
    }
    catch (zzp localzzp)
    {
      if (Log.isLoggable("InstanceID", 3))
        Log.d("InstanceID", "Writing key to shared preferences");
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString(zzak.zzh(paramString, "|P|"), zzo.zzd(paramzzo));
      localEditor.putString(zzak.zzh(paramString, "|K|"), zzo.zze(paramzzo));
      localEditor.putString(zzak.zzh(paramString, "cre"), String.valueOf(zzo.zzf(paramzzo)));
      localEditor.commit();
    }
  }

  // ERROR //
  private static KeyPair zzg(String paramString1, String paramString2)
    throws zzp
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 8
    //   3: invokestatic 210	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   6: astore_3
    //   7: aload_1
    //   8: bipush 8
    //   10: invokestatic 210	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   13: astore 4
    //   15: ldc 212
    //   17: invokestatic 218	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   20: astore 8
    //   22: new 220	java/security/KeyPair
    //   25: dup
    //   26: aload 8
    //   28: new 222	java/security/spec/X509EncodedKeySpec
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 225	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   36: invokevirtual 229	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   39: aload 8
    //   41: new 231	java/security/spec/PKCS8EncodedKeySpec
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 232	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   50: invokevirtual 236	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   53: invokespecial 239	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   56: astore 9
    //   58: aload 9
    //   60: areturn
    //   61: astore_2
    //   62: new 12	com/google/android/gms/iid/zzp
    //   65: dup
    //   66: aload_2
    //   67: invokespecial 81	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   70: athrow
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: astore 6
    //   80: ldc 84
    //   82: new 140	java/lang/StringBuilder
    //   85: dup
    //   86: bipush 19
    //   88: aload 6
    //   90: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   93: invokevirtual 144	java/lang/String:length	()I
    //   96: iadd
    //   97: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   100: ldc 241
    //   102: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 6
    //   107: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 160	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: new 12	com/google/android/gms/iid/zzp
    //   120: dup
    //   121: aload 5
    //   123: invokespecial 81	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
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

  static void zzg(Context paramContext, String paramString)
  {
    File localFile = zzj(paramContext, paramString);
    if (localFile.exists())
      localFile.delete();
  }

  private final zzo zzh(Context paramContext, String paramString)
    throws zzp
  {
    try
    {
      zzo localzzo2 = zzi(paramContext, paramString);
      if (localzzo2 != null)
      {
        zze(paramContext, paramString, localzzo2);
        return localzzo2;
      }
      localObject1 = null;
      try
      {
        zzo localzzo1 = zzd(paramContext.getSharedPreferences("com.google.android.gms.appid", 0), paramString);
        if (localzzo1 == null)
          break label72;
        zzd(paramContext, paramString, localzzo1);
        return localzzo1;
      }
      catch (zzp localzzp2)
      {
        if (localzzp2 == null)
          break label79;
      }
      throw localzzp2;
    }
    catch (zzp localzzp1)
    {
      while (true)
      {
        Object localObject1 = localzzp1;
        continue;
        label72: Object localObject2 = localObject1;
      }
    }
    label79: return null;
  }

  private final zzo zzi(Context paramContext, String paramString)
    throws zzp
  {
    File localFile = zzj(paramContext, paramString);
    if (!localFile.exists())
      return null;
    try
    {
      zzo localzzo2 = zzd(localFile);
      return localzzo2;
    }
    catch (IOException localIOException1)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        String str2 = String.valueOf(localIOException1);
        Log.d("InstanceID", 40 + String.valueOf(str2).length() + "Failed to read key from file, retrying: " + str2);
      }
      try
      {
        zzo localzzo1 = zzd(localFile);
        return localzzo1;
      }
      catch (IOException localIOException2)
      {
        String str1 = String.valueOf(localIOException2);
        Log.w("InstanceID", 45 + String.valueOf(str1).length() + "IID file exists, but failed to read from it: " + str1);
        throw new zzp(localIOException2);
      }
    }
  }

  static void zzi(Context paramContext)
  {
    for (File localFile : zzj(paramContext).listFiles())
      if (localFile.getName().startsWith("com.google.InstanceId"))
        localFile.delete();
  }

  private static File zzj(Context paramContext)
  {
    File localFile = ContextCompat.getNoBackupFilesDir(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
      return localFile;
    Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
    return paramContext.getFilesDir();
  }

  private static File zzj(Context paramContext, String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
      localObject = "com.google.InstanceId.properties";
    while (true)
    {
      return new File(zzj(paramContext), (String)localObject);
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

  final zzo zze(Context paramContext, String paramString)
    throws zzp
  {
    zzo localzzo = zzh(paramContext, paramString);
    if (localzzo != null)
      return localzzo;
    return zzf(paramContext, paramString);
  }

  final zzo zzf(Context paramContext, String paramString)
  {
    zzo localzzo1 = new zzo(zzd.zzl(), System.currentTimeMillis());
    try
    {
      zzo localzzo2 = zzh(paramContext, paramString);
      if (localzzo2 != null)
      {
        if (Log.isLoggable("InstanceID", 3))
          Log.d("InstanceID", "Loaded key after generating new one, using loaded one");
        return localzzo2;
      }
    }
    catch (zzp localzzp)
    {
      if (Log.isLoggable("InstanceID", 3))
        Log.d("InstanceID", "Generated new key");
      zzd(paramContext, paramString, localzzo1);
      zze(paramContext, paramString, localzzo1);
    }
    return localzzo1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzn
 * JD-Core Version:    0.6.2
 */