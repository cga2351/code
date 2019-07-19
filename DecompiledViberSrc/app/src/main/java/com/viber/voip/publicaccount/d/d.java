package com.viber.voip.publicaccount.d;

public enum d
{
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J;

  static
  {
    A = new d("RECENT_MEDIA", 26, false, true, true, true, false, false);
    B = new d("VIEW_PUBLIC_CHAT", 27, true, true, true, true, false, false);
    C = new d("LEAVE_PUBLIC_CHAT", 28, false, false, true, true, false, true);
    D = new d("URI", 29, false, false, true, true, false, true);
    d[] arrayOfd = new d[30];
    arrayOfd[0] = a;
    arrayOfd[1] = b;
    arrayOfd[2] = c;
    arrayOfd[3] = d;
    arrayOfd[4] = e;
    arrayOfd[5] = f;
    arrayOfd[6] = g;
    arrayOfd[7] = h;
    arrayOfd[8] = i;
    arrayOfd[9] = j;
    arrayOfd[10] = k;
    arrayOfd[11] = l;
    arrayOfd[12] = m;
    arrayOfd[13] = n;
    arrayOfd[14] = o;
    arrayOfd[15] = p;
    arrayOfd[16] = q;
    arrayOfd[17] = r;
    arrayOfd[18] = s;
    arrayOfd[19] = t;
    arrayOfd[20] = u;
    arrayOfd[21] = v;
    arrayOfd[22] = w;
    arrayOfd[23] = x;
    arrayOfd[24] = y;
    arrayOfd[25] = z;
    arrayOfd[26] = A;
    arrayOfd[27] = B;
    arrayOfd[28] = C;
    arrayOfd[29] = D;
  }

  private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this.E = paramBoolean4;
    this.F = paramBoolean3;
    this.G = paramBoolean2;
    this.H = paramBoolean1;
    this.I = paramBoolean6;
    this.J = paramBoolean5;
  }

  private boolean a(int paramInt)
  {
    if (paramInt == -1)
      return this.I;
    return this.E;
  }

  private boolean b(int paramInt)
  {
    if (paramInt == -1)
      return this.J;
    return this.G;
  }

  private boolean c(int paramInt)
  {
    if (paramInt == -1)
      return this.J;
    return this.F;
  }

  private boolean d(int paramInt)
  {
    if (paramInt == -1)
      return this.J;
    return this.H;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
    case 2:
    case 1:
    case 4:
    case 3:
    }
    do
    {
      return b(paramInt2);
      return a(paramInt2);
      return c(paramInt2);
    }
    while (3 != paramInt2);
    return d(paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.d
 * JD-Core Version:    0.6.2
 */