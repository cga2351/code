package com.viber.voip.messages.conversation.adapter.viewbinders.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;

public abstract class b
{
  private int a = 0;

  protected void a(Configuration paramConfiguration)
  {
  }

  protected void a(ConstraintLayout paramConstraintLayout, a parama)
  {
  }

  protected abstract boolean a();

  public final void b(Configuration paramConfiguration)
  {
    if (!a())
      return;
    this.a = paramConfiguration.orientation;
    a(paramConfiguration);
  }

  protected void b(ConstraintLayout paramConstraintLayout, a parama)
  {
  }

  protected void c(ConstraintLayout paramConstraintLayout, a parama)
  {
  }

  public final void d(ConstraintLayout paramConstraintLayout, a parama)
  {
    if (!a())
      return;
    Configuration localConfiguration = paramConstraintLayout.getContext().getResources().getConfiguration();
    if (localConfiguration.orientation != this.a)
    {
      this.a = localConfiguration.orientation;
      a(localConfiguration);
    }
    a(paramConstraintLayout, parama);
  }

  public final void e(ConstraintLayout paramConstraintLayout, a parama)
  {
    if (!a())
      return;
    b(paramConstraintLayout, parama);
  }

  public final void f(ConstraintLayout paramConstraintLayout, a parama)
  {
    if (!a())
      return;
    c(paramConstraintLayout, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
 * JD-Core Version:    0.6.2
 */