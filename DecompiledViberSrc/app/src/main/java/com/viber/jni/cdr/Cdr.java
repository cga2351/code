package com.viber.jni.cdr;

public class Cdr
{
  long m_Cdr = 0L;

  public static Cdr Create(String paramString)
  {
    Cdr localCdr = new Cdr();
    localCdr.m_Cdr = localCdr.CreateCdr(paramString);
    return localCdr;
  }

  private native long CreateCdr(String paramString);

  private native void Destroy(long paramLong);

  private native boolean SetS16(long paramLong1, String paramString, long paramLong2);

  private native boolean SetS32(long paramLong1, String paramString, long paramLong2);

  private native boolean SetS64(long paramLong1, String paramString, long paramLong2);

  private native boolean SetS8(long paramLong1, String paramString, long paramLong2);

  private native boolean SetString(long paramLong, String paramString1, String paramString2);

  private native void SetTag(long paramLong, String paramString);

  private native boolean SetU16(long paramLong1, String paramString, long paramLong2);

  private native boolean SetU32(long paramLong1, String paramString, long paramLong2);

  private native boolean SetU64(long paramLong1, String paramString, long paramLong2);

  private native boolean SetU8(long paramLong1, String paramString, long paramLong2);

  private native boolean isValid(long paramLong);

  private native String toXml(long paramLong);

  public void Destroy()
  {
    Destroy(this.m_Cdr);
    this.m_Cdr = 0L;
  }

  public boolean SetS16(String paramString, long paramLong)
  {
    return SetS16(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetS32(String paramString, long paramLong)
  {
    return SetS32(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetS64(String paramString, long paramLong)
  {
    return SetS64(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetS8(String paramString, long paramLong)
  {
    return SetS8(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetString(String paramString1, String paramString2)
  {
    return SetString(this.m_Cdr, paramString1, paramString2);
  }

  public void SetTag(String paramString)
  {
    SetTag(this.m_Cdr, paramString);
  }

  public boolean SetU16(String paramString, long paramLong)
  {
    return SetU16(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetU32(String paramString, long paramLong)
  {
    return SetU32(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetU64(String paramString, long paramLong)
  {
    return SetU64(this.m_Cdr, paramString, paramLong);
  }

  public boolean SetU8(String paramString, long paramLong)
  {
    return SetU8(this.m_Cdr, paramString, paramLong);
  }

  protected void finalize()
  {
    if (this.m_Cdr != 0L)
      Destroy(this.m_Cdr);
  }

  public boolean isValid()
  {
    return isValid(this.m_Cdr);
  }

  public native String stringFromJNI();

  public String toXml()
  {
    return toXml(this.m_Cdr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.cdr.Cdr
 * JD-Core Version:    0.6.2
 */