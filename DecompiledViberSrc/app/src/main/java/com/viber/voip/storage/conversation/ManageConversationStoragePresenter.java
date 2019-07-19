package com.viber.voip.storage.conversation;

import android.arch.lifecycle.h;
import android.support.v4.util.ArraySet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.storage.a.a;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.a.i.a;
import com.viber.voip.storage.model.ConversationMediaSize;
import com.viber.voip.storage.model.ConversationMediaSize.a;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.MediaFileType;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.MediaStorageInteractor.a;
import com.viber.voip.storage.repository.p.a;
import com.viber.voip.util.n;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

class ManageConversationStoragePresenter extends BaseMvpPresenter<d, ManageConversationStorageState>
{
  private static final Logger a = ViberEnv.getLogger();
  private final long b;
  private final int c;
  private final MediaStorageInteractor d;
  private final i e;
  private final MediaStorageInteractor.a f = new MediaStorageInteractor.a()
  {
    private void b(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, paramAnonymousConversationWithMediaSizesEntity);
      ((d)ManageConversationStoragePresenter.b(ManageConversationStoragePresenter.this)).a(paramAnonymousConversationWithMediaSizesEntity);
    }

    public void a()
    {
      if (ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this) != null)
      {
        ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this).getMediaSize());
        if (!ManageConversationStoragePresenter.d(ManageConversationStoragePresenter.this))
          break label75;
      }
      label75: for (MediaFileType[] arrayOfMediaFileType = MediaFileType.getTypes(); ; arrayOfMediaFileType = (MediaFileType[])ManageConversationStoragePresenter.e(ManageConversationStoragePresenter.this).toArray(new MediaFileType[0]))
      {
        ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, false);
        ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, arrayOfMediaFileType);
        ((d)ManageConversationStoragePresenter.f(ManageConversationStoragePresenter.this)).a();
        return;
      }
    }

    public void a(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      b(paramAnonymousConversationWithMediaSizesEntity);
    }

    public void a(List<ConversationWithMediaSizesEntity> paramAnonymousList)
    {
      if (paramAnonymousList.isEmpty())
      {
        ((d)ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this)).b();
        return;
      }
      b((ConversationWithMediaSizesEntity)paramAnonymousList.get(0));
    }
  };
  private final i.a g = new i.a()
  {
    public void a(int paramAnonymousInt)
    {
      ((d)ManageConversationStoragePresenter.g(ManageConversationStoragePresenter.this)).a(paramAnonymousInt);
    }

    public void a(p.a paramAnonymousa)
    {
      if (ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this) != null)
      {
        MediaFileType[] arrayOfMediaFileType = (MediaFileType[])ManageConversationStoragePresenter.e(ManageConversationStoragePresenter.this).toArray(new MediaFileType[0]);
        ConversationMediaSize.a locala = new ConversationMediaSize.a(ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this).getMediaSize());
        locala.a(arrayOfMediaFileType);
        ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, new ConversationWithMediaSizesEntity(ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this), locala.a()));
        ((d)ManageConversationStoragePresenter.h(ManageConversationStoragePresenter.this)).a(ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this));
        ManageConversationStoragePresenter.a(ManageConversationStoragePresenter.this, ManageConversationStoragePresenter.c(ManageConversationStoragePresenter.this).getMediaSize());
        ManageConversationStoragePresenter.e(ManageConversationStoragePresenter.this).clear();
        ManageConversationStoragePresenter.i(ManageConversationStoragePresenter.this);
        if ((!paramAnonymousa.a()) && (!n.a(arrayOfMediaFileType)))
          ((d)ManageConversationStoragePresenter.j(ManageConversationStoragePresenter.this)).a(new ManageConversationStorageDeletionErrorData(arrayOfMediaFileType));
      }
      ManageConversationStoragePresenter.k(ManageConversationStoragePresenter.this).c();
      ((d)ManageConversationStoragePresenter.l(ManageConversationStoragePresenter.this)).e();
      ManageConversationStoragePresenter.b(ManageConversationStoragePresenter.this, false);
    }
  };
  private final EnumSet<MediaFileType> h = EnumSet.noneOf(MediaFileType.class);
  private ConversationWithMediaSizesEntity i;
  private boolean j = true;
  private boolean k;

  ManageConversationStoragePresenter(long paramLong, int paramInt, MediaStorageInteractor paramMediaStorageInteractor, i parami)
  {
    this.b = paramLong;
    this.c = paramInt;
    this.d = paramMediaStorageInteractor;
    this.e = parami;
  }

  private long a(MediaFileType[] paramArrayOfMediaFileType)
  {
    if (this.i == null)
      return 0L;
    this.h.clear();
    ConversationMediaSize localConversationMediaSize = this.i.getMediaSize();
    int m = paramArrayOfMediaFileType.length;
    int n = 0;
    if (n < m)
    {
      MediaFileType localMediaFileType = paramArrayOfMediaFileType[n];
      if (a(localConversationMediaSize.getMediaTypeSizeBytes(localMediaFileType)))
        this.h.add(localMediaFileType);
      while (true)
      {
        n++;
        break;
        this.h.remove(localMediaFileType);
      }
    }
    return e();
  }

  private void a(ConversationMediaSize paramConversationMediaSize)
  {
    ArraySet localArraySet = new ArraySet(MediaFileType.getTypesCount());
    for (MediaFileType localMediaFileType : MediaFileType.getTypes())
      if (a(paramConversationMediaSize.getMediaTypeSizeBytes(localMediaFileType)))
        localArraySet.add(localMediaFileType);
    ((d)this.mView).a(localArraySet);
  }

  private boolean a(long paramLong)
  {
    return paramLong > 0L;
  }

  private boolean d()
  {
    return (this.i != null) && (!this.h.isEmpty());
  }

  private long e()
  {
    long l = f();
    ((d)this.mView).a(l, Collections.unmodifiableSet(this.h));
    return l;
  }

  private long f()
  {
    if (this.i != null)
    {
      ConversationMediaSize localConversationMediaSize = this.i.getMediaSize();
      Iterator localIterator = this.h.iterator();
      for (l = 0L; localIterator.hasNext(); l += Math.max(localConversationMediaSize.getMediaTypeSizeBytes((MediaFileType)localIterator.next()), 0L));
    }
    long l = 0L;
    return l;
  }

  protected ManageConversationStorageState a()
  {
    return new ManageConversationStorageState(this.d.a(), this.i, (MediaFileType[])this.h.toArray(new MediaFileType[0]), this.k);
  }

  public void a(ManageConversationStorageDeletionErrorData paramManageConversationStorageDeletionErrorData)
  {
    if (paramManageConversationStorageDeletionErrorData == null);
    while (a(paramManageConversationStorageDeletionErrorData.getSelectedTypes()) <= 0L)
      return;
    c();
  }

  protected void a(ManageConversationStorageState paramManageConversationStorageState)
  {
    super.onViewAttached(paramManageConversationStorageState);
    if (paramManageConversationStorageState != null)
    {
      this.d.a(paramManageConversationStorageState.getInteractorSaveState());
      this.k = paramManageConversationStorageState.isClearMediaRunning();
      this.i = paramManageConversationStorageState.getConversation();
      if (this.i != null)
      {
        this.j = false;
        ((d)this.mView).a(this.i);
        a(this.i.getMediaSize());
        a(paramManageConversationStorageState.getSelectedTypes());
      }
    }
  }

  public void a(MediaFileType paramMediaFileType)
  {
    int m = 1;
    if (this.h.contains(paramMediaFileType))
      this.h.remove(paramMediaFileType);
    while (true)
    {
      if (m != 0)
        e();
      return;
      if ((this.i != null) && (a(this.i.getMediaSize().getMediaTypeSizeBytes(paramMediaFileType))))
        this.h.add(paramMediaFileType);
      else
        m = 0;
    }
  }

  public void b()
  {
    if (d())
      ((d)this.mView).c();
  }

  public void c()
  {
    long l = f();
    if ((d()) && (l > 0L))
    {
      this.k = true;
      ((d)this.mView).d();
      a locala = new a(this.i, this.c, l, (MediaFileType[])this.h.toArray(new MediaFileType[0]));
      this.e.a(locala, this.g);
    }
  }

  public void onCreate(h paramh)
  {
    super.onCreate(paramh);
    this.d.b();
  }

  public void onDestroy(h paramh)
  {
    this.d.e();
    super.onDestroy(paramh);
  }

  public void onPause(h paramh)
  {
    super.onPause(paramh);
    this.d.d();
  }

  public void onResume(h paramh)
  {
    super.onResume(paramh);
    this.d.a(this.f);
    if (this.e.a(this.b, this.g))
    {
      if (!this.k)
        ((d)this.mView).d();
      return;
    }
    ((d)this.mView).e();
    this.k = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.conversation.ManageConversationStoragePresenter
 * JD-Core Version:    0.6.2
 */