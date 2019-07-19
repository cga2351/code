package com.viber.voip.backup.d.a;

import com.viber.voip.backup.d.a.a.c.a;
import java.util.ArrayList;
import java.util.List;

class e extends c
{
  private final String[] b;
  private final boolean c;

  public e(b paramb, int[] paramArrayOfInt)
  {
    super(paramb);
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
      localArrayList.add(String.valueOf(paramArrayOfInt[j]));
    int k = localArrayList.indexOf(String.valueOf(2));
    if (k >= 0)
    {
      this.c = true;
      localArrayList.remove(k);
    }
    while (true)
    {
      this.b = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      return;
      this.c = false;
    }
  }

  public List<com.viber.voip.backup.d.a.a.c> a()
  {
    List localList = super.a();
    c.a locala = new c.a();
    if (this.c)
      locala.a(" AND ");
    locala.a("", "extra_mime", this.b);
    if (this.c)
    {
      locala.a(" OR ").a("", "extra_mime", Integer.valueOf(2)).b(" AND ", "extra_duration", Integer.valueOf(0)).a();
      locala.a();
    }
    localList.add(locala.b());
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a.e
 * JD-Core Version:    0.6.2
 */