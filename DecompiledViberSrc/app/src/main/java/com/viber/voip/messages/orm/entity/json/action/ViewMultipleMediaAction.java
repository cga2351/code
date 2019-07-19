package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.ui.media.simple.SimpleMediaViewItem;
import com.viber.voip.util.ViberActionRunner.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewMultipleMediaAction extends Action
{
  public static final Parcelable.Creator<ViewMultipleMediaAction> CREATOR = new Parcelable.Creator()
  {
    public ViewMultipleMediaAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViewMultipleMediaAction(paramAnonymousParcel);
    }

    public ViewMultipleMediaAction[] newArray(int paramAnonymousInt)
    {
      return new ViewMultipleMediaAction[paramAnonymousInt];
    }
  };
  private final long mConversationId;
  private final int mFocusedItem;
  private final ArrayList<SimpleMediaViewItem> mViewItems;

  public ViewMultipleMediaAction(long paramLong, int paramInt, List<ViewMediaAction> paramList)
  {
    this.mConversationId = paramLong;
    this.mFocusedItem = paramInt;
    this.mViewItems = buildSimpleViewItems(paramList);
  }

  public ViewMultipleMediaAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mConversationId = paramParcel.readLong();
    this.mFocusedItem = paramParcel.readInt();
    this.mViewItems = new ArrayList();
    paramParcel.readTypedList(this.mViewItems, SimpleMediaViewItem.CREATOR);
  }

  private ArrayList<SimpleMediaViewItem> buildSimpleViewItems(List<ViewMediaAction> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ViewMediaAction localViewMediaAction = (ViewMediaAction)localIterator.next();
      if (localViewMediaAction != null)
      {
        String str = localViewMediaAction.buildMediaUrl();
        if (str != null)
          localArrayList.add(new SimpleMediaViewItem(str, localViewMediaAction.getMediaType()));
      }
    }
    return localArrayList;
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    super.execute(paramContext, paramExecuteListener);
    ViberActionRunner.bm.a(paramContext, this.mConversationId, this.mFocusedItem, this.mViewItems);
    if (paramExecuteListener != null)
      paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
  }

  public ActionType getType()
  {
    return null;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeInt(this.mFocusedItem);
    paramParcel.writeTypedList(this.mViewItems);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewMultipleMediaAction
 * JD-Core Version:    0.6.2
 */