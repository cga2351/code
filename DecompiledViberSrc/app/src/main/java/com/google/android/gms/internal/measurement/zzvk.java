package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

final class zzvk
  implements zzwm
{
  private static final zzvu zzcai = new zzvl();
  private final zzvu zzcah;

  public zzvk()
  {
    this(new zzvm(arrayOfzzvu));
  }

  private zzvk(zzvu paramzzvu)
  {
    this.zzcah = ((zzvu)zzuq.zza(paramzzvu, "messageInfoFactory"));
  }

  private static boolean zza(zzvt paramzzvt)
  {
    return paramzzvt.zzxm() == zzuo.zze.zzbyu;
  }

  private static zzvu zzxf()
  {
    try
    {
      zzvu localzzvu = (zzvu)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      return localzzvu;
    }
    catch (Exception localException)
    {
    }
    return zzcai;
  }

  public final <T> zzwl<T> zzh(Class<T> paramClass)
  {
    zzwn.zzj(paramClass);
    zzvt localzzvt = this.zzcah.zzf(paramClass);
    if (localzzvt.zzxn())
    {
      if (zzuo.class.isAssignableFrom(paramClass))
        return zzwa.zza(zzwn.zzxz(), zzue.zzvu(), localzzvt.zzxo());
      return zzwa.zza(zzwn.zzxx(), zzue.zzvv(), localzzvt.zzxo());
    }
    if (zzuo.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzvt))
        return zzvz.zza(paramClass, localzzvt, zzwe.zzxr(), zzvf.zzxe(), zzwn.zzxz(), zzue.zzvu(), zzvs.zzxk());
      return zzvz.zza(paramClass, localzzvt, zzwe.zzxr(), zzvf.zzxe(), zzwn.zzxz(), null, zzvs.zzxk());
    }
    if (zza(localzzvt))
      return zzvz.zza(paramClass, localzzvt, zzwe.zzxq(), zzvf.zzxd(), zzwn.zzxx(), zzue.zzvv(), zzvs.zzxj());
    return zzvz.zza(paramClass, localzzvt, zzwe.zzxq(), zzvf.zzxd(), zzwn.zzxy(), null, zzvs.zzxj());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvk
 * JD-Core Version:    0.6.2
 */