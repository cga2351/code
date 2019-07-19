package com.viber.voip.messages.conversation.adapter;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.cd;

public class y extends c
{
  private boolean c;

  public y(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    super(paramContext, paramConversationItemLoaderEntity);
    this.b = paramConversationItemLoaderEntity;
    this.c = paramBoolean;
  }

  public String h()
  {
    if ((!this.c) && (as.a(this.b)));
    for (int i = 1; i != 0; i = 0)
      return this.a.getString(R.string.public_account_manage_participants);
    return "";
  }

  public boolean i()
  {
    return false;
  }

  public String j()
  {
    return null;
  }

  public boolean l()
  {
    return cd.b(this.b.getGroupRole());
  }

  public String m()
  {
    if ((!this.c) && (this.b != null) && (cd.d(this.b.getGroupRole(), this.b.getConversationType())));
    for (int i = 1; i != 0; i = 0)
      return this.a.getString(R.string.public_account_manage_participants);
    return "";
  }

  public String n()
  {
    return this.a.getString(R.string.public_group_info_show_all_admins);
  }

  public String o()
  {
    return this.a.getString(R.string.public_group_info_show_all_participants);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.y
 * JD-Core Version:    0.6.2
 */