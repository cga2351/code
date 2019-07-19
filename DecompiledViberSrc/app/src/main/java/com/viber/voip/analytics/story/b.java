package com.viber.voip.analytics.story;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.t;
import com.viber.voip.analytics.t.a;
import java.io.Serializable;

public class b
{
  public static a a(String[] paramArrayOfString)
  {
    return new a(paramArrayOfString).a(t.a);
  }

  public static a b(String[] paramArrayOfString)
  {
    return new a(paramArrayOfString).a(t.a.a);
  }

  public static class a
    implements Serializable
  {
    private final ArrayMap<String, String> a = new ArrayMap();
    private final ArrayMap<String, f.a.a> b = new ArrayMap();

    public a()
    {
    }

    public a(String[] paramArrayOfString)
    {
      a(paramArrayOfString);
    }

    public a a(String paramString, f.a.a parama)
    {
      this.b.put(paramString, parama);
      return this;
    }

    public <T2> a a(String paramString, final T2 paramT2)
    {
      this.b.put(paramString, new f.a.a()
      {
        public T2 a(Object paramAnonymousObject)
        {
          return paramT2;
        }
      });
      return this;
    }

    public a a(String paramString1, String paramString2)
    {
      this.a.put(paramString1, paramString2);
      return this;
    }

    public a a(String[] paramArrayOfString)
    {
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      {
        int i = paramArrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          String str = paramArrayOfString[j];
          this.a.put(str, str);
        }
      }
      return this;
    }

    public f.a a()
    {
      return new f.a()
      {
        public ArrayMap<String, String> a()
        {
          return b.a.a(b.a.this);
        }

        public ArrayMap<String, f.a.a> b()
        {
          return b.a.b(b.a.this);
        }
      };
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b
 * JD-Core Version:    0.6.2
 */