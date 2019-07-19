package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzawi
  implements Runnable
{
  zzawi(zzawh paramzzawh, Context paramContext, zzbbs paramzzbbs)
  {
  }

  public final void run()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.val$context);
      this.zzdsx.set(localInfo);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      this.zzdsx.setException(localGooglePlayServicesRepairableException);
      zzbae.zzc("Exception while getting advertising Id info", localGooglePlayServicesRepairableException);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label18;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      break label18;
    }
    catch (IOException localIOException)
    {
      label18: break label18;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawi
 * JD-Core Version:    0.6.2
 */