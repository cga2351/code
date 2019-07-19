package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzl
{
  private final String mName;
  private final String mValue;

  public zzl(String paramString1, String paramString2)
  {
    this.mName = paramString1;
    this.mValue = paramString2;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzl localzzl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzl = (zzl)paramObject;
    }
    while ((TextUtils.equals(this.mName, localzzl.mName)) && (TextUtils.equals(this.mValue, localzzl.mValue)));
    return false;
  }

  public final String getName()
  {
    return this.mName;
  }

  public final String getValue()
  {
    return this.mValue;
  }

  public final int hashCode()
  {
    return 31 * this.mName.hashCode() + this.mValue.hashCode();
  }

  public final String toString()
  {
    String str1 = this.mName;
    String str2 = this.mValue;
    return 20 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Header[name=" + str1 + ",value=" + str2 + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzl
 * JD-Core Version:    0.6.2
 */