package com.antoine.ideaplugin.greenrobot;

import com.intellij.codeInsight.daemon.ImplicitUsageProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;

import static com.antoine.ideaplugin.greenrobot.SubscriberMetadata.isAnnotatedWithProducer;
import static com.antoine.ideaplugin.greenrobot.SubscriberMetadata.isAnnotatedWithSubscriber;

/**
 * Indicates to intellij that any subscriber or producer methods are actually used implicitly
 * @author Steve Ash
 */
public class GreenrobotImplicitUsageProvider implements ImplicitUsageProvider {
  @Override
  public boolean isImplicitUsage(PsiElement psiElement) {
    if (!(psiElement instanceof PsiMethod))
      return false;

    PsiMethod method = (PsiMethod) psiElement;
    return isAnnotatedWithSubscriber(method) || isAnnotatedWithProducer(method);
  }

  @Override
  public boolean isImplicitRead(PsiElement psiElement) {
    return false;
  }

  @Override
  public boolean isImplicitWrite(PsiElement psiElement) {
    return false;
  }
}
