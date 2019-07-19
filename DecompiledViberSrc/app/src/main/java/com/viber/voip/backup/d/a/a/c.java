package com.viber.voip.backup.d.a.a;

import com.viber.voip.s.a;

public class c extends b
{
  private c(String paramString)
  {
    super(paramString);
  }

  public static class a
  {
    private StringBuilder a = new StringBuilder();

    private void a(Object paramObject)
    {
      if ((paramObject instanceof String))
      {
        this.a.append('\'').append(String.valueOf(paramObject)).append('\'');
        return;
      }
      this.a.append(String.valueOf(paramObject));
    }

    private void b(String paramString)
    {
      this.a.append(paramString);
    }

    public a a()
    {
      this.a.append(')');
      return this;
    }

    public a a(String paramString)
    {
      b(paramString);
      this.a.append('(');
      return this;
    }

    public a a(String paramString1, String paramString2, Object paramObject)
    {
      b(paramString1);
      this.a.append(paramString2).append("=");
      a(paramObject);
      return this;
    }

    public a a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
    {
      b(paramString1);
      StringBuilder localStringBuilder = this.a.append(paramString2);
      if (paramBoolean);
      for (String str = "<="; ; str = "<")
      {
        localStringBuilder.append(str);
        a(paramObject);
        return this;
      }
    }

    public a a(String paramString1, String paramString2, String[] paramArrayOfString)
    {
      b(paramString1);
      this.a.append(paramString2).append(" IN(");
      a.a(this.a, paramArrayOfString);
      this.a.append(')');
      return this;
    }

    public a b(String paramString1, String paramString2, Object paramObject)
    {
      b(paramString1);
      this.a.append(paramString2).append("<>");
      a(paramObject);
      return this;
    }

    public c b()
    {
      return new c(this.a.toString(), null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a.a.c
 * JD-Core Version:    0.6.2
 */