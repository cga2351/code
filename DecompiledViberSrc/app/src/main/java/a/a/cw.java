package a.a;

import com.appboy.f.c;

public class cw
  implements da
{
  private static final String a = c.a(cw.class);
  private final da b;
  private final d c;

  public cw(da paramda, d paramd)
  {
    this.b = paramda;
    this.c = paramd;
  }

  public bh a()
  {
    try
    {
      bh localbh = this.b.a();
      return localbh;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to get the active session from the storage.", localException);
      a(this.c, localException);
    }
    return null;
  }

  public void a(bh parambh)
  {
    try
    {
      this.b.a(parambh);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to upsert active session in the storage.", localException);
      a(this.c, localException);
    }
  }

  void a(d paramd, Throwable paramThrowable)
  {
    try
    {
      paramd.a(new x("A storage exception has occurred. Please view the stack trace for more details.", paramThrowable), x.class);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to log throwable.", localException);
    }
  }

  public void b(bh parambh)
  {
    try
    {
      this.b.b(parambh);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to delete the sealed session from the storage.", localException);
      a(this.c, localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cw
 * JD-Core Version:    0.6.2
 */