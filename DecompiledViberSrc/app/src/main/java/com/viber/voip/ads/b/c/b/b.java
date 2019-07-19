package com.viber.voip.ads.b.c.b;

import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ListAdapter;
import com.viber.common.a.e;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.a.a.a;
import com.viber.voip.ads.b.c.b.a.d;
import com.viber.voip.ads.h;
import com.viber.voip.ads.s;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.util.cj;
import java.util.Map;

public class b extends f
{
  private static final e i = ViberEnv.getLogger();

  public b(Context paramContext, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.b.b.c.a parama, com.viber.voip.i.f paramf1, com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama1, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc1, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.ads.b.c.c.a.a<com.viber.voip.ads.b.c.c.c> parama2, String paramString, com.viber.voip.messages.extras.b.a parama3, com.viber.voip.util.i.c paramc2, com.viber.voip.analytics.story.g.a parama4, cj paramcj, com.viber.voip.i.f paramf2, s params, h paramh)
  {
    super(paramContext, paramc, parama, paramf1, parama1, paramHandler1, paramHandler2, paramPhoneController, paramICdrController, parama2, paramString, paramcj, paramc1, parama3, paramc2, parama4, paramf2, params, paramh);
  }

  protected com.viber.voip.ads.b.a.a.a.b a(com.viber.voip.ads.b.c.b.a parama)
  {
    Map localMap1 = com.viber.voip.util.k.a.b(parama.a());
    Map localMap2 = com.viber.voip.util.k.a.c(parama.a());
    Location localLocation = h();
    return new com.viber.voip.ads.b.a.a.a.b.a().a(new a.a(parama.a(), 0, "8NkSxai9fzduQhPYUpHGKBSCngbwrfH3O8Jv5YOt", "/65656263/SDK_HB/Calls_Screen_Placement_Production").a(localMap1).b(localMap2).a(localLocation).a()).a(new com.viber.voip.ads.b.a.a.a.c.a(parama.a(), 0, "/65656263/Google_Direct/Calls_Screen_Placement_Prod_Direct", null).a(localMap1).a(localLocation).a()).a();
  }

  protected com.viber.voip.ads.b.c.b.a.c a(ViberListView paramViberListView, ListAdapter paramListAdapter)
  {
    return new a(this, paramViberListView, paramListAdapter);
  }

  protected boolean b(com.viber.voip.ads.b.b.b.a parama)
  {
    i();
    return super.b(parama);
  }

  protected int g()
  {
    return 23;
  }

  private static class a extends com.viber.voip.ads.b.c.b.a.b
  {
    a(d paramd, ViberListView paramViberListView, ListAdapter paramListAdapter)
    {
      super(paramViberListView, paramListAdapter);
    }

    protected Pair<com.viber.voip.ads.b.c.c.c, Boolean> a(ViberListView paramViberListView)
    {
      int i = paramViberListView.getFirstVisiblePosition();
      Rect localRect = new Rect();
      paramViberListView.getDrawingRect(localRect);
      int j = paramViberListView.getChildCount();
      for (int k = 0; k < j; k++)
      {
        View localView = paramViberListView.getChildAt(k);
        if ((localView != null) && (i + k < paramViberListView.getAdapter().getCount()))
        {
          Object localObject = localView.getTag(R.id.calls_tab_ad_tag);
          if ((localObject instanceof com.viber.voip.ads.b.c.c.c))
          {
            com.viber.voip.ads.b.c.c.c localc = (com.viber.voip.ads.b.c.c.c)localObject;
            float f = localView.getY();
            int m = localView.getHeight();
            if ((f >= localRect.top) && (f + m <= localRect.bottom))
              return Pair.create(localc, Boolean.valueOf(true));
            if ((f + m / 2 >= localRect.top) || (f + m / 2 >= localRect.bottom))
              return Pair.create(localc, Boolean.valueOf(false));
          }
        }
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.b
 * JD-Core Version:    0.6.2
 */