package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

public final class zzbl extends OutputStream
{

  @Nullable
  private volatile zzav zzcw;
  private final OutputStream zzcy;

  public zzbl(OutputStream paramOutputStream)
  {
    this.zzcy = ((OutputStream)Preconditions.checkNotNull(paramOutputStream));
  }

  private final IOException zza(IOException paramIOException)
  {
    zzav localzzav = this.zzcw;
    if (localzzav != null)
    {
      if (Log.isLoggable("ChannelOutputStream", 2))
        Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", paramIOException);
      paramIOException = new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzav.zzg, localzzav.zzcj);
    }
    return paramIOException;
  }

  public final void close()
    throws IOException
  {
    try
    {
      this.zzcy.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }

  public final void flush()
    throws IOException
  {
    try
    {
      this.zzcy.flush();
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }

  public final void write(int paramInt)
    throws IOException
  {
    try
    {
      this.zzcy.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }

  public final void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.zzcy.write(paramArrayOfByte);
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }

  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.zzcy.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      throw zza(localIOException);
    }
  }

  final void zzc(zzav paramzzav)
  {
    this.zzcw = paramzzav;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * JD-Core Version:    0.6.2
 */