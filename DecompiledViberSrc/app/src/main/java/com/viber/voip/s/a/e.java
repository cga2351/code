package com.viber.voip.s.a;

import android.text.TextUtils;
import com.viber.voip.s.a;

public class e extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(450).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM ").append("messages");
    if (!TextUtils.isEmpty(paramString1))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if (!TextUtils.isEmpty(paramString4))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.e
 * JD-Core Version:    0.6.2
 */