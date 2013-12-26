##
##
## Copyright 2008, The Android Open Source Project
##
## Redistribution and use in source and binary forms, with or without
## modification, are permitted provided that the following conditions
## are met:
##  * Redistributions of source code must retain the above copyright
##    notice, this list of conditions and the following disclaimer.
##  * Redistributions in binary form must reproduce the above copyright
##    notice, this list of conditions and the following disclaimer in the
##    documentation and/or other materials provided with the distribution.
##
## THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS ``AS IS'' AND ANY
## EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
## IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
## PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL APPLE COMPUTER, INC. OR
## CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
## EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
## PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
## PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
## OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
## (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
## OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
##

LOCAL_PATH:= $(call my-dir)

#APP_ABI := armeabi armeabi-v7a x86 mips

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	main.cpp \
	PluginObject.cpp \
	RenderingThread.cpp \
	animation/AnimationPlugin.cpp \
	animation/AnimationThread.cpp \
	audio/AudioPlugin.cpp \
	background/BackgroundPlugin.cpp \
	form/FormPlugin.cpp \
	navigation/NavigationPlugin.cpp \
	paint/PaintPlugin.cpp \
	video/VideoPlugin.cpp \
	jni-bridge.cpp \
	
PLATFORM_PATH := D:/adt-bundle-windows-x86_64-20130522/source/platform

WEBCORE_PATH := $(PLATFORM_PATH)/external/webkit/Source/WebCore

LOCAL_C_INCLUDES += \
	$(JNI_H_INCLUDE) \
	$(LOCAL_PATH) \
	$(LOCAL_PATH)/animation \
	$(LOCAL_PATH)/audio \
	$(LOCAL_PATH)/background \
	$(LOCAL_PATH)/form \
	$(LOCAL_PATH)/navigation \
	$(LOCAL_PATH)/paint \
	$(LOCAL_PATH)/video \
	$(WEBCORE_PATH)/bridge \
	$(WEBCORE_PATH)/plugins \
	$(WEBCORE_PATH)/platform/android/JavaVM \
	$(PLATFORM_PATH)/external/webkit/Source/WebKit/android/plugins \
	$(PLATFORM_PATH)/external/skia/include/core \
	$(PLATFORM_PATH)/system/core/include \
	$(PLATFORM_PATH)/libnativehelper/include/nativehelper

LIB_PATH := $(LOCAL_PATH)/lib/so/arm

#LIB_PATH := $(LOCAL_PATH)/lib/so/x86

#LOCAL_SHARED_LIBRARIES := \

LOCAL_LDLIBS := \
	$(LIB_PATH)/libnativehelper.so \
	$(LIB_PATH)/libandroid.so \
	$(LIB_PATH)/libutils.so \
	$(LIB_PATH)/libcutils.so \
	$(LIB_PATH)/libEGL.so \
	$(LIB_PATH)/libGLESv2.so \
	$(LIB_PATH)/libskia.so

LOCAL_CFLAGS += -fvisibility=hidden 

LOCAL_CFLAGS += -DHAVE_PTHREADS -DANDROID

#LOCAL_ALLOW_UNDEFINED_SYMBOLS := true

LOCAL_MODULE:= libsampleplugin

LOCAL_MODULE_TAGS := optional

include $(BUILD_SHARED_LIBRARY)

