package com.c.a.a.a;

import com.c.a.a.f;
import com.c.a.a.g;
import com.c.a.a.g.a;
import com.c.a.a.h;
import com.c.a.a.j;
import java.io.IOException;

public abstract class c extends g
{
  protected j K;

  protected static final String c(int paramInt)
  {
    char c = (char)paramInt;
    if (Character.isISOControl(c))
      return "(CTRL-CHAR, code " + paramInt + ")";
    if (paramInt > 255)
      return "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
    return "'" + c + "' (code " + paramInt + ")";
  }

  protected void C()
    throws f
  {
    c(" in " + this.K);
  }

  protected void D()
    throws f
  {
    c(" in a value");
  }

  protected final void E()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }

  protected char a(char paramChar)
    throws h
  {
    if (a(g.a.f));
    while ((paramChar == '\'') && (a(g.a.d)))
      return paramChar;
    d("Unrecognized character escape " + c(paramChar));
    return paramChar;
  }

  public abstract j a()
    throws IOException, f;

  protected final void a(String paramString, Throwable paramThrowable)
    throws f
  {
    throw b(paramString, paramThrowable);
  }

  protected final f b(String paramString, Throwable paramThrowable)
  {
    return new f(paramString, e(), paramThrowable);
  }

  public g b()
    throws IOException, f
  {
    if ((this.K != j.b) && (this.K != j.d))
      return this;
    int i = 1;
    do
    {
      while (true)
      {
        j localj = a();
        if (localj == null)
        {
          t();
          return this;
        }
        switch (1.a[localj.ordinal()])
        {
        default:
          break;
        case 1:
        case 2:
          i++;
        case 3:
        case 4:
        }
      }
      i--;
    }
    while (i != 0);
    return this;
  }

  protected void b(int paramInt)
    throws f
  {
    int i = (char)paramInt;
    d("Illegal character (" + c(i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }

  protected void b(int paramInt, String paramString)
    throws f
  {
    String str = "Unexpected character (" + c(paramInt) + ")";
    if (paramString != null)
      str = str + ": " + paramString;
    d(str);
  }

  public j c()
  {
    return this.K;
  }

  protected void c(int paramInt, String paramString)
    throws f
  {
    if ((!a(g.a.e)) || (paramInt >= 32))
    {
      int i = (char)paramInt;
      d("Illegal unquoted character (" + c(i) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }

  protected void c(String paramString)
    throws f
  {
    d("Unexpected end-of-input" + paramString);
  }

  protected final void d(String paramString)
    throws f
  {
    throw a(paramString);
  }

  public abstract String f()
    throws IOException, f;

  protected abstract void t()
    throws f;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.a.c
 * JD-Core Version:    0.6.2
 */