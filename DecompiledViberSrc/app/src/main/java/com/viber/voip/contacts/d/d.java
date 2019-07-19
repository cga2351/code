package com.viber.voip.contacts.d;

import android.net.Uri;
import android.text.TextUtils;
import com.viber.provider.contacts.a.c;
import com.viber.voip.util.a.b;
import com.viber.voip.util.a.b.b;
import com.viber.voip.util.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
  implements a
{
  private static Pattern a = Pattern.compile("([^(\\u0020-\\u002f)(\\u003a-\\u003f)(\\u005b-\\u005e)(\\u007b-\\u007e)]+)", 2);
  private String b = "";
  private String c;
  private String d;

  private void a(HashMap<String, StringBuilder> paramHashMap, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = (StringBuilder)paramHashMap.get(paramString1);
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder();
      paramHashMap.put(paramString1, localStringBuilder);
    }
    if (localStringBuilder.length() == 0);
    for (String str = ""; ; str = " AND ")
    {
      localStringBuilder.append(str).append(b(paramString1, paramString2));
      return;
    }
  }

  private String b(String paramString1, String paramString2)
  {
    String str = paramString2.replace("\"", "\"\"");
    return paramString1 + " LIKE \"%" + str + "%\"";
  }

  public Uri a()
  {
    return a.c.e;
  }

  protected String[] a(String paramString)
  {
    Matcher localMatcher = a.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (!localMatcher.find())
        break;
      localArrayList.add(localMatcher.group(0));
    }
    while (localArrayList.size() < 5);
    if (localArrayList.isEmpty())
      localArrayList.add(paramString);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public String[] a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      paramString1 = "";
    this.c = paramString1;
    this.d = paramString2;
    String str1 = "%" + this.c + "%";
    String str2;
    HashMap localHashMap;
    int i;
    label115: String str3;
    b.b localb;
    String str4;
    if (!TextUtils.isEmpty(this.d))
    {
      str2 = "%" + this.d + "%";
      String[] arrayOfString = a(this.c);
      if (arrayOfString.length <= 0)
        break label345;
      localHashMap = new HashMap();
      i = 0;
      if (i >= arrayOfString.length)
        break label236;
      str3 = arrayOfString[i];
      localb = b.a(str3);
      if (!localb.c)
        break label189;
      str4 = str3;
    }
    while (true)
    {
      if (e.h(str3))
        a(localHashMap, "phonebookcontact.display_name", str3);
      a(localHashMap, "phonebookcontact.low_display_name", str4);
      i++;
      break label115;
      str2 = str1;
      break;
      label189: str4 = localb.a;
      String str5 = localb.b;
      a(localHashMap, "phonebookcontact.phonetic_name", str5);
      a(localHashMap, "phonebookcontact.phonetic_name", str4);
      a(localHashMap, "phonebookcontact.low_display_name", str5);
    }
    label236: Iterator localIterator = localHashMap.keySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
      localStringBuilder.append("(").append((CharSequence)localHashMap.get(localIterator.next())).append(") OR ");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localStringBuilder.toString();
    this.b = String.format("( %s phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.mime_type=0 AND (phonebookdata.data1 LIKE ? OR phonebookdata.data2 LIKE ? OR phonebookdata.data2 LIKE ?)))", arrayOfObject);
    return new String[] { str1, str1, str2 };
    label345: return null;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.d.d
 * JD-Core Version:    0.6.2
 */