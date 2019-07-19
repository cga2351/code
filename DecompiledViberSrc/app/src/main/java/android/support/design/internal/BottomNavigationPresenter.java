package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;

public class BottomNavigationPresenter
  implements o
{
  private h a;
  private c b;
  private boolean c = false;
  private int d;

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(c paramc)
  {
    this.b = paramc;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public int getId()
  {
    return this.d;
  }

  public void initForMenu(Context paramContext, h paramh)
  {
    this.a = paramh;
    this.b.initialize(this.a);
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
      this.b.b(((SavedState)paramParcelable).selectedItemId);
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.selectedItemId = this.b.getSelectedItemId();
    return localSavedState;
  }

  public boolean onSubMenuSelected(u paramu)
  {
    return false;
  }

  public void setCallback(o.a parama)
  {
  }

  public void updateMenuView(boolean paramBoolean)
  {
    if (this.c)
      return;
    if (paramBoolean)
    {
      this.b.b();
      return;
    }
    this.b.c();
  }

  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public BottomNavigationPresenter.SavedState a(Parcel paramAnonymousParcel)
      {
        return new BottomNavigationPresenter.SavedState(paramAnonymousParcel);
      }

      public BottomNavigationPresenter.SavedState[] a(int paramAnonymousInt)
      {
        return new BottomNavigationPresenter.SavedState[paramAnonymousInt];
      }
    };
    int selectedItemId;

    SavedState()
    {
    }

    SavedState(Parcel paramParcel)
    {
      this.selectedItemId = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.selectedItemId);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationPresenter
 * JD-Core Version:    0.6.2
 */