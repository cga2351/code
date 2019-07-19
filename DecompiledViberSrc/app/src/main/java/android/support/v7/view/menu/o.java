package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public abstract interface o
{
  public abstract boolean collapseItemActionView(h paramh, j paramj);

  public abstract boolean expandItemActionView(h paramh, j paramj);

  public abstract boolean flagActionItems();

  public abstract int getId();

  public abstract void initForMenu(Context paramContext, h paramh);

  public abstract void onCloseMenu(h paramh, boolean paramBoolean);

  public abstract void onRestoreInstanceState(Parcelable paramParcelable);

  public abstract Parcelable onSaveInstanceState();

  public abstract boolean onSubMenuSelected(u paramu);

  public abstract void setCallback(a parama);

  public abstract void updateMenuView(boolean paramBoolean);

  public static abstract interface a
  {
    public abstract void onCloseMenu(h paramh, boolean paramBoolean);

    public abstract boolean onOpenSubMenu(h paramh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.o
 * JD-Core Version:    0.6.2
 */