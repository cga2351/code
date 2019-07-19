package com.viber.voip.user;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import com.viber.voip.R.dimen;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.extras.c.a;
import com.viber.voip.util.dj;
import java.util.ArrayList;

public class PhotoActionPopup
{
  public static ListPopupWindow createPopupMenu(Context paramContext, View paramView, final Listener paramListener, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(4);
    int k;
    String str3;
    if ((paramInt & 0x20) > 0)
    {
      if (TextUtils.isEmpty(UserManager.from(paramContext).getUserData().getViberName()))
      {
        k = R.string.menu_add_your_name;
        localArrayList.add(new ChoiceListItem(4, paramContext.getString(k)));
      }
    }
    else if ((paramInt & 0x4) > 0)
    {
      str3 = paramContext.getString(R.string.user_menu_take_new_pic);
      if (!TextUtils.isEmpty(UserManager.from(paramContext).getUserData().getViberImage()))
        break label449;
    }
    label449: for (int j = R.string.user_menu_select_pic; ; j = R.string.user_menu_pick_new_photo)
    {
      String str4 = paramContext.getString(j);
      localArrayList.add(new ChoiceListItem(1, str3));
      localArrayList.add(new ChoiceListItem(2, str4));
      if ((paramInt & 0x8) > 0)
      {
        String str1 = paramContext.getString(R.string.options_take_photo);
        String str2 = paramContext.getString(R.string.user_menu_select_pic);
        localArrayList.add(new ChoiceListItem(6, str1));
        localArrayList.add(new ChoiceListItem(7, str2));
      }
      if ((paramInt & 0x10) > 0)
        localArrayList.add(new ChoiceListItem(5, paramContext.getString(R.string.btn_import_from_facebook)));
      if (((paramInt & 0x80) > 0) && (a.d()))
        localArrayList.add(new ChoiceListItem(9, paramContext.getString(R.string.btn_import_from_vk)));
      if ((paramInt & 0x2) > 0)
        localArrayList.add(new ChoiceListItem(3, paramContext.getString(R.string.user_menu_remove_pic)));
      if ((paramInt & 0x40) > 0)
        localArrayList.add(new ChoiceListItem(8, paramContext.getString(R.string.user_menu_remove_pic)));
      ArrayAdapter localArrayAdapter = new ArrayAdapter(paramContext, R.layout.select_dialog_item, localArrayList);
      final ListPopupWindow localListPopupWindow = new ListPopupWindow(paramContext);
      AdapterView.OnItemClickListener local1 = new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          switch (((PhotoActionPopup.ChoiceListItem)this.val$choices.get(paramAnonymousInt)).getId())
          {
          default:
          case 0:
          case 3:
          case 1:
          case 2:
          case 4:
          case 5:
          case 9:
          case 8:
          case 7:
          case 6:
          }
          while (true)
          {
            localListPopupWindow.dismiss();
            return;
            paramListener.onUseAsPrimaryChosen();
            continue;
            paramListener.onRemovePictureChosen();
            continue;
            paramListener.onTakePhotoChosen();
            continue;
            paramListener.onPickFromGalleryChosen();
            continue;
            paramListener.onEditName();
            continue;
            paramListener.onImportFromFB();
            continue;
            paramListener.onImportFromVK();
            continue;
            paramListener.onRemovePhoto();
            continue;
            paramListener.onChoosePhoto();
            continue;
            paramListener.onTakePhoto();
          }
        }
      };
      localListPopupWindow.setAnchorView(paramView);
      localListPopupWindow.setAdapter(localArrayAdapter);
      localListPopupWindow.setOnItemClickListener(local1);
      localListPopupWindow.setModal(true);
      localListPopupWindow.setInputMethodMode(2);
      int i = paramContext.getResources().getDimensionPixelSize(R.dimen.photo_action_popup_min_width);
      if (paramView.getWidth() < i)
        localListPopupWindow.setWidth(i);
      if (dj.c(paramContext))
      {
        localListPopupWindow.setHorizontalOffset(paramView.getWidth());
        localListPopupWindow.setVerticalOffset(-paramView.getWidth());
      }
      return localListPopupWindow;
      k = R.string.menu_edit_your_name;
      break;
    }
  }

  private static final class ChoiceListItem
  {
    public static final int ID_CHOOSE_PHOTO = 7;
    public static final int ID_EDIT_NAME = 4;
    public static final int ID_IMPORT_FROM_FACEBOOK = 5;
    public static final int ID_IMPORT_FROM_VK = 9;
    public static final int ID_PICK_PHOTO = 2;
    public static final int ID_REMOVE = 3;
    public static final int ID_REMOVE_PHOTO = 8;
    public static final int ID_TAKE_PHOTO = 1;
    public static final int ID_TAKE_PHOTO_FROM_CAMERA = 6;
    public static final int ID_USE_AS_PRIMARY;
    private final String mCaption;
    private final int mId;

    public ChoiceListItem(int paramInt, String paramString)
    {
      this.mId = paramInt;
      this.mCaption = paramString;
    }

    public int getId()
    {
      return this.mId;
    }

    public String toString()
    {
      return this.mCaption;
    }
  }

  public static final class Flags
  {
    public static final int CHANGE_NAME = 32;
    public static final int LOAD_FROM_FACEBOOK_PHOTO = 16;
    public static final int LOAD_FROM_VK_PHOTO = 128;
    public static final int REMOVE_PHOTO = 2;
    public static final int REMOVE_PHOTO_WITHOUT_DIALOG = 64;
    public static final int TAKE_OR_CHOOSE_PHOTO = 8;
    public static final int TAKE_OR_PICK_PHOTO = 4;
  }

  public static abstract interface Listener
  {
    public abstract void onChoosePhoto();

    public abstract void onEditName();

    public abstract void onImportFromFB();

    public abstract void onImportFromVK();

    public abstract void onPickFromGalleryChosen();

    public abstract void onRemovePhoto();

    public abstract void onRemovePictureChosen();

    public abstract void onTakePhoto();

    public abstract void onTakePhotoChosen();

    public abstract void onUseAsPrimaryChosen();
  }

  public static final class Modes
  {
    public static final int ADD_YOUR_PHOTO_MODE = 180;
    public static final int CHANGE_YOUR_PHOTO_MODE = 182;
    public static final int GROUP_ICON_MODE = 72;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.PhotoActionPopup
 * JD-Core Version:    0.6.2
 */