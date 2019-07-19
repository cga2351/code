package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback
{

  @KeepForSdk
  protected final LifecycleFragment mLifecycleFragment;

  @KeepForSdk
  protected LifecycleCallback(LifecycleFragment paramLifecycleFragment)
  {
    this.mLifecycleFragment = paramLifecycleFragment;
  }

  @Keep
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity)
  {
    throw new IllegalStateException("Method not available in SDK.");
  }

  @KeepForSdk
  public static LifecycleFragment getFragment(Activity paramActivity)
  {
    return getFragment(new LifecycleActivity(paramActivity));
  }

  @KeepForSdk
  public static LifecycleFragment getFragment(ContextWrapper paramContextWrapper)
  {
    throw new UnsupportedOperationException();
  }

  @KeepForSdk
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity)
  {
    if (paramLifecycleActivity.isSupport())
      return zzc.zza(paramLifecycleActivity.asFragmentActivity());
    if (paramLifecycleActivity.zzh())
      return zza.zza(paramLifecycleActivity.asActivity());
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }

  @KeepForSdk
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  @KeepForSdk
  public Activity getActivity()
  {
    return this.mLifecycleFragment.getLifecycleActivity();
  }

  @KeepForSdk
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  @KeepForSdk
  public void onCreate(Bundle paramBundle)
  {
  }

  @KeepForSdk
  public void onDestroy()
  {
  }

  @KeepForSdk
  public void onResume()
  {
  }

  @KeepForSdk
  public void onSaveInstanceState(Bundle paramBundle)
  {
  }

  @KeepForSdk
  public void onStart()
  {
  }

  @KeepForSdk
  public void onStop()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleCallback
 * JD-Core Version:    0.6.2
 */