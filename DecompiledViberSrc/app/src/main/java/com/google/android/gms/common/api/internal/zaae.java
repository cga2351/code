package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

public class zaae extends zal
{
  private GoogleApiManager zabm;
  private final ArraySet<zai<?>> zafo = new ArraySet();

  private zaae(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
  }

  public static void zaa(Activity paramActivity, GoogleApiManager paramGoogleApiManager, zai<?> paramzai)
  {
    LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
    zaae localzaae = (zaae)localLifecycleFragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
    if (localzaae == null)
      localzaae = new zaae(localLifecycleFragment);
    localzaae.zabm = paramGoogleApiManager;
    Preconditions.checkNotNull(paramzai, "ApiKey cannot be null");
    localzaae.zafo.add(paramzai);
    paramGoogleApiManager.zaa(localzaae);
  }

  private final void zaak()
  {
    if (!this.zafo.isEmpty())
      this.zabm.zaa(this);
  }

  public void onResume()
  {
    super.onResume();
    zaak();
  }

  public void onStart()
  {
    super.onStart();
    zaak();
  }

  public void onStop()
  {
    super.onStop();
    this.zabm.zab(this);
  }

  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zabm.zaa(paramConnectionResult, paramInt);
  }

  final ArraySet<zai<?>> zaaj()
  {
    return this.zafo;
  }

  protected final void zao()
  {
    this.zabm.zao();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaae
 * JD-Core Version:    0.6.2
 */