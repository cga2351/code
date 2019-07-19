package com.viber.voip.publicaccount.ui.holders.storage;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.a;

public class a extends com.viber.voip.publicaccount.ui.holders.b<ManageStorageUiData, PublicAccountEditUIHolder.a>
  implements View.OnClickListener
{
  private final a c;

  public a(a parama)
  {
    this.c = parama;
  }

  protected void a(PublicAccountEditUIHolder.a parama, ManageStorageUiData paramManageStorageUiData)
  {
  }

  protected PublicAccountEditUIHolder.a b(View paramView)
  {
    return new b(paramView, this);
  }

  protected Class<PublicAccountEditUIHolder.a> b()
  {
    return PublicAccountEditUIHolder.a.class;
  }

  protected ManageStorageUiData e()
  {
    return new ManageStorageUiData();
  }

  public void onClick(View paramView)
  {
    this.c.j();
  }

  public static abstract interface a
  {
    public abstract void j();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.storage.a
 * JD-Core Version:    0.6.2
 */