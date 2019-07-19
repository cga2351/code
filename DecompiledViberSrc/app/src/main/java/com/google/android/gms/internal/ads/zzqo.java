package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzqo
  implements zzql
{
  private final zzlu zzars;
  private final zzql[] zzbji;
  private final ArrayList<zzql> zzbjj;
  private zzqm zzbjk;
  private zzlr zzbjl;
  private Object zzbjm;
  private int zzbjn;
  private zzqq zzbjo;

  public zzqo(zzql[] paramArrayOfzzql)
  {
    this.zzbji = paramArrayOfzzql;
    this.zzbjj = new ArrayList(Arrays.asList(paramArrayOfzzql));
    this.zzars = new zzlu();
    this.zzbjn = -1;
  }

  private final void zza(int paramInt, zzlr paramzzlr, Object paramObject)
  {
    int j;
    zzqq localzzqq;
    if (this.zzbjo == null)
    {
      int i = paramzzlr.zzhf();
      j = 0;
      if (j >= i)
        break label70;
      if (paramzzlr.zza(j, this.zzars, false).zzaut)
      {
        localzzqq = new zzqq(0);
        label50: this.zzbjo = localzzqq;
      }
    }
    else
    {
      if (this.zzbjo == null)
        break label116;
    }
    label70: label116: 
    do
    {
      return;
      j++;
      break;
      if (this.zzbjn == -1)
        this.zzbjn = paramzzlr.zzhg();
      while (paramzzlr.zzhg() == this.zzbjn)
      {
        localzzqq = null;
        break;
      }
      localzzqq = new zzqq(1);
      break label50;
      this.zzbjj.remove(this.zzbji[paramInt]);
      if (paramInt == 0)
      {
        this.zzbjl = paramzzlr;
        this.zzbjm = paramObject;
      }
    }
    while (!this.zzbjj.isEmpty());
    this.zzbjk.zzb(this.zzbjl, this.zzbjm);
  }

  public final zzqj zza(int paramInt, zzrt paramzzrt)
  {
    zzqj[] arrayOfzzqj = new zzqj[this.zzbji.length];
    for (int i = 0; i < arrayOfzzqj.length; i++)
      arrayOfzzqj[i] = this.zzbji[i].zza(paramInt, paramzzrt);
    return new zzqn(arrayOfzzqj);
  }

  public final void zza(zzkv paramzzkv, boolean paramBoolean, zzqm paramzzqm)
  {
    this.zzbjk = paramzzqm;
    for (int i = 0; i < this.zzbji.length; i++)
      this.zzbji[i].zza(paramzzkv, false, new zzqp(this, i));
  }

  public final void zzb(zzqj paramzzqj)
  {
    zzqn localzzqn = (zzqn)paramzzqj;
    for (int i = 0; i < this.zzbji.length; i++)
      this.zzbji[i].zzb(localzzqn.zzbjd[i]);
  }

  public final void zzjf()
    throws IOException
  {
    if (this.zzbjo != null)
      throw this.zzbjo;
    zzql[] arrayOfzzql = this.zzbji;
    int i = arrayOfzzql.length;
    for (int j = 0; j < i; j++)
      arrayOfzzql[j].zzjf();
  }

  public final void zzjg()
  {
    zzql[] arrayOfzzql = this.zzbji;
    int i = arrayOfzzql.length;
    for (int j = 0; j < i; j++)
      arrayOfzzql[j].zzjg();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqo
 * JD-Core Version:    0.6.2
 */