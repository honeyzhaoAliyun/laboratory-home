#include <jni.h>
#include "personal_JNI_HelloWorld.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_personal_JNI_HelloWorld_DisplayHello
(JNIEnv *env, jobject obj)
{
    printf("From jni_helloworldImpl.cpp :");
    printf("Hello world ! \n");
    return;
}