package com.viber.voip.analytics.story.i;

import com.viber.voip.analytics.g.a;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.f.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

class b
{
  static e a(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point" }).a();
    return new e("View Profile Screen").a("Entry Point", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Element Tapped", "Notification Is displayed" }).a();
    return new e("Tap in More Screen").a("Element Tapped", paramString).a("Notification Is displayed", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(List<String> paramList, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Notification Is displayed", "Badge Is Displayed" }).a();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put((String)localIterator.next());
    return new e("View More Screen").a("Notification Is displayed", localJSONArray).a("Badge Is Displayed", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(a.a[] paramArrayOfa)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "wasabi_experiments_key" }).a("key_property_name", "Total & unique taps on Sticker Market").a();
    return new e("Total & unique taps on Sticker Market").a("wasabi_experiments_key", paramArrayOfa).a(a.class, locala);
  }

  static e b(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Element Tapped" }).a();
    return new e("Tap in Profile Screen").a("Element Tapped", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(a.a[] paramArrayOfa)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "wasabi_experiments_key" }).a("key_property_name", "Total & unique taps on VO").a();
    return new e("Total & unique taps on VO").a("wasabi_experiments_key", paramArrayOfa).a(a.class, locala);
  }

  static e c(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Action Type" }).a();
    return new e("Edit Profile").a("Action Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e c(a.a[] paramArrayOfa)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "wasabi_experiments_key" }).a("key_property_name", "Total & unique taps on VLN").a();
    return new e("Total & unique taps on VLN").a("wasabi_experiments_key", paramArrayOfa).a(a.class, locala);
  }

  static e d(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Origin" }).a();
    return new e("View Secondary Devices Screen").a("Origin", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e e(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Action Type" }).a();
    return new e("Tap in Secondary Devices Screen").a("Action Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.i.b
 * JD-Core Version:    0.6.2
 */