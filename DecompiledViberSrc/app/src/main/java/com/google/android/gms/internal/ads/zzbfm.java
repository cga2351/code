package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzbfm
{
  private long zzct;

  public final long zzl(ByteBuffer paramByteBuffer)
  {
    if (this.zzct > 0L)
      return this.zzct;
    try
    {
      ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
      localByteBuffer.flip();
      Iterator localIterator1 = new zzbb(new zzbfl(localByteBuffer), zzbfo.zzehq).zzbbd().iterator();
      zzbf localzzbf;
      zzbd localzzbd1;
      while (localIterator1.hasNext())
      {
        zzbd localzzbd2 = (zzbd)localIterator1.next();
        if ((localzzbd2 instanceof zzbf))
        {
          localzzbf = (zzbf)localzzbd2;
          Iterator localIterator2 = localzzbf.zzbbd().iterator();
          do
          {
            if (!localIterator2.hasNext())
              break;
            localzzbd1 = (zzbd)localIterator2.next();
          }
          while (!(localzzbd1 instanceof zzbg));
        }
      }
      for (zzbg localzzbg = (zzbg)localzzbd1; ; localzzbg = null)
      {
        this.zzct = (1000L * localzzbg.getDuration() / localzzbg.zzr());
        long l = this.zzct;
        return l;
        localzzbf = null;
        break;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      return 0L;
    }
    catch (IOException localIOException)
    {
      label182: break label182;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfm
 * JD-Core Version:    0.6.2
 */