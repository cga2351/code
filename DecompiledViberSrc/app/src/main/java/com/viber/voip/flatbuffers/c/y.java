package com.viber.voip.flatbuffers.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.viber.liblinkparser.LinkParser;
import com.viber.liblinkparser.LinkParser.LinkSpec.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class y extends z
{
  public static boolean a = true;

  public static boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1)
    {
      if (!a)
        break label50;
      ArrayList localArrayList = LinkParser.parseText(paramString, LinkParser.LinkSpec.Type.WEB);
      bool2 = false;
      if (localArrayList != null)
      {
        boolean bool3 = localArrayList.isEmpty();
        bool2 = false;
        if (!bool3)
          bool2 = true;
      }
    }
    return bool2;
    label50: return Patterns.WEB_URL.matcher(paramString).matches();
  }

  protected Uri a(String paramString)
  {
    if (b(paramString))
      return super.a(paramString);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.c.y
 * JD-Core Version:    0.6.2
 */