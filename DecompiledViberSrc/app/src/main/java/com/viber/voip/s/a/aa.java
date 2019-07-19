package com.viber.voip.s.a;

import android.text.TextUtils;
import com.viber.provider.contacts.a.f.a;
import com.viber.voip.s.a;

public class aa extends ai
{
  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a.d(paramArrayOfString);
    StringBuilder localStringBuilder2 = new StringBuilder().append(" AND (");
    if (TextUtils.isEmpty(paramString1))
      paramString1 = "1";
    String str2 = paramString1 + ")";
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = str1;
    arrayOfObject1[1] = (a.f.a.a.ordinal() + str2);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(String.format(" SELECT %s, MAX(_id), GROUP_CONCAT(_id) as ids, COUNT(*) as canonized_number_rows_count FROM sync_data WHERE operation=%s GROUP BY canonized_phone_number", arrayOfObject1)).append(" UNION ALL ");
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = str1;
    arrayOfObject2[1] = (a.f.a.c.ordinal() + str2);
    StringBuilder localStringBuilder4 = localStringBuilder3.append(String.format(" SELECT %s, MAX(_id), GROUP_CONCAT(_id) as ids, COUNT(*) as canonized_number_rows_count FROM sync_data WHERE operation=%s GROUP BY canonized_phone_number", arrayOfObject2)).append(" UNION ALL ");
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = str1;
    arrayOfObject3[1] = (a.f.a.b.ordinal() + str2);
    localStringBuilder4.append(String.format(" SELECT %s, MAX(_id), GROUP_CONCAT(_id) as ids, COUNT(*) as canonized_number_rows_count FROM sync_data WHERE operation=%s GROUP BY canonized_phone_number", arrayOfObject3));
    if ((paramString4 != null) && (!paramString4.isEmpty()))
      localStringBuilder1.append(" ORDER BY ").append(paramString4);
    return localStringBuilder1.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.aa
 * JD-Core Version:    0.6.2
 */