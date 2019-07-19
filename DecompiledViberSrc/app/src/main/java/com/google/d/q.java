package com.google.d;

import com.google.d.d.a;
import com.google.d.d.b;
import com.google.d.d.d;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class q
{
  // ERROR //
  public l a(a parama)
    throws m, u
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 24	com/google/d/d/a:q	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 27	com/google/d/d/a:a	(Z)V
    //   10: aload_1
    //   11: invokestatic 31	com/google/d/b/j:a	(Lcom/google/d/d/a;)Lcom/google/d/l;
    //   14: astore 6
    //   16: aload_1
    //   17: iload_2
    //   18: invokevirtual 27	com/google/d/d/a:a	(Z)V
    //   21: aload 6
    //   23: areturn
    //   24: astore 5
    //   26: new 33	com/google/d/p
    //   29: dup
    //   30: new 35	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   37: ldc 38
    //   39: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc 47
    //   48: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aload 5
    //   56: invokespecial 54	com/google/d/p:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: astore 4
    //   62: aload_1
    //   63: iload_2
    //   64: invokevirtual 27	com/google/d/d/a:a	(Z)V
    //   67: aload 4
    //   69: athrow
    //   70: astore_3
    //   71: new 33	com/google/d/p
    //   74: dup
    //   75: new 35	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   82: ldc 38
    //   84: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: ldc 47
    //   93: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aload_3
    //   100: invokespecial 54	com/google/d/p:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	16	24	java/lang/StackOverflowError
    //   10	16	60	finally
    //   26	60	60	finally
    //   71	104	60	finally
    //   10	16	70	java/lang/OutOfMemoryError
  }

  public l a(Reader paramReader)
    throws m, u
  {
    l locall;
    try
    {
      a locala = new a(paramReader);
      locall = a(locala);
      if ((!locall.j()) && (locala.f() != b.j))
        throw new u("Did not consume the entire document.");
    }
    catch (d locald)
    {
      throw new u(locald);
    }
    catch (IOException localIOException)
    {
      throw new m(localIOException);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new u(localNumberFormatException);
    }
    return locall;
  }

  public l a(String paramString)
    throws u
  {
    return a(new StringReader(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.q
 * JD-Core Version:    0.6.2
 */