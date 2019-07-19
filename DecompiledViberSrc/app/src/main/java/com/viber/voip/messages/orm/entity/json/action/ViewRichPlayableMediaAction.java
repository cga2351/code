package com.viber.voip.messages.orm.entity.json.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.common.dialogs.h.a;
import com.viber.jni.Engine;
import com.viber.liblinkparser.LinkParser;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.messages.ui.fm.o.a;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.a.c;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.w;
import com.viber.voip.util.an;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class ViewRichPlayableMediaAction extends ViewMediaAction
{
  public static final Parcelable.Creator<ViewRichPlayableMediaAction> CREATOR = new Parcelable.Creator()
  {
    public ViewRichPlayableMediaAction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ViewRichPlayableMediaAction(paramAnonymousParcel);
    }

    public ViewRichPlayableMediaAction[] newArray(int paramAnonymousInt)
    {
      return new ViewRichPlayableMediaAction[paramAnonymousInt];
    }
  };
  private static final com.viber.common.a.e L = ViberEnv.getLogger();
  private final String mActionReplyData;
  private final BotReplyRequest mBotReplyRequest;
  private final boolean mHasVisualContent;
  private final boolean mIsFavoriteLinksAvailable;
  private final boolean mLoop;
  private final String mSubtitle;
  private final String mThumbnailUri;
  private final String mTitle;

  ViewRichPlayableMediaAction(Parcel paramParcel)
  {
    super(paramParcel);
    this.mBotReplyRequest = ((BotReplyRequest)paramParcel.readParcelable(BotReplyRequest.class.getClassLoader()));
    this.mThumbnailUri = paramParcel.readString();
    int j;
    int k;
    if (paramParcel.readByte() != 0)
    {
      j = i;
      this.mHasVisualContent = j;
      this.mTitle = paramParcel.readString();
      this.mSubtitle = paramParcel.readString();
      if (paramParcel.readByte() != i)
        break label104;
      k = i;
      label72: this.mLoop = k;
      this.mActionReplyData = paramParcel.readString();
      if (paramParcel.readByte() <= 0)
        break label110;
    }
    while (true)
    {
      this.mIsFavoriteLinksAvailable = i;
      return;
      j = 0;
      break;
      label104: k = 0;
      break label72;
      label110: i = 0;
    }
  }

  public ViewRichPlayableMediaAction(BotReplyRequest paramBotReplyRequest, String paramString1, String paramString2, long paramLong, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, boolean paramBoolean3)
  {
    super(paramString1, paramLong);
    this.mBotReplyRequest = paramBotReplyRequest;
    this.mThumbnailUri = paramString2;
    this.mHasVisualContent = paramBoolean1;
    this.mTitle = paramString3;
    this.mSubtitle = paramString4;
    this.mLoop = paramBoolean2;
    this.mActionReplyData = paramString5;
    this.mIsFavoriteLinksAvailable = paramBoolean3;
  }

  private void openMediaPlayer(Context paramContext, Action.ExecuteListener paramExecuteListener, int paramInt)
  {
    int i = 1;
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if ((localEngine.getCurrentCall() != null) || (localEngine.isGSMCallActive()))
    {
      o.n().d();
      if (paramExecuteListener != null)
        paramExecuteListener.onFinish(Action.ExecuteStatus.FAIL);
    }
    label190: label196: label210: 
    while (true)
    {
      return;
      MediaPlayer.VisualSpec localVisualSpec = com.viber.voip.messages.ui.media.player.c.e.a(this.mMediaUrl, this.mThumbnailUri).a(paramInt, this.mHasVisualContent, this.mLoop, this.mActionReplyData);
      c localc = c.a(this.mTitle, this.mSubtitle);
      label111: MediaPlayerControls.VisualSpec localVisualSpec1;
      if (this.mIsFavoriteLinksAvailable)
      {
        int j = i;
        if (da.a(this.mActionReplyData))
          break label190;
        localVisualSpec1 = localc.a(j, i);
        if (!dj.e(paramContext))
          break label196;
        an.a(paramContext);
        ViberApplication.getInstance().getPlayerWindowManager().a(this.mBotReplyRequest);
        ViberApplication.getInstance().getPlayerWindowManager().a(localVisualSpec, localVisualSpec1, new o.a(localVisualSpec, localVisualSpec1));
      }
      while (true)
      {
        if (paramExecuteListener == null)
          break label210;
        paramExecuteListener.onFinish(Action.ExecuteStatus.OK);
        return;
        int k = 0;
        break;
        i = 0;
        break label111;
        ViberActionRunner.w.a(paramContext, this.mBotReplyRequest, localVisualSpec, localVisualSpec1, null);
      }
    }
  }

  public void execute(Context paramContext, Action.ExecuteListener paramExecuteListener)
  {
    if (da.a(this.mMediaUrl))
    {
      super.execute(paramContext, paramExecuteListener);
      return;
    }
    boolean bool = LinkParser.isEmbeddedMedia(this.mMediaUrl, 1);
    if ((bool) && (an.e()))
    {
      openMediaPlayer(paramContext, paramExecuteListener, 1);
      return;
    }
    if (bool)
    {
      ViberActionRunner.a(paramContext, this.mMediaUrl);
      return;
    }
    openMediaPlayer(paramContext, paramExecuteListener, 0);
  }

  public int getMediaType()
  {
    return 3;
  }

  public ActionType getType()
  {
    return ActionType.VIEW_VIDEO;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mBotReplyRequest, paramInt);
    paramParcel.writeString(this.mThumbnailUri);
    int j;
    int k;
    if (this.mHasVisualContent)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      paramParcel.writeString(this.mTitle);
      paramParcel.writeString(this.mSubtitle);
      if (!this.mLoop)
        break label103;
      k = i;
      label68: paramParcel.writeByte((byte)k);
      paramParcel.writeString(this.mActionReplyData);
      if (!this.mIsFavoriteLinksAvailable)
        break label109;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      return;
      j = 0;
      break;
      label103: k = 0;
      break label68;
      label109: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.action.ViewRichPlayableMediaAction
 * JD-Core Version:    0.6.2
 */