package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

@Deprecated
public abstract interface ChannelApi
{
  public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";

  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelListener paramChannelListener);

  public abstract PendingResult<OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);

  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelListener paramChannelListener);

  @Deprecated
  public static abstract interface ChannelListener
  {
    public static final int CLOSE_REASON_DISCONNECTED = 1;
    public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
    public static final int CLOSE_REASON_NORMAL = 0;
    public static final int CLOSE_REASON_REMOTE_CLOSE = 2;

    public abstract void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2);

    public abstract void onChannelOpened(Channel paramChannel);

    public abstract void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2);

    public abstract void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CloseReason
  {
  }

  @Deprecated
  public static abstract interface OpenChannelResult extends Result
  {
    @Nullable
    public abstract Channel getChannel();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelApi
 * JD-Core Version:    0.6.2
 */