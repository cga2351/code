package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzcxw
{
  private boolean zzbqn;
  private zzadx zzdgu;
  private zzyb zzdln;
  private zzaiz zzdng;
  private zzxx zzghg;
  private zzzw zzgkz;
  private zzacc zzgla;
  private String zzglb;
  private ArrayList<String> zzglc;
  private ArrayList<String> zzgld;
  private String zzgle;
  private String zzglf;
  private int zzglg = 1;
  private PublisherAdViewOptions zzglh;
  private zzzq zzgli;
  public final Set<String> zzglj = new HashSet();

  public final zzxx zzamo()
  {
    return this.zzghg;
  }

  public final String zzamp()
  {
    return this.zzglb;
  }

  public final zzcxu zzamq()
  {
    Preconditions.checkNotNull(this.zzglb, "ad unit must not be null");
    Preconditions.checkNotNull(this.zzdln, "ad size must not be null");
    Preconditions.checkNotNull(this.zzghg, "ad request must not be null");
    return new zzcxu(this, null);
  }

  public final zzcxw zzb(PublisherAdViewOptions paramPublisherAdViewOptions)
  {
    this.zzglh = paramPublisherAdViewOptions;
    if (paramPublisherAdViewOptions != null)
    {
      this.zzbqn = paramPublisherAdViewOptions.getManualImpressionsEnabled();
      this.zzgli = paramPublisherAdViewOptions.zzkt();
    }
    return this;
  }

  public final zzcxw zzb(zzadx paramzzadx)
  {
    this.zzdgu = paramzzadx;
    return this;
  }

  public final zzcxw zzb(zzaiz paramzzaiz)
  {
    this.zzdng = paramzzaiz;
    this.zzgla = new zzacc(false, true, false);
    return this;
  }

  public final zzcxw zzb(ArrayList<String> paramArrayList)
  {
    this.zzglc = paramArrayList;
    return this;
  }

  public final zzcxw zzbc(boolean paramBoolean)
  {
    this.zzbqn = paramBoolean;
    return this;
  }

  public final zzcxw zzc(zzacc paramzzacc)
  {
    this.zzgla = paramzzacc;
    return this;
  }

  public final zzcxw zzc(ArrayList<String> paramArrayList)
  {
    this.zzgld = paramArrayList;
    return this;
  }

  public final zzcxw zzd(zzyb paramzzyb)
  {
    this.zzdln = paramzzyb;
    return this;
  }

  public final zzcxw zzd(zzzw paramzzzw)
  {
    this.zzgkz = paramzzzw;
    return this;
  }

  public final zzcxw zzdp(int paramInt)
  {
    this.zzglg = paramInt;
    return this;
  }

  public final zzcxw zzft(String paramString)
  {
    this.zzglb = paramString;
    return this;
  }

  public final zzcxw zzfu(String paramString)
  {
    this.zzgle = paramString;
    return this;
  }

  public final zzcxw zzfv(String paramString)
  {
    this.zzglf = paramString;
    return this;
  }

  public final zzcxw zzg(zzxx paramzzxx)
  {
    this.zzghg = paramzzxx;
    return this;
  }

  public final zzyb zzpn()
  {
    return this.zzdln;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxw
 * JD-Core Version:    0.6.2
 */