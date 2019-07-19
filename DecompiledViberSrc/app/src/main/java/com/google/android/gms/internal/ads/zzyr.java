package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

@zzare
public final class zzyr
{
  private static zzyr zzcie = new zzyr();
  private final zzazu zzcif;
  private final zzyf zzcig;
  private final String zzcih;
  private final zzaco zzcii;
  private final zzacp zzcij;
  private final zzacq zzcik;
  private final zzbaj zzcil;
  private final Random zzcim;
  private final WeakHashMap<Object, String> zzcin;

  protected zzyr()
  {
    this(new zzazu(), new zzyf(new zzxv(), new zzxu(), new zzabj(), new zzagj(), new zzatg(), new zzauk(), new zzaqg(), new zzagk()), new zzaco(), new zzacp(), new zzacq(), zzazu.zzwz(), new zzbaj(0, 15000000, true), new Random(), new WeakHashMap());
  }

  private zzyr(zzazu paramzzazu, zzyf paramzzyf, zzaco paramzzaco, zzacp paramzzacp, zzacq paramzzacq, String paramString, zzbaj paramzzbaj, Random paramRandom, WeakHashMap<Object, String> paramWeakHashMap)
  {
    this.zzcif = paramzzazu;
    this.zzcig = paramzzyf;
    this.zzcii = paramzzaco;
    this.zzcij = paramzzacp;
    this.zzcik = paramzzacq;
    this.zzcih = paramString;
    this.zzcil = paramzzbaj;
    this.zzcim = paramRandom;
    this.zzcin = paramWeakHashMap;
  }

  public static zzazu zzpa()
  {
    return zzcie.zzcif;
  }

  public static zzyf zzpb()
  {
    return zzcie.zzcig;
  }

  public static zzacp zzpc()
  {
    return zzcie.zzcij;
  }

  public static zzaco zzpd()
  {
    return zzcie.zzcii;
  }

  public static zzacq zzpe()
  {
    return zzcie.zzcik;
  }

  public static String zzpf()
  {
    return zzcie.zzcih;
  }

  public static zzbaj zzpg()
  {
    return zzcie.zzcil;
  }

  public static Random zzph()
  {
    return zzcie.zzcim;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyr
 * JD-Core Version:    0.6.2
 */