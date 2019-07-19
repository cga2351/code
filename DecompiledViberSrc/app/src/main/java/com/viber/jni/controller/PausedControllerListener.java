package com.viber.jni.controller;

import java.util.LinkedList;
import java.util.Queue;

public class PausedControllerListener<T> extends ControllerListener<T>
{
  private boolean mPaused = false;
  private Queue<ControllerListener.ControllerListenerAction<T>> mQueue = new LinkedList();

  @SafeVarargs
  public PausedControllerListener(T[] paramArrayOfT)
  {
    registerDelegate(paramArrayOfT);
  }

  public void notifyListeners(ControllerListener.ControllerListenerAction<T> paramControllerListenerAction)
  {
    if (this.mPaused)
    {
      this.mQueue.add(paramControllerListenerAction);
      return;
    }
    super.notifyListeners(paramControllerListenerAction);
  }

  public void pause()
  {
    this.mPaused = true;
  }

  public void resume()
  {
    this.mPaused = false;
    while (!this.mQueue.isEmpty())
      super.notifyListeners((ControllerListener.ControllerListenerAction)this.mQueue.poll());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.controller.PausedControllerListener
 * JD-Core Version:    0.6.2
 */