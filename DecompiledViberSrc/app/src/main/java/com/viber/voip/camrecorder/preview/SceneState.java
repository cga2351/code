package com.viber.voip.camrecorder.preview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.List;

class SceneState
  implements Parcelable
{
  public static final Parcelable.Creator<SceneState> CREATOR = new Parcelable.Creator()
  {
    public SceneState a(Parcel paramAnonymousParcel)
    {
      return new SceneState(paramAnonymousParcel, null);
    }

    public SceneState[] a(int paramAnonymousInt)
    {
      return new SceneState[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private int mSceneHashCode;
  private final List<Integer> mSceneSavedHashCodes = new ArrayList(20);

  SceneState()
  {
    this.mSceneHashCode = 0;
  }

  private SceneState(Parcel paramParcel)
  {
    this.mSceneHashCode = paramParcel.readInt();
    paramParcel.readList(this.mSceneSavedHashCodes, Integer.class.getClassLoader());
  }

  public int describeContents()
  {
    return 0;
  }

  boolean hasData()
  {
    return this.mSceneHashCode != 0;
  }

  public int hashCode()
  {
    return this.mSceneHashCode;
  }

  boolean isSaved()
  {
    return (!hasData()) || (this.mSceneSavedHashCodes.contains(Integer.valueOf(this.mSceneHashCode)));
  }

  void onSave()
  {
    if (!this.mSceneSavedHashCodes.contains(Integer.valueOf(this.mSceneHashCode)))
      this.mSceneSavedHashCodes.add(Integer.valueOf(this.mSceneHashCode));
  }

  public String toString()
  {
    return "SceneState{mSceneHashCode=" + this.mSceneHashCode + ", mSceneSavedHashCodes=" + this.mSceneSavedHashCodes + '}';
  }

  void update(int paramInt)
  {
    this.mSceneHashCode = paramInt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mSceneHashCode);
    paramParcel.writeList(this.mSceneSavedHashCodes);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.SceneState
 * JD-Core Version:    0.6.2
 */