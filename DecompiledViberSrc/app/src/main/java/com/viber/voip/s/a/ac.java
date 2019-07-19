package com.viber.voip.s.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.viber.provider.b;
import com.viber.voip.s.a;

public class ac extends ai
{
  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Cursor localCursor = paramb.a(1048576, a(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4), paramArrayOfString2);
      return localCursor;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(1250).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM messages LEFT OUTER JOIN stickers ON (messages.extra_upload_id=stickers._id) LEFT OUTER JOIN remote_banners ON (remote_banners.token=stickers._id AND remote_banners.location=messages.conversation_id) LEFT OUTER JOIN participants ON (messages.participant_id=participants._id) LEFT OUTER JOIN participants_info ON (participants.participant_info_id=participants_info._id)");
    if (!TextUtils.isEmpty(paramString1))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if (!TextUtils.isEmpty(paramString4))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.ac
 * JD-Core Version:    0.6.2
 */