package com.viber.voip.analytics.story.b;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.StoryConstants.e.a;
import com.viber.voip.analytics.story.StoryConstants.k.a;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import java.util.List;

public class e
  implements c
{
  private final g a;

  public e(g paramg)
  {
    this.a = paramg;
  }

  public void a()
  {
    this.a.a(b.a());
  }

  public void a(int paramInt)
  {
    this.a.a(b.a(paramInt));
  }

  public void a(int paramInt1, f paramf, String paramString, List<String> paramList, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    String str1 = StoryConstants.e.a.a(paramf);
    String str2 = StoryConstants.k.a.a(paramInt2);
    boolean bool1;
    if ((paramf.g()) || (paramf.h()) || (paramLong4 > 0L))
    {
      bool1 = true;
      if ((!paramf.f()) && (!paramf.a()))
        break label151;
    }
    label151: for (boolean bool2 = true; ; bool2 = false)
    {
      this.a.a(b.a(paramInt1, paramString, paramList, paramLong1, str1, bool2, paramf.d(), paramf.e(), str2, paramLong3, paramLong4, bool1, paramLong5));
      ArrayMap localArrayMap = a.a(ae.b());
      if (bool2)
        a.a(localArrayMap);
      a.a(localArrayMap, str1);
      a.a(localArrayMap, paramLong1);
      a.b(localArrayMap, paramLong2);
      this.a.a(localArrayMap);
      return;
      bool1 = false;
      break;
    }
  }

  public void a(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (!paramBoolean2) && (!paramBoolean3))
    {
      this.a.a(b.c());
      if (!paramString1.equals(paramList.get(0)))
        this.a.a(b.d());
    }
    boolean bool;
    if (!paramBoolean1)
    {
      bool = false;
      if (!paramBoolean3);
    }
    else
    {
      bool = true;
    }
    this.a.a(b.a(paramInt, paramString1, paramList, paramString2, paramString3, bool));
    this.a.a(a.a(ae.b(), paramBoolean2, bool, paramBoolean3, paramString3));
  }

  public void a(CallInfo paramCallInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, long paramLong, String paramString4)
  {
    String str = StoryConstants.e.a.a(paramCallInfo);
    boolean bool;
    ArrayMap localArrayMap;
    int i;
    if ((paramBoolean3) || (paramCallInfo.isConference()))
    {
      bool = true;
      this.a.a(b.a(paramString2, paramString3, paramBoolean1, paramBoolean2, str, paramString1, bool, paramBoolean4, paramBoolean5, paramLong));
      if ((paramBoolean3) && (!paramCallInfo.isViberOut()) && (!paramCallInfo.isConference()))
      {
        this.a.a(b.e());
        if (!paramString2.equals(paramString3))
          this.a.a(b.f());
      }
      localArrayMap = a.b(paramString4);
      a.b(localArrayMap, paramString1);
      if (bool)
        a.b(localArrayMap);
      if ("Group Audio Call".equals(str))
        a.d(localArrayMap);
      i = -1;
      switch (paramString1.hashCode())
      {
      default:
        label180: switch (i)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
        break;
      case 1966025694:
      case 271151619:
      case -2106529294:
      }
    }
    while (true)
    {
      this.a.a(localArrayMap);
      return;
      bool = false;
      break;
      if (!paramString1.equals("Answer"))
        break label180;
      i = 0;
      break label180;
      if (!paramString1.equals("Answer with Video"))
        break label180;
      i = 1;
      break label180;
      if (!paramString1.equals("Ignore"))
        break label180;
      i = 2;
      break label180;
      a.e(localArrayMap);
      continue;
      a.c(localArrayMap);
      continue;
      a.f(localArrayMap);
    }
  }

  public void a(String paramString)
  {
    this.a.a(b.a(da.h(paramString)));
  }

  public void b()
  {
    this.a.a(b.b());
  }

  public void b(int paramInt)
  {
    this.a.a(b.b(paramInt));
  }

  public void b(String paramString)
  {
    this.a.a(b.b(paramString));
  }

  public void c(String paramString)
  {
    this.a.a(b.c(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.e
 * JD-Core Version:    0.6.2
 */