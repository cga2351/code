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
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView extends FrameLayout
{
  private final zzb zzbg;

  public MapView(Context paramContext)
  {
    super(paramContext);
    this.zzbg = new zzb(this, paramContext, null);
    setClickable(true);
  }

  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzbg = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    setClickable(true);
  }

  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzbg = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    setClickable(true);
  }

  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.zzbg = new zzb(this, paramContext, paramGoogleMapOptions);
    setClickable(true);
  }

  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    Preconditions.checkMainThread("getMapAsync() must be called on the main thread");
    this.zzbg.getMapAsync(paramOnMapReadyCallback);
  }

  public final void onCreate(Bundle paramBundle)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitAll().build());
    try
    {
      this.zzbg.onCreate(paramBundle);
      if (this.zzbg.getDelegate() == null)
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }

  public final void onDestroy()
  {
    this.zzbg.onDestroy();
  }

  public final void onEnterAmbient(Bundle paramBundle)
  {
    Preconditions.checkMainThread("onEnterAmbient() must be called on the main thread");
    zzb localzzb = this.zzbg;
    if (localzzb.getDelegate() != null)
      ((zza)localzzb.getDelegate()).onEnterAmbient(paramBundle);
  }

  public final void onExitAmbient()
  {
    Preconditions.checkMainThread("onExitAmbient() must be called on the main thread");
    zzb localzzb = this.zzbg;
    if (localzzb.getDelegate() != null)
      ((zza)localzzb.getDelegate()).onExitAmbient();
  }

  public final void onLowMemory()
  {
    this.zzbg.onLowMemory();
  }

  public final void onPause()
  {
    this.zzbg.onPause();
  }

  public final void onResume()
  {
    this.zzbg.onResume();
  }

  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzbg.onSaveInstanceState(paramBundle);
  }

  public final void onStart()
  {
    this.zzbg.onStart();
  }

  public final void onStop()
  {
    this.zzbg.onStop();
  }

  @VisibleForTesting
  static final class zza
    implements MapLifecycleDelegate
  {
    private final ViewGroup parent;
    private final IMapViewDelegate zzbh;
    private View zzbi;

    public zza(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.zzbh = ((IMapViewDelegate)Preconditions.checkNotNull(paramIMapViewDelegate));
      this.parent = ((ViewGroup)Preconditions.checkNotNull(paramViewGroup));
    }

    public final void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzbh.getMapAsync(new zzac(this, paramOnMapReadyCallback));
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
        this.zzbh.onCreate(localBundle);
        zzby.zza(localBundle, paramBundle);
        this.zzbi = ((View)ObjectWrapper.unwrap(this.zzbh.getView()));
        this.parent.removeAllViews();
        this.parent.addView(this.zzbi);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }

    public final void onDestroy()
    {
      try
      {
        this.zzbh.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    public final void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle, localBundle);
        this.zzbh.onEnterAmbient(localBundle);
        zzby.zza(localBundle, paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onExitAmbient()
    {
      try
      {
        this.zzbh.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    public final void onLowMemory()
    {
      try
      {
        this.zzbh.onLowMemory();
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
        this.zzbh.onPause();
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
        this.zzbh.onResume();
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
        this.zzbh.onSaveInstanceState(localBundle);
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
        this.zzbh.onStart();
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
        this.zzbh.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  @VisibleForTesting
  static final class zzb extends DeferredLifecycleHelper<MapView.zza>
  {
    private OnDelegateCreatedListener<MapView.zza> zzbd;
    private final List<OnMapReadyCallback> zzbf = new ArrayList();
    private final ViewGroup zzbj;
    private final Context zzbk;
    private final GoogleMapOptions zzbl;

    @VisibleForTesting
    zzb(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.zzbj = paramViewGroup;
      this.zzbk = paramContext;
      this.zzbl = paramGoogleMapOptions;
    }

    protected final void createDelegate(OnDelegateCreatedListener<MapView.zza> paramOnDelegateCreatedListener)
    {
      this.zzbd = paramOnDelegateCreatedListener;
      if ((this.zzbd != null) && (getDelegate() == null))
        try
        {
          MapsInitializer.initialize(this.zzbk);
          IMapViewDelegate localIMapViewDelegate = zzbz.zza(this.zzbk).zza(ObjectWrapper.wrap(this.zzbk), this.zzbl);
          if (localIMapViewDelegate == null)
            return;
          this.zzbd.onDelegateCreated(new MapView.zza(this.zzbj, localIMapViewDelegate));
          Iterator localIterator = this.zzbf.iterator();
          while (localIterator.hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)localIterator.next();
            ((MapView.zza)getDelegate()).getMapAsync(localOnMapReadyCallback);
          }
        }
        catch (RemoteException localRemoteException)
        {
          throw new RuntimeRemoteException(localRemoteException);
          this.zzbf.clear();
          return;
        }
        catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
        {
        }
    }

    public final void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (getDelegate() != null)
      {
        ((MapView.zza)getDelegate()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzbf.add(paramOnMapReadyCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapView
 * JD-Core Version:    0.6.2
 */