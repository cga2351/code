package com.viber.voip.analytics.story.d;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean);
    while (true)
    {
      return n.a("# of People in Block List", paramDouble);
      paramDouble = -paramDouble;
    }
  }

  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Viewed Contacts List", "Last Viewed Contacts List", "# of Times Viewed Contacts List", paramString);
  }

  static ArrayMap<f, g> b(String paramString)
  {
    return n.a("First Viewed Contact Profile", "Last Viewed Contact Profile", "# of Viewed Contact Profile", paramString);
  }

  static ArrayMap<f, g> c(String paramString)
  {
    return n.a("First Added Contacts", "Last Added Contacts", "# of Added Contacts", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.d.a
 * JD-Core Version:    0.6.2
 */