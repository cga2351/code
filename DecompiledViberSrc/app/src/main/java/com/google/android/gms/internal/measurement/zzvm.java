package com.google.android.gms.internal.measurement;

final class zzvm
  implements zzvu
{
  private zzvu[] zzcaj;

  zzvm(zzvu[] paramArrayOfzzvu)
  {
    this.zzcaj = paramArrayOfzzvu;
  }

  public final boolean zze(Class<?> paramClass)
  {
    zzvu[] arrayOfzzvu = this.zzcaj;
    int i = arrayOfzzvu.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfzzvu[j].zze(paramClass))
          bool = true;
      }
      else
        return bool;
    }
  }

  public final zzvt zzf(Class<?> paramClass)
  {
    for (zzvu localzzvu : this.zzcaj)
      if (localzzvu.zze(paramClass))
        return localzzvu.zzf(paramClass);
    String str1 = String.valueOf(paramClass.getName());
    if (str1.length() != 0);
    for (String str2 = "No factory is available for message type: ".concat(str1); ; str2 = new String("No factory is available for message type: "))
      throw new UnsupportedOperationException(str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzvm
 * JD-Core Version:    0.6.2
 */