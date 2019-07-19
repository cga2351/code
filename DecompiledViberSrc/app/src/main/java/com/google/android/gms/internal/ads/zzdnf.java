package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzdnf
  implements zzdpz
{
  private int tag;
  private final zzdnc zzhdj;
  private int zzhdk;
  private int zzhdl = 0;

  private zzdnf(zzdnc paramzzdnc)
  {
    this.zzhdj = ((zzdnc)zzdoc.zza(paramzzdnc, "input"));
    this.zzhdj.zzhdc = this;
  }

  public static zzdnf zza(zzdnc paramzzdnc)
  {
    if (paramzzdnc.zzhdc != null)
      return paramzzdnc.zzhdc;
    return new zzdnf(paramzzdnc);
  }

  private final Object zza(zzdrh paramzzdrh, Class<?> paramClass, zzdnn paramzzdnn)
    throws IOException
  {
    switch (zzdng.zzhdm[paramzzdrh.ordinal()])
    {
    default:
      throw new RuntimeException("unsupported field type.");
    case 1:
      return Boolean.valueOf(zzawa());
    case 2:
      return zzawc();
    case 3:
      return Double.valueOf(readDouble());
    case 4:
      return Integer.valueOf(zzawe());
    case 5:
      return Integer.valueOf(zzavz());
    case 6:
      return Long.valueOf(zzavy());
    case 7:
      return Float.valueOf(readFloat());
    case 8:
      return Integer.valueOf(zzavx());
    case 9:
      return Long.valueOf(zzavw());
    case 10:
      zzfv(2);
      return zzc(zzdpw.zzazg().zzg(paramClass), paramzzdnn);
    case 11:
      return Integer.valueOf(zzawf());
    case 12:
      return Long.valueOf(zzawg());
    case 13:
      return Integer.valueOf(zzawh());
    case 14:
      return Long.valueOf(zzawi());
    case 15:
      return zzawb();
    case 16:
      return Integer.valueOf(zzawd());
    case 17:
    }
    return Long.valueOf(zzavv());
  }

  private final void zza(List<String> paramList, boolean paramBoolean)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzdoj.zzayi();
    if (((paramList instanceof zzdos)) && (!paramBoolean))
    {
      zzdos localzzdos = (zzdos)paramList;
      int j;
      do
      {
        localzzdos.zzdb(zzawc());
        if (this.zzhdj.zzawk())
          return;
        j = this.zzhdj.zzavu();
      }
      while (j == this.tag);
      this.zzhdl = j;
      return;
    }
    label79: if (paramBoolean);
    for (String str = zzawb(); ; str = readString())
    {
      paramList.add(str);
      if (this.zzhdj.zzawk())
        break;
      int i = this.zzhdj.zzavu();
      if (i == this.tag)
        break label79;
      this.zzhdl = i;
      return;
    }
  }

  private final <T> T zzc(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    int i = this.zzhdj.zzawd();
    if (this.zzhdj.zzhcz >= this.zzhdj.zzhda)
      throw new zzdoj("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    int j = this.zzhdj.zzfr(i);
    Object localObject = paramzzdqa.newInstance();
    zzdnc localzzdnc1 = this.zzhdj;
    localzzdnc1.zzhcz = (1 + localzzdnc1.zzhcz);
    paramzzdqa.zza(localObject, this, paramzzdnn);
    paramzzdqa.zzaa(localObject);
    this.zzhdj.zzfp(0);
    zzdnc localzzdnc2 = this.zzhdj;
    localzzdnc2.zzhcz = (-1 + localzzdnc2.zzhcz);
    this.zzhdj.zzfs(j);
    return localObject;
  }

  private final <T> T zzd(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    int i = this.zzhdk;
    this.zzhdk = (0x4 | this.tag >>> 3 << 3);
    Object localObject2;
    try
    {
      localObject2 = paramzzdqa.newInstance();
      paramzzdqa.zza(localObject2, this, paramzzdnn);
      paramzzdqa.zzaa(localObject2);
      if (this.tag != this.zzhdk)
        throw zzdoj.zzayj();
    }
    finally
    {
      this.zzhdk = i;
    }
    this.zzhdk = i;
    return localObject2;
  }

  private final void zzfv(int paramInt)
    throws IOException
  {
    if ((0x7 & this.tag) != paramInt)
      throw zzdoj.zzayi();
  }

  private static void zzfw(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x7) != 0)
      throw zzdoj.zzayj();
  }

  private static void zzfx(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x3) != 0)
      throw zzdoj.zzayj();
  }

  private final void zzfy(int paramInt)
    throws IOException
  {
    if (this.zzhdj.zzawl() != paramInt)
      throw zzdoj.zzayd();
  }

  public final int getTag()
  {
    return this.tag;
  }

  public final double readDouble()
    throws IOException
  {
    zzfv(1);
    return this.zzhdj.readDouble();
  }

  public final float readFloat()
    throws IOException
  {
    zzfv(5);
    return this.zzhdj.readFloat();
  }

  public final String readString()
    throws IOException
  {
    zzfv(2);
    return this.zzhdj.readString();
  }

  public final void readStringList(List<String> paramList)
    throws IOException
  {
    zza(paramList, false);
  }

  public final <T> T zza(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    zzfv(2);
    return zzc(paramzzdqa, paramzzdnn);
  }

  public final <T> void zza(List<T> paramList, zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzdoj.zzayi();
    int i = this.tag;
    int j;
    do
    {
      paramList.add(zzc(paramzzdqa, paramzzdnn));
      if ((this.zzhdj.zzawk()) || (this.zzhdl != 0))
        return;
      j = this.zzhdj.zzavu();
    }
    while (j == i);
    this.zzhdl = j;
  }

  public final <K, V> void zza(Map<K, V> paramMap, zzdpc<K, V> paramzzdpc, zzdnn paramzzdnn)
    throws IOException
  {
    zzfv(2);
    int i = this.zzhdj.zzawd();
    int j = this.zzhdj.zzfr(i);
    Object localObject1 = paramzzdpc.zzhjj;
    Object localObject2 = paramzzdpc.zzcki;
    while (true)
    {
      try
      {
        int k = zzaws();
        if (k == 2147483647)
          break;
        boolean bool = this.zzhdj.zzawk();
        if (bool)
          break;
        switch (k)
        {
        default:
          try
          {
            if (zzawt())
              continue;
            throw new zzdoj("Unable to parse map entry.");
          }
          catch (zzdok localzzdok)
          {
          }
          if (zzawt())
            continue;
          throw new zzdoj("Unable to parse map entry.");
        case 1:
        case 2:
        }
      }
      finally
      {
        this.zzhdj.zzfs(j);
      }
      localObject1 = zza(paramzzdpc.zzhji, null, null);
      continue;
      Object localObject4 = zza(paramzzdpc.zzhjk, paramzzdpc.zzcki.getClass(), paramzzdnn);
      localObject2 = localObject4;
    }
    paramMap.put(localObject1, localObject2);
    this.zzhdj.zzfs(j);
  }

  public final long zzavv()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzavv();
  }

  public final long zzavw()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzavw();
  }

  public final int zzavx()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzavx();
  }

  public final long zzavy()
    throws IOException
  {
    zzfv(1);
    return this.zzhdj.zzavy();
  }

  public final int zzavz()
    throws IOException
  {
    zzfv(5);
    return this.zzhdj.zzavz();
  }

  public final boolean zzawa()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzawa();
  }

  public final String zzawb()
    throws IOException
  {
    zzfv(2);
    return this.zzhdj.zzawb();
  }

  public final zzdmq zzawc()
    throws IOException
  {
    zzfv(2);
    return this.zzhdj.zzawc();
  }

  public final int zzawd()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzawd();
  }

  public final int zzawe()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzawe();
  }

  public final int zzawf()
    throws IOException
  {
    zzfv(5);
    return this.zzhdj.zzawf();
  }

  public final long zzawg()
    throws IOException
  {
    zzfv(1);
    return this.zzhdj.zzawg();
  }

  public final int zzawh()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzawh();
  }

  public final long zzawi()
    throws IOException
  {
    zzfv(0);
    return this.zzhdj.zzawi();
  }

  public final int zzaws()
    throws IOException
  {
    if (this.zzhdl != 0)
    {
      this.tag = this.zzhdl;
      this.zzhdl = 0;
    }
    while ((this.tag == 0) || (this.tag == this.zzhdk))
    {
      return 2147483647;
      this.tag = this.zzhdj.zzavu();
    }
    return this.tag >>> 3;
  }

  public final boolean zzawt()
    throws IOException
  {
    if ((this.zzhdj.zzawk()) || (this.tag == this.zzhdk))
      return false;
    return this.zzhdj.zzfq(this.tag);
  }

  public final <T> T zzb(zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    zzfv(3);
    return zzd(paramzzdqa, paramzzdnn);
  }

  public final <T> void zzb(List<T> paramList, zzdqa<T> paramzzdqa, zzdnn paramzzdnn)
    throws IOException
  {
    if ((0x7 & this.tag) != 3)
      throw zzdoj.zzayi();
    int i = this.tag;
    int j;
    do
    {
      paramList.add(zzd(paramzzdqa, paramzzdnn));
      if ((this.zzhdj.zzawk()) || (this.zzhdl != 0))
        return;
      j = this.zzhdj.zzavu();
    }
    while (j == i);
    this.zzhdl = j;
  }

  public final void zzi(List<Double> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdnk))
    {
      zzdnk localzzdnk = (zzdnk)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfw(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdnk.zzd(this.zzhdj.readDouble());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzdnk.zzd(this.zzhdj.readDouble());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfw(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Double.valueOf(this.zzhdj.readDouble()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Double.valueOf(this.zzhdj.readDouble()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzj(List<Float> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdnx))
    {
      zzdnx localzzdnx = (zzdnx)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfx(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdnx.zzi(this.zzhdj.readFloat());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzdnx.zzi(this.zzhdj.readFloat());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfx(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Float.valueOf(this.zzhdj.readFloat()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Float.valueOf(this.zzhdj.readFloat()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzk(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdox))
    {
      zzdox localzzdox = (zzdox)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdox.zzfu(this.zzhdj.zzavv());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdox.zzfu(this.zzhdj.zzavv());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Long.valueOf(this.zzhdj.zzavv()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzhdj.zzavv()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzl(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdox))
    {
      zzdox localzzdox = (zzdox)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdox.zzfu(this.zzhdj.zzavw());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdox.zzfu(this.zzhdj.zzavw());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Long.valueOf(this.zzhdj.zzavw()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzhdj.zzavw()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzm(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzavx());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzavx());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzavx()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzavx()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzn(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdox))
    {
      zzdox localzzdox = (zzdox)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfw(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdox.zzfu(this.zzhdj.zzavy());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzdox.zzfu(this.zzhdj.zzavy());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfw(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Long.valueOf(this.zzhdj.zzavy()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzhdj.zzavy()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzo(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfx(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzavz());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzavz());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfx(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzavz()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzavz()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzp(List<Boolean> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdmo))
    {
      zzdmo localzzdmo = (zzdmo)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdmo.addBoolean(this.zzhdj.zzawa());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdmo.addBoolean(this.zzhdj.zzawa());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Boolean.valueOf(this.zzhdj.zzawa()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Boolean.valueOf(this.zzhdj.zzawa()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzq(List<String> paramList)
    throws IOException
  {
    zza(paramList, true);
  }

  public final void zzr(List<zzdmq> paramList)
    throws IOException
  {
    if ((0x7 & this.tag) != 2)
      throw zzdoj.zzayi();
    int i;
    do
    {
      paramList.add(zzawc());
      if (this.zzhdj.zzawk())
        return;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzs(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzawd());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzawd());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzawd()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzawd()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzt(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzawe());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzawe());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzawe()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzawe()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzu(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 3:
      case 4:
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfx(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzawf());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 5:
      }
      int m;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzawf());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 3:
    case 4:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfx(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzawf()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 5:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzawf()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzv(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdox))
    {
      zzdox localzzdox = (zzdox)paramList;
      switch (0x7 & this.tag)
      {
      default:
        throw zzdoj.zzayi();
      case 2:
        int n = this.zzhdj.zzawd();
        zzfw(n);
        int i1 = n + this.zzhdj.zzawl();
        do
          localzzdox.zzfu(this.zzhdj.zzawg());
        while (this.zzhdj.zzawl() < i1);
        return;
      case 1:
      }
      int m;
      do
      {
        localzzdox.zzfu(this.zzhdj.zzawg());
        if (this.zzhdj.zzawk())
          break;
        m = this.zzhdj.zzavu();
      }
      while (m == this.tag);
      this.zzhdl = m;
      return;
    }
    switch (0x7 & this.tag)
    {
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd();
      zzfw(j);
      int k = j + this.zzhdj.zzawl();
      do
        paramList.add(Long.valueOf(this.zzhdj.zzawg()));
      while (this.zzhdj.zzawl() < k);
      return;
    case 1:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzhdj.zzawg()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzw(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdob))
    {
      zzdob localzzdob = (zzdob)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdob.zzgp(this.zzhdj.zzawh());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdob.zzgp(this.zzhdj.zzawh());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Integer.valueOf(this.zzhdj.zzawh()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Integer.valueOf(this.zzhdj.zzawh()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }

  public final void zzx(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zzdox))
    {
      zzdox localzzdox = (zzdox)paramList;
      switch (0x7 & this.tag)
      {
      case 1:
      default:
        throw zzdoj.zzayi();
      case 2:
        int m = this.zzhdj.zzawd() + this.zzhdj.zzawl();
        do
          localzzdox.zzfu(this.zzhdj.zzawi());
        while (this.zzhdj.zzawl() < m);
        zzfy(m);
        return;
      case 0:
      }
      int k;
      do
      {
        localzzdox.zzfu(this.zzhdj.zzawi());
        if (this.zzhdj.zzawk())
          break;
        k = this.zzhdj.zzavu();
      }
      while (k == this.tag);
      this.zzhdl = k;
      return;
    }
    switch (0x7 & this.tag)
    {
    case 1:
    default:
      throw zzdoj.zzayi();
    case 2:
      int j = this.zzhdj.zzawd() + this.zzhdj.zzawl();
      do
        paramList.add(Long.valueOf(this.zzhdj.zzawi()));
      while (this.zzhdj.zzawl() < j);
      zzfy(j);
      return;
    case 0:
    }
    int i;
    do
    {
      paramList.add(Long.valueOf(this.zzhdj.zzawi()));
      if (this.zzhdj.zzawk())
        break;
      i = this.zzhdj.zzavu();
    }
    while (i == this.tag);
    this.zzhdl = i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnf
 * JD-Core Version:    0.6.2
 */