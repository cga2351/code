package com.viber.voip.messages.conversation.adapter.viewbinders.helpers;

import android.view.View;
import android.view.ViewStub;

public class e<T extends View>
{
  private final int a;
  private final ViewStub b;
  private final e c;
  private T d;

  public e(ViewStub paramViewStub)
  {
    this.b = paramViewStub;
    this.c = null;
    this.a = -1;
  }

  public e(e parame, int paramInt)
  {
    this.b = null;
    this.c = parame;
    this.a = paramInt;
  }

  public boolean a()
  {
    return this.d != null;
  }

  public T b()
  {
    if (a())
      return this.d;
    if ((this.a == -1) && (this.b != null));
    for (this.d = this.b.inflate(); ; this.d = this.c.b().findViewById(this.a))
      do
        return this.d;
      while ((this.a == -1) || (this.c == null));
  }

  public T c()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e
 * JD-Core Version:    0.6.2
 */