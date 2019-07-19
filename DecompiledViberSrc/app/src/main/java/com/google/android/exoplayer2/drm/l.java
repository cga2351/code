package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;

@TargetApi(16)
public abstract interface l<T extends n>
{
  public abstract k<T> a(Looper paramLooper, DrmInitData paramDrmInitData);

  public abstract void a(k<T> paramk);

  public abstract boolean a(DrmInitData paramDrmInitData);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.l
 * JD-Core Version:    0.6.2
 */