package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.app.Notification.InboxStyle;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.compat.R.color;
import android.support.compat.R.dimen;
import android.support.compat.R.drawable;
import android.support.compat.R.id;
import android.support.compat.R.integer;
import android.support.compat.R.layout;
import android.support.compat.R.string;
import android.support.v4.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;

  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;

  public static Action getAction(Notification paramNotification, int paramInt)
  {
    Action localAction;
    if (Build.VERSION.SDK_INT >= 20)
      localAction = getActionCompatFromAction(paramNotification.actions[paramInt]);
    int i;
    do
    {
      return localAction;
      if (Build.VERSION.SDK_INT >= 19)
      {
        Notification.Action localAction1 = paramNotification.actions[paramInt];
        SparseArray localSparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
        Bundle localBundle = null;
        if (localSparseArray != null)
          localBundle = (Bundle)localSparseArray.get(paramInt);
        return NotificationCompatJellybean.readAction(localAction1.icon, localAction1.title, localAction1.actionIntent, localBundle);
      }
      i = Build.VERSION.SDK_INT;
      localAction = null;
    }
    while (i < 16);
    return NotificationCompatJellybean.getAction(paramNotification, paramInt);
  }

  static Action getActionCompatFromAction(Notification.Action paramAction)
  {
    android.app.RemoteInput[] arrayOfRemoteInput = paramAction.getRemoteInputs();
    if (arrayOfRemoteInput == null);
    label46: RemoteInput[] arrayOfRemoteInput1;
    for (Object localObject = null; ; localObject = arrayOfRemoteInput1)
    {
      boolean bool3;
      boolean bool1;
      boolean bool2;
      if (Build.VERSION.SDK_INT >= 24)
        if ((paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies")) || (paramAction.getAllowGeneratedReplies()))
        {
          bool3 = true;
          bool1 = bool3;
          bool2 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
          if (Build.VERSION.SDK_INT < 28)
            break label187;
        }
      label187: for (int j = paramAction.getSemanticAction(); ; j = paramAction.getExtras().getInt("android.support.action.semanticAction", 0))
      {
        return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), (RemoteInput[])localObject, null, bool1, j, bool2);
        arrayOfRemoteInput1 = new RemoteInput[arrayOfRemoteInput.length];
        for (int i = 0; i < arrayOfRemoteInput.length; i++)
        {
          android.app.RemoteInput localRemoteInput = arrayOfRemoteInput[i];
          arrayOfRemoteInput1[i] = new RemoteInput(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras(), null);
        }
        bool3 = false;
        break;
        bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
        break label46;
      }
    }
  }

  public static int getActionCount(Notification paramNotification)
  {
    int j;
    if (Build.VERSION.SDK_INT >= 19)
    {
      Notification.Action[] arrayOfAction = paramNotification.actions;
      j = 0;
      if (arrayOfAction != null)
        j = paramNotification.actions.length;
    }
    int i;
    do
    {
      return j;
      i = Build.VERSION.SDK_INT;
      j = 0;
    }
    while (i < 16);
    return NotificationCompatJellybean.getActionCount(paramNotification);
  }

  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramNotification.getBadgeIconType();
    return 0;
  }

  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramNotification.category;
    return null;
  }

  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramNotification.getChannelId();
    return null;
  }

  public static CharSequence getContentTitle(Notification paramNotification)
  {
    return paramNotification.extras.getCharSequence("android.title");
  }

  public static Bundle getExtras(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramNotification.extras;
    if (Build.VERSION.SDK_INT >= 16)
      return NotificationCompatJellybean.getExtras(paramNotification);
    return null;
  }

  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20)
      return paramNotification.getGroup();
    if (Build.VERSION.SDK_INT >= 19)
      return paramNotification.extras.getString("android.support.groupKey");
    if (Build.VERSION.SDK_INT >= 16)
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey");
    return null;
  }

  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramNotification.getGroupAlertBehavior();
    return 0;
  }

  public static List<Action> getInvisibleActions(Notification paramNotification)
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle1 = paramNotification.extras.getBundle("android.car.EXTENSIONS");
    if (localBundle1 == null)
      return localArrayList;
    Bundle localBundle2 = localBundle1.getBundle("invisible_actions");
    if (localBundle2 != null)
      for (int i = 0; i < localBundle2.size(); i++)
        localArrayList.add(NotificationCompatJellybean.getActionFromBundle(localBundle2.getBundle(Integer.toString(i))));
    return localArrayList;
  }

  public static boolean getLocalOnly(Notification paramNotification)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 20)
    {
      int j = 0x100 & paramNotification.flags;
      bool = false;
      if (j != 0)
        bool = true;
    }
    int i;
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19)
        return paramNotification.extras.getBoolean("android.support.localOnly");
      i = Build.VERSION.SDK_INT;
      bool = false;
    }
    while (i < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly");
  }

  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null))
      return (Notification[])arrayOfParcelable;
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    for (int i = 0; i < arrayOfParcelable.length; i++)
      arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
    paramBundle.putParcelableArray(paramString, arrayOfNotification);
    return arrayOfNotification;
  }

  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramNotification.getShortcutId();
    return null;
  }

  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20)
      return paramNotification.getSortKey();
    if (Build.VERSION.SDK_INT >= 19)
      return paramNotification.extras.getString("android.support.sortKey");
    if (Build.VERSION.SDK_INT >= 16)
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey");
    return null;
  }

  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramNotification.getTimeoutAfter();
    return 0L;
  }

  public static boolean isGroupSummary(Notification paramNotification)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 20)
    {
      int j = 0x200 & paramNotification.flags;
      bool = false;
      if (j != 0)
        bool = true;
    }
    int i;
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19)
        return paramNotification.extras.getBoolean("android.support.isGroupSummary");
      i = Build.VERSION.SDK_INT;
      bool = false;
    }
    while (i < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary");
  }

  public static class Action
  {
    static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    public static final int SEMANTIC_ACTION_CALL = 10;
    public static final int SEMANTIC_ACTION_DELETE = 4;
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    public static final int SEMANTIC_ACTION_MUTE = 6;
    public static final int SEMANTIC_ACTION_NONE = 0;
    public static final int SEMANTIC_ACTION_REPLY = 1;
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    public PendingIntent actionIntent;
    public int icon;
    private boolean mAllowGeneratedReplies;
    private final RemoteInput[] mDataOnlyRemoteInputs;
    final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    private final int mSemanticAction;
    boolean mShowsUserInterface = true;
    public CharSequence title;

    public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true);
    }

    Action(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
    {
      this.icon = paramInt1;
      this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      if (paramBundle != null);
      while (true)
      {
        this.mExtras = paramBundle;
        this.mRemoteInputs = paramArrayOfRemoteInput1;
        this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
        this.mAllowGeneratedReplies = paramBoolean1;
        this.mSemanticAction = paramInt2;
        this.mShowsUserInterface = paramBoolean2;
        return;
        paramBundle = new Bundle();
      }
    }

    public PendingIntent getActionIntent()
    {
      return this.actionIntent;
    }

    public boolean getAllowGeneratedReplies()
    {
      return this.mAllowGeneratedReplies;
    }

    public RemoteInput[] getDataOnlyRemoteInputs()
    {
      return this.mDataOnlyRemoteInputs;
    }

    public Bundle getExtras()
    {
      return this.mExtras;
    }

    public int getIcon()
    {
      return this.icon;
    }

    public RemoteInput[] getRemoteInputs()
    {
      return this.mRemoteInputs;
    }

    public int getSemanticAction()
    {
      return this.mSemanticAction;
    }

    public boolean getShowsUserInterface()
    {
      return this.mShowsUserInterface;
    }

    public CharSequence getTitle()
    {
      return this.title;
    }

    public static final class Builder
    {
      private boolean mAllowGeneratedReplies = true;
      private final Bundle mExtras;
      private final int mIcon;
      private final PendingIntent mIntent;
      private ArrayList<RemoteInput> mRemoteInputs;
      private int mSemanticAction;
      private boolean mShowsUserInterface = true;
      private final CharSequence mTitle;

      public Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
      {
        this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true);
      }

      private Builder(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
      {
        this.mIcon = paramInt1;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
        this.mIntent = paramPendingIntent;
        this.mExtras = paramBundle;
        if (paramArrayOfRemoteInput == null);
        for (ArrayList localArrayList = null; ; localArrayList = new ArrayList(Arrays.asList(paramArrayOfRemoteInput)))
        {
          this.mRemoteInputs = localArrayList;
          this.mAllowGeneratedReplies = paramBoolean1;
          this.mSemanticAction = paramInt2;
          this.mShowsUserInterface = paramBoolean2;
          return;
        }
      }

      public Builder(NotificationCompat.Action paramAction)
      {
        this(paramAction.icon, paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies(), paramAction.getSemanticAction(), paramAction.mShowsUserInterface);
      }

      public Builder addExtras(Bundle paramBundle)
      {
        if (paramBundle != null)
          this.mExtras.putAll(paramBundle);
        return this;
      }

      public Builder addRemoteInput(RemoteInput paramRemoteInput)
      {
        if (this.mRemoteInputs == null)
          this.mRemoteInputs = new ArrayList();
        this.mRemoteInputs.add(paramRemoteInput);
        return this;
      }

      public NotificationCompat.Action build()
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if (this.mRemoteInputs != null)
        {
          Iterator localIterator = this.mRemoteInputs.iterator();
          while (localIterator.hasNext())
          {
            RemoteInput localRemoteInput = (RemoteInput)localIterator.next();
            if (localRemoteInput.isDataOnly())
              localArrayList1.add(localRemoteInput);
            else
              localArrayList2.add(localRemoteInput);
          }
        }
        RemoteInput[] arrayOfRemoteInput1;
        if (localArrayList1.isEmpty())
        {
          arrayOfRemoteInput1 = null;
          if (!localArrayList2.isEmpty())
            break label170;
        }
        label170: for (RemoteInput[] arrayOfRemoteInput2 = null; ; arrayOfRemoteInput2 = (RemoteInput[])localArrayList2.toArray(new RemoteInput[localArrayList2.size()]))
        {
          return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayOfRemoteInput2, arrayOfRemoteInput1, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface);
          arrayOfRemoteInput1 = (RemoteInput[])localArrayList1.toArray(new RemoteInput[localArrayList1.size()]);
          break;
        }
      }

      public Builder extend(NotificationCompat.Action.Extender paramExtender)
      {
        paramExtender.extend(this);
        return this;
      }

      public Bundle getExtras()
      {
        return this.mExtras;
      }

      public Builder setAllowGeneratedReplies(boolean paramBoolean)
      {
        this.mAllowGeneratedReplies = paramBoolean;
        return this;
      }

      public Builder setSemanticAction(int paramInt)
      {
        this.mSemanticAction = paramInt;
        return this;
      }

      public Builder setShowsUserInterface(boolean paramBoolean)
      {
        this.mShowsUserInterface = paramBoolean;
        return this;
      }
    }

    public static abstract interface Extender
    {
      public abstract NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder);
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface SemanticAction
    {
    }

    public static final class WearableExtender
      implements NotificationCompat.Action.Extender
    {
      private static final int DEFAULT_FLAGS = 1;
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      private static final int FLAG_HINT_DISPLAY_INLINE = 4;
      private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      private static final String KEY_FLAGS = "flags";
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      private CharSequence mCancelLabel;
      private CharSequence mConfirmLabel;
      private int mFlags = 1;
      private CharSequence mInProgressLabel;

      public WearableExtender()
      {
      }

      public WearableExtender(NotificationCompat.Action paramAction)
      {
        Bundle localBundle = paramAction.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (localBundle != null)
        {
          this.mFlags = localBundle.getInt("flags", 1);
          this.mInProgressLabel = localBundle.getCharSequence("inProgressLabel");
          this.mConfirmLabel = localBundle.getCharSequence("confirmLabel");
          this.mCancelLabel = localBundle.getCharSequence("cancelLabel");
        }
      }

      private void setFlag(int paramInt, boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.mFlags = (paramInt | this.mFlags);
          return;
        }
        this.mFlags &= (paramInt ^ 0xFFFFFFFF);
      }

      public WearableExtender clone()
      {
        WearableExtender localWearableExtender = new WearableExtender();
        localWearableExtender.mFlags = this.mFlags;
        localWearableExtender.mInProgressLabel = this.mInProgressLabel;
        localWearableExtender.mConfirmLabel = this.mConfirmLabel;
        localWearableExtender.mCancelLabel = this.mCancelLabel;
        return localWearableExtender;
      }

      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
      {
        Bundle localBundle = new Bundle();
        if (this.mFlags != 1)
          localBundle.putInt("flags", this.mFlags);
        if (this.mInProgressLabel != null)
          localBundle.putCharSequence("inProgressLabel", this.mInProgressLabel);
        if (this.mConfirmLabel != null)
          localBundle.putCharSequence("confirmLabel", this.mConfirmLabel);
        if (this.mCancelLabel != null)
          localBundle.putCharSequence("cancelLabel", this.mCancelLabel);
        paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramBuilder;
      }

      @Deprecated
      public CharSequence getCancelLabel()
      {
        return this.mCancelLabel;
      }

      @Deprecated
      public CharSequence getConfirmLabel()
      {
        return this.mConfirmLabel;
      }

      public boolean getHintDisplayActionInline()
      {
        return (0x4 & this.mFlags) != 0;
      }

      public boolean getHintLaunchesActivity()
      {
        return (0x2 & this.mFlags) != 0;
      }

      @Deprecated
      public CharSequence getInProgressLabel()
      {
        return this.mInProgressLabel;
      }

      public boolean isAvailableOffline()
      {
        return (0x1 & this.mFlags) != 0;
      }

      public WearableExtender setAvailableOffline(boolean paramBoolean)
      {
        setFlag(1, paramBoolean);
        return this;
      }

      @Deprecated
      public WearableExtender setCancelLabel(CharSequence paramCharSequence)
      {
        this.mCancelLabel = paramCharSequence;
        return this;
      }

      @Deprecated
      public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
      {
        this.mConfirmLabel = paramCharSequence;
        return this;
      }

      public WearableExtender setHintDisplayActionInline(boolean paramBoolean)
      {
        setFlag(4, paramBoolean);
        return this;
      }

      public WearableExtender setHintLaunchesActivity(boolean paramBoolean)
      {
        setFlag(2, paramBoolean);
        return this;
      }

      @Deprecated
      public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
      {
        this.mInProgressLabel = paramCharSequence;
        return this;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BadgeIconType
  {
  }

  public static class BigPictureStyle extends NotificationCompat.Style
  {
    private Bitmap mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;

    public BigPictureStyle()
    {
    }

    public BigPictureStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Notification.BigPictureStyle localBigPictureStyle = new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
        if (this.mBigLargeIconSet)
          localBigPictureStyle.bigLargeIcon(this.mBigLargeIcon);
        if (this.mSummaryTextSet)
          localBigPictureStyle.setSummaryText(this.mSummaryText);
      }
    }

    public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
    {
      this.mBigLargeIcon = paramBitmap;
      this.mBigLargeIconSet = true;
      return this;
    }

    public BigPictureStyle bigPicture(Bitmap paramBitmap)
    {
      this.mPicture = paramBitmap;
      return this;
    }

    public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }

  public static class BigTextStyle extends NotificationCompat.Style
  {
    private CharSequence mBigText;

    public BigTextStyle()
    {
    }

    public BigTextStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Notification.BigTextStyle localBigTextStyle = new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
        if (this.mSummaryTextSet)
          localBigTextStyle.setSummaryText(this.mSummaryText);
      }
    }

    public BigTextStyle bigText(CharSequence paramCharSequence)
    {
      this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public BigTextStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }

  public static class Builder
  {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    int mBadgeIcon = 0;
    RemoteViews mBigContentView;
    String mCategory;
    String mChannelId;
    int mColor = 0;
    boolean mColorized;
    boolean mColorizedSet;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    RemoteViews mContentView;
    public Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    int mGroupAlertBehavior = 0;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    ArrayList<NotificationCompat.Action> mInvisibleActions = new ArrayList();
    Bitmap mLargeIcon;
    boolean mLocalOnly = false;
    Notification mNotification = new Notification();
    int mNumber;

    @Deprecated
    public ArrayList<String> mPeople;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    CharSequence[] mRemoteInputHistory;
    String mShortcutId;
    boolean mShowWhen = true;
    String mSortKey;
    NotificationCompat.Style mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    long mTimeout;
    boolean mUseChronometer;
    int mVisibility = 0;

    @Deprecated
    public Builder(Context paramContext)
    {
      this(paramContext, null);
    }

    public Builder(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList();
    }

    protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null);
      while (paramCharSequence.length() <= 5120)
        return paramCharSequence;
      return paramCharSequence.subSequence(0, 5120);
    }

    private Bitmap reduceLargeIconSize(Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (Build.VERSION.SDK_INT >= 27));
      int i;
      int j;
      do
      {
        return paramBitmap;
        Resources localResources = this.mContext.getResources();
        i = localResources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        j = localResources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
      }
      while ((paramBitmap.getWidth() <= i) && (paramBitmap.getHeight() <= j));
      double d = Math.min(i / Math.max(1, paramBitmap.getWidth()), j / Math.max(1, paramBitmap.getHeight()));
      return Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(d * paramBitmap.getWidth()), (int)Math.ceil(d * paramBitmap.getHeight()), true);
    }

    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        Notification localNotification2 = this.mNotification;
        localNotification2.flags = (paramInt | localNotification2.flags);
        return;
      }
      Notification localNotification1 = this.mNotification;
      localNotification1.flags &= (paramInt ^ 0xFFFFFFFF);
    }

    public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }

    public Builder addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }

    public Builder addExtras(Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        if (this.mExtras == null)
          this.mExtras = new Bundle(paramBundle);
      }
      else
        return this;
      this.mExtras.putAll(paramBundle);
      return this;
    }

    public Builder addInvisibleAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      return addInvisibleAction(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    }

    public Builder addInvisibleAction(NotificationCompat.Action paramAction)
    {
      this.mInvisibleActions.add(paramAction);
      return this;
    }

    public Builder addPerson(String paramString)
    {
      this.mPeople.add(paramString);
      return this;
    }

    public Notification build()
    {
      return new NotificationCompatBuilder(this).build();
    }

    public Builder extend(NotificationCompat.Extender paramExtender)
    {
      paramExtender.extend(this);
      return this;
    }

    public RemoteViews getBigContentView()
    {
      return this.mBigContentView;
    }

    public int getColor()
    {
      return this.mColor;
    }

    public RemoteViews getContentView()
    {
      return this.mContentView;
    }

    public Bundle getExtras()
    {
      if (this.mExtras == null)
        this.mExtras = new Bundle();
      return this.mExtras;
    }

    public RemoteViews getHeadsUpContentView()
    {
      return this.mHeadsUpContentView;
    }

    @Deprecated
    public Notification getNotification()
    {
      return build();
    }

    public int getPriority()
    {
      return this.mPriority;
    }

    public long getWhenIfShowing()
    {
      if (this.mShowWhen)
        return this.mNotification.when;
      return 0L;
    }

    public Builder setAutoCancel(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }

    public Builder setBadgeIconType(int paramInt)
    {
      this.mBadgeIcon = paramInt;
      return this;
    }

    public Builder setCategory(String paramString)
    {
      this.mCategory = paramString;
      return this;
    }

    public Builder setChannelId(String paramString)
    {
      this.mChannelId = paramString;
      return this;
    }

    public Builder setColor(int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }

    public Builder setColorized(boolean paramBoolean)
    {
      this.mColorized = paramBoolean;
      this.mColorizedSet = true;
      return this;
    }

    public Builder setContent(RemoteViews paramRemoteViews)
    {
      this.mNotification.contentView = paramRemoteViews;
      return this;
    }

    public Builder setContentInfo(CharSequence paramCharSequence)
    {
      this.mContentInfo = limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public Builder setContentIntent(PendingIntent paramPendingIntent)
    {
      this.mContentIntent = paramPendingIntent;
      return this;
    }

    public Builder setContentText(CharSequence paramCharSequence)
    {
      this.mContentText = limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public Builder setContentTitle(CharSequence paramCharSequence)
    {
      this.mContentTitle = limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
    {
      this.mBigContentView = paramRemoteViews;
      return this;
    }

    public Builder setCustomContentView(RemoteViews paramRemoteViews)
    {
      this.mContentView = paramRemoteViews;
      return this;
    }

    public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
    {
      this.mHeadsUpContentView = paramRemoteViews;
      return this;
    }

    public Builder setDefaults(int paramInt)
    {
      this.mNotification.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.mNotification;
        localNotification.flags = (0x1 | localNotification.flags);
      }
      return this;
    }

    public Builder setDeleteIntent(PendingIntent paramPendingIntent)
    {
      this.mNotification.deleteIntent = paramPendingIntent;
      return this;
    }

    public Builder setExtras(Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }

    public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
    {
      this.mFullScreenIntent = paramPendingIntent;
      setFlag(128, paramBoolean);
      return this;
    }

    public Builder setGroup(String paramString)
    {
      this.mGroupKey = paramString;
      return this;
    }

    public Builder setGroupAlertBehavior(int paramInt)
    {
      this.mGroupAlertBehavior = paramInt;
      return this;
    }

    public Builder setGroupSummary(boolean paramBoolean)
    {
      this.mGroupSummary = paramBoolean;
      return this;
    }

    public Builder setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = reduceLargeIconSize(paramBitmap);
      return this;
    }

    public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      this.mNotification.ledARGB = paramInt1;
      this.mNotification.ledOnMS = paramInt2;
      this.mNotification.ledOffMS = paramInt3;
      int j;
      Notification localNotification;
      int k;
      if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0))
      {
        j = i;
        localNotification = this.mNotification;
        k = 0xFFFFFFFE & this.mNotification.flags;
        if (j == 0)
          break label92;
      }
      while (true)
      {
        localNotification.flags = (k | i);
        return this;
        j = 0;
        break;
        label92: i = 0;
      }
    }

    public Builder setLocalOnly(boolean paramBoolean)
    {
      this.mLocalOnly = paramBoolean;
      return this;
    }

    public Builder setNumber(int paramInt)
    {
      this.mNumber = paramInt;
      return this;
    }

    public Builder setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }

    public Builder setOnlyAlertOnce(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }

    public Builder setPriority(int paramInt)
    {
      this.mPriority = paramInt;
      return this;
    }

    public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mProgressMax = paramInt1;
      this.mProgress = paramInt2;
      this.mProgressIndeterminate = paramBoolean;
      return this;
    }

    public Builder setPublicVersion(Notification paramNotification)
    {
      this.mPublicVersion = paramNotification;
      return this;
    }

    public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
    {
      this.mRemoteInputHistory = paramArrayOfCharSequence;
      return this;
    }

    public Builder setShortcutId(String paramString)
    {
      this.mShortcutId = paramString;
      return this;
    }

    public Builder setShowWhen(boolean paramBoolean)
    {
      this.mShowWhen = paramBoolean;
      return this;
    }

    public Builder setSmallIcon(int paramInt)
    {
      this.mNotification.icon = paramInt;
      return this;
    }

    public Builder setSmallIcon(int paramInt1, int paramInt2)
    {
      this.mNotification.icon = paramInt1;
      this.mNotification.iconLevel = paramInt2;
      return this;
    }

    public Builder setSortKey(String paramString)
    {
      this.mSortKey = paramString;
      return this;
    }

    public Builder setSound(Uri paramUri)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21)
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      return this;
    }

    public Builder setSound(Uri paramUri, int paramInt)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = paramInt;
      if (Build.VERSION.SDK_INT >= 21)
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(paramInt).build();
      return this;
    }

    public Builder setStyle(NotificationCompat.Style paramStyle)
    {
      if (this.mStyle != paramStyle)
      {
        this.mStyle = paramStyle;
        if (this.mStyle != null)
          this.mStyle.setBuilder(this);
      }
      return this;
    }

    public Builder setSubText(CharSequence paramCharSequence)
    {
      this.mSubText = limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public Builder setTicker(CharSequence paramCharSequence)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      this.mTickerView = paramRemoteViews;
      return this;
    }

    public Builder setTimeoutAfter(long paramLong)
    {
      this.mTimeout = paramLong;
      return this;
    }

    public Builder setUsesChronometer(boolean paramBoolean)
    {
      this.mUseChronometer = paramBoolean;
      return this;
    }

    public Builder setVibrate(long[] paramArrayOfLong)
    {
      this.mNotification.vibrate = paramArrayOfLong;
      return this;
    }

    public Builder setVisibility(int paramInt)
    {
      this.mVisibility = paramInt;
      return this;
    }

    public Builder setWhen(long paramLong)
    {
      this.mNotification.when = paramLong;
      return this;
    }
  }

  public static final class CarExtender
    implements NotificationCompat.Extender
  {
    static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    private int mColor = 0;
    private Bitmap mLargeIcon;
    private UnreadConversation mUnreadConversation;

    public CarExtender()
    {
    }

    public CarExtender(Notification paramNotification)
    {
      if (Build.VERSION.SDK_INT < 21);
      while (true)
      {
        return;
        if (NotificationCompat.getExtras(paramNotification) == null);
        for (Bundle localBundle = null; localBundle != null; localBundle = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS"))
        {
          this.mLargeIcon = ((Bitmap)localBundle.getParcelable("large_icon"));
          this.mColor = localBundle.getInt("app_color", 0);
          this.mUnreadConversation = getUnreadConversationFromBundle(localBundle.getBundle("car_conversation"));
          return;
        }
      }
    }

    private static Bundle getBundleForUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      int i = 0;
      Bundle localBundle1 = new Bundle();
      String[] arrayOfString = paramUnreadConversation.getParticipants();
      String str = null;
      if (arrayOfString != null)
      {
        int j = paramUnreadConversation.getParticipants().length;
        str = null;
        if (j > 1)
          str = paramUnreadConversation.getParticipants()[0];
      }
      Parcelable[] arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
        localBundle2.putString("author", str);
        arrayOfParcelable[i] = localBundle2;
        i++;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      RemoteInput localRemoteInput = paramUnreadConversation.getRemoteInput();
      if (localRemoteInput != null)
        localBundle1.putParcelable("remote_input", new RemoteInput.Builder(localRemoteInput.getResultKey()).setLabel(localRemoteInput.getLabel()).setChoices(localRemoteInput.getChoices()).setAllowFreeFormInput(localRemoteInput.getAllowFreeFormInput()).addExtras(localRemoteInput.getExtras()).build());
      localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
      localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
      localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
      localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
      return localBundle1;
    }

    private static UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle)
    {
      if (paramBundle == null)
        return null;
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("messages");
      String[] arrayOfString3;
      int i;
      int j;
      if (arrayOfParcelable != null)
      {
        arrayOfString3 = new String[arrayOfParcelable.length];
        i = 0;
        if (i < arrayOfString3.length)
        {
          boolean bool = arrayOfParcelable[i] instanceof Bundle;
          j = 0;
          if (!bool)
            label52: if (j == 0)
              break label226;
        }
      }
      for (String[] arrayOfString1 = arrayOfString3; ; arrayOfString1 = null)
      {
        PendingIntent localPendingIntent1 = (PendingIntent)paramBundle.getParcelable("on_read");
        PendingIntent localPendingIntent2 = (PendingIntent)paramBundle.getParcelable("on_reply");
        android.app.RemoteInput localRemoteInput = (android.app.RemoteInput)paramBundle.getParcelable("remote_input");
        String[] arrayOfString2 = paramBundle.getStringArray("participants");
        if ((arrayOfString2 == null) || (arrayOfString2.length != 1))
          break;
        if (localRemoteInput != null);
        for (RemoteInput localRemoteInput1 = new RemoteInput(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras(), null); ; localRemoteInput1 = null)
        {
          long l = paramBundle.getLong("timestamp");
          return new UnreadConversation(arrayOfString1, localRemoteInput1, localPendingIntent2, localPendingIntent1, arrayOfString2, l);
          arrayOfString3[i] = ((Bundle)arrayOfParcelable[i]).getString("text");
          String str = arrayOfString3[i];
          j = 0;
          if (str == null)
            break label52;
          i++;
          break;
        }
        j = 1;
        break label52;
        label226: break;
      }
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      if (Build.VERSION.SDK_INT < 21)
        return paramBuilder;
      Bundle localBundle = new Bundle();
      if (this.mLargeIcon != null)
        localBundle.putParcelable("large_icon", this.mLargeIcon);
      if (this.mColor != 0)
        localBundle.putInt("app_color", this.mColor);
      if (this.mUnreadConversation != null)
        localBundle.putBundle("car_conversation", getBundleForUnreadConversation(this.mUnreadConversation));
      paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      return paramBuilder;
    }

    public int getColor()
    {
      return this.mColor;
    }

    public Bitmap getLargeIcon()
    {
      return this.mLargeIcon;
    }

    public UnreadConversation getUnreadConversation()
    {
      return this.mUnreadConversation;
    }

    public CarExtender setColor(int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }

    public CarExtender setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = paramBitmap;
      return this;
    }

    public CarExtender setUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      this.mUnreadConversation = paramUnreadConversation;
      return this;
    }

    public static class UnreadConversation
    {
      private final long mLatestTimestamp;
      private final String[] mMessages;
      private final String[] mParticipants;
      private final PendingIntent mReadPendingIntent;
      private final RemoteInput mRemoteInput;
      private final PendingIntent mReplyPendingIntent;

      UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.mMessages = paramArrayOfString1;
        this.mRemoteInput = paramRemoteInput;
        this.mReadPendingIntent = paramPendingIntent2;
        this.mReplyPendingIntent = paramPendingIntent1;
        this.mParticipants = paramArrayOfString2;
        this.mLatestTimestamp = paramLong;
      }

      public long getLatestTimestamp()
      {
        return this.mLatestTimestamp;
      }

      public String[] getMessages()
      {
        return this.mMessages;
      }

      public String getParticipant()
      {
        if (this.mParticipants.length > 0)
          return this.mParticipants[0];
        return null;
      }

      public String[] getParticipants()
      {
        return this.mParticipants;
      }

      public PendingIntent getReadPendingIntent()
      {
        return this.mReadPendingIntent;
      }

      public RemoteInput getRemoteInput()
      {
        return this.mRemoteInput;
      }

      public PendingIntent getReplyPendingIntent()
      {
        return this.mReplyPendingIntent;
      }

      public static class Builder
      {
        private long mLatestTimestamp;
        private final List<String> mMessages = new ArrayList();
        private final String mParticipant;
        private PendingIntent mReadPendingIntent;
        private RemoteInput mRemoteInput;
        private PendingIntent mReplyPendingIntent;

        public Builder(String paramString)
        {
          this.mParticipant = paramString;
        }

        public Builder addMessage(String paramString)
        {
          this.mMessages.add(paramString);
          return this;
        }

        public NotificationCompat.CarExtender.UnreadConversation build()
        {
          String[] arrayOfString1 = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = this.mParticipant;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString1, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, arrayOfString2, this.mLatestTimestamp);
        }

        public Builder setLatestTimestamp(long paramLong)
        {
          this.mLatestTimestamp = paramLong;
          return this;
        }

        public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
        {
          this.mReadPendingIntent = paramPendingIntent;
          return this;
        }

        public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
        {
          this.mRemoteInput = paramRemoteInput;
          this.mReplyPendingIntent = paramPendingIntent;
          return this;
        }
      }
    }
  }

  public static class DecoratedCustomViewStyle extends NotificationCompat.Style
  {
    private static final int MAX_ACTION_BUTTONS = 3;

    private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
    {
      RemoteViews localRemoteViews1 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
      localRemoteViews1.removeAllViews(R.id.actions);
      if ((paramBoolean) && (this.mBuilder.mActions != null))
      {
        int k = Math.min(this.mBuilder.mActions.size(), 3);
        if (k > 0)
          for (int m = 0; m < k; m++)
          {
            RemoteViews localRemoteViews2 = generateActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(m));
            localRemoteViews1.addView(R.id.actions, localRemoteViews2);
          }
      }
      for (int i = 1; ; i = 0)
      {
        if (i != 0);
        for (int j = 0; ; j = 8)
        {
          localRemoteViews1.setViewVisibility(R.id.actions, j);
          localRemoteViews1.setViewVisibility(R.id.action_divider, j);
          buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
          return localRemoteViews1;
        }
      }
    }

    private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
    {
      int i;
      String str;
      if (paramAction.actionIntent == null)
      {
        i = 1;
        str = this.mBuilder.mContext.getPackageName();
        if (i == 0)
          break label129;
      }
      label129: for (int j = R.layout.notification_action_tombstone; ; j = R.layout.notification_action)
      {
        RemoteViews localRemoteViews = new RemoteViews(str, j);
        localRemoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIcon(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
        localRemoteViews.setTextViewText(R.id.action_text, paramAction.title);
        if (i == 0)
          localRemoteViews.setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent);
        if (Build.VERSION.SDK_INT >= 15)
          localRemoteViews.setContentDescription(R.id.action_container, paramAction.title);
        return localRemoteViews;
        i = 0;
        break;
      }
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24)
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24);
      while (true)
      {
        return null;
        RemoteViews localRemoteViews = this.mBuilder.getBigContentView();
        if (localRemoteViews != null);
        while (localRemoteViews != null)
        {
          return createRemoteViews(localRemoteViews, true);
          localRemoteViews = this.mBuilder.getContentView();
        }
      }
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24);
      while (this.mBuilder.getContentView() == null)
        return null;
      return createRemoteViews(this.mBuilder.getContentView(), false);
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24);
      while (true)
      {
        return null;
        RemoteViews localRemoteViews1 = this.mBuilder.getHeadsUpContentView();
        if (localRemoteViews1 != null);
        for (RemoteViews localRemoteViews2 = localRemoteViews1; localRemoteViews1 != null; localRemoteViews2 = this.mBuilder.getContentView())
          return createRemoteViews(localRemoteViews2, true);
      }
    }
  }

  public static abstract interface Extender
  {
    public abstract NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface GroupAlertBehavior
  {
  }

  public static class InboxStyle extends NotificationCompat.Style
  {
    private ArrayList<CharSequence> mTexts = new ArrayList();

    public InboxStyle()
    {
    }

    public InboxStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }

    public InboxStyle addLine(CharSequence paramCharSequence)
    {
      this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
      return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Notification.InboxStyle localInboxStyle = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
        if (this.mSummaryTextSet)
          localInboxStyle.setSummaryText(this.mSummaryText);
        Iterator localIterator = this.mTexts.iterator();
        while (localIterator.hasNext())
          localInboxStyle.addLine((CharSequence)localIterator.next());
      }
    }

    public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }

    public InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }

  public static class MessagingStyle extends NotificationCompat.Style
  {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    private CharSequence mConversationTitle;
    private Boolean mIsGroupConversation;
    private final List<Message> mMessages = new ArrayList();
    private Person mUser;

    private MessagingStyle()
    {
    }

    public MessagingStyle(Person paramPerson)
    {
      if (TextUtils.isEmpty(paramPerson.getName()))
        throw new IllegalArgumentException("User's name must not be empty.");
      this.mUser = paramPerson;
    }

    @Deprecated
    public MessagingStyle(CharSequence paramCharSequence)
    {
      this.mUser = new Person.Builder().setName(paramCharSequence).build();
    }

    public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
    {
      Bundle localBundle = NotificationCompat.getExtras(paramNotification);
      if ((localBundle != null) && (!localBundle.containsKey("android.selfDisplayName")) && (!localBundle.containsKey("android.messagingStyleUser")))
        return null;
      try
      {
        MessagingStyle localMessagingStyle = new MessagingStyle();
        localMessagingStyle.restoreFromCompatExtras(localBundle);
        return localMessagingStyle;
      }
      catch (ClassCastException localClassCastException)
      {
      }
      return null;
    }

    private Message findLatestIncomingMessage()
    {
      for (int i = -1 + this.mMessages.size(); i >= 0; i--)
      {
        Message localMessage = (Message)this.mMessages.get(i);
        if ((localMessage.getPerson() != null) && (!TextUtils.isEmpty(localMessage.getPerson().getName())))
          return localMessage;
      }
      if (!this.mMessages.isEmpty())
        return (Message)this.mMessages.get(-1 + this.mMessages.size());
      return null;
    }

    private boolean hasMessagesWithoutSender()
    {
      for (int i = -1 + this.mMessages.size(); i >= 0; i--)
      {
        Message localMessage = (Message)this.mMessages.get(i);
        if ((localMessage.getPerson() != null) && (localMessage.getPerson().getName() == null))
          return true;
      }
      return false;
    }

    private TextAppearanceSpan makeFontColorSpan(int paramInt)
    {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
    }

    private CharSequence makeMessageLine(Message paramMessage)
    {
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i;
      int j;
      label32: Object localObject1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        i = 1;
        if (i == 0)
          break label162;
        j = -16777216;
        if (paramMessage.getPerson() != null)
          break label168;
        localObject1 = "";
        label43: if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.mUser.getName();
          if ((i != 0) && (this.mBuilder.getColor() != 0))
            j = this.mBuilder.getColor();
        }
        CharSequence localCharSequence = localBidiFormatter.unicodeWrap((CharSequence)localObject1);
        localSpannableStringBuilder.append(localCharSequence);
        localSpannableStringBuilder.setSpan(makeFontColorSpan(j), localSpannableStringBuilder.length() - localCharSequence.length(), localSpannableStringBuilder.length(), 33);
        if (paramMessage.getText() != null)
          break label180;
      }
      label162: label168: label180: for (Object localObject2 = ""; ; localObject2 = paramMessage.getText())
      {
        localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap((CharSequence)localObject2));
        return localSpannableStringBuilder;
        i = 0;
        break;
        j = -1;
        break label32;
        localObject1 = paramMessage.getPerson().getName();
        break label43;
      }
    }

    public void addCompatExtras(Bundle paramBundle)
    {
      super.addCompatExtras(paramBundle);
      paramBundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
      paramBundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
      paramBundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
      if ((this.mConversationTitle != null) && (this.mIsGroupConversation.booleanValue()))
        paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
      if (!this.mMessages.isEmpty())
        paramBundle.putParcelableArray("android.messages", Message.getBundleArrayForMessages(this.mMessages));
      if (this.mIsGroupConversation != null)
        paramBundle.putBoolean("android.isGroupConversation", this.mIsGroupConversation.booleanValue());
    }

    public MessagingStyle addMessage(Message paramMessage)
    {
      this.mMessages.add(paramMessage);
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0);
      return this;
    }

    public MessagingStyle addMessage(CharSequence paramCharSequence, long paramLong, Person paramPerson)
    {
      addMessage(new Message(paramCharSequence, paramLong, paramPerson));
      return this;
    }

    @Deprecated
    public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
    {
      this.mMessages.add(new Message(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build()));
      if (this.mMessages.size() > 25)
        this.mMessages.remove(0);
      return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      setGroupConversation(isGroupConversation());
      Notification.MessagingStyle localMessagingStyle;
      label101: Message localMessage3;
      Notification.MessagingStyle.Message localMessage;
      if (Build.VERSION.SDK_INT >= 24)
      {
        Person localPerson;
        CharSequence localCharSequence4;
        long l;
        if (Build.VERSION.SDK_INT >= 28)
        {
          localMessagingStyle = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
          if ((this.mIsGroupConversation.booleanValue()) || (Build.VERSION.SDK_INT >= 28))
            localMessagingStyle.setConversationTitle(this.mConversationTitle);
          if (Build.VERSION.SDK_INT >= 28)
            localMessagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue());
          Iterator localIterator = this.mMessages.iterator();
          if (!localIterator.hasNext())
            break label281;
          localMessage3 = (Message)localIterator.next();
          if (Build.VERSION.SDK_INT < 28)
            break label239;
          localPerson = localMessage3.getPerson();
          localCharSequence4 = localMessage3.getText();
          l = localMessage3.getTimestamp();
          if (localPerson != null)
            break label229;
        }
        label229: for (android.app.Person localPerson1 = null; ; localPerson1 = localPerson.toAndroidPerson())
        {
          localMessage = new Notification.MessagingStyle.Message(localCharSequence4, l, localPerson1);
          if (localMessage3.getDataMimeType() != null)
            localMessage.setData(localMessage3.getDataMimeType(), localMessage3.getDataUri());
          localMessagingStyle.addMessage(localMessage);
          break label101;
          localMessagingStyle = new Notification.MessagingStyle(this.mUser.getName());
          break;
        }
        label239: if (localMessage3.getPerson() == null)
          break label577;
      }
      label281: label410: label543: label553: label577: for (CharSequence localCharSequence3 = localMessage3.getPerson().getName(); ; localCharSequence3 = null)
      {
        localMessage = new Notification.MessagingStyle.Message(localMessage3.getText(), localMessage3.getTimestamp(), localCharSequence3);
        break;
        localMessagingStyle.setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
        Message localMessage1;
        CharSequence localCharSequence2;
        label355: 
        do
        {
          return;
          localMessage1 = findLatestIncomingMessage();
          if ((this.mConversationTitle == null) || (!this.mIsGroupConversation.booleanValue()))
            break;
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
          if (localMessage1 != null)
          {
            Notification.Builder localBuilder = paramNotificationBuilderWithBuilderAccessor.getBuilder();
            if (this.mConversationTitle == null)
              break label528;
            localCharSequence2 = makeMessageLine(localMessage1);
            localBuilder.setContentText(localCharSequence2);
          }
        }
        while (Build.VERSION.SDK_INT < 16);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        int i;
        int j;
        Message localMessage2;
        if ((this.mConversationTitle != null) || (hasMessagesWithoutSender()))
        {
          i = 1;
          j = -1 + this.mMessages.size();
          if (j < 0)
            break label553;
          localMessage2 = (Message)this.mMessages.get(j);
          if (i == 0)
            break label543;
        }
        for (CharSequence localCharSequence1 = makeMessageLine(localMessage2); ; localCharSequence1 = localMessage2.getText())
        {
          if (j != -1 + this.mMessages.size())
            localSpannableStringBuilder.insert(0, "\n");
          localSpannableStringBuilder.insert(0, localCharSequence1);
          j--;
          break label410;
          if (localMessage1 == null)
            break;
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
          if (localMessage1.getPerson() == null)
            break;
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(localMessage1.getPerson().getName());
          break;
          localCharSequence2 = localMessage1.getText();
          break label355;
          i = 0;
          break label397;
        }
        new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(localSpannableStringBuilder);
        return;
      }
    }

    public CharSequence getConversationTitle()
    {
      return this.mConversationTitle;
    }

    public List<Message> getMessages()
    {
      return this.mMessages;
    }

    public Person getUser()
    {
      return this.mUser;
    }

    @Deprecated
    public CharSequence getUserDisplayName()
    {
      return this.mUser.getName();
    }

    public boolean isGroupConversation()
    {
      boolean bool;
      if ((this.mBuilder != null) && (this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28) && (this.mIsGroupConversation == null))
      {
        CharSequence localCharSequence = this.mConversationTitle;
        bool = false;
        if (localCharSequence != null)
          bool = true;
      }
      Boolean localBoolean;
      do
      {
        return bool;
        localBoolean = this.mIsGroupConversation;
        bool = false;
      }
      while (localBoolean == null);
      return this.mIsGroupConversation.booleanValue();
    }

    protected void restoreFromCompatExtras(Bundle paramBundle)
    {
      this.mMessages.clear();
      if (paramBundle.containsKey("android.messagingStyleUser"));
      for (this.mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser")); ; this.mUser = new Person.Builder().setName(paramBundle.getString("android.selfDisplayName")).build())
      {
        this.mConversationTitle = paramBundle.getCharSequence("android.conversationTitle");
        if (this.mConversationTitle == null)
          this.mConversationTitle = paramBundle.getCharSequence("android.hiddenConversationTitle");
        Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("android.messages");
        if (arrayOfParcelable != null)
          this.mMessages.addAll(Message.getMessagesFromBundleArray(arrayOfParcelable));
        if (paramBundle.containsKey("android.isGroupConversation"))
          this.mIsGroupConversation = Boolean.valueOf(paramBundle.getBoolean("android.isGroupConversation"));
        return;
      }
    }

    public MessagingStyle setConversationTitle(CharSequence paramCharSequence)
    {
      this.mConversationTitle = paramCharSequence;
      return this;
    }

    public MessagingStyle setGroupConversation(boolean paramBoolean)
    {
      this.mIsGroupConversation = Boolean.valueOf(paramBoolean);
      return this;
    }

    public static final class Message
    {
      static final String KEY_DATA_MIME_TYPE = "type";
      static final String KEY_DATA_URI = "uri";
      static final String KEY_EXTRAS_BUNDLE = "extras";
      static final String KEY_NOTIFICATION_PERSON = "sender_person";
      static final String KEY_PERSON = "person";
      static final String KEY_SENDER = "sender";
      static final String KEY_TEXT = "text";
      static final String KEY_TIMESTAMP = "time";
      private String mDataMimeType;
      private Uri mDataUri;
      private Bundle mExtras = new Bundle();
      private final Person mPerson;
      private final CharSequence mText;
      private final long mTimestamp;

      public Message(CharSequence paramCharSequence, long paramLong, Person paramPerson)
      {
        this.mText = paramCharSequence;
        this.mTimestamp = paramLong;
        this.mPerson = paramPerson;
      }

      @Deprecated
      public Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
      {
        this(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build());
      }

      static Bundle[] getBundleArrayForMessages(List<Message> paramList)
      {
        Bundle[] arrayOfBundle = new Bundle[paramList.size()];
        int i = paramList.size();
        for (int j = 0; j < i; j++)
          arrayOfBundle[j] = ((Message)paramList.get(j)).toBundle();
        return arrayOfBundle;
      }

      static Message getMessageFromBundle(Bundle paramBundle)
      {
        Message localMessage;
        while (true)
        {
          try
          {
            if ((!paramBundle.containsKey("text")) || (!paramBundle.containsKey("time")))
              break;
            if (paramBundle.containsKey("person"))
            {
              localObject = Person.fromBundle(paramBundle.getBundle("person"));
              localMessage = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), (Person)localObject);
              if ((paramBundle.containsKey("type")) && (paramBundle.containsKey("uri")))
                localMessage.setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
              if (!paramBundle.containsKey("extras"))
                break label203;
              localMessage.getExtras().putAll(paramBundle.getBundle("extras"));
              break label203;
            }
            if ((paramBundle.containsKey("sender_person")) && (Build.VERSION.SDK_INT >= 28))
            {
              localObject = Person.fromAndroidPerson((android.app.Person)paramBundle.getParcelable("sender_person"));
              continue;
            }
            if (paramBundle.containsKey("sender"))
            {
              Person localPerson = new Person.Builder().setName(paramBundle.getCharSequence("sender")).build();
              localObject = localPerson;
              continue;
            }
          }
          catch (ClassCastException localClassCastException)
          {
            return null;
          }
          Object localObject = null;
        }
        return null;
        label203: return localMessage;
      }

      static List<Message> getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
      {
        ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
        for (int i = 0; i < paramArrayOfParcelable.length; i++)
          if ((paramArrayOfParcelable[i] instanceof Bundle))
          {
            Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
            if (localMessage != null)
              localArrayList.add(localMessage);
          }
        return localArrayList;
      }

      private Bundle toBundle()
      {
        Bundle localBundle = new Bundle();
        if (this.mText != null)
          localBundle.putCharSequence("text", this.mText);
        localBundle.putLong("time", this.mTimestamp);
        if (this.mPerson != null)
        {
          localBundle.putCharSequence("sender", this.mPerson.getName());
          if (Build.VERSION.SDK_INT < 28)
            break label129;
          localBundle.putParcelable("sender_person", this.mPerson.toAndroidPerson());
        }
        while (true)
        {
          if (this.mDataMimeType != null)
            localBundle.putString("type", this.mDataMimeType);
          if (this.mDataUri != null)
            localBundle.putParcelable("uri", this.mDataUri);
          if (this.mExtras != null)
            localBundle.putBundle("extras", this.mExtras);
          return localBundle;
          label129: localBundle.putBundle("person", this.mPerson.toBundle());
        }
      }

      public String getDataMimeType()
      {
        return this.mDataMimeType;
      }

      public Uri getDataUri()
      {
        return this.mDataUri;
      }

      public Bundle getExtras()
      {
        return this.mExtras;
      }

      public Person getPerson()
      {
        return this.mPerson;
      }

      @Deprecated
      public CharSequence getSender()
      {
        if (this.mPerson == null)
          return null;
        return this.mPerson.getName();
      }

      public CharSequence getText()
      {
        return this.mText;
      }

      public long getTimestamp()
      {
        return this.mTimestamp;
      }

      public Message setData(String paramString, Uri paramUri)
      {
        this.mDataMimeType = paramString;
        this.mDataUri = paramUri;
        return this;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotificationVisibility
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface StreamType
  {
  }

  public static abstract class Style
  {
    CharSequence mBigContentTitle;
    protected NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;

    private int calculateTopPadding()
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      int i = localResources.getDimensionPixelSize(R.dimen.notification_top_pad);
      int j = localResources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
      float f = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.3F;
      return Math.round((1.0F - f) * i + f * j);
    }

    private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if (paramFloat1 < paramFloat2)
        return paramFloat2;
      if (paramFloat1 > paramFloat3)
        return paramFloat3;
      return paramFloat1;
    }

    private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
    {
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1);
      if (paramInt3 == 0);
      for (int i = localDrawable.getIntrinsicWidth(); ; i = paramInt3)
      {
        if (paramInt3 == 0)
          paramInt3 = localDrawable.getIntrinsicHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, paramInt3, Bitmap.Config.ARGB_8888);
        localDrawable.setBounds(0, 0, i, paramInt3);
        if (paramInt2 != 0)
          localDrawable.mutate().setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN));
        localDrawable.draw(new Canvas(localBitmap));
        return localBitmap;
      }
    }

    private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = R.drawable.notification_icon_background;
      if (paramInt4 == 0)
        paramInt4 = 0;
      Bitmap localBitmap = createColoredBitmap(i, paramInt4, paramInt2);
      Canvas localCanvas = new Canvas(localBitmap);
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
      localDrawable.setFilterBitmap(true);
      int j = (paramInt2 - paramInt3) / 2;
      localDrawable.setBounds(j, j, paramInt3 + j, paramInt3 + j);
      localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localDrawable.draw(localCanvas);
      return localBitmap;
    }

    private void hideNormalContent(RemoteViews paramRemoteViews)
    {
      paramRemoteViews.setViewVisibility(R.id.title, 8);
      paramRemoteViews.setViewVisibility(R.id.text2, 8);
      paramRemoteViews.setViewVisibility(R.id.text, 8);
    }

    public void addCompatExtras(Bundle paramBundle)
    {
    }

    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
    }

    public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
      int i;
      if (this.mBuilder.getPriority() < -1)
      {
        i = 1;
        if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21))
        {
          if (i == 0)
            break label599;
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
        }
        label93: if (this.mBuilder.mLargeIcon == null)
          break label667;
        if (Build.VERSION.SDK_INT < 16)
          break label628;
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        localRemoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
        label135: if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
        {
          int i9 = localResources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
          int i10 = i9 - 2 * localResources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
          if (Build.VERSION.SDK_INT < 21)
            break label641;
          Bitmap localBitmap2 = createIconWithBackground(this.mBuilder.mNotification.icon, i9, i10, this.mBuilder.getColor());
          localRemoteViews.setImageViewBitmap(R.id.right_icon, localBitmap2);
          label222: localRemoteViews.setViewVisibility(R.id.right_icon, 0);
        }
        label231: if (this.mBuilder.mContentTitle != null)
          localRemoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
        if (this.mBuilder.mContentText == null)
          break label978;
        localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
      }
      label305: label964: label971: label978: for (int j = 1; ; j = 0)
      {
        int k;
        int m;
        int n;
        label345: int i1;
        int i3;
        int i4;
        if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null))
        {
          k = 1;
          if (this.mBuilder.mContentInfo == null)
            break label802;
          localRemoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
          localRemoteViews.setViewVisibility(R.id.info, 0);
          m = 1;
          n = 1;
          if ((this.mBuilder.mSubText == null) || (Build.VERSION.SDK_INT < 16))
            break label928;
          localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
          if (this.mBuilder.mContentText == null)
            break label918;
          localRemoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
          localRemoteViews.setViewVisibility(R.id.text2, 0);
          i1 = 1;
          if ((i1 != 0) && (Build.VERSION.SDK_INT >= 16))
          {
            if (paramBoolean2)
            {
              float f = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
              localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
            }
            localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
          }
          if (this.mBuilder.getWhenIfShowing() != 0L)
          {
            if ((!this.mBuilder.mUseChronometer) || (Build.VERSION.SDK_INT < 16))
              break label934;
            localRemoteViews.setViewVisibility(R.id.chronometer, 0);
            localRemoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
            m = 1;
          }
          int i2 = R.id.right_side;
          if (m == 0)
            break label964;
          i3 = 0;
          localRemoteViews.setViewVisibility(i2, i3);
          i4 = R.id.line3;
          if (n == 0)
            break label971;
        }
        for (int i5 = 0; ; i5 = 8)
        {
          localRemoteViews.setViewVisibility(i4, i5);
          return localRemoteViews;
          i = 0;
          break;
          label599: localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
          break label93;
          label628: localRemoteViews.setViewVisibility(R.id.icon, 8);
          break label135;
          localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          break label222;
          if ((!paramBoolean1) || (this.mBuilder.mNotification.icon == 0))
            break label231;
          localRemoteViews.setViewVisibility(R.id.icon, 0);
          if (Build.VERSION.SDK_INT >= 21)
          {
            int i7 = localResources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - localResources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
            int i8 = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
            Bitmap localBitmap1 = createIconWithBackground(this.mBuilder.mNotification.icon, i7, i8, this.mBuilder.getColor());
            localRemoteViews.setImageViewBitmap(R.id.icon, localBitmap1);
            break label231;
          }
          localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          break label231;
          k = 0;
          break label305;
          if (this.mBuilder.mNumber > 0)
          {
            int i6 = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
            if (this.mBuilder.mNumber > i6)
              localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
            while (true)
            {
              localRemoteViews.setViewVisibility(R.id.info, 0);
              m = 1;
              n = 1;
              break;
              NumberFormat localNumberFormat = NumberFormat.getIntegerInstance();
              localRemoteViews.setTextViewText(R.id.info, localNumberFormat.format(this.mBuilder.mNumber));
            }
          }
          localRemoteViews.setViewVisibility(R.id.info, 8);
          m = k;
          n = j;
          break label345;
          localRemoteViews.setViewVisibility(R.id.text2, 8);
          i1 = 0;
          break label415;
          localRemoteViews.setViewVisibility(R.id.time, 0);
          localRemoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
          break label543;
          i3 = 8;
          break label559;
        }
      }
    }

    public Notification build()
    {
      NotificationCompat.Builder localBuilder = this.mBuilder;
      Notification localNotification = null;
      if (localBuilder != null)
        localNotification = this.mBuilder.build();
      return localNotification;
    }

    public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
    {
      hideNormalContent(paramRemoteViews1);
      paramRemoteViews1.removeAllViews(R.id.notification_main_column);
      paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
      paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21)
        paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
    }

    public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
    {
      return createColoredBitmap(paramInt1, paramInt2, 0);
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }

    protected void restoreFromCompatExtras(Bundle paramBundle)
    {
    }

    public void setBuilder(NotificationCompat.Builder paramBuilder)
    {
      if (this.mBuilder != paramBuilder)
      {
        this.mBuilder = paramBuilder;
        if (this.mBuilder != null)
          this.mBuilder.setStyle(this);
      }
    }
  }

  public static final class WearableExtender
    implements NotificationCompat.Extender
  {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = -1;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex = -1;
    private int mContentIcon;
    private int mContentIconGravity = 8388613;
    private int mCustomContentHeight;
    private int mCustomSizePreset = 0;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags = 1;
    private int mGravity = 80;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages = new ArrayList();

    public WearableExtender()
    {
    }

    public WearableExtender(Notification paramNotification)
    {
      Bundle localBundle1 = NotificationCompat.getExtras(paramNotification);
      Bundle localBundle2;
      ArrayList localArrayList;
      NotificationCompat.Action[] arrayOfAction;
      int i;
      if (localBundle1 != null)
      {
        localBundle2 = localBundle1.getBundle("android.wearable.EXTENSIONS");
        if (localBundle2 == null)
          return;
        localArrayList = localBundle2.getParcelableArrayList("actions");
        if ((Build.VERSION.SDK_INT < 16) || (localArrayList == null))
          break label194;
        arrayOfAction = new NotificationCompat.Action[localArrayList.size()];
        i = 0;
        label107: if (i >= arrayOfAction.length)
          break label181;
        if (Build.VERSION.SDK_INT < 20)
          break label152;
        arrayOfAction[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)localArrayList.get(i));
      }
      while (true)
      {
        i++;
        break label107;
        localBundle2 = null;
        break;
        label152: if (Build.VERSION.SDK_INT >= 16)
          arrayOfAction[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)localArrayList.get(i));
      }
      label181: Collections.addAll(this.mActions, (NotificationCompat.Action[])arrayOfAction);
      label194: this.mFlags = localBundle2.getInt("flags", 1);
      this.mDisplayIntent = ((PendingIntent)localBundle2.getParcelable("displayIntent"));
      Notification[] arrayOfNotification = NotificationCompat.getNotificationArrayFromBundle(localBundle2, "pages");
      if (arrayOfNotification != null)
        Collections.addAll(this.mPages, arrayOfNotification);
      this.mBackground = ((Bitmap)localBundle2.getParcelable("background"));
      this.mContentIcon = localBundle2.getInt("contentIcon");
      this.mContentIconGravity = localBundle2.getInt("contentIconGravity", 8388613);
      this.mContentActionIndex = localBundle2.getInt("contentActionIndex", -1);
      this.mCustomSizePreset = localBundle2.getInt("customSizePreset", 0);
      this.mCustomContentHeight = localBundle2.getInt("customContentHeight");
      this.mGravity = localBundle2.getInt("gravity", 80);
      this.mHintScreenTimeout = localBundle2.getInt("hintScreenTimeout");
      this.mDismissalId = localBundle2.getString("dismissalId");
      this.mBridgeTag = localBundle2.getString("bridgeTag");
    }

    private static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction)
    {
      Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      if (paramAction.getExtras() != null);
      for (Bundle localBundle = new Bundle(paramAction.getExtras()); ; localBundle = new Bundle())
      {
        localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24)
          localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
        localBuilder.addExtras(localBundle);
        RemoteInput[] arrayOfRemoteInput = paramAction.getRemoteInputs();
        if (arrayOfRemoteInput == null)
          break;
        android.app.RemoteInput[] arrayOfRemoteInput1 = RemoteInput.fromCompat(arrayOfRemoteInput);
        int i = arrayOfRemoteInput1.length;
        for (int j = 0; j < i; j++)
          localBuilder.addRemoteInput(arrayOfRemoteInput1[j]);
      }
      return localBuilder.build();
    }

    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mFlags = (paramInt | this.mFlags);
        return;
      }
      this.mFlags &= (paramInt ^ 0xFFFFFFFF);
    }

    public WearableExtender addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }

    public WearableExtender addActions(List<NotificationCompat.Action> paramList)
    {
      this.mActions.addAll(paramList);
      return this;
    }

    public WearableExtender addPage(Notification paramNotification)
    {
      this.mPages.add(paramNotification);
      return this;
    }

    public WearableExtender addPages(List<Notification> paramList)
    {
      this.mPages.addAll(paramList);
      return this;
    }

    public WearableExtender clearActions()
    {
      this.mActions.clear();
      return this;
    }

    public WearableExtender clearPages()
    {
      this.mPages.clear();
      return this;
    }

    public WearableExtender clone()
    {
      WearableExtender localWearableExtender = new WearableExtender();
      localWearableExtender.mActions = new ArrayList(this.mActions);
      localWearableExtender.mFlags = this.mFlags;
      localWearableExtender.mDisplayIntent = this.mDisplayIntent;
      localWearableExtender.mPages = new ArrayList(this.mPages);
      localWearableExtender.mBackground = this.mBackground;
      localWearableExtender.mContentIcon = this.mContentIcon;
      localWearableExtender.mContentIconGravity = this.mContentIconGravity;
      localWearableExtender.mContentActionIndex = this.mContentActionIndex;
      localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
      localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
      localWearableExtender.mGravity = this.mGravity;
      localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
      localWearableExtender.mDismissalId = this.mDismissalId;
      localWearableExtender.mBridgeTag = this.mBridgeTag;
      return localWearableExtender;
    }

    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      Bundle localBundle = new Bundle();
      if (!this.mActions.isEmpty())
      {
        if (Build.VERSION.SDK_INT < 16)
          break label379;
        ArrayList localArrayList = new ArrayList(this.mActions.size());
        Iterator localIterator = this.mActions.iterator();
        while (localIterator.hasNext())
        {
          NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
          if (Build.VERSION.SDK_INT >= 20)
            localArrayList.add(getActionFromActionCompat(localAction));
          else if (Build.VERSION.SDK_INT >= 16)
            localArrayList.add(NotificationCompatJellybean.getBundleForAction(localAction));
        }
        localBundle.putParcelableArrayList("actions", localArrayList);
      }
      while (true)
      {
        if (this.mFlags != 1)
          localBundle.putInt("flags", this.mFlags);
        if (this.mDisplayIntent != null)
          localBundle.putParcelable("displayIntent", this.mDisplayIntent);
        if (!this.mPages.isEmpty())
          localBundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
        if (this.mBackground != null)
          localBundle.putParcelable("background", this.mBackground);
        if (this.mContentIcon != 0)
          localBundle.putInt("contentIcon", this.mContentIcon);
        if (this.mContentIconGravity != 8388613)
          localBundle.putInt("contentIconGravity", this.mContentIconGravity);
        if (this.mContentActionIndex != -1)
          localBundle.putInt("contentActionIndex", this.mContentActionIndex);
        if (this.mCustomSizePreset != 0)
          localBundle.putInt("customSizePreset", this.mCustomSizePreset);
        if (this.mCustomContentHeight != 0)
          localBundle.putInt("customContentHeight", this.mCustomContentHeight);
        if (this.mGravity != 80)
          localBundle.putInt("gravity", this.mGravity);
        if (this.mHintScreenTimeout != 0)
          localBundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
        if (this.mDismissalId != null)
          localBundle.putString("dismissalId", this.mDismissalId);
        if (this.mBridgeTag != null)
          localBundle.putString("bridgeTag", this.mBridgeTag);
        paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramBuilder;
        label379: localBundle.putParcelableArrayList("actions", null);
      }
    }

    public List<NotificationCompat.Action> getActions()
    {
      return this.mActions;
    }

    public Bitmap getBackground()
    {
      return this.mBackground;
    }

    public String getBridgeTag()
    {
      return this.mBridgeTag;
    }

    public int getContentAction()
    {
      return this.mContentActionIndex;
    }

    @Deprecated
    public int getContentIcon()
    {
      return this.mContentIcon;
    }

    @Deprecated
    public int getContentIconGravity()
    {
      return this.mContentIconGravity;
    }

    public boolean getContentIntentAvailableOffline()
    {
      return (0x1 & this.mFlags) != 0;
    }

    @Deprecated
    public int getCustomContentHeight()
    {
      return this.mCustomContentHeight;
    }

    @Deprecated
    public int getCustomSizePreset()
    {
      return this.mCustomSizePreset;
    }

    public String getDismissalId()
    {
      return this.mDismissalId;
    }

    public PendingIntent getDisplayIntent()
    {
      return this.mDisplayIntent;
    }

    @Deprecated
    public int getGravity()
    {
      return this.mGravity;
    }

    public boolean getHintAmbientBigPicture()
    {
      return (0x20 & this.mFlags) != 0;
    }

    @Deprecated
    public boolean getHintAvoidBackgroundClipping()
    {
      return (0x10 & this.mFlags) != 0;
    }

    public boolean getHintContentIntentLaunchesActivity()
    {
      return (0x40 & this.mFlags) != 0;
    }

    @Deprecated
    public boolean getHintHideIcon()
    {
      return (0x2 & this.mFlags) != 0;
    }

    @Deprecated
    public int getHintScreenTimeout()
    {
      return this.mHintScreenTimeout;
    }

    @Deprecated
    public boolean getHintShowBackgroundOnly()
    {
      return (0x4 & this.mFlags) != 0;
    }

    public List<Notification> getPages()
    {
      return this.mPages;
    }

    public boolean getStartScrollBottom()
    {
      return (0x8 & this.mFlags) != 0;
    }

    public WearableExtender setBackground(Bitmap paramBitmap)
    {
      this.mBackground = paramBitmap;
      return this;
    }

    public WearableExtender setBridgeTag(String paramString)
    {
      this.mBridgeTag = paramString;
      return this;
    }

    public WearableExtender setContentAction(int paramInt)
    {
      this.mContentActionIndex = paramInt;
      return this;
    }

    @Deprecated
    public WearableExtender setContentIcon(int paramInt)
    {
      this.mContentIcon = paramInt;
      return this;
    }

    @Deprecated
    public WearableExtender setContentIconGravity(int paramInt)
    {
      this.mContentIconGravity = paramInt;
      return this;
    }

    public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
    {
      setFlag(1, paramBoolean);
      return this;
    }

    @Deprecated
    public WearableExtender setCustomContentHeight(int paramInt)
    {
      this.mCustomContentHeight = paramInt;
      return this;
    }

    @Deprecated
    public WearableExtender setCustomSizePreset(int paramInt)
    {
      this.mCustomSizePreset = paramInt;
      return this;
    }

    public WearableExtender setDismissalId(String paramString)
    {
      this.mDismissalId = paramString;
      return this;
    }

    public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
    {
      this.mDisplayIntent = paramPendingIntent;
      return this;
    }

    @Deprecated
    public WearableExtender setGravity(int paramInt)
    {
      this.mGravity = paramInt;
      return this;
    }

    public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
    {
      setFlag(32, paramBoolean);
      return this;
    }

    @Deprecated
    public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }

    public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
    {
      setFlag(64, paramBoolean);
      return this;
    }

    @Deprecated
    public WearableExtender setHintHideIcon(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }

    @Deprecated
    public WearableExtender setHintScreenTimeout(int paramInt)
    {
      this.mHintScreenTimeout = paramInt;
      return this;
    }

    @Deprecated
    public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
    {
      setFlag(4, paramBoolean);
      return this;
    }

    public WearableExtender setStartScrollBottom(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.6.2
 */