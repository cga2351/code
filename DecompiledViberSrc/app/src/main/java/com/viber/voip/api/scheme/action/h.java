package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.common.dialogs.a.a;
import com.viber.voip.api.scheme.i;
import com.viber.voip.api.scheme.i.b;
import com.viber.voip.model.entity.g;

public class h extends f
{
  private final String f;
  private final a g;

  public h(String paramString, a parama)
  {
    this.f = paramString;
    this.g = parama;
  }

  public void a(Context paramContext, final c.a parama)
  {
    if (this.f.startsWith("+"));
    for (String str = this.f; ; str = "+" + this.f)
    {
      i.a(str, new i.b()
      {
        public void a()
        {
          com.viber.voip.ui.dialogs.f.d().b(false).d();
          parama.b();
        }

        public void a(int paramAnonymousInt, String paramAnonymousString, g paramAnonymousg)
        {
          h.a(h.this).a(paramAnonymousInt, paramAnonymousString, paramAnonymousg);
          parama.b();
        }
      });
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, g paramg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.h
 * JD-Core Version:    0.6.2
 */