package com.viber.voip.messages.conversation.publicaccount;

import android.view.Menu;
import android.view.MenuItem;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ui.a;
import com.viber.voip.publicaccount.d.e;

public class j extends a
{
  private MenuItem a;
  private MenuItem b;
  private MenuItem c;
  private MenuItem d;

  public void a(Menu paramMenu)
  {
    this.a = paramMenu.findItem(R.id.menu_pa_invite_to_follow);
    this.b = paramMenu.findItem(R.id.menu_open_1on1_chat);
    this.c = paramMenu.findItem(R.id.menu_setup_inbox);
    this.d = paramMenu.findItem(R.id.menu_conversation_info);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool = true;
    if (paramBoolean1)
    {
      a(this.b, bool);
      a(this.c, false);
    }
    while (true)
    {
      a(this.d, e.d());
      a(this.a, paramBoolean4);
      return;
      if (paramBoolean2)
      {
        a(this.b, false);
        MenuItem localMenuItem = this.c;
        if ((!paramBoolean3) && (e.c()));
        while (true)
        {
          a(localMenuItem, bool);
          break;
          bool = false;
        }
      }
      a(this.b, false);
      a(this.c, false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.j
 * JD-Core Version:    0.6.2
 */