package e.a.b;

import java.io.IOException;

public class g
{
  public static final g a = new g(0);
  public static final g b = new g(-1);
  public static final g c = new g(2);
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private j.f h;
  private j.f i;
  private j.g j;

  public g()
  {
    this(0);
  }

  public g(int paramInt)
  {
    boolean bool2;
    boolean bool3;
    label28: boolean bool4;
    label43: label56: Object localObject;
    if ((paramInt & 0x1) == 0)
    {
      bool2 = bool1;
      this.d = bool2;
      if ((paramInt & 0x4) != 0)
        break label121;
      bool3 = bool1;
      this.f = bool3;
      if ((paramInt & 0x2) != 0)
        break label127;
      bool4 = bool1;
      this.e = bool4;
      if ((paramInt & 0x10) <= 0)
        break label133;
      this.g = bool1;
      if ((paramInt & 0x8) <= 0)
        break label138;
      localObject = j.c;
      label73: if (!this.f)
        break label146;
      this.i = j.b;
      label87: if (!this.d)
        break label155;
    }
    label133: label138: label146: label155: for (this.h = j.b; ; this.h = ((j.f)localObject))
    {
      if (!this.e)
        break label164;
      this.j = j.e;
      return;
      bool2 = false;
      break;
      label121: bool3 = false;
      break label28;
      label127: bool4 = false;
      break label43;
      bool1 = false;
      break label56;
      localObject = j.a;
      break label73;
      this.i = ((j.f)localObject);
      break label87;
    }
    label164: this.j = j.d;
  }

  public void a(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append('{');
  }

  public void a(Appendable paramAppendable, String paramString)
    throws IOException
  {
    if (!b(paramString))
    {
      paramAppendable.append(paramString);
      return;
    }
    paramAppendable.append('"');
    i.a(paramString, paramAppendable, this);
    paramAppendable.append('"');
  }

  public void a(String paramString, Appendable paramAppendable)
  {
    this.j.a(paramString, paramAppendable);
  }

  public boolean a()
  {
    return this.g;
  }

  public boolean a(String paramString)
  {
    return this.h.a(paramString);
  }

  public void b(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append('}');
  }

  public boolean b(String paramString)
  {
    return this.i.a(paramString);
  }

  public void c(Appendable paramAppendable)
    throws IOException
  {
  }

  public void d(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append(',');
  }

  public void e(Appendable paramAppendable)
    throws IOException
  {
  }

  public void f(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append(':');
  }

  public void g(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append('[');
  }

  public void h(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append(']');
  }

  public void i(Appendable paramAppendable)
    throws IOException
  {
  }

  public void j(Appendable paramAppendable)
    throws IOException
  {
    paramAppendable.append(',');
  }

  public void k(Appendable paramAppendable)
    throws IOException
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.g
 * JD-Core Version:    0.6.2
 */