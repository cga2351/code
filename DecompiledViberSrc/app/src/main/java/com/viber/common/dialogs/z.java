package com.viber.common.dialogs;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import java.util.Iterator;
import java.util.List;

public final class z
{
  private static FragmentManager a(Fragment paramFragment)
  {
    try
    {
      FragmentManager localFragmentManager = paramFragment.getChildFragmentManager();
      return localFragmentManager;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return null;
  }

  public static void a(Context paramContext, DialogCodeProvider paramDialogCodeProvider)
  {
    Intent localIntent = new Intent("com.viber.action.HIDE_DIALOG");
    localIntent.putExtra("com.viber.extra.DIALOG_CODE", paramDialogCodeProvider);
    paramContext.sendBroadcast(localIntent);
  }

  public static void a(Fragment paramFragment, DialogCodeProvider paramDialogCodeProvider)
  {
    FragmentManager localFragmentManager = a(paramFragment);
    if (localFragmentManager == null);
    while (a(localFragmentManager, paramDialogCodeProvider))
      return;
    a(paramFragment.getFragmentManager(), paramDialogCodeProvider);
  }

  public static boolean a(FragmentActivity paramFragmentActivity)
  {
    List localList = paramFragmentActivity.getSupportFragmentManager().getFragments();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        if (((Fragment)localIterator.next() instanceof DialogFragment))
          return true;
    }
    return false;
  }

  public static boolean a(FragmentManager paramFragmentManager, DialogCodeProvider paramDialogCodeProvider)
  {
    m localm = c(paramFragmentManager, paramDialogCodeProvider);
    if (localm != null)
    {
      localm.dismiss();
      return true;
    }
    return false;
  }

  public static boolean a(DialogCodeProvider paramDialogCodeProvider1, DialogCodeProvider paramDialogCodeProvider2)
  {
    return (paramDialogCodeProvider1 != null) && (paramDialogCodeProvider2 != null) && (paramDialogCodeProvider1.code().equals(paramDialogCodeProvider2.code()));
  }

  public static void b(Fragment paramFragment, DialogCodeProvider paramDialogCodeProvider)
  {
    FragmentManager localFragmentManager = a(paramFragment);
    if (localFragmentManager == null);
    while (b(localFragmentManager, paramDialogCodeProvider))
      return;
    b(paramFragment.getFragmentManager(), paramDialogCodeProvider);
  }

  public static boolean b(FragmentManager paramFragmentManager, DialogCodeProvider paramDialogCodeProvider)
  {
    m localm = c(paramFragmentManager, paramDialogCodeProvider);
    if (localm != null)
    {
      localm.dismissAllowingStateLoss();
      return true;
    }
    return false;
  }

  public static m c(FragmentManager paramFragmentManager, DialogCodeProvider paramDialogCodeProvider)
  {
    if (paramFragmentManager == null)
      return null;
    Fragment localFragment = paramFragmentManager.findFragmentByTag(paramDialogCodeProvider.managerTag());
    if ((localFragment instanceof m))
      return (m)localFragment;
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.z
 * JD-Core Version:    0.6.2
 */