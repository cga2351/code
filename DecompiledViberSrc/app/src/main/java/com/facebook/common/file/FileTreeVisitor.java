package com.facebook.common.file;

import java.io.File;

public abstract interface FileTreeVisitor
{
  public abstract void postVisitDirectory(File paramFile);

  public abstract void preVisitDirectory(File paramFile);

  public abstract void visitFile(File paramFile);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.file.FileTreeVisitor
 * JD-Core Version:    0.6.2
 */