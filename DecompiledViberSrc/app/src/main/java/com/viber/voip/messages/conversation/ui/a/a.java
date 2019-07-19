package com.viber.voip.messages.conversation.ui.a;

import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewConfiguration;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.o;
import com.viber.voip.widget.b.b.a;

public class a
  implements o, b.a
{
  private final o a;
  private final View.OnCreateContextMenuListener b;
  private boolean c;
  private final Handler d;
  private final Runnable e = new b(this);

  public a(o paramo, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, Handler paramHandler)
  {
    this.a = paramo;
    this.b = paramOnCreateContextMenuListener;
    this.d = paramHandler;
  }

  public void a(aa paramaa)
  {
    if (!this.c)
      this.a.a(paramaa);
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    this.a.a(paramaa, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    this.d.postDelayed(this.e, 2 * ViewConfiguration.getLongPressTimeout());
  }

  public void b()
  {
    this.d.removeCallbacks(this.e);
    this.c = true;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (!this.c)
      this.b.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.a.a
 * JD-Core Version:    0.6.2
 */