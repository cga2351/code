package com.viber.voip.messages.conversation.community.b;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.s;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final ai c;
  private final LongSparseSet d = new LongSparseSet();

  public a(Context paramContext, ai paramai)
  {
    this.b = paramContext;
    this.c = paramai;
  }

  public void a(aa paramaa)
  {
    int i;
    if (paramaa.az())
    {
      if ((paramaa.f() == -2) || (!da.a(paramaa.o())) || (da.a(paramaa.B())))
        break label105;
      i = 1;
      if ((i == 0) || (s.a(dx.a(paramaa))) || (!bk.a(this.b)) || (this.d.contains(paramaa.a())))
        break label110;
      this.d.add(paramaa.a());
      this.c.a(paramaa.a(), paramaa.B());
    }
    label105: label110: 
    while (i != 0)
    {
      return;
      i = 0;
      break;
    }
    this.d.remove(paramaa.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.b.a
 * JD-Core Version:    0.6.2
 */