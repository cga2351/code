package com.viber.voip.analytics.a;

import com.viber.voip.model.entity.MessageEntity;

public class f
{
  public static enum a
  {
    private final String l;

    static
    {
      a[] arrayOfa = new a[11];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
    }

    private a(String paramString)
    {
      this.l = paramString;
    }

    public static a a(MessageEntity paramMessageEntity)
    {
      int n = paramMessageEntity.getMimeType();
      if (n == 0)
        return a;
      if (1 == n)
      {
        if (paramMessageEntity.getMediaFlag() != 0)
          return f;
        return b;
      }
      if (4 == n)
        return j;
      if (3 == n)
        return c;
      if ((2 == n) || (1009 == n))
        return d;
      if (5 == n)
        return e;
      if (8 == n)
        return g;
      if (9 == n)
        return h;
      if (7 == n)
        return i;
      return k;
    }

    public String toString()
    {
      return this.l;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.f
 * JD-Core Version:    0.6.2
 */