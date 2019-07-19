package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.voip.messages.orm.entity.json.action.PreviewPublicGroupAction;
import com.viber.voip.publicaccount.entity.PublicAccount;

class PublicInfoAction$1 extends PreviewPublicGroupAction
{
  PublicInfoAction$1(s params, String paramString, c.a parama)
  {
    super(paramString);
  }

  protected void onPublicGroupInfoReady(Context paramContext, boolean paramBoolean, PublicAccount paramPublicAccount)
  {
    if (s.a(this.this$0) != null)
      s.a(this.this$0).a(paramBoolean, paramPublicAccount);
    this.val$listener.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.PublicInfoAction.1
 * JD-Core Version:    0.6.2
 */