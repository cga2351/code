package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class InstanceID
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String ERROR_TIMEOUT = "TIMEOUT";
  private static final zzaj<Boolean> zzbu = zzai.zzy().zzd("gcm_check_for_different_iid_in_token", true);
  private static Map<String, InstanceID> zzbv = new ArrayMap();
  private static final long zzbw = TimeUnit.DAYS.toMillis(7L);
  private static zzak zzbx;
  private static zzaf zzby;
  private static String zzbz;
  private String zzca = "";
  private Context zzl;

  @ShowFirstParty
  private InstanceID(Context paramContext, String paramString)
  {
    this.zzl = paramContext.getApplicationContext();
    this.zzca = paramString;
  }

  @Deprecated
  public static InstanceID getInstance(Context paramContext)
  {
    return getInstance(paramContext, null);
  }

  @KeepForSdk
  public static InstanceID getInstance(Context paramContext, Bundle paramBundle)
  {
    Object localObject2;
    if (paramBundle == null)
      localObject2 = "";
    while (true)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (zzbx == null)
        {
          String str2 = localContext.getPackageName();
          Log.w("InstanceID", 73 + String.valueOf(str2).length() + "Instance ID SDK is deprecated, " + str2 + " should update to use Firebase Instance ID");
          zzbx = new zzak(localContext);
          zzby = new zzaf(localContext);
        }
        zzbz = Integer.toString(zzg(localContext));
        InstanceID localInstanceID = (InstanceID)zzbv.get(localObject3);
        if (localInstanceID == null)
        {
          localInstanceID = new InstanceID(localContext, (String)localObject3);
          zzbv.put(localObject3, localInstanceID);
        }
        return localInstanceID;
        String str1 = paramBundle.getString("subtype");
        localObject2 = str1;
      }
      finally
      {
      }
      while (localObject2 != null)
      {
        localObject3 = localObject2;
        break;
      }
      Object localObject3 = "";
    }
  }

  private final KeyPair getKeyPair()
  {
    return zzbx.zzj(this.zzca).getKeyPair();
  }

  static String zzd(KeyPair paramKeyPair)
  {
    byte[] arrayOfByte1 = paramKeyPair.getPublic().getEncoded();
    try
    {
      byte[] arrayOfByte2 = MessageDigest.getInstance("SHA1").digest(arrayOfByte1);
      arrayOfByte2[0] = ((byte)(112 + (0xF & arrayOfByte2[0])));
      String str = Base64.encodeToString(arrayOfByte2, 0, 8, 11);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Log.w("InstanceID", "Unexpected error, device missing required algorithms");
    }
    return null;
  }

  static int zzg(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str = String.valueOf(localNameNotFoundException);
      Log.w("InstanceID", 38 + String.valueOf(str).length() + "Never happens: can't find own package " + str);
    }
    return 0;
  }

  static String zzh(Context paramContext)
  {
    try
    {
      String str2 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str1 = String.valueOf(localNameNotFoundException);
      Log.w("InstanceID", 38 + String.valueOf(str1).length() + "Never happens: can't find own package " + str1);
    }
    return null;
  }

  public static zzak zzp()
  {
    return zzbx;
  }

  @Deprecated
  public void deleteInstanceID()
    throws IOException
  {
    zzd("*", "*", null);
    zzo();
  }

  @Deprecated
  public void deleteToken(String paramString1, String paramString2)
    throws IOException
  {
    zzd(paramString1, paramString2, null);
  }

  @Deprecated
  public long getCreationTime()
  {
    return zzbx.zzj(this.zzca).getCreationTime();
  }

  @Deprecated
  public String getId()
  {
    return zzd(getKeyPair());
  }

  @KeepForSdk
  public String getSubtype()
  {
    return this.zzca;
  }

  @Deprecated
  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    return getToken(paramString1, paramString2, null);
  }

  @Deprecated
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    int i = 1;
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    String str1 = zzbx.get("appVersion");
    if ((str1 == null) || (!str1.equals(zzbz)));
    String str2;
    while (true)
    {
      str2 = null;
      if (i == 0)
        str2 = zzbx.zzf(this.zzca, paramString1, paramString2);
      if (str2 != null)
        break label228;
      if (paramBundle == null)
        paramBundle = new Bundle();
      str2 = zze(paramString1, paramString2, paramBundle);
      if ((!((Boolean)zzbu.get()).booleanValue()) || (!str2.contains(":")) || (str2.startsWith(String.valueOf(getId()).concat(":"))))
        break;
      InstanceIDListenerService.zzd(this.zzl, zzbx);
      throw new IOException("SERVICE_NOT_AVAILABLE");
      long l = zzbx.zzg(this.zzca, paramString1, paramString2);
      if ((l >= 0L) && (System.currentTimeMillis() - l < zzbw))
        i = 0;
    }
    if (str2 != null)
      zzbx.zzd(this.zzca, paramString1, paramString2, str2, zzbz);
    label228: return str2;
  }

  @ShowFirstParty
  public final void zzd(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    zzbx.zzh(this.zzca, paramString1, paramString2);
    if (paramBundle == null)
      paramBundle = new Bundle();
    paramBundle.putString("sender", paramString1);
    if (paramString2 != null)
      paramBundle.putString("scope", paramString2);
    paramBundle.putString("subscription", paramString1);
    paramBundle.putString("delete", "1");
    paramBundle.putString("X-delete", "1");
    String str;
    if ("".equals(this.zzca))
    {
      str = paramString1;
      paramBundle.putString("subtype", str);
      if (!"".equals(this.zzca))
        break label159;
    }
    while (true)
    {
      paramBundle.putString("X-subtype", paramString1);
      zzaf.zzi(zzby.zzd(paramBundle, getKeyPair()));
      return;
      str = this.zzca;
      break;
      label159: paramString1 = this.zzca;
    }
  }

  public final String zze(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (paramString2 != null)
      paramBundle.putString("scope", paramString2);
    paramBundle.putString("sender", paramString1);
    if ("".equals(this.zzca));
    String str2;
    for (String str1 = paramString1; ; str1 = this.zzca)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", str1);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", str1);
      }
      str2 = zzaf.zzi(zzby.zzd(paramBundle, getKeyPair()));
      if ((!"RST".equals(str2)) && (!str2.startsWith("RST|")))
        break;
      InstanceIDListenerService.zzd(this.zzl, zzbx);
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    return str2;
  }

  final void zzo()
  {
    zzbx.zzk(this.zzca);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.InstanceID
 * JD-Core Version:    0.6.2
 */