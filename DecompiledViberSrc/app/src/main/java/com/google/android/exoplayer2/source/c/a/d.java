package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.offline.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d extends f
{
  public static final d a = new d("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap());
  public final List<a> b;
  public final List<a> c;
  public final List<a> d;
  public final Format e;
  public final List<Format> f;
  public final Map<String, String> g;

  public d(String paramString, List<String> paramList, List<a> paramList1, List<a> paramList2, List<a> paramList3, Format paramFormat, List<Format> paramList4, boolean paramBoolean, Map<String, String> paramMap)
  {
    super(paramString, paramList, paramBoolean);
    this.b = Collections.unmodifiableList(paramList1);
    this.c = Collections.unmodifiableList(paramList2);
    this.d = Collections.unmodifiableList(paramList3);
    this.e = paramFormat;
    if (paramList4 != null);
    for (List localList = Collections.unmodifiableList(paramList4); ; localList = null)
    {
      this.f = localList;
      this.g = Collections.unmodifiableMap(paramMap);
      return;
    }
  }

  public static d a(String paramString)
  {
    List localList1 = Collections.singletonList(a.a(paramString));
    List localList2 = Collections.emptyList();
    return new d(null, Collections.emptyList(), localList1, localList2, localList2, null, null, false, Collections.emptyMap());
  }

  private static List<a> a(List<a> paramList, int paramInt, List<c> paramList1)
  {
    ArrayList localArrayList = new ArrayList(paramList1.size());
    int i = 0;
    if (i < paramList.size())
    {
      a locala = (a)paramList.get(i);
      for (int j = 0; ; j++)
        if (j < paramList1.size())
        {
          c localc = (c)paramList1.get(j);
          if ((localc.b == paramInt) && (localc.c == i))
            localArrayList.add(locala);
        }
        else
        {
          i++;
          break;
        }
    }
    return localArrayList;
  }

  public d b(List<c> paramList)
  {
    return new d(this.n, this.o, a(this.b, 0, paramList), a(this.c, 1, paramList), a(this.d, 2, paramList), this.e, this.f, this.p, this.g);
  }

  public static final class a
  {
    public final String a;
    public final Format b;

    public a(String paramString, Format paramFormat)
    {
      this.a = paramString;
      this.b = paramFormat;
    }

    public static a a(String paramString)
    {
      return new a(paramString, Format.createContainerFormat("0", null, "application/x-mpegURL", null, null, -1, 0, null));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.d
 * JD-Core Version:    0.6.2
 */