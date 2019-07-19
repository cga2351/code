package com.viber.voip.s.a;

import com.viber.voip.s.a;

public class f extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(1700).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM calls LEFT OUTER JOIN vibernumbers ON (calls.canonized_number=vibernumbers.canonized_number) LEFT OUTER JOIN phonebookdata ON (calls.canonized_number=phonebookdata.data2) LEFT OUTER JOIN phonebookcontact ON (phonebookdata.contact_id=phonebookcontact._id) WHERE (phonebookdata._id = (SELECT MIN(phonebookdata._id) FROM phonebookdata WHERE phonebookdata.data2=calls.canonized_number)  OR phonebookdata._id IS NULL)");
    if ((paramString1 != null) && (!paramString1.isEmpty()))
      localStringBuilder.append(" AND (").append(paramString1).append(")");
    localStringBuilder.append(" GROUP BY ").append("calls.aggregate_hash");
    if ((paramString4 != null) && (!paramString4.isEmpty()))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.f
 * JD-Core Version:    0.6.2
 */