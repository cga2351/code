package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zza extends Fragment
  implements LifecycleFragment
{
  private static WeakHashMap<Activity, WeakReference<zza>> zzbd = new WeakHashMap();
  private Map<String, LifecycleCallback> zzbe = new ArrayMap();
  private int zzbf = 0;
  private Bundle zzbg;

  public static zza zza(Activity paramActivity)
  {
    WeakReference localWeakReference = (WeakReference)zzbd.get(paramActivity);
    if (localWeakReference != null)
    {
      zza localzza2 = (zza)localWeakReference.get();
      if (localzza2 != null)
        return localzza2;
    }
    try
    {
      zza localzza1 = (zza)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if ((localzza1 == null) || (localzza1.isRemoving()))
      {
        localzza1 = new zza();
        paramActivity.getFragmentManager().beginTransaction().add(localzza1, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      zzbd.put(paramActivity, new WeakReference(localzza1));
      return localzza1;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", localClassCastException);
    }
  }

  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    if (!this.zzbe.containsKey(paramString))
    {
      this.zzbe.put(paramString, paramLifecycleCallback);
      if (this.zzbf > 0)
        new zze(Looper.getMainLooper()).post(new zzb(this, paramLifecycleCallback, paramString));
      return;
    }
    throw new IllegalArgumentException(59 + String.valueOf(paramString).length() + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass)
  {
    return (LifecycleCallback)paramClass.cast(this.zzbe.get(paramString));
  }

  public final Activity getLifecycleActivity()
  {
    return getActivity();
  }

  public final boolean isCreated()
  {
    return this.zzbf > 0;
  }

  public final boolean isStarted()
  {
    return this.zzbf >= 2;
  }

  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzbf = 1;
    this.zzbg = paramBundle;
    Iterator localIterator = this.zzbe.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)localEntry.getValue();
      if (paramBundle != null);
      for (Bundle localBundle = paramBundle.getBundle((String)localEntry.getKey()); ; localBundle = null)
      {
        localLifecycleCallback.onCreate(localBundle);
        break;
      }
    }
  }

  public final void onDestroy()
  {
    super.onDestroy();
    this.zzbf = 5;
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).onDestroy();
  }

  public final void onResume()
  {
    super.onResume();
    this.zzbf = 3;
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).onResume();
  }

  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null);
    while (true)
    {
      return;
      Iterator localIterator = this.zzbe.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((LifecycleCallback)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }

  public final void onStart()
  {
    super.onStart();
    this.zzbf = 2;
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).onStart();
  }

  public final void onStop()
  {
    super.onStop();
    this.zzbf = 4;
    Iterator localIterator = this.zzbe.values().iterator();
    while (localIterator.hasNext())
      ((LifecycleCallback)localIterator.next()).onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zza
 * JD-Core Version:    0.6.2
 */