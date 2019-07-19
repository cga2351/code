package com.viber.voip.messages.extensions.model;

import com.google.d.a.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import java.util.Set;

public class c
{
  public static final b[] a = new b[0];
  private static final Logger b = ViberEnv.getLogger();

  @com.google.d.a.c(a="extensions")
  private b[] c;

  public b[] a()
  {
    if (this.c == null)
      return a;
    return this.c;
  }

  @b(a="Lcom/viber/voip/messages/extensions/model/a/a;")
  public static enum a
  {
    private final int d;
    private final String e;

    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }

    private a(int paramInt, String paramString)
    {
      this.d = paramInt;
      this.e = paramString;
    }

    public static a a(String paramString)
    {
      for (a locala : values())
        if (locala.e.equals(paramString))
          return locala;
      return null;
    }

    public int a()
    {
      return this.d;
    }

    public String b()
    {
      return this.e;
    }
  }

  public static final class b
  {

    @com.google.d.a.c(a="pubAccId")
    private String a;

    @com.google.d.a.c(a="name")
    private String b;

    @com.google.d.a.c(a="uri")
    private String c;

    @com.google.d.a.c(a="chatExtensionHintText")
    private String d;

    @com.google.d.a.c(a="chatExtensionIconUrl2")
    private String e;

    @com.google.d.a.c(a="chatExtensionIconUrl")
    private String f;

    @b(a="Lcom/viber/voip/messages/extensions/model/a/b;")
    @com.google.d.a.c(a="chatExtensionRichMediaText")
    private String g;

    @com.google.d.a.c(a="fl")
    private int h;

    @com.google.d.a.c(a="chatExtensionFlags")
    private Set<c.a> i;

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.c;
    }

    public String c()
    {
      return this.b;
    }

    public String d()
    {
      return this.d;
    }

    public String e()
    {
      if (!da.a(this.e))
        return this.e;
      return null;
    }

    public String f()
    {
      if (!da.a(this.f))
        return this.f;
      return null;
    }

    public String g()
    {
      return this.g;
    }

    public int h()
    {
      return this.h;
    }

    public Set<c.a> i()
    {
      return this.i;
    }

    public String toString()
    {
      return "KeyboardExtensionItem{mName='" + this.b + '\'' + ", mUri='" + this.c + '\'' + ", mPublicAccountId='" + this.a + '\'' + ", mHint='" + this.d + '\'' + ", mIcon='" + this.e + '\'' + ", mIconOld='" + this.f + '\'' + ", mHeaderText='" + this.g + '\'' + ", mFlags=" + this.h + ", mChatExtensionFlags=" + this.i + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.c
 * JD-Core Version:    0.6.2
 */