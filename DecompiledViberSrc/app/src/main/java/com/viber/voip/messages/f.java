package com.viber.voip.messages;

import android.content.Context;
import com.viber.jni.LocationInfo;
import com.viber.voip.model.entity.MessageEntity;

public class f
{
  public static MessageEntity a(Context paramContext, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString6, boolean paramBoolean, int paramInt8, int paramInt9)
  {
    if (12 == paramInt3)
      return a(paramContext, paramLong1, paramLong2, paramString1, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString2, paramString3, paramString4, paramString5, paramInt4, paramInt5, paramInt6, paramInt7, paramString6, paramBoolean);
    return new p(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString2, paramString3, paramString4, paramString5, paramInt4, paramInt5, paramInt6, paramInt7, null, paramString6, paramBoolean, false, paramInt8, paramInt9).a(paramContext, paramInt3);
  }

  private static MessageEntity a(Context paramContext, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, long paramLong3, int paramInt1, int paramInt2, LocationInfo paramLocationInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString6, boolean paramBoolean)
  {
    q.a locala = q.a(paramString6);
    return new p(paramLong1, paramLong2, paramString1, paramArrayOfByte, paramLong3, paramInt1, paramInt2, paramLocationInfo, paramString2, paramString3, paramString4, paramString5, paramInt3, paramInt4, paramInt5, paramInt6, locala.b(), locala.a(), paramBoolean, true, 0, 0).b(paramContext, locala.c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.f
 * JD-Core Version:    0.6.2
 */