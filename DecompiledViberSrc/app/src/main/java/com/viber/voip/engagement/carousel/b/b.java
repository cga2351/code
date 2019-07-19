package com.viber.voip.engagement.carousel.b;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.k;

public class b
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a.a c;
  private final Handler d = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      b.a(b.this).a(paramAnonymousMessage.what);
      return true;
    }
  });

  public b(Context paramContext, a.a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }

  public void a(int paramInt)
  {
    Message localMessage = this.d.obtainMessage(paramInt);
    k.s().a(new a(null)).a(localMessage).a(this.b);
  }

  private static class a extends m.a
  {
    public void onDialogAction(m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D375)) && ((paramm.d() instanceof Message)))
      {
        Message localMessage = (Message)paramm.d();
        if (localMessage.getTarget() != null)
          localMessage.sendToTarget();
      }
      else
      {
        return;
      }
      b.a().a(new Throwable(), "onDialogAction can't send message back because Target is null");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.b.b
 * JD-Core Version:    0.6.2
 */