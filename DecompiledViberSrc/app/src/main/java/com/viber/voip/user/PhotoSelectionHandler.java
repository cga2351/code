package com.viber.voip.user;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class PhotoSelectionHandler
  implements View.OnClickListener
{
  private static final Logger L = ViberEnv.getLogger();
  protected final Context mContext;
  private final int mPhotoMode;
  private final View mPhotoView;
  private ListPopupWindow mPopup;

  public PhotoSelectionHandler(Context paramContext, View paramView, int paramInt)
  {
    this.mContext = paramContext;
    this.mPhotoView = paramView;
    this.mPhotoMode = paramInt;
  }

  private void showPhotoSelectPopup()
  {
    final PhotoActionListener localPhotoActionListener = getListener();
    if (localPhotoActionListener != null)
    {
      this.mPopup = PhotoActionPopup.createPopupMenu(this.mContext, this.mPhotoView, localPhotoActionListener, this.mPhotoMode);
      this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss()
        {
          localPhotoActionListener.onPhotoSelectionDismissed();
        }
      });
      this.mPopup.show();
    }
  }

  public void destroy()
  {
    if (this.mPopup != null)
      this.mPopup.dismiss();
  }

  public abstract PhotoActionListener getListener();

  public void onClick(View paramView)
  {
    showPhotoSelectPopup();
  }

  public abstract class PhotoActionListener
    implements PhotoActionPopup.Listener
  {
    public PhotoActionListener()
    {
    }

    public abstract void onPhotoSelectionDismissed();

    public void onPickFromGalleryChosen()
    {
    }

    public void onRemovePictureChosen()
    {
    }

    public void onTakePhotoChosen()
    {
    }

    public void onUseAsPrimaryChosen()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.PhotoSelectionHandler
 * JD-Core Version:    0.6.2
 */