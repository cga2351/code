package com.viber.voip.messages.conversation.adapter;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.contacts.ui.list.as;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;

public abstract class c
  implements n
{
  protected Context a;
  protected ConversationItemLoaderEntity b;

  public c(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.a = paramContext;
    this.b = paramConversationItemLoaderEntity;
  }

  public int a()
  {
    return 4;
  }

  public String a(int paramInt)
  {
    if (paramInt > 0)
    {
      Context localContext = this.a;
      int i = R.string.public_group_info_admin_count;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.toString(paramInt);
      return localContext.getString(i, arrayOfObject);
    }
    return this.a.getString(R.string.public_group_info_admin);
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == 0;
  }

  public String b()
  {
    return this.a.getString(R.string.public_group_info_add_me_as_admin);
  }

  public String b(int paramInt)
  {
    Context localContext = this.a;
    int i = R.string.public_group_info_participant_count_upper;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.toString(paramInt);
    return localContext.getString(i, arrayOfObject);
  }

  public boolean b(int paramInt1, int paramInt2)
  {
    return paramInt1 < paramInt2;
  }

  public boolean c()
  {
    return false;
  }

  public int d()
  {
    return R.drawable.add_participants_button;
  }

  public String e()
  {
    return null;
  }

  public int f()
  {
    return 1;
  }

  public boolean g()
  {
    return as.b(this.b);
  }

  public String h()
  {
    return null;
  }

  public boolean i()
  {
    return as.c(this.b);
  }

  public String j()
  {
    return this.a.getString(R.string.add_participants);
  }

  public int k()
  {
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.c
 * JD-Core Version:    0.6.2
 */