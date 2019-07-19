package com.crashlytics.android.a;

public class m extends d<m>
{
  private final String a;

  public m(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("eventName must not be null");
    this.a = this.b.a(paramString);
  }

  String a()
  {
    return this.a;
  }

  public String toString()
  {
    return "{eventName:\"" + this.a + '"' + ", customAttributes:" + this.c + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.m
 * JD-Core Version:    0.6.2
 */