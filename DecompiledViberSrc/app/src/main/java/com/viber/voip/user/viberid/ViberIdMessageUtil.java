package com.viber.voip.user.viberid;

import android.content.Context;
import android.text.Html;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.c.a;
import com.viber.voip.model.entity.MessageEntity;

public class ViberIdMessageUtil
{
  public static MessageEntity createEmailConnectedSystemMessage(Context paramContext, String paramString)
  {
    String str = Html.fromHtml(paramContext.getString(R.string.viber_id_email_is_connected_message, new Object[] { paramString })).toString();
    MessageEntity localMessageEntity = new a("Viber", 0L, System.currentTimeMillis(), 3145729, 0, null, 1, 0).a(0, str, 0, null, 0);
    localMessageEntity.addExtraFlag(26);
    return localMessageEntity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdMessageUtil
 * JD-Core Version:    0.6.2
 */