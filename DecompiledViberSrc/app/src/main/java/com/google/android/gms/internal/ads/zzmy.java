package com.google.android.gms.internal.ads;

public class zzmy
{
  private int flags;

  public void clear()
  {
    this.flags = 0;
  }

  public final void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }

  public final void zzal(int paramInt)
  {
    this.flags = (0x80000000 | this.flags);
  }

  protected final boolean zzam(int paramInt)
  {
    return (paramInt & this.flags) == paramInt;
  }

  public final boolean zzib()
  {
    return zzam(-2147483648);
  }

  public final boolean zzic()
  {
    return zzam(4);
  }

  public final boolean zzid()
  {
    return zzam(1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmy
 * JD-Core Version:    0.6.2
 */