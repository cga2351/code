package com.viber.voip.user.more;

import android.net.Uri;
import com.viber.voip.mvp.core.j;
import com.viber.voip.settings.a.a;
import java.util.List;

abstract interface MoreView extends j, MorePermissionHelper, MoreRouter
{
  public abstract void adjustTopBar();

  public abstract void bindNotificationBanner();

  public abstract void setEditMenuItemVisibility(boolean paramBoolean);

  public abstract void setItems(List<a> paramList);

  public abstract void setUserName(CharSequence paramCharSequence);

  public abstract void setUserPhoneNumber(CharSequence paramCharSequence);

  public abstract void setUserPhoto(Uri paramUri);

  public abstract void updateViberOutBalanceText(CharSequence paramCharSequence);

  public abstract void updateVisibleItem(int paramInt);

  public abstract void updateVisibleItems();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreView
 * JD-Core Version:    0.6.2
 */