package android.support.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class a
{
  private Object a;

  private a(Object paramObject)
  {
    this.a = paramObject;
  }

  public static a a(Activity paramActivity, DragEvent paramDragEvent)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      DragAndDropPermissions localDragAndDropPermissions = paramActivity.requestDragAndDropPermissions(paramDragEvent);
      if (localDragAndDropPermissions != null)
        return new a(localDragAndDropPermissions);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.a.a.a
 * JD-Core Version:    0.6.2
 */