package com.viber.voip.messages.conversation.chatinfo.presentation.a;

import com.viber.voip.R.layout;

public enum d
{
  private final int s;

  static
  {
    d[] arrayOfd = new d[18];
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
  }

  private d(int paramInt)
  {
    this.s = paramInt;
  }

  public static d a(int paramInt)
  {
    for (d locald : values())
      if (locald.ordinal() == paramInt)
        return locald;
    return a;
  }

  public int a()
  {
    return this.s;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.a.d
 * JD-Core Version:    0.6.2
 */