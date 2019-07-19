package com.viber.voip.ui.style;

import android.text.style.URLSpan;
import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.i;
import com.viber.voip.ui.g.c;
import com.viber.voip.ui.g.d;

public class InternalURLSpan extends URLSpan
{
  private static a sClickListener;

  public InternalURLSpan(String paramString)
  {
    super(paramString);
  }

  public static void addClickListener(a parama)
  {
    if (sClickListener != parama)
      sClickListener = parama;
  }

  public static void removeClickListener(a parama)
  {
    if (sClickListener == parama)
      sClickListener = null;
  }

  public void onClick(View paramView)
  {
    Object localObject1;
    aa localaa;
    if (sClickListener != null)
    {
      localObject1 = paramView.getTag();
      if (!(localObject1 instanceof com.viber.voip.messages.conversation.adapter.a.a))
        break label44;
      localaa = ((com.viber.voip.messages.conversation.adapter.a.a)localObject1).c();
    }
    while (true)
    {
      sClickListener.a(getURL(), localaa);
      return;
      label44: if ((localObject1 instanceof aa))
      {
        localaa = (aa)localObject1;
      }
      else
      {
        View localView = (View)paramView.getParent();
        if (localView != null)
        {
          Object localObject2 = localView.getTag();
          if ((localObject2 instanceof aa))
          {
            localaa = (aa)localObject2;
          }
          else if ((localObject2 instanceof com.viber.voip.ui.g.a))
          {
            c localc = ((com.viber.voip.ui.g.a)localObject2).a().d();
            if ((localc instanceof i))
              localaa = ((i)localc).c();
          }
        }
        else
        {
          localaa = null;
        }
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, aa paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.InternalURLSpan
 * JD-Core Version:    0.6.2
 */