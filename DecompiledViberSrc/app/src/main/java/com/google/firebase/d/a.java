package com.google.firebase.d;

import javax.annotation.Nonnull;

final class a extends e
{
  private final String a;
  private final String b;

  a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new NullPointerException("Null libraryName");
    this.a = paramString1;
    if (paramString2 == null)
      throw new NullPointerException("Null version");
    this.b = paramString2;
  }

  @Nonnull
  public String a()
  {
    return this.a;
  }

  @Nonnull
  public String b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    e locale;
    do
    {
      return true;
      if (!(paramObject instanceof e))
        break;
      locale = (e)paramObject;
    }
    while ((this.a.equals(locale.a())) && (this.b.equals(locale.b())));
    return false;
    return false;
  }

  public int hashCode()
  {
    return 1000003 * (0xF4243 ^ this.a.hashCode()) ^ this.b.hashCode();
  }

  public String toString()
  {
    return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.d.a
 * JD-Core Version:    0.6.2
 */