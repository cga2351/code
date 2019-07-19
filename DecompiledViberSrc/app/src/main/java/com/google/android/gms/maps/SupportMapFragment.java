package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SupportMapFragment extends Fragment
{
  private final zzb zzch = new zzb(this);

  public static SupportMapFragment newInstance()
  {
    return new SupportMapFragment();
  }

  public static SupportMapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localSupportMapFragment.setArguments(localBundle);
    return localSupportMapFragment;
  }

  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    Preconditions.checkMainThread("getMapAsync must be called on the main thread.");
    this.zzch.getMapAsync(paramOnMapReadyCallback);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzch, paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzch.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = this.zzch.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    localView.setClickable(true);
    return localView;
  }

  public void onDestroy()
  {
    this.zzch.onDestroy();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.zzch.onDestroyView();
    super.onDestroyView();
  }

  public final void onEnterAmbient(Bundle paramBundle)
  {
    Preconditions.checkMainThread("onEnterAmbient must be called on the main thread.");
    zzb localzzb = this.zzch;
    if (localzzb.getDelegate() != null)
      ((zza)localzzb.getDelegate()).onEnterAmbient(paramBundle);
  }

  public final void onExitAmbient()
  {
    Preconditions.checkMainThread("onExitAmbient must be called on the main thread.");
    zzb localzzb = this.zzch;
    if (localzzb.getDelegate() != null)
      ((zza)localzzb.getDelegate()).onExitAmbient();
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitAll().build());
    try
    {
      super.onInflate(paramActivity, paramAttributeSet, paramBundle);
      zzb.zza(this.zzch, paramActivity);
      GoogleMapOptions localGoogleMapOptions = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("MapOptions", localGoogleMapOptions);
      this.zzch.onInflate(paramActivity, localBundle, paramBundle);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }

  public void onLowMemory()
  {
    this.zzch.onLowMemory();
    super.onLowMemory();
  }

  public void onPause()
  {
    this.zzch.onPause();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.zzch.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader());
    super.onSaveInstanceState(paramBundle);
    this.zzch.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.zzch.onStart();
  }

  public void onStop()
  {
    this.zzch.onStop();
    super.onStop();
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }

  @VisibleForTesting
  static final class zza
    implements MapLifecycleDelegate
  {
    private final Fragment fragment;
    private final IMapFragmentDelegate zzbb;

    public zza(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.zzbb = ((IMapFragmentDelegate)Preconditions.checkNotNull(paramIMapFragmentDelegate));
      this.fragment = ((Fragment)Preconditions.checkNotNull(paramFragment));
    }

    public final void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzbb.getMapAsync(new zzak(this, paramOnMapReadyCallback));
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
        Bundle localBundle1 = new Bundle();
        zzby.zza(paramBundle, localBundle1);
        Bundle localBundle2 = this.fragment.getArguments();
        if ((localBundle2 != null) && (localBundle2.containsKey("MapOptions")))
          zzby.zza(localBundle1, "MapOptions", localBundle2.getParcelable("MapOptions"));
        this.zzbb.onCreate(localBundle1);
        zzby.zza(localBundle1, paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle, localBundle);
        IObjectWrapper localIObjectWrapper = this.zzbb.onCreateView(ObjectWrapper.wrap(paramLayoutInflater), ObjectWrapper.wrap(paramViewGroup), localBundle);
        zzby.zza(localBundle, paramBundle);
        return (View)ObjectWrapper.unwrap(localIObjectWrapper);
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onDestroy()
    {
      try
      {
        this.zzbb.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onDestroyView()
    {
      try
      {
        this.zzbb.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle, localBundle);
        this.zzbb.onEnterAmbient(localBundle);
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
        this.zzbb.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      GoogleMapOptions localGoogleMapOptions = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle2, localBundle);
        this.zzbb.onInflate(ObjectWrapper.wrap(paramActivity), localGoogleMapOptions, localBundle);
        zzby.zza(localBundle, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onLowMemory()
    {
      try
      {
        this.zzbb.onLowMemory();
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
        this.zzbb.onPause();
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
        this.zzbb.onResume();
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
        this.zzbb.onSaveInstanceState(localBundle);
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
        this.zzbb.onStart();
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
        this.zzbb.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  @VisibleForTesting
  static final class zzb extends DeferredLifecycleHelper<SupportMapFragment.zza>
  {
    private final Fragment fragment;
    private OnDelegateCreatedListener<SupportMapFragment.zza> zzbd;
    private Activity zzbe;
    private final List<OnMapReadyCallback> zzbf = new ArrayList();

    @VisibleForTesting
    zzb(Fragment paramFragment)
    {
      this.fragment = paramFragment;
    }

    private final void setActivity(Activity paramActivity)
    {
      this.zzbe = paramActivity;
      zzd();
    }

    private final void zzd()
    {
      if ((this.zzbe != null) && (this.zzbd != null) && (getDelegate() == null))
        try
        {
          MapsInitializer.initialize(this.zzbe);
          IMapFragmentDelegate localIMapFragmentDelegate = zzbz.zza(this.zzbe).zzc(ObjectWrapper.wrap(this.zzbe));
          if (localIMapFragmentDelegate == null)
            return;
          this.zzbd.onDelegateCreated(new SupportMapFragment.zza(this.fragment, localIMapFragmentDelegate));
          Iterator localIterator = this.zzbf.iterator();
          while (localIterator.hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)localIterator.next();
            ((SupportMapFragment.zza)getDelegate()).getMapAsync(localOnMapReadyCallback);
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

    protected final void createDelegate(OnDelegateCreatedListener<SupportMapFragment.zza> paramOnDelegateCreatedListener)
    {
      this.zzbd = paramOnDelegateCreatedListener;
      zzd();
    }

    public final void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (getDelegate() != null)
      {
        ((SupportMapFragment.zza)getDelegate()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzbf.add(paramOnMapReadyCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.SupportMapFragment
 * JD-Core Version:    0.6.2
 */