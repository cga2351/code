package com.google.android.gms.internal.ads;

import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;

public final class zzbzb
{
  public static final zzbzb zzfpd = new zzbzd().zzaip();
  private final zzafk zzfow;
  private final zzafh zzfox;
  private final zzafw zzfoy;
  private final zzaft zzfoz;
  private final zzajf zzfpa;
  private final SimpleArrayMap<String, zzafq> zzfpb;
  private final SimpleArrayMap<String, zzafn> zzfpc;

  private zzbzb(zzbzd paramzzbzd)
  {
    this.zzfow = paramzzbzd.zzfow;
    this.zzfox = paramzzbzd.zzfox;
    this.zzfoy = paramzzbzd.zzfoy;
    this.zzfpb = new SimpleArrayMap(paramzzbzd.zzfpb);
    this.zzfpc = new SimpleArrayMap(paramzzbzd.zzfpc);
    this.zzfoz = paramzzbzd.zzfoz;
    this.zzfpa = paramzzbzd.zzfpa;
  }

  public final zzafk zzaii()
  {
    return this.zzfow;
  }

  public final zzafh zzaij()
  {
    return this.zzfox;
  }

  public final zzafw zzaik()
  {
    return this.zzfoy;
  }

  public final zzaft zzail()
  {
    return this.zzfoz;
  }

  public final zzajf zzaim()
  {
    return this.zzfpa;
  }

  public final ArrayList<String> zzain()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.zzfoy != null)
      localArrayList.add(Integer.toString(6));
    if (this.zzfow != null)
      localArrayList.add(Integer.toString(1));
    if (this.zzfox != null)
      localArrayList.add(Integer.toString(2));
    if (this.zzfpb.size() > 0)
      localArrayList.add(Integer.toString(3));
    if (this.zzfpa != null)
      localArrayList.add(Integer.toString(7));
    return localArrayList;
  }

  public final ArrayList<String> zzaio()
  {
    ArrayList localArrayList = new ArrayList(this.zzfpb.size());
    for (int i = 0; i < this.zzfpb.size(); i++)
      localArrayList.add((String)this.zzfpb.keyAt(i));
    return localArrayList;
  }

  public final zzafq zzfn(String paramString)
  {
    return (zzafq)this.zzfpb.get(paramString);
  }

  public final zzafn zzfo(String paramString)
  {
    return (zzafn)this.zzfpc.get(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzb
 * JD-Core Version:    0.6.2
 */