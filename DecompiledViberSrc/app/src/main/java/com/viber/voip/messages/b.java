package com.viber.voip.messages;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.c.a;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.av;

public class b
{
  public static void a(bs parambs, Context paramContext)
  {
    MessageEntity localMessageEntity = new a("External:12829", 0L, System.currentTimeMillis(), 2098177, 0, null, 12829, 0).a(0, paramContext.getString(R.string.business_inbox_promotion_message), 0, null, 0);
    localMessageEntity.setExtraFlags(av.a(localMessageEntity.getExtraFlags(), 35));
    parambs.a(localMessageEntity, 12829);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.b
 * JD-Core Version:    0.6.2
 */