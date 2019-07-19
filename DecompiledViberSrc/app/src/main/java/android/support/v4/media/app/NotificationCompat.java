package android.support.v4.media.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.DecoratedMediaCustomViewStyle;
import android.app.Notification.MediaStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.mediacompat.R.color;
import android.support.mediacompat.R.id;
import android.support.mediacompat.R.integer;
import android.support.mediacompat.R.layout;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat
{
  public static class DecoratedMediaCustomViewStyle extends NotificationCompat.MediaStyle
  {
    private void setBackgroundColor(RemoteViews paramRemoteViews)
    {
      if (this.mBuilder.getColor() != 0);
      for (int i = this.mBuilder.getColor(); ; i = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color))
      {
        paramRemoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
        return;
      }
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
        return;
      }
      super.apply(paramNotificationBuilderWithBuilderAccessor);
    }

    int getBigContentViewLayoutResource(int paramInt)
    {
      if (paramInt <= 3)
        return R.layout.notification_template_big_media_narrow_custom;
      return R.layout.notification_template_big_media_custom;
    }

    int getContentViewLayoutResource()
    {
      if (this.mBuilder.getContentView() != null)
        return R.layout.notification_template_media_custom;
      return super.getContentViewLayoutResource();
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      int i = Build.VERSION.SDK_INT;
      RemoteViews localRemoteViews1 = null;
      if (i >= 24)
        return localRemoteViews1;
      if (this.mBuilder.getBigContentView() != null);
      for (RemoteViews localRemoteViews2 = this.mBuilder.getBigContentView(); ; localRemoteViews2 = this.mBuilder.getContentView())
      {
        localRemoteViews1 = null;
        if (localRemoteViews2 == null)
          break;
        localRemoteViews1 = generateBigContentView();
        buildIntoRemoteViews(localRemoteViews1, localRemoteViews2);
        if (Build.VERSION.SDK_INT < 21)
          break;
        setBackgroundColor(localRemoteViews1);
        return localRemoteViews1;
      }
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24)
        return null;
      if (this.mBuilder.getContentView() != null);
      for (int i = 1; Build.VERSION.SDK_INT >= 21; i = 0)
      {
        int j;
        if (i == 0)
        {
          RemoteViews localRemoteViews3 = this.mBuilder.getBigContentView();
          j = 0;
          if (localRemoteViews3 == null);
        }
        else
        {
          j = 1;
        }
        if (j == 0)
          break label119;
        RemoteViews localRemoteViews2 = generateContentView();
        if (i != 0)
          buildIntoRemoteViews(localRemoteViews2, this.mBuilder.getContentView());
        setBackgroundColor(localRemoteViews2);
        return localRemoteViews2;
      }
      RemoteViews localRemoteViews1 = generateContentView();
      if (i != 0)
      {
        buildIntoRemoteViews(localRemoteViews1, this.mBuilder.getContentView());
        return localRemoteViews1;
      }
      label119: return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      int i = Build.VERSION.SDK_INT;
      RemoteViews localRemoteViews1 = null;
      if (i >= 24)
        return localRemoteViews1;
      if (this.mBuilder.getHeadsUpContentView() != null);
      for (RemoteViews localRemoteViews2 = this.mBuilder.getHeadsUpContentView(); ; localRemoteViews2 = this.mBuilder.getContentView())
      {
        localRemoteViews1 = null;
        if (localRemoteViews2 == null)
          break;
        localRemoteViews1 = generateBigContentView();
        buildIntoRemoteViews(localRemoteViews1, localRemoteViews2);
        if (Build.VERSION.SDK_INT < 21)
          break;
        setBackgroundColor(localRemoteViews1);
        return localRemoteViews1;
      }
    }
  }

  public static class MediaStyle extends NotificationCompat.Style
  {
    private static final int MAX_MEDIA_BUTTONS = 5;
    private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    int[] mActionsToShowInCompact = null;
    PendingIntent mCancelButtonIntent;
    boolean mShowCancelButton;
    MediaSessionCompat.Token mToken;

    public MediaStyle()
    {
    }

    public MediaStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }

    private RemoteViews generateMediaActionButton(NotificationCompat.Action paramAction)
    {
      if (paramAction.getActionIntent() == null);
      for (int i = 1; ; i = 0)
      {
        RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
        localRemoteViews.setImageViewResource(R.id.action0, paramAction.getIcon());
        if (i == 0)
          localRemoteViews.setOnClickPendingIntent(R.id.action0, paramAction.getActionIntent());
        if (Build.VERSION.SDK_INT >= 15)
          localRemoteViews.setContentDescription(R.id.action0, paramAction.getTitle());
        return localRemoteViews;
      }
    }

    public static MediaSessionCompat.Token getMediaSession(Notification paramNotification)
    {
      Bundle localBundle = android.support.v4.app.NotificationCompat.getExtras(paramNotification);
      if (localBundle != null)
        if (Build.VERSION.SDK_INT >= 21)
        {
          Parcelable localParcelable = localBundle.getParcelable("android.mediaSession");
          if (localParcelable != null)
            return MediaSessionCompat.Token.fromToken(localParcelable);
        }
        else
        {
          IBinder localIBinder = BundleCompat.getBinder(localBundle, "android.mediaSession");
          if (localIBinder != null)
          {
            Parcel localParcel = Parcel.obtain();
            localParcel.writeStrongBinder(localIBinder);
            localParcel.setDataPosition(0);
            MediaSessionCompat.Token localToken = (MediaSessionCompat.Token)MediaSessionCompat.Token.CREATOR.createFromParcel(localParcel);
            localParcel.recycle();
            return localToken;
          }
        }
      return null;
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 21)
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
      while (!this.mShowCancelButton)
        return;
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
    }

    Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle paramMediaStyle)
    {
      if (this.mActionsToShowInCompact != null)
        paramMediaStyle.setShowActionsInCompactView(this.mActionsToShowInCompact);
      if (this.mToken != null)
        paramMediaStyle.setMediaSession((MediaSession.Token)this.mToken.getToken());
      return paramMediaStyle;
    }

    RemoteViews generateBigContentView()
    {
      int i = Math.min(this.mBuilder.mActions.size(), 5);
      RemoteViews localRemoteViews1 = applyStandardTemplate(false, getBigContentViewLayoutResource(i), false);
      localRemoteViews1.removeAllViews(R.id.media_actions);
      if (i > 0)
        for (int j = 0; j < i; j++)
        {
          RemoteViews localRemoteViews2 = generateMediaActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(j));
          localRemoteViews1.addView(R.id.media_actions, localRemoteViews2);
        }
      if (this.mShowCancelButton)
      {
        localRemoteViews1.setViewVisibility(R.id.cancel_action, 0);
        localRemoteViews1.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        localRemoteViews1.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        return localRemoteViews1;
      }
      localRemoteViews1.setViewVisibility(R.id.cancel_action, 8);
      return localRemoteViews1;
    }

    RemoteViews generateContentView()
    {
      RemoteViews localRemoteViews1 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
      int i = this.mBuilder.mActions.size();
      int j;
      if (this.mActionsToShowInCompact == null)
      {
        j = 0;
        localRemoteViews1.removeAllViews(R.id.media_actions);
        if (j <= 0);
      }
      else
      {
        for (int k = 0; ; k++)
        {
          if (k >= j)
            break label152;
          if (k >= i)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(k);
            arrayOfObject[1] = Integer.valueOf(i - 1);
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", arrayOfObject));
            j = Math.min(this.mActionsToShowInCompact.length, 3);
            break;
          }
          RemoteViews localRemoteViews2 = generateMediaActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(this.mActionsToShowInCompact[k]));
          localRemoteViews1.addView(R.id.media_actions, localRemoteViews2);
        }
      }
      label152: if (this.mShowCancelButton)
      {
        localRemoteViews1.setViewVisibility(R.id.end_padder, 8);
        localRemoteViews1.setViewVisibility(R.id.cancel_action, 0);
        localRemoteViews1.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        localRemoteViews1.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        return localRemoteViews1;
      }
      localRemoteViews1.setViewVisibility(R.id.end_padder, 0);
      localRemoteViews1.setViewVisibility(R.id.cancel_action, 8);
      return localRemoteViews1;
    }

    int getBigContentViewLayoutResource(int paramInt)
    {
      if (paramInt <= 3)
        return R.layout.notification_template_big_media_narrow;
      return R.layout.notification_template_big_media;
    }

    int getContentViewLayoutResource()
    {
      return R.layout.notification_template_media;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 21)
        return null;
      return generateBigContentView();
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 21)
        return null;
      return generateContentView();
    }

    public MediaStyle setCancelButtonIntent(PendingIntent paramPendingIntent)
    {
      this.mCancelButtonIntent = paramPendingIntent;
      return this;
    }

    public MediaStyle setMediaSession(MediaSessionCompat.Token paramToken)
    {
      this.mToken = paramToken;
      return this;
    }

    public MediaStyle setShowActionsInCompactView(int[] paramArrayOfInt)
    {
      this.mActionsToShowInCompact = paramArrayOfInt;
      return this;
    }

    public MediaStyle setShowCancelButton(boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 21)
        this.mShowCancelButton = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.app.NotificationCompat
 * JD-Core Version:    0.6.2
 */