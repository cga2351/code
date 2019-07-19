package com.google.android.gms.internal.ads;

public class zzcgl extends Exception
{
  private final int errorCode;

  public zzcgl(int paramInt)
  {
    this.errorCode = paramInt;
  }

  public zzcgl(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }

  public zzcgl(String paramString, Throwable paramThrowable, int paramInt)
  {
    super(paramString, paramThrowable);
    this.errorCode = 0;
  }

  public static int zze(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof zzcgl))
      return ((zzcgl)paramThrowable).errorCode;
    if ((paramThrowable instanceof zzayo))
      return ((zzayo)paramThrowable).getErrorCode();
    return 0;
  }

  public final int getErrorCode()
  {
    return this.errorCode;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcgl
 * JD-Core Version:    0.6.2
 */