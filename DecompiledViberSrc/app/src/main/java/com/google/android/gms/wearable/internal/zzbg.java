package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

final class zzbg
  implements Channel.GetInputStreamResult
{
  private final InputStream zzct;
  private final Status zzp;

  zzbg(Status paramStatus, @Nullable InputStream paramInputStream)
  {
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzct = paramInputStream;
  }

  @Nullable
  public final InputStream getInputStream()
  {
    return this.zzct;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }

  public final void release()
  {
    if (this.zzct != null);
    try
    {
      this.zzct.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbg
 * JD-Core Version:    0.6.2
 */