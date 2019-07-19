package com.google.android.exoplayer2.trackselection;

public final class i
{
  public final int a;
  public final com.google.android.exoplayer2.ag[] b;
  public final g c;
  public final Object d;

  public i(com.google.android.exoplayer2.ag[] paramArrayOfag, e[] paramArrayOfe, Object paramObject)
  {
    this.b = paramArrayOfag;
    this.c = new g(paramArrayOfe);
    this.d = paramObject;
    this.a = paramArrayOfag.length;
  }

  public boolean a(int paramInt)
  {
    return this.b[paramInt] != null;
  }

  public boolean a(i parami)
  {
    if ((parami == null) || (parami.c.a != this.c.a))
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= this.c.a)
        break label51;
      if (!a(parami, i))
        break;
    }
    label51: return true;
  }

  public boolean a(i parami, int paramInt)
  {
    if (parami == null);
    while ((!com.google.android.exoplayer2.g.ag.a(this.b[paramInt], parami.b[paramInt])) || (!com.google.android.exoplayer2.g.ag.a(this.c.a(paramInt), parami.c.a(paramInt))))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.i
 * JD-Core Version:    0.6.2
 */