package pl.droidsonroids.gif;

public class f
{
  char a;
  boolean b;

  public f()
  {
    a();
  }

  private void a()
  {
    this.a = '\001';
    this.b = false;
  }

  public void a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 65535))
    {
      this.a = '\001';
      return;
    }
    this.a = ((char)paramInt);
  }

  void a(f paramf)
  {
    if (paramf == null)
    {
      a();
      return;
    }
    this.b = paramf.b;
    this.a = paramf.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.f
 * JD-Core Version:    0.6.2
 */