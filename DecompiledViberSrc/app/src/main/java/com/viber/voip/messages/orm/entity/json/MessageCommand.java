package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.ActionFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageCommand
  implements Parcelable
{
  public static final Parcelable.Creator<MessageCommand> CREATOR = new Parcelable.Creator()
  {
    public MessageCommand createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MessageCommand(paramAnonymousParcel);
    }

    public MessageCommand[] newArray(int paramAnonymousInt)
    {
      return new MessageCommand[paramAnonymousInt];
    }
  };
  private static final String KEY_COMMANDS = "Commands";
  private List<Action> mCommands;

  MessageCommand(Parcel paramParcel)
  {
    ClassLoader localClassLoader = MessageCommand.class.getClassLoader();
    int j = paramParcel.readInt();
    if (j < 0);
    for (int k = 0; ; k = j)
    {
      this.mCommands = new ArrayList(k);
      while (i < j)
      {
        this.mCommands.add((Action)paramParcel.readParcelable(localClassLoader));
        i++;
      }
    }
  }

  public MessageCommand(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("Commands");
    int j;
    label36: Action localAction;
    if (localJSONArray != null)
    {
      j = localJSONArray.length();
      this.mCommands = new ArrayList(j);
      if (i >= j)
        return;
      localAction = ActionFactory.createAction(localJSONArray.getJSONObject(i));
      if (localAction != null)
        break label69;
    }
    while (true)
    {
      i++;
      break label36;
      j = 0;
      break;
      label69: this.mCommands.add(localAction);
    }
  }

  boolean canDoAction(ActionType paramActionType)
  {
    return getAction(paramActionType) != null;
  }

  public int describeContents()
  {
    return 0;
  }

  <T extends Action> T getAction(ActionType paramActionType)
  {
    int i = this.mCommands.size();
    for (int j = 0; j < i; j++)
    {
      Action localAction = (Action)this.mCommands.get(j);
      if (localAction.getType() == paramActionType)
        return localAction;
    }
    return null;
  }

  public List<Action> getCommands()
  {
    return this.mCommands;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mCommands.size());
    int i = this.mCommands.size();
    for (int j = 0; j < i; j++)
      paramParcel.writeParcelable((Action)this.mCommands.get(j), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.MessageCommand
 * JD-Core Version:    0.6.2
 */