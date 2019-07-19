package com.viber.voip.ui.dialogs.a;

import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.voip.util.ViberActionRunner.f;

public class b
{
  public static class a extends m.a
  {
    private final String a;

    public a(String paramString)
    {
      this.a = paramString;
    }

    public void onDialogAction(m paramm, int paramInt)
    {
      if (-1 == paramInt)
        ViberActionRunner.f.b(paramm.getContext(), this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.a.b
 * JD-Core Version:    0.6.2
 */