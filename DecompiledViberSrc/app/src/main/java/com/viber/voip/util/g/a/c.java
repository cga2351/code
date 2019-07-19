package com.viber.voip.util.g.a;

import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;

public class c extends a
{
  public c(int paramInt)
  {
    super(paramInt);
  }

  public void a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isForwardedMessage()) && (!da.a(paramMessageEntity.getSpans())))
      return;
    paramMessageEntity.setSpans(a(paramMessageEntity.getDescription(), paramMessageEntity.getMessageInfo().getTextMetaInfo()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.c
 * JD-Core Version:    0.6.2
 */