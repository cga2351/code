package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mixpanel.android.b.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class UpdateDisplayState
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateDisplayState> CREATOR = new Parcelable.Creator()
  {
    public UpdateDisplayState a(Parcel paramAnonymousParcel)
    {
      Bundle localBundle = new Bundle(UpdateDisplayState.class.getClassLoader());
      localBundle.readFromParcel(paramAnonymousParcel);
      return new UpdateDisplayState(localBundle, null);
    }

    public UpdateDisplayState[] a(int paramAnonymousInt)
    {
      return new UpdateDisplayState[paramAnonymousInt];
    }
  };
  private static final String DISPLAYSTATE_BUNDLE_KEY = "com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY";
  private static final String DISTINCT_ID_BUNDLE_KEY = "com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY";
  private static final String LOGTAG = "MixpanelAPI.UpDisplSt";
  private static final long MAX_LOCK_TIME_MILLIS = 43200000L;
  private static final String TOKEN_BUNDLE_KEY = "com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY";
  private static int sNextIntentId = 0;
  private static int sShowingIntentId = -1;
  private static final ReentrantLock sUpdateDisplayLock = new ReentrantLock();
  private static long sUpdateDisplayLockMillis = -1L;
  private static UpdateDisplayState sUpdateDisplayState = null;
  private final DisplayState mDisplayState;
  private final String mDistinctId;
  private final String mToken;

  private UpdateDisplayState(Bundle paramBundle)
  {
    this.mDistinctId = paramBundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
    this.mToken = paramBundle.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
    this.mDisplayState = ((DisplayState)paramBundle.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY"));
  }

  UpdateDisplayState(DisplayState paramDisplayState, String paramString1, String paramString2)
  {
    this.mDistinctId = paramString1;
    this.mToken = paramString2;
    this.mDisplayState = paramDisplayState;
  }

  public static UpdateDisplayState claimDisplayState(int paramInt)
  {
    sUpdateDisplayLock.lock();
    try
    {
      if (sShowingIntentId > 0)
      {
        int i = sShowingIntentId;
        if (i != paramInt)
          return null;
      }
      UpdateDisplayState localUpdateDisplayState1 = sUpdateDisplayState;
      if (localUpdateDisplayState1 == null)
        return null;
      sUpdateDisplayLockMillis = System.currentTimeMillis();
      sShowingIntentId = paramInt;
      UpdateDisplayState localUpdateDisplayState2 = sUpdateDisplayState;
      return localUpdateDisplayState2;
    }
    finally
    {
      sUpdateDisplayLock.unlock();
    }
  }

  static ReentrantLock getLockObject()
  {
    return sUpdateDisplayLock;
  }

  static boolean hasCurrentProposal()
  {
    if (!sUpdateDisplayLock.isHeldByCurrentThread())
      throw new AssertionError();
    long l = System.currentTimeMillis() - sUpdateDisplayLockMillis;
    if ((sNextIntentId > 0) && (l > 43200000L))
    {
      f.c("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
      sUpdateDisplayState = null;
    }
    return sUpdateDisplayState != null;
  }

  static int proposeDisplay(DisplayState paramDisplayState, String paramString1, String paramString2)
  {
    if (!sUpdateDisplayLock.isHeldByCurrentThread())
      throw new AssertionError();
    if (!hasCurrentProposal())
    {
      sUpdateDisplayLockMillis = System.currentTimeMillis();
      sUpdateDisplayState = new UpdateDisplayState(paramDisplayState, paramString1, paramString2);
      sNextIntentId = 1 + sNextIntentId;
      return sNextIntentId;
    }
    f.a("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
    return -1;
  }

  public static void releaseDisplayState(int paramInt)
  {
    sUpdateDisplayLock.lock();
    try
    {
      if (paramInt == sShowingIntentId)
      {
        sShowingIntentId = -1;
        sUpdateDisplayState = null;
      }
      return;
    }
    finally
    {
      sUpdateDisplayLock.unlock();
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public DisplayState getDisplayState()
  {
    return this.mDisplayState;
  }

  public String getDistinctId()
  {
    return this.mDistinctId;
  }

  public String getToken()
  {
    return this.mToken;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.mDistinctId);
    localBundle.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.mToken);
    localBundle.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.mDisplayState);
    paramParcel.writeBundle(localBundle);
  }

  public static class AnswerMap
    implements Parcelable
  {
    public static final Parcelable.Creator<AnswerMap> CREATOR = new Parcelable.Creator()
    {
      public UpdateDisplayState.AnswerMap a(Parcel paramAnonymousParcel)
      {
        Bundle localBundle = new Bundle(UpdateDisplayState.AnswerMap.class.getClassLoader());
        UpdateDisplayState.AnswerMap localAnswerMap = new UpdateDisplayState.AnswerMap();
        localBundle.readFromParcel(paramAnonymousParcel);
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localAnswerMap.put(Integer.valueOf(str), localBundle.getString(str));
        }
        return localAnswerMap;
      }

      public UpdateDisplayState.AnswerMap[] a(int paramAnonymousInt)
      {
        return new UpdateDisplayState.AnswerMap[paramAnonymousInt];
      }
    };
    private final HashMap<Integer, String> mMap = new HashMap();

    public boolean contentEquals(AnswerMap paramAnswerMap)
    {
      return this.mMap.equals(paramAnswerMap.mMap);
    }

    public int describeContents()
    {
      return 0;
    }

    public String get(Integer paramInteger)
    {
      return (String)this.mMap.get(paramInteger);
    }

    public void put(Integer paramInteger, String paramString)
    {
      this.mMap.put(paramInteger, paramString);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Bundle localBundle = new Bundle();
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBundle.putString(Integer.toString(((Integer)localEntry.getKey()).intValue()), (String)localEntry.getValue());
      }
      paramParcel.writeBundle(localBundle);
    }
  }

  public static abstract class DisplayState
    implements Parcelable
  {
    public static final Parcelable.Creator<DisplayState> CREATOR = new Parcelable.Creator()
    {
      public UpdateDisplayState.DisplayState a(Parcel paramAnonymousParcel)
      {
        Bundle localBundle1 = new Bundle(UpdateDisplayState.DisplayState.class.getClassLoader());
        localBundle1.readFromParcel(paramAnonymousParcel);
        String str = localBundle1.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
        Bundle localBundle2 = localBundle1.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
        if ("InAppNotificationState".equals(str))
          return new UpdateDisplayState.DisplayState.InAppNotificationState(localBundle2, null);
        throw new RuntimeException("Unrecognized display state type " + str);
      }

      public UpdateDisplayState.DisplayState[] a(int paramAnonymousInt)
      {
        return new UpdateDisplayState.DisplayState[paramAnonymousInt];
      }
    };
    public static final String STATE_IMPL_KEY = "com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY";
    public static final String STATE_TYPE_KEY = "com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY";

    public abstract String getType();

    public static final class InAppNotificationState extends UpdateDisplayState.DisplayState
    {
      public static final Parcelable.Creator<InAppNotificationState> CREATOR = new Parcelable.Creator()
      {
        public UpdateDisplayState.DisplayState.InAppNotificationState a(Parcel paramAnonymousParcel)
        {
          Bundle localBundle = new Bundle(UpdateDisplayState.DisplayState.InAppNotificationState.class.getClassLoader());
          localBundle.readFromParcel(paramAnonymousParcel);
          return new UpdateDisplayState.DisplayState.InAppNotificationState(localBundle, null);
        }

        public UpdateDisplayState.DisplayState.InAppNotificationState[] a(int paramAnonymousInt)
        {
          return new UpdateDisplayState.DisplayState.InAppNotificationState[paramAnonymousInt];
        }
      };
      private static String HIGHLIGHT_KEY = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
      private static String INAPP_KEY = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
      public static final String TYPE = "InAppNotificationState";
      private final int mHighlightColor;
      private final InAppNotification mInAppNotification;

      private InAppNotificationState(Bundle paramBundle)
      {
        super();
        this.mInAppNotification = ((InAppNotification)paramBundle.getParcelable(INAPP_KEY));
        this.mHighlightColor = paramBundle.getInt(HIGHLIGHT_KEY);
      }

      public InAppNotificationState(InAppNotification paramInAppNotification, int paramInt)
      {
        super();
        this.mInAppNotification = paramInAppNotification;
        this.mHighlightColor = paramInt;
      }

      public int describeContents()
      {
        return 0;
      }

      public int getHighlightColor()
      {
        return this.mHighlightColor;
      }

      public InAppNotification getInAppNotification()
      {
        return this.mInAppNotification;
      }

      public String getType()
      {
        return "InAppNotificationState";
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable(INAPP_KEY, this.mInAppNotification);
        localBundle.putInt(HIGHLIGHT_KEY, this.mHighlightColor);
        paramParcel.writeBundle(localBundle);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.UpdateDisplayState
 * JD-Core Version:    0.6.2
 */