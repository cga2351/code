package com.yandex.metrica.impl.ob;

public class is
  implements it
{
  private final it a;
  private final it b;

  is(it paramit1, it paramit2)
  {
    this.a = paramit1;
    this.b = paramit2;
  }

  public static a b()
  {
    return new a(new iu(false), new jc(null));
  }

  public a a()
  {
    return new a(this.a, this.b);
  }

  public boolean a(String paramString)
  {
    return (this.b.a(paramString)) && (this.a.a(paramString));
  }

  public String toString()
  {
    return "AskForPermissionsStrategy{mLocationFlagStrategy=" + this.a + ", mStartupStateStrategy=" + this.b + '}';
  }

  public static class a
  {
    private it a;
    private it b;

    private a()
    {
    }

    public a(it paramit1, it paramit2)
    {
      this.a = paramit1;
      this.b = paramit2;
    }

    public a a(mw parammw)
    {
      this.b = new jc(parammw.y);
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.a = new iu(paramBoolean);
      return this;
    }

    public is a()
    {
      return new is(this.a, this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.is
 * JD-Core Version:    0.6.2
 */