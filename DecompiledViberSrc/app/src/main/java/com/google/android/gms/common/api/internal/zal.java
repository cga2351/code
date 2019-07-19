package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal extends LifecycleCallback
  implements DialogInterface.OnCancelListener
{
  protected volatile boolean mStarted;
  protected final GoogleApiAvailability zacc;
  protected final AtomicReference<zam> zade = new AtomicReference(null);
  private final Handler zadf = new com.google.android.gms.internal.base.zal(Looper.getMainLooper());

  protected zal(LifecycleFragment paramLifecycleFragment)
  {
    this(paramLifecycleFragment, GoogleApiAvailability.getInstance());
  }

  @VisibleForTesting
  private zal(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramLifecycleFragment);
    this.zacc = paramGoogleApiAvailability;
  }

  private static int zaa(zam paramzam)
  {
    if (paramzam == null)
      return -1;
    return paramzam.zar();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 13;
    Object localObject = (zam)this.zade.get();
    label43: label52: int k;
    switch (paramInt1)
    {
    default:
      j = 0;
      if (j != 0)
      {
        zaq();
        return;
      }
      break;
    case 2:
      k = this.zacc.isGooglePlayServicesAvailable(getActivity());
      if (k != 0);
      break;
    case 1:
    }
    for (int j = 1; ; j = 0)
    {
      if (localObject == null)
        break label52;
      if ((((zam)localObject).getConnectionResult().getErrorCode() != 18) || (k != 18))
        break label43;
      return;
      if (paramInt2 == -1)
      {
        j = 1;
        break label43;
      }
      if (paramInt2 != 0)
        break;
      if (paramIntent != null)
        i = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", i);
      zam localzam = new zam(new ConnectionResult(i, null), zaa((zam)localObject));
      this.zade.set(localzam);
      localObject = localzam;
      j = 0;
      break label43;
      if (localObject == null)
        break label52;
      zaa(((zam)localObject).getConnectionResult(), ((zam)localObject).zar());
      return;
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    zaa(new ConnectionResult(13, null), zaa((zam)this.zade.get()));
    zaq();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AtomicReference localAtomicReference;
    if (paramBundle != null)
    {
      localAtomicReference = this.zade;
      if (!paramBundle.getBoolean("resolving_error", false))
        break label67;
    }
    label67: for (zam localzam = new zam(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1)); ; localzam = null)
    {
      localAtomicReference.set(localzam);
      return;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    zam localzam = (zam)this.zade.get();
    if (localzam != null)
    {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", localzam.zar());
      paramBundle.putInt("failed_status", localzam.getConnectionResult().getErrorCode());
      paramBundle.putParcelable("failed_resolution", localzam.getConnectionResult().getResolution());
    }
  }

  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
  }

  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
  }

  protected abstract void zaa(ConnectionResult paramConnectionResult, int paramInt);

  public final void zab(ConnectionResult paramConnectionResult, int paramInt)
  {
    zam localzam = new zam(paramConnectionResult, paramInt);
    if (this.zade.compareAndSet(null, localzam))
      this.zadf.post(new zan(this, localzam));
  }

  protected abstract void zao();

  protected final void zaq()
  {
    this.zade.set(null);
    zao();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zal
 * JD-Core Version:    0.6.2
 */