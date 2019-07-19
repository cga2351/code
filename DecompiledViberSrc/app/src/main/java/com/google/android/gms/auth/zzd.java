package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.util.List;

public class zzd
{
  private static final String[] ACCEPTABLE_ACCOUNT_TYPES = { "com.google", "com.google.work", "cn.google" };
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";

  @SuppressLint({"InlinedApi"})
  public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";

  @SuppressLint({"InlinedApi"})
  public static final String KEY_CALLER_UID = "callerUid";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  public static final String WORK_ACCOUNT_TYPE = "com.google.work";
  private static final ComponentName zzm = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  private static final Logger zzn = new Logger("Auth", new String[] { "GoogleAuthUtil" });

  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    Bundle localBundle = new Bundle();
    String str = paramContext.getApplicationInfo().packageName;
    localBundle.putString("clientPackageName", str);
    if (!localBundle.containsKey(KEY_ANDROID_PACKAGE_NAME))
      localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
    zzf localzzf = new zzf(paramString, localBundle);
    zza(paramContext, zzm, localzzf);
  }

  private static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtilLight.ensurePlayServicesAvailable(paramContext.getApplicationContext(), paramInt);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new GooglePlayServicesAvailabilityException(localGooglePlayServicesRepairableException.getConnectionStatusCode(), localGooglePlayServicesRepairableException.getMessage(), localGooglePlayServicesRepairableException.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      throw new GoogleAuthException(localGooglePlayServicesNotAvailableException.getMessage());
    }
  }

  public static List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    zzg localzzg = new zzg(paramString, paramInt);
    return (List)zza(paramContext, zzm, localzzg);
  }

  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotEmpty(paramString, "accountName must be provided");
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    ensurePlayServicesAvailable(paramContext, 8400000);
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }

  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }

  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    zzb(paramAccount);
    return zzb(paramContext, paramAccount, paramString, paramBundle).zzb();
  }

  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }

  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }

  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }

  @TargetApi(23)
  public static Bundle removeAccount(Context paramContext, Account paramAccount)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotNull(paramContext);
    zzb(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    zzh localzzh = new zzh(paramAccount);
    return (Bundle)zza(paramContext, zzm, localzzh);
  }

  @TargetApi(26)
  public static Boolean requestGoogleAccountsAccess(Context paramContext)
    throws GoogleAuthException, IOException
  {
    Preconditions.checkNotNull(paramContext);
    ensurePlayServicesAvailable(paramContext, 11400000);
    zzi localzzi = new zzi(paramContext.getApplicationInfo().packageName);
    return (Boolean)zza(paramContext, zzm, localzzi);
  }

  // ERROR //
  private static <T> T zza(Context paramContext, ComponentName paramComponentName, zzj<T> paramzzj)
    throws IOException, GoogleAuthException
  {
    // Byte code:
    //   0: new 242	com/google/android/gms/common/BlockingServiceConnection
    //   3: dup
    //   4: invokespecial 243	com/google/android/gms/common/BlockingServiceConnection:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 249	com/google/android/gms/common/internal/GmsClientSupervisor:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/GmsClientSupervisor;
    //   12: astore 4
    //   14: aload 4
    //   16: aload_1
    //   17: aload_3
    //   18: ldc 68
    //   20: invokevirtual 253	com/google/android/gms/common/internal/GmsClientSupervisor:bindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   23: ifeq +79 -> 102
    //   26: aload_2
    //   27: aload_3
    //   28: invokevirtual 257	com/google/android/gms/common/BlockingServiceConnection:getService	()Landroid/os/IBinder;
    //   31: invokeinterface 262 2 0
    //   36: astore 7
    //   38: aload 4
    //   40: aload_1
    //   41: aload_3
    //   42: ldc 68
    //   44: invokevirtual 266	com/google/android/gms/common/internal/GmsClientSupervisor:unbindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   47: aload 7
    //   49: areturn
    //   50: astore 5
    //   52: getstatic 73	com/google/android/gms/auth/zzd:zzn	Lcom/google/android/gms/common/logging/Logger;
    //   55: ldc 68
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 268
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload 5
    //   71: aastore
    //   72: invokevirtual 272	com/google/android/gms/common/logging/Logger:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: new 83	java/io/IOException
    //   78: dup
    //   79: ldc_w 268
    //   82: aload 5
    //   84: invokespecial 275	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: astore 6
    //   90: aload 4
    //   92: aload_1
    //   93: aload_3
    //   94: ldc 68
    //   96: invokevirtual 266	com/google/android/gms/common/internal/GmsClientSupervisor:unbindService	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   99: aload 6
    //   101: athrow
    //   102: new 83	java/io/IOException
    //   105: dup
    //   106: ldc_w 277
    //   109: invokespecial 278	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   112: athrow
    //   113: astore 5
    //   115: goto -63 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   26	38	50	java/lang/InterruptedException
    //   26	38	88	finally
    //   52	88	88	finally
    //   26	38	113	android/os/RemoteException
  }

  private static <T> T zza(T paramT)
    throws IOException
  {
    if (paramT == null)
    {
      zzn.w("GoogleAuthUtil", new Object[] { "Binder call returned null." });
      throw new IOException("Service unavailable.");
    }
    return paramT;
  }

  public static TokenData zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    Preconditions.checkNotEmpty(paramString, "Scope cannot be empty or null.");
    zzb(paramAccount);
    ensurePlayServicesAvailable(paramContext, 8400000);
    if (paramBundle == null);
    for (Bundle localBundle = new Bundle(); ; localBundle = new Bundle(paramBundle))
    {
      String str = paramContext.getApplicationInfo().packageName;
      localBundle.putString("clientPackageName", str);
      if (TextUtils.isEmpty(localBundle.getString(KEY_ANDROID_PACKAGE_NAME)))
        localBundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
      localBundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
      zze localzze = new zze(paramAccount, paramString, localBundle);
      return (TokenData)zza(paramContext, zzm, localzze);
    }
  }

  private static void zzb(Account paramAccount)
  {
    if (paramAccount == null)
      throw new IllegalArgumentException("Account cannot be null");
    if (TextUtils.isEmpty(paramAccount.name))
      throw new IllegalArgumentException("Account name cannot be empty!");
    String[] arrayOfString = ACCEPTABLE_ACCOUNT_TYPES;
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      if (arrayOfString[j].equals(paramAccount.type))
        return;
    throw new IllegalArgumentException("Account type not supported");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.zzd
 * JD-Core Version:    0.6.2
 */