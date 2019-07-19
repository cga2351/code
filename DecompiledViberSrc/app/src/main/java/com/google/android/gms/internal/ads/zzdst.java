package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzdst
  implements zzbe, Closeable, Iterator<zzbd>
{
  private static zzdtb zzcp = zzdtb.zzm(zzdst.class);
  private static final zzbd zzhtq = new zzdsu("eof ");
  long zzbdz = 0L;
  long zzbkn = 0L;
  protected zzdsv zzhtn;
  protected zzba zzhtr;
  private zzbd zzhts = null;
  long zzhtt = 0L;
  private List<zzbd> zzhtu = new ArrayList();

  private final zzbd zzbbe()
  {
    if ((this.zzhts != null) && (this.zzhts != zzhtq))
    {
      zzbd localzzbd2 = this.zzhts;
      this.zzhts = null;
      return localzzbd2;
    }
    if ((this.zzhtn == null) || (this.zzhtt >= this.zzbdz))
    {
      this.zzhts = zzhtq;
      throw new NoSuchElementException();
    }
    try
    {
      synchronized (this.zzhtn)
      {
        this.zzhtn.zzff(this.zzhtt);
        zzbd localzzbd1 = this.zzhtr.zza(this.zzhtn, this);
        this.zzhtt = this.zzhtn.position();
        return localzzbd1;
      }
    }
    catch (EOFException localEOFException)
    {
      throw new NoSuchElementException();
    }
    catch (IOException localIOException)
    {
    }
    throw new NoSuchElementException();
  }

  public void close()
    throws IOException
  {
    this.zzhtn.close();
  }

  public boolean hasNext()
  {
    if (this.zzhts == zzhtq)
      return false;
    if (this.zzhts != null)
      return true;
    try
    {
      this.zzhts = ((zzbd)next());
      return true;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      this.zzhts = zzhtq;
    }
    return false;
  }

  public void remove()
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append("[");
    for (int i = 0; i < this.zzhtu.size(); i++)
    {
      if (i > 0)
        localStringBuilder.append(";");
      localStringBuilder.append(((zzbd)this.zzhtu.get(i)).toString());
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void zza(zzdsv paramzzdsv, long paramLong, zzba paramzzba)
    throws IOException
  {
    this.zzhtn = paramzzdsv;
    long l = paramzzdsv.position();
    this.zzbkn = l;
    this.zzhtt = l;
    paramzzdsv.zzff(paramLong + paramzzdsv.position());
    this.zzbdz = paramzzdsv.position();
    this.zzhtr = paramzzba;
  }

  public final List<zzbd> zzbbd()
  {
    if ((this.zzhtn != null) && (this.zzhts != zzhtq))
      return new zzdsz(this.zzhtu, this);
    return this.zzhtu;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdst
 * JD-Core Version:    0.6.2
 */