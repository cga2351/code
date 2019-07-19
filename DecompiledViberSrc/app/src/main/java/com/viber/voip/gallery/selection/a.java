package com.viber.voip.gallery.selection;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.util.dg;
import com.viber.voip.widget.aj;

public class a
{
  aj a;
  private ViberFragmentActivity b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h;
  private a i;
  private final android.support.v7.app.a j;
  private final String k;

  public a(ViberFragmentActivity paramViberFragmentActivity, a parama)
  {
    this.b = paramViberFragmentActivity;
    ConversationData localConversationData = (ConversationData)paramViberFragmentActivity.getIntent().getParcelableExtra("extra_conversation_data");
    int m;
    Object[] arrayOfObject;
    if (localConversationData != null)
    {
      m = R.string.gallery_title;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = dg.a(localConversationData);
    }
    for (this.k = paramViberFragmentActivity.getString(m, arrayOfObject); ; this.k = paramViberFragmentActivity.getString(R.string.gallery))
    {
      this.i = parama;
      this.j = paramViberFragmentActivity.getSupportActionBar();
      this.e = ContextCompat.getColor(this.b, R.color.negative);
      this.f = ContextCompat.getColor(this.b, R.color.red);
      return;
    }
  }

  private void c()
  {
    this.i.a();
  }

  private void d()
  {
    aj localaj;
    if (this.a != null)
    {
      String str = Integer.toString(this.c) + "/" + Integer.toString(this.d);
      this.a.a(str);
      localaj = this.a;
      if (this.c >= this.d)
        break label78;
    }
    label78: for (int m = this.e; ; m = this.f)
    {
      localaj.d(m);
      return;
    }
  }

  public void a()
  {
    this.g = true;
    c();
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
    d();
  }

  public void a(String paramString)
  {
    this.j.c(true);
    this.j.a(paramString);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.c(true);
      this.j.a(this.k);
      return;
    }
    this.j.c(false);
  }

  public boolean a(Menu paramMenu)
  {
    this.b.getMenuInflater().inflate(R.menu.menu_gallery, paramMenu);
    this.a = new aj(MenuItemCompat.getActionView(paramMenu.findItem(R.id.menu_counts)));
    this.a.a(false);
    this.a.e(0);
    d();
    return true;
  }

  public void b()
  {
    this.g = false;
    c();
  }

  public void b(int paramInt)
  {
    this.c = paramInt;
    d();
  }

  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public boolean b(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_done);
    if ((this.g) && ((this.c > 0) || (this.h)));
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      paramMenu.findItem(R.id.menu_counts).setVisible(this.g);
      return true;
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.a
 * JD-Core Version:    0.6.2
 */