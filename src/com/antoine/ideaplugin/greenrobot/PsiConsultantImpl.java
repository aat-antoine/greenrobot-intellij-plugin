package com.antoine.ideaplugin.greenrobot;

import com.intellij.psi.*;

public class PsiConsultantImpl {

  static PsiMethodCallExpression findMethodCall(PsiElement element) {
    if (element == null) {
      return null;
    }
    else if (element instanceof PsiMethodCallExpression) {
      return (PsiMethodCallExpression) element;
    } else {
      return findMethodCall(element.getParent());
    }
  }

  static PsiAnnotation findAnnotationOnMethod(PsiMethod psiMethod, String annotationName) {
    PsiModifierList modifierList = psiMethod.getModifierList();
    for (PsiAnnotation psiAnnotation : modifierList.getAnnotations()) {
      if (annotationName.equals(psiAnnotation.getQualifiedName())) {
        return psiAnnotation;
      }
    }
    return null;
  }

  static PsiClass getClass(PsiType psiType) {
    if (psiType instanceof PsiClassType) {
      return ((PsiClassType) psiType).resolve();
    }
    return null;
  }

  static boolean hasAnnotation(PsiMethod psiMethod, String annotationName) {
    return findAnnotationOnMethod(psiMethod, annotationName) != null;
  }

  static PsiMethod findMethod(PsiElement element) {
    if (element == null) {
      return null;
    } else if (element instanceof PsiMethod) {
      return (PsiMethod) element;
    } else {
      return findMethod(element.getParent());
    }
  }
}
