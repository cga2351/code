package com.viber.voip.ui.dialogs.a;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.viber.common.b.b;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.voip.messages.ui.MessageComposerView.f;
import com.viber.voip.settings.d.n;
import com.viber.voip.ui.dialogs.DialogCode;

public class a
{
  public static class a extends m.a
  {
    private final int a;
    private final MessageComposerView.f b;

    public a(int paramInt, MessageComposerView.f paramf)
    {
      this.a = paramInt;
      this.b = paramf;
    }

    public void onDialogAction(m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D399b));
      switch (paramInt)
      {
      case -2:
      default:
        return;
      case -1:
        d.n.h.a(false);
        this.b.a(true, this.a, false);
        return;
      case -3:
      }
      this.b.a(true, this.a, false);
    }
  }

  public static class b extends m.a
  {
    private final a a;

    public b(a parama)
    {
      this.a = parama;
    }

    public void onDialogAction(m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D305c));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        this.a.a();
        Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        paramm.getActivity().startActivity(localIntent);
        return;
      case -2:
      }
      this.a.b();
    }

    public static abstract interface a
    {
      public abstract void a();

      public abstract void b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.a.a
 * JD-Core Version:    0.6.2
 */