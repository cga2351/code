package com.viber.voip.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.permissions.n;
import com.viber.voip.settings.d.f;

public class ax
{
  private static final Logger a = ViberEnv.getLogger();

  public static String a()
  {
    if (!d.f.d.d())
      return "";
    try
    {
      if (com.viber.deviceinfo.a.a().c())
        return "";
      String str = com.viber.deviceinfo.a.a().b();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String a(PackageManager paramPackageManager)
  {
    try
    {
      String str1 = paramPackageManager.getPackageInfo("com.google.android.gms", 0).versionName;
      int i = str1.indexOf("(");
      if (i > 0)
      {
        String str2 = str1.substring(0, i - 1);
        return str2;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "";
  }

  public static void a(FragmentManager paramFragmentManager)
  {
    DialogFragment localDialogFragment = (DialogFragment)paramFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localDialogFragment != null)
      localDialogFragment.dismiss();
  }

  public static void a(com.google.a.a.b.a.a.b.a.a parama)
    throws com.viber.voip.k.b
  {
    if (parama.c() == null)
      throw new com.viber.voip.k.b("Google account is missing");
  }

  public static void a(com.google.a.a.b.a.a.b.a.d paramd, Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(paramd.d(), paramInt);
  }

  public static void a(com.google.a.a.b.a.a.b.a.d paramd, Fragment paramFragment, int paramInt)
  {
    paramFragment.startActivityForResult(paramd.d(), paramInt);
  }

  public static boolean a(Activity paramActivity, Fragment paramFragment, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt)
  {
    int i = b(paramActivity.getApplicationContext());
    if (i != 0)
    {
      GooglePlayServicesUtil.showErrorDialogFragment(i, paramActivity, paramFragment, paramInt, paramOnCancelListener);
      return false;
    }
    return true;
  }

  public static boolean a(Context paramContext)
  {
    GoogleApiAvailability localGoogleApiAvailability = GoogleApiAvailability.getInstance();
    int i = b(paramContext.getApplicationContext());
    return (i == 0) || ((localGoogleApiAvailability.isUserResolvableError(i)) && (cc.b("com.android.vending") != null));
  }

  public static boolean a(com.viber.voip.k.d paramd, Activity paramActivity, Fragment paramFragment, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt1, int paramInt2)
  {
    if (a(paramActivity, paramFragment, paramOnCancelListener, paramInt1))
    {
      if (paramd.d())
        return true;
      if (paramFragment == null)
        break label33;
      paramd.a(paramFragment, paramInt2);
    }
    while (true)
    {
      return false;
      label33: paramd.a(paramActivity, paramInt2);
    }
  }

  public static int b(Context paramContext)
  {
    try
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext.getApplicationContext());
      return i;
    }
    catch (Exception localException)
    {
      com.viber.provider.contacts.a.a.b.a(localException, "isGooglePlayServicesAvailable failed");
    }
    return 1;
  }

  public static Account[] c(Context paramContext)
  {
    if (!c.a(paramContext).a(n.j))
      return new Account[0];
    AccountManager localAccountManager = (AccountManager)paramContext.getSystemService("account");
    if (localAccountManager != null)
      return localAccountManager.getAccountsByType("com.google");
    return new Account[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ax
 * JD-Core Version:    0.6.2
 */