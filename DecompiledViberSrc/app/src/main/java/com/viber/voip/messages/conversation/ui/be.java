package com.viber.voip.messages.conversation.ui;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class be
{
  private final Handler a;
  private final List<Runnable> b = new LinkedList();
  private boolean c = true;

  public be(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  private void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      this.a.post(localRunnable);
    }
    this.b.clear();
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      if (this.c)
        a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.be
 * JD-Core Version:    0.6.2
 */