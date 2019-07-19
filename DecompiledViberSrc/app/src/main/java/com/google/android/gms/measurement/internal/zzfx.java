package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdq;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzfx extends zzcs
{
  private static final String[] zzauq = { "firebase_", "google_", "ga_" };
  private int zzado;
  private SecureRandom zzaur;
  private final AtomicLong zzaus = new AtomicLong(0L);
  private Integer zzaut = null;

  zzfx(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  static MessageDigest getMessageDigest()
  {
    int i = 0;
    while (i < 2)
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null)
          return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
    return null;
  }

  private static Object zza(int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null)
      paramObject = null;
    while (((paramObject instanceof Long)) || ((paramObject instanceof Double)))
      return paramObject;
    if ((paramObject instanceof Integer))
      return Long.valueOf(((Integer)paramObject).intValue());
    if ((paramObject instanceof Byte))
      return Long.valueOf(((Byte)paramObject).byteValue());
    if ((paramObject instanceof Short))
      return Long.valueOf(((Short)paramObject).shortValue());
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue());
      for (long l = 1L; ; l = 0L)
        return Long.valueOf(l);
    }
    if ((paramObject instanceof Float))
      return Double.valueOf(((Float)paramObject).doubleValue());
    if (((paramObject instanceof String)) || ((paramObject instanceof Character)) || ((paramObject instanceof CharSequence)))
      return zza(String.valueOf(paramObject), paramInt, paramBoolean);
    return null;
  }

  public static String zza(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
      paramString = null;
    while (paramString.codePointCount(0, paramString.length()) <= paramInt)
      return paramString;
    if (paramBoolean)
      return String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
    return null;
  }

  private static void zza(Bundle paramBundle, Object paramObject)
  {
    Preconditions.checkNotNull(paramBundle);
    if ((paramObject != null) && (((paramObject instanceof String)) || ((paramObject instanceof CharSequence))))
      paramBundle.putLong("_el", String.valueOf(paramObject).length());
  }

  static boolean zza(Context paramContext, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    if (Build.VERSION.SDK_INT >= 24)
      return zzc(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService");
    return zzc(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
  }

  private static boolean zza(Bundle paramBundle, int paramInt)
  {
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      return true;
    }
    return false;
  }

  private final boolean zza(String paramString1, String paramString2, int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramObject == null);
    Object localObject;
    do
    {
      ArrayList localArrayList;
      int i;
      int j;
      while (j >= i)
      {
        while (true)
        {
          return true;
          if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Double)))
            if (((paramObject instanceof String)) || ((paramObject instanceof Character)) || ((paramObject instanceof CharSequence)))
            {
              String str = String.valueOf(paramObject);
              if (str.codePointCount(0, str.length()) > paramInt)
              {
                zzgt().zzjj().zzd("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(str.length()));
                return false;
              }
            }
            else if ((!(paramObject instanceof Bundle)) || (!paramBoolean))
            {
              if ((!(paramObject instanceof Parcelable[])) || (!paramBoolean))
                break;
              for (Parcelable localParcelable : (Parcelable[])paramObject)
                if (!(localParcelable instanceof Bundle))
                {
                  zzgt().zzjj().zze("All Parcelable[] elements must be of type Bundle. Value type, name", localParcelable.getClass(), paramString2);
                  return false;
                }
            }
        }
        if ((!(paramObject instanceof ArrayList)) || (!paramBoolean))
          break;
        localArrayList = (ArrayList)paramObject;
        i = localArrayList.size();
        j = 0;
      }
      localObject = localArrayList.get(j);
      j++;
    }
    while ((localObject instanceof Bundle));
    zzgt().zzjj().zze("All ArrayList elements must be of type Bundle. Value type, name", localObject.getClass(), paramString2);
    return false;
    return false;
  }

  static boolean zza(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((!bool1) && (!bool2))
      if (paramString1.equals(paramString2));
    label77: 
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            return false;
            if ((!bool1) || (!bool2))
              break label77;
            if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
              break;
          }
          while (!paramString3.equals(paramString4));
          return false;
        }
        while (!TextUtils.isEmpty(paramString4));
        return false;
        if ((bool1) || (!bool2))
          break;
        if (TextUtils.isEmpty(paramString4))
          return false;
      }
      while ((TextUtils.isEmpty(paramString3)) || (!paramString3.equals(paramString4)));
      return false;
    }
    while ((TextUtils.isEmpty(paramString3)) || (!paramString3.equals(paramString4)));
    return false;
  }

  static byte[] zza(Parcelable paramParcelable)
  {
    if (paramParcelable == null)
      return null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      return arrayOfByte;
    }
    finally
    {
      localParcel.recycle();
    }
  }

  public static long zzc(long paramLong1, long paramLong2)
  {
    return (paramLong1 + 60000L * paramLong2) / 86400000L;
  }

  @VisibleForTesting
  static long zzc(byte[] paramArrayOfByte)
  {
    int i = 0;
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length > 0);
    long l;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      l = 0L;
      for (int j = -1 + paramArrayOfByte.length; (j >= 0) && (j >= -8 + paramArrayOfByte.length); j--)
      {
        l += ((0xFF & paramArrayOfByte[j]) << i);
        i += 8;
      }
    }
    return l;
  }

  private static boolean zzc(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
        return false;
      ServiceInfo localServiceInfo = localPackageManager.getServiceInfo(new ComponentName(paramContext, paramString), 0);
      if (localServiceInfo != null)
      {
        boolean bool = localServiceInfo.enabled;
        if (bool)
          return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  static boolean zzc(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    return ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(str)) || ("https://www.google.com".equals(str)) || ("android-app://com.google.appcrawler".equals(str));
  }

  static boolean zzct(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    boolean bool1;
    if (paramString.charAt(0) == '_')
    {
      boolean bool2 = paramString.equals("_ep");
      bool1 = false;
      if (!bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  @VisibleForTesting
  private static boolean zzcw(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return paramString.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
  }

  private static int zzcx(String paramString)
  {
    if ("_ldl".equals(paramString))
      return 2048;
    if ("_id".equals(paramString))
      return 256;
    return 36;
  }

  static boolean zzcy(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }

  public static Bundle zzd(List<zzfu> paramList)
  {
    Bundle localBundle = new Bundle();
    if (paramList == null)
      return localBundle;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zzfu localzzfu = (zzfu)localIterator.next();
      if (localzzfu.zzamn != null)
        localBundle.putString(localzzfu.name, localzzfu.zzamn);
      else if (localzzfu.zzaun != null)
        localBundle.putLong(localzzfu.name, localzzfu.zzaun.longValue());
      else if (localzzfu.zzaup != null)
        localBundle.putDouble(localzzfu.name, localzzfu.zzaup.doubleValue());
    }
    return localBundle;
  }

  @VisibleForTesting
  private final boolean zze(Context paramContext, String paramString)
  {
    X500Principal localX500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if ((localPackageInfo != null) && (localPackageInfo.signatures != null) && (localPackageInfo.signatures.length > 0))
      {
        Signature localSignature = localPackageInfo.signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(localSignature.toByteArray()))).getSubjectX500Principal().equals(localX500Principal);
        return bool;
      }
    }
    catch (CertificateException localCertificateException)
    {
      zzgt().zzjg().zzg("Error obtaining certificate", localCertificateException);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        zzgt().zzjg().zzg("Package name not found", localNameNotFoundException);
    }
  }

  public static Bundle zzf(Bundle paramBundle)
  {
    if (paramBundle == null)
      return new Bundle();
    Bundle localBundle = new Bundle(paramBundle);
    Iterator localIterator = localBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = localBundle.get(str);
      if ((localObject1 instanceof Bundle))
      {
        localBundle.putBundle(str, new Bundle((Bundle)localObject1));
      }
      else if ((localObject1 instanceof Parcelable[]))
      {
        Parcelable[] arrayOfParcelable = (Parcelable[])localObject1;
        for (int j = 0; j < arrayOfParcelable.length; j++)
          if ((arrayOfParcelable[j] instanceof Bundle))
            arrayOfParcelable[j] = new Bundle((Bundle)arrayOfParcelable[j]);
      }
      else if ((localObject1 instanceof List))
      {
        List localList = (List)localObject1;
        for (int i = 0; i < localList.size(); i++)
        {
          Object localObject2 = localList.get(i);
          if ((localObject2 instanceof Bundle))
            localList.set(i, new Bundle((Bundle)localObject2));
        }
      }
    }
    return localBundle;
  }

  static Bundle[] zzf(Object paramObject)
  {
    if ((paramObject instanceof Bundle))
    {
      Bundle[] arrayOfBundle = new Bundle[1];
      arrayOfBundle[0] = ((Bundle)paramObject);
      return arrayOfBundle;
    }
    if ((paramObject instanceof Parcelable[]))
      return (Bundle[])Arrays.copyOf((Parcelable[])paramObject, ((Parcelable[])paramObject).length, [Landroid.os.Bundle.class);
    if ((paramObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)paramObject;
      return (Bundle[])localArrayList.toArray(new Bundle[localArrayList.size()]);
    }
    return null;
  }

  private final boolean zzt(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzgt().zzjg().zzg("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzgt().zzjg().zzg("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95))
    {
      zzgt().zzjg().zze("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    int k = Character.charCount(i);
    while (k < j)
    {
      int m = paramString2.codePointAt(k);
      if ((m != 95) && (!Character.isLetterOrDigit(m)))
      {
        zzgt().zzjg().zze("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      k += Character.charCount(m);
    }
    return true;
  }

  static boolean zzv(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null))
      return true;
    if (paramString1 == null)
      return false;
    return paramString1.equals(paramString2);
  }

  final Bundle zza(Uri paramUri)
  {
    Bundle localBundle = null;
    if (paramUri == null)
      return localBundle;
    while (true)
    {
      try
      {
        if (paramUri.isHierarchical())
        {
          str4 = paramUri.getQueryParameter("utm_campaign");
          str3 = paramUri.getQueryParameter("utm_source");
          str2 = paramUri.getQueryParameter("utm_medium");
          String str10 = paramUri.getQueryParameter("gclid");
          str1 = str10;
          if ((TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str2)))
          {
            boolean bool = TextUtils.isEmpty(str1);
            localBundle = null;
            if (bool)
              break;
          }
          localBundle = new Bundle();
          if (!TextUtils.isEmpty(str4))
            localBundle.putString("campaign", str4);
          if (!TextUtils.isEmpty(str3))
            localBundle.putString("source", str3);
          if (!TextUtils.isEmpty(str2))
            localBundle.putString("medium", str2);
          if (!TextUtils.isEmpty(str1))
            localBundle.putString("gclid", str1);
          String str5 = paramUri.getQueryParameter("utm_term");
          if (!TextUtils.isEmpty(str5))
            localBundle.putString("term", str5);
          String str6 = paramUri.getQueryParameter("utm_content");
          if (!TextUtils.isEmpty(str6))
            localBundle.putString("content", str6);
          String str7 = paramUri.getQueryParameter("aclid");
          if (!TextUtils.isEmpty(str7))
            localBundle.putString("aclid", str7);
          String str8 = paramUri.getQueryParameter("cp1");
          if (!TextUtils.isEmpty(str8))
            localBundle.putString("cp1", str8);
          String str9 = paramUri.getQueryParameter("anid");
          if (TextUtils.isEmpty(str9))
            break;
          localBundle.putString("anid", str9);
          return localBundle;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        zzgt().zzjj().zzg("Install referrer url isn't a hierarchical URI", localUnsupportedOperationException);
        return null;
      }
      String str1 = null;
      String str2 = null;
      String str3 = null;
      String str4 = null;
    }
  }

  final Bundle zza(String paramString1, String paramString2, Bundle paramBundle, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        int j;
        if (paramList != null)
        {
          boolean bool2 = paramList.contains(str1);
          j = 0;
          if (bool2);
        }
        else
        {
          j = 0;
          if (paramBoolean1)
          {
            if (zzs("event param", str1))
              break label174;
            j = 3;
          }
          label100: if (j == 0)
          {
            if (zzt("event param", str1))
              break label220;
            j = 3;
          }
        }
        while (true)
        {
          if (j == 0)
            break label266;
          if (zza(localBundle, j))
          {
            localBundle.putString("_ev", zza(str1, 40, true));
            if (j == 3)
              zza(localBundle, str1);
          }
          localBundle.remove(str1);
          break;
          label174: if (!zza("event param", null, str1))
          {
            j = 14;
            break label100;
          }
          if (!zza("event param", 40, str1))
          {
            j = 3;
            break label100;
          }
          j = 0;
          break label100;
          label220: if (!zza("event param", null, str1))
            j = 14;
          else if (!zza("event param", 40, str1))
            j = 3;
          else
            j = 0;
        }
        label266: Object localObject2 = paramBundle.get(str1);
        zzaf();
        int i1;
        label299: int n;
        label333: int k;
        if (paramBoolean2)
          if ((localObject2 instanceof Parcelable[]))
          {
            i1 = ((Parcelable[])localObject2).length;
            if (i1 <= 1000)
              break label432;
            zzgt().zzjj().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str1, Integer.valueOf(i1));
            n = 0;
            if (n != 0)
              break label438;
            k = 17;
          }
        while (true)
        {
          if ((k == 0) || ("_ev".equals(str1)))
            break label519;
          if (zza(localBundle, k))
          {
            localBundle.putString("_ev", zza(str1, 40, true));
            zza(localBundle, paramBundle.get(str1));
          }
          localBundle.remove(str1);
          break;
          if ((localObject2 instanceof ArrayList))
          {
            i1 = ((ArrayList)localObject2).size();
            break label299;
          }
          n = 1;
          break label333;
          label432: n = 1;
          break label333;
          label438: if (((zzgv().zzav(paramString1)) && (zzcy(paramString2))) || (zzcy(str1)));
          for (boolean bool1 = zza("param", str1, 256, localObject2, paramBoolean2); ; bool1 = zza("param", str1, 100, localObject2, paramBoolean2))
          {
            if (!bool1)
              break label513;
            k = 0;
            break;
          }
          label513: k = 4;
        }
        label519: int m;
        if (zzct(str1))
        {
          m = i + 1;
          if (m > 25)
          {
            String str2 = 48 + "Event can't contain more than 25 params";
            zzgt().zzjg().zze(str2, zzgq().zzbt(paramString2), zzgq().zzd(paramBundle));
            zza(localBundle, 5);
            localBundle.remove(str1);
            i = m;
          }
        }
        else
        {
          m = i;
          i = m;
        }
      }
      localObject1 = localBundle;
    }
    return localObject1;
  }

  final zzag zza(String paramString1, String paramString2, Bundle paramBundle, String paramString3, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2))
      return null;
    if (zzcu(paramString2) != 0)
    {
      zzgt().zzjg().zzg("Invalid conditional property event name", zzgq().zzbv(paramString2));
      throw new IllegalArgumentException();
    }
    if (paramBundle != null);
    for (Bundle localBundle = new Bundle(paramBundle); ; localBundle = new Bundle())
    {
      localBundle.putString("_o", paramString3);
      return new zzag(paramString2, new zzad(zze(zza(paramString1, paramString2, localBundle, CollectionUtils.listOf("_o"), false, false))), paramString3, paramLong);
    }
  }

  public final void zza(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    zza(null, paramInt1, paramString1, paramString2, paramInt2);
  }

  final void zza(Bundle paramBundle, long paramLong)
  {
    long l = paramBundle.getLong("_et");
    if (l != 0L)
      zzgt().zzjj().zzg("Params already contained engagement", Long.valueOf(l));
    paramBundle.putLong("_et", l + paramLong);
  }

  final void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null);
    do
    {
      return;
      if ((paramObject instanceof Long))
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof String))
      {
        paramBundle.putString(paramString, String.valueOf(paramObject));
        return;
      }
      if ((paramObject instanceof Double))
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
    }
    while (paramString == null);
    if (paramObject != null);
    for (String str = paramObject.getClass().getSimpleName(); ; str = null)
    {
      zzgt().zzjl().zze("Not putting event parameter. Invalid value type. name, type", zzgq().zzbu(paramString), str);
      return;
    }
  }

  public final void zza(zzdq paramzzdq, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("r", paramInt);
    try
    {
      paramzzdq.zzb(localBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzada.zzgt().zzjj().zzg("Error returning int value to wrapper", localRemoteException);
    }
  }

  public final void zza(zzdq paramzzdq, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("r", paramLong);
    try
    {
      paramzzdq.zzb(localBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzada.zzgt().zzjj().zzg("Error returning long value to wrapper", localRemoteException);
    }
  }

  public final void zza(zzdq paramzzdq, Bundle paramBundle)
  {
    try
    {
      paramzzdq.zzb(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzada.zzgt().zzjj().zzg("Error returning bundle value to wrapper", localRemoteException);
    }
  }

  public final void zza(zzdq paramzzdq, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("r", paramArrayOfByte);
    try
    {
      paramzzdq.zzb(localBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzada.zzgt().zzjj().zzg("Error returning byte array to wrapper", localRemoteException);
    }
  }

  final void zza(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    zza(localBundle, paramInt1);
    if (zzgv().zze(paramString1, zzai.zzali))
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
        localBundle.putString(paramString2, paramString3);
    while (true)
    {
      if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2))
        localBundle.putLong("_el", paramInt2);
      this.zzada.zzgw();
      this.zzada.zzgj().logEvent("auto", "_err", localBundle);
      return;
      if (!TextUtils.isEmpty(paramString2))
        localBundle.putString(paramString2, paramString3);
    }
  }

  final boolean zza(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      zzgt().zzjg().zzg("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      zzgt().zzjg().zzd("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }

  final boolean zza(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (paramString2 == null)
    {
      zzgt().zzjg().zzg("Name is required and can't be null. Type", paramString1);
      return false;
    }
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString = zzauq;
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
      if (!paramString2.startsWith(arrayOfString[j]));
    for (int k = 1; ; k = 0)
    {
      if (k == 0)
        break label94;
      zzgt().zzjg().zze("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      return false;
      j++;
      break;
    }
    label94: if (paramArrayOfString != null)
    {
      Preconditions.checkNotNull(paramArrayOfString);
      int m = paramArrayOfString.length;
      int n = 0;
      if (n < m)
        if (!zzv(paramString2, paramArrayOfString[n]));
      for (int i1 = 1; ; i1 = 0)
      {
        if (i1 == 0)
          break label165;
        zzgt().zzjg().zze("Name is reserved. Type, name", paramString1, paramString2);
        return false;
        n++;
        break;
      }
    }
    label165: return true;
  }

  public final void zzb(zzdq paramzzdq, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("r", paramString);
    try
    {
      paramzzdq.zzb(localBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzada.zzgt().zzjj().zzg("Error returning string value to wrapper", localRemoteException);
    }
  }

  final int zzcu(String paramString)
  {
    if (!zzt("event", paramString));
    do
    {
      return 2;
      if (!zza("event", zzcu.zzaqt, paramString))
        return 13;
    }
    while (!zza("event", 40, paramString));
    return 0;
  }

  final int zzcv(String paramString)
  {
    if (!zzt("user property", paramString));
    do
    {
      return 6;
      if (!zza("user property", zzcw.zzaqx, paramString))
        return 15;
    }
    while (!zza("user property", 24, paramString));
    return 0;
  }

  final boolean zzcz(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    String str = zzgv().zzid();
    zzgw();
    return str.equals(paramString);
  }

  final long zzd(Context paramContext, String paramString)
  {
    zzaf();
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotEmpty(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    MessageDigest localMessageDigest = getMessageDigest();
    if (localMessageDigest == null)
    {
      zzgt().zzjg().zzby("Could not get MD5 instance");
      return -1L;
    }
    if (localPackageManager != null)
      try
      {
        if (!zze(paramContext, paramString))
        {
          PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(getContext().getPackageName(), 64);
          if ((localPackageInfo.signatures != null) && (localPackageInfo.signatures.length > 0))
            return zzc(localMessageDigest.digest(localPackageInfo.signatures[0].toByteArray()));
          zzgt().zzjj().zzby("Could not get signatures");
          return -1L;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        zzgt().zzjg().zzg("Package name not found", localNameNotFoundException);
      }
    return 0L;
  }

  final Bundle zze(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zzh(str, paramBundle.get(str));
        if (localObject == null)
          zzgt().zzjj().zzg("Param value can't be null", zzgq().zzbu(str));
        else
          zza(localBundle, str, localObject);
      }
    }
    return localBundle;
  }

  protected final boolean zzgy()
  {
    return true;
  }

  protected final void zzgz()
  {
    zzaf();
    SecureRandom localSecureRandom = new SecureRandom();
    long l = localSecureRandom.nextLong();
    if (l == 0L)
    {
      l = localSecureRandom.nextLong();
      if (l == 0L)
        zzgt().zzjj().zzby("Utils falling back to Random for random id");
    }
    this.zzaus.set(l);
  }

  final Object zzh(String paramString, Object paramObject)
  {
    int i = 256;
    if ("_ev".equals(paramString))
      return zza(i, paramObject, true);
    if (zzcy(paramString));
    while (true)
    {
      return zza(i, paramObject, false);
      i = 100;
    }
  }

  final int zzi(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString));
    for (boolean bool = zza("user property referrer", paramString, zzcx(paramString), paramObject, false); bool; bool = zza("user property", paramString, zzcx(paramString), paramObject, false))
      return 0;
    return 7;
  }

  final Object zzj(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString))
      return zza(zzcx(paramString), paramObject, true);
    return zza(zzcx(paramString), paramObject, false);
  }

  public final long zzmj()
  {
    if (this.zzaus.get() == 0L)
      synchronized (this.zzaus)
      {
        long l2 = new Random(System.nanoTime() ^ zzbx().currentTimeMillis()).nextLong();
        int i = 1 + this.zzado;
        this.zzado = i;
        long l3 = l2 + i;
        return l3;
      }
    synchronized (this.zzaus)
    {
      this.zzaus.compareAndSet(-1L, 1L);
      long l1 = this.zzaus.getAndIncrement();
      return l1;
    }
  }

  final SecureRandom zzmk()
  {
    zzaf();
    if (this.zzaur == null)
      this.zzaur = new SecureRandom();
    return this.zzaur;
  }

  public final int zzml()
  {
    if (this.zzaut == null)
      this.zzaut = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
    return this.zzaut.intValue();
  }

  final String zzmm()
  {
    byte[] arrayOfByte = new byte[16];
    zzmk().nextBytes(arrayOfByte);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new BigInteger(1, arrayOfByte);
    return String.format(localLocale, "%032x", arrayOfObject);
  }

  public final int zzs(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(getContext(), 12451000);
  }

  final boolean zzs(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzgt().zzjg().zzg("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzgt().zzjg().zzg("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      zzgt().zzjg().zze("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    int k = Character.charCount(i);
    while (k < j)
    {
      int m = paramString2.codePointAt(k);
      if ((m != 95) && (!Character.isLetterOrDigit(m)))
      {
        zzgt().zzjg().zze("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      k += Character.charCount(m);
    }
    return true;
  }

  final boolean zzu(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (zzcw(paramString1))
        break label101;
      if (this.zzada.zzkn())
        zzgt().zzjg().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzas.zzbw(paramString1));
    }
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (zzcw(paramString2))
          break;
        zzgt().zzjg().zzg("Invalid admob_app_id. Analytics disabled.", zzas.zzbw(paramString2));
        return false;
      }
    }
    while (!this.zzada.zzkn());
    zzgt().zzjg().zzby("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
    return false;
    label101: return true;
  }

  final boolean zzx(String paramString)
  {
    zzaf();
    if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(paramString) == 0)
      return true;
    zzgt().zzjn().zzg("Permission not granted", paramString);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfx
 * JD-Core Version:    0.6.2
 */