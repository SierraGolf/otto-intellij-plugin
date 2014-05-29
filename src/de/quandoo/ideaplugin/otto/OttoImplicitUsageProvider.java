package de.quandoo.ideaplugin.otto;

import com.intellij.codeInsight.daemon.ImplicitUsageProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;

/**
 * Indicates to intellij that any subscriber or producer methods are actually used implicitly
 * @author Steve Ash
 */
public class OttoImplicitUsageProvider implements ImplicitUsageProvider {
  @Override
  public boolean isImplicitUsage(PsiElement psiElement) {
    if (!(psiElement instanceof PsiMethod))
      return false;

    PsiMethod method = (PsiMethod) psiElement;
    return SubscriberMetadata.isAnnotatedWithSubscriber(method) || SubscriberMetadata.isAnnotatedWithProducer(method);
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
