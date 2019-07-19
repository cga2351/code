package com.viber.voip.messages.controller.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.a;
import com.google.d.a.c;

public abstract interface SyncHistoryCommunicator
{
  public static class SyncHistoryMessage
    implements Parcelable
  {
    public static final Parcelable.Creator<SyncHistoryMessage> CREATOR = new Parcelable.Creator()
    {
      public SyncHistoryCommunicator.SyncHistoryMessage a(Parcel paramAnonymousParcel)
      {
        return new SyncHistoryCommunicator.SyncHistoryMessage(paramAnonymousParcel);
      }

      public SyncHistoryCommunicator.SyncHistoryMessage[] a(int paramAnonymousInt)
      {
        return new SyncHistoryCommunicator.SyncHistoryMessage[paramAnonymousInt];
      }
    };

    @c(a="Action")
    private String mAction;

    @c(a="DownloadEP")
    private String mEncryptionParams;

    @c(a="ErrorString")
    private String mError;

    @c(a="FromToken")
    private Long mFromToken;

    @c(a="Progress")
    private Integer mProgress;

    @c(a="Reason")
    private String mReason;

    @c(a="SecondaryID")
    private String mSecondaryId;

    @c(a="Status")
    private String mStatus;

    @a(b=false)
    @c(a="Type")
    private String mType = as.a.a.a();

    public SyncHistoryMessage()
    {
    }

    protected SyncHistoryMessage(Parcel paramParcel)
    {
      this.mType = paramParcel.readString();
      this.mAction = paramParcel.readString();
      this.mSecondaryId = paramParcel.readString();
      this.mProgress = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
      this.mFromToken = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.mStatus = paramParcel.readString();
      this.mReason = paramParcel.readString();
      this.mError = paramParcel.readString();
      this.mEncryptionParams = paramParcel.readString();
    }

    public static a builder()
    {
      return new a(null);
    }

    public int describeContents()
    {
      return 0;
    }

    public String getAction()
    {
      return this.mAction;
    }

    public String getEncryptionParams()
    {
      return this.mEncryptionParams;
    }

    public String getError()
    {
      return this.mError;
    }

    public Long getFromToken()
    {
      return this.mFromToken;
    }

    public Integer getProgress()
    {
      return this.mProgress;
    }

    public String getReason()
    {
      return this.mReason;
    }

    public String getSecondaryId()
    {
      return this.mSecondaryId;
    }

    public String getStatus()
    {
      return this.mStatus;
    }

    public String toString()
    {
      return "SyncHistoryMessage{mType='" + this.mType + '\'' + ", mAction='" + this.mAction + '\'' + ", mSecondaryId='" + this.mSecondaryId + '\'' + ", mProgress=" + this.mProgress + ", mFromToken=" + this.mFromToken + ", mStatus='" + this.mStatus + '\'' + ", mReason='" + this.mReason + '\'' + ", mError='" + this.mError + '\'' + ", mEncryptionParams='" + this.mEncryptionParams + '\'' + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mType);
      paramParcel.writeString(this.mAction);
      paramParcel.writeString(this.mSecondaryId);
      paramParcel.writeValue(this.mProgress);
      paramParcel.writeValue(this.mFromToken);
      paramParcel.writeString(this.mStatus);
      paramParcel.writeString(this.mReason);
      paramParcel.writeString(this.mError);
      paramParcel.writeString(this.mEncryptionParams);
    }

    public static final class a
    {
      private SyncHistoryCommunicator.SyncHistoryMessage a = new SyncHistoryCommunicator.SyncHistoryMessage();

      public a a(Integer paramInteger)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$202(this.a, paramInteger);
        return this;
      }

      public a a(Long paramLong)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$302(this.a, paramLong);
        return this;
      }

      public a a(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$002(this.a, paramString);
        return this;
      }

      public SyncHistoryCommunicator.SyncHistoryMessage a()
      {
        SyncHistoryCommunicator.SyncHistoryMessage localSyncHistoryMessage = this.a;
        this.a = new SyncHistoryCommunicator.SyncHistoryMessage();
        return localSyncHistoryMessage;
      }

      public a b(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$102(this.a, paramString);
        return this;
      }

      public a c(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$402(this.a, paramString);
        return this;
      }

      public a d(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$502(this.a, paramString);
        return this;
      }

      public a e(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$602(this.a, paramString);
        return this;
      }

      public a f(String paramString)
      {
        SyncHistoryCommunicator.SyncHistoryMessage.access$702(this.a, paramString);
        return this;
      }
    }
  }

  public static class a
  {
    private SyncHistoryCommunicator.SyncHistoryMessage.a g(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return SyncHistoryCommunicator.SyncHistoryMessage.builder().b(paramSyncHistoryMessage.getSecondaryId());
    }

    SyncHistoryCommunicator.SyncHistoryMessage a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Handshake").a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, int paramInt)
    {
      return g(paramSyncHistoryMessage).a("Progress changed").a(Integer.valueOf(paramInt)).a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, String paramString)
    {
      return g(paramSyncHistoryMessage).a("Error").e(paramString).a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage b(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Reply").c("Rejected").a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage b(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, String paramString)
    {
      return g(paramSyncHistoryMessage).a("Completed").f(paramString).a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage c(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Reply").c("Accepted").a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage d(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Paused").d("Background").a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage e(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Resumed").a();
    }

    SyncHistoryCommunicator.SyncHistoryMessage f(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage)
    {
      return g(paramSyncHistoryMessage).a("Canceled").a();
    }
  }

  public static class b
  {
    public static final b a = a(null, 0);
    public final SyncHistoryCommunicator.SyncHistoryMessage b;
    public final int c;

    private b(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, int paramInt)
    {
      this.b = paramSyncHistoryMessage;
      this.c = paramInt;
    }

    public static b a(SyncHistoryCommunicator.SyncHistoryMessage paramSyncHistoryMessage, int paramInt)
    {
      return new b(paramSyncHistoryMessage, paramInt);
    }

    public b a(int paramInt)
    {
      return a(this.b, paramInt);
    }

    public boolean a(int[] paramArrayOfInt)
    {
      int i = paramArrayOfInt.length;
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          int k = paramArrayOfInt[j];
          if (this.c == k)
            bool = true;
        }
        else
        {
          return bool;
        }
      }
    }

    public String toString()
    {
      return "SyncHistoryState{request=" + this.b + ", step=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.SyncHistoryCommunicator
 * JD-Core Version:    0.6.2
 */