package com.viber.voip.util.g.a;

import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage.MutableFormattedMessageWrapper;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.orm.entity.json.TextMessage.MutableTextMessageWrapper;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends a
{
  private static final e b = ViberEnv.getLogger();

  public b(int paramInt)
  {
    super(paramInt);
  }

  public void a(MessageEntity paramMessageEntity)
  {
    FormattedMessage localFormattedMessage = paramMessageEntity.loadFormattedMessage();
    if (localFormattedMessage == null)
      return;
    FormattedMessage.MutableFormattedMessageWrapper localMutableFormattedMessageWrapper = localFormattedMessage.mutate();
    Iterator localIterator = localFormattedMessage.getMessage().iterator();
    int i = 0;
    BaseMessage localBaseMessage;
    TextMessage localTextMessage;
    int m;
    while (true)
      if (localIterator.hasNext())
      {
        localBaseMessage = (BaseMessage)localIterator.next();
        if ((localBaseMessage instanceof TextMessage))
        {
          localTextMessage = (TextMessage)localBaseMessage;
          if ((!paramMessageEntity.isForwardedMessage()) || (da.a(localTextMessage.getSpans())))
          {
            boolean bool1 = a.a(localTextMessage, paramMessageEntity);
            if (((0x1 & this.a) == 0) || (!bool1))
              break label285;
            if (a.a(paramMessageEntity))
              m = 1;
          }
        }
      }
    label285: for (int j = m | 0x0; ; j = 0)
    {
      while (true)
      {
        boolean bool2 = a.b(localTextMessage, paramMessageEntity);
        if (((0x2 & this.a) != 0) && (bool2))
          j |= 2;
        boolean bool3 = a.c(localTextMessage, paramMessageEntity);
        if (((0x8 & this.a) != 0) && (bool3))
          j |= 8;
        String str = a(localTextMessage.getText(), paramMessageEntity.getMessageInfo().getTextMetaInfo(), j);
        if (str.equals(localTextMessage.getSpans()))
          break;
        try
        {
          localMutableFormattedMessageWrapper.getJsonData().getJSONObject(localBaseMessage.getElementIndex()).put("TextSpans", str);
          localTextMessage.mutate().setSpans(str);
          k = 1;
          i = k;
          break;
          m = 4;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            int k = i;
        }
      }
      if (i == 0)
        break;
      paramMessageEntity.setBody(localMutableFormattedMessageWrapper.getJsonData().toString());
      return;
    }
  }

  public static final class a
  {
    public static boolean a(aa paramaa)
    {
      return paramaa.aE();
    }

    public static boolean a(TextMessage paramTextMessage, aa paramaa)
    {
      FormattedMessage localFormattedMessage = paramaa.L();
      return (paramTextMessage.shouldHighlightLinks()) || ((paramaa.aE()) && (localFormattedMessage != null) && (!localFormattedMessage.isInviteFromPublicAccount()) && (!paramaa.aL()) && (!paramaa.aF()));
    }

    public static boolean a(TextMessage paramTextMessage, MessageEntity paramMessageEntity)
    {
      FormattedMessage localFormattedMessage = paramMessageEntity.loadFormattedMessage();
      return (paramTextMessage.shouldHighlightLinks()) || ((paramMessageEntity.isFormattedMessage()) && (localFormattedMessage != null) && (!localFormattedMessage.isInviteFromPublicAccount()) && (!paramMessageEntity.isUrlMessage()) && (!paramMessageEntity.isShareContactMessage()));
    }

    public static boolean a(MessageEntity paramMessageEntity)
    {
      return paramMessageEntity.isFormattedMessage();
    }

    public static boolean b(TextMessage paramTextMessage, aa paramaa)
    {
      return (paramTextMessage.shouldHighlightEmoticons()) || ((paramaa.aE()) && (!paramaa.aL()) && (!paramaa.aF()));
    }

    public static boolean b(TextMessage paramTextMessage, MessageEntity paramMessageEntity)
    {
      return (paramTextMessage.shouldHighlightEmoticons()) || ((paramMessageEntity.isFormattedMessage()) && (!paramMessageEntity.isUrlMessage()) && (!paramMessageEntity.isShareContactMessage()));
    }

    public static boolean c(TextMessage paramTextMessage, aa paramaa)
    {
      return paramTextMessage.shouldConsiderMentions();
    }

    public static boolean c(TextMessage paramTextMessage, MessageEntity paramMessageEntity)
    {
      return paramTextMessage.shouldConsiderMentions();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.b
 * JD-Core Version:    0.6.2
 */