package com.viber.voip.messages.controller.c;

import android.content.Context;
import com.viber.voip.messages.j;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.av;

public class c
{
  public static MessageEntity a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, String paramString1, int paramInt3, long paramLong3, String paramString2, int paramInt4, int paramInt5)
  {
    if ((paramInt3 & 0x10) != 0);
    MessageEntity localMessageEntity;
    for (int i = 1; ; i = 0)
    {
      localMessageEntity = new MessageEntity();
      localMessageEntity.setMessageSeq(paramInt1);
      localMessageEntity.setGroupId(paramLong1);
      localMessageEntity.setConversationType(paramInt2);
      localMessageEntity.setDate(paramLong2);
      if (i == 0)
        break;
      localMessageEntity.setType(1);
      localMessageEntity.setStatus(2);
      localMessageEntity.setUnread(0);
      localMessageEntity.setMemberId(paramString1);
      localMessageEntity.setMessageToken(paramLong3);
      localMessageEntity.setLat(0);
      localMessageEntity.setLng(0);
      localMessageEntity.setFlag(paramInt3);
      localMessageEntity.setBody(paramString2);
      localMessageEntity.setMessageGlobalId(paramInt4);
      localMessageEntity.setMimeType(paramInt5);
      return localMessageEntity;
    }
    localMessageEntity.setType(0);
    if ((paramInt3 & 0x40) != 0);
    for (int j = 0; ; j = 1)
    {
      localMessageEntity.setUnread(j);
      break;
    }
  }

  public static MessageEntity a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, long paramLong3, String paramString2)
  {
    return a(paramLong1, paramInt1, paramLong2, paramString1, paramInt2, paramLong3, paramString2, 0);
  }

  public static MessageEntity a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, long paramLong3, String paramString2, int paramInt3)
  {
    return a(paramLong1, paramInt1, paramLong2, paramString1, paramInt2, paramLong3, paramString2, paramInt3, 1000);
  }

  private static MessageEntity a(long paramLong1, int paramInt1, long paramLong2, String paramString1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4)
  {
    return a(0, paramLong1, paramInt1, paramLong2, paramString1, paramInt2, paramLong3, paramString2, paramInt3, paramInt4);
  }

  public static MessageEntity a(long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, long paramLong3, int paramInt3)
  {
    return a(paramLong1, paramInt1, paramLong2, paramString, paramInt2, paramLong3, "", paramInt3, 1007);
  }

  public static MessageEntity a(Context paramContext, int paramInt1, h paramh, String paramString1, int paramInt2, long paramLong1, long paramLong2, String paramString2, String paramString3, int paramInt3)
  {
    int i;
    int m;
    if ((paramh != null) && (paramInt1 > 0))
    {
      i = paramInt1 & 0x7;
      if (!paramh.g())
        break label225;
      m = av.f(i, 4);
      if (m == 0)
        break label225;
    }
    label225: for (int j = m; ; j = i)
    {
      if ((j & j - 1) != 0);
      for (int k = 1; k != 0; k = 0)
        return a(paramh.k(), paramh.j(), paramLong1, paramString1, paramInt2, paramLong2, j.a(paramString1, j, paramString3), paramInt3);
      if ((j & 0x4) != 0)
      {
        if (paramh.g())
          return a(paramh.k(), paramh.j(), paramString1, paramLong1, paramInt2, paramLong2, paramInt3);
        return a(paramh.k(), paramh.j(), paramLong1, paramString1, paramInt2, paramLong2, j.g(paramString1), paramInt3);
      }
      if ((j & 0x2) != 0)
        return a(paramh.k(), paramh.j(), paramLong1, paramString1, paramInt2, paramLong2, j.b(paramString1, paramh.q()), paramInt3);
      if ((j & 0x1) != 0)
        return a(paramh.k(), paramh.j(), paramLong1, paramString1, paramInt2, paramLong2, j.a(paramString1, paramString3, paramString2), paramInt3);
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.c.c
 * JD-Core Version:    0.6.2
 */