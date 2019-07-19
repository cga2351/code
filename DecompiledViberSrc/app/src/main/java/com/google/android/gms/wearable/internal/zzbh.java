package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

final class zzbh
  implements Channel.GetOutputStreamResult
{
  private final OutputStream zzcu;
  private final Status zzp;

  zzbh(Status paramStatus, @Nullable OutputStream paramOutputStream)
  {
    this.zzp = ((Status)Preconditions.checkNotNull(paramStatus));
    this.zzcu = paramOutputStream;
  }

  @Nullable
  public final OutputStream getOutputStream()
  {
    return this.zzcu;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }

  public final void release()
  {
    if (this.zzcu != null);
    try
    {
      this.zzcu.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbh
 * JD-Core Version:    0.6.2
 */