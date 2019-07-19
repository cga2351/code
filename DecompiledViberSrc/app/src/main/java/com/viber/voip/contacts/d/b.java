package com.viber.voip.contacts.d;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b extends d
{
  private static Pattern a = Pattern.compile("([^(\\u0020)]+)", 2);

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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.d.b
 * JD-Core Version:    0.6.2
 */