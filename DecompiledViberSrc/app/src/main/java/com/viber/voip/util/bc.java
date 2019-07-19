package com.viber.voip.util;

import android.content.Context;
import android.support.v7.app.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.ac;

public class bc
{
  private static final Logger b = ViberEnv.getLogger();
  public boolean a = false;
  private a c;
  private boolean d;
  private View e;
  private View f;

  public bc(Context paramContext, a parama, LayoutInflater paramLayoutInflater)
  {
    this.c = parama;
    this.d = dj.c(paramContext);
    this.e = dj.a(paramContext, paramLayoutInflater);
    this.f = this.e.findViewById(R.id.abs__up);
    this.c.a(this.e);
    this.c.d(true);
    this.c.e(false);
    this.c.b(false);
    this.c.c(false);
  }

  public void a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default:
    case 0:
      do
        return;
      while (this.a);
      b(bool, false);
      View localView = this.e;
      if (!this.d);
      while (true)
      {
        dj.d(localView, bool);
        return;
        bool = false;
      }
    case 1:
    case 2:
    }
    b(false, false);
    this.c.c(false);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    if ((this.e != null) && (!this.d))
      this.e.setOnClickListener(paramOnClickListener);
  }

  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }

  public void a(boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence));
    for (boolean bool = true; ; bool = false)
    {
      this.c.c(bool);
      this.c.b(paramBoolean);
      this.c.a(paramCharSequence);
      return;
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, ac.a);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    boolean bool;
    View localView;
    int i;
    if ((paramBoolean2) && (paramInt == 0))
    {
      bool = true;
      b(bool, paramBoolean1);
      localView = this.f;
      i = 0;
      if (!paramBoolean1)
        break label45;
    }
    while (true)
    {
      localView.setVisibility(i);
      return;
      bool = false;
      break;
      label45: i = 8;
    }
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    boolean bool2;
    int i;
    label22: a locala;
    if (!paramBoolean1)
    {
      bool2 = bool1;
      View localView = this.e;
      if (!paramBoolean1)
        break label66;
      i = 0;
      localView.setVisibility(i);
      this.c.c(bool2);
      locala = this.c;
      if ((!bool2) || (!paramBoolean2))
        break label73;
    }
    while (true)
    {
      locala.b(bool1);
      return;
      bool2 = false;
      break;
      label66: i = 8;
      break label22;
      label73: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bc
 * JD-Core Version:    0.6.2
 */