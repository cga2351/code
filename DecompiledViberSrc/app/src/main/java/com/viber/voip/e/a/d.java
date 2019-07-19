package com.viber.voip.e.a;

import com.viber.voip.model.entity.MessageEntity;

public class d
{
  public static void a(String paramString1, MessageEntity paramMessageEntity, String paramString2)
  {
    c localc = e.b();
    String str = b.a(paramMessageEntity.getMimeType());
    if (paramMessageEntity.getBenchmarkTrackingSequence() > 0L);
    for (long l = paramMessageEntity.getBenchmarkTrackingSequence(); ; l = paramMessageEntity.getMessageSeq())
    {
      localc.a(paramString1, str, paramString2, l);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.e.a.d
 * JD-Core Version:    0.6.2
 */