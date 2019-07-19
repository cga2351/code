package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatBuilder
  implements NotificationBuilderWithBuilderAccessor
{
  private final List<Bundle> mActionExtrasList = new ArrayList();
  private RemoteViews mBigContentView;
  private final Notification.Builder mBuilder;
  private final NotificationCompat.Builder mBuilderCompat;
  private RemoteViews mContentView;
  private final Bundle mExtras = new Bundle();
  private int mGroupAlertBehavior;
  private RemoteViews mHeadsUpContentView;

  NotificationCompatBuilder(NotificationCompat.Builder paramBuilder)
  {
    this.mBuilderCompat = paramBuilder;
    Notification localNotification;
    boolean bool1;
    label138: boolean bool2;
    label159: boolean bool3;
    label181: Notification.Builder localBuilder4;
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramBuilder.mContext, paramBuilder.mChannelId);
      localNotification = paramBuilder.mNotification;
      Notification.Builder localBuilder1 = this.mBuilder.setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, paramBuilder.mTickerView).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
      if ((0x2 & localNotification.flags) == 0)
        break label403;
      bool1 = true;
      Notification.Builder localBuilder2 = localBuilder1.setOngoing(bool1);
      if ((0x8 & localNotification.flags) == 0)
        break label409;
      bool2 = true;
      Notification.Builder localBuilder3 = localBuilder2.setOnlyAlertOnce(bool2);
      if ((0x10 & localNotification.flags) == 0)
        break label415;
      bool3 = true;
      localBuilder4 = localBuilder3.setAutoCancel(bool3).setDefaults(localNotification.defaults).setContentTitle(paramBuilder.mContentTitle).setContentText(paramBuilder.mContentText).setContentInfo(paramBuilder.mContentInfo).setContentIntent(paramBuilder.mContentIntent).setDeleteIntent(localNotification.deleteIntent);
      localPendingIntent = paramBuilder.mFullScreenIntent;
      if ((0x80 & localNotification.flags) == 0)
        break label421;
    }
    label403: label409: label415: label421: for (boolean bool4 = true; ; bool4 = false)
    {
      localBuilder4.setFullScreenIntent(localPendingIntent, bool4).setLargeIcon(paramBuilder.mLargeIcon).setNumber(paramBuilder.mNumber).setProgress(paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate);
      if (Build.VERSION.SDK_INT < 21)
        this.mBuilder.setSound(localNotification.sound, localNotification.audioStreamType);
      if (Build.VERSION.SDK_INT < 16)
        break label547;
      this.mBuilder.setSubText(paramBuilder.mSubText).setUsesChronometer(paramBuilder.mUseChronometer).setPriority(paramBuilder.mPriority);
      Iterator localIterator2 = paramBuilder.mActions.iterator();
      while (localIterator2.hasNext())
        addAction((NotificationCompat.Action)localIterator2.next());
      this.mBuilder = new Notification.Builder(paramBuilder.mContext);
      break;
      bool1 = false;
      break label138;
      bool2 = false;
      break label159;
      bool3 = false;
      break label181;
    }
    if (paramBuilder.mExtras != null)
      this.mExtras.putAll(paramBuilder.mExtras);
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramBuilder.mLocalOnly)
        this.mExtras.putBoolean("android.support.localOnly", true);
      if (paramBuilder.mGroupKey != null)
      {
        this.mExtras.putString("android.support.groupKey", paramBuilder.mGroupKey);
        if (!paramBuilder.mGroupSummary)
          break label767;
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    while (true)
    {
      if (paramBuilder.mSortKey != null)
        this.mExtras.putString("android.support.sortKey", paramBuilder.mSortKey);
      this.mContentView = paramBuilder.mContentView;
      this.mBigContentView = paramBuilder.mBigContentView;
      label547: if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramBuilder.mShowWhen);
        if ((Build.VERSION.SDK_INT < 21) && (paramBuilder.mPeople != null) && (!paramBuilder.mPeople.isEmpty()))
          this.mExtras.putStringArray("android.people", (String[])paramBuilder.mPeople.toArray(new String[paramBuilder.mPeople.size()]));
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramBuilder.mLocalOnly).setGroup(paramBuilder.mGroupKey).setGroupSummary(paramBuilder.mGroupSummary).setSortKey(paramBuilder.mSortKey);
        this.mGroupAlertBehavior = paramBuilder.mGroupAlertBehavior;
      }
      if (Build.VERSION.SDK_INT < 21)
        break label914;
      this.mBuilder.setCategory(paramBuilder.mCategory).setColor(paramBuilder.mColor).setVisibility(paramBuilder.mVisibility).setPublicVersion(paramBuilder.mPublicVersion).setSound(localNotification.sound, localNotification.audioAttributes);
      Iterator localIterator1 = paramBuilder.mPeople.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        this.mBuilder.addPerson(str);
      }
      label767: this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.mHeadsUpContentView = paramBuilder.mHeadsUpContentView;
    Bundle localBundle1;
    if (paramBuilder.mInvisibleActions.size() > 0)
    {
      localBundle1 = paramBuilder.getExtras().getBundle("android.car.EXTENSIONS");
      if (localBundle1 != null)
        break label1092;
    }
    label914: label1092: for (Bundle localBundle2 = new Bundle(); ; localBundle2 = localBundle1)
    {
      Bundle localBundle3 = new Bundle();
      for (int i = 0; i < paramBuilder.mInvisibleActions.size(); i++)
        localBundle3.putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)paramBuilder.mInvisibleActions.get(i)));
      localBundle2.putBundle("invisible_actions", localBundle3);
      paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle2);
      this.mExtras.putBundle("android.car.EXTENSIONS", localBundle2);
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.mBuilder.setExtras(paramBuilder.mExtras).setRemoteInputHistory(paramBuilder.mRemoteInputHistory);
        if (paramBuilder.mContentView != null)
          this.mBuilder.setCustomContentView(paramBuilder.mContentView);
        if (paramBuilder.mBigContentView != null)
          this.mBuilder.setCustomBigContentView(paramBuilder.mBigContentView);
        if (paramBuilder.mHeadsUpContentView != null)
          this.mBuilder.setCustomHeadsUpContentView(paramBuilder.mHeadsUpContentView);
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.mBuilder.setBadgeIconType(paramBuilder.mBadgeIcon).setShortcutId(paramBuilder.mShortcutId).setTimeoutAfter(paramBuilder.mTimeout).setGroupAlertBehavior(paramBuilder.mGroupAlertBehavior);
        if (paramBuilder.mColorizedSet)
          this.mBuilder.setColorized(paramBuilder.mColorized);
        if (!TextUtils.isEmpty(paramBuilder.mChannelId))
          this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
      return;
    }
  }

  private void addAction(NotificationCompat.Action paramAction)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      if (paramAction.getRemoteInputs() != null)
      {
        arrayOfRemoteInput = RemoteInput.fromCompat(paramAction.getRemoteInputs());
        i = arrayOfRemoteInput.length;
        for (j = 0; j < i; j++)
          localBuilder.addRemoteInput(arrayOfRemoteInput[j]);
      }
      if (paramAction.getExtras() != null)
      {
        localBundle = new Bundle(paramAction.getExtras());
        localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24)
          localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
        localBundle.putInt("android.support.action.semanticAction", paramAction.getSemanticAction());
        if (Build.VERSION.SDK_INT >= 28)
          localBuilder.setSemanticAction(paramAction.getSemanticAction());
        localBundle.putBoolean("android.support.action.showsUserInterface", paramAction.getShowsUserInterface());
        localBuilder.addExtras(localBundle);
        this.mBuilder.addAction(localBuilder.build());
      }
    }
    while (Build.VERSION.SDK_INT < 16)
      while (true)
      {
        Notification.Action.Builder localBuilder;
        android.app.RemoteInput[] arrayOfRemoteInput;
        int i;
        int j;
        return;
        Bundle localBundle = new Bundle();
      }
    this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, paramAction));
  }

  private void removeSoundAndVibration(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults = (0xFFFFFFFE & paramNotification.defaults);
    paramNotification.defaults = (0xFFFFFFFD & paramNotification.defaults);
  }

  public Notification build()
  {
    NotificationCompat.Style localStyle = this.mBuilderCompat.mStyle;
    if (localStyle != null)
      localStyle.apply(this);
    RemoteViews localRemoteViews1;
    Notification localNotification;
    if (localStyle != null)
    {
      localRemoteViews1 = localStyle.makeContentView(this);
      localNotification = buildInternal();
      if (localRemoteViews1 == null)
        break label143;
      localNotification.contentView = localRemoteViews1;
    }
    while (true)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (localStyle != null))
      {
        RemoteViews localRemoteViews3 = localStyle.makeBigContentView(this);
        if (localRemoteViews3 != null)
          localNotification.bigContentView = localRemoteViews3;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (localStyle != null))
      {
        RemoteViews localRemoteViews2 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (localRemoteViews2 != null)
          localNotification.headsUpContentView = localRemoteViews2;
      }
      if ((Build.VERSION.SDK_INT >= 16) && (localStyle != null))
      {
        Bundle localBundle = NotificationCompat.getExtras(localNotification);
        if (localBundle != null)
          localStyle.addCompatExtras(localBundle);
      }
      return localNotification;
      localRemoteViews1 = null;
      break;
      label143: if (this.mBuilderCompat.mContentView != null)
        localNotification.contentView = this.mBuilderCompat.mContentView;
    }
  }

  protected Notification buildInternal()
  {
    Notification localNotification2;
    if (Build.VERSION.SDK_INT >= 26)
      localNotification2 = this.mBuilder.build();
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return localNotification2;
                  if (Build.VERSION.SDK_INT < 24)
                    break;
                  localNotification2 = this.mBuilder.build();
                }
                while (this.mGroupAlertBehavior == 0);
                if ((localNotification2.getGroup() != null) && ((0x200 & localNotification2.flags) != 0) && (this.mGroupAlertBehavior == 2))
                  removeSoundAndVibration(localNotification2);
              }
              while ((localNotification2.getGroup() == null) || ((0x200 & localNotification2.flags) != 0) || (this.mGroupAlertBehavior != 1));
              removeSoundAndVibration(localNotification2);
              return localNotification2;
              if (Build.VERSION.SDK_INT < 21)
                break;
              this.mBuilder.setExtras(this.mExtras);
              localNotification2 = this.mBuilder.build();
              if (this.mContentView != null)
                localNotification2.contentView = this.mContentView;
              if (this.mBigContentView != null)
                localNotification2.bigContentView = this.mBigContentView;
              if (this.mHeadsUpContentView != null)
                localNotification2.headsUpContentView = this.mHeadsUpContentView;
            }
            while (this.mGroupAlertBehavior == 0);
            if ((localNotification2.getGroup() != null) && ((0x200 & localNotification2.flags) != 0) && (this.mGroupAlertBehavior == 2))
              removeSoundAndVibration(localNotification2);
          }
          while ((localNotification2.getGroup() == null) || ((0x200 & localNotification2.flags) != 0) || (this.mGroupAlertBehavior != 1));
          removeSoundAndVibration(localNotification2);
          return localNotification2;
          if (Build.VERSION.SDK_INT < 20)
            break;
          this.mBuilder.setExtras(this.mExtras);
          localNotification2 = this.mBuilder.build();
          if (this.mContentView != null)
            localNotification2.contentView = this.mContentView;
          if (this.mBigContentView != null)
            localNotification2.bigContentView = this.mBigContentView;
        }
        while (this.mGroupAlertBehavior == 0);
        if ((localNotification2.getGroup() != null) && ((0x200 & localNotification2.flags) != 0) && (this.mGroupAlertBehavior == 2))
          removeSoundAndVibration(localNotification2);
      }
      while ((localNotification2.getGroup() == null) || ((0x200 & localNotification2.flags) != 0) || (this.mGroupAlertBehavior != 1));
      removeSoundAndVibration(localNotification2);
      return localNotification2;
      if (Build.VERSION.SDK_INT < 19)
        break;
      SparseArray localSparseArray2 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localSparseArray2 != null)
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", localSparseArray2);
      this.mBuilder.setExtras(this.mExtras);
      localNotification2 = this.mBuilder.build();
      if (this.mContentView != null)
        localNotification2.contentView = this.mContentView;
    }
    while (this.mBigContentView == null);
    localNotification2.bigContentView = this.mBigContentView;
    return localNotification2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      Notification localNotification1 = this.mBuilder.build();
      Bundle localBundle1 = NotificationCompat.getExtras(localNotification1);
      Bundle localBundle2 = new Bundle(this.mExtras);
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localBundle1.containsKey(str))
          localBundle2.remove(str);
      }
      localBundle1.putAll(localBundle2);
      SparseArray localSparseArray1 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localSparseArray1 != null)
        NotificationCompat.getExtras(localNotification1).putSparseParcelableArray("android.support.actionExtras", localSparseArray1);
      if (this.mContentView != null)
        localNotification1.contentView = this.mContentView;
      if (this.mBigContentView != null)
        localNotification1.bigContentView = this.mBigContentView;
      return localNotification1;
    }
    return this.mBuilder.getNotification();
  }

  public Notification.Builder getBuilder()
  {
    return this.mBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatBuilder
 * JD-Core Version:    0.6.2
 */