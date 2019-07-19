package com.viber.voip.messages;

public enum d
{
  public final String k;
  public final String l;
  public final String m;

  static
  {
    d[] arrayOfd = new d[10];
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
  }

  private d(String paramString)
  {
    this(paramString, "error.svg");
  }

  private d(String paramString1, String paramString2)
  {
    this.k = ("file_types/upload/" + paramString1);
    this.l = ("file_types/download/" + paramString1);
    this.m = ("file_types/" + paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.d
 * JD-Core Version:    0.6.2
 */