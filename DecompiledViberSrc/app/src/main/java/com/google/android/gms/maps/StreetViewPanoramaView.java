package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout
{
  private final zzb zzcd;

  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.zzcd = new zzb(this, paramContext, null);
  }

  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzcd = new zzb(this, paramContext, null);
  }

  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzcd = new zzb(this, paramContext, null);
  }

  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.zzcd = new zzb(this, paramContext, paramStreetViewPanoramaOptions);
  }

  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzcd.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }

  public final void onCreate(Bundle paramBundle)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitAll().build());
    try
    {
      this.zzcd.onCreate(paramBundle);
      if (this.zzcd.getDelegate() == null)
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }

  public void onDestroy()
  {
    this.zzcd.onDestroy();
  }

  public final void onLowMemory()
  {
    this.zzcd.onLowMemory();
  }

  public final void onPause()
  {
    this.zzcd.onPause();
  }

  public void onResume()
  {
    this.zzcd.onResume();
  }

  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzcd.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    this.zzcd.onStart();
  }

  public void onStop()
  {
    this.zzcd.onStop();
  }

  @VisibleForTesting
  static final class zza
    implements StreetViewLifecycleDelegate
  {
    private final ViewGroup parent;
    private final IStreetViewPanoramaViewDelegate zzce;
    private View zzcf;

    public zza(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.zzce = ((IStreetViewPanoramaViewDelegate)Preconditions.checkNotNull(paramIStreetViewPanoramaViewDelegate));
      this.parent = ((ViewGroup)Preconditions.checkNotNull(paramViewGroup));
    }

    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.zzce.getStreetViewPanoramaAsync(new zzaj(this, paramOnStreetViewPanoramaReadyCallback));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onCreate(Bundle paramBundle)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle, localBundle);
        this.zzce.onCreate(localBundle);
        zzby.zza(localBundle, paramBundle);
        this.zzcf = ((View)ObjectWrapper.unwrap(this.zzce.getView()));
        this.parent.removeAllViews();
        this.parent.addView(this.zzcf);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    public final void onDestroy()
    {
      try
      {
        this.zzce.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    public final void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    public final void onLowMemory()
    {
      try
      {
        this.zzce.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onPause()
    {
      try
      {
        this.zzce.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onResume()
    {
      try
      {
        this.zzce.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle, localBundle);
        this.zzce.onSaveInstanceState(localBundle);
        zzby.zza(localBundle, paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onStart()
    {
      try
      {
        this.zzce.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onStop()
    {
      try
      {
        this.zzce.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  @VisibleForTesting
  static final class zzb extends DeferredLifecycleHelper<StreetViewPanoramaView.zza>
  {
    private OnDelegateCreatedListener<StreetViewPanoramaView.zza> zzbd;
    private final ViewGroup zzbj;
    private final Context zzbk;
    private final List<OnStreetViewPanoramaReadyCallback> zzbw = new ArrayList();
    private final StreetViewPanoramaOptions zzcg;

    @VisibleForTesting
    zzb(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.zzbj = paramViewGroup;
      this.zzbk = paramContext;
      this.zzcg = paramStreetViewPanoramaOptions;
    }

    protected final void createDelegate(OnDelegateCreatedListener<StreetViewPanoramaView.zza> paramOnDelegateCreatedListener)
    {
      this.zzbd = paramOnDelegateCreatedListener;
      if ((this.zzbd != null) && (getDelegate() == null));
      try
      {
        MapsInitializer.initialize(this.zzbk);
        IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = zzbz.zza(this.zzbk).zza(ObjectWrapper.wrap(this.zzbk), this.zzcg);
        this.zzbd.onDelegateCreated(new StreetViewPanoramaView.zza(this.zzbj, localIStreetViewPanoramaViewDelegate));
        Iterator localIterator = this.zzbw.iterator();
        while (localIterator.hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)localIterator.next();
          ((StreetViewPanoramaView.zza)getDelegate()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
        }
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        this.zzbw.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
      }
    }

    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (getDelegate() != null)
      {
        ((StreetViewPanoramaView.zza)getDelegate()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzbw.add(paramOnStreetViewPanoramaReadyCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaView
 * JD-Core Version:    0.6.2
 */