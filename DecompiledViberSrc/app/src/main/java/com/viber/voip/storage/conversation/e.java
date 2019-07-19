package com.viber.voip.storage.conversation;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.z;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.storage.b;
import com.viber.voip.storage.model.ConversationMediaSize;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class e extends com.viber.voip.mvp.core.d<ManageConversationStoragePresenter>
  implements d
{
  private final Activity a;
  private final Fragment b;
  private final c c;
  private final com.viber.voip.storage.a<ConversationWithMediaSizesEntity> d;
  private final b<ConversationWithMediaSizesEntity> e;
  private final com.viber.voip.widget.ProgressBar f;
  private final Button g;
  private final View h;
  private final CharSequence i;
  private final String j;
  private EnumMap<MediaFileType, MediaStorageCategoryLayout> k = new EnumMap(MediaFileType.class);
  private android.widget.ProgressBar l;
  private final DialogCode m = DialogCode.D464_PROGRESS;
  private int n = 0;

  e(Activity paramActivity, Fragment paramFragment, b<ConversationWithMediaSizesEntity> paramb, com.viber.voip.storage.a<ConversationWithMediaSizesEntity> parama, c paramc, ManageConversationStoragePresenter paramManageConversationStoragePresenter, View paramView)
  {
    super(paramManageConversationStoragePresenter, paramView);
    this.a = paramActivity;
    this.b = paramFragment;
    this.e = paramb;
    this.d = parama;
    this.c = paramc;
    this.i = paramActivity.getText(R.string.manage_storage_clear);
    this.j = paramActivity.getString(R.string.manage_storage_clear_with_size);
    ((ViewGroup)paramView.findViewById(R.id.manage_conversation_storage_container)).getLayoutTransition().enableTransitionType(4);
    this.f = ((com.viber.voip.widget.ProgressBar)paramView.findViewById(R.id.loading_progress));
    this.g = ((Button)paramView.findViewById(R.id.clear_media));
    this.h = paramView.findViewById(R.id.clear_media_subtitle);
    this.g.setOnClickListener(new f(this));
    a((MediaStorageCategoryLayout)paramView.findViewById(R.id.manage_storage_category_photos), MediaFileType.PICTURE);
    a((MediaStorageCategoryLayout)paramView.findViewById(R.id.manage_storage_category_videos), MediaFileType.VIDEO);
    a((MediaStorageCategoryLayout)paramView.findViewById(R.id.manage_storage_category_gifs), MediaFileType.GIF);
    a((MediaStorageCategoryLayout)paramView.findViewById(R.id.manage_storage_category_audio_ptt), MediaFileType.AUDIO_PTT);
    a((MediaStorageCategoryLayout)paramView.findViewById(R.id.manage_storage_category_video_ptt), MediaFileType.VIDEO_PTT);
  }

  private long a(long paramLong)
  {
    if (paramLong == -1L)
      paramLong = 0L;
    return paramLong;
  }

  private void a(MediaStorageCategoryLayout paramMediaStorageCategoryLayout, MediaFileType paramMediaFileType)
  {
    paramMediaStorageCategoryLayout.a(paramMediaFileType, new g(this));
    this.k.put(paramMediaFileType, paramMediaStorageCategoryLayout);
  }

  private void b(MediaFileType paramMediaFileType)
  {
    ((ManageConversationStoragePresenter)this.mPresenter).a(paramMediaFileType);
  }

  private void f()
  {
    if (this.l != null)
    {
      if (com.viber.common.d.a.k())
        this.l.setProgress(this.n, true);
    }
    else
      return;
    this.l.setProgress(this.n);
  }

  public void a()
  {
    dj.c(this.f, false);
    dj.c(this.g, true);
    dj.c(this.h, true);
  }

  public void a(int paramInt)
  {
    this.n = paramInt;
    f();
  }

  public void a(long paramLong, Set<MediaFileType> paramSet)
  {
    if (paramLong > 0L)
    {
      String str1 = this.j;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.i;
      arrayOfObject[1] = at.a(paramLong, false);
      String str2 = String.format(str1, arrayOfObject);
      this.g.setText(str2);
      this.g.setEnabled(true);
    }
    while (true)
    {
      Iterator localIterator = this.k.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((MediaStorageCategoryLayout)localEntry.getValue()).setChecked(paramSet.contains(localEntry.getKey()));
      }
      this.g.setText(this.i);
      this.g.setEnabled(false);
    }
  }

  public void a(ManageConversationStorageDeletionErrorData paramManageConversationStorageDeletionErrorData)
  {
    t.t().a(paramManageConversationStorageDeletionErrorData).a(this.b).b(this.b);
  }

  public void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity)
  {
    this.d.a(paramConversationWithMediaSizesEntity);
    this.a.setTitle(this.e.a(paramConversationWithMediaSizesEntity));
    ConversationMediaSize localConversationMediaSize = paramConversationWithMediaSizesEntity.getMediaSize();
    Iterator localIterator = this.k.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      long l1 = a(localConversationMediaSize.getMediaTypeSizeBytes((MediaFileType)localEntry.getKey()));
      MediaStorageCategoryLayout localMediaStorageCategoryLayout = (MediaStorageCategoryLayout)localEntry.getValue();
      localMediaStorageCategoryLayout.setMediaSize(l1);
      if (l1 > 0L);
      for (boolean bool = true; ; bool = false)
      {
        localMediaStorageCategoryLayout.setEnabled(bool);
        break;
      }
    }
  }

  public void a(Set<MediaFileType> paramSet)
  {
    Iterator localIterator = this.k.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((MediaStorageCategoryLayout)localEntry.getValue()).setEnabled(paramSet.contains(localEntry.getKey()));
    }
  }

  public void b()
  {
    this.c.a();
  }

  public void c()
  {
    t.r().a(this.b).b(this.b);
  }

  public void d()
  {
    FragmentManager localFragmentManager = this.b.getChildFragmentManager();
    localFragmentManager.executePendingTransactions();
    if (z.c(localFragmentManager, this.m) == null)
      t.s().a(this.b).b(this.b);
  }

  public void e()
  {
    z.b(this.b, this.m);
    this.n = 0;
    this.l = null;
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    boolean bool2;
    if (paramm.a(DialogCode.D464))
    {
      if (paramInt == -1)
        ((ManageConversationStoragePresenter)this.mPresenter).c();
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (paramm.a(this.m))
      {
        if ((paramInt == -1001) || (paramInt == -1000))
        {
          this.n = 0;
          this.l = null;
        }
        return true;
      }
      bool1 = paramm.a(DialogCode.D465);
      bool2 = false;
    }
    while (!bool1);
    if (paramInt == -1)
      ((ManageConversationStoragePresenter)this.mPresenter).a((ManageConversationStorageDeletionErrorData)paramm.d());
    return true;
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    if (paramm.a(this.m))
    {
      this.l = ((android.widget.ProgressBar)paramView.findViewById(R.id.media_storage_clearing_progress));
      f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.e
 * JD-Core Version:    0.6.2
 */