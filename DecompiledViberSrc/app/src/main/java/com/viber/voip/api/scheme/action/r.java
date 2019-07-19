package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteListener;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteStatus;
import com.viber.voip.messages.orm.entity.json.action.PreviewPublicAccountAction;
import com.viber.voip.publicaccount.entity.PublicAccount;

public class r extends f
{
  private final String f;
  private final String g;
  private final a h;

  public r(String paramString1, String paramString2, a parama)
  {
    this.f = paramString1;
    this.g = paramString2;
    this.h = parama;
  }

  public void a(Context paramContext, final c.a parama)
  {
    new PublicAccountInfoAction.1(this, this.f, this.g, parama).execute(paramContext, new Action.ExecuteListener()
    {
      public void onFinish(Action.ExecuteStatus paramAnonymousExecuteStatus)
      {
        if (paramAnonymousExecuteStatus != Action.ExecuteStatus.OK)
        {
          if (r.a(r.this) != null)
            r.a(r.this).a();
          parama.b();
        }
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(boolean paramBoolean, PublicAccount paramPublicAccount);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.r
 * JD-Core Version:    0.6.2
 */