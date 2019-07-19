package com.viber.voip.s.a;

import com.viber.voip.s.a;
import com.viber.voip.util.da;

public class s extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(1700).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM conversations LEFT OUTER JOIN public_accounts ON (conversations.group_id=public_accounts.group_id)");
    if (!da.a(paramString1))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if (!da.a(paramString4))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.s
 * JD-Core Version:    0.6.2
 */