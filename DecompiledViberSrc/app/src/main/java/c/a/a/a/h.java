package c.a.a.a;

import c.a.a.a.a.b.x;
import c.a.a.a.a.c.e;

class h<Result> extends c.a.a.a.a.c.f<Void, Void, Result>
{
  final i<Result> a;

  public h(i<Result> parami)
  {
    this.a = parami;
  }

  private x a(String paramString)
  {
    x localx = new x(this.a.b() + "." + paramString, "KitInitialization");
    localx.a();
    return localx;
  }

  protected Result a(Void[] paramArrayOfVoid)
  {
    x localx = a("doInBackground");
    boolean bool = e();
    Object localObject = null;
    if (!bool)
      localObject = this.a.f();
    localx.b();
    return localObject;
  }

  // ERROR //
  protected void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 68	c/a/a/a/a/c/f:a	()V
    //   4: aload_0
    //   5: ldc 70
    //   7: invokespecial 53	c/a/a/a/h:a	(Ljava/lang/String;)Lc/a/a/a/a/b/x;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 15	c/a/a/a/h:a	Lc/a/a/a/i;
    //   15: invokevirtual 73	c/a/a/a/i:f_	()Z
    //   18: istore 7
    //   20: aload_1
    //   21: invokevirtual 63	c/a/a/a/a/b/x:b	()V
    //   24: iload 7
    //   26: ifne +9 -> 35
    //   29: aload_0
    //   30: iconst_1
    //   31: invokevirtual 76	c/a/a/a/h:a	(Z)Z
    //   34: pop
    //   35: return
    //   36: astore 6
    //   38: aload 6
    //   40: athrow
    //   41: astore 4
    //   43: aload_1
    //   44: invokevirtual 63	c/a/a/a/a/b/x:b	()V
    //   47: aload_0
    //   48: iconst_1
    //   49: invokevirtual 76	c/a/a/a/h:a	(Z)Z
    //   52: pop
    //   53: aload 4
    //   55: athrow
    //   56: astore_2
    //   57: invokestatic 82	c/a/a/a/c:g	()Lc/a/a/a/l;
    //   60: ldc 84
    //   62: ldc 86
    //   64: aload_2
    //   65: invokeinterface 91 4 0
    //   70: aload_1
    //   71: invokevirtual 63	c/a/a/a/a/b/x:b	()V
    //   74: aload_0
    //   75: iconst_1
    //   76: invokevirtual 76	c/a/a/a/h:a	(Z)Z
    //   79: pop
    //   80: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	20	36	c/a/a/a/a/c/m
    //   11	20	41	finally
    //   38	41	41	finally
    //   57	70	41	finally
    //   11	20	56	java/lang/Exception
  }

  protected void a(Result paramResult)
  {
    this.a.a(paramResult);
    this.a.h.a(paramResult);
  }

  public e b()
  {
    return e.c;
  }

  protected void b(Result paramResult)
  {
    this.a.b(paramResult);
    g localg = new g(this.a.b() + " Initialization was cancelled");
    this.a.h.a(localg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.h
 * JD-Core Version:    0.6.2
 */