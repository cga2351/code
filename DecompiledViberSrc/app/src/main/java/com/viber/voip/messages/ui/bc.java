package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.permission.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ui.j;

public abstract class bc
{
  protected Activity a;
  protected ContextMenu b;
  protected SparseArray<b> c;
  protected ai d;
  protected be e;
  protected final c f;
  private final j g;

  protected bc(Activity paramActivity, ContextMenu paramContextMenu, int paramInt, j paramj)
  {
    this.a = paramActivity;
    this.g = paramj;
    this.f = c.a(paramActivity);
    this.b = paramContextMenu;
    this.c = new SparseArray();
    this.d = new ai(this.a);
    this.e = new be(paramActivity);
    this.e.d(paramInt);
  }

  protected View a()
  {
    bd localbd = (bd)this.e.a();
    View localView = LayoutInflater.from(this.a).inflate(R.layout.context_menu_header, null);
    localView.setBackgroundColor(localbd.a());
    ImageViewCompat.setImageTintList((ImageView)localView.findViewById(R.id.icon), ColorStateList.valueOf(localbd.c()));
    TextView localTextView = (TextView)localView.findViewById(R.id.text);
    localTextView.setTextColor(localbd.b());
    localTextView.setLayerType(1, null);
    this.b.setHeaderView(localView);
    return localView;
  }

  protected void a(int paramInt, b paramb)
  {
    if (paramb != null)
      paramb.a();
    this.c.put(paramInt, paramb);
  }

  public void a(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      int i = ((Integer)paramObject).intValue();
      b localb = (b)this.c.get(i);
      if (((localb instanceof c)) && (paramInt == ((c)localb).c()))
        localb.a(this.g);
    }
  }

  protected void a(int[] paramArrayOfInt, b paramb)
  {
    if (paramb != null)
      paramb.a();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      this.c.put(k, paramb);
    }
  }

  public boolean a(int paramInt)
  {
    b localb = (b)this.c.get(paramInt);
    if (localb != null)
    {
      c localc;
      if ((localb instanceof c))
      {
        localc = (c)localb;
        if (this.f.a(localc.b()))
          localb.a(this.g);
      }
      while (true)
      {
        return true;
        this.f.a(this.a, localc.c(), localc.b(), Integer.valueOf(paramInt));
        continue;
        if ((localb instanceof a))
          ((a)localb).a(this.g, paramInt);
        else
          localb.a(this.g);
      }
    }
    return false;
  }

  public void c()
  {
    this.b.close();
  }

  protected static abstract interface a extends bc.b
  {
    public abstract void a(j paramj, int paramInt);
  }

  protected static abstract interface b
  {
    public abstract void a();

    public abstract void a(j paramj);
  }

  protected static abstract interface c extends bc.b
  {
    public abstract String[] b();

    public abstract int c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bc
 * JD-Core Version:    0.6.2
 */