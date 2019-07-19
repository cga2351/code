package com.viber.voip.notif.b.e;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.h.g;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.dg;
import java.util.Iterator;
import java.util.Set;

public class a extends d
{
  public a(g paramg)
  {
    super(paramg);
  }

  protected n b(Context paramContext, o paramo)
  {
    return paramo.b(paramContext, a(), ViberActionRunner.ab.a(paramContext), 134217728);
  }

  protected CharSequence c(Context paramContext)
  {
    int i = R.string.notification_aggregated_likes_title;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.valueOf(this.a.g());
    return paramContext.getString(i, arrayOfObject);
  }

  protected CharSequence h(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.f().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(dg.b(str));
    }
    return paramContext.getString(R.string.notification_aggregated_likes_text, new Object[] { localStringBuilder });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.e.a
 * JD-Core Version:    0.6.2
 */