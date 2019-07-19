package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbk;
import com.google.android.gms.internal.location.zzq;

public class LocationServices
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("LocationServices.API", CLIENT_BUILDER, CLIENT_KEY);
  private static final Api.AbstractClientBuilder<zzaz, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzaz> CLIENT_KEY = new Api.ClientKey();

  @Deprecated
  public static final FusedLocationProviderApi FusedLocationApi = new zzq();

  @Deprecated
  public static final GeofencingApi GeofencingApi = new zzaf();

  @Deprecated
  public static final SettingsApi SettingsApi = new zzbk();

  static
  {
    CLIENT_BUILDER = new zzad();
  }

  public static FusedLocationProviderClient getFusedLocationProviderClient(Activity paramActivity)
  {
    return new FusedLocationProviderClient(paramActivity);
  }

  public static FusedLocationProviderClient getFusedLocationProviderClient(Context paramContext)
  {
    return new FusedLocationProviderClient(paramContext);
  }

  public static GeofencingClient getGeofencingClient(Activity paramActivity)
  {
    return new GeofencingClient(paramActivity);
  }

  public static GeofencingClient getGeofencingClient(Context paramContext)
  {
    return new GeofencingClient(paramContext);
  }

  public static SettingsClient getSettingsClient(Activity paramActivity)
  {
    return new SettingsClient(paramActivity);
  }

  public static SettingsClient getSettingsClient(Context paramContext)
  {
    return new SettingsClient(paramContext);
  }

  public static zzaz zza(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool1 = true;
    boolean bool2;
    zzaz localzzaz;
    if (paramGoogleApiClient != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "GoogleApiClient parameter is required.");
      localzzaz = (zzaz)paramGoogleApiClient.getClient(CLIENT_KEY);
      if (localzzaz == null)
        break label42;
    }
    while (true)
    {
      Preconditions.checkState(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return localzzaz;
      bool2 = false;
      break;
      label42: bool1 = false;
    }
  }

  public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzaz>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationServices
 * JD-Core Version:    0.6.2
 */