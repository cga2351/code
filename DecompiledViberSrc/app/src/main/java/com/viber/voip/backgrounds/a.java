package com.viber.voip.backgrounds;

import android.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Pattern b = Pattern.compile("(\\B1[0-9a-f]{7})", 2);
  private int c;
  private String d;
  private String e;
  private List<p> f;

  public static a a(String paramString)
  {
    a locala = new a();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      locala.c = localJSONObject1.getInt("revision");
      locala.d = localJSONObject1.getString("defaultBackgroundId");
      locala.f = new ArrayList();
      if (localJSONObject1.has("colors"))
      {
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("colors");
        Iterator localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject2.getString(str1);
          p localp = new p(((Integer)m.e(str1).first).intValue(), locala.c, true, str2);
          locala.f.add(localp);
          if (str1.equals(locala.d))
            locala.e = str2;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    return locala;
  }

  public static int b(String paramString)
  {
    Matcher localMatcher = b.matcher(paramString);
    if (localMatcher.find())
      return Integer.parseInt(localMatcher.group(1), 10);
    return -1;
  }

  public int a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public List<p> c()
  {
    if (this.f == null)
      this.f = new ArrayList();
    return this.f;
  }

  public String d()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.a
 * JD-Core Version:    0.6.2
 */