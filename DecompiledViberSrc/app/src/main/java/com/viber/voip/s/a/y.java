package com.viber.voip.s.a;

import com.viber.voip.s.a;
import com.viber.voip.util.da;

public class y extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(3550).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    a(localStringBuilder);
    if (!da.a(paramString1))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if (!da.a(paramString4))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }

  protected void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(" FROM conversations LEFT OUTER JOIN messages ON (messages._id = (SELECT messages._id FROM messages WHERE messages.conversation_id=conversations._id AND messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT 1)) LEFT OUTER JOIN public_accounts ON (conversations.group_id=public_accounts.group_id AND conversations.group_id > 0) LEFT OUTER JOIN participants_info ON (conversations.participant_id_1=participants_info._id)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.y
 * JD-Core Version:    0.6.2
 */