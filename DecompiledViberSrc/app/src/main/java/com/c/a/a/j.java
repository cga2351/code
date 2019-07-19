package com.c.a.a;

public enum j
{
  final String n;
  final char[] o;
  final byte[] p;

  static
  {
    j[] arrayOfj = new j[13];
    arrayOfj[0] = a;
    arrayOfj[1] = b;
    arrayOfj[2] = c;
    arrayOfj[3] = d;
    arrayOfj[4] = e;
    arrayOfj[5] = f;
    arrayOfj[6] = g;
    arrayOfj[7] = h;
    arrayOfj[8] = i;
    arrayOfj[9] = j;
    arrayOfj[10] = k;
    arrayOfj[11] = l;
    arrayOfj[12] = m;
  }

  private j(String paramString)
  {
    if (paramString == null)
    {
      this.n = null;
      this.o = null;
      this.p = null;
    }
    while (true)
    {
      return;
      this.n = paramString;
      this.o = paramString.toCharArray();
      int i2 = this.o.length;
      this.p = new byte[i2];
      for (int i3 = 0; i3 < i2; i3++)
        this.p[i3] = ((byte)this.o[i3]);
    }
  }

  public String a()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.j
 * JD-Core Version:    0.6.2
 */