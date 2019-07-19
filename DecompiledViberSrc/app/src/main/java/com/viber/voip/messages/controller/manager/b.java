package com.viber.voip.messages.controller.manager;

import com.viber.common.a.e;
import com.viber.jni.im2.CSendActionToBotReplyMsg;
import com.viber.voip.ViberEnv;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private static final e a = ViberEnv.getLogger();
  private final c b;

  public b(c paramc)
  {
    this.b = paramc;
  }

  public void onCSendActionToBotReplyMsg(CSendActionToBotReplyMsg paramCSendActionToBotReplyMsg)
  {
    Iterator localIterator = a.b().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a locala1 = (a)this.b.a(locala);
      if (locala1 != null)
        locala1.onCSendActionToBotReplyMsg(paramCSendActionToBotReplyMsg);
    }
  }

  public static enum a
    implements am.b
  {
    private static final List<a> b = Collections.unmodifiableList(Arrays.asList(values()));

    static
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = a;
      c = arrayOfa;
    }

    public static List<a> b()
    {
      return b;
    }

    public String a()
    {
      return name();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.b
 * JD-Core Version:    0.6.2
 */