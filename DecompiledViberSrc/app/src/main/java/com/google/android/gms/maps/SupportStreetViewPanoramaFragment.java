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
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment
{
  private final zzb zzci = new zzb(this);

  public static SupportStreetViewPanoramaFragment newInstance()
  {
    return new SupportStreetViewPanoramaFragment();
  }

  public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    SupportStreetViewPanoramaFragment localSupportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("StreetViewPanoramaOptions", paramStreetViewPanoramaOptions);
    localSupportStreetViewPanoramaFragment.setArguments(localBundle);
    return localSupportStreetViewPanoramaFragment;
  }

  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzci.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzci, paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzci.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.zzci.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  public void onDestroy()
  {
    this.zzci.onDestroy();
    super.onDestroy();
  }

  public void onDestroyView()
  {
    this.zzci.onDestroyView();
    super.onDestroyView();
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(localThreadPolicy).permitAll().build());
    try
    {
      super.onInflate(paramActivity, paramAttributeSet, paramBundle);
      zzb.zza(this.zzci, paramActivity);
      Bundle localBundle = new Bundle();
      this.zzci.onInflate(paramActivity, localBundle, paramBundle);
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }

  public void onLowMemory()
  {
    this.zzci.onLowMemory();
    super.onLowMemory();
  }

  public void onPause()
  {
    this.zzci.onPause();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    this.zzci.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
    super.onSaveInstanceState(paramBundle);
    this.zzci.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.zzci.onStart();
  }

  public void onStop()
  {
    this.zzci.onStop();
    super.onStop();
  }

  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }

  @VisibleForTesting
  static final class zza
    implements StreetViewLifecycleDelegate
  {
    private final Fragment fragment;
    private final IStreetViewPanoramaFragmentDelegate zzbu;

    public zza(Fragment paramFragment, IStreetViewPanoramaFragmentDelegate paramIStreetViewPanoramaFragmentDelegate)
    {
      this.zzbu = ((IStreetViewPanoramaFragmentDelegate)Preconditions.checkNotNull(paramIStreetViewPanoramaFragmentDelegate));
      this.fragment = ((Fragment)Preconditions.checkNotNull(paramFragment));
    }

    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.zzbu.getStreetViewPanoramaAsync(new zzal(this, paramOnStreetViewPanoramaReadyCallback));
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
        if ((localBundle2 != null) && (localBundle2.containsKey("StreetViewPanoramaOptions")))
          zzby.zza(localBundle1, "StreetViewPanoramaOptions", localBundle2.getParcelable("StreetViewPanoramaOptions"));
        this.zzbu.onCreate(localBundle1);
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
        IObjectWrapper localIObjectWrapper = this.zzbu.onCreateView(ObjectWrapper.wrap(paramLayoutInflater), ObjectWrapper.wrap(paramViewGroup), localBundle);
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
        this.zzbu.onDestroy();
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
        this.zzbu.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }

    public final void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      try
      {
        Bundle localBundle = new Bundle();
        zzby.zza(paramBundle2, localBundle);
        this.zzbu.onInflate(ObjectWrapper.wrap(paramActivity), null, localBundle);
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
        this.zzbu.onLowMemory();
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
        this.zzbu.onPause();
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
        this.zzbu.onResume();
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
        this.zzbu.onSaveInstanceState(localBundle);
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
        this.zzbu.onStart();
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
        this.zzbu.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }

  @VisibleForTesting
  static final class zzb extends DeferredLifecycleHelper<SupportStreetViewPanoramaFragment.zza>
  {
    private final Fragment fragment;
    private OnDelegateCreatedListener<SupportStreetViewPanoramaFragment.zza> zzbd;
    private Activity zzbe;
    private final List<OnStreetViewPanoramaReadyCallback> zzbw = new ArrayList();

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
      if ((this.zzbe != null) && (this.zzbd != null) && (getDelegate() == null));
      try
      {
        MapsInitializer.initialize(this.zzbe);
        IStreetViewPanoramaFragmentDelegate localIStreetViewPanoramaFragmentDelegate = zzbz.zza(this.zzbe).zzd(ObjectWrapper.wrap(this.zzbe));
        this.zzbd.onDelegateCreated(new SupportStreetViewPanoramaFragment.zza(this.fragment, localIStreetViewPanoramaFragmentDelegate));
        Iterator localIterator = this.zzbw.iterator();
        while (localIterator.hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)localIterator.next();
          ((SupportStreetViewPanoramaFragment.zza)getDelegate()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
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

    protected final void createDelegate(OnDelegateCreatedListener<SupportStreetViewPanoramaFragment.zza> paramOnDelegateCreatedListener)
    {
      this.zzbd = paramOnDelegateCreatedListener;
      zzd();
    }

    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (getDelegate() != null)
      {
        ((SupportStreetViewPanoramaFragment.zza)getDelegate()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzbw.add(paramOnStreetViewPanoramaReadyCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.SupportStreetViewPanoramaFragment
 * JD-Core Version:    0.6.2
 */