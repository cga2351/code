package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzawz extends zzaww
{
  private Context zzlj;

  zzawz(Context paramContext)
  {
    this.zzlj = paramContext;
  }

  public final void zzto()
  {
    try
    {
      boolean bool2 = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zzlj);
      bool1 = bool2;
      zzazy.zzal(bool1);
      zzaxa.zzep(43 + "Update ad debug logging enablement as " + bool1);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      while (true)
      {
        zzaxa.zzc("Fail to get isAdIdFakeForDebugLogging", localGooglePlayServicesRepairableException);
        boolean bool1 = false;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label40;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      break label40;
    }
    catch (IOException localIOException)
    {
      label40: break label40;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawz
 * JD-Core Version:    0.6.2
 */