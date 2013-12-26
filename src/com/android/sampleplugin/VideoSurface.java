/*
 * Copyright 2009, The Android Open Source Project
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.android.sampleplugin;


import java.util.ArrayList;

import com.android.sampleplugin.component.Slider;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

public class VideoSurface extends FrameLayout {

	
	
    public VideoSurface(Context context) {
        super(context);

        LayoutParams fp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.setLayoutParams(fp);
        Slider slider = new Slider(context);
        slider.setData(new ArrayList<String>(){{
        	add("http://gmu.baidu.com/examples/assets/slider/image1.png");
        	add("http://gmu.baidu.com/examples/assets/slider/image2.png");
        	add("http://gmu.baidu.com/examples/assets/slider/image3.png");
        	add("http://gmu.baidu.com/examples/assets/slider/image4.png");
        }});
        this.addView(slider, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        // ensure that the view system is aware that we will be drawing
        this.setWillNotDraw(false);
    }
}
