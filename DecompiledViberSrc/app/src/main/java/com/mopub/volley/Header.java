package com.mopub.volley;

import android.text.TextUtils;

public final class Header
{
  private final String a;
  private final String b;

  public Header(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Header localHeader;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHeader = (Header)paramObject;
    }
    while ((TextUtils.equals(this.a, localHeader.a)) && (TextUtils.equals(this.b, localHeader.b)));
    return false;
  }

  public final String getName()
  {
    return this.a;
  }

  public final String getValue()
  {
    return this.b;
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }

  public String toString()
  {
    return "Header[name=" + this.a + ",value=" + this.b + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.Header
 * JD-Core Version:    0.6.2
 */