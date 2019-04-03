package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubButton extends AppCompatButton {
    public WrenchubButton(Context context) {
        super(context);
        init(null);

    }

    public WrenchubButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WrenchubButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    private void init(AttributeSet attr){
        if(attr!=null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attr, R.styleable.WrenchubButton);
            String fontName=typedArray.getString(R.styleable.WrenchubButton_fontName);
            if(fontName!=null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedArray.recycle();
        }
    }
}
