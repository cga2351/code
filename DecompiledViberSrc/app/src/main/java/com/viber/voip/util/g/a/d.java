package com.viber.voip.util.g.a;

import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;

public class d extends a
{
  public d(int paramInt)
  {
    super(paramInt);
  }

  public void a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isForwardedMessage()) && (!da.a(paramMessageEntity.getSpans())))
      return;
    paramMessageEntity.setSpans(a(paramMessageEntity.getBody(), paramMessageEntity.getMessageInfo().getTextMetaInfo()));
  }

  protected int b()
  {
    return aj.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.d
 * JD-Core Version:    0.6.2
 */