package com.viber.voip.messages.ui.popup.a;

import android.app.Activity;
import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.z;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import java.util.Iterator;
import java.util.List;

public abstract class g
{
  private Activity a;
  private z b;
  private boolean c;

  public g(Activity paramActivity, z paramz, boolean paramBoolean)
  {
    a(paramActivity);
    a(paramz);
    this.c = paramBoolean;
  }

  protected int a(int paramInt)
  {
    if (this.b != null);
    for (aa localaa = this.b.f(paramInt); localaa == null; localaa = null)
      return 1;
    if ((localaa.aY()) || (localaa.aZ()))
      return 1;
    if (localaa.aE())
    {
      Iterator localIterator = localaa.L().getMessage().iterator();
      while (localIterator.hasNext())
      {
        BaseMessage localBaseMessage = (BaseMessage)localIterator.next();
        if ((MessageType.IMAGE == localBaseMessage.getType()) || (MessageType.VIDEO == localBaseMessage.getType()) || (MessageType.GIF == localBaseMessage.getType()))
          return 2;
      }
      return 1;
    }
    return 2;
  }

  public abstract View a(View paramView, int paramInt);

  public void a(int paramInt, boolean paramBoolean)
  {
  }

  protected void a(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  protected void a(z paramz)
  {
    this.b = paramz;
  }

  public abstract boolean a();

  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }

  public abstract int b();

  public int b(int paramInt)
  {
    return -1;
  }

  public int c(int paramInt)
  {
    return -1;
  }

  public z f()
  {
    return this.b;
  }

  public Activity g()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.g
 * JD-Core Version:    0.6.2
 */