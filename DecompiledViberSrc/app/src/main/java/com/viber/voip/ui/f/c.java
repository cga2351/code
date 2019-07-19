package com.viber.voip.ui.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.bottomnavigation.a;
import java.util.List;

public class c
{
  private final ViberApplication a;
  private final b b = new b(null);
  private a[] c = new a[0];

  public c(ViberApplication paramViberApplication)
  {
    this.a = paramViberApplication;
  }

  public int a()
  {
    return this.c.length;
  }

  public void a(int paramInt)
  {
    Context localContext = this.a.getLocaleDataCache().a();
    this.c = ((a[])this.b.a(localContext, paramInt).toArray(new a[0]));
  }

  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c.length))
      return this.c[paramInt].a();
    return -1;
  }

  public a[] b()
  {
    return this.c;
  }

  public int c(int paramInt)
  {
    int i = 0;
    int j = this.c.length;
    while (i < j)
    {
      if (a.a(this.c[i]) == paramInt)
        return i;
      i++;
    }
    return -1;
  }

  private static class a
    implements a
  {
    private final int a;
    private final CharSequence b;
    private final Drawable c;

    a(int paramInt, CharSequence paramCharSequence, Drawable paramDrawable)
    {
      this.a = paramInt;
      this.b = paramCharSequence;
      this.c = paramDrawable;
    }

    public int a()
    {
      return this.a;
    }

    public CharSequence b()
    {
      return this.b;
    }

    public Drawable c()
    {
      return this.c;
    }

    public String toString()
    {
      return "HomeTabItem{, mTabId=" + this.a + ", mTitle='" + this.b + '\'' + ", mIcon=" + this.c + '}';
    }
  }

  private static class b extends com.viber.voip.ui.bottomnavigation.b<c.a>
  {
    private int a(int paramInt)
    {
      if (paramInt == R.id.navigation_chats)
        return 0;
      if (paramInt == R.id.navigation_contacts)
        return 1;
      if (paramInt == R.id.navigation_more)
        return 2;
      if (paramInt == R.id.navigation_news)
        return 3;
      return -1;
    }

    protected c.a b(MenuItem paramMenuItem)
    {
      int i = a(paramMenuItem.getItemId());
      if (i != -1)
        return new c.a(i, paramMenuItem.getTitle(), paramMenuItem.getIcon());
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.f.c
 * JD-Core Version:    0.6.2
 */