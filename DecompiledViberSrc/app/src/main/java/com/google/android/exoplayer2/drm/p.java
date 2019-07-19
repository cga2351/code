package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
public final class p
  implements n
{
  private final MediaCrypto a;
  private final boolean b;

  public MediaCrypto a()
  {
    return this.a;
  }

  public boolean a(String paramString)
  {
    return (!this.b) && (this.a.requiresSecureDecoderComponent(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.p
 * JD-Core Version:    0.6.2
 */