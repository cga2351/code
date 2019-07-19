package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zztt
  implements zzwk
{
  private int tag;
  private final zztq zzbuk;
  private int zzbul;
  private int zzbum = 0;

  private zztt(zztq paramzztq)
  {
    this.zzbuk = ((zztq)zzuq.zza(paramzztq, "input"));
    this.zzbuk.zzbud = this;
  }

  public static zztt zza(zztq paramzztq)
  {
    if (paramzztq.zzbud != null)
      return paramzztq.zzbud;
    return new zztt(paramzztq);
  }

  private final Object zza(zzxs paramzzxs, Class<?> paramClass, zzub paramzzub)
    throws IOException
  {
    switch (zztu.zzbun[paramzzxs.ordinal()])
    {
    default:
      throw new RuntimeException("unsupported field type.");
    case 1:
      return Boolean.valueOf(zzup());
    case 2:
      return zzur();
    case 3:
      return Double.valueOf(readDouble());
    case 4:
      return Integer.valueOf(zzut());
    case 5:
      return Integer.valueOf(zzuo());
    case 6:
      return Long.valueOf(zzun());
    case 7:
      return Float.valueOf(readFloat());
    case 8:
      return Integer.valueOf(zzum());
    case 9:
      return Long.valueOf(zzul());
    case 10:
      zzav(2);
      return zzc(zzwh.zzxt().zzi(paramClass), paramzzub);
    case 11:
      return Integer.valueOf(zzuu());
    case 12:
      return Long.valueOf(zzuv());
    case 13:
      return Integer.valueOf(zzuw());
    case 14:
      return Long.valueOf(zzux());
    case 15:
      return zzuq();
    case 16:
      return Integer.valueOf(zzus());
    case 17:
    }
    return Long.valueOf(zzuk());
  }

  private final void zza(List<String> paramList, boolean paramBoolean)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzuv.zzwu();
    if (((paramList instanceof zzve)) && (!paramBoolean))
    {
      zzve localzzve = (zzve)paramList;
      int j;
      do
      {
        localzzve.zzc(zzur());
        if (this.zzbuk.zzuz())
          return;
        j = this.zzbuk.zzuj();
      }
      while (j == this.tag);
      this.zzbum = j;
      return;
    }
    label79: if (paramBoolean);
    for (String str = zzuq(); ; str = readString())
    {
      paramList.add(str);
      if (this.zzbuk.zzuz())
        break;
      int i = this.zzbuk.zzuj();
      if (i == this.tag)
        break label79;
      this.zzbum = i;
      return;
    }
  }

  private final void zzav(int paramInt)
    throws IOException
  {
    if ((0x7 & this.tag) != paramInt)
      throw zzuv.zzwu();
  }

  private static void zzaw(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x7) != 0)
      throw zzuv.zzww();
  }

  private static void zzax(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x3) != 0)
      throw zzuv.zzww();
  }

  private final void zzay(int paramInt)
    throws IOException
  {
    if (this.zzbuk.zzva() != paramInt)
      throw zzuv.zzwq();
  }

  private final <T> T zzc(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    int i = this.zzbuk.zzus();
    if (this.zzbuk.zzbua >= this.zzbuk.zzbub)
      throw zzuv.zzwv();
    int j = this.zzbuk.zzas(i);
    Object localObject = paramzzwl.newInstance();
    zztq localzztq1 = this.zzbuk;
    localzztq1.zzbua = (1 + localzztq1.zzbua);
    paramzzwl.zza(localObject, this, paramzzub);
    paramzzwl.zzy(localObject);
    this.zzbuk.zzap(0);
    zztq localzztq2 = this.zzbuk;
    localzztq2.zzbua = (-1 + localzztq2.zzbua);
    this.zzbuk.zzat(j);
    return localObject;
  }

  private final <T> T zzd(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    int i = this.zzbul;
    this.zzbul = (0x4 | this.tag >>> 3 << 3);
    Object localObject2;
    try
    {
      localObject2 = paramzzwl.newInstance();
      paramzzwl.zza(localObject2, this, paramzzub);
      paramzzwl.zzy(localObject2);
      if (this.tag != this.zzbul)
        throw zzuv.zzww();
    }
    finally
    {
      this.zzbul = i;
    }
    this.zzbul = i;
    return localObject2;
  }

  public final int getTag()
  {
    return this.tag;
  }

  public final double readDouble()
    throws IOException
  {
    zzav(1);
    return this.zzbuk.readDouble();
  }

  public final float readFloat()
    throws IOException
  {
    zzav(5);
    return this.zzbuk.readFloat();
  }

  public final String readString()
    throws IOException
  {
    zzav(2);
    return this.zzbuk.readString();
  }

  public final void readStringList(List<String> paramList)
    throws IOException
  {
    zza(paramList, false);
  }

  public final <T> T zza(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    zzav(2);
    return zzc(paramzzwl, paramzzub);
  }

  public final <T> void zza(List<T> paramList, zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzuv.zzwu();
    int i = this.tag;
    int j;
    do
    {
      paramList.add(zzc(paramzzwl, paramzzub));
      if ((this.zzbuk.zzuz()) || (this.zzbum != 0))
        return;
      j = this.zzbuk.zzuj();
    }
    while (j == i);
    this.zzbum = j;
  }

  public final <K, V> void zza(Map<K, V> paramMap, zzvo<K, V> paramzzvo, zzub paramzzub)
    throws IOException
  {
    zzav(2);
    int i = this.zzbuk.zzus();
    int j = this.zzbuk.zzas(i);
    Object localObject1 = paramzzvo.zzcal;
    Object localObject2 = paramzzvo.zzbrr;
    while (true)
    {
      try
      {
        int k = zzvh();
        if (k == 2147483647)
          break;
        boolean bool = this.zzbuk.zzuz();
        if (bool)
          break;
        switch (k)
        {
        default:
          try
          {
            if (zzvi())
              continue;
            throw new zzuv("Unable to parse map entry.");
          }
          catch (zzuw localzzuw)
          {
          }
          if (zzvi())
            continue;
          throw new zzuv("Unable to parse map entry.");
        case 1:
        case 2:
        }
      }
      finally
      {
        this.zzbuk.zzat(j);
      }
      localObject1 = zza(paramzzvo.zzcak, null, null);
      continue;
      Object localObject4 = zza(paramzzvo.zzcam, paramzzvo.zzbrr.getClass(), paramzzub);
      localObject2 = localObject4;
    }
    paramMap.put(localObject1, localObject2);
    this.zzbuk.zzat(j);
  }

  public final <T> T zzb(zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    zzav(3);
    return zzd(paramzzwl, paramzzub);
  }

  public final <T> void zzb(List<T> paramList, zzwl<T> paramzzwl, zzub paramzzub)
    throws IOException
  {
    if ((0x7 & this.tag) != 3)
      throw zzuv.zzwu();
    int i = this.tag;
    int j;
    do
    {
      paramList.add(zzd(paramzzwl, paramzzub));
      if ((this.zzbuk.zzuz()) || (this.zzbum != 0))
        return;
      j = this.zzbuk.zzuj();
    }
    while (j == i);
    this.zzbum = j;
  }

  public final void zzi(List<Double> paramList)
    throws IOException
  {
    if ((paramList instanceof zzty))
    {
      zzty localzzty = (zzty)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzaw(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzty.zzd(this.zzbuk.readDouble());
        while (this.zzbuk.zzva() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzty.zzd(this.zzbuk.readDouble());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzaw(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Double.valueOf(this.zzbuk.readDouble()));
      while (this.zzbuk.zzva() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Double.valueOf(this.zzbuk.readDouble()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzj(List<Float> paramList)
    throws IOException
  {
    if ((paramList instanceof zzul))
    {
      zzul localzzul = (zzul)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzax(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzul.zzc(this.zzbuk.readFloat());
        while (this.zzbuk.zzva() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzul.zzc(this.zzbuk.readFloat());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzax(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Float.valueOf(this.zzbuk.readFloat()));
      while (this.zzbuk.zzva() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Float.valueOf(this.zzbuk.readFloat()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzk(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzvj))
    {
      zzvj localzzvj = (zzvj)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzvj.zzbe(this.zzbuk.zzuk());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzvj.zzbe(this.zzbuk.zzuk());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Long.valueOf(this.zzbuk.zzuk()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzbuk.zzuk()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzl(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzvj))
    {
      zzvj localzzvj = (zzvj)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzvj.zzbe(this.zzbuk.zzul());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzvj.zzbe(this.zzbuk.zzul());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Long.valueOf(this.zzbuk.zzul()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzbuk.zzul()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzm(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzum());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzup.zzbo(this.zzbuk.zzum());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzum()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzum()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzn(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzvj))
    {
      zzvj localzzvj = (zzvj)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzaw(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzvj.zzbe(this.zzbuk.zzun());
        while (this.zzbuk.zzva() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzvj.zzbe(this.zzbuk.zzun());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzaw(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Long.valueOf(this.zzbuk.zzun()));
      while (this.zzbuk.zzva() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzbuk.zzun()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzo(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzax(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzuo());
        while (this.zzbuk.zzva() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzup.zzbo(this.zzbuk.zzuo());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzax(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzuo()));
      while (this.zzbuk.zzva() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzuo()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzp(List<Boolean> paramList)
    throws IOException
  {
    if ((paramList instanceof zztc))
    {
      zztc localzztc = (zztc)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzztc.addBoolean(this.zzbuk.zzup());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzztc.addBoolean(this.zzbuk.zzup());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Boolean.valueOf(this.zzbuk.zzup()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Boolean.valueOf(this.zzbuk.zzup()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzq(List<String> paramList)
    throws IOException
  {
    zza(paramList, true);
  }

  public final void zzr(List<zzte> paramList)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzuv.zzwu();
    int i;
    do
    {
      paramList.add(zzur());
      if (this.zzbuk.zzuz())
        return;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzs(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzus());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzup.zzbo(this.zzbuk.zzus());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzus()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzus()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzt(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzut());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzup.zzbo(this.zzbuk.zzut());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzut()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzut()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzu(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzax(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzuu());
        while (this.zzbuk.zzva() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzup.zzbo(this.zzbuk.zzuu());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzax(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzuu()));
      while (this.zzbuk.zzva() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzuu()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final long zzuk()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzuk();
  }

  public final long zzul()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzul();
  }

  public final int zzum()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzum();
  }

  public final long zzun()
    throws IOException
  {
    zzav(1);
    return this.zzbuk.zzun();
  }

  public final int zzuo()
    throws IOException
  {
    zzav(5);
    return this.zzbuk.zzuo();
  }

  public final boolean zzup()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzup();
  }

  public final String zzuq()
    throws IOException
  {
    zzav(2);
    return this.zzbuk.zzuq();
  }

  public final zzte zzur()
    throws IOException
  {
    zzav(2);
    return this.zzbuk.zzur();
  }

  public final int zzus()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzus();
  }

  public final int zzut()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzut();
  }

  public final int zzuu()
    throws IOException
  {
    zzav(5);
    return this.zzbuk.zzuu();
  }

  public final long zzuv()
    throws IOException
  {
    zzav(1);
    return this.zzbuk.zzuv();
  }

  public final int zzuw()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzuw();
  }

  public final long zzux()
    throws IOException
  {
    zzav(0);
    return this.zzbuk.zzux();
  }

  public final void zzv(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzvj))
    {
      zzvj localzzvj = (zzvj)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzuv.zzwu();
      case 2:
        int n = this.zzbuk.zzus();
        zzaw(n);
        int i1 = n + this.zzbuk.zzva();
        do
          localzzvj.zzbe(this.zzbuk.zzuv());
        while (this.zzbuk.zzva() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzvj.zzbe(this.zzbuk.zzuv());
        if (this.zzbuk.zzuz())
          break;
        m = this.zzbuk.zzuj();
      }
      while (m == this.tag);
      this.zzbum = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus();
      zzaw(j);
      int k = j + this.zzbuk.zzva();
      do
        paramList.add(Long.valueOf(this.zzbuk.zzuv()));
      while (this.zzbuk.zzva() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzbuk.zzuv()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final int zzvh()
    throws IOException
  {
    if (this.zzbum != 0)
    {
      this.tag = this.zzbum;
      this.zzbum = 0;
    }
    while ((this.tag == 0) || (this.tag == this.zzbul))
    {
      return 2147483647;
      this.tag = this.zzbuk.zzuj();
    }
    return this.tag >>> 3;
  }

  public final boolean zzvi()
    throws IOException
  {
    if ((this.zzbuk.zzuz()) || (this.tag == this.zzbul))
      return false;
    return this.zzbuk.zzaq(this.tag);
  }

  public final void zzw(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzup))
    {
      zzup localzzup = (zzup)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzup.zzbo(this.zzbuk.zzuw());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzup.zzbo(this.zzbuk.zzuw());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Integer.valueOf(this.zzbuk.zzuw()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzbuk.zzuw()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }

  public final void zzx(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzvj))
    {
      zzvj localzzvj = (zzvj)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzuv.zzwu();
      case 2:
        int m = this.zzbuk.zzus() + this.zzbuk.zzva();
        do
          localzzvj.zzbe(this.zzbuk.zzux());
        while (this.zzbuk.zzva() < m);
        zzay(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzvj.zzbe(this.zzbuk.zzux());
        if (this.zzbuk.zzuz())
          break;
        k = this.zzbuk.zzuj();
      }
      while (k == this.tag);
      this.zzbum = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzuv.zzwu();
    case 2:
      int j = this.zzbuk.zzus() + this.zzbuk.zzva();
      do
        paramList.add(Long.valueOf(this.zzbuk.zzux()));
      while (this.zzbuk.zzva() < j);
      zzay(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzbuk.zzux()));
      if (this.zzbuk.zzuz())
        break;
      i = this.zzbuk.zzuj();
    }
    while (i == this.tag);
    this.zzbum = i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztt
 * JD-Core Version:    0.6.2
 */