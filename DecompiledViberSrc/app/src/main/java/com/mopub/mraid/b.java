package com.mopub.mraid;

 enum b
{
  private final int a;

  static
  {
    LANDSCAPE = new b("LANDSCAPE", 1, 0);
    NONE = new b("NONE", 2, -1);
    b[] arrayOfb = new b[3];
    arrayOfb[0] = PORTRAIT;
    arrayOfb[1] = LANDSCAPE;
    arrayOfb[2] = NONE;
  }

  private b(int paramInt)
  {
    this.a = paramInt;
  }

  int a()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.b
 * JD-Core Version:    0.6.2
 */