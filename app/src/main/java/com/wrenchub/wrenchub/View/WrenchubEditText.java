package com.wrenchub.wrenchub.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.wrenchub.wrenchub.R;


public class WrenchubEditText extends android.support.v7.widget.AppCompatEditText {
    public WrenchubEditText(Context context) {
        super(context);
        init(null);
    }

    public WrenchubEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public WrenchubEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs){
        if (attrs != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.WrenchubEditText);
            String fontName = typedArray.getString(R.styleable.WrenchubEditText_fontName);
            if (fontName != null){
                setTypeface(Typefaces.getTypeFace(getContext(),fontName));
            }
            typedArray.recycle();

        }
    }

}
