package com.viber.voip.messages.ui;

import android.os.Bundle;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;

public class j extends bk
{
  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramConversationItemLoaderEntity != null))
    {
      a(this);
      a(this, paramConversationItemLoaderEntity, true);
    }
  }

  protected boolean d()
  {
    return false;
  }

  protected void f()
  {
  }

  protected void h()
  {
  }

  protected void i()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    this.Q = false;
    super.onCreate(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.j
 * JD-Core Version:    0.6.2
 */