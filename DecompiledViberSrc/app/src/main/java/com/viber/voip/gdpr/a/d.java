package com.viber.voip.gdpr.a;

import com.viber.jni.im2.CGdprCommandReplyMsg;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.am.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class d
  implements c
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private final e b;

  public d(e parame)
  {
    this.b = parame;
  }

  public void onCGdprCommandReplyMsg(CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
  {
    a locala = a.a(paramCGdprCommandReplyMsg.commandType);
    if (locala == null);
    c localc;
    do
    {
      return;
      localc = (c)this.b.a(locala);
    }
    while (localc == null);
    localc.onCGdprCommandReplyMsg(paramCGdprCommandReplyMsg);
  }

  public static enum a
    implements am.b
  {
    private static final List<a> d = Collections.unmodifiableList(Arrays.asList(values()));
    public final int c;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      e = arrayOfa;
    }

    private a(int paramInt)
    {
      this.c = paramInt;
    }

    public static a a(int paramInt)
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.c == paramInt)
          return locala;
      }
      return null;
    }

    public static List<a> b()
    {
      return d;
    }

    public String a()
    {
      return name();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.d
 * JD-Core Version:    0.6.2
 */