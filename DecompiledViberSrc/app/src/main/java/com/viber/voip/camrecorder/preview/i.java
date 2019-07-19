package com.viber.voip.camrecorder.preview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.cv;
import com.viber.voip.messages.ui.cv.a;
import com.viber.voip.messages.ui.cv.c.a;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.settings.d.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class i extends cv
{
  private static final Logger m = ViberEnv.getLogger();

  i(Context paramContext, View paramView, LayoutInflater paramLayoutInflater, d.a parama)
  {
    super(paramContext, paramView, paramLayoutInflater, parama, new cv.a()
    {
      public int a()
      {
        return d.ax.k.d();
      }

      public void a(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        d.ax.k.a(paramAnonymousInt);
      }
    }
    , new cv.c.a().a(false).b(false).a(R.color.solid_70).b(R.drawable.preview_tab_background).a(ContextCompat.getDrawable(paramContext, R.drawable.sticker_package_selector)).b(ContextCompat.getDrawable(paramContext, R.drawable.ic_stickers_menu_add)).c(ContextCompat.getDrawable(paramContext, R.drawable.ic_stickers_menu_search)).a());
  }

  protected int a()
  {
    com.viber.voip.stickers.entity.a locala = this.b.k();
    if ((locala != null) && (locala.p()) && (locala.g()))
      return locala.e();
    return super.a();
  }

  protected void a(LayoutInflater paramLayoutInflater, com.viber.voip.stickers.entity.a parama)
  {
    super.a(paramLayoutInflater, parama);
    this.j.a(false);
  }

  protected boolean a(com.viber.voip.stickers.entity.a parama)
  {
    if (parama.k())
      return false;
    return super.a(parama);
  }

  public List<com.viber.voip.stickers.entity.a> b()
  {
    ArrayList localArrayList = new ArrayList(this.b.g());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      com.viber.voip.stickers.entity.a locala3 = (com.viber.voip.stickers.entity.a)localIterator.next();
      if ((locala3.h()) || (!locala3.g()))
        localIterator.remove();
    }
    com.viber.voip.stickers.entity.a locala1 = this.b.k();
    if ((locala1 != null) && (locala1.p()) && (locala1.g()))
      localArrayList.add(0, locala1);
    com.viber.voip.stickers.entity.a locala2 = this.b.j();
    if ((locala2 != null) && (locala2.p()) && (locala2.g()))
      localArrayList.add(0, locala2);
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.i
 * JD-Core Version:    0.6.2
 */