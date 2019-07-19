package com.viber.voip.s.a;

import com.viber.voip.s.a;

public class l extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(650).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM phonebookdata").append(" LEFT OUTER JOIN phonebookcontact").append(" ON (phonebookcontact._id=phonebookdata.contact_id)").append(" LEFT OUTER JOIN vibernumbers").append(" ON (phonebookdata.data2=vibernumbers.canonized_number)").append(" LEFT OUTER JOIN blockednumbers").append(" ON (blockednumbers.canonized_number=vibernumbers.member_id OR blockednumbers.canonized_number=phonebookdata.data2)").append(" WHERE phonebookdata.mime_type=0");
    if ((paramString1 != null) && (!paramString1.isEmpty()))
      localStringBuilder.append(" AND (").append(paramString1).append(")");
    if ((paramString4 != null) && (!paramString4.isEmpty()))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.l
 * JD-Core Version:    0.6.2
 */