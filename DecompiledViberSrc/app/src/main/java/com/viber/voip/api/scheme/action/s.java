package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteListener;
import com.viber.voip.messages.orm.entity.json.action.Action.ExecuteStatus;
import com.viber.voip.messages.orm.entity.json.action.PreviewPublicGroupAction;
import com.viber.voip.publicaccount.entity.PublicAccount;

public class s extends f
{
  private String f;
  private a g;

  public s(String paramString, a parama)
  {
    this.f = paramString;
    this.g = parama;
  }

  public void a(Context paramContext, final c.a parama)
  {
    new PublicInfoAction.1(this, this.f, parama).execute(paramContext, new Action.ExecuteListener()
    {
      public void onFinish(Action.ExecuteStatus paramAnonymousExecuteStatus)
      {
        if (paramAnonymousExecuteStatus != Action.ExecuteStatus.OK)
        {
          if (s.a(s.this) != null)
            s.a(s.this).b();
          parama.b();
        }
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, PublicAccount paramPublicAccount);

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.s
 * JD-Core Version:    0.6.2
 */