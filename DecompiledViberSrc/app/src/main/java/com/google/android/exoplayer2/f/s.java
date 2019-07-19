package com.google.android.exoplayer2.f;

public final class s extends v.a
{
  private final String a;
  private final ad b;
  private final int c;
  private final int d;
  private final boolean e;

  public s(String paramString, ad paramad)
  {
    this(paramString, paramad, 8000, 8000, false);
  }

  public s(String paramString, ad paramad, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramad;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
  }

  protected r a(v.f paramf)
  {
    r localr = new r(this.a, null, this.c, this.d, this.e, paramf);
    if (this.b != null)
      localr.a(this.b);
    return localr;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.s
 * JD-Core Version:    0.6.2
 */