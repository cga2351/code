package com.viber.voip.gallery.selection;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.util.at;
import com.viber.voip.util.at.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GalleryMediaSelector
  implements Parcelable
{
  public static final Parcelable.Creator<GalleryMediaSelector> CREATOR = new Parcelable.Creator()
  {
    public GalleryMediaSelector a(Parcel paramAnonymousParcel)
    {
      return new GalleryMediaSelector(paramAnonymousParcel);
    }

    public GalleryMediaSelector[] a(int paramAnonymousInt)
    {
      return new GalleryMediaSelector[paramAnonymousInt];
    }
  };
  private final ArrayList<GalleryItem> mSelectedItems;
  private int mSelectionType;

  public GalleryMediaSelector()
  {
    this.mSelectedItems = new ArrayList();
    resetSelectionType();
  }

  protected GalleryMediaSelector(Parcel paramParcel)
  {
    this.mSelectedItems = paramParcel.createTypedArrayList(GalleryItem.CREATOR);
    this.mSelectionType = paramParcel.readInt();
  }

  public GalleryMediaSelector(List<GalleryItem> paramList)
  {
    if (paramList != null);
    for (ArrayList localArrayList = new ArrayList(paramList); ; localArrayList = new ArrayList())
    {
      this.mSelectedItems = localArrayList;
      if (!this.mSelectedItems.isEmpty())
        break;
      resetSelectionType();
      return;
    }
    this.mSelectionType = getSelectionType((GalleryItem)this.mSelectedItems.get(0));
  }

  private void addItemToSelection(GalleryItem paramGalleryItem, p paramp)
  {
    int i = getSelectionType(paramGalleryItem);
    if (this.mSelectionType == 0)
      this.mSelectionType = i;
    if ((this.mSelectionType == i) && (isSelectionAvailable(this.mSelectionType)))
    {
      this.mSelectedItems.add(paramGalleryItem);
      notifySelectionSucceed(paramGalleryItem, paramp);
      return;
    }
    notifySelectionError(paramGalleryItem, 1, paramp);
  }

  private int getMaxAvailableSelectionSize(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 2147483647;
    case 1:
      return 10;
    case 2:
    }
    return 1;
  }

  private int getSelectionType(GalleryItem paramGalleryItem)
  {
    if (paramGalleryItem.isVideo())
      return 2;
    return 1;
  }

  private void notifySelectionError(GalleryItem paramGalleryItem, int paramInt, p paramp)
  {
    paramp.a(paramGalleryItem, paramInt);
  }

  private void notifySelectionRemoved(GalleryItem paramGalleryItem, p paramp)
  {
    paramp.b(paramGalleryItem);
  }

  private void notifySelectionSucceed(GalleryItem paramGalleryItem, p paramp)
  {
    paramp.a(paramGalleryItem);
  }

  private void resetSelectionType()
  {
    this.mSelectionType = 0;
  }

  private void selectImage(GalleryItem paramGalleryItem, File paramFile, p paramp)
  {
    if ((paramFile == null) || (!paramFile.exists()))
    {
      notifySelectionError(paramGalleryItem, 0, paramp);
      return;
    }
    if ((paramGalleryItem.isGif()) && (paramFile.length() > 25165824L))
    {
      notifySelectionError(paramGalleryItem, 2, paramp);
      return;
    }
    addItemToSelection(paramGalleryItem, paramp);
  }

  private void selectVideo(final GalleryItem paramGalleryItem, File paramFile, FragmentActivity paramFragmentActivity, final p paramp)
  {
    final Uri localUri = Uri.fromFile(paramFile);
    at.a(paramFragmentActivity, localUri, true, new at.b()
    {
      public void a(Map<String, Boolean> paramAnonymousMap)
      {
        if (paramAnonymousMap.size() == 1)
        {
          if (((Boolean)paramAnonymousMap.get(localUri.getPath())).booleanValue())
          {
            GalleryMediaSelector.this.addItemToSelection(paramGalleryItem, paramp);
            return;
          }
          GalleryMediaSelector.this.notifySelectionError(paramGalleryItem, 3, paramp);
          return;
        }
        GalleryMediaSelector.this.notifySelectionError(paramGalleryItem, 4, paramp);
      }
    });
  }

  public void clearSelection()
  {
    this.mSelectedItems.clear();
    resetSelectionType();
  }

  public int describeContents()
  {
    return 0;
  }

  public void deselect(GalleryItem paramGalleryItem, p paramp)
  {
    this.mSelectedItems.remove(paramGalleryItem);
    if (paramp != null)
      notifySelectionRemoved(paramGalleryItem, paramp);
    if (this.mSelectedItems.isEmpty())
      resetSelectionType();
  }

  public List<GalleryItem> getSelection()
  {
    return Collections.unmodifiableList(this.mSelectedItems);
  }

  public boolean isSelected(GalleryItem paramGalleryItem)
  {
    return (!isSelectionEmpty()) && (this.mSelectedItems.contains(paramGalleryItem));
  }

  public boolean isSelectionAvailable(int paramInt)
  {
    return (isSelectionEmpty()) || ((this.mSelectionType == paramInt) && (this.mSelectedItems.size() < getMaxAvailableSelectionSize(this.mSelectionType)));
  }

  public boolean isSelectionEmpty()
  {
    return this.mSelectedItems.isEmpty();
  }

  public void select(GalleryItem paramGalleryItem, FragmentActivity paramFragmentActivity, p paramp)
  {
    if (this.mSelectedItems.contains(paramGalleryItem))
    {
      notifySelectionSucceed(paramGalleryItem, paramp);
      return;
    }
    if ((this.mSelectionType != 0) && (this.mSelectionType != getSelectionType(paramGalleryItem)))
    {
      notifySelectionError(paramGalleryItem, 1, paramp);
      return;
    }
    if (this.mSelectedItems.size() >= getMaxAvailableSelectionSize(this.mSelectionType))
    {
      notifySelectionError(paramGalleryItem, 5, paramp);
      return;
    }
    File localFile = at.a(paramFragmentActivity, paramGalleryItem.getOriginalUri());
    if (localFile == null)
    {
      notifySelectionError(paramGalleryItem, 0, paramp);
      return;
    }
    if (paramGalleryItem.isVideo())
    {
      selectVideo(paramGalleryItem, localFile, paramFragmentActivity, paramp);
      return;
    }
    selectImage(paramGalleryItem, localFile, paramp);
  }

  public int selectionSize()
  {
    return this.mSelectedItems.size();
  }

  public void swapSelection(List<GalleryItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mSelectedItems.clear();
      this.mSelectedItems.addAll(paramList);
      this.mSelectionType = getSelectionType((GalleryItem)this.mSelectedItems.get(0));
      return;
    }
    clearSelection();
  }

  public void toggleItemSelection(GalleryItem paramGalleryItem, FragmentActivity paramFragmentActivity, p paramp)
  {
    if (isSelected(paramGalleryItem))
    {
      deselect(paramGalleryItem, paramp);
      return;
    }
    select(paramGalleryItem, paramFragmentActivity, paramp);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.mSelectedItems);
    paramParcel.writeInt(this.mSelectionType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.GalleryMediaSelector
 * JD-Core Version:    0.6.2
 */