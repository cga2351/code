package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.b.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters
{
  private UUID a;
  private e b;
  private Set<String> c;
  private a d;
  private int e;
  private Executor f;
  private a g;
  private s h;

  public WorkerParameters(UUID paramUUID, e parame, Collection<String> paramCollection, a parama, int paramInt, Executor paramExecutor, a parama1, s params)
  {
    this.a = paramUUID;
    this.b = parame;
    this.c = new HashSet(paramCollection);
    this.d = parama;
    this.e = paramInt;
    this.f = paramExecutor;
    this.g = parama1;
    this.h = params;
  }

  public UUID a()
  {
    return this.a;
  }

  public e b()
  {
    return this.b;
  }

  public Executor c()
  {
    return this.f;
  }

  public s d()
  {
    return this.h;
  }

  public static class a
  {
    public List<String> a = Collections.emptyList();
    public List<Uri> b = Collections.emptyList();
    public Network c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.WorkerParameters
 * JD-Core Version:    0.6.2
 */