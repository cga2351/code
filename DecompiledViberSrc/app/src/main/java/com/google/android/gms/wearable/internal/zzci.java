package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import java.io.IOException;
import java.io.InputStream;

public final class zzci
  implements DataApi.GetFdForAssetResult
{
  private volatile boolean closed = false;
  private volatile InputStream zzct;
  private volatile ParcelFileDescriptor zzf;
  private final Status zzp;

  public zzci(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.zzp = paramStatus;
    this.zzf = paramParcelFileDescriptor;
  }

  public final ParcelFileDescriptor getFd()
  {
    if (this.closed)
      throw new IllegalStateException("Cannot access the file descriptor after release().");
    return this.zzf;
  }

  public final InputStream getInputStream()
  {
    if (this.closed)
      throw new IllegalStateException("Cannot access the input stream after release().");
    if (this.zzf == null)
      return null;
    if (this.zzct == null)
      this.zzct = new ParcelFileDescriptor.AutoCloseInputStream(this.zzf);
    return this.zzct;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }

  public final void release()
  {
    if (this.zzf == null)
      return;
    if (this.closed)
      throw new IllegalStateException("releasing an already released result.");
    try
    {
      if (this.zzct != null)
        this.zzct.close();
      while (true)
      {
        this.closed = true;
        this.zzf = null;
        this.zzct = null;
        return;
        this.zzf.close();
      }
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzci
 * JD-Core Version:    0.6.2
 */