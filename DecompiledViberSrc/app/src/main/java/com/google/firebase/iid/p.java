package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import com.google.firebase.b;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class p
{
  private final Context a;

  @GuardedBy("this")
  private String b;

  @GuardedBy("this")
  private String c;

  @GuardedBy("this")
  private int d;

  @GuardedBy("this")
  private int e = 0;

  public p(Context paramContext)
  {
    this.a = paramContext;
  }

  private final PackageInfo a(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo(paramString, 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str = String.valueOf(localNameNotFoundException);
      Log.w("FirebaseInstanceId", 23 + String.valueOf(str).length() + "Failed to find package " + str);
    }
    return null;
  }

  public static String a(FirebaseApp paramFirebaseApp)
  {
    String str = paramFirebaseApp.c().b();
    if (str != null);
    do
    {
      do
      {
        return str;
        str = paramFirebaseApp.c().a();
      }
      while (!str.startsWith("1:"));
      String[] arrayOfString = str.split(":");
      if (arrayOfString.length < 2)
        return null;
      str = arrayOfString[1];
    }
    while (!str.isEmpty());
    return null;
  }

  public static String a(KeyPair paramKeyPair)
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
      Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
    }
    return null;
  }

  private final void e()
  {
    try
    {
      PackageInfo localPackageInfo = a(this.a.getPackageName());
      if (localPackageInfo != null)
      {
        this.b = Integer.toString(localPackageInfo.versionCode);
        this.c = localPackageInfo.versionName;
      }
      return;
    }
    finally
    {
    }
  }

  public final int a()
  {
    int i;
    while (true)
    {
      PackageManager localPackageManager;
      try
      {
        if (this.e != 0)
        {
          i = this.e;
          return i;
        }
        localPackageManager = this.a.getPackageManager();
        if (localPackageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1)
        {
          Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
          i = 0;
          continue;
        }
      }
      finally
      {
      }
      if (!PlatformVersion.isAtLeastO())
      {
        Intent localIntent1 = new Intent("com.google.android.c2dm.intent.REGISTER");
        localIntent1.setPackage("com.google.android.gms");
        List localList1 = localPackageManager.queryIntentServices(localIntent1, 0);
        if ((localList1 != null) && (localList1.size() > 0))
        {
          this.e = 1;
          i = this.e;
        }
      }
      else
      {
        Intent localIntent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        localIntent2.setPackage("com.google.android.gms");
        List localList2 = localPackageManager.queryBroadcastReceivers(localIntent2, 0);
        if ((localList2 == null) || (localList2.size() <= 0))
          break;
        this.e = 2;
        i = this.e;
      }
    }
    Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
    if (PlatformVersion.isAtLeastO());
    for (this.e = 2; ; this.e = 1)
    {
      i = this.e;
      break;
    }
  }

  public final String b()
  {
    try
    {
      if (this.b == null)
        e();
      String str = this.b;
      return str;
    }
    finally
    {
    }
  }

  public final String c()
  {
    try
    {
      if (this.c == null)
        e();
      String str = this.c;
      return str;
    }
    finally
    {
    }
  }

  public final int d()
  {
    try
    {
      if (this.d == 0)
      {
        PackageInfo localPackageInfo = a("com.google.android.gms");
        if (localPackageInfo != null)
          this.d = localPackageInfo.versionCode;
      }
      int i = this.d;
      return i;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.p
 * JD-Core Version:    0.6.2
 */