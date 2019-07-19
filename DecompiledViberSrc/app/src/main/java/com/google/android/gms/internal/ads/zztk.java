package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;

@TargetApi(23)
final class zztk
  implements MediaCodec.OnFrameRenderedListener
{
  private zztk(zzth paramzzth, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
  }

  public final void onFrameRendered(MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
  {
    if (this != this.zzbpc.zzboy)
      return;
    this.zzbpc.zzkj();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztk
 * JD-Core Version:    0.6.2
 */