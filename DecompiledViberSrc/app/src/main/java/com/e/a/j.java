package com.e.a;

import com.e.a.d.c;
import com.e.a.d.f;
import java.text.ParseException;

public class j extends e
{
  private final i a;
  private final String b;
  private c c;
  private a d;

  public j(c paramc1, c paramc2, c paramc3)
    throws ParseException
  {
    if (paramc1 == null)
      throw new IllegalArgumentException("The first part must not be null");
    try
    {
      this.a = i.a(paramc1);
      if (paramc2 == null)
        throw new IllegalArgumentException("The second part must not be null");
    }
    catch (ParseException localParseException)
    {
      throw new ParseException("Invalid JWS header: " + localParseException.getMessage(), 0);
    }
    a(new l(paramc2));
    this.b = a(paramc1, paramc2);
    if (paramc3 == null)
      throw new IllegalArgumentException("The third part must not be null");
    this.c = paramc3;
    this.d = a.b;
    a(new c[] { paramc1, paramc2, paramc3 });
  }

  private static String a(c paramc1, c paramc2)
  {
    return paramc1.toString() + '.' + paramc2.toString();
  }

  private void g()
  {
    if ((this.d != a.b) && (this.d != a.c))
      throw new IllegalStateException("The JWS object must be in a signed or verified state");
  }

  // ERROR //
  public boolean a(k paramk)
    throws d
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 107	com/e/a/j:g	()V
    //   6: aload_1
    //   7: aload_0
    //   8: invokevirtual 110	com/e/a/j:c	()Lcom/e/a/i;
    //   11: aload_0
    //   12: invokevirtual 113	com/e/a/j:d	()[B
    //   15: aload_0
    //   16: invokevirtual 117	com/e/a/j:e	()Lcom/e/a/d/c;
    //   19: invokeinterface 122 4 0
    //   24: istore 5
    //   26: iload 5
    //   28: ifeq +10 -> 38
    //   31: aload_0
    //   32: getstatic 95	com/e/a/j$a:c	Lcom/e/a/j$a;
    //   35: putfield 77	com/e/a/j:d	Lcom/e/a/j$a;
    //   38: aload_0
    //   39: monitorexit
    //   40: iload 5
    //   42: ireturn
    //   43: astore 4
    //   45: aload 4
    //   47: athrow
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: astore_3
    //   54: new 103	com/e/a/d
    //   57: dup
    //   58: aload_3
    //   59: invokevirtual 123	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   62: aload_3
    //   63: invokespecial 126	com/e/a/d:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	26	43	com/e/a/d
    //   2	6	48	finally
    //   6	26	48	finally
    //   31	38	48	finally
    //   45	48	48	finally
    //   54	67	48	finally
    //   6	26	53	java/lang/Exception
  }

  public i c()
  {
    return this.a;
  }

  public byte[] d()
  {
    return this.b.getBytes(f.a);
  }

  public c e()
  {
    return this.c;
  }

  public String f()
  {
    g();
    return this.b + '.' + this.c.toString();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.j
 * JD-Core Version:    0.6.2
 */