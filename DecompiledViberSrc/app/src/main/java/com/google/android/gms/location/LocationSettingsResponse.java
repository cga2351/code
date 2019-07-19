package com.google.android.gms.location;

import com.google.android.gms.common.api.Response;

public class LocationSettingsResponse extends Response<LocationSettingsResult>
{
  public LocationSettingsStates getLocationSettingsStates()
  {
    return ((LocationSettingsResult)getResult()).getLocationSettingsStates();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationSettingsResponse
 * JD-Core Version:    0.6.2
 */