package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

final class zzagq
  implements Runnable
{
  zzagq(zzagp paramzzagp, PublisherAdView paramPublisherAdView, zzzi paramzzzi)
  {
  }

  public final void run()
  {
    if (this.zzczj.zza(this.zzczk))
    {
      zzagp.zza(this.zzczl).onPublisherAdViewLoaded(this.zzczj);
      return;
    }
    zzbae.zzep("Could not bind.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagq
 * JD-Core Version:    0.6.2
 */