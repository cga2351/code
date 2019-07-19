package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.messages.orm.entity.json.action.PreviewPublicAccountAction;
import com.viber.voip.publicaccount.entity.PublicAccount;

class PublicAccountInfoAction$1 extends PreviewPublicAccountAction
{
  PublicAccountInfoAction$1(r paramr, String paramString1, String paramString2, c.a parama)
  {
    super(paramString1, paramString2);
  }

  protected void onPublicAccountInfoReady(Context paramContext, boolean paramBoolean, PublicAccount paramPublicAccount)
  {
    if (r.a(this.this$0) != null)
      r.a(this.this$0).a(paramBoolean, paramPublicAccount);
    this.val$listener.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.PublicAccountInfoAction.1
 * JD-Core Version:    0.6.2
 */