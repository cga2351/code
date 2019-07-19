package com.viber.voip.util.g.a;

import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;

public class h extends a
{
  public h(int paramInt)
  {
    super(paramInt);
  }

  private String b(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isPinMessage())
      return paramMessageEntity.getMessageInfo().getPin().getText();
    return paramMessageEntity.getBody();
  }

  private TextMetaInfo[] c(MessageEntity paramMessageEntity)
  {
    if (paramMessageEntity.isPinMessage())
      return paramMessageEntity.getMessageInfo().getPin().getTextMetaInfo();
    return paramMessageEntity.getMessageInfo().getTextMetaInfo();
  }

  public void a(MessageEntity paramMessageEntity)
  {
    if ((paramMessageEntity.isForwardedMessage()) && (!da.a(paramMessageEntity.getSpans())))
      return;
    paramMessageEntity.setSpans(a(b(paramMessageEntity), c(paramMessageEntity)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.h
 * JD-Core Version:    0.6.2
 */