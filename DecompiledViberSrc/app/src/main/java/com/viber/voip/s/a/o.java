package com.viber.voip.s.a;

import android.database.Cursor;
import com.viber.provider.b;
import com.viber.voip.s.a;

public class o extends ai
{
  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      Cursor localCursor = paramb.a(2097152, a(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4), paramArrayOfString2);
      return localCursor;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(1400).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM phonebookcontact LEFT OUTER JOIN phonebookrawcontact ON (phonebookcontact._id=phonebookrawcontact.contact_id) LEFT OUTER JOIN phonebookdata ON (phonebookrawcontact._id=phonebookdata.raw_id)");
    if ((paramString1 != null) && (!paramString1.isEmpty()))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if ((paramString4 != null) && (!paramString4.isEmpty()))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.o
 * JD-Core Version:    0.6.2
 */