package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u extends h
  implements SubMenu
{
  private h d;
  private j e;

  public u(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    this.d = paramh;
    this.e = paramj;
  }

  public String a()
  {
    if (this.e != null);
    for (int i = this.e.getItemId(); i == 0; i = 0)
      return null;
    return super.a() + ":" + i;
  }

  public void a(h.a parama)
  {
    this.d.a(parama);
  }

  boolean a(h paramh, MenuItem paramMenuItem)
  {
    return (super.a(paramh, paramMenuItem)) || (this.d.a(paramh, paramMenuItem));
  }

  public boolean b()
  {
    return this.d.b();
  }

  public boolean c()
  {
    return this.d.c();
  }

  public boolean c(j paramj)
  {
    return this.d.c(paramj);
  }

  public boolean d()
  {
    return this.d.d();
  }

  public boolean d(j paramj)
  {
    return this.d.d(paramj);
  }

  public MenuItem getItem()
  {
    return this.e;
  }

  public h q()
  {
    return this.d.q();
  }

  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.d.setGroupDividerEnabled(paramBoolean);
  }

  public SubMenu setHeaderIcon(int paramInt)
  {
    return (SubMenu)super.e(paramInt);
  }

  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    return (SubMenu)super.a(paramDrawable);
  }

  public SubMenu setHeaderTitle(int paramInt)
  {
    return (SubMenu)super.d(paramInt);
  }

  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    return (SubMenu)super.a(paramCharSequence);
  }

  public SubMenu setHeaderView(View paramView)
  {
    return (SubMenu)super.a(paramView);
  }

  public SubMenu setIcon(int paramInt)
  {
    this.e.setIcon(paramInt);
    return this;
  }

  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.e.setIcon(paramDrawable);
    return this;
  }

  public void setQwertyMode(boolean paramBoolean)
  {
    this.d.setQwertyMode(paramBoolean);
  }

  public Menu t()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.u
 * JD-Core Version:    0.6.2
 */