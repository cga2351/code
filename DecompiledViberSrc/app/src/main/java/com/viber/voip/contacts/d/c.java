package com.viber.voip.contacts.d;

import android.net.Uri;
import android.text.TextUtils;
import com.viber.provider.contacts.a.c;

public class c
  implements a
{
  private String a;
  private String b;

  public Uri a()
  {
    return a.c.d;
  }

  public String[] a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    String str1 = "%" + this.a + "%";
    if (!TextUtils.isEmpty(this.b));
    for (String str2 = "%" + this.b + "%"; ; str2 = str1)
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = this.a;
      arrayOfString[1] = str1;
      arrayOfString[2] = str1;
      arrayOfString[3] = str2;
      return arrayOfString;
    }
  }

  public String b()
  {
    return "(phonebookcontact.native_id IN (%s) OR phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1 LIKE ? OR phonebookdata.data2 LIKE ? OR phonebookdata.data2 LIKE ?)))";
  }

  public String c()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.d.c
 * JD-Core Version:    0.6.2
 */